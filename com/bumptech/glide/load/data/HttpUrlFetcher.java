package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* loaded from: classes5.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    @VisibleForTesting
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    public static final int INVALID_STATUS_CODE = -1;
    public static final int MAXIMUM_REDIRECTS = 5;
    public static final String TAG = "HttpUrlFetcher";
    public final HttpUrlConnectionFactory connectionFactory;
    public final GlideUrl glideUrl;
    public volatile boolean isCancelled;
    public InputStream stream;
    public final int timeout;
    public HttpURLConnection urlConnection;

    /* loaded from: classes5.dex */
    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* loaded from: classes5.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this(glideUrl, i2, DEFAULT_CONNECTION_FACTORY);
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    public static boolean isHttpOk(int i2) {
        return i2 / 100 == 2;
    }

    public static boolean isHttpRedirect(int i2) {
        return i2 / 100 == 3;
    }

    private InputStream loadDataWithRedirects(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.urlConnection = this.connectionFactory.build(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.urlConnection.setConnectTimeout(this.timeout);
            this.urlConnection.setReadTimeout(this.timeout);
            this.urlConnection.setUseCaches(false);
            this.urlConnection.setDoInput(true);
            this.urlConnection.setInstanceFollowRedirects(false);
            this.urlConnection.connect();
            this.stream = this.urlConnection.getInputStream();
            if (this.isCancelled) {
                return null;
            }
            int responseCode = this.urlConnection.getResponseCode();
            if (isHttpOk(responseCode)) {
                return getStreamForSuccessfulRequest(this.urlConnection);
            }
            if (!isHttpRedirect(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.urlConnection.getResponseMessage(), responseCode);
            }
            String headerField = this.urlConnection.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                cleanup();
                return loadDataWithRedirects(url3, i2 + 1, url, map);
            }
            throw new HttpException("Received empty or null redirect url");
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        this.isCancelled = true;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        InputStream inputStream = this.stream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.urlConnection;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.urlConnection = null;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        long logTime = LogTime.getLogTime();
        try {
            try {
                dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
            } catch (IOException e2) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to load data for url", e2);
                }
                dataCallback.onLoadFailed(e2);
                if (!Log.isLoggable(TAG, 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable(TAG, 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(LogTime.getElapsedMillis(logTime));
                Log.v(TAG, sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime));
            }
            throw th;
        }
    }

    @VisibleForTesting
    public HttpUrlFetcher(GlideUrl glideUrl, int i2, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.timeout = i2;
        this.connectionFactory = httpUrlConnectionFactory;
    }
}

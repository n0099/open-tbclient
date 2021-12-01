package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes12.dex */
public class HttpUrlFetcher implements DataFetcher<InputStream> {
    public static /* synthetic */ Interceptable $ic = null;
    @VisibleForTesting
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY;
    public static final int INVALID_STATUS_CODE = -1;
    public static final int MAXIMUM_REDIRECTS = 5;
    public static final String TAG = "HttpUrlFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpUrlConnectionFactory connectionFactory;
    public final GlideUrl glideUrl;
    public volatile boolean isCancelled;
    public InputStream stream;
    public final int timeout;
    public HttpURLConnection urlConnection;

    /* loaded from: classes12.dex */
    public static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultHttpUrlConnectionFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) ? (HttpURLConnection) url.openConnection() : (HttpURLConnection) invokeL.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-196908532, "Lcom/bumptech/glide/load/data/HttpUrlFetcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-196908532, "Lcom/bumptech/glide/load/data/HttpUrlFetcher;");
                return;
            }
        }
        DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlFetcher(GlideUrl glideUrl, int i2) {
        this(glideUrl, i2, DEFAULT_CONNECTION_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideUrl, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GlideUrl) objArr2[0], ((Integer) objArr2[1]).intValue(), (HttpUrlConnectionFactory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, httpURLConnection)) == null) {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(TAG, 3)) {
                    String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
                }
                this.stream = httpURLConnection.getInputStream();
            }
            return this.stream;
        }
        return (InputStream) invokeL.objValue;
    }

    public static boolean isHttpOk(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? i2 / 100 == 2 : invokeI.booleanValue;
    }

    public static boolean isHttpRedirect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i2)) == null) ? i2 / 100 == 3 : invokeI.booleanValue;
    }

    private InputStream loadDataWithRedirects(URL url, int i2, URL url2, Map<String, String> map) throws IOException {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65542, this, url, i2, url2, map)) == null) {
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
        return (InputStream) invokeLILL.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isCancelled = true;
        }
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void cleanup() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<InputStream> getDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? InputStream.class : (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? DataSource.REMOTE : (DataSource) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super InputStream> dataCallback) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
            long logTime = LogTime.getLogTime();
            try {
                try {
                    dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
                } catch (IOException e2) {
                    Log.isLoggable(TAG, 3);
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
                    sb.toString();
                }
            } catch (Throwable th) {
                if (Log.isLoggable(TAG, 2)) {
                    String str = "Finished http url fetcher fetch in " + LogTime.getElapsedMillis(logTime);
                }
                throw th;
            }
        }
    }

    @VisibleForTesting
    public HttpUrlFetcher(GlideUrl glideUrl, int i2, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideUrl, Integer.valueOf(i2), httpUrlConnectionFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.glideUrl = glideUrl;
        this.timeout = i2;
        this.connectionFactory = httpUrlConnectionFactory;
    }
}

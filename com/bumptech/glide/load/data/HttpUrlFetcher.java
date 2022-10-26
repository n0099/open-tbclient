package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
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
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* loaded from: classes7.dex */
public class HttpUrlFetcher implements DataFetcher {
    public static /* synthetic */ Interceptable $ic = null;
    public static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY;
    public static final int INVALID_STATUS_CODE = -1;
    public static final int MAXIMUM_REDIRECTS = 5;
    public static final String REDIRECT_HEADER_FIELD = "Location";
    public static final String TAG = "HttpUrlFetcher";
    public transient /* synthetic */ FieldHolder $fh;
    public final HttpUrlConnectionFactory connectionFactory;
    public final GlideUrl glideUrl;
    public volatile boolean isCancelled;
    public InputStream stream;
    public final int timeout;
    public HttpURLConnection urlConnection;

    /* loaded from: classes7.dex */
    public interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    /* loaded from: classes7.dex */
    public class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public DefaultHttpUrlConnectionFactory() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.bumptech.glide.load.data.HttpUrlFetcher.HttpUrlConnectionFactory
        public HttpURLConnection build(URL url) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, url)) == null) {
                return (HttpURLConnection) url.openConnection();
            }
            return (HttpURLConnection) invokeL.objValue;
        }
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
    public Class getDataClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return InputStream.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public DataSource getDataSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return DataSource.REMOTE;
        }
        return (DataSource) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpUrlFetcher(GlideUrl glideUrl, int i) {
        this(glideUrl, i, DEFAULT_CONNECTION_FACTORY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideUrl, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((GlideUrl) objArr2[0], ((Integer) objArr2[1]).intValue(), (HttpUrlConnectionFactory) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private HttpURLConnection buildAndConfigureConnection(URL url, Map map) throws HttpException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, url, map)) == null) {
            try {
                HttpURLConnection build = this.connectionFactory.build(url);
                for (Map.Entry entry : map.entrySet()) {
                    build.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                build.setConnectTimeout(this.timeout);
                build.setReadTimeout(this.timeout);
                build.setUseCaches(false);
                build.setDoInput(true);
                build.setInstanceFollowRedirects(false);
                return build;
            } catch (IOException e) {
                throw new HttpException("URL.openConnection threw", 0, e);
            }
        }
        return (HttpURLConnection) invokeLL.objValue;
    }

    public HttpUrlFetcher(GlideUrl glideUrl, int i, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {glideUrl, Integer.valueOf(i), httpUrlConnectionFactory};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.glideUrl = glideUrl;
        this.timeout = i;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    public static int getHttpStatusCodeOrInvalid(HttpURLConnection httpURLConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, httpURLConnection)) == null) {
            try {
                return httpURLConnection.getResponseCode();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to get a response code", e);
                    return -1;
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static boolean isHttpOk(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i / 100 == 2) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean isHttpRedirect(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            if (i / 100 == 3) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws HttpException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, httpURLConnection)) == null) {
            try {
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                    }
                    this.stream = httpURLConnection.getInputStream();
                }
                return this.stream;
            } catch (IOException e) {
                throw new HttpException("Failed to obtain InputStream", getHttpStatusCodeOrInvalid(httpURLConnection), e);
            }
        }
        return (InputStream) invokeL.objValue;
    }

    private InputStream loadDataWithRedirects(URL url, int i, URL url2, Map map) throws HttpException {
        InterceptResult invokeLILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65544, this, url, i, url2, map)) == null) {
            if (i < 5) {
                if (url2 != null) {
                    try {
                        if (url.toURI().equals(url2.toURI())) {
                            throw new HttpException("In re-direct loop", -1);
                        }
                    } catch (URISyntaxException unused) {
                    }
                }
                HttpURLConnection buildAndConfigureConnection = buildAndConfigureConnection(url, map);
                this.urlConnection = buildAndConfigureConnection;
                try {
                    buildAndConfigureConnection.connect();
                    this.stream = this.urlConnection.getInputStream();
                    if (this.isCancelled) {
                        return null;
                    }
                    int httpStatusCodeOrInvalid = getHttpStatusCodeOrInvalid(this.urlConnection);
                    if (isHttpOk(httpStatusCodeOrInvalid)) {
                        return getStreamForSuccessfulRequest(this.urlConnection);
                    }
                    if (isHttpRedirect(httpStatusCodeOrInvalid)) {
                        String headerField = this.urlConnection.getHeaderField("Location");
                        if (!TextUtils.isEmpty(headerField)) {
                            try {
                                URL url3 = new URL(url, headerField);
                                cleanup();
                                return loadDataWithRedirects(url3, i + 1, url, map);
                            } catch (MalformedURLException e) {
                                throw new HttpException("Bad redirect url: " + headerField, httpStatusCodeOrInvalid, e);
                            }
                        }
                        throw new HttpException("Received empty or null redirect url", httpStatusCodeOrInvalid);
                    } else if (httpStatusCodeOrInvalid == -1) {
                        throw new HttpException(httpStatusCodeOrInvalid);
                    } else {
                        try {
                            throw new HttpException(this.urlConnection.getResponseMessage(), httpStatusCodeOrInvalid);
                        } catch (IOException e2) {
                            throw new HttpException("Failed to get a response message", httpStatusCodeOrInvalid, e2);
                        }
                    }
                } catch (IOException e3) {
                    throw new HttpException("Failed to connect or obtain data", getHttpStatusCodeOrInvalid(this.urlConnection), e3);
                }
            }
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        return (InputStream) invokeLILL.objValue;
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    public void loadData(Priority priority, DataFetcher.DataCallback dataCallback) {
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, priority, dataCallback) == null) {
            long logTime = LogTime.getLogTime();
            try {
                try {
                    dataCallback.onDataReady(loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders()));
                } catch (IOException e) {
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Failed to load data for url", e);
                    }
                    dataCallback.onLoadFailed(e);
                    if (Log.isLoggable(TAG, 2)) {
                        sb = new StringBuilder();
                    } else {
                        return;
                    }
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
    }
}

package com.baidu.tieba;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.http.request.RequestCall;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import okhttp3.internal.Util;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public class wf implements IHttpNet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yf a;
    public HttpRequestBuilder b;
    public RequestCall c;
    public Response d;

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (URL) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void e(URL url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, url) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void g(URL url, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, url, z) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(266771681, "Lcom/baidu/tieba/wf$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(266771681, "Lcom/baidu/tieba/wf$a;");
                    return;
                }
            }
            int[] iArr = new int[IHttpNet.HttpNetType.values().length];
            a = iArr;
            try {
                iArr[IHttpNet.HttpNetType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_FORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public wf(yf yfVar, IHttpNet.HttpNetType httpNetType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yfVar, httpNetType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = yfVar;
        int i3 = a.a[httpNetType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.b = HttpManager.getDefault(BdBaseApplication.getInst()).postByteRequest();
                    return;
                }
                return;
            }
            this.b = HttpManager.getDefault(BdBaseApplication.getInst()).postFormRequest();
            return;
        }
        this.b = HttpManager.getDefault(BdBaseApplication.getInst()).getRequest();
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void a(URL url, int i, int i2) {
        HttpRequestBuilder httpRequestBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, url, i, i2) == null) && (httpRequestBuilder = this.b) != null && url != null) {
            httpRequestBuilder.url(url.toString()).connectionTimeout(i * 2).readTimeout(i2 * 2).requestSubFrom(8927);
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Response response = this.d;
            if (response != null && response.headers() != null) {
                return this.d.headers().toMultimap();
            }
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void f() {
        HttpRequestBuilder httpRequestBuilder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (httpRequestBuilder = this.b) == null) {
            return;
        }
        httpRequestBuilder.addHeaders(this.a.b().g());
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Response response = this.d;
            if (response != null && response.headers() != null) {
                return this.d.headers().get(Headers.CONTENT_ENCODING);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Response response = this.d;
            if (response != null && response.body() != null) {
                return this.d.body().contentLength();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Response response = this.d;
            if (response == null) {
                return 0;
            }
            return response.code();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int c() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HttpRequestBuilder httpRequestBuilder = this.b;
            if (httpRequestBuilder == null) {
                return 0;
            }
            if (httpRequestBuilder instanceof GetRequest.GetRequestBuilder) {
                ((GetRequest.GetRequestBuilder) httpRequestBuilder).addUrlParams(this.a.b().i());
            } else if (httpRequestBuilder instanceof PostFormRequest.PostFormRequestBuilder) {
                ((PostFormRequest.PostFormRequestBuilder) httpRequestBuilder).addParams(this.a.b().i());
            } else if (httpRequestBuilder instanceof PostByteRequest.PostByteRequestBuilder) {
                ((PostByteRequest.PostByteRequestBuilder) httpRequestBuilder).mediaType("multipart/form-data; boundary=--------7da3d81520810*");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (this.a.b().j() != null) {
                    Iterator<BasicNameValuePair> it = this.a.b().j().iterator();
                    while (it.hasNext()) {
                        BasicNameValuePair next = it.next();
                        if (next != null) {
                            String name = next.getName();
                            String value = next.getValue();
                            if (value != null && name != null) {
                                byteArrayOutputStream.write("----------7da3d81520810*\r\n".getBytes(Util.UTF_8));
                                byte[] bytes = value.getBytes("UTF-8");
                                byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + name + "\"\r\n").getBytes(Util.UTF_8));
                                byteArrayOutputStream.write("\r\n".getBytes(Util.UTF_8));
                                byteArrayOutputStream.write(bytes);
                                byteArrayOutputStream.write("\r\n".getBytes(Util.UTF_8));
                            }
                        }
                    }
                }
                if (this.a.b().g != null) {
                    for (Map.Entry<String, byte[]> entry : this.a.b().g.entrySet()) {
                        String key = entry.getKey();
                        byte[] value2 = entry.getValue();
                        if (value2 != null) {
                            byteArrayOutputStream.write("----------7da3d81520810*\r\n".getBytes(Util.UTF_8));
                            byteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"file\"\r\n").getBytes(Util.UTF_8));
                            byteArrayOutputStream.write("\r\n".getBytes(Util.UTF_8));
                            byteArrayOutputStream.write(value2);
                            byteArrayOutputStream.write("\r\n".getBytes(Util.UTF_8));
                        }
                    }
                }
                byteArrayOutputStream.write("----------7da3d81520810*--\r\n".getBytes(Util.UTF_8));
                byteArrayOutputStream.flush();
                ((PostByteRequest.PostByteRequestBuilder) this.b).content(byteArrayOutputStream.toByteArray());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public byte[] execute() throws RequestCallException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequestCall makeRequestCall = this.b.build().makeRequestCall();
            this.c = makeRequestCall;
            Response executeSync = makeRequestCall.executeSync();
            this.d = executeSync;
            if (executeSync != null && executeSync.body() != null) {
                return this.d.body().bytes();
            }
            return null;
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Response response = this.d;
            if (response != null && response.body() != null && this.d.body().contentType() != null) {
                return this.d.body().contentType().toString();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }
}

package com.baidu.webkit.net;

import android.os.AsyncTask;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.net.BdNet;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.net.ssl.SSLContext;
/* loaded from: classes7.dex */
public class BdNetTask implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "BdNetTask";
    public static final int MAX_POOL_SIZE = 10;
    public static final Map<String, String> NULL_ARRAY;
    public static final int TIMEOUT_CONNECTION = 0;
    public static final int TIMEOUT_READ = 25000;
    public static Vector<BdNetTask> sTaskPool;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isUseCorenet;
    public HttpURLConnection mConnection;
    public int mConnectionTimeOut;
    public byte[] mContent;
    public Map<String, String> mCookies;
    public boolean mFollowRedirects;
    public Map<String, String> mHeaders;
    public boolean mIsRedirect;
    public volatile boolean mIsStop;
    public BdNet.HttpMethod mMethod;
    public BdNet mNet;
    public com.baidu.webkit.net.b mNetWorker;
    public int mReadTimeOut;
    public String mRedirectUrl;
    public String mRefer;
    public Map<String, String> mResHeaders;
    public SSLContext mSSLContext;
    public Object mSetting;
    public b mTaskPriority;
    public String mUrl;

    /* loaded from: classes7.dex */
    public static class a extends AsyncTask<HttpURLConnection, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(byte b) {
            this();
        }

        public static Void a(HttpURLConnection... httpURLConnectionArr) {
            InterceptResult invokeL;
            HttpURLConnection httpURLConnection;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, httpURLConnectionArr)) == null) {
                if (httpURLConnectionArr != null) {
                    try {
                        if (httpURLConnectionArr.length <= 0 || (httpURLConnection = httpURLConnectionArr[0]) == null) {
                            return null;
                        }
                        httpURLConnection.disconnect();
                        return null;
                    } catch (Exception unused) {
                        return null;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.AsyncTask
        public final /* synthetic */ Void doInBackground(HttpURLConnection[] httpURLConnectionArr) {
            return a(httpURLConnectionArr);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final /* synthetic */ b[] e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-83863282, "Lcom/baidu/webkit/net/BdNetTask$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-83863282, "Lcom/baidu/webkit/net/BdNetTask$b;");
                    return;
                }
            }
            a = new b("PRIORITY_HIGHER", 0);
            b = new b("PRIORITY_NORMAL", 1);
            c = new b("PRIORITY_LOWER", 2);
            b bVar = new b("PRIORITY_IDLE", 3);
            d = bVar;
            e = new b[]{a, b, c, bVar};
        }

        public b(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static b valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
        }

        public static b[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) e.clone() : (b[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1591146932, "Lcom/baidu/webkit/net/BdNetTask;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1591146932, "Lcom/baidu/webkit/net/BdNetTask;");
                return;
            }
        }
        NULL_ARRAY = Collections.emptyMap();
        sTaskPool = new Vector<>();
    }

    public BdNetTask() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMethod = BdNet.HttpMethod.METHOD_GET;
        Map<String, String> map = NULL_ARRAY;
        this.mHeaders = map;
        this.mResHeaders = map;
        this.mCookies = map;
        this.mReadTimeOut = 25000;
        this.mConnectionTimeOut = 0;
        this.mFollowRedirects = true;
        this.isUseCorenet = true;
        this.mTaskPriority = b.b;
    }

    private void clearForRecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            stop();
            this.mUrl = null;
            this.mRedirectUrl = null;
            this.mRefer = null;
            this.mContent = null;
            this.mMethod = BdNet.HttpMethod.METHOD_GET;
            Map<String, String> map = NULL_ARRAY;
            this.mHeaders = map;
            this.mResHeaders = map;
            this.mCookies = map;
            this.mReadTimeOut = 25000;
            this.mConnectionTimeOut = 0;
            this.mIsRedirect = false;
            this.mFollowRedirects = true;
            this.mIsStop = false;
            this.mNet = null;
            this.mNetWorker = null;
            this.mConnection = null;
        }
    }

    public static void clearTaskPool() {
        Vector<BdNetTask> vector;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, null) == null) || (vector = sTaskPool) == null) {
            return;
        }
        vector.clear();
    }

    private void disconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            try {
                if (this.mConnection != null) {
                    this.mConnection.disconnect();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized BdNetTask obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            synchronized (BdNetTask.class) {
                if (sTaskPool.size() > 0) {
                    try {
                        return sTaskPool.remove(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return new BdNetTask();
                    }
                }
                return new BdNetTask();
            }
        }
        return (BdNetTask) invokeV.objValue;
    }

    public static BdNetTask obtain(BdNet bdNet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bdNet)) == null) {
            BdNetTask obtain = obtain();
            obtain.setNet(bdNet);
            return obtain;
        }
        return (BdNetTask) invokeL.objValue;
    }

    public static BdNetTask obtain(BdNet bdNet, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bdNet, str)) == null) {
            BdNetTask obtain = obtain();
            obtain.setNet(bdNet);
            obtain.setUrl(str);
            return obtain;
        }
        return (BdNetTask) invokeLL.objValue;
    }

    public void addCookies(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                if (this.mCookies == NULL_ARRAY) {
                    this.mCookies = new HashMap();
                }
                for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                    String[] split = str2.split("=");
                    if (split.length >= 2) {
                        this.mCookies.put(split[0], split[1]);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void addCookies(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (this.mCookies == NULL_ARRAY) {
                this.mCookies = new HashMap();
            }
            this.mCookies.put(str, str2);
        }
    }

    public void addHeaders(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            if (this.mHeaders == NULL_ARRAY) {
                this.mHeaders = new HashMap();
            }
            this.mHeaders.put(str, str2);
        }
    }

    public void addResHeaders(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            if (this.mResHeaders == NULL_ARRAY) {
                this.mResHeaders = new HashMap();
            }
            this.mResHeaders.put(str, str2);
        }
    }

    public HttpURLConnection getConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mConnection : (HttpURLConnection) invokeV.objValue;
    }

    public int getConnectionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mConnectionTimeOut : invokeV.intValue;
    }

    public byte[] getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (byte[]) this.mContent.clone() : (byte[]) invokeV.objValue;
    }

    public Map<String, String> getCookies() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCookies : (Map) invokeV.objValue;
    }

    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mHeaders : (Map) invokeV.objValue;
    }

    public BdNet.HttpMethod getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mMethod : (BdNet.HttpMethod) invokeV.objValue;
    }

    public synchronized BdNet getNet() {
        InterceptResult invokeV;
        BdNet bdNet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                bdNet = this.mNet;
            }
            return bdNet;
        }
        return (BdNet) invokeV.objValue;
    }

    public int getReadTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mReadTimeOut : invokeV.intValue;
    }

    public String getRedirectUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mRedirectUrl : (String) invokeV.objValue;
    }

    public String getRefer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mRefer : (String) invokeV.objValue;
    }

    public Map<String, String> getResHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mResHeaders : (Map) invokeV.objValue;
    }

    public SSLContext getSSLContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSSLContext : (SSLContext) invokeV.objValue;
    }

    public Object getSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mSetting : invokeV.objValue;
    }

    public b getTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mTaskPriority : (b) invokeV.objValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mUrl : (String) invokeV.objValue;
    }

    public com.baidu.webkit.net.b getWorker() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mNetWorker : (com.baidu.webkit.net.b) invokeV.objValue;
    }

    public boolean isFollowRedirects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mFollowRedirects : invokeV.booleanValue;
    }

    public boolean isHigherPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mTaskPriority == b.a : invokeV.booleanValue;
    }

    public boolean isRedirect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mIsRedirect : invokeV.booleanValue;
    }

    public boolean isStop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mIsStop : invokeV.booleanValue;
    }

    public boolean isUseCorenet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.isUseCorenet : invokeV.booleanValue;
    }

    public synchronized void recycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            synchronized (this) {
                if (sTaskPool.size() < 10) {
                    clearForRecycle();
                    sTaskPool.add(this);
                }
            }
        }
    }

    public void setConnection(HttpURLConnection httpURLConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpURLConnection) == null) {
            this.mConnection = httpURLConnection;
        }
    }

    public void setConnectionTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mConnectionTimeOut = i;
        }
    }

    public void setContent(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, bArr) == null) || bArr == null) {
            return;
        }
        this.mContent = (byte[]) bArr.clone();
    }

    public void setCookies(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, map) == null) {
            this.mCookies = map;
        }
    }

    public void setFollowRedirects(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.mFollowRedirects = z;
        }
    }

    public void setHeaders(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, map) == null) {
            this.mHeaders = map;
        }
    }

    public void setIsUseCorenet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isUseCorenet = z;
        }
    }

    public void setMethod(BdNet.HttpMethod httpMethod) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, httpMethod) == null) {
            this.mMethod = httpMethod;
        }
    }

    public synchronized void setNet(BdNet bdNet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bdNet) == null) {
            synchronized (this) {
                this.mNet = bdNet;
            }
        }
    }

    public void setReadTimeOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.mReadTimeOut = i;
        }
    }

    public void setRedirect(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.mIsRedirect = z;
        }
    }

    public void setRedirectUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.mRedirectUrl = str;
        }
    }

    public void setRefer(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.mRefer = str;
        }
    }

    public void setSSLContext(SSLContext sSLContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, sSLContext) == null) {
            this.mSSLContext = sSLContext;
        }
    }

    public void setSetting(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, obj) == null) {
            this.mSetting = obj;
        }
    }

    public void setTaskPriority(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, bVar) == null) {
            this.mTaskPriority = bVar;
        }
    }

    public void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, str) == null) {
            this.mUrl = str;
        }
    }

    public void setWorker(com.baidu.webkit.net.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            this.mNetWorker = bVar;
        }
    }

    public synchronized void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            synchronized (this) {
                if (this.mNet != null) {
                    this.mIsStop = false;
                    this.mNet.start(this);
                }
            }
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                disconnect();
            } else if (this.mConnection != null) {
                new a((byte) 0).execute(this.mConnection);
            }
            this.mIsStop = true;
            this.mConnection = null;
        }
    }
}

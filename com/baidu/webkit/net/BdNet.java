package com.baidu.webkit.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.baidu.webkit.net.BdNetEngine;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes2.dex */
public class BdNet implements INoProGuard, BdNetEngine.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CORE_POOL_SIZE = 2;
    public static final boolean DEBUG = false;
    public static final String LOG_TAG = "BdNet";
    public static final int MAX_POOL_SIZE = 3;
    public static final int MSG_START_ERROR = 1;
    public static final int PRIORITY_HIGHER = 0;
    public static final int PRIORITY_IDLE = 3;
    public static final int PRIORITY_LOWER = 2;
    public static final int PRIORITY_NORMAL = 1;
    public static SSLContext mSSLContext;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> mContext;
    public INetListener mListener;
    public int mPoolSize;
    public int mPriority;
    public Handler mPrivateHandler;
    public Vector<BdNetTask> mTaskList;
    public Vector<b> mWorkerList;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class HttpMethod implements INoProGuard {
        public static final /* synthetic */ HttpMethod[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final HttpMethod METHOD_GET;
        public static final HttpMethod METHOD_HEAD;
        public static final HttpMethod METHOD_POST;
        public static final HttpMethod METHOD_RESUME;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-646603976, "Lcom/baidu/webkit/net/BdNet$HttpMethod;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-646603976, "Lcom/baidu/webkit/net/BdNet$HttpMethod;");
                    return;
                }
            }
            METHOD_GET = new HttpMethod("METHOD_GET", 0);
            METHOD_POST = new HttpMethod("METHOD_POST", 1);
            METHOD_RESUME = new HttpMethod("METHOD_RESUME", 2);
            HttpMethod httpMethod = new HttpMethod("METHOD_HEAD", 3);
            METHOD_HEAD = httpMethod;
            $VALUES = new HttpMethod[]{METHOD_GET, METHOD_POST, METHOD_RESUME, httpMethod};
        }

        public HttpMethod(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static HttpMethod valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (HttpMethod) Enum.valueOf(HttpMethod.class, str) : (HttpMethod) invokeL.objValue;
        }

        public static HttpMethod[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (HttpMethod[]) $VALUES.clone() : (HttpMethod[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class NetError implements INoProGuard {
        public static final /* synthetic */ NetError[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetError ERROR_CONNECT_TIMEOUT;
        public static final NetError ERROR_HTTP;
        public static final NetError ERROR_IO;
        public static final NetError ERROR_MALFORMEDURL;
        public static final NetError ERROR_REDIRECT;
        public static final NetError ERROR_RUN_EXCEPTION;
        public static final NetError ERROR_RUN_START;
        public static final NetError ERROR_RUN_STOP;
        public static final NetError ERROR_UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-441080298, "Lcom/baidu/webkit/net/BdNet$NetError;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-441080298, "Lcom/baidu/webkit/net/BdNet$NetError;");
                    return;
                }
            }
            ERROR_RUN_START = new NetError("ERROR_RUN_START", 0);
            ERROR_RUN_EXCEPTION = new NetError("ERROR_RUN_EXCEPTION", 1);
            ERROR_RUN_STOP = new NetError("ERROR_RUN_STOP", 2);
            ERROR_HTTP = new NetError("ERROR_HTTP", 3);
            ERROR_REDIRECT = new NetError("ERROR_REDIRECT", 4);
            ERROR_MALFORMEDURL = new NetError("ERROR_MALFORMEDURL", 5);
            ERROR_CONNECT_TIMEOUT = new NetError("ERROR_CONNECT_TIMEOUT", 6);
            ERROR_IO = new NetError("ERROR_IO", 7);
            NetError netError = new NetError("ERROR_UNKNOWN", 8);
            ERROR_UNKNOWN = netError;
            $VALUES = new NetError[]{ERROR_RUN_START, ERROR_RUN_EXCEPTION, ERROR_RUN_STOP, ERROR_HTTP, ERROR_REDIRECT, ERROR_MALFORMEDURL, ERROR_CONNECT_TIMEOUT, ERROR_IO, netError};
        }

        public NetError(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetError valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetError) Enum.valueOf(NetError.class, str) : (NetError) invokeL.objValue;
        }

        public static NetError[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetError[]) $VALUES.clone() : (NetError[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class NetState implements INoProGuard {
        public static final /* synthetic */ NetState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final NetState STATE_CONNECT_SETUP;
        public static final NetState STATE_CONNECT_START;
        public static final NetState STATE_DISCONNECT;
        public static final NetState STATE_UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-38927187, "Lcom/baidu/webkit/net/BdNet$NetState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-38927187, "Lcom/baidu/webkit/net/BdNet$NetState;");
                    return;
                }
            }
            STATE_CONNECT_START = new NetState("STATE_CONNECT_START", 0);
            STATE_CONNECT_SETUP = new NetState("STATE_CONNECT_SETUP", 1);
            STATE_DISCONNECT = new NetState("STATE_DISCONNECT", 2);
            NetState netState = new NetState("STATE_UNKNOWN", 3);
            STATE_UNKNOWN = netState;
            $VALUES = new NetState[]{STATE_CONNECT_START, STATE_CONNECT_SETUP, STATE_DISCONNECT, netState};
        }

        public NetState(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static NetState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetState) Enum.valueOf(NetState.class, str) : (NetState) invokeL.objValue;
        }

        public static NetState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetState[]) $VALUES.clone() : (NetState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements X509TrustManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public X509TrustManager a;

        /* renamed from: b  reason: collision with root package name */
        public X509TrustManager f54940b;

        public a(KeyStore keyStore) throws KeyStoreException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {keyStore};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            try {
                this.a = a(null);
                this.f54940b = a(keyStore);
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
        }

        public static X509TrustManager a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, keyStore)) == null) {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
            }
            return (X509TrustManager) invokeL.objValue;
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, x509CertificateArr, str) == null) {
                try {
                    this.a.checkClientTrusted(x509CertificateArr, str);
                } catch (CertificateException unused) {
                    this.f54940b.checkClientTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr, str) == null) {
                try {
                    this.a.checkServerTrusted(x509CertificateArr, str);
                } catch (CertificateException unused) {
                    this.f54940b.checkServerTrusted(x509CertificateArr, str);
                }
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public final X509Certificate[] getAcceptedIssuers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                X509Certificate[] acceptedIssuers = this.a.getAcceptedIssuers();
                X509Certificate[] acceptedIssuers2 = this.f54940b.getAcceptedIssuers();
                X509Certificate[] x509CertificateArr = (X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length + acceptedIssuers2.length);
                System.arraycopy(acceptedIssuers2, 0, x509CertificateArr, acceptedIssuers.length, acceptedIssuers2.length);
                return x509CertificateArr;
            }
            return (X509Certificate[]) invokeV.objValue;
        }
    }

    public BdNet(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPriority = 1;
        this.mPoolSize = 2;
        this.mContext = new WeakReference<>(context);
        if (com.baidu.webkit.net.a.a().f54956c == null) {
            com.baidu.webkit.net.a.a().f54956c = getContext().getApplicationContext();
        }
        this.mTaskList = new Vector<>();
        this.mWorkerList = new Vector<>();
    }

    private synchronized SSLContext getSSLContext() {
        InterceptResult invokeV;
        SSLContext sSLContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this) {
                sSLContext = mSSLContext;
            }
            return sSLContext;
        }
        return (SSLContext) invokeV.objValue;
    }

    private boolean isComplete() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            int size = this.mWorkerList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mWorkerList.get(i2).a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStartError(BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bdNetTask) == null) {
            try {
                if (this.mListener != null) {
                    this.mListener.onNetDownloadError(this, bdNetTask, NetError.ERROR_RUN_START, 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void releaseSSLContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            mSSLContext = null;
        }
    }

    private BdNetTask startNext(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, bdNetEngine, bdNetTask)) == null) {
            BdNetTask pollTask = pollTask();
            BdNetTask d2 = com.baidu.webkit.net.a.a().d();
            b worker = bdNetTask.getWorker();
            if (d2 != null) {
                if (pollTask == null) {
                    worker.b();
                    if (this.mListener != null && isComplete()) {
                        this.mListener.onNetDownloadComplete(this);
                    }
                } else if (!worker.a(pollTask)) {
                    startError(pollTask);
                }
                d2.getWorker().a(bdNetEngine);
                return d2;
            } else if (pollTask != null) {
                worker.a = pollTask;
                worker.a(bdNetEngine);
                pollTask.setWorker(worker);
                return pollTask;
            } else {
                worker.b();
                if (this.mListener != null && isComplete()) {
                    this.mListener.onNetDownloadComplete(this);
                }
                if (isComplete()) {
                    com.baidu.webkit.net.a.a();
                    if (com.baidu.webkit.net.a.b()) {
                        com.baidu.webkit.net.a a2 = com.baidu.webkit.net.a.a();
                        try {
                            if (a2.a != null) {
                                a2.a.clear();
                                a2.a = null;
                            }
                            int size = a2.f54955b.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                a2.f54955b.get(i2).stopDownload();
                            }
                            a2.f54955b.clear();
                            releaseSSLContext();
                            BdNetTask.clearTaskPool();
                            com.baidu.webkit.net.a.c();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                return null;
            }
        }
        return (BdNetTask) invokeLL.objValue;
    }

    public void createSSLContext(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, inputStream) == null) || inputStream == null) {
            return;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                Certificate generateCertificate = certificateFactory.generateCertificate(bufferedInputStream);
                bufferedInputStream.close();
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setCertificateEntry("ca4", generateCertificate);
                a aVar = new a(keyStore);
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                mSSLContext = sSLContext;
                sSLContext.init(null, new TrustManager[]{aVar}, null);
            } catch (Throwable th) {
                bufferedInputStream.close();
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (KeyManagementException e3) {
            e3.printStackTrace();
        } catch (KeyStoreException e4) {
            e4.printStackTrace();
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
        } catch (CertificateException e6) {
            e6.printStackTrace();
        }
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mContext.get() : (Context) invokeV.objValue;
    }

    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPriority : invokeV.intValue;
    }

    public BdNetTask obtainTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdNetTask.obtain(this) : (BdNetTask) invokeV.objValue;
    }

    public BdNetTask obtainTask(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? BdNetTask.obtain(this, str) : (BdNetTask) invokeL.objValue;
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public BdNetTask onNetDownloadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask, boolean z) {
        InterceptResult invokeLLZ;
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, bdNetEngine, bdNetTask, z)) == null) {
            if (z && (iNetListener = this.mListener) != null) {
                iNetListener.onNetTaskComplete(this, bdNetTask);
            }
            BdNetTask startNext = startNext(bdNetEngine, bdNetTask);
            bdNetTask.recycle();
            return startNext;
        }
        return (BdNetTask) invokeLLZ.objValue;
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetDownloadError(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetError netError, int i2) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048582, this, bdNetEngine, bdNetTask, netError, i2) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetDownloadError(this, bdNetTask, netError, i2);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetDownloadStart(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, bdNetEngine, bdNetTask) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetTaskStart(this, bdNetTask);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetReceiveData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, byte[] bArr, int i2) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdNetEngine, bdNetTask, bArr, i2) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetReceiveData(this, bdNetTask, bArr, i2);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetReceiveHeaders(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, bdNetEngine, bdNetTask) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetReceiveHeaders(this, bdNetTask);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public boolean onNetRedirect(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, bdNetEngine, bdNetTask, i2)) == null) {
            INetListener iNetListener = this.mListener;
            if (iNetListener != null) {
                return iNetListener.onNetRedirect(this, bdNetTask, i2);
            }
            return true;
        }
        return invokeLLI.booleanValue;
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetResponseCode(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048587, this, bdNetEngine, bdNetTask, i2) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetResponseCode(this, bdNetTask, i2);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetStateChanged(BdNetEngine bdNetEngine, BdNetTask bdNetTask, NetState netState, int i2) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048588, this, bdNetEngine, bdNetTask, netState, i2) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetStateChanged(this, bdNetTask, netState, i2);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetUploadComplete(BdNetEngine bdNetEngine, BdNetTask bdNetTask) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, bdNetEngine, bdNetTask) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetUploadComplete(this, bdNetTask);
    }

    @Override // com.baidu.webkit.net.BdNetEngine.b
    public void onNetUploadData(BdNetEngine bdNetEngine, BdNetTask bdNetTask, int i2, int i3) {
        INetListener iNetListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(1048590, this, bdNetEngine, bdNetTask, i2, i3) == null) || (iNetListener = this.mListener) == null) {
            return;
        }
        iNetListener.onNetUploadData(this, bdNetTask, i2, i3);
    }

    public BdNetTask peekTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.mTaskList.size() > 0) {
                return this.mTaskList.get(0);
            }
            return null;
        }
        return (BdNetTask) invokeV.objValue;
    }

    public BdNetTask pollTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (this.mTaskList.size() > 0) {
                return this.mTaskList.remove(0);
            }
            return null;
        }
        return (BdNetTask) invokeV.objValue;
    }

    public void setEventListener(INetListener iNetListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iNetListener) == null) {
            this.mListener = iNetListener;
        }
    }

    public void setPoolSize(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || i2 <= 0 || i2 > 3) {
            return;
        }
        this.mPoolSize = i2;
    }

    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i2) == null) || i2 < 0 || i2 > 3) {
            return;
        }
        this.mPriority = i2;
    }

    public void start(BdNetTask bdNetTask) throws NullPointerException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdNetTask) == null) {
            start(bdNetTask, true);
        }
    }

    public void start(BdNetTask bdNetTask, boolean z) throws NullPointerException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, bdNetTask, z) == null) {
            if (bdNetTask == null) {
                throw new NullPointerException("start nettask null");
            }
            if (z) {
                bdNetTask.setSSLContext(getSSLContext());
            }
            Iterator<b> it = this.mWorkerList.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (!next.a()) {
                    if (next.a(bdNetTask)) {
                        return;
                    }
                    startError(bdNetTask);
                    return;
                }
            }
            if (this.mWorkerList.size() >= this.mPoolSize) {
                this.mTaskList.add(bdNetTask);
                return;
            }
            b bVar = new b(this);
            this.mWorkerList.add(bVar);
            bVar.a(bdNetTask);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public void startError(BdNetTask bdNetTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bdNetTask) == null) {
            if (this.mPrivateHandler == null) {
                if (getContext() == null) {
                    return;
                }
                this.mPrivateHandler = new Handler(this, getContext().getMainLooper()) { // from class: com.baidu.webkit.net.BdNet.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdNet a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.os.Handler
                    public final void handleMessage(Message message) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) && message.what == 1) {
                            this.a.onStartError((BdNetTask) message.obj);
                        }
                    }
                };
            }
            this.mPrivateHandler.obtainMessage(1, bdNetTask).sendToTarget();
        }
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Iterator<b> it = this.mWorkerList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.mWorkerList.clear();
            this.mTaskList.clear();
            this.mListener = null;
        }
    }
}

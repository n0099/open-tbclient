package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import b.a.e.e.m.b;
import b.a.r0.z3.c;
import b.a.r0.z3.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.convert.IVideoConvertListener;
import com.baidu.tieba.video.convert.IVideoConvertService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes9.dex */
public class VideoConvertUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final String n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f54641a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f54642b;

    /* renamed from: c  reason: collision with root package name */
    public String f54643c;

    /* renamed from: d  reason: collision with root package name */
    public String f54644d;

    /* renamed from: e  reason: collision with root package name */
    public File f54645e;

    /* renamed from: f  reason: collision with root package name */
    public File f54646f;

    /* renamed from: g  reason: collision with root package name */
    public d f54647g;

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f54648h;

    /* renamed from: i  reason: collision with root package name */
    public int f54649i;
    public boolean j;
    public boolean k;
    public int l;
    public ServiceConnection m;

    /* loaded from: classes9.dex */
    public class IntenalConvertListener extends IVideoConvertListener.Stub {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoConvertUtil this$0;

        public IntenalConvertListener(VideoConvertUtil videoConvertUtil) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoConvertUtil};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = videoConvertUtil;
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertAborted() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.f54647g == null) {
                return;
            }
            this.this$0.f54647g.onConvertAborted();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$0.f54647g == null) {
                return;
            }
            this.this$0.f54647g.onConvertFailed();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.this$0.f54647g != null) {
                    this.this$0.f54647g.onConvertProgress(i2);
                }
                if ((this.this$0.f54645e == null || this.this$0.f54645e.exists()) && (this.this$0.f54646f == null || this.this$0.f54646f.exists())) {
                    return;
                }
                this.this$0.a();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.f54649i = 1;
                if (this.this$0.f54647g != null) {
                    this.this$0.f54647g.onConvertSuccess();
                }
            }
        }

        public /* synthetic */ IntenalConvertListener(VideoConvertUtil videoConvertUtil, a aVar) {
            this(videoConvertUtil);
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoConvertUtil f54650e;

        public a(VideoConvertUtil videoConvertUtil) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoConvertUtil};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54650e = videoConvertUtil;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f54650e.f54642b = IVideoConvertService.Stub.asInterface(iBinder);
                if (this.f54650e.k) {
                    this.f54650e.p();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (this.f54650e.k) {
                    if (!this.f54650e.j && this.f54650e.f54649i == -3 && this.f54650e.f54647g != null) {
                        this.f54650e.f54647g.onConvertFailed();
                    }
                    this.f54650e.k = false;
                }
                this.f54650e.f54642b = null;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(438278239, "Lcom/baidu/tieba/video/VideoConvertUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(438278239, "Lcom/baidu/tieba/video/VideoConvertUtil;");
                return;
            }
        }
        n = c.f28286f;
    }

    public VideoConvertUtil(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f54649i = -3;
        this.j = false;
        this.k = false;
        this.l = 1;
        this.m = new a(this);
        this.f54641a = context;
        this.f54648h = new IntenalConvertListener(this, null);
    }

    private void bindService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f54641a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f54641a.bindService(intent, this.m, 1);
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            File file = new File(n);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.exists() && file.isDirectory();
        }
        return invokeV.booleanValue;
    }

    public static int o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int e2 = b.e(mediaMetadataRetriever.extractMetadata(20), 0);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return e2;
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    private void startService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f54641a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f54641a.startService(intent);
    }

    public static String t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str != null && !str.isEmpty()) {
                try {
                    byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
                    StringBuilder sb = new StringBuilder(digest.length * 2);
                    for (byte b2 : digest) {
                        int i2 = b2 & 255;
                        if (i2 < 16) {
                            sb.append("0");
                        }
                        sb.append(Integer.toHexString(i2));
                    }
                    return sb.toString();
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return "";
                } catch (NoSuchAlgorithmException e3) {
                    e3.printStackTrace();
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    private void unbindService() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.f54642b == null || (context = this.f54641a) == null) {
            return;
        }
        context.unbindService(this.m);
    }

    public void a() {
        IVideoConvertService iVideoConvertService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoConvertService = this.f54642b) == null) {
            return;
        }
        try {
            iVideoConvertService.abortConvert();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void m(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.k = true;
            this.j = false;
            this.f54649i = -3;
            this.f54643c = str;
            this.f54644d = str2;
            this.f54645e = new File(this.f54643c);
            this.f54646f = new File(this.f54644d);
            if (this.f54642b == null) {
                startService();
                bindService();
                return;
            }
            p();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j = true;
            a();
            unbindService();
        }
    }

    public final void p() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                this.f54642b.setIVideoConvertListener(this.f54648h);
                this.f54642b.setConvertType(this.l);
                i2 = this.f54642b.doConvert(this.f54643c, this.f54644d);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            d dVar = this.f54647g;
            if (dVar != null) {
                if (i2 == 0) {
                    dVar.b();
                } else {
                    dVar.a(i2);
                }
            }
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                if (this.f54642b != null) {
                    return this.f54642b.isConvertRunning();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.l = i2;
        }
    }

    public void s(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            this.f54647g = dVar;
        }
    }
}

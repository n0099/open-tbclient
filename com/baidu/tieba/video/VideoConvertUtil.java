package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import b.a.e.f.m.b;
import b.a.r0.a4.c;
import b.a.r0.a4.d;
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
    public Context f55560a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f55561b;

    /* renamed from: c  reason: collision with root package name */
    public String f55562c;

    /* renamed from: d  reason: collision with root package name */
    public String f55563d;

    /* renamed from: e  reason: collision with root package name */
    public File f55564e;

    /* renamed from: f  reason: collision with root package name */
    public File f55565f;

    /* renamed from: g  reason: collision with root package name */
    public d f55566g;

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f55567h;

    /* renamed from: i  reason: collision with root package name */
    public int f55568i;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.f55566g == null) {
                return;
            }
            this.this$0.f55566g.onConvertAborted();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$0.f55566g == null) {
                return;
            }
            this.this$0.f55566g.onConvertFailed();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.this$0.f55566g != null) {
                    this.this$0.f55566g.onConvertProgress(i2);
                }
                if ((this.this$0.f55564e == null || this.this$0.f55564e.exists()) && (this.this$0.f55565f == null || this.this$0.f55565f.exists())) {
                    return;
                }
                this.this$0.a();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.f55568i = 1;
                if (this.this$0.f55566g != null) {
                    this.this$0.f55566g.onConvertSuccess();
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
        public final /* synthetic */ VideoConvertUtil f55569e;

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
            this.f55569e = videoConvertUtil;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f55569e.f55561b = IVideoConvertService.Stub.asInterface(iBinder);
                if (this.f55569e.k) {
                    this.f55569e.p();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (this.f55569e.k) {
                    if (!this.f55569e.j && this.f55569e.f55568i == -3 && this.f55569e.f55566g != null) {
                        this.f55569e.f55566g.onConvertFailed();
                    }
                    this.f55569e.k = false;
                }
                this.f55569e.f55561b = null;
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
        n = c.f15921f;
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
        this.f55568i = -3;
        this.j = false;
        this.k = false;
        this.l = 1;
        this.m = new a(this);
        this.f55560a = context;
        this.f55567h = new IntenalConvertListener(this, null);
    }

    private void bindService() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.f55560a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f55560a.bindService(intent, this.m, 1);
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
        if (!(interceptable == null || interceptable.invokeV(65551, this) == null) || this.f55560a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f55560a.startService(intent);
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
        if (!(interceptable == null || interceptable.invokeV(65553, this) == null) || this.f55561b == null || (context = this.f55560a) == null) {
            return;
        }
        context.unbindService(this.m);
    }

    public void a() {
        IVideoConvertService iVideoConvertService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoConvertService = this.f55561b) == null) {
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
            this.f55568i = -3;
            this.f55562c = str;
            this.f55563d = str2;
            this.f55564e = new File(this.f55562c);
            this.f55565f = new File(this.f55563d);
            if (this.f55561b == null) {
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
                this.f55561b.setIVideoConvertListener(this.f55567h);
                this.f55561b.setConvertType(this.l);
                i2 = this.f55561b.doConvert(this.f55562c, this.f55563d);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            d dVar = this.f55566g;
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
                if (this.f55561b != null) {
                    return this.f55561b.isConvertRunning();
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
            this.f55566g = dVar;
        }
    }
}

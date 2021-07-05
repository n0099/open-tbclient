package com.baidu.tieba.video;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaMetadataRetriever;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.m.b;
import d.a.s0.v3.c;
import d.a.s0.v3.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes5.dex */
public class VideoConvertUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final String n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f21492a;

    /* renamed from: b  reason: collision with root package name */
    public IVideoConvertService f21493b;

    /* renamed from: c  reason: collision with root package name */
    public String f21494c;

    /* renamed from: d  reason: collision with root package name */
    public String f21495d;

    /* renamed from: e  reason: collision with root package name */
    public File f21496e;

    /* renamed from: f  reason: collision with root package name */
    public File f21497f;

    /* renamed from: g  reason: collision with root package name */
    public d f21498g;

    /* renamed from: h  reason: collision with root package name */
    public IntenalConvertListener f21499h;

    /* renamed from: i  reason: collision with root package name */
    public int f21500i;
    public boolean j;
    public boolean k;
    public int l;
    public ServiceConnection m;

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.this$0.f21498g == null) {
                return;
            }
            this.this$0.f21498g.onConvertAborted();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertFailed() throws RemoteException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.this$0.f21498g == null) {
                return;
            }
            this.this$0.f21498g.onConvertFailed();
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertProgress(int i2) throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                if (this.this$0.f21498g != null) {
                    this.this$0.f21498g.onConvertProgress(i2);
                }
                if ((this.this$0.f21496e == null || this.this$0.f21496e.exists()) && (this.this$0.f21497f == null || this.this$0.f21497f.exists())) {
                    return;
                }
                this.this$0.a();
            }
        }

        @Override // com.baidu.tieba.video.convert.IVideoConvertListener
        public void onConvertSuccess() throws RemoteException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.f21500i = 1;
                if (this.this$0.f21498g != null) {
                    this.this$0.f21498g.onConvertSuccess();
                }
            }
        }

        public /* synthetic */ IntenalConvertListener(VideoConvertUtil videoConvertUtil, a aVar) {
            this(videoConvertUtil);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoConvertUtil f21501e;

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
            this.f21501e = videoConvertUtil;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                this.f21501e.f21493b = IVideoConvertService.Stub.asInterface(iBinder);
                if (this.f21501e.k) {
                    this.f21501e.q();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                if (this.f21501e.k) {
                    if (!this.f21501e.j && this.f21501e.f21500i == -3 && this.f21501e.f21498g != null) {
                        this.f21501e.f21498g.onConvertFailed();
                    }
                    this.f21501e.k = false;
                }
                this.f21501e.f21493b = null;
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
        n = c.f68591d;
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
        this.f21500i = -3;
        this.j = false;
        this.k = false;
        this.l = 1;
        this.m = new a(this);
        this.f21492a = context;
        this.f21499h = new IntenalConvertListener(this, null);
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
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

    public static int p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(str);
                    int d2 = b.d(mediaMetadataRetriever.extractMetadata(20), 0);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return d2;
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) {
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

    public void a() {
        IVideoConvertService iVideoConvertService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iVideoConvertService = this.f21493b) == null) {
            return;
        }
        try {
            iVideoConvertService.abortConvert();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f21492a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f21492a.bindService(intent, this.m, 1);
    }

    public void n(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            this.k = true;
            this.j = false;
            this.f21500i = -3;
            this.f21494c = str;
            this.f21495d = str2;
            this.f21496e = new File(this.f21494c);
            this.f21497f = new File(this.f21495d);
            if (this.f21493b == null) {
                u();
                l();
                return;
            }
            q();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j = true;
            a();
            w();
        }
    }

    public final void q() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            try {
                this.f21493b.setIVideoConvertListener(this.f21499h);
                this.f21493b.setConvertType(this.l);
                i2 = this.f21493b.doConvert(this.f21494c, this.f21495d);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            d dVar = this.f21498g;
            if (dVar != null) {
                if (i2 == 0) {
                    dVar.b();
                } else {
                    dVar.a(i2);
                }
            }
        }
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                if (this.f21493b != null) {
                    return this.f21493b.isConvertRunning();
                }
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.l = i2;
        }
    }

    public void t(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            this.f21498g = dVar;
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f21492a == null) {
            return;
        }
        Intent intent = new Intent("com.baidu.tieba.video.convert.VideoConvertService");
        intent.setPackage("com.baidu.tieba");
        this.f21492a.startService(intent);
    }

    public final void w() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f21493b == null || (context = this.f21492a) == null) {
            return;
        }
        context.unbindService(this.m);
    }
}

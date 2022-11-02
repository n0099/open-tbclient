package com.baidu.ugc.download;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fg9;
import com.baidu.tieba.gg9;
import com.baidu.tieba.hg9;
import com.baidu.tieba.ig9;
import com.baidu.tieba.ti9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes6.dex */
public class CaptureDownloadService extends Service {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_CANCEL = "com.baidu.ugc.download.ACTION_CANCEL";
    public static final String ACTION_CANCEL_ALL = "com.baidu.ugc.download.ACTION_CANCEL_ALL";
    public static final String ACTION_DOWNLOAD = "com.baidu.ugc.download.ACTION_DOWNLOAD";
    public static final String ACTION_DOWNLOAD_BROAD_CAST = "com.baidu.ugc.download.ACTION_BROAD_CAST";
    public static final String ACTION_PAUSE = "com.baidu.ugc.download.ACTION_PAUSE";
    public static final String ACTION_PAUSE_ALL = "com.baidu.ugc.download.ACTION_PAUSE_ALL";
    public static final String EXTRA_FILE_INFO = "extra_file_info";
    public static final String EXTRA_POSITION = "extra_position";
    public static final String EXTRA_TAG = "extra_tag";
    public static final String TAG = "CaptureDownloadService";
    public transient /* synthetic */ FieldHolder $fh;
    public fg9 mDownloadManager;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class a extends ig9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public hg9 b;
        public LocalBroadcastManager c;
        public long d;
        public int e;

        public a(int i, hg9 hg9Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), hg9Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = hg9Var;
            this.c = LocalBroadcastManager.getInstance(context);
        }

        @Override // com.baidu.tieba.ig9
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.f(6);
                this.b.d(100);
                this.b.e(str);
                j(this.b);
            }
        }

        @Override // com.baidu.tieba.ig9
        public void f(DownloadException downloadException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, downloadException) == null) {
                downloadException.printStackTrace();
                this.b.f(5);
                j(this.b);
            }
        }

        public final boolean i(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.d > 300 && i != this.e) {
                    this.d = currentTimeMillis;
                    this.e = i;
                    return true;
                }
                return false;
            }
            return invokeI.booleanValue;
        }

        @Override // com.baidu.tieba.ig9
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.f(0);
                this.b.d(0);
                this.b.c("");
                j(this.b);
            }
        }

        @Override // com.baidu.tieba.ig9
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.f(4);
                j(this.b);
            }
        }

        @Override // com.baidu.tieba.ig9
        public void g(long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                if (this.d == 0) {
                    this.d = System.currentTimeMillis();
                }
                this.b.f(3);
                this.b.d(i);
                this.b.c(ti9.a(j, j2));
                if (i(i)) {
                    j(this.b);
                }
            }
        }

        public final void j(hg9 hg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hg9Var) == null) {
                Intent intent = new Intent();
                intent.setAction("com.baidu.ugc.download.ACTION_BROAD_CAST");
                intent.putExtra("extra_position", this.a);
                intent.putExtra("extra_file_info", hg9Var.g().toString());
                this.c.sendBroadcast(intent);
            }
        }
    }

    public CaptureDownloadService() {
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

    private void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.mDownloadManager.d();
        }
    }

    private void pauseAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            this.mDownloadManager.m();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            this.mDownloadManager = fg9.h();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            this.mDownloadManager.m();
        }
    }

    public static void cancel(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_CANCEL");
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    public static void pause(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_PAUSE");
            intent.putExtra("extra_tag", str);
            context.startService(intent);
        }
    }

    private void cancel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, str) == null) {
            this.mDownloadManager.c(str);
        }
    }

    public static void cancelAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_CANCEL_ALL");
            context.startService(intent);
        }
    }

    public static void destroy(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, context) == null) {
            context.stopService(new Intent(context, CaptureDownloadService.class));
        }
    }

    private void pause(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            this.mDownloadManager.l(str);
        }
    }

    public static void pauseAll(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_PAUSE_ALL");
            context.startService(intent);
        }
    }

    private void download(int i, hg9 hg9Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65542, this, i, hg9Var, str) == null) {
            gg9.b bVar = new gg9.b();
            bVar.d(hg9Var.a());
            this.mDownloadManager.f(bVar.a(), str, new a(i, hg9Var, getApplicationContext()));
        }
    }

    public static void start(Context context, String str, hg9 hg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65548, null, context, str, hg9Var) == null) {
            start(context, 0, str, hg9Var);
        }
    }

    public static void start(Context context, int i, String str, hg9 hg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65547, null, context, i, str, hg9Var) == null) {
            Intent intent = new Intent(context, CaptureDownloadService.class);
            intent.setAction("com.baidu.ugc.download.ACTION_DOWNLOAD");
            intent.putExtra("extra_position", i);
            intent.putExtra("extra_tag", str);
            intent.putExtra("extra_file_info", hg9Var.g().toString());
            context.startService(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (r0.equals("com.baidu.ugc.download.ACTION_DOWNLOAD") != false) goto L9;
     */
    @Override // android.app.Service
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent != null) {
                String action = intent.getAction();
                char c = 0;
                int intExtra = intent.getIntExtra("extra_position", 0);
                hg9 hg9Var = new hg9();
                hg9Var.b(intent.getStringExtra("extra_file_info"));
                String stringExtra = intent.getStringExtra("extra_tag");
                switch (action.hashCode()) {
                    case -2000112966:
                        if (action.equals("com.baidu.ugc.download.ACTION_CANCEL")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -1148652932:
                        if (action.equals("com.baidu.ugc.download.ACTION_CANCEL_ALL")) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case -929888424:
                        if (action.equals("com.baidu.ugc.download.ACTION_PAUSE_ALL")) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    case -707184440:
                        break;
                    case 1610061206:
                        if (action.equals("com.baidu.ugc.download.ACTION_PAUSE")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c != 2) {
                            if (c != 3) {
                                if (c == 4) {
                                    cancelAll();
                                }
                            } else {
                                pauseAll();
                            }
                        } else {
                            cancel(stringExtra);
                        }
                    } else {
                        pause(stringExtra);
                    }
                } else {
                    download(intExtra, hg9Var, stringExtra);
                }
            }
            return super.onStartCommand(intent, i, i2);
        }
        return invokeLII.intValue;
    }
}

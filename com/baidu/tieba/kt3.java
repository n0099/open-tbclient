package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import com.baidu.tieba.mt3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public final class kt3 implements tt3, mt3.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static kt3 k;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public ExecutorService b;
    public final ConcurrentHashMap<String, Object> c;
    public final List<DownloadInfo> d;
    public final Context e;
    public final ut3 f;
    public final rt3 g;
    public final jt3 h;
    public ConcurrentHashMap<Uri, BroadcastReceiver> i;
    public ConcurrentHashMap<Uri, Timer> j;

    /* loaded from: classes6.dex */
    public class a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kt3 this$0;
        public final /* synthetic */ d val$listener;
        public final /* synthetic */ String val$packageName;
        public final /* synthetic */ Uri val$uri;

        public a(kt3 kt3Var, String str, d dVar, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt3Var, str, dVar, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kt3Var;
            this.val$packageName = str;
            this.val$listener = dVar;
            this.val$uri = uri;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String dataString;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && (dataString = intent.getDataString()) != null && dataString.endsWith(this.val$packageName)) {
                this.val$listener.a(Boolean.TRUE);
                this.this$0.l(context, this.val$uri);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Uri c;
        public final /* synthetic */ kt3 d;

        public b(kt3 kt3Var, d dVar, Context context, Uri uri) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt3Var, dVar, context, uri};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = kt3Var;
            this.a = dVar;
            this.b = context;
            this.c = uri;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a(Boolean.FALSE);
                this.d.l(this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Timer a;
        public final /* synthetic */ kt3 b;

        public c(kt3 kt3Var, Timer timer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kt3Var, timer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kt3Var;
            this.a = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (Map.Entry entry : this.b.i.entrySet()) {
                    kt3 kt3Var = this.b;
                    kt3Var.l(kt3Var.e, (Uri) entry.getKey());
                }
                this.a.cancel();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t) == null) {
            }
        }

        public d() {
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
    }

    public kt3(Context context, jt3 jt3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jt3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = new ConcurrentHashMap<>();
        this.j = new ConcurrentHashMap<>();
        this.e = context;
        if (jt3Var == null) {
            this.h = new jt3();
        } else {
            this.h = jt3Var;
        }
        if (this.h.a() == null) {
            this.g = new ot3(context, this.h);
        } else {
            this.g = this.h.a();
        }
        this.d = new ArrayList();
        this.c = new ConcurrentHashMap<>();
        this.g.b();
        this.b = Executors.newFixedThreadPool(this.h.b());
        this.f = new lt3(this.g);
    }

    @Override // com.baidu.tieba.tt3
    public synchronized void a(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, downloadInfo) == null) {
            synchronized (this) {
                if (n()) {
                    p(downloadInfo);
                }
            }
        }
    }

    @Override // com.baidu.tieba.tt3
    public synchronized void c(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo) == null) {
            synchronized (this) {
                this.d.add(downloadInfo);
                p(downloadInfo);
            }
        }
    }

    @Override // com.baidu.tieba.tt3
    public synchronized void d(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, downloadInfo) == null) {
            synchronized (this) {
                if (n()) {
                    o(downloadInfo);
                }
            }
        }
    }

    @Override // com.baidu.tieba.mt3.a
    public synchronized void e(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, downloadInfo) == null) {
            synchronized (this) {
                hv3.c(downloadInfo.getPath(), false);
                this.c.remove(downloadInfo.getId());
                this.d.remove(downloadInfo);
                q();
            }
        }
    }

    public final void o(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, downloadInfo) == null) {
            downloadInfo.setStatus(DownloadState.DOWNLOAD_PAUSED.value());
            this.c.remove(downloadInfo.getId());
            this.f.b(downloadInfo);
            q();
        }
    }

    public static synchronized tt3 m(Context context, jt3 jt3Var) {
        InterceptResult invokeLL;
        kt3 kt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, jt3Var)) == null) {
            synchronized (kt3.class) {
                if (k == null) {
                    k = new kt3(context, jt3Var);
                }
                kt3Var = k;
            }
            return kt3Var;
        }
        return (tt3) invokeLL.objValue;
    }

    public final void l(Context context, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, context, uri) == null) {
            BroadcastReceiver remove = this.i.remove(uri);
            if (remove != null) {
                context.unregisterReceiver(remove);
            }
            Timer remove2 = this.j.remove(uri);
            if (remove2 != null) {
                remove2.cancel();
            }
        }
    }

    @Override // com.baidu.tieba.tt3
    public synchronized void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
            synchronized (this) {
                if (downloadInfo == null) {
                    return;
                }
                downloadInfo.setStatus(DownloadState.DELETED.value());
                this.c.remove(downloadInfo.getId());
                this.d.remove(downloadInfo);
                this.g.d(downloadInfo);
                this.f.b(downloadInfo);
                new File(downloadInfo.getPath()).delete();
            }
        }
    }

    @Override // com.baidu.tieba.tt3
    public synchronized DownloadInfo g(String str) {
        InterceptResult invokeL;
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                downloadInfo = null;
                Iterator<DownloadInfo> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadInfo next = it.next();
                    if (next.getId().equals(str)) {
                        downloadInfo = next;
                        break;
                    }
                }
                if (downloadInfo == null) {
                    downloadInfo = this.g.c(str);
                }
            }
            return downloadInfo;
        }
        return (DownloadInfo) invokeL.objValue;
    }

    @Override // com.baidu.tieba.tt3
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                k();
                if (this.g != null) {
                    this.g.close();
                }
                if (this.b != null) {
                    this.b.shutdownNow();
                    this.b = null;
                }
                k = null;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Timer timer = new Timer();
            timer.schedule(new c(this, timer), 60000L);
        }
    }

    public synchronized boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                if (System.currentTimeMillis() - this.a > 500) {
                    this.a = System.currentTimeMillis();
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            for (DownloadInfo downloadInfo : this.d) {
                if (downloadInfo.getStatus() == DownloadState.WAIT.value()) {
                    p(downloadInfo);
                    return;
                }
            }
        }
    }

    @Override // com.baidu.tieba.tt3
    @AnyThread
    public synchronized void f(@NonNull String str, @NonNull Uri uri, @NonNull d<Boolean> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, uri, dVar) == null) {
            synchronized (this) {
                Context appContext = AppRuntime.getAppContext();
                if (hv3.a(appContext, str)) {
                    dVar.a(Boolean.TRUE);
                }
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction(PackageChangedReceiver.ACTION_INSTALL);
                a aVar = new a(this, str, dVar, uri);
                appContext.registerReceiver(aVar, intentFilter);
                Timer timer = new Timer();
                timer.schedule(new b(this, dVar, appContext, uri), 60000L);
                this.i.put(uri, aVar);
                this.j.put(uri, timer);
            }
        }
    }

    public final void p(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadInfo) == null) {
            if (this.c.size() >= this.h.b()) {
                downloadInfo.setStatus(DownloadState.WAIT.value());
                this.f.b(downloadInfo);
                return;
            }
            mt3 mt3Var = new mt3(this.b, this.f, downloadInfo, this);
            this.c.put(downloadInfo.getId(), mt3Var);
            downloadInfo.setStatus(DownloadState.PREPARE_DOWNLOAD.value());
            this.f.b(downloadInfo);
            mt3Var.c();
        }
    }
}

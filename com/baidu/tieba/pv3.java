package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.down.manage.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class pv3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DownloadManager a;

    /* loaded from: classes5.dex */
    public class a implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(pv3 pv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && download.getState() == Download.DownloadState.FINISH && pv3.j(download) && !tv3.h(AppRuntime.getAppContext(), download.getKeyByUser())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(pv3 pv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && download.getState() == Download.DownloadState.FINISH && tv3.h(AppRuntime.getAppContext(), download.getKeyByUser())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv3 a;

        public c(pv3 pv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pv3Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, download)) != null) {
                return invokeL.booleanValue;
            }
            return this.a.k(download);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pv3 a;

        public d(pv3 pv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pv3Var;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && !this.a.k(download)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public e(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getKeyByUser(), this.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public f(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getKeyByUser(), this.a) && download.getState() == Download.DownloadState.FINISH) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public g(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getKeyByUser(), this.a) && download.getState() == Download.DownloadState.FINISH) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pv3 b;

        public h(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pv3Var;
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getUrl(), this.a) && !this.b.k(download)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public i(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getKeyByUser(), this.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public j(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && download.getState() == Download.DownloadState.FINISH && download.getKeyByUser().contains(this.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public k(pv3 pv3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && TextUtils.equals(download.getUrl(), this.a)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements DownloadManager.DownloadItemFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public l(pv3 pv3Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pv3Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.down.manage.DownloadManager.DownloadItemFilter
        public boolean filter(Download download) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, download)) == null) {
                if (download != null && download.getState() == Download.DownloadState.FINISH && !tv3.h(this.a, download.getKeyByUser())) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public pv3(DownloadManager downloadManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {downloadManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = downloadManager;
    }

    public synchronized boolean b(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.a.getDownloadListByFilter(new i(this, str));
                if (downloadListByFilter != null) {
                    if (downloadListByFilter.size() > 0) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean c(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.a.getDownloadListByFilter(new j(this, str));
                if (downloadListByFilter != null) {
                    if (downloadListByFilter.size() > 0) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        h(r(str));
    }

    public final boolean l(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, download)) == null) {
            if (download == null || (System.currentTimeMillis() - new nv3(download).e()) / 86400000 < 30) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized Collection<Download> p(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            synchronized (this) {
                downloadListByFilter = this.a.getDownloadListByFilter(new g(this, str));
            }
            return downloadListByFilter;
        }
        return (Collection) invokeL.objValue;
    }

    public synchronized Collection<Download> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return this.a.getDownloadListByFilter(new h(this, str));
            }
        }
        return (Collection) invokeL.objValue;
    }

    public synchronized Collection<Download> r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return this.a.getDownloadListByFilter(new k(this, str));
            }
        }
        return (Collection) invokeL.objValue;
    }

    public Collection<Download> s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.a.getDownloadListByFilter(new f(this, str));
        }
        return (Collection) invokeL.objValue;
    }

    public Download v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            Collection<Download> q = q(str);
            Download download = null;
            if (q == null) {
                return null;
            }
            for (Download download2 : q) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public Download u(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            Download v = v(str);
            if (v == null) {
                return o(str2);
            }
            return v;
        }
        return (Download) invokeLL.objValue;
    }

    public static boolean j(Download download) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, download)) == null) {
            if (download == null) {
                return false;
            }
            String realDownloadDir = download.getRealDownloadDir();
            String fileName = download.getFileName();
            if (TextUtils.isEmpty(realDownloadDir) || TextUtils.isEmpty(fileName)) {
                return false;
            }
            File file = new File(realDownloadDir + File.separator + fileName);
            if (!file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized String i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                if (str.endsWith(".huawei")) {
                    return str.replace(".huawei", "");
                }
                if (str.endsWith(".mi")) {
                    return str.replace(".mi", "");
                }
                if (str.endsWith(".nearme.gamecenter")) {
                    return str.replace(".nearme.gamecenter", "");
                }
                if (str.endsWith(".vivo")) {
                    return str.replace(".vivo", "");
                }
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.a.getDownloadListByFilter(new b(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 30;
                if (size <= 0) {
                    return;
                }
                int i2 = 0;
                for (Download download : downloadListByFilter) {
                    if (i2 == size) {
                        return;
                    }
                    if (download != null) {
                        this.a.cancel(download.getId().longValue());
                    }
                    i2++;
                }
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                Collection<Download> downloadListByFilter = this.a.getDownloadListByFilter(new a(this));
                if (downloadListByFilter == null) {
                    return;
                }
                int size = downloadListByFilter.size() - 20;
                if (size <= 0) {
                    return;
                }
                int i2 = 0;
                for (Download download : downloadListByFilter) {
                    if (i2 == size) {
                        return;
                    }
                    if (download != null) {
                        this.a.cancel(download.getId().longValue());
                    }
                    i2++;
                }
            }
        }
    }

    public void m() {
        Collection<Download> n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (n = n()) != null && !n.isEmpty()) {
            for (Download download : n) {
                if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.DOWNLOADING)) {
                    this.a.pause(download.getId().longValue());
                }
            }
        }
    }

    public Collection<Download> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Collection<Download> n = n();
            if (n != null && !n.isEmpty()) {
                for (Download download : n) {
                    if (download != null && (download.getState() == Download.DownloadState.WAITING || download.getState() == Download.DownloadState.PAUSE)) {
                        this.a.resume(download.getId().longValue());
                    }
                }
                return n;
            }
            return null;
        }
        return (Collection) invokeV.objValue;
    }

    public synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                h(this.a.getDownloadListByFilter(new c(this)));
            }
        }
    }

    public Collection<Download> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a.getDownloadListByFilter(new d(this));
        }
        return (Collection) invokeV.objValue;
    }

    public synchronized Collection<Download> t() {
        InterceptResult invokeV;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                downloadListByFilter = this.a.getDownloadListByFilter(new l(this, AppRuntime.getAppContext()));
            }
            return downloadListByFilter;
        }
        return (Collection) invokeV.objValue;
    }

    public void h(Collection<Download> collection) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, collection) != null) || collection == null) {
            return;
        }
        for (Download download : collection) {
            if (download != null) {
                this.a.cancel(download.getId().longValue());
            }
        }
    }

    public final boolean k(Download download) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, download)) == null) {
            if (download == null) {
                return false;
            }
            if (download.getState() == Download.DownloadState.FINISH && !j(download)) {
                z = true;
            } else {
                z = false;
            }
            if ((!l(download) && !z) || tv3.h(AppRuntime.getAppContext(), download.getKeyByUser())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public Download o(String str) {
        InterceptResult invokeL;
        Collection<Download> downloadListByFilter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            Download download = null;
            if (TextUtils.isEmpty(str) || (downloadListByFilter = this.a.getDownloadListByFilter(new e(this, str))) == null) {
                return null;
            }
            for (Download download2 : downloadListByFilter) {
                if (download2 != null) {
                    download = download2;
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }

    public Download w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            Collection<Download> s = s(str);
            Download download = null;
            if (s != null && s.size() != 0) {
                Iterator<Download> it = s.iterator();
                while (it.hasNext()) {
                    download = it.next();
                }
            }
            return download;
        }
        return (Download) invokeL.objValue;
    }
}

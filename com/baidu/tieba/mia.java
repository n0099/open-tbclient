package com.baidu.tieba;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.util.AdApkInstallHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class mia {
    public static /* synthetic */ Interceptable $ic;
    public static mia c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public static List<oe7> f;
    public static HashMap<String, Integer> g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public HashMap<String, oia> b;

    /* loaded from: classes7.dex */
    public class a extends nu5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public a(mia miaVar, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {miaVar, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.nu5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.a.getId() + "_" + this.a.getName() + ".tmp";
                File externalPrivateFile = FileHelper.getExternalPrivateFile(str);
                if (externalPrivateFile == null) {
                    externalPrivateFile = FileHelper.GetFileInCache(str);
                }
                FileHelper.deleteFileOrDir(externalPrivateFile);
                if (StringUtils.isNotNull(this.a.getId())) {
                    FileHelper.deleteFileOrDir(FileHelper.getExternalPrivateFile(this.a.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements st5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public b(mia miaVar, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {miaVar, downloadData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = downloadData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.a.getName()));
                List<oe7> g = lia.i().g();
                if (!ListUtils.isEmpty(g)) {
                    this.a.setStatus(6);
                    this.a.setStatusMsg(null);
                    for (int i = 0; i < g.size(); i++) {
                        g.get(i).d(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public oe7 a;
        public final /* synthetic */ mia b;

        public c(mia miaVar, oe7 oe7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {miaVar, oe7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = miaVar;
            this.a = oe7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DownloadData doInBackground(DownloadData... downloadDataArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, downloadDataArr)) == null) {
                DownloadData downloadData = downloadDataArr[0];
                if (downloadData == null) {
                    return downloadData;
                }
                String id = downloadData.getId();
                String name = downloadData.getName();
                if (!rd.isEmpty(id) && !rd.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                    String m = mia.m(str);
                    File externalPrivateFile = FileHelper.getExternalPrivateFile(str);
                    if (!isForceDownload && externalPrivateFile != null) {
                        ApkDownloadData apkDownloadData = downloadData.getApkDownloadData();
                        int source = downloadData.getSource();
                        DownloadData downloadData2 = new DownloadData(id);
                        downloadData2.setPath(m);
                        downloadData2.setSource(source);
                        downloadData2.setApkDownloadData(apkDownloadData);
                        downloadData2.setStatus(3);
                        return downloadData2;
                    }
                    downloadData.setCallback(new rd5());
                    downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                    downloadData.setType(12);
                    downloadData.setPath(m);
                    return downloadData;
                }
                return downloadData;
            }
            return (DownloadData) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                super.onPostExecute(downloadData);
                this.b.a = null;
                if (downloadData != null) {
                    if (downloadData.getStatus() == 3) {
                        this.b.x(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            AdApkInstallHelper.a(mia.m(downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX), downloadData);
                        }
                    } else {
                        lia.i().l(downloadData, this.a);
                        if (this.b.l(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                                oia oiaVar = new oia(downloadData, 0);
                                this.b.b.put(downloadData.getUrl(), oiaVar);
                                Application app = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.b.j(downloadData.getAction()), false, oiaVar.b(), false);
                            }
                        } else if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                    }
                    DownloadData unused = mia.d = null;
                    if (!mia.e.isEmpty()) {
                        mia.e.remove(0);
                        if (!mia.f.isEmpty()) {
                            mia.f.remove(0);
                        }
                        this.b.z();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947975012, "Lcom/baidu/tieba/mia;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947975012, "Lcom/baidu/tieba/mia;");
                return;
            }
        }
        e = new LinkedList();
        f = new LinkedList();
        g = new HashMap<>();
    }

    public mia() {
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
        this.a = null;
        this.b = new HashMap<>();
    }

    public static mia o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (mia.class) {
                if (c == null) {
                    c = new mia();
                }
            }
            return c;
        }
        return (mia) invokeV.objValue;
    }

    public void h(oe7 oe7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oe7Var) == null) {
            lia.i().e(oe7Var);
        }
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            TbadkApplication inst = TbadkApplication.getInst();
            if (inst == null) {
                return false;
            }
            try {
                if (inst.getPackageManager() == null) {
                    return false;
                }
                inst.getPackageManager().getPackageInfo(str, 64);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void w(oe7 oe7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, oe7Var) == null) {
            lia.i().j(oe7Var);
        }
    }

    public void x(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public static String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(FileHelper.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static Integer p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (g.containsKey(str)) {
                return g.get(str);
            }
            Integer valueOf = Integer.valueOf(BdUniqueId.gen().getId());
            g.put(str, valueOf);
            return valueOf;
        }
        return (Integer) invokeL.objValue;
    }

    public final PendingIntent j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent intent = new Intent(str);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
        }
        return (PendingIntent) invokeL.objValue;
    }

    public void k(DownloadData downloadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
            return;
        }
        lia i = lia.i();
        String url = downloadData.getUrl();
        if (downloadData.getItemData() != null) {
            str = downloadData.getItemData().pkgName;
        } else {
            str = "";
        }
        i.f(url, true, str);
        ru5.b(new a(this, downloadData), new b(this, downloadData));
    }

    public boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            for (DownloadData downloadData : lia.i().h()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (FileHelper.getExternalPrivateFile(str.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            for (DownloadData downloadData : lia.i().h()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int q(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, downloadData)) == null) {
            if (o().u(downloadData.getId())) {
                i = 3;
            } else if (o().s(downloadData.getId())) {
                i = 5;
            } else if (o().v(downloadData.getId())) {
                i = 1;
            } else if (o().r(downloadData.getId(), downloadData.getName())) {
                i = 7;
            } else {
                i = 6;
            }
            DownloadStaticsData downloadStaticsData = downloadData.getDownloadStaticsData();
            if (downloadStaticsData != null) {
                id = downloadStaticsData.getApk_name();
            } else {
                id = downloadData.getId();
            }
            if (TextUtils.isEmpty(id)) {
                return i;
            }
            if (e06.a().k() && o().t(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void i(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) != null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : lia.i().h()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        lia.i().f(str, false, str3);
        if (downloadData != null && downloadData.isNeedNotify()) {
            int l = l(downloadData.getId(), downloadData.getName());
            String str4 = l + "%";
            if (downloadData != null && l >= 0) {
                oia oiaVar = this.b.get(downloadData.getUrl());
                if (oiaVar == null) {
                    oiaVar = new oia(downloadData, l);
                }
                oiaVar.d();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str4, downloadData.getUser_name(), j(downloadData.getAction()), false, oiaVar.b(), false);
            }
        }
    }

    public int l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            long n = n(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (n > j) {
                return 0;
            }
            return (int) ((n * 100) / j);
        }
        return invokeLL.intValue;
    }

    public long n(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String str3 = str + "_" + str2 + ".tmp";
            File externalPrivateFile = FileHelper.getExternalPrivateFile(str3);
            if (externalPrivateFile == null) {
                externalPrivateFile = FileHelper.GetFileInCache(str3);
            }
            if (externalPrivateFile != null && externalPrivateFile.exists() && externalPrivateFile.isFile()) {
                return externalPrivateFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
                return false;
            }
            String str3 = str + "_" + str2 + ".tmp";
            File externalPrivateFile = FileHelper.getExternalPrivateFile(str3);
            if (externalPrivateFile == null) {
                externalPrivateFile = FileHelper.GetFileInCache(str3);
            }
            if (externalPrivateFile == null || !externalPrivateFile.exists() || !externalPrivateFile.isFile()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean y(DownloadData downloadData, oe7 oe7Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, downloadData, oe7Var)) == null) {
            if (downloadData == null) {
                return false;
            }
            List<DownloadData> h = lia.i().h();
            if (h != null && h.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                x(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return false;
            }
            e.add(downloadData);
            f.add(oe7Var);
            z();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && d == null && !e.isEmpty() && !f.isEmpty()) {
            DownloadData downloadData = e.get(0);
            d = downloadData;
            if (downloadData != null) {
                c cVar = new c(this, f.get(0));
                this.a = cVar;
                cVar.setPriority(3);
                this.a.execute(d);
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.filedownloader.data.ApkDownloadData;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
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
/* loaded from: classes5.dex */
public class io8 {
    public static /* synthetic */ Interceptable $ic;
    public static io8 c;
    public static DownloadData d;
    public static List<DownloadData> e;
    public static List<tk6> f;
    public static HashMap<String, Integer> g;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public HashMap<String, ko8> b;

    /* loaded from: classes5.dex */
    public class a extends zk5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public a(io8 io8Var, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io8Var, downloadData};
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
        @Override // com.baidu.tieba.zk5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String str = this.a.getId() + "_" + this.a.getName() + ".tmp";
                File GetFile = FileHelper.GetFile(str);
                if (GetFile == null) {
                    GetFile = FileHelper.GetFileInCache(str);
                }
                FileHelper.deleteFileOrDir(GetFile);
                if (StringUtils.isNotNull(this.a.getId())) {
                    FileHelper.deleteFileOrDir(FileHelper.GetFile(this.a.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX));
                }
                return Boolean.TRUE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements dk5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DownloadData a;

        public b(io8 io8Var, DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io8Var, downloadData};
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
        @Override // com.baidu.tieba.dk5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921626, this.a.getName()));
                LinkedList linkedList = new LinkedList();
                this.a.setStatus(6);
                this.a.setStatusMsg(null);
                linkedList.add(this.a);
                MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BdAsyncTask<DownloadData, DownloadData, DownloadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public tk6 a;
        public final /* synthetic */ io8 b;

        public c(io8 io8Var, tk6 tk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {io8Var, tk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = io8Var;
            this.a = tk6Var;
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
                if (!yi.isEmpty(id) && !yi.isEmpty(name)) {
                    boolean isForceDownload = downloadData.isForceDownload();
                    String str = id.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX;
                    String l = io8.l(str);
                    File GetFile = FileHelper.GetFile(str);
                    if (!isForceDownload && GetFile != null) {
                        ApkDownloadData apkDownloadData = downloadData.getApkDownloadData();
                        int source = downloadData.getSource();
                        DownloadData downloadData2 = new DownloadData(id);
                        downloadData2.setPath(l);
                        downloadData2.setSource(source);
                        downloadData2.setApkDownloadData(apkDownloadData);
                        downloadData2.setStatus(3);
                        return downloadData2;
                    }
                    downloadData.setCallback(new q65());
                    downloadData.setStatusMsg(TbadkCoreApplication.getCurrentAccount());
                    downloadData.setType(12);
                    downloadData.setPath(l);
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
                        this.b.v(downloadData);
                        if (downloadData.isNeedInvokeApk()) {
                            if (downloadData.getApkDownloadData() != null) {
                                oq4.c().a(downloadData.getApkDownloadData().getPackageName(), downloadData.getName(), Integer.toString(downloadData.getSource()), downloadData.getUrl());
                            }
                            Application app = TbadkCoreApplication.getInst().getApp();
                            UtilHelper.install_apk(app, downloadData.getId().replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
                        }
                    } else {
                        ho8.f().h(downloadData, this.a);
                        if (this.b.k(downloadData.getId(), downloadData.getName()) <= 0) {
                            if (downloadData.getDownloadStaticsData() != null) {
                                downloadData.getDownloadStaticsData().setDa_range("0");
                            }
                            if (downloadData.isNeedNotify()) {
                                String string = TbadkCoreApplication.getInst().getApp().getResources().getString(R.string.download_will_begin);
                                ko8 ko8Var = new ko8(downloadData, 0);
                                this.b.b.put(downloadData.getUrl(), ko8Var);
                                Application app2 = TbadkCoreApplication.getInst().getApp();
                                int notifyId = downloadData.getNotifyId();
                                NotificationHelper.showProgressNotification(app2, notifyId, downloadData.getUser_name() + string, 0, string, downloadData.getUser_name(), this.b.i(downloadData.getAction()), false, ko8Var.b(), false);
                            }
                        } else if (downloadData.getDownloadStaticsData() != null) {
                            downloadData.getDownloadStaticsData().setDa_range("1");
                        }
                    }
                    DownloadData unused = io8.d = null;
                    if (!io8.e.isEmpty()) {
                        io8.e.remove(0);
                        if (!io8.f.isEmpty()) {
                            io8.f.remove(0);
                        }
                        this.b.x();
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947860343, "Lcom/baidu/tieba/io8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947860343, "Lcom/baidu/tieba/io8;");
                return;
            }
        }
        e = new LinkedList();
        f = new LinkedList();
        g = new HashMap<>();
    }

    public io8() {
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

    public static io8 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            synchronized (io8.class) {
                if (c == null) {
                    c = new io8();
                }
            }
            return c;
        }
        return (io8) invokeV.objValue;
    }

    public void j(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData) != null) || downloadData == null) {
            return;
        }
        ho8.f().d(downloadData.getUrl(), true);
        dl5.b(new a(this, downloadData), new b(this, downloadData));
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
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

    public void v(DownloadData downloadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadData) == null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(downloadData);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
        }
    }

    public static String l(String str) {
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

    public static Integer o(String str) {
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

    public final PendingIntent i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
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

    public boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            for (DownloadData downloadData : ho8.f().e()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (FileHelper.GetFile(str.replace(".", "_") + Constant.FILE.SUFFIX.BUNDLE_SUFFIX) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            for (DownloadData downloadData : ho8.f().e()) {
                if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int p(DownloadData downloadData) {
        InterceptResult invokeL;
        int i;
        String id;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, downloadData)) == null) {
            if (n().t(downloadData.getId())) {
                i = 3;
            } else if (n().r(downloadData.getId())) {
                i = 5;
            } else if (n().u(downloadData.getId())) {
                i = 1;
            } else if (n().q(downloadData.getId(), downloadData.getName())) {
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
            if (aq5.a().l() && n().s(id)) {
                return 8;
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, str2) != null) || StringUtils.isNull(str)) {
            return;
        }
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : ho8.f().e()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        ho8.f().d(str, false);
        if (downloadData != null) {
            int k = k(downloadData.getId(), downloadData.getName());
            String str3 = k + "%";
            if (downloadData != null && k >= 0) {
                ko8 ko8Var = this.b.get(downloadData.getUrl());
                if (ko8Var == null) {
                    ko8Var = new ko8(downloadData, k);
                }
                ko8Var.d();
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), null, 0, str3, downloadData.getUser_name(), i(downloadData.getAction()), false, ko8Var.b(), false);
            }
        }
    }

    public int k(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            long m = m(str, str2);
            long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
            if (0 == j) {
                return -1;
            }
            if (m > j) {
                return 0;
            }
            return (int) ((m * 100) / j);
        }
        return invokeLL.intValue;
    }

    public long m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile != null && GetFile.exists() && GetFile.isFile()) {
                return GetFile.length();
            }
            return -1L;
        }
        return invokeLL.longValue;
    }

    public boolean q(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
                return false;
            }
            String str3 = str + "_" + str2 + ".tmp";
            File GetFile = FileHelper.GetFile(str3);
            if (GetFile == null) {
                GetFile = FileHelper.GetFileInCache(str3);
            }
            if (GetFile == null || !GetFile.exists() || !GetFile.isFile()) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean w(DownloadData downloadData, tk6 tk6Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, downloadData, tk6Var)) == null) {
            if (downloadData == null) {
                return false;
            }
            List<DownloadData> e2 = ho8.f().e();
            if (e2 != null && e2.size() >= 5) {
                downloadData.setStatus(2);
                downloadData.setStatusMsg(TbadkCoreApplication.getInst().getApp().getString(R.string.download_fail_over_max));
                v(downloadData);
                UtilHelper.showToast(TbadkCoreApplication.getInst(), (int) R.string.download_fail_over_max);
                return false;
            }
            e.add(downloadData);
            f.add(tk6Var);
            x();
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && d == null && !e.isEmpty() && !f.isEmpty()) {
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

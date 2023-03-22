package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class qc6 extends BdAsyncTask<Void, Void, uc6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final h09 b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public NetWork g;

    public qc6(String str, h09 h09Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, h09Var, Boolean.valueOf(z)};
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
        this.b = h09Var;
        this.d = h09Var.c();
        this.c = this.b.a();
        this.e = this.b.b();
        this.f = z;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(mc6.g + "bdtbWCacheTemp/" + str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public uc6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        HashMap<String, vc6> hashMap;
        ?? r3;
        FileInputStream fileInputStream;
        String b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            b(this.a);
            rc6.a(this.a);
            if (this.f) {
                if (!TextUtils.isEmpty(mc6.h().i(this.a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.g = netWork;
            netWork.setUrl(this.c);
            new File(mc6.g + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
            String str = mc6.g + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
            boolean downloadFile = this.g.downloadFile(str, null, 0, 3, 0, true);
            pd6.b("lt-log", "[new]download result :" + downloadFile);
            if (downloadFile) {
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1");
                TiebaStatic.log(param);
                try {
                    try {
                        fileInputStream = new FileInputStream(str);
                        try {
                            b = oi.b(fileInputStream);
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            pd6.b("lt-log", "[new]md5 check result : false");
                            ii.e(fileInputStream);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        r3 = param;
                        ii.e(r3);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    r3 = 0;
                    ii.e(r3);
                    throw th;
                }
                if (!StringUtils.isNull(b) && b.toLowerCase().equals(this.e.toLowerCase())) {
                    ii.e(fileInputStream);
                    pd6.b("lt-log", "[new]md5 check result : true");
                    String str2 = mc6.g + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                    new File(str2).mkdirs();
                    boolean k = wd6.k(str, str2);
                    pd6.b("lt-log", "[new]upZipResult result:" + k + ",desFilePath=" + str);
                    if (k) {
                        String str3 = mc6.g + "bdtbNWCache/" + this.a + "/" + this.d + "/";
                        new File(str3).mkdirs();
                        boolean j = wd6.j(str2, str3);
                        pd6.b("lt-log", "[new]copyResult :" + j);
                        if (!j) {
                            wd6.f(str3);
                            b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "write error");
                        }
                    } else {
                        wd6.f(str2);
                        b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "unzip error");
                    }
                } else {
                    b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "md5 error");
                    b(this.a);
                    pd6.b("lt-log", "[new]md5 check result : false");
                    ii.e(fileInputStream);
                    return null;
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "download error");
            }
            b(this.a);
            uc6 c = rc6.c(this.a, this.d);
            if (c != null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                rc6.b(c.c, this.a);
                return c;
            }
            b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
            rc6.a(this.a);
            return null;
        }
        return (uc6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(uc6 uc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uc6Var) == null) {
            super.onPostExecute(uc6Var);
            if (uc6Var != null) {
                mc6.h().u(this.a, uc6Var.c);
                mc6.h().s();
                pc6.b().m(this.a, uc6Var.b);
                pc6.b().i(true, this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", uc6Var.c));
            } else {
                mc6.h().e(this.a);
                mc6.h().s();
                pc6.b().g(this.a);
            }
            lc6.b(uc6Var, this.a);
            mc6.h().r(this.a);
        }
    }
}

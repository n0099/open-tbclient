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
import java.io.InputStream;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class t66 extends BdAsyncTask<Void, Void, x66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final s66 b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public NetWork g;

    public t66(String str, s66 s66Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, s66Var, Boolean.valueOf(z)};
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
        this.b = s66Var;
        this.d = s66Var.c();
        this.c = this.b.a();
        this.e = this.b.b();
        this.f = z;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(n66.f + "bdtbWCacheTemp/" + str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x66 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        x66 c;
        HashMap<String, r66> hashMap;
        InputStream inputStream;
        FileInputStream fileInputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            b(this.a);
            u66.a(this.a);
            if (this.f) {
                if (!TextUtils.isEmpty(n66.h().i(this.a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.g = netWork;
            netWork.setUrl(this.c);
            new File(n66.f + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
            String str2 = n66.f + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
            if (this.g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            String b = gj.b(fileInputStream);
                            if (StringUtils.isNull(b) || !b.toLowerCase().equals(this.e.toLowerCase())) {
                                ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "md5 error");
                                b(this.a);
                                aj.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            aj.e(fileInputStream);
                            str = n66.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                            new File(str).mkdirs();
                            if (!ky4.b(str2, str)) {
                            }
                            b(this.a);
                            c = u66.c(this.a, this.d);
                            if (c == null) {
                            }
                            ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
                            u66.a(this.a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = "obj_type";
                        aj.e(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    aj.e(inputStream);
                    throw th;
                }
                aj.e(fileInputStream);
                str = n66.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                new File(str).mkdirs();
                if (!ky4.b(str2, str)) {
                    String str3 = n66.f + "bdtbNWCache/" + this.a + "/" + this.d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "write error");
                    }
                } else {
                    ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "unzip error");
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "download error");
            }
            b(this.a);
            c = u66.c(this.a, this.d);
            if (c == null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                u66.b(c.c, this.a);
                return c;
            }
            ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
            u66.a(this.a);
            return null;
        }
        return (x66) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(x66 x66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x66Var) == null) {
            super.onPostExecute(x66Var);
            if (x66Var != null) {
                n66.h().q(this.a, x66Var.c);
                n66.h().o();
                q66.a().j(this.a, x66Var.b);
                q66.a().f(true, this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", x66Var.c));
                return;
            }
            n66.h().e(this.a);
            n66.h().o();
            q66.a().d(this.a);
        }
    }
}

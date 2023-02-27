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
/* loaded from: classes5.dex */
public class md6 extends BdAsyncTask<Void, Void, qd6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final ev8 b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public NetWork g;

    public md6(String str, ev8 ev8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ev8Var, Boolean.valueOf(z)};
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
        this.b = ev8Var;
        this.d = ev8Var.c();
        this.c = this.b.a();
        this.e = this.b.b();
        this.f = z;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(hd6.f + "bdtbWCacheTemp/" + str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01b9  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public qd6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        qd6 c;
        HashMap<String, ld6> hashMap;
        InputStream inputStream;
        FileInputStream fileInputStream;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            b(this.a);
            nd6.a(this.a);
            if (this.f) {
                if (!TextUtils.isEmpty(hd6.h().i(this.a))) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", this.d));
                }
                return null;
            }
            NetWork netWork = new NetWork();
            this.g = netWork;
            netWork.setUrl(this.c);
            new File(hd6.f + "bdtbWCacheTemp/" + this.a + "/").mkdirs();
            String str2 = hd6.f + "bdtbWCacheTemp/" + this.a + "/bdtbNWCache.zip";
            if (this.g.downloadFile(str2, null, 0, 3, 0, true)) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "1"));
                try {
                    try {
                        fileInputStream = new FileInputStream(str2);
                        try {
                            String b = lj.b(fileInputStream);
                            if (StringUtils.isNull(b) || !b.toLowerCase().equals(this.e.toLowerCase())) {
                                q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "md5 error");
                                b(this.a);
                                fj.e(fileInputStream);
                                return null;
                            }
                        } catch (FileNotFoundException e) {
                            e = e;
                            e.printStackTrace();
                            fj.e(fileInputStream);
                            str = hd6.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                            new File(str).mkdirs();
                            if (!j45.b(str2, str)) {
                            }
                            b(this.a);
                            c = nd6.c(this.a, this.d);
                            if (c == null) {
                            }
                            q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
                            nd6.a(this.a);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream = "obj_type";
                        fj.e(inputStream);
                        throw th;
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    fj.e(inputStream);
                    throw th;
                }
                fj.e(fileInputStream);
                str = hd6.f + "bdtbWCacheTemp/" + this.a + "/" + this.d + "/";
                new File(str).mkdirs();
                if (!j45.b(str2, str)) {
                    String str3 = hd6.f + "bdtbNWCache/" + this.a + "/" + this.d + "/";
                    new File(str3).mkdirs();
                    if (!FileHelper.CopyDir(str, str3, true)) {
                        q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "write error");
                    }
                } else {
                    q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "unzip error");
                }
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_H5_OFFLINE_PACKAGE_DOWNLOAD).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_type", "2"));
                q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "download error");
            }
            b(this.a);
            c = nd6.c(this.a, this.d);
            if (c == null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                nd6.b(c.c, this.a);
                return c;
            }
            q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", this.a, "hybridVersion", this.d, "hybridResult", "bundle incomplete");
            nd6.a(this.a);
            return null;
        }
        return (qd6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(qd6 qd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qd6Var) == null) {
            super.onPostExecute(qd6Var);
            if (qd6Var != null) {
                hd6.h().r(this.a, qd6Var.c);
                hd6.h().p();
                kd6.a().j(this.a, qd6Var.b);
                kd6.a().f(true, this.a);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_UPDATE_OFFLINE_PACK).param("obj_name", this.a).param("obj_id", qd6Var.c));
                return;
            }
            hd6.h().e(this.a);
            hd6.h().p();
            kd6.a().d(this.a);
        }
    }
}

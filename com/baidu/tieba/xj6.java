package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.util.DownloadErrorLogger;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
/* loaded from: classes8.dex */
public class xj6 extends BdAsyncTask<Void, Void, vj6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public xj6(String str, ow9 ow9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, ow9Var};
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
        this.c = ow9Var.c();
        this.b = ow9Var.a();
        this.d = ow9Var.b();
    }

    public static void c(String str, ow9 ow9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, ow9Var) == null) {
            xj6 xj6Var = new xj6(str, ow9Var);
            xj6Var.setPriority(4);
            xj6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public vj6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        vj6 vj6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(rj6.n().o(), this.a);
            HybridLog.getInstance().e("Offline", "离线包开始下载：" + this.a + " 目录：" + file);
            if (!hl6.a(file)) {
                dl6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                hl6.c(file2);
                dl6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                rj6.w("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, il6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!gl6.d(file2, this.d)) {
                hl6.c(file2);
                dl6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                rj6.w("download bundle", "md5_error", this.a, this.c, il6.a(Pair.create("detail", this.d + "_" + gl6.b(file2))));
                return null;
            } else {
                File file3 = new File(rj6.n().m(), this.a);
                if (!e(file2, file3, this.c)) {
                    rj6.w("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, ak6> b = yj6.b(file4);
                if (yj6.f(file4, b)) {
                    vj6Var = new vj6(file4, this.c, b);
                } else {
                    vj6Var = null;
                }
                if (vj6Var != null && vj6Var.c()) {
                    rj6.j(rj6.n().m(), this.c, this.a);
                    rj6.j(rj6.n().o(), this.c + ".zip", this.a);
                    return vj6Var;
                }
                hl6.b(file4);
                dl6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (vj6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(vj6 vj6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vj6Var) == null) {
            super.onPostExecute(vj6Var);
            if (vj6Var != null) {
                rj6.n().y(this.a, vj6Var.b());
                rj6.n().v();
                sj6.e().k(this.a, vj6Var.a());
                sj6.e().c(this.a);
                rj6.w("download bundle", "success", this.a, vj6Var.b(), "");
            } else {
                rj6.n().i(this.a);
                rj6.n().v();
                sj6.e().i(this.a);
            }
            qj6.b(vj6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    ll6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    hl6.b(file2);
                    dl6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

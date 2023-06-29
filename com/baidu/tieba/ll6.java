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
/* loaded from: classes6.dex */
public class ll6 extends BdAsyncTask<Void, Void, jl6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public ll6(String str, or9 or9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, or9Var};
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
        this.c = or9Var.c();
        this.b = or9Var.a();
        this.d = or9Var.b();
    }

    public static void c(String str, or9 or9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, or9Var) == null) {
            ll6 ll6Var = new ll6(str, or9Var);
            ll6Var.setPriority(4);
            ll6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public jl6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        jl6 jl6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(fl6.n().o(), this.a);
            HybridLog.getInstance().b("Offline", "离线包开始下载：" + this.a + " 目录：" + file);
            if (!vm6.a(file)) {
                rm6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                vm6.c(file2);
                rm6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                fl6.w("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, wm6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!um6.d(file2, this.d)) {
                vm6.c(file2);
                rm6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                fl6.w("download bundle", "md5_error", this.a, this.c, wm6.a(Pair.create("detail", this.d + "_" + um6.b(file2))));
                return null;
            } else {
                File file3 = new File(fl6.n().m(), this.a);
                if (!e(file2, file3, this.c)) {
                    fl6.w("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, ol6> b = ml6.b(file4);
                if (ml6.f(file4, b)) {
                    jl6Var = new jl6(file4, this.c, b);
                } else {
                    jl6Var = null;
                }
                if (jl6Var != null && jl6Var.c()) {
                    fl6.j(fl6.n().m(), this.c, this.a);
                    fl6.j(fl6.n().o(), this.c + ".zip", this.a);
                    return jl6Var;
                }
                vm6.b(file4);
                rm6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (jl6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(jl6 jl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jl6Var) == null) {
            super.onPostExecute(jl6Var);
            if (jl6Var != null) {
                fl6.n().y(this.a, jl6Var.b());
                fl6.n().v();
                gl6.e().k(this.a, jl6Var.a());
                gl6.e().c(this.a);
                fl6.w("download bundle", "success", this.a, jl6Var.b(), "");
            } else {
                fl6.n().i(this.a);
                fl6.n().v();
                gl6.e().i(this.a);
            }
            el6.b(jl6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    zm6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    vm6.b(file2);
                    rm6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

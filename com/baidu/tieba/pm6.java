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
/* loaded from: classes7.dex */
public class pm6 extends BdAsyncTask<Void, Void, nm6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public pm6(String str, vx9 vx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, vx9Var};
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
        this.c = vx9Var.c();
        this.b = vx9Var.a();
        this.d = vx9Var.b();
    }

    public static void c(String str, vx9 vx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, vx9Var) == null) {
            pm6 pm6Var = new pm6(str, vx9Var);
            pm6Var.setPriority(4);
            pm6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public nm6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        nm6 nm6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(jm6.n().o(), this.a);
            HybridLog.getInstance().b("Offline", "离线包开始下载：" + this.a + " 目录：" + file);
            if (!zn6.a(file)) {
                vn6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                zn6.c(file2);
                vn6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                jm6.w("download bundle", DownloadErrorLogger.LOGGER_SPACE, this.a, this.c, ao6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!yn6.d(file2, this.d)) {
                zn6.c(file2);
                vn6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                jm6.w("download bundle", "md5_error", this.a, this.c, ao6.a(Pair.create("detail", this.d + "_" + yn6.b(file2))));
                return null;
            } else {
                File file3 = new File(jm6.n().m(), this.a);
                if (!e(file2, file3, this.c)) {
                    jm6.w("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, sm6> b = qm6.b(file4);
                if (qm6.f(file4, b)) {
                    nm6Var = new nm6(file4, this.c, b);
                } else {
                    nm6Var = null;
                }
                if (nm6Var != null && nm6Var.c()) {
                    jm6.j(jm6.n().m(), this.c, this.a);
                    jm6.j(jm6.n().o(), this.c + ".zip", this.a);
                    return nm6Var;
                }
                zn6.b(file4);
                vn6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (nm6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(nm6 nm6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nm6Var) == null) {
            super.onPostExecute(nm6Var);
            if (nm6Var != null) {
                jm6.n().y(this.a, nm6Var.b());
                jm6.n().v();
                km6.e().k(this.a, nm6Var.a());
                km6.e().c(this.a);
                jm6.w("download bundle", "success", this.a, nm6Var.b(), "");
            } else {
                jm6.n().i(this.a);
                jm6.n().v();
                km6.e().i(this.a);
            }
            im6.b(nm6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    do6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    zn6.b(file2);
                    vn6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

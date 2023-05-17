package com.baidu.tieba;

import androidx.core.util.Pair;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Map;
/* loaded from: classes7.dex */
public class rg6 extends BdAsyncTask<Void, Void, pg6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;

    public rg6(String str, xe9 xe9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, xe9Var};
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
        this.c = xe9Var.c();
        this.b = xe9Var.a();
        this.d = xe9Var.b();
    }

    public static void c(String str, xe9 xe9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, xe9Var) == null) {
            rg6 rg6Var = new rg6(str, xe9Var);
            rg6Var.setPriority(4);
            rg6Var.execute(new Void[0]);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public pg6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean z;
        pg6 pg6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            File file = new File(lg6.l().m(), this.a);
            if (!ai6.a(file)) {
                wh6.b("newHybrid", "离线包下载失败：" + this.a + "->目录创建失败");
            }
            File file2 = new File(file, this.c + ".zip");
            if (!file2.exists()) {
                z = new NetWork(this.b).downloadFile(file2.getAbsolutePath(), null, 0, 3, 0, true);
            } else {
                z = true;
            }
            if (!z) {
                ai6.c(file2);
                wh6.b("newHybrid", "离线包下载失败:网络下载异常：" + this.a);
                lg6.t("download bundle", "download_error", this.a, this.c, bi6.a(Pair.create("error_code", "-1"), Pair.create(GameCodeGetResponseMsg.PARAM_ERROR_MSG, "网络下载错误")));
                return null;
            } else if (!zh6.d(file2, this.d)) {
                ai6.c(file2);
                wh6.b("newHybrid", "离线包目md5验证失败：" + this.a);
                lg6.t("download bundle", "md5_error", this.a, this.c, bi6.a(Pair.create("detail", this.d + "_" + zh6.b(file2))));
                return null;
            } else {
                File file3 = new File(lg6.l().k(), this.a);
                if (!e(file2, file3, this.c)) {
                    lg6.t("download bundle", "unzip_error", this.a, this.c, "");
                    return null;
                }
                File file4 = new File(file3, this.c);
                Map<String, ug6> b = sg6.b(file4);
                if (sg6.f(file4, b)) {
                    pg6Var = new pg6(file4, this.c, b);
                } else {
                    pg6Var = null;
                }
                if (pg6Var != null && pg6Var.c()) {
                    lg6.i(lg6.l().k(), this.c, this.a);
                    lg6.i(lg6.l().m(), this.c + ".zip", this.a);
                    return pg6Var;
                }
                ai6.b(file4);
                wh6.b("newHybrid", "离线包应用失败：" + this.a + "，path：" + file4.getAbsolutePath());
                return null;
            }
        }
        return (pg6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public void onPostExecute(pg6 pg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg6Var) == null) {
            super.onPostExecute(pg6Var);
            if (pg6Var != null) {
                lg6.l().v(this.a, pg6Var.b());
                lg6.l().s();
                mg6.d().j(this.a, pg6Var.a());
                mg6.d().c(this.a);
                lg6.t("download bundle", "success", this.a, pg6Var.b(), "");
            } else {
                lg6.l().h(this.a);
                lg6.l().s();
                mg6.d().h(this.a);
            }
            kg6.b(pg6Var, this.a);
        }
    }

    public final boolean e(File file, File file2, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, file, file2, str)) == null) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                try {
                    ei6.c(file, file3);
                    return true;
                } catch (UnzipErrorException e) {
                    ai6.b(file2);
                    wh6.b("newHybrid", "离线包资源解压缩失败：" + e);
                    return false;
                }
            }
            return true;
        }
        return invokeLLL.booleanValue;
    }
}

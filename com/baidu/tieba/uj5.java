package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class uj5 extends BdAsyncTask<Void, Void, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public NetWork c;
    public a d;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, String str);
    }

    public uj5(String str, String str2, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, aVar};
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
        this.b = str2;
        this.d = aVar;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            try {
                return file.mkdirs();
            } catch (Exception e) {
                TiebaStatic.file(e, dj.join("FileHelper", ".", "CheckTempDir", " ", str));
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || dj.isEmpty(str)) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
            if (dj.isEmpty(this.a) || dj.isEmpty(this.b) || !b(this.a)) {
                return null;
            }
            String c = lj.c(this.b);
            String str = this.a + c + "/";
            if (e(str)) {
                return c;
            }
            NetWork netWork = new NetWork();
            this.c = netWork;
            netWork.setUrl(this.b);
            String str2 = this.a + c + ".zip";
            if (this.c.downloadFile(str2, null, 0, 3, 0, true) && f(str2, str)) {
                c(str2);
                return c;
            }
            c(str2);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (dj.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || file.list() == null || file.list().length <= 0) {
                file.delete();
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
            if (dj.isEmpty(str) || dj.isEmpty(str2)) {
                return false;
            }
            return gw4.b(str, str2);
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.d == null) {
            return;
        }
        if (!dj.isEmpty(str)) {
            this.d.a(true, str);
        } else {
            this.d.a(false, null);
        }
    }
}

package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k17 extends BdAsyncTask<Void, Void, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final a c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    @JvmOverloads
    public k17(String dataPath, String desPath, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataPath, desPath, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(dataPath, "dataPath");
        Intrinsics.checkNotNullParameter(desPath, "desPath");
        this.a = dataPath;
        this.b = desPath;
        this.c = aVar;
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            super.onPostExecute(Boolean.valueOf(z));
            a aVar = this.c;
            if (aVar != null) {
                aVar.a(z);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        b(bool.booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean doInBackground(Void... params) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, params)) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            d85.c(new File(this.a), this.b);
            boolean z = false;
            try {
                d85.c(new File(this.a), this.b);
                z = true;
            } catch (ZipException e) {
                BdLog.e(e);
            } catch (IOException e2) {
                BdLog.e(e2);
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }
}

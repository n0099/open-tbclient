package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class py5 extends BdAsyncTask<Void, String, String> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public ly5 b;
    public String c;

    public py5(String str, int i, ly5 ly5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), ly5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = ly5Var;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public String doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            String str = this.c;
            if (str == null) {
                return null;
            }
            return c(str);
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:13:0x0028 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x0036 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0009 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (String) invokeL.objValue;
        }
        ?? isEmpty = TextUtils.isEmpty(str);
        String str2 = null;
        str2 = null;
        str2 = null;
        InputStream inputStream = null;
        try {
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (isEmpty != 0) {
                return null;
            }
            try {
                isEmpty = new FileInputStream(str);
                try {
                    byte[] bArr = new byte[isEmpty.available()];
                    isEmpty.read(bArr);
                    str2 = Base64.encodeToString(bArr, 0);
                    isEmpty.close();
                    isEmpty = isEmpty;
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    if (isEmpty != 0) {
                        isEmpty.close();
                        isEmpty = isEmpty;
                    }
                    return str2;
                }
            } catch (Exception e3) {
                e = e3;
                isEmpty = 0;
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            inputStream = isEmpty;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            super.onPostExecute((py5) str);
            ly5 ly5Var = this.b;
            if (ly5Var == null || str == null) {
                return;
            }
            ly5Var.a("", this.a, str);
        }
    }
}

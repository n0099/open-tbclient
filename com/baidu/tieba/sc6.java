package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.browser.core.webview.offline.message.OfflineResourceReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class sc6 extends BdAsyncTask<Void, Void, tc6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sc6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public tc6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        HashMap<String, vc6> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            tc6 tc6Var = new tc6();
            for (String str : mc6.h().j()) {
                String i = mc6.h().i(str);
                uc6 c = rc6.c(str, i);
                if (c != null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                    if (tc6Var.a == null) {
                        tc6Var.a = new HashMap();
                    }
                    tc6Var.a.put(str, c);
                    if (tc6Var.b == null) {
                        tc6Var.b = new HashMap<>();
                    }
                    tc6Var.b.putAll(c.b);
                    rc6.b(c.c, str);
                } else {
                    b35.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", i, "hybridResult", "bundle incomplete");
                    rc6.a(str);
                }
            }
            return tc6Var;
        }
        return (tc6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(tc6 tc6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tc6Var) == null) {
            if (tc6Var == null) {
                b35.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                pc6.b().j(tc6Var.b);
            }
            MessageManager.getInstance().sendMessage(new OfflineResourceReqMsg("0.0.0.0"));
        }
    }
}

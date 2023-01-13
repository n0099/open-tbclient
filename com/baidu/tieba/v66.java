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
public class v66 extends BdAsyncTask<Void, Void, w66> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public v66() {
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
    public w66 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        HashMap<String, r66> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            w66 w66Var = new w66();
            for (String str : n66.h().j()) {
                String i = n66.h().i(str);
                x66 c = u66.c(str, i);
                if (c != null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                    if (w66Var.a == null) {
                        w66Var.a = new HashMap();
                    }
                    w66Var.a.put(str, c);
                    if (w66Var.b == null) {
                        w66Var.b = new HashMap<>();
                    }
                    w66Var.b.putAll(c.b);
                    u66.b(c.c, str);
                } else {
                    ry4.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", i, "hybridResult", "bundle incomplete");
                    u66.a(str);
                }
            }
            return w66Var;
        }
        return (w66) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(w66 w66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w66Var) == null) {
            if (w66Var == null) {
                ry4.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                q66.a().g(w66Var.b);
            }
            o76.b("lt-log", "ReadRouterFinalResult:" + w66Var);
            MessageManager.getInstance().sendMessage(new OfflineResourceReqMsg("0.0.0.0"));
        }
    }
}

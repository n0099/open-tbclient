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
/* loaded from: classes5.dex */
public class od6 extends BdAsyncTask<Void, Void, pd6> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public od6() {
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
    public pd6 doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        HashMap<String, ld6> hashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            pd6 pd6Var = new pd6();
            for (String str : hd6.h().j()) {
                String i = hd6.h().i(str);
                qd6 c = nd6.c(str, i);
                if (c != null && !TextUtils.isEmpty(c.a) && (hashMap = c.b) != null && hashMap.size() != 0) {
                    if (pd6Var.a == null) {
                        pd6Var.a = new HashMap();
                    }
                    pd6Var.a.put(str, c);
                    if (pd6Var.b == null) {
                        pd6Var.b = new HashMap<>();
                    }
                    pd6Var.b.putAll(c.b);
                    nd6.b(c.c, str);
                } else {
                    q45.a("OfflineCache", -1L, -1, "downloadCache", -1, "", "hybridName", str, "hybridVersion", i, "hybridResult", "bundle incomplete");
                    nd6.a(str);
                }
            }
            return pd6Var;
        }
        return (pd6) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: c */
    public void onPostExecute(pd6 pd6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd6Var) == null) {
            if (pd6Var == null) {
                q45.a("OfflineCache", -1L, -1, "readFile", -1, "read error", new Object[0]);
            } else {
                kd6.a().g(pd6Var.b);
            }
            MessageManager.getInstance().sendMessage(new OfflineResourceReqMsg("0.0.0.0"));
        }
    }
}

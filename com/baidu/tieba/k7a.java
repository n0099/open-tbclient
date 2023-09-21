package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.wa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k7a() {
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

    public final String a(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                List<String> b = b();
                if (true ^ b.isEmpty()) {
                    return e(b);
                }
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<k78> b = yda.d.a().b();
            if (b.isEmpty()) {
                return arrayList;
            }
            for (k78 k78Var : b) {
                arrayList.add(k78Var.b());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final void c(List<k78> originList, List<wa8.b> confirmList) {
        k78 k78Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, originList, confirmList) == null) {
            Intrinsics.checkNotNullParameter(originList, "originList");
            Intrinsics.checkNotNullParameter(confirmList, "confirmList");
            if (!originList.isEmpty() && !confirmList.isEmpty()) {
                HashMap hashMap = new HashMap();
                for (k78 k78Var2 : originList) {
                    if (k78Var2 != null && k78Var2.j()) {
                        hashMap.put(k78Var2.b(), k78Var2);
                    }
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                for (wa8.b bVar : confirmList) {
                    if (hashMap.containsKey(String.valueOf(bVar.a())) && bVar.b().c().b() && (k78Var = (k78) hashMap.get(String.valueOf(bVar.a()))) != null) {
                        k78Var.n(true);
                    }
                }
            }
        }
    }

    public final void d(String str, BdUniqueId mPageUniqueId) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, mPageUniqueId) == null) {
            Intrinsics.checkNotNullParameter(mPageUniqueId, "mPageUniqueId");
            String a = a(str);
            if (a.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_SIGN_IN_RESULT);
            httpMessage.addParam("scene_from", "recom");
            httpMessage.addParam("forum_ids", a);
            httpMessage.setTag(mPageUniqueId);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final String e(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            if (list.isEmpty()) {
                return "";
            }
            return CollectionsKt___CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null);
        }
        return (String) invokeL.objValue;
    }
}

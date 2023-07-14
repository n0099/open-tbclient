package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.JSONLikeSerializable;
import com.baidu.tieba.immessagecenter.arch.utils.IMLog;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public final class us8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948221679, "Lcom/baidu/tieba/us8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948221679, "Lcom/baidu/tieba/us8;");
        }
    }

    public us8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final HashMap<String, Serializable> a(List<tr8> list) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            h29 iMLog = IMLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("NavigationData Size = ");
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            sb.append(i);
            iMLog.c("im", sb.toString());
            List<MsgTabForumData> b = b(list);
            h29 iMLog2 = IMLog.getInstance();
            iMLog2.c("im", "ForumListData Size = " + b.size());
            HashMap<String, Serializable> hashMap = new HashMap<>();
            ArrayList arrayList = new ArrayList();
            for (MsgTabForumData msgTabForumData : b) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("forum_id", String.valueOf(msgTabForumData.getForumId()));
                linkedHashMap.put("forum_name", msgTabForumData.getForumName());
                linkedHashMap.put("avatar", msgTabForumData.getIcon());
                String hotNumsText = msgTabForumData.getHotNumsText();
                if (hotNumsText == null) {
                    hotNumsText = "";
                }
                linkedHashMap.put("hot_num_value", hotNumsText);
                arrayList.add(linkedHashMap);
            }
            JSONLikeSerializable jSONLikeSerializable = new JSONLikeSerializable();
            jSONLikeSerializable.parseJsonArray(new JSONArray((Collection) arrayList));
            hashMap.put("often_forum_list", jSONLikeSerializable);
            hashMap.put("checkLength", Integer.valueOf(b.size()));
            h29 iMLog3 = IMLog.getInstance();
            iMLog3.c("im", "OftenForumListString = " + jSONLikeSerializable.getJsonString());
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public final List<MsgTabForumData> b(List<tr8> list) {
        InterceptResult invokeL;
        MsgTabForumData e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (tr8 tr8Var : list) {
                    if (tr8Var.getType() == 3 && (e = ForumChannelDataObs.c.a().e(tr8Var.c())) != null) {
                        arrayList.add(e);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

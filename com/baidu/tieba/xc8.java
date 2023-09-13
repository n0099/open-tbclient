package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.biz.aibot.AibotChatRepo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class xc8 {
    public static /* synthetic */ Interceptable $ic;
    public static final xc8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948295676, "Lcom/baidu/tieba/xc8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948295676, "Lcom/baidu/tieba/xc8;");
                return;
            }
        }
        a = new xc8();
    }

    public xc8() {
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

    public final void a(AibotChatRepo repo, JSONObject params, yg8 fetchMsgCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, repo, params, fetchMsgCallback) == null) {
            Intrinsics.checkNotNullParameter(repo, "repo");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(fetchMsgCallback, "fetchMsgCallback");
            repo.c0(params.optLong("beginMsgId"), params.optLong("endMsgId"), params.optInt("count"), fetchMsgCallback);
        }
    }

    public final HashMap<String, Object> b(TreeSet<TbBaseMsg> fetchedMsgs, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fetchedMsgs, j)) == null) {
            Intrinsics.checkNotNullParameter(fetchedMsgs, "fetchedMsgs");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fetchedMsgs, 10));
            for (TbBaseMsg tbBaseMsg : fetchedMsgs) {
                arrayList.add(eh8.c(tbBaseMsg, false));
            }
            HashMap<String, Object> hashMap = new HashMap<>();
            String a2 = p10.a(DataExt.toJson(arrayList));
            Intrinsics.checkNotNullExpressionValue(a2, "getEncodeValue(mapList.toJson())");
            hashMap.put("msgs", a2);
            hashMap.put("chatType", "AISingleChat");
            hashMap.put("chatId", Long.valueOf(j));
            return hashMap;
        }
        return (HashMap) invokeLJ.objValue;
    }
}

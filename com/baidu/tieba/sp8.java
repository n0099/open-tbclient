package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class sp8 implements g95<List<? extends ChatMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sp8() {
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
    @Override // com.baidu.tieba.g95
    /* renamed from: b */
    public List<ChatMsg> a(List<c95<List<ChatMsg>>> tasks) {
        InterceptResult invokeL;
        boolean z;
        JSONObject jSONObject;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tasks)) == null) {
            Intrinsics.checkNotNullParameter(tasks, "tasks");
            List<ChatMsg> list = tasks.get(0).a;
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (ChatMsg chatMsg : list) {
                for (c95<List<ChatMsg>> c95Var : tasks) {
                    List<ChatMsg> list2 = c95Var.a;
                    if (list2 != null) {
                        for (ChatMsg chatMsg2 : list2) {
                            if (chatMsg.getMsgId() == chatMsg2.getMsgId()) {
                                String chatRoomContentExt = chatMsg.getChatRoomContentExt();
                                if (chatRoomContentExt != null && chatRoomContentExt.length() != 0) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    jSONObject = new JSONObject();
                                } else {
                                    jSONObject = new JSONObject(chatMsg.getChatRoomContentExt());
                                }
                                String chatRoomContentExt2 = chatMsg2.getChatRoomContentExt();
                                if (chatRoomContentExt2 != null && chatRoomContentExt2.length() != 0) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                if (!z2) {
                                    JSONObject b = MsgContentMergeUtil.a.b(jSONObject, new JSONObject(chatMsg2.getChatRoomContentExt()));
                                    if (b.length() > 0) {
                                        chatMsg.setChatRoomContentExt(b.toString());
                                    }
                                }
                            }
                        }
                    }
                }
                arrayList.add(chatMsg);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}

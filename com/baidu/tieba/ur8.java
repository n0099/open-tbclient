package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.IChatRoomEnterListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ur8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ur8() {
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

    public IChatRoomEnterListener.ReMsgInfo a(TbReMsgInfo tbInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tbInfo)) == null) {
            Intrinsics.checkNotNullParameter(tbInfo, "tbInfo");
            IChatRoomEnterListener.ReMsgInfo reMsgInfo = new IChatRoomEnterListener.ReMsgInfo();
            reMsgInfo.msgType = String.valueOf(tbInfo.getSdkMsgType());
            reMsgInfo.bdUk = os8.b(tbInfo.getUid());
            reMsgInfo.nickName = tbInfo.getNickname();
            reMsgInfo.msgId = String.valueOf(tbInfo.getMsgId());
            reMsgInfo.msgKey = tbInfo.getMsgKey();
            reMsgInfo.url = tbInfo.getUrl();
            reMsgInfo.content = tbInfo.getContent();
            HashMap hashMap = new HashMap();
            hashMap.put("msg_type", Integer.valueOf(tbInfo.getMsgType()));
            reMsgInfo.ext = DataExt.toJson(hashMap);
            return reMsgInfo;
        }
        return (IChatRoomEnterListener.ReMsgInfo) invokeL.objValue;
    }

    public TbReMsgInfo b(IChatRoomEnterListener.ReMsgInfo sdkInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkInfo)) == null) {
            Intrinsics.checkNotNullParameter(sdkInfo, "sdkInfo");
            TbReMsgInfo tbReMsgInfo = new TbReMsgInfo();
            String ext = sdkInfo.ext;
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            Long l = (Long) DataExt.toMap(ext).get("msg_type");
            Intrinsics.checkNotNull(l);
            tbReMsgInfo.setMsgType((int) l.longValue());
            String msgType = sdkInfo.msgType;
            Intrinsics.checkNotNullExpressionValue(msgType, "msgType");
            tbReMsgInfo.setSdkMsgType(Integer.parseInt(msgType));
            String bdUk = sdkInfo.bdUk;
            Intrinsics.checkNotNullExpressionValue(bdUk, "bdUk");
            tbReMsgInfo.setUid(os8.a(bdUk));
            String nickName = sdkInfo.nickName;
            Intrinsics.checkNotNullExpressionValue(nickName, "nickName");
            tbReMsgInfo.setNickname(nickName);
            String msgId = sdkInfo.msgId;
            Intrinsics.checkNotNullExpressionValue(msgId, "msgId");
            tbReMsgInfo.setMsgId(Long.parseLong(msgId));
            String msgKey = sdkInfo.msgKey;
            Intrinsics.checkNotNullExpressionValue(msgKey, "msgKey");
            tbReMsgInfo.setMsgKey(msgKey);
            tbReMsgInfo.setUrl(sdkInfo.url);
            String content = sdkInfo.content;
            Intrinsics.checkNotNullExpressionValue(content, "content");
            tbReMsgInfo.setContent(content);
            return tbReMsgInfo;
        }
        return (TbReMsgInfo) invokeL.objValue;
    }
}

package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.impersonal.sprite.SpriteMsgProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class ww8<SdkMsg extends ChatMsg, T> implements zw8<SdkMsg, av8<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int c();

    public abstract SdkMsg e(T t);

    public abstract T g(SdkMsg sdkmsg);

    public ww8() {
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
    @Override // com.baidu.tieba.zw8
    /* renamed from: d */
    public SdkMsg b(av8<T> msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            SdkMsg e = e(msg.f());
            e.setSenderUid(BIMManager.getBdUidFromBdUK(String.valueOf(SpriteMsgProcessor.m.a())));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", c());
            jSONObject.put("from", "android");
            e.setContentExtra(jSONObject.toString());
            return e;
        }
        return (SdkMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zw8
    /* renamed from: f */
    public av8<T> a(SdkMsg msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            av8<T> av8Var = new av8<>();
            av8Var.i(g(msg));
            av8Var.c(msg.getMsgId());
            String msgKey = msg.getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
            av8Var.d(msgKey);
            av8Var.e().m(msg.getContacterUk());
            av8Var.e().l(zeb.c(msg.getSenderUid(), 0L));
            av8Var.e().j(msg.getStatus());
            av8Var.j(msg);
            boolean isSelf = msg.isSelf(TbadkApplication.getInst());
            av8Var.e().i(isSelf);
            if (!isSelf) {
                av8Var.e().h(TbSingleton.getInstance().getFunnySpriteAvatar());
                av8Var.e().g(TbSingleton.getInstance().getFunnySpriteName());
            } else {
                av8Var.e().h(TbadkCoreApplication.getCurrentPortrait());
                av8Var.e().g(TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (!StringUtils.isNull(msg.getContentExtra())) {
                try {
                    JSONObject jSONObject = new JSONObject(msg.getContentExtra());
                    av8Var.e().k(jSONObject.optInt("type"));
                    av8Var.e().f(jSONObject.optString("from"));
                } catch (JSONException e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        e.printStackTrace();
                    } else {
                        throw e;
                    }
                }
            }
            String msgContent = msg.getMsgContent();
            if (msgContent == null) {
                msgContent = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(msgContent, "msg.msgContent ?: \"\"");
            }
            if (!ad.isEmpty(msgContent)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(msgContent);
                    zu8 g = av8Var.g();
                    String optString = jSONObject2.optString("origin_msg_key");
                    Intrinsics.checkNotNullExpressionValue(optString, "msgContentObj.optString(\"origin_msg_key\")");
                    g.b(optString);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return av8Var;
        }
        return (av8) invokeL.objValue;
    }
}

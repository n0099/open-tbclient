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
/* loaded from: classes7.dex */
public abstract class nm8<SdkMsg extends ChatMsg, T> implements qm8<SdkMsg, tk8<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int c();

    public abstract SdkMsg e(T t);

    public abstract T g(SdkMsg sdkmsg);

    public nm8() {
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
    @Override // com.baidu.tieba.qm8
    /* renamed from: d */
    public SdkMsg b(tk8<T> msg) {
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
    @Override // com.baidu.tieba.qm8
    /* renamed from: f */
    public tk8<T> a(SdkMsg msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            tk8<T> tk8Var = new tk8<>();
            tk8Var.i(g(msg));
            tk8Var.c(msg.getMsgId());
            String msgKey = msg.getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
            tk8Var.d(msgKey);
            tk8Var.e().l(msg.getContacterUk());
            tk8Var.e().k(cva.c(msg.getSenderUid(), 0L));
            tk8Var.e().i(msg.getStatus());
            tk8Var.j(msg);
            boolean isSelf = msg.isSelf(TbadkApplication.getInst());
            tk8Var.e().h(isSelf);
            if (!isSelf) {
                tk8Var.e().g(TbSingleton.getInstance().getFunnySpriteAvatar());
                tk8Var.e().f(TbSingleton.getInstance().getFunnySpriteName());
            } else {
                tk8Var.e().g(TbadkCoreApplication.getCurrentPortrait());
                tk8Var.e().f(TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (!StringUtils.isNull(msg.getContentExtra())) {
                try {
                    JSONObject jSONObject = new JSONObject(msg.getContentExtra());
                    tk8Var.e().j(jSONObject.optInt("type"));
                    tk8Var.e().e(jSONObject.optString("from"));
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
            if (!ui.isEmpty(msgContent)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(msgContent);
                    sk8 g = tk8Var.g();
                    String optString = jSONObject2.optString("origin_msg_key");
                    Intrinsics.checkNotNullExpressionValue(optString, "msgContentObj.optString(\"origin_msg_key\")");
                    g.b(optString);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return tk8Var;
        }
        return (tk8) invokeL.objValue;
    }
}

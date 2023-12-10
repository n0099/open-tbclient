package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.impersonal.data.Extra;
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
public abstract class ud9<SdkMsg extends ChatMsg, T> implements xd9<SdkMsg, vb9<T>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract int c();

    public abstract SdkMsg e(T t);

    public abstract T g(SdkMsg sdkmsg);

    public ud9() {
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
    @Override // com.baidu.tieba.xd9
    /* renamed from: d */
    public SdkMsg b(vb9<T> msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            SdkMsg e = e(msg.f());
            e.setSenderUid(BIMManager.getBdUidFromBdUK(String.valueOf(SpriteMsgProcessor.n.a())));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", c());
            jSONObject.put("from", "android");
            e.setContentExtra(jSONObject.toString());
            return e;
        }
        return (SdkMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xd9
    /* renamed from: f */
    public vb9<T> a(SdkMsg msg) {
        InterceptResult invokeL;
        Extra extra;
        String jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            vb9<T> vb9Var = new vb9<>();
            vb9Var.i(g(msg));
            vb9Var.c(msg.getMsgId());
            String msgKey = msg.getMsgKey();
            Intrinsics.checkNotNullExpressionValue(msgKey, "msg.msgKey");
            vb9Var.d(msgKey);
            vb9Var.e().m(msg.getContacterUk());
            vb9Var.e().l(xwb.c(msg.getSenderUid(), 0L));
            vb9Var.e().j(msg.getStatus());
            vb9Var.j(msg);
            boolean isSelf = msg.isSelf(TbadkApplication.getInst());
            vb9Var.e().i(isSelf);
            if (!isSelf) {
                vb9Var.e().h(TbSingleton.getInstance().getFunnySpriteAvatar());
                vb9Var.e().g(TbSingleton.getInstance().getFunnySpriteName());
            } else {
                vb9Var.e().h(TbadkCoreApplication.getCurrentPortrait());
                vb9Var.e().g(TbadkCoreApplication.getCurrentAccountNameShow());
            }
            if (!StringUtils.isNull(msg.getContentExtra())) {
                try {
                    JSONObject jSONObject2 = new JSONObject(msg.getContentExtra());
                    vb9Var.e().k(jSONObject2.optInt("type"));
                    vb9Var.e().f(jSONObject2.optString("from"));
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
            if (!rd.isEmpty(msgContent)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(msgContent);
                    ub9 g = vb9Var.g();
                    String optString = jSONObject3.optString("origin_msg_key");
                    Intrinsics.checkNotNullExpressionValue(optString, "msgContentObj.optString(\"origin_msg_key\")");
                    g.d(optString);
                    JSONObject optJSONObject = jSONObject3.optJSONObject("extra");
                    ub9 g2 = vb9Var.g();
                    if (optJSONObject != null && (jSONObject = optJSONObject.toString()) != null) {
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString()");
                        extra = (Extra) DataExt.toEntityNullable(jSONObject, Extra.class);
                    } else {
                        extra = null;
                    }
                    g2.c(extra);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            return vb9Var;
        }
        return (vb9) invokeL.objValue;
    }
}

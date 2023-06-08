package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class sm8 extends nm8<TextMsg, uk8> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nm8
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public sm8() {
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
    @Override // com.baidu.tieba.nm8
    /* renamed from: h */
    public TextMsg e(uk8 uk8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, uk8Var)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.setText((uk8Var == null || (r5 = uk8Var.c()) == null) ? "" : "");
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nm8
    /* renamed from: i */
    public uk8 g(TextMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            uk8 uk8Var = new uk8();
            String msgContent = sdkMsg.getMsgContent();
            if (msgContent == null) {
                msgContent = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(msgContent, "sdkMsg.msgContent ?: \"\"");
            }
            if (!ui.isEmpty(msgContent)) {
                try {
                    uk8Var.e(new JSONObject(msgContent).optJSONArray("struct_data"));
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            if (uk8Var.b() == null) {
                String text = sdkMsg.getText();
                Intrinsics.checkNotNullExpressionValue(text, "sdkMsg.getText()");
                uk8Var.f(text);
            }
            String text2 = sdkMsg.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "sdkMsg.getText()");
            uk8Var.d(text2);
            return uk8Var;
        }
        return (uk8) invokeL.objValue;
    }
}

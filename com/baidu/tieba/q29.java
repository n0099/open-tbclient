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
public final class q29 extends l29<TextMsg, q09> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.l29
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    public q29() {
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
    @Override // com.baidu.tieba.l29
    /* renamed from: h */
    public TextMsg e(q09 q09Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, q09Var)) == null) {
            TextMsg textMsg = new TextMsg();
            textMsg.setText((q09Var == null || (r5 = q09Var.c()) == null) ? "" : "");
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.l29
    /* renamed from: i */
    public q09 g(TextMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            q09 q09Var = new q09();
            String msgContent = sdkMsg.getMsgContent();
            if (msgContent == null) {
                msgContent = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(msgContent, "sdkMsg.msgContent ?: \"\"");
            }
            if (!di.isEmpty(msgContent)) {
                try {
                    q09Var.e(new JSONObject(msgContent).optJSONArray("struct_data"));
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            if (q09Var.b() == null) {
                String text = sdkMsg.getText();
                Intrinsics.checkNotNullExpressionValue(text, "sdkMsg.getText()");
                q09Var.f(text);
            }
            String text2 = sdkMsg.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "sdkMsg.getText()");
            q09Var.d(text2);
            return q09Var;
        }
        return (q09) invokeL.objValue;
    }
}

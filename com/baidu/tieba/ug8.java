package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextToSpeechMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class ug8 extends og8<TbTextMsg, TextMsg> {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948210147, "Lcom/baidu/tieba/ug8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948210147, "Lcom/baidu/tieba/ug8;");
                return;
            }
        }
        f = new a(null);
    }

    public /* synthetic */ ug8(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public final Triple<Class<TbTextMsg>, Class<TextMsg>, ug8> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Triple<>(TbTextMsg.class, TextMsg.class, new ug8(null));
            }
            return (Triple) invokeV.objValue;
        }
    }

    public ug8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        j(1, TbTextMsg.class);
        j(103, TbTextToSpeechMsg.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og8
    /* renamed from: n */
    public TextMsg g(TbTextMsg tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            TextMsg textMsg = new TextMsg();
            textMsg.setText(tbMsg.getText());
            return textMsg;
        }
        return (TextMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.og8
    /* renamed from: o */
    public TbTextMsg h(int i, TextMsg sdkMsg, Map<String, ? extends Object> sdkMsgMap) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, sdkMsg, sdkMsgMap)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Intrinsics.checkNotNullParameter(sdkMsgMap, "sdkMsgMap");
            TbTextMsg tbTextMsg = (TbTextMsg) DataExt.toEntity(sdkMsgMap, l(i));
            String str = sdkMsg.text;
            Intrinsics.checkNotNullExpressionValue(str, "sdkMsg.text");
            tbTextMsg.setText(str);
            return tbTextMsg;
        }
        return (TbTextMsg) invokeILL.objValue;
    }
}

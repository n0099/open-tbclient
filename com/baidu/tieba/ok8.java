package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.TextImageMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
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
/* loaded from: classes7.dex */
public final class ok8 extends jk8<TbSingleTextImageMsg, TextImageMsg> {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948035245, "Lcom/baidu/tieba/ok8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948035245, "Lcom/baidu/tieba/ok8;");
                return;
            }
        }
        f = new a(null);
    }

    public /* synthetic */ ok8(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes7.dex */
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

        public final Triple<Class<TbSingleTextImageMsg>, Class<TextImageMsg>, ok8> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Triple<>(TbSingleTextImageMsg.class, TextImageMsg.class, new ok8(null));
            }
            return (Triple) invokeV.objValue;
        }
    }

    public ok8() {
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
        j(102, TbSingleTextImageMsg.class);
        j(101, TbTextGenImageMsg.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk8
    /* renamed from: n */
    public TextImageMsg g(TbSingleTextImageMsg tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            TextImageMsg textImageMsg = new TextImageMsg();
            textImageMsg.setText(tbMsg.getText());
            kk8.f.a(textImageMsg, tbMsg);
            return textImageMsg;
        }
        return (TextImageMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.jk8
    /* renamed from: o */
    public TbSingleTextImageMsg h(int i, TextImageMsg sdkMsg, Map<String, ? extends Object> sdkMsgMap) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, sdkMsg, sdkMsgMap)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Intrinsics.checkNotNullParameter(sdkMsgMap, "sdkMsgMap");
            TbSingleTextImageMsg tbSingleTextImageMsg = (TbSingleTextImageMsg) DataExt.toEntity(sdkMsgMap, l(i));
            kk8.f.b(tbSingleTextImageMsg, sdkMsg);
            tbSingleTextImageMsg.setText(sdkMsg.getText());
            return tbSingleTextImageMsg;
        }
        return (TbSingleTextImageMsg) invokeILL.objValue;
    }
}

package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.utils.CommonUtilsKt;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.lib.socket.msg.TbBaseImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbBigEmotionMsg;
import com.baidu.tieba.im.lib.socket.msg.TbImageMsg;
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
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes7.dex */
public final class nf8 extends mf8<TbBaseImageMsg, ImageMsg> {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948000649, "Lcom/baidu/tieba/nf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948000649, "Lcom/baidu/tieba/nf8;");
                return;
            }
        }
        f = new a(null);
    }

    public /* synthetic */ nf8(DefaultConstructorMarker defaultConstructorMarker) {
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

        public final Triple<Class<TbBaseImageMsg>, Class<ImageMsg>, nf8> d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return new Triple<>(TbBaseImageMsg.class, ImageMsg.class, new nf8(null));
            }
            return (Triple) invokeV.objValue;
        }

        public final void a(ImageMsg imageMsg, TbBaseImageMsg tbMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, imageMsg, tbMsg) == null) {
                Intrinsics.checkNotNullParameter(imageMsg, "imageMsg");
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                imageMsg.setThumbUrl(tbMsg.getThumbUrl());
                imageMsg.setContent(tbMsg.getBigSrc());
                String thumbSize = tbMsg.getThumbSize();
                Intrinsics.checkNotNullExpressionValue(thumbSize, "tbMsg.thumbSize");
                String[] c = c(thumbSize);
                if (c != null && c.length > 1) {
                    imageMsg.setImgWH(CommonUtilsKt.toIntSafely(c[0]), CommonUtilsKt.toIntSafely(c[1]));
                }
            }
        }

        public final void b(TbBaseImageMsg tbMsg, ImageMsg sdkMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbMsg, sdkMsg) == null) {
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
                tbMsg.setThumbUrl(sdkMsg.getThumbUrl());
                tbMsg.setBigSrc(sdkMsg.getRemoteUrl());
            }
        }

        public final String[] c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (StringUtils.isNull(str)) {
                    return null;
                }
                Object[] array = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (array != null) {
                    return (String[]) array;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            return (String[]) invokeL.objValue;
        }
    }

    public nf8() {
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
        j(2, TbImageMsg.class);
        j(4, TbBigEmotionMsg.class);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf8
    /* renamed from: n */
    public ImageMsg g(TbBaseImageMsg tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            ImageMsg imageMsg = new ImageMsg();
            f.a(imageMsg, tbMsg);
            return imageMsg;
        }
        return (ImageMsg) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.mf8
    /* renamed from: o */
    public TbBaseImageMsg h(int i, ImageMsg sdkMsg, Map<String, ? extends Object> sdkMsgMap) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048579, this, i, sdkMsg, sdkMsgMap)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Intrinsics.checkNotNullParameter(sdkMsgMap, "sdkMsgMap");
            TbBaseImageMsg tbBaseImageMsg = (TbBaseImageMsg) DataExt.toEntity(sdkMsgMap, l(i));
            f.b(tbBaseImageMsg, sdkMsg);
            return tbBaseImageMsg;
        }
        return (TbBaseImageMsg) invokeILL.objValue;
    }
}

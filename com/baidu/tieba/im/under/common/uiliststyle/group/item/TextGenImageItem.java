package com.baidu.tieba.im.under.common.uiliststyle.group.item;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.uilist.Action;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTaskInfo;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0001H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/TextGenImageItem;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbTextGenImageMsg;", "()V", "getType", "Lcom/baidu/adp/BdUniqueId;", "isContentChanged", "", "newItem", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "provideAction", "Lcom/baidu/tieba/im/base/core/uilist/Action;", "Companion", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextGenImageItem extends BaseItem<TbTextGenImageMsg> {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId ADAPTER_TYPE;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final Pair<Integer, Class<TextGenImageItem>> parsePair() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Companion.a() : (Pair) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
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

        @JvmStatic
        public final Pair<Integer, Class<TextGenImageItem>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Pair<>(101, TextGenImageItem.class);
            }
            return (Pair) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2064100228, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/TextGenImageItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2064100228, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/TextGenImageItem;");
                return;
            }
        }
        Companion = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        ADAPTER_TYPE = gen;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbTaskInfo taskInfo = getTbMsg().getTaskInfo();
            if (taskInfo == null) {
                return null;
            }
            String originMsgKey = taskInfo.getOriginMsgKey();
            if (TextUtils.isEmpty(originMsgKey) || !taskInfo.isComplete()) {
                return null;
            }
            return Action.a(taskInfo.getOriginMsgId(), originMsgKey, Action.Op.DELETE, null);
        }
        return (Action) invokeV.objValue;
    }

    public TextGenImageItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, com.baidu.tieba.yh
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem
    public boolean isContentChanged(BaseItem<? extends TbBaseMsg> newItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, newItem)) == null) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!TbTaskInfo.Companion.a(getTbMsg().getTaskInfo(), newItem.getTbMsg().getTaskInfo()) && !super.isContentChanged(newItem)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}

package com.baidu.tieba.im.under.common.uiliststyle.group.item;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.repo.MsgProcessor;
import com.baidu.tieba.im.base.core.uilist.Action;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbActivitySysMsg;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.im.under.common.uiliststyle.group.item.ActivitySysItem;
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
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/ActivitySysItem;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lcom/baidu/tieba/im/lib/socket/msg/TbActivitySysMsg;", "()V", "getType", "Lcom/baidu/adp/BdUniqueId;", "provideAction", "Lcom/baidu/tieba/im/base/core/uilist/Action;", "Companion", "im-under-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ActivitySysItem extends BaseItem<TbActivitySysMsg> {
    public static /* synthetic */ Interceptable $ic;
    @JvmField
    public static final BdUniqueId ADAPTER_TYPE;
    public static final a Companion;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    public static final Pair<Integer, Class<ActivitySysItem>> parsePair() {
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
        public final Pair<Integer, Class<ActivitySysItem>> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Pair<>(7022, ActivitySysItem.class);
            }
            return (Pair) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Action.a<BaseItem<TbActivitySysMsg>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public static final void b(TopBubbleData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65537, null, data) == null) {
                Intrinsics.checkNotNullParameter(data, "$data");
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921796, data));
            }
        }

        @Override // com.baidu.tieba.im.base.core.uilist.Action.a
        public void a(Action.Op op, BaseItem<TbActivitySysMsg> baseItem, MsgProcessor.d source) {
            TbActivitySysMsg.ActivityInfo activityInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, op, baseItem, source) == null) {
                Intrinsics.checkNotNullParameter(op, "op");
                Intrinsics.checkNotNullParameter(source, "source");
                if (source.g() && baseItem != null && (activityInfo = baseItem.getTbMsg().getActivityInfo()) != null) {
                    final TopBubbleData topBubbleData = new TopBubbleData();
                    topBubbleData.setPinnedType("activity");
                    topBubbleData.setActivityID(activityInfo.getId());
                    topBubbleData.setActivityStatus(activityInfo.getStatus());
                    UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.sv8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                ActivitySysItem.b.b(TopBubbleData.this);
                            }
                        }
                    });
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(804656406, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/ActivitySysItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(804656406, "Lcom/baidu/tieba/im/under/common/uiliststyle/group/item/ActivitySysItem;");
                return;
            }
        }
        Companion = new a(null);
        BdUniqueId gen = BdUniqueId.gen();
        Intrinsics.checkNotNullExpressionValue(gen, "gen()");
        ADAPTER_TYPE = gen;
    }

    public ActivitySysItem() {
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

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, com.baidu.tieba.oi
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ADAPTER_TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem
    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbActivitySysMsg tbMsg = getTbMsg();
            Action a2 = Action.a(tbMsg.getMsgId(), tbMsg.getMsgKey(), Action.Op.EXEC, new b());
            Intrinsics.checkNotNullExpressionValue(a2, "create(\n                …     }\n                })");
            return a2;
        }
        return (Action) invokeV.objValue;
    }
}

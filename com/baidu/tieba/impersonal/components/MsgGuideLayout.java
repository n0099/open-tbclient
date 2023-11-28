package com.baidu.tieba.impersonal.components;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.widget.ListView.SpaceItemDecoration;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.gq8;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.impersonal.data.BehaviorExt;
import com.baidu.tieba.impersonal.databinding.LayoutMsgGuideBinding;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/impersonal/components/MsgGuideLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/baidu/tieba/impersonal/databinding/LayoutMsgGuideBinding;", "curSkinType", "", "mMsgGuideAdapter", "Lcom/baidu/tieba/impersonal/components/MsgGuideAdapter;", "initView", "", "onChangeSkinType", "processorTransfer", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "behaviorExt", "Lcom/baidu/tieba/impersonal/data/BehaviorExt;", "render", "guideList", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgGuideLayout extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LayoutMsgGuideBinding a;
    public int b;
    public MsgGuideAdapter c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgGuideLayout(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MsgGuideLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        a();
        this.b = 3;
    }

    public /* synthetic */ MsgGuideLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutMsgGuideBinding c = LayoutMsgGuideBinding.c(LayoutInflater.from(getContext()), this, true);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
            this.a = c;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.c = new MsgGuideAdapter(context);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            LayoutMsgGuideBinding layoutMsgGuideBinding = this.a;
            LayoutMsgGuideBinding layoutMsgGuideBinding2 = null;
            if (layoutMsgGuideBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                layoutMsgGuideBinding = null;
            }
            layoutMsgGuideBinding.b.setLayoutManager(linearLayoutManager);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_H_X002);
            LayoutMsgGuideBinding layoutMsgGuideBinding3 = this.a;
            if (layoutMsgGuideBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                layoutMsgGuideBinding3 = null;
            }
            layoutMsgGuideBinding3.b.addItemDecoration(new SpaceItemDecoration(0, dimenPixelSize, 0));
            LayoutMsgGuideBinding layoutMsgGuideBinding4 = this.a;
            if (layoutMsgGuideBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                layoutMsgGuideBinding2 = layoutMsgGuideBinding4;
            }
            layoutMsgGuideBinding2.b.setAdapter(this.c);
            b();
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.b == SkinManager.getCurrentSkinType()) {
            return;
        }
        this.b = SkinManager.getCurrentSkinType();
        LayoutMsgGuideBinding layoutMsgGuideBinding = this.a;
        if (layoutMsgGuideBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            layoutMsgGuideBinding = null;
        }
        EMManager.from(layoutMsgGuideBinding.getRoot()).setCorner(R.string.J_X06).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0205));
    }

    public final void c(gq8 processor, BehaviorExt behaviorExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, processor, behaviorExt) == null) {
            Intrinsics.checkNotNullParameter(processor, "processor");
            Intrinsics.checkNotNullParameter(behaviorExt, "behaviorExt");
            MsgGuideAdapter msgGuideAdapter = this.c;
            if (msgGuideAdapter != null) {
                msgGuideAdapter.p(processor);
            }
            MsgGuideAdapter msgGuideAdapter2 = this.c;
            if (msgGuideAdapter2 != null) {
                msgGuideAdapter2.o(behaviorExt);
            }
        }
    }

    public final void d(List<AbilityItem> guideList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, guideList) == null) {
            Intrinsics.checkNotNullParameter(guideList, "guideList");
            MsgGuideAdapter msgGuideAdapter = this.c;
            if (msgGuideAdapter != null) {
                msgGuideAdapter.setData(guideList);
            }
        }
    }
}

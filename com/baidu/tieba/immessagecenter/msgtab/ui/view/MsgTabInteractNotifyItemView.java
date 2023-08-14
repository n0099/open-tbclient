package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ig8;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.np8;
import com.baidu.tieba.tq8;
import com.baidu.tieba.ts8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0018J\u0010\u00107\u001a\u0002052\u0006\u00108\u001a\u000209H\u0014J\b\u0010:\u001a\u000205H\u0002J\b\u0010;\u001a\u000205H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0016J\u0012\u0010?\u001a\u0002052\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u000205H\u0014J\b\u0010C\u001a\u000205H\u0002J\b\u0010D\u001a\u000205H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u001a\u0010+\u001a\u00020,X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u0013¨\u0006E"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabInteractNotifyItemView;", "Lcom/baidu/tieba/immessagecenter/arch/view/StatelessView;", "Landroid/view/View$OnClickListener;", "mRootFragment", "Lcom/baidu/tbadk/core/BaseFragment;", "(Lcom/baidu/tbadk/core/BaseFragment;)V", "DEFAULT_CONTENT", "", "mCardAbs", "Landroid/widget/TextView;", "getMCardAbs", "()Landroid/widget/TextView;", "setMCardAbs", "(Landroid/widget/TextView;)V", "mCardMsgView", "Landroid/widget/LinearLayout;", "getMCardMsgView", "()Landroid/widget/LinearLayout;", "setMCardMsgView", "(Landroid/widget/LinearLayout;)V", "mCardTitle", "getMCardTitle", "setMCardTitle", "mCurrentData", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgNotifyData;", "mEnterBtn", "Landroid/widget/ImageView;", "getMEnterBtn", "()Landroid/widget/ImageView;", "setMEnterBtn", "(Landroid/widget/ImageView;)V", "mHeadView", "Lcom/baidu/tbadk/widget/TbImageView;", "getMHeadView", "()Lcom/baidu/tbadk/widget/TbImageView;", "setMHeadView", "(Lcom/baidu/tbadk/widget/TbImageView;)V", "mPresenter", "Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/MsgTabNotifyItemPresenter;", "getMPresenter", "()Lcom/baidu/tieba/immessagecenter/msgtab/ui/prenster/MsgTabNotifyItemPresenter;", "mPresenter$delegate", "Lkotlin/Lazy;", "mRedDot", "Lcom/baidu/tbadk/core/view/MessageRedDotView;", "getMRedDot", "()Lcom/baidu/tbadk/core/view/MessageRedDotView;", "setMRedDot", "(Lcom/baidu/tbadk/core/view/MessageRedDotView;)V", "mStatusView", "getMStatusView", "setMStatusView", "bindData", "", "data", "init", "context", "Landroid/content/Context;", "onAgreeMeItemClick", "onAtMeItemClick", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "", "onClick", "v", "Landroid/view/View;", "onFinishInflate", "onFollowMeItemClick", "onReplyMeItemClick", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgTabInteractNotifyItemView extends ig8 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment e;
    public final String f;
    public TbImageView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public MessageRedDotView k;
    public ImageView l;
    public LinearLayout m;
    public final Lazy n;
    public np8 o;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1845851282, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabInteractNotifyItemView$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1845851282, "Lcom/baidu/tieba/immessagecenter/msgtab/ui/view/MsgTabInteractNotifyItemView$a;");
                    return;
                }
            }
            int[] iArr = new int[NotifyType.values().length];
            iArr[NotifyType.AT_ME.ordinal()] = 1;
            iArr[NotifyType.AGREE_ME.ordinal()] = 2;
            iArr[NotifyType.REPLY_ME.ordinal()] = 3;
            iArr[NotifyType.FANS.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgTabInteractNotifyItemView(BaseFragment mRootFragment) {
        super(R.layout.obfuscated_res_0x7f0d0638);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mRootFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mRootFragment, "mRootFragment");
        this.e = mRootFragment;
        String string = TbadkApplication.getInst().getString(R.string.not_received_new_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.not_received_new_msg)");
        this.f = string;
        this.n = LazyKt__LazyJVMKt.lazy(MsgTabInteractNotifyItemView$mPresenter$2.INSTANCE);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        NotifyType notifyType;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            np8 np8Var = this.o;
            if (np8Var != null) {
                notifyType = np8Var.getType();
            } else {
                notifyType = null;
            }
            if (notifyType == null) {
                i = -1;
            } else {
                i = a.$EnumSwitchMapping$0[notifyType.ordinal()];
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            b0();
                        }
                    } else {
                        c0();
                    }
                } else {
                    Z();
                }
            } else {
                a0();
            }
            W().a(this.o);
            ts8.a.d(this.o);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h0((TbImageView) j(R.id.obfuscated_res_0x7f091995));
            e0((LinearLayout) j(R.id.obfuscated_res_0x7f091996));
            f0((TextView) j(R.id.obfuscated_res_0x7f091999));
            d0((TextView) j(R.id.obfuscated_res_0x7f091994));
            i0((MessageRedDotView) j(R.id.obfuscated_res_0x7f091997));
            g0((ImageView) j(R.id.obfuscated_res_0x7f090a16));
            j0((LinearLayout) j(R.id.obfuscated_res_0x7f091998));
        }
    }

    public final void Q(np8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.o = data;
            T().setText(data.getType().getTitle());
            if (TextUtils.isEmpty(data.b())) {
                R().setText(this.f);
            } else {
                R().setText(data.b());
            }
            if (data.c() > 0) {
                Y().setVisibility(0);
                U().setVisibility(8);
                MessageRedDotView X = X();
                X.setVisibility(0);
                X.refresh(data.c());
                return;
            }
            Y().setVisibility(8);
            U().setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.hg8
    public void onChangeSkinType(int i) {
        NotifyType type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            EMManager.from(T()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(R()).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            WebPManager.setPureDrawable(U(), R.drawable.obfuscated_res_0x7f08089c, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            np8 np8Var = this.o;
            if (np8Var != null && (type = np8Var.getType()) != null) {
                WebPManager.setMaskDrawable(V(), type.getIcon(), WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final TextView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardAbs");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final LinearLayout S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final TextView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.i;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ImageView imageView = this.l;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final TbImageView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TbImageView tbImageView = this.g;
            if (tbImageView != null) {
                return tbImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
            return null;
        }
        return (TbImageView) invokeV.objValue;
    }

    public final tq8 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (tq8) this.n.getValue();
        }
        return (tq8) invokeV.objValue;
    }

    public final MessageRedDotView X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MessageRedDotView messageRedDotView = this.k;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final LinearLayout Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.m;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void Z() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            np8 np8Var = this.o;
            if (np8Var != null) {
                i = np8Var.c();
            } else {
                i = 0;
            }
            tq8 W = W();
            ts8.a.a(i);
            W.b(this.e, i);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            tq8 W = W();
            ts8.a.c();
            ts8.a.g();
            W.d(this.e);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            tq8 W = W();
            ts8.a.e();
            W.e(this.e);
        }
    }

    public final void a0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            np8 np8Var = this.o;
            if (np8Var != null) {
                i = np8Var.c();
            } else {
                i = 0;
            }
            tq8 W = W();
            ts8.a.b(i);
            ts8.a.f(this.e.getContext());
            W.c(this.e, i);
        }
    }

    public final void d0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void e0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.h = linearLayout;
        }
    }

    public final void f0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void g0(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.l = imageView;
        }
    }

    public final void h0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbImageView) == null) {
            Intrinsics.checkNotNullParameter(tbImageView, "<set-?>");
            this.g = tbImageView;
        }
    }

    public final void i0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.k = messageRedDotView;
        }
    }

    public final void j0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.m = linearLayout;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            X().setThreeDotMode(2);
            TbImageView V = V();
            V.setConrers(15);
            V.setScaleType(ImageView.ScaleType.CENTER_CROP);
            V.setOnClickListener(this);
            S().setOnClickListener(this);
        }
    }
}

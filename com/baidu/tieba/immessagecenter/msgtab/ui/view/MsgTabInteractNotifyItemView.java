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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.cm8;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.s75;
import com.baidu.tieba.td8;
import com.baidu.tieba.um8;
import com.baidu.tieba.vo8;
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
public final class MsgTabInteractNotifyItemView extends td8 implements View.OnClickListener {
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
    public cm8 o;

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
        super(R.layout.obfuscated_res_0x7f0d0628);
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
            cm8 cm8Var = this.o;
            if (cm8Var != null) {
                notifyType = cm8Var.getType();
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
                            Z();
                        }
                    } else {
                        a0();
                    }
                } else {
                    X();
                }
            } else {
                Y();
            }
            U().a(this.o);
            vo8.a.d(this.o);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            f0((TbImageView) g(R.id.obfuscated_res_0x7f09196b));
            c0((LinearLayout) g(R.id.obfuscated_res_0x7f09196c));
            d0((TextView) g(R.id.obfuscated_res_0x7f09196f));
            b0((TextView) g(R.id.obfuscated_res_0x7f09196a));
            g0((MessageRedDotView) g(R.id.obfuscated_res_0x7f09196d));
            e0((ImageView) g(R.id.obfuscated_res_0x7f0909fc));
            h0((LinearLayout) g(R.id.obfuscated_res_0x7f09196e));
        }
    }

    public final void N(cm8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.o = data;
            R().setText(data.getType().getTitle());
            if (TextUtils.isEmpty(data.b())) {
                O().setText(this.f);
            } else {
                O().setText(data.b());
            }
            if (data.c() > 0) {
                W().setVisibility(0);
                S().setVisibility(8);
                MessageRedDotView V = V();
                V.setVisibility(0);
                V.f(data.c());
                return;
            }
            W().setVisibility(8);
            S().setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        NotifyType type;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            s75 d = s75.d(R());
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X05);
            d.D(R.string.F_X01);
            s75 d2 = s75.d(O());
            d2.x(R.color.CAM_X0109);
            d2.C(R.dimen.T_X08);
            d2.D(R.string.F_X01);
            WebPManager.setPureDrawable(S(), R.drawable.obfuscated_res_0x7f08089c, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            cm8 cm8Var = this.o;
            if (cm8Var != null && (type = cm8Var.getType()) != null) {
                WebPManager.setMaskDrawable(T(), type.getIcon(), WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    public final TextView O() {
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

    public final LinearLayout Q() {
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

    public final TextView R() {
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

    public final ImageView S() {
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

    public final TbImageView T() {
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

    public final um8 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (um8) this.n.getValue();
        }
        return (um8) invokeV.objValue;
    }

    public final MessageRedDotView V() {
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

    public final LinearLayout W() {
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

    public final void X() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            cm8 cm8Var = this.o;
            if (cm8Var != null) {
                i = cm8Var.c();
            } else {
                i = 0;
            }
            um8 U = U();
            vo8.a.a(i);
            U.b(this.e, i);
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            um8 U = U();
            vo8.a.c();
            vo8.a.g();
            U.d(this.e);
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            um8 U = U();
            vo8.a.e();
            U.e(this.e);
        }
    }

    public final void Y() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            cm8 cm8Var = this.o;
            if (cm8Var != null) {
                i = cm8Var.c();
            } else {
                i = 0;
            }
            um8 U = U();
            vo8.a.b(i);
            vo8.a.f(this.e.getContext());
            U.c(this.e, i);
        }
    }

    public final void b0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void c0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.h = linearLayout;
        }
    }

    public final void d0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void e0(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.l = imageView;
        }
    }

    public final void f0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbImageView) == null) {
            Intrinsics.checkNotNullParameter(tbImageView, "<set-?>");
            this.g = tbImageView;
        }
    }

    public final void g0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.k = messageRedDotView;
        }
    }

    public final void h0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.m = linearLayout;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            V().setThreeDotMode(2);
            TbImageView T2 = T();
            T2.setConrers(15);
            T2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            T2.setOnClickListener(this);
            Q().setOnClickListener(this);
        }
    }
}

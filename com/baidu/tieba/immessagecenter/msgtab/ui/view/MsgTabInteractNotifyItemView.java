package com.baidu.tieba.immessagecenter.msgtab.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.immessagecenter.msgtab.data.NotifyType;
import com.baidu.tieba.k19;
import com.baidu.tieba.l79;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.ra9;
import com.baidu.tieba.s89;
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
public final class MsgTabInteractNotifyItemView extends k19 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment f;
    public final String g;
    public TbImageView h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public MessageRedDotView l;
    public ImageView m;
    public LinearLayout n;
    public final Lazy o;
    public l79 p;

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
        super(R.layout.obfuscated_res_0x7f0d0671);
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
        this.f = mRootFragment;
        String string = TbadkApplication.getInst().getString(R.string.not_received_new_msg);
        Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(R.string.not_received_new_msg)");
        this.g = string;
        this.o = LazyKt__LazyJVMKt.lazy(MsgTabInteractNotifyItemView$mPresenter$2.INSTANCE);
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i0((TbImageView) j(R.id.obfuscated_res_0x7f091aa5));
            f0((LinearLayout) j(R.id.obfuscated_res_0x7f091aa6));
            g0((TextView) j(R.id.obfuscated_res_0x7f091aa9));
            e0((TextView) j(R.id.obfuscated_res_0x7f091aa4));
            j0((MessageRedDotView) j(R.id.obfuscated_res_0x7f091aa7));
            h0((ImageView) j(R.id.obfuscated_res_0x7f090a6d));
            k0((LinearLayout) j(R.id.obfuscated_res_0x7f091aa8));
        }
    }

    public final void R(l79 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.p = data;
            U().setText(data.c().getTitle());
            if (TextUtils.isEmpty(data.b())) {
                S().setText(this.g);
            } else {
                S().setText(data.b());
            }
            if (data.d() > 0) {
                Z().setVisibility(0);
                V().setVisibility(8);
                MessageRedDotView Y = Y();
                Y.setVisibility(0);
                Y.refresh(data.d());
                TbLog defaultLog = DefaultLog.getInstance();
                defaultLog.d("MsgTabNotifyRemind", "[消息Tab]-通知tab: " + data.c().getTitle() + "item 展现未读数View 未读数 = " + data.d());
                return;
            }
            TbLog defaultLog2 = DefaultLog.getInstance();
            defaultLog2.d("MsgTabNotifyRemind", "[消息Tab]-通知tab: " + data.c().getTitle() + "item 隐藏红点未读数View 未读数 = " + data.d());
            Z().setVisibility(8);
            V().setVisibility(0);
        }
    }

    public final TextView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.k;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardAbs");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final LinearLayout T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            LinearLayout linearLayout = this.i;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final TextView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ImageView imageView = this.m;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final TbImageView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TbImageView tbImageView = this.h;
            if (tbImageView != null) {
                return tbImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
            return null;
        }
        return (TbImageView) invokeV.objValue;
    }

    public final s89 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (s89) this.o.getValue();
        }
        return (s89) invokeV.objValue;
    }

    public final MessageRedDotView Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            MessageRedDotView messageRedDotView = this.l;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final LinearLayout Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            LinearLayout linearLayout = this.n;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mStatusView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final void a0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l79 l79Var = this.p;
            if (l79Var != null) {
                i = l79Var.d();
            } else {
                i = 0;
            }
            s89 X = X();
            ra9.a.a(i);
            X.b(this.f, i);
        }
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            s89 X = X();
            ra9.a.c();
            ra9.a.g();
            X.d(this.f);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            s89 X = X();
            ra9.a.e();
            X.e(this.f);
        }
    }

    public final void b0() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            l79 l79Var = this.p;
            if (l79Var != null) {
                i = l79Var.d();
            } else {
                i = 0;
            }
            s89 X = X();
            ra9.a.b(i);
            ra9.a.f(this.f.getContext());
            X.c(this.f, i);
        }
    }

    public final void e0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.k = textView;
        }
    }

    public final void f0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.i = linearLayout;
        }
    }

    public final void g0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void h0(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.m = imageView;
        }
    }

    public final void i0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbImageView) == null) {
            Intrinsics.checkNotNullParameter(tbImageView, "<set-?>");
            this.h = tbImageView;
        }
    }

    public final void j0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.l = messageRedDotView;
        }
    }

    public final void k0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.n = linearLayout;
        }
    }

    @Override // com.baidu.tieba.j19
    public void onChangeSkinType(int i) {
        NotifyType c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            EMManager.from(U()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(S()).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            WebPManager.setPureDrawable(V(), R.drawable.obfuscated_res_0x7f0808c9, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            l79 l79Var = this.p;
            if (l79Var != null && (c = l79Var.c()) != null) {
                WebPManager.setMaskDrawable(W(), c.getIcon(), WebPManager.ResourceStateType.NORMAL_PRESS);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        NotifyType notifyType;
        int i;
        NotifyType c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, view2) == null) {
            l79 l79Var = this.p;
            String str = null;
            if (l79Var != null) {
                notifyType = l79Var.c();
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
                            c0();
                        }
                    } else {
                        d0();
                    }
                } else {
                    a0();
                }
            } else {
                b0();
            }
            X().a(this.p);
            TbLog defaultLog = DefaultLog.getInstance();
            StringBuilder sb = new StringBuilder();
            sb.append("[消息Tab-通知Tab] 点击进入二级页，消除「");
            l79 l79Var2 = this.p;
            if (l79Var2 != null && (c = l79Var2.c()) != null) {
                str = c.getTitle();
            }
            sb.append(str);
            sb.append("Item」红点");
            defaultLog.i("MsgTabNotifyRemind", sb.toString());
            ra9.a.d(this.p);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Y().setThreeDotMode(2);
            TbImageView W = W();
            W.setConrers(15);
            W.setScaleType(ImageView.ScaleType.CENTER_CROP);
            W.setOnClickListener(this);
            T().setOnClickListener(this);
        }
    }
}

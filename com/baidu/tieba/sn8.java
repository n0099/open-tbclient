package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel;
import com.baidu.tieba.no8;
import com.baidu.tieba.oo8;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class sn8 extends BaseView<oo8, no8, MsgTabInviteAnswerViewModel> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment e;
    public ImageView f;
    public RelativeLayout g;
    public TextView h;
    public TextView i;
    public TextView j;
    public MessageRedDotView k;
    public ImageView l;
    public RoundRelativeLayout m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sn8(BaseFragment mFragment) {
        super(R.layout.obfuscated_res_0x7f0d0629);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mFragment};
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
        Intrinsics.checkNotNullParameter(mFragment, "mFragment");
        this.e = mFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            int i = 1;
            if (l().getVisibility() == 0 && r95.p().l("key_question_msg_no_remind", false)) {
                i = 2;
            }
            V(0);
            Context requireContext = this.e.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mFragment.requireContext()");
            m().k(new no8.a(requireContext, i));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            X((ImageView) g(R.id.obfuscated_res_0x7f09115c));
            c0((RelativeLayout) g(R.id.obfuscated_res_0x7f09251f));
            d0((TextView) g(R.id.obfuscated_res_0x7f09115f));
            Y((TextView) g(R.id.obfuscated_res_0x7f09115b));
            b0((TextView) g(R.id.obfuscated_res_0x7f09115e));
            a0((MessageRedDotView) g(R.id.obfuscated_res_0x7f09115d));
            this.m = (RoundRelativeLayout) g(R.id.obfuscated_res_0x7f090295);
            Z((ImageView) g(R.id.obfuscated_res_0x7f0909fc));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: U */
    public void D(oo8 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof oo8.b) {
                W(((oo8.b) state).a());
            } else if (state instanceof oo8.a) {
                V(((oo8.a) state).a());
            }
        }
    }

    public final void X(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.f = imageView;
        }
    }

    public final void Y(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void Z(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.l = imageView;
        }
    }

    public final void a0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.k = messageRedDotView;
        }
    }

    public final void b0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void c0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.g = relativeLayout;
        }
    }

    public final void d0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.h = textView;
        }
    }

    public final ImageView J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ImageView imageView = this.f;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardIcon");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final TextView M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.i;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageView imageView = this.l;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final MessageRedDotView O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageRedDotView messageRedDotView = this.k;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedView");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final TextView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mShield");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RelativeLayout relativeLayout = this.g;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTextContainer");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final TextView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TextView textView = this.h;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: T */
    public MsgTabInviteAnswerViewModel q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.e).get(MsgTabInviteAnswerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mFragm…werViewModel::class.java)");
            return (MsgTabInviteAnswerViewModel) viewModel;
        }
        return (MsgTabInviteAnswerViewModel) invokeV.objValue;
    }

    public final void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i > 0) {
                if (r95.p().l("key_question_msg_no_remind", false)) {
                    i = 0;
                }
                N().setVisibility(8);
                O().setThreeDotMode(2);
                O().f(i);
                O().setVisibility(0);
                M().setText(R.string.obfuscated_res_0x7f0f07e1);
                return;
            }
            O().setVisibility(8);
            N().setVisibility(0);
            M().setText(R.string.obfuscated_res_0x7f0f07e0);
        }
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                int g = xi.g(this.e.getContext(), R.dimen.tbds34);
                pureDrawable.setBounds(new Rect(0, 0, g, g));
                Q().setCompoundDrawables(null, null, pureDrawable, null);
                Q().setVisibility(0);
                return;
            }
            Q().setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            J().setOnClickListener(this);
            R().setOnClickListener(this);
            S().setOnClickListener(this);
            M().setOnClickListener(this);
            O().setOnClickListener(this);
            V(r95.p().q(r95.t("msg_tab_entrance_invitation_answer_unread_num"), 0));
        }
    }

    @Override // com.baidu.tieba.sd8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            WebPManager.setMaskDrawable(J(), R.drawable.obfuscated_res_0x7f0811d3, WebPManager.ResourceStateType.NORMAL);
            RoundRelativeLayout roundRelativeLayout = this.m;
            RoundRelativeLayout roundRelativeLayout2 = null;
            if (roundRelativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                roundRelativeLayout = null;
            }
            roundRelativeLayout.setAllCornerRound(xi.g(this.e.getContext(), R.dimen.tbds31));
            RoundRelativeLayout roundRelativeLayout3 = this.m;
            if (roundRelativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                roundRelativeLayout2 = roundRelativeLayout3;
            }
            s75 d = s75.d(roundRelativeLayout2);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            WebPManager.setPureDrawable(N(), R.drawable.obfuscated_res_0x7f08089c, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            s75 d2 = s75.d(S());
            d2.C(R.dimen.T_X05);
            d2.D(R.string.F_X01);
            d2.x(R.color.CAM_X0105);
            s75 d3 = s75.d(M());
            d3.x(R.color.CAM_X0109);
            d3.D(R.string.F_X01);
            d3.C(R.dimen.T_X07);
        }
    }
}

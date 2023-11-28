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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tieba.da9;
import com.baidu.tieba.ea9;
import com.baidu.tieba.immessagecenter.arch.view.BaseView;
import com.baidu.tieba.immessagecenter.msgtab.ui.vm.MsgTabInviteAnswerViewModel;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class l99 extends BaseView<ea9, da9, MsgTabInviteAnswerViewModel> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment f;
    public ImageView g;
    public RelativeLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public MessageRedDotView l;
    public ImageView m;
    public RoundRelativeLayout n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l99(BaseFragment mFragment) {
        super(R.layout.obfuscated_res_0x7f0d0672);
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
        this.f = mFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            int i = 1;
            if (n().getVisibility() == 0 && SharedPrefHelper.getInstance().getBoolean("key_question_msg_no_remind", false)) {
                i = 2;
            }
            Y(0);
            Context requireContext = this.f.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "mFragment.requireContext()");
            q().k(new da9.a(requireContext, i));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            a0((ImageView) j(R.id.obfuscated_res_0x7f09120a));
            f0((RelativeLayout) j(R.id.obfuscated_res_0x7f092694));
            g0((TextView) j(R.id.obfuscated_res_0x7f09120d));
            b0((TextView) j(R.id.obfuscated_res_0x7f091209));
            e0((TextView) j(R.id.obfuscated_res_0x7f09120c));
            d0((MessageRedDotView) j(R.id.obfuscated_res_0x7f09120b));
            this.n = (RoundRelativeLayout) j(R.id.obfuscated_res_0x7f0902c3);
            c0((ImageView) j(R.id.obfuscated_res_0x7f090a6c));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    /* renamed from: X */
    public void J(ea9 state) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state instanceof ea9.b) {
                Z(((ea9.b) state).a());
            } else if (state instanceof ea9.a) {
                Y(((ea9.a) state).a());
            }
        }
    }

    public final void a0(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.g = imageView;
        }
    }

    public final void b0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void c0(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imageView) == null) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.m = imageView;
        }
    }

    public final void d0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.l = messageRedDotView;
        }
    }

    public final void e0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.k = textView;
        }
    }

    public final void f0(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.h = relativeLayout;
        }
    }

    public final void g0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final ImageView P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ImageView imageView = this.g;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardIcon");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final TextView Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mContent");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageView imageView = this.m;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mEnterBtn");
            return null;
        }
        return (ImageView) invokeV.objValue;
    }

    public final MessageRedDotView S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageRedDotView messageRedDotView = this.l;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedView");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final TextView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.k;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mShield");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mTextContainer");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final TextView V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            TextView textView = this.i;
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
    /* renamed from: W */
    public MsgTabInviteAnswerViewModel u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ViewModel viewModel = new ViewModelProvider(this.f).get(MsgTabInviteAnswerViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mFragm…werViewModel::class.java)");
            return (MsgTabInviteAnswerViewModel) viewModel;
        }
        return (MsgTabInviteAnswerViewModel) invokeV.objValue;
    }

    public final void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i > 0) {
                if (SharedPrefHelper.getInstance().getBoolean("key_question_msg_no_remind", false)) {
                    i = 0;
                }
                R().setVisibility(8);
                S().setThreeDotMode(2);
                S().refresh(i);
                S().setVisibility(0);
                Q().setText(R.string.obfuscated_res_0x7f0f0807);
                return;
            }
            S().setVisibility(8);
            R().setVisibility(0);
            Q().setText(R.string.obfuscated_res_0x7f0f0806);
        }
    }

    public final void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            if (z) {
                Drawable pureDrawable = SvgManager.getInstance().getPureDrawable(R.drawable.ic_icon_pure_shield_svg, R.color.CAM_X1111, SvgManager.SvgResourceStateType.NORMAL);
                int dimens = BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds34);
                pureDrawable.setBounds(new Rect(0, 0, dimens, dimens));
                T().setCompoundDrawables(null, null, pureDrawable, null);
                T().setVisibility(0);
                return;
            }
            T().setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            P().setOnClickListener(this);
            U().setOnClickListener(this);
            V().setOnClickListener(this);
            Q().setOnClickListener(this);
            S().setOnClickListener(this);
            Y(SharedPrefHelper.getInstance().getInt(SharedPrefHelper.getSharedPrefKeyWithAccount("msg_tab_entrance_invitation_answer_unread_num"), 0));
        }
    }

    @Override // com.baidu.tieba.e19
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            WebPManager.setMaskDrawable(P(), R.drawable.obfuscated_res_0x7f08125b, WebPManager.ResourceStateType.NORMAL);
            RoundRelativeLayout roundRelativeLayout = this.n;
            RoundRelativeLayout roundRelativeLayout2 = null;
            if (roundRelativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                roundRelativeLayout = null;
            }
            roundRelativeLayout.setAllCornerRound(BdUtilHelper.getDimens(this.f.getContext(), R.dimen.tbds31));
            RoundRelativeLayout roundRelativeLayout3 = this.n;
            if (roundRelativeLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            } else {
                roundRelativeLayout2 = roundRelativeLayout3;
            }
            EMManager.from(roundRelativeLayout2).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
            WebPManager.setPureDrawable(R(), R.drawable.obfuscated_res_0x7f0808c9, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
            EMManager.from(V()).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0105);
            EMManager.from(Q()).setTextColor(R.color.CAM_X0109).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X08);
        }
    }
}

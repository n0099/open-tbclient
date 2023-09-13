package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class xw8 extends jl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity f;
    public TextView g;
    public ImageView h;
    public BarImageView i;
    public View j;
    public TextView k;
    public ImageView l;
    public int m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xw8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d0654);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = context;
        this.m = -1;
    }

    public static final Boolean S(NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newsRemindMessage)) == null) {
            if (newsRemindMessage != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }

    public final String R(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i > 100) {
                return "99+";
            }
            if (i > 0) {
                return String.valueOf(i);
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public static final Pair T(xw8 this$0, NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, newsRemindMessage)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = this$0.m;
            int i2 = 0;
            if (i == 2) {
                i2 = newsRemindMessage.getChatCount();
                z = newsRemindMessage.hasChatRemind();
            } else {
                if (i == 1) {
                    i2 = newsRemindMessage.getMsgCount() + newsRemindMessage.getNotificationCount();
                }
                z = false;
            }
            return new Pair(Integer.valueOf(i2), Boolean.valueOf(z));
        }
        return (Pair) invokeLL.objValue;
    }

    public static final void U(xw8 this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.W(((Number) pair.getFirst()).intValue(), ((Boolean) pair.getSecond()).booleanValue());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = (ImageView) j(R.id.iv_icon);
            this.g = (TextView) j(R.id.new_message);
            this.j = j(R.id.obfuscated_res_0x7f091951);
            this.i = (BarImageView) j(R.id.bg_view);
            this.k = (TextView) j(R.id.tv_title);
            this.l = (ImageView) j(R.id.obfuscated_res_0x7f09124a);
        }
    }

    public final void P(qu8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.m = data.getType();
            ImageView imageView = null;
            if (data.getType() == 2) {
                TextView textView = this.k;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView = null;
                }
                textView.setText(R.string.obfuscated_res_0x7f0f0404);
                ImageView imageView2 = this.h;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080fef);
            } else {
                TextView textView2 = this.k;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView2 = null;
                }
                textView2.setText(R.string.msg_notify);
                ImageView imageView3 = this.h;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView3;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080ffa);
            }
            l().setSelected(data.b());
        }
    }

    public final void Q(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.ALPHA, f, f2);
            ImageView imageView = this.l;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
                imageView = null;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView, ofFloat);
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(m…kgroundView, alphaProper)");
            ofPropertyValuesHolder.setDuration(200L);
            ofPropertyValuesHolder.start();
        }
    }

    public final void W(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TextView textView = null;
            if (i > 0) {
                View view2 = this.j;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view2 = null;
                }
                un6.f(view2, 8);
                TextView textView2 = this.g;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                    textView2 = null;
                }
                un6.f(textView2, 0);
                TextView textView3 = this.g;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView3;
                }
                textView.setText(R(i));
            } else if (z) {
                View view3 = this.j;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view3 = null;
                }
                un6.f(view3, 0);
                TextView textView4 = this.g;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView4;
                }
                un6.f(textView, 8);
            } else {
                View view4 = this.j;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view4 = null;
                }
                un6.f(view4, 8);
                TextView textView5 = this.g;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView5;
                }
                un6.f(textView, 8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.al8
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            tfc k = k();
            if (k != null) {
                k.a(NewsRemindMsgMonitor.f.a().k().k(new lbc() { // from class: com.baidu.tieba.fw8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.lbc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? xw8.S((NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).p(new lbc() { // from class: com.baidu.tieba.pw8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.lbc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? xw8.T(xw8.this, (NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).H(new gbc() { // from class: com.baidu.tieba.sw8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.gbc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            xw8.U(xw8.this, (Pair) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.il8
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.c(z);
            TextView textView = null;
            if (z) {
                BarImageView barImageView = this.i;
                if (barImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                    barImageView = null;
                }
                un6.f(barImageView, 0);
                TextView textView2 = this.k;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                } else {
                    textView = textView2;
                }
                un6.f(textView, 8);
            } else {
                BarImageView barImageView2 = this.i;
                if (barImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                    barImageView2 = null;
                }
                un6.f(barImageView2, 8);
                TextView textView3 = this.k;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                } else {
                    textView = textView3;
                }
                un6.f(textView, 0);
            }
            if (z) {
                Q(0.0f, 1.0f);
            } else {
                Q(1.0f, 0.0f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final BaseFragmentActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.il8
    public void onChangeSkinType(int i) {
        int color;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            int i3 = R.color.CAM_X0341;
            TextView textView = null;
            if (i == 4) {
                ImageView imageView = this.h;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView = null;
                }
                if (l().isSelected()) {
                    i3 = R.color.CAM_X0622;
                }
                imageView.setColorFilter(SkinManager.getColor(i3));
            } else {
                ImageView imageView2 = this.h;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView2 = null;
                }
                if (l().isSelected()) {
                    color = -1;
                } else {
                    color = SkinManager.getColor(R.color.CAM_X0341);
                }
                imageView2.setColorFilter(color);
            }
            if (l().isSelected()) {
                i2 = R.color.CAM_X0201;
            } else {
                i2 = R.color.CAM_X0202;
            }
            ImageView imageView3 = this.l;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
                imageView3 = null;
            }
            imageView3.setColorFilter(SkinManager.getColor(i2));
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view2 = null;
            }
            EMManager.from(view2).setBorderColor(i2).setBackGroundColor(R.color.CAM_X0301);
            TextView textView2 = this.g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView2 = null;
            }
            EMManager.from(textView2).setTextColor(R.color.CAM_X0101).setBorderColor(i2).setBackGroundColor(R.color.CAM_X0301);
            TextView textView3 = this.k;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
            } else {
                textView = textView3;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0107);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void p(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = this.k;
            BarImageView barImageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                textView = null;
            }
            EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0107);
            TextView textView2 = this.g;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView2 = null;
            }
            EMManager.from(textView2).setCorner(R.string.J_X07).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0301);
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view2 = null;
            }
            EMManager.from(view2).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0301);
            BarImageView barImageView2 = this.i;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
            } else {
                barImageView = barImageView2;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f080ffb);
            barImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080ffb);
        }
    }
}

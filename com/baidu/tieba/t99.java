package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
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
public final class t99 extends j19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity f;
    public ViewGroup g;
    public BarImageView h;
    public TextView i;
    public ImageView j;
    public BarImageView k;
    public View l;
    public TextView m;
    public ImageView n;
    public int o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t99(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d0674);
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
        this.o = -1;
    }

    public static final Boolean U(NewsRemindMessage newsRemindMessage) {
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

    public final String T(int i) {
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

    public static final Pair V(t99 this$0, NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, newsRemindMessage)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int i = this$0.o;
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

    public static final void W(t99 this$0, Pair pair) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, pair) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.X(((Number) pair.getFirst()).intValue(), ((Boolean) pair.getSecond()).booleanValue());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (ViewGroup) j(R.id.obfuscated_res_0x7f091826);
            this.h = (BarImageView) j(R.id.obfuscated_res_0x7f09181d);
            this.j = (ImageView) j(R.id.iv_icon);
            this.i = (TextView) j(R.id.new_message);
            this.l = j(R.id.obfuscated_res_0x7f091a22);
            this.k = (BarImageView) j(R.id.bg_view);
            this.m = (TextView) j(R.id.tv_title);
            this.n = (ImageView) j(R.id.obfuscated_res_0x7f0912b9);
        }
    }

    public final void R(l79 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.o = data.b();
            ImageView imageView = null;
            if (data.b() == 2) {
                TextView textView = this.m;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView = null;
                }
                textView.setText(R.string.obfuscated_res_0x7f0f040f);
                ImageView imageView2 = this.j;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView2;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f081021);
            } else {
                TextView textView2 = this.m;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView2 = null;
                }
                textView2.setText(R.string.msg_notify);
                ImageView imageView3 = this.j;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView3;
                }
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08102c);
            }
            n().setSelected(data.c());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.i19
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            super.d(z);
            int i = 0;
            ViewGroup viewGroup = null;
            if (z) {
                BarImageView barImageView = this.k;
                if (barImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                    barImageView = null;
                }
                rk6.f(barImageView, 0);
                TextView textView = this.m;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView = null;
                }
                rk6.f(textView, 8);
            } else {
                BarImageView barImageView2 = this.k;
                if (barImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                    barImageView2 = null;
                }
                rk6.f(barImageView2, 8);
                TextView textView2 = this.m;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                    textView2 = null;
                }
                rk6.f(textView2, 0);
            }
            BarImageView barImageView3 = this.h;
            if (barImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgFrameBorderView");
                barImageView3 = null;
            }
            if (!z) {
                i = 8;
            }
            barImageView3.setVisibility(i);
            if (z) {
                S(0.0f, 1.0f);
            } else {
                S(1.0f, 0.0f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            if (z) {
                ViewGroup viewGroup2 = this.g;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContentContainerView");
                } else {
                    viewGroup = viewGroup2;
                }
                oa9.a(viewGroup);
            }
        }
    }

    public final void S(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.ALPHA, f, f2);
            ImageView imageView = this.n;
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

    public final void X(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            TextView textView = null;
            if (i > 0) {
                View view2 = this.l;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view2 = null;
                }
                rk6.f(view2, 8);
                TextView textView2 = this.i;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                    textView2 = null;
                }
                rk6.f(textView2, 0);
                TextView textView3 = this.i;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView3;
                }
                textView.setText(T(i));
            } else if (z) {
                View view3 = this.l;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view3 = null;
                }
                rk6.f(view3, 0);
                TextView textView4 = this.i;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView4;
                }
                rk6.f(textView, 8);
            } else {
                View view4 = this.l;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                    view4 = null;
                }
                rk6.f(view4, 8);
                TextView textView5 = this.i;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView5;
                }
                rk6.f(textView, 8);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.a19
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.b();
            gtc k = k();
            if (k != null) {
                k.a(NewsRemindMsgMonitor.f.a().k().k(new woc() { // from class: com.baidu.tieba.a99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.woc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? t99.U((NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).p(new woc() { // from class: com.baidu.tieba.l99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.woc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? t99.V(t99.this, (NewsRemindMessage) obj) : invokeL.objValue;
                    }
                }).H(new roc() { // from class: com.baidu.tieba.n99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.roc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            t99.W(t99.this, (Pair) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.i19
    public void onChangeSkinType(int i) {
        int color;
        int i2;
        int color2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            BarImageView barImageView = null;
            if (i == 4) {
                ImageView imageView = this.j;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView = null;
                }
                if (n().isSelected()) {
                    color2 = SkinManager.getColor(R.color.CAM_X0622);
                } else {
                    color2 = SkinManager.getColor(R.color.CAM_X0341);
                }
                imageView.setColorFilter(color2);
            } else {
                ImageView imageView2 = this.j;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    imageView2 = null;
                }
                if (n().isSelected()) {
                    color = -1;
                } else {
                    color = SkinManager.getColor(R.color.CAM_X0341);
                }
                imageView2.setColorFilter(color);
            }
            if (n().isSelected()) {
                i2 = R.color.CAM_X0201;
            } else {
                i2 = R.color.CAM_X0202;
            }
            ImageView imageView3 = this.n;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
                imageView3 = null;
            }
            imageView3.setColorFilter(SkinManager.getColor(i2));
            View view2 = this.l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view2 = null;
            }
            EMManager.from(view2).setBorderColor(i2).setBackGroundColor(R.color.CAM_X0301);
            TextView textView = this.i;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0101).setBorderColor(i2).setBackGroundColor(R.color.CAM_X0301);
            TextView textView2 = this.m;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                textView2 = null;
            }
            EMManager.from(textView2).setTextColor(R.color.CAM_X0107);
            BarImageView barImageView2 = this.h;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgFrameBorderView");
            } else {
                barImageView = barImageView2;
            }
            barImageView.setStrokeColorResId(R.color.CAM_X0341);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = this.m;
            BarImageView barImageView = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleView");
                textView = null;
            }
            EMManager.from(textView).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0107);
            BarImageView barImageView2 = this.h;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgFrameBorderView");
                barImageView2 = null;
            }
            barImageView2.setShowOval(true);
            barImageView2.setShowOuterBorder(true);
            barImageView2.setShowInnerBorder(false);
            barImageView2.setDefaultBgResource(R.color.CAM_X0211);
            barImageView2.setStrokeWith(BdUtilHelper.getDimens(context, R.dimen.tbds5));
            barImageView2.setStrokeColorResId(R.color.CAM_X0341);
            TextView textView2 = this.i;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView2 = null;
            }
            EMManager.from(textView2).setCorner(R.string.J_X07).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0301);
            View view2 = this.l;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNewMessageRemind");
                view2 = null;
            }
            EMManager.from(view2).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0301);
            BarImageView barImageView3 = this.k;
            if (barImageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
            } else {
                barImageView = barImageView3;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setDefaultResource(R.drawable.obfuscated_res_0x7f08102d);
            barImageView.setDefaultBgResource(R.drawable.obfuscated_res_0x7f08102d);
        }
    }
}

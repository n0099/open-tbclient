package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.tieba.immessagecenter.msgtab.ui.view.MsgTabNavTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class s99 extends j19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity f;
    public ViewGroup g;
    public BarImageView h;
    public BarImageView i;
    public MsgTabNavTextView j;
    public ImageView k;
    public TextView l;
    public Long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s99(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d0673);
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
    }

    public final void R(l79 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Long valueOf = Long.valueOf(data.a());
            this.m = valueOf;
            if (valueOf != null) {
                n().setTag(Long.valueOf(valueOf.longValue()));
            }
            K(data.c());
        }
    }

    public static final Boolean T(s99 this$0, Map map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, this$0, map)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.m != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final MsgTabForumData U(s99 this$0, Map it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, it)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return (MsgTabForumData) it.get(this$0.m);
        }
        return (MsgTabForumData) invokeLL.objValue;
    }

    public static final void V(s99 this$0, MsgTabForumData msgTabForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, msgTabForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.W(msgTabForumData);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (ViewGroup) j(R.id.obfuscated_res_0x7f0906ec);
            this.i = (BarImageView) j(R.id.iv_icon);
            this.h = (BarImageView) j(R.id.obfuscated_res_0x7f0906eb);
            this.j = (MsgTabNavTextView) j(R.id.obfuscated_res_0x7f092887);
            this.k = (ImageView) j(R.id.obfuscated_res_0x7f0912b9);
            this.l = (TextView) j(R.id.tv_tips);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.a19
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.b();
            gtc k = k();
            if (k != null) {
                k.a(ForumChannelDataObs.b.a().b().k(new woc() { // from class: com.baidu.tieba.z89
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.woc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? s99.T(s99.this, (Map) obj) : invokeL.objValue;
                    }
                }).x().p(new woc() { // from class: com.baidu.tieba.d99
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.woc
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? s99.U(s99.this, (Map) obj) : invokeL.objValue;
                    }
                }).s(noc.b()).H(new roc() { // from class: com.baidu.tieba.y89
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.roc
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            s99.V(s99.this, (MsgTabForumData) obj);
                        }
                    }
                }));
            }
        }
    }

    public final void S(float f, float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ImageView imageView = this.k;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
                imageView = null;
            }
            if (f2 == imageView.getAlpha()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(Key.ALPHA, f, f2);
            ImageView imageView3 = this.k;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
            } else {
                imageView2 = imageView3;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(imageView2, ofFloat);
            Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(m…kgroundView, alphaProper)");
            ofPropertyValuesHolder.setDuration(200L);
            ofPropertyValuesHolder.start();
        }
    }

    public final void W(MsgTabForumData msgTabForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, msgTabForumData) == null) && msgTabForumData != null) {
            BarImageView barImageView = this.i;
            TextView textView = null;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView = null;
            }
            if (!(!Intrinsics.areEqual(barImageView.getTag(), msgTabForumData.getIcon()))) {
                barImageView = null;
            }
            int i = 0;
            if (barImageView != null) {
                barImageView.setTag(msgTabForumData.getIcon());
                barImageView.setImageDrawable(null);
                barImageView.setDefaultBgResource(R.drawable.pic_use_header_28_n);
                barImageView.startLoad(msgTabForumData.getIcon(), 10, false);
            }
            if (TextUtils.isEmpty(msgTabForumData.getHotNumsText())) {
                MsgTabNavTextView msgTabNavTextView = this.j;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                msgTabNavTextView.setVisibility(8);
            } else {
                MsgTabNavTextView msgTabNavTextView2 = this.j;
                if (msgTabNavTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView2 = null;
                }
                msgTabNavTextView2.setText(msgTabForumData.getHotNumsText());
                MsgTabNavTextView msgTabNavTextView3 = this.j;
                if (msgTabNavTextView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView3 = null;
                }
                msgTabNavTextView3.setVisibility(0);
            }
            TextView textView2 = this.l;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
            } else {
                textView = textView2;
            }
            if (msgTabForumData.getHasActivity() != 1) {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.i19
    public void d(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.d(z);
            if (z) {
                S(0.0f, 1.0f);
            } else {
                S(1.0f, 0.0f);
            }
            BarImageView barImageView = this.h;
            ViewGroup viewGroup = null;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgFrameBorderView");
                barImageView = null;
            }
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            barImageView.setVisibility(i);
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

    @Override // com.baidu.tieba.i19
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            BarImageView barImageView = null;
            if (B()) {
                MsgTabNavTextView msgTabNavTextView = this.j;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                EMManager.from(msgTabNavTextView).setTextColor(R.color.CAM_X0622).setBorderColor(R.color.CAM_X0201).setBorderWidth(R.dimen.tbds6).setBackGroundColor(R.color.CAM_X0341);
                TextView textView = this.l;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
                    textView = null;
                }
                EMManager.from(textView).setTextColor(R.color.CAM_X0101).setBorderColor(R.color.CAM_X0201).setBackGroundColor(R.color.CAM_X0319);
            } else {
                MsgTabNavTextView msgTabNavTextView2 = this.j;
                if (msgTabNavTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView2 = null;
                }
                EMManager.from(msgTabNavTextView2).setTextColor(R.color.CAM_X0622).setBorderColor(R.color.CAM_X0202).setBorderWidth(R.dimen.tbds6).setBackGroundColorString("#FFA1B2E6");
                TextView textView2 = this.l;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
                    textView2 = null;
                }
                EMManager.from(textView2).setTextColor(R.color.CAM_X0101).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0319);
            }
            ImageView imageView = this.k;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
                imageView = null;
            }
            imageView.setColorFilter(SkinManager.getColor(R.color.CAM_X0201));
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
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            TextView textView = null;
            Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.obfuscated_res_0x7f080a94, null);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, ResourcesCompat.getColor(context.getResources(), R.color.CAM_X0622, null));
                MsgTabNavTextView msgTabNavTextView = this.j;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                msgTabNavTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            BarImageView barImageView = this.h;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgFrameBorderView");
                barImageView = null;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(true);
            barImageView.setShowInnerBorder(false);
            barImageView.setDefaultBgResource(R.color.CAM_X0211);
            barImageView.setStrokeWith(BdUtilHelper.getDimens(context, R.dimen.tbds5));
            barImageView.setStrokeColorResId(R.color.CAM_X0341);
            BarImageView barImageView2 = this.i;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView2 = null;
            }
            barImageView2.setShowOval(true);
            barImageView2.setShowOuterBorder(true);
            barImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            MsgTabNavTextView msgTabNavTextView2 = this.j;
            if (msgTabNavTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                msgTabNavTextView2 = null;
            }
            EMManager.from(msgTabNavTextView2).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setCorner(R.string.J_X07).setTextColor(R.color.CAM_X0622).setBorderWidth(R.dimen.tbds6).setBorderColor(R.color.CAM_X0202);
            TextView textView2 = this.l;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
                textView2 = null;
            }
            textView2.setText(R.string.card_promotion_text);
            TextView textView3 = this.l;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTipsView");
            } else {
                textView = textView3;
            }
            EMManager.from(textView).setCorner(R.string.J_X07).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0319);
        }
    }
}

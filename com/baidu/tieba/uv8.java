package com.baidu.tieba;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.InputDeviceCompat;
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
public final class uv8 extends hk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity f;
    public BarImageView g;
    public MsgTabNavTextView h;
    public ImageView i;
    public Long j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d0642);
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

    public final void Q(ot8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Long valueOf = Long.valueOf(data.a());
            this.j = valueOf;
            if (valueOf != null) {
                m().setTag(Long.valueOf(valueOf.longValue()));
            }
            J(data.b());
        }
    }

    public static final Boolean S(uv8 this$0, Map map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, this$0, map)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.j != null) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final MsgTabForumData T(uv8 this$0, Map it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, it)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return (MsgTabForumData) it.get(this$0.j);
        }
        return (MsgTabForumData) invokeLL.objValue;
    }

    public static final void U(uv8 this$0, MsgTabForumData msgTabForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, msgTabForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.W(msgTabForumData);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (BarImageView) j(R.id.iv_icon);
            this.h = (MsgTabNavTextView) j(R.id.obfuscated_res_0x7f0927af);
            this.i = (ImageView) j(R.id.obfuscated_res_0x7f091244);
        }
    }

    public final BaseFragmentActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.f;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    public final void R(float f, float f2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            ImageView imageView = this.i;
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
            ImageView imageView3 = this.i;
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
            BarImageView barImageView = this.g;
            MsgTabNavTextView msgTabNavTextView = null;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView = null;
            }
            if (!(!Intrinsics.areEqual(barImageView.getTag(), msgTabForumData.getIcon()))) {
                barImageView = null;
            }
            if (barImageView != null) {
                barImageView.setTag(msgTabForumData.getIcon());
                barImageView.setImageDrawable(null);
                barImageView.setDefaultBgResource(R.drawable.pic_use_header_28_n);
                barImageView.startLoad(msgTabForumData.getIcon(), 10, false);
            }
            if (TextUtils.isEmpty(msgTabForumData.getHotNumsText())) {
                MsgTabNavTextView msgTabNavTextView2 = this.h;
                if (msgTabNavTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                } else {
                    msgTabNavTextView = msgTabNavTextView2;
                }
                msgTabNavTextView.setVisibility(8);
                return;
            }
            MsgTabNavTextView msgTabNavTextView3 = this.h;
            if (msgTabNavTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                msgTabNavTextView3 = null;
            }
            msgTabNavTextView3.setText(msgTabForumData.getHotNumsText());
            MsgTabNavTextView msgTabNavTextView4 = this.h;
            if (msgTabNavTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
            } else {
                msgTabNavTextView = msgTabNavTextView4;
            }
            msgTabNavTextView.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.gk8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            ImageView imageView = null;
            if (s()) {
                MsgTabNavTextView msgTabNavTextView = this.h;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                EMManager.from(msgTabNavTextView).setTextColor(R.color.CAM_X0622).setBorderColor(R.color.CAM_X0201).setBorderWidth(R.dimen.tbds6).setBackGroundColor(R.color.CAM_X0341);
            } else {
                MsgTabNavTextView msgTabNavTextView2 = this.h;
                if (msgTabNavTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView2 = null;
                }
                EMManager.from(msgTabNavTextView2).setTextColor(R.color.CAM_X0622).setBorderColor(R.color.CAM_X0202).setBorderWidth(R.dimen.tbds6).setBackGroundColorString("#FFA1B2E6");
            }
            ImageView imageView2 = this.i;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBackgroundView");
            } else {
                imageView = imageView2;
            }
            imageView.setColorFilter(SkinManager.getColor(R.color.CAM_X0201));
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            MsgTabNavTextView msgTabNavTextView = null;
            Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.obfuscated_res_0x7f080a74, null);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, ResourcesCompat.getColor(context.getResources(), R.color.CAM_X0622, null));
                MsgTabNavTextView msgTabNavTextView2 = this.h;
                if (msgTabNavTextView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView2 = null;
                }
                msgTabNavTextView2.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            BarImageView barImageView = this.g;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView = null;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(true);
            barImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            MsgTabNavTextView msgTabNavTextView3 = this.h;
            if (msgTabNavTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
            } else {
                msgTabNavTextView = msgTabNavTextView3;
            }
            EMManager.from(msgTabNavTextView).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setCorner(R.string.J_X07).setTextColor(R.color.CAM_X0622).setBorderWidth(R.dimen.tbds6).setBorderColor(R.color.CAM_X0202);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.yj8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.c();
            occ k = k();
            if (k != null) {
                k.a(ForumChannelDataObs.b.a().b().k(new g8c() { // from class: com.baidu.tieba.mv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.g8c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? uv8.S(uv8.this, (Map) obj) : invokeL.objValue;
                    }
                }).x().p(new g8c() { // from class: com.baidu.tieba.hv8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.g8c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? uv8.T(uv8.this, (Map) obj) : invokeL.objValue;
                    }
                }).s(x7c.b()).H(new b8c() { // from class: com.baidu.tieba.xu8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.b8c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            uv8.U(uv8.this, (MsgTabForumData) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.gk8
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            super.d(z);
            if (z) {
                R(0.0f, 1.0f);
            } else {
                R(1.0f, 0.0f);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}

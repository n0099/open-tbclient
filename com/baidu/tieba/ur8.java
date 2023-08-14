package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.elementsMaven.EMManager;
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
public final class ur8 extends ig8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity e;
    public TextView f;
    public BarImageView g;
    public BarImageView h;
    public MsgTabNavTextView i;
    public View j;
    public View k;
    public boolean l;
    public Long m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur8(BaseFragmentActivity context) {
        super(R.layout.obfuscated_res_0x7f0d063a);
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
        this.e = context;
    }

    public static final void R(ur8 this$0, MsgTabForumData msgTabForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, msgTabForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.U(msgTabForumData);
        }
    }

    public static final Boolean S(ur8 this$0, Map map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, map)) == null) {
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

    public static final MsgTabForumData T(ur8 this$0, Map it) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, this$0, it)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return (MsgTabForumData) it.get(this$0.m);
        }
        return (MsgTabForumData) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.h = (BarImageView) j(R.id.iv_icon);
            this.g = (BarImageView) j(R.id.obfuscated_res_0x7f091210);
            this.f = (TextView) j(R.id.new_message);
            this.i = (MsgTabNavTextView) j(R.id.obfuscated_res_0x7f09277e);
            this.j = j(R.id.obfuscated_res_0x7f090b45);
            this.k = j(R.id.obfuscated_res_0x7f090b44);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.yf8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            y5c k = k();
            if (k != null) {
                k.a(ForumChannelDataObs.c.a().b().k(new q1c() { // from class: com.baidu.tieba.gr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? ur8.S(ur8.this, (Map) obj) : invokeL.objValue;
                    }
                }).w().p(new q1c() { // from class: com.baidu.tieba.wq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? ur8.T(ur8.this, (Map) obj) : invokeL.objValue;
                    }
                }).s(i1c.b()).H(new m1c() { // from class: com.baidu.tieba.vq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            ur8.R(ur8.this, (MsgTabForumData) obj);
                        }
                    }
                }));
            }
        }
    }

    public final void Q(op8 data) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Long valueOf = Long.valueOf(data.c());
            this.m = valueOf;
            if (valueOf != null) {
                m().setTag(Long.valueOf(valueOf.longValue()));
                if (data.getType() == 6) {
                    z = true;
                } else {
                    z = false;
                }
                this.l = z;
            }
            if (this.l) {
                BarImageView barImageView = this.h;
                ViewGroup.MarginLayoutParams marginLayoutParams = null;
                if (barImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                    barImageView = null;
                }
                ViewGroup.LayoutParams layoutParams = barImageView.getLayoutParams();
                if (layoutParams != null) {
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    }
                    if (marginLayoutParams != null) {
                        marginLayoutParams.setMargins(0, 0, 0, 0);
                    }
                }
            }
            I(data.d());
        }
    }

    public final void U(MsgTabForumData msgTabForumData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msgTabForumData) == null) && msgTabForumData != null) {
            BarImageView barImageView = this.h;
            TextView textView = null;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView = null;
            }
            barImageView.setTag(msgTabForumData.getIcon());
            barImageView.setImageDrawable(null);
            barImageView.setDefaultBgResource(R.drawable.pic_use_header_28_n);
            barImageView.startLoad(msgTabForumData.getIcon(), 10, false);
            if (TextUtils.isEmpty(msgTabForumData.getHotNumsText())) {
                View view2 = this.k;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                    view2 = null;
                }
                view2.setVisibility(8);
            } else {
                MsgTabNavTextView msgTabNavTextView = this.i;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                msgTabNavTextView.setText(msgTabForumData.getHotNumsText());
                View view3 = this.k;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                    view3 = null;
                }
                view3.setVisibility(0);
            }
            if (msgTabForumData.isAtMe() == 1) {
                TextView textView2 = this.f;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                TextView textView3 = this.f;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                } else {
                    textView = textView3;
                }
                textView.setText("@");
                return;
            }
            TextView textView4 = this.f;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
            } else {
                textView = textView4;
            }
            textView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.hg8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            MsgTabNavTextView msgTabNavTextView = this.i;
            BarImageView barImageView = null;
            if (msgTabNavTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                msgTabNavTextView = null;
            }
            EMManager.from(msgTabNavTextView).setTextColor(R.color.CAM_X0622);
            TextView textView = this.f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            EMManager.from(textView).setTextColor(R.color.CAM_X0101).setBackGroundColor(R.color.CAM_X0301);
            View view2 = this.j;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
                view2 = null;
            }
            EMManager.from(view2).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0202);
            if (this.l) {
                View view3 = this.k;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                    view3 = null;
                }
                view3.setSelected(true);
                View view4 = this.k;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                    view4 = null;
                }
                EMManager.from(view4).setBorderColor(R.color.transparent).setBackGroundColor(R.color.transparent);
            } else {
                View view5 = this.k;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                    view5 = null;
                }
                EMManager.from(view5).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0202);
            }
            BarImageView barImageView2 = this.g;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageViewBg");
            } else {
                barImageView = barImageView2;
            }
            barImageView.setStrokeColorResId(R.color.CAM_X0341);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.hg8
    public void d(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            super.d(z);
            BarImageView barImageView = this.g;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageViewBg");
                barImageView = null;
            }
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            barImageView.setVisibility(i);
        }
    }

    public final BaseFragmentActivity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (BaseFragmentActivity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            View view2 = null;
            Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.obfuscated_res_0x7f080a66, null);
            if (drawable != null) {
                DrawableCompat.setTint(drawable, ResourcesCompat.getColor(context.getResources(), R.color.CAM_X0622, null));
                MsgTabNavTextView msgTabNavTextView = this.i;
                if (msgTabNavTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                    msgTabNavTextView = null;
                }
                msgTabNavTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            BarImageView barImageView = this.g;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageViewBg");
                barImageView = null;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(true);
            barImageView.setShowInnerBorder(false);
            barImageView.setDefaultBgResource(R.color.CAM_X0211);
            barImageView.setStrokeWith(BdUtilHelper.getDimens(context, R.dimen.tbds7));
            barImageView.setStrokeColorResId(R.color.CAM_X0341);
            BarImageView barImageView2 = this.h;
            if (barImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                barImageView2 = null;
            }
            barImageView2.setShowOval(true);
            barImageView2.setShowOuterBorder(true);
            barImageView2.setShowInnerBorder(false);
            barImageView2.setStrokeWith(BdUtilHelper.getDimens(context, R.dimen.tbds6));
            barImageView2.setStrokeColorResId(R.color.transparent);
            barImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            MsgTabNavTextView msgTabNavTextView2 = this.i;
            if (msgTabNavTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusTextView");
                msgTabNavTextView2 = null;
            }
            EMManager.from(msgTabNavTextView2).setTextStyle(R.string.F_X02).setTextSize(R.dimen.T_X10).setTextColor(R.color.CAM_X0622);
            View view3 = this.k;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusLayout");
                view3 = null;
            }
            EMManager.from(view3).setCorner(R.string.J_X07).setBorderWidth(R.dimen.tbds6).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0202);
            TextView textView = this.f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUnreadNumTextView");
                textView = null;
            }
            EMManager.from(textView).setCorner(R.string.J_X07).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01).setTextSize(R.dimen.T_X10).setBackGroundColor(R.color.CAM_X0301);
            View view4 = this.j;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMsgCountBgView");
            } else {
                view2 = view4;
            }
            EMManager.from(view2).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X04).setBorderColor(R.color.CAM_X0202).setBackGroundColor(R.color.CAM_X0202);
        }
    }
}

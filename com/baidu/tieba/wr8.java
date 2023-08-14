package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabFunctionData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabImgData;
import com.baidu.tieba.immessagecenter.msgtab.obs.ForumChannelDataObs;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class wr8 extends ig8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragmentActivity e;
    public BarImageView f;
    public ImageView g;
    public long h;
    public Drawable i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wr8(BaseFragmentActivity mContext) {
        super(R.layout.obfuscated_res_0x7f0d063d);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mContext};
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
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.e = mContext;
        this.h = -1L;
    }

    public static final Boolean S(wr8 this$0, Map map) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, this$0, map)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.h != -1) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }

    public static final MsgTabFunctionData T(wr8 this$0, Map map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, this$0, map)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            return (MsgTabFunctionData) map.get(Long.valueOf(this$0.h));
        }
        return (MsgTabFunctionData) invokeLL.objValue;
    }

    public static final void U(wr8 this$0, MsgTabFunctionData msgTabFunctionData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, msgTabFunctionData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.R(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.g = (ImageView) j(R.id.iv_icon);
            this.f = (BarImageView) j(R.id.bg_view);
        }
    }

    public final void Q(op8 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.h = data.c();
            R(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void R(int i) {
        MsgTabFunctionData f;
        MsgTabImgData icon;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (f = ForumChannelDataObs.c.a().f(this.h)) != null && (icon = f.getIcon()) != null) {
            ImageView imageView = null;
            if (i == 4) {
                RequestBuilder error = Glide.with((FragmentActivity) this.e).load(icon.getDarkImg()).placeholder(this.i).error(this.i);
                ImageView imageView2 = this.g;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
                } else {
                    imageView = imageView2;
                }
                error.into(imageView);
                return;
            }
            RequestBuilder error2 = Glide.with((FragmentActivity) this.e).load(icon.getNormalImg()).placeholder(this.i).error(this.i);
            ImageView imageView3 = this.g;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIconImageView");
            } else {
                imageView = imageView3;
            }
            error2.into(imageView);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView, com.baidu.tieba.yf8
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c();
            y5c k = k();
            if (k != null) {
                k.a(ForumChannelDataObs.c.a().d().k(new q1c() { // from class: com.baidu.tieba.xq8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? wr8.S(wr8.this, (Map) obj) : invokeL.objValue;
                    }
                }).w().p(new q1c() { // from class: com.baidu.tieba.nr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.q1c
                    public final Object call(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) ? wr8.T(wr8.this, (Map) obj) : invokeL.objValue;
                    }
                }).s(i1c.b()).H(new m1c() { // from class: com.baidu.tieba.br8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.m1c
                    public final void call(Object obj) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                            wr8.U(wr8.this, (MsgTabFunctionData) obj);
                        }
                    }
                }));
            }
        }
    }

    @Override // com.baidu.tieba.hg8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            R(i);
            BarImageView barImageView = this.f;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                barImageView = null;
            }
            barImageView.setDefaultResource(R.color.CAM_X0211);
            barImageView.setDefaultBgResource(R.color.CAM_X0211);
            Drawable drawable = this.i;
            if (drawable != null) {
                DrawableCompat.setTint(drawable, SkinManager.getColor(R.color.CAM_X0341));
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void q(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            BarImageView barImageView = this.f;
            if (barImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBgImageView");
                barImageView = null;
            }
            barImageView.setShowOval(true);
            barImageView.setShowOuterBorder(false);
            barImageView.setDefaultResource(R.color.CAM_X0211);
            barImageView.setDefaultBgResource(R.color.CAM_X0211);
            this.i = ResourcesCompat.getDrawable(context.getResources(), R.drawable.obfuscated_res_0x7f0810fa, null);
        }
    }
}

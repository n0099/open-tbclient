package com.bytedance.sdk.openadsdk.core.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ILoaderListener;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.component.image.ResultType;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.img.ImageLoaderWrapper;
import com.bytedance.sdk.openadsdk.q.b;
import com.bytedance.sdk.openadsdk.q.s;
/* loaded from: classes9.dex */
public class DynamicImageView extends DynamicBaseWidgetImp {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicImageView(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull f fVar) {
        super(context, dynamicRootView, fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, dynamicRootView, fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (DynamicRootView) objArr2[1], (f) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (this.f66371j.m() > 0.0f) {
            TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context);
            this.n = tTRoundRectImageView;
            tTRoundRectImageView.setXRound(s.d(context, this.f66371j.m()));
            ((TTRoundRectImageView) this.n).setYRound(s.d(context, this.f66371j.m()));
        } else {
            this.n = new ImageView(context);
        }
        this.n.setTag(Integer.valueOf(getClickArea()));
        addView(this.n, new FrameLayout.LayoutParams(this.f66366e, this.f66367f));
    }

    private boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? !TextUtils.isEmpty(this.f66371j.k()) : invokeV.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicBaseWidget
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            super.b();
            ((ImageView) this.n).setBackgroundColor(this.f66371j.r());
            ImageLoaderWrapper.from(this.f66371j.j()).to((ImageView) this.n);
            if (f() && Build.VERSION.SDK_INT >= 17) {
                ((ImageView) this.n).setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageLoaderWrapper.from(this.f66371j.j()).type(ResultType.BITMAP).to(new ILoaderListener<Bitmap>(this) { // from class: com.bytedance.sdk.openadsdk.core.dynamic.dynamicview.DynamicImageView.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ DynamicImageView f66372a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f66372a = this;
                    }

                    @Override // com.bytedance.sdk.component.image.ILoaderListener
                    public void onFailed(int i2, String str, @Nullable Throwable th) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, th) == null) {
                        }
                    }

                    @Override // com.bytedance.sdk.component.image.ILoaderListener
                    public void onSuccess(ImageResponse<Bitmap> imageResponse) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse) == null) {
                            Bitmap a2 = b.a(this.f66372a.f66370i, imageResponse.getResult(), 25);
                            if (a2 == null) {
                                return;
                            }
                            this.f66372a.n.setBackground(new BitmapDrawable(this.f66372a.getResources(), a2));
                        }
                    }
                });
                return true;
            }
            ((ImageView) this.n).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        return invokeV.booleanValue;
    }
}

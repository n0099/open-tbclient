package com.baidu.tieba.view.progressball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.image.TbImage;
import com.baidu.tieba.R;
import com.baidu.tieba.gea;
import com.baidu.tieba.ova;
import com.baidu.tieba.pz5;
import com.baidu.tieba.tbadkcore.databinding.ProgressBallBinding;
import com.baidu.tieba.view.progressball.ProgressBall;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.drawable.ScalingUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J0\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0014J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/tieba/view/progressball/ProgressBall;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DRAWABLE_URI_PREFIX", "", "binding", "Lcom/baidu/tieba/tbadkcore/databinding/ProgressBallBinding;", "circlePath", "Landroid/graphics/Path;", "data", "Lcom/baidu/tieba/view/progressball/ProgressBallData;", "h", "progress", "w", "draw", "", "canvas", "Landroid/graphics/Canvas;", "init", "onLayout", "changed", "", "l", "t", "r", "b", "updateData", "updateProgress", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ProgressBall extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public int b;
    public int c;
    public final Path d;
    public int e;
    public ova f;
    public ProgressBallBinding g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressBall(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProgressBall(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressBall(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = "res:///";
        this.d = new Path();
        this.f = new ova();
        a();
    }

    public static final void d(ProgressBall this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            float f = this$0.e / 100.0f;
            ProgressBallBinding progressBallBinding = this$0.g;
            ProgressBallBinding progressBallBinding2 = null;
            if (progressBallBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                progressBallBinding = null;
            }
            float f2 = 1 - f;
            progressBallBinding.c.setTranslationY(this$0.c * f2);
            ProgressBallBinding progressBallBinding3 = this$0.g;
            if (progressBallBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                progressBallBinding2 = progressBallBinding3;
            }
            progressBallBinding2.d.setTranslationY(this$0.c * f2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setWillNotDraw(false);
            ProgressBallBinding c = ProgressBallBinding.c(LayoutInflater.from(getContext()), this, true);
            Intrinsics.checkNotNullExpressionValue(c, "inflate(LayoutInflater.from(context), this, true)");
            this.g = c;
        }
    }

    public final void b(ova data) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            boolean z2 = true;
            if (data.a().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            ProgressBallBinding progressBallBinding = null;
            if (z && !Intrinsics.areEqual(data.a(), this.f.a())) {
                ProgressBallBinding progressBallBinding2 = this.g;
                if (progressBallBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding2 = null;
                }
                progressBallBinding2.b.setBorderWidth(0);
                ProgressBallBinding progressBallBinding3 = this.g;
                if (progressBallBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding3 = null;
                }
                progressBallBinding3.b.setForegroundColor(gea.a(SkinManager.getColor(R.color.CAM_X0611), 0.6f));
                ProgressBallBinding progressBallBinding4 = this.g;
                if (progressBallBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding4 = null;
                }
                progressBallBinding4.b.startLoad(data.a(), 10, false);
                ProgressBallBinding progressBallBinding5 = this.g;
                if (progressBallBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding5 = null;
                }
                progressBallBinding5.b.setVisibility(0);
            }
            if (data.c() > 0 && data.c() != this.f.c()) {
                ProgressBallBinding progressBallBinding6 = this.g;
                if (progressBallBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding6 = null;
                }
                progressBallBinding6.c.setPlaceHolderDrawable(pz5.a.a());
                ProgressBallBinding progressBallBinding7 = this.g;
                if (progressBallBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding7 = null;
                }
                TbImage tbImage = progressBallBinding7.c;
                ScalingUtils.ScaleType FIT_X = ScalingUtils.ScaleType.FIT_X;
                Intrinsics.checkNotNullExpressionValue(FIT_X, "FIT_X");
                tbImage.setScaleType(FIT_X);
                Uri parse = Uri.parse(this.a + data.c());
                ProgressBallBinding progressBallBinding8 = this.g;
                if (progressBallBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding8 = null;
                }
                progressBallBinding8.c.setImageURI(parse, (Object) null);
                ProgressBallBinding progressBallBinding9 = this.g;
                if (progressBallBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding9 = null;
                }
                progressBallBinding9.d.setVisibility(8);
                ProgressBallBinding progressBallBinding10 = this.g;
                if (progressBallBinding10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding10 = null;
                }
                progressBallBinding10.c.setVisibility(0);
            }
            if (data.b() > 0 && data.b() != this.f.b()) {
                ProgressBallBinding progressBallBinding11 = this.g;
                if (progressBallBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding11 = null;
                }
                EMManager.from(progressBallBinding11.d).setBackGroundColor(data.b());
                ProgressBallBinding progressBallBinding12 = this.g;
                if (progressBallBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding12 = null;
                }
                progressBallBinding12.c.setVisibility(8);
                ProgressBallBinding progressBallBinding13 = this.g;
                if (progressBallBinding13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding13 = null;
                }
                progressBallBinding13.d.setVisibility(0);
            }
            if (data.e() != this.f.e()) {
                c(data.e());
            }
            if (data.f().length() <= 0) {
                z2 = false;
            }
            if (z2 && !Intrinsics.areEqual(data.f(), this.f.f())) {
                ProgressBallBinding progressBallBinding14 = this.g;
                if (progressBallBinding14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding14 = null;
                }
                progressBallBinding14.e.setText(data.f());
                ProgressBallBinding progressBallBinding15 = this.g;
                if (progressBallBinding15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding15 = null;
                }
                EMManager.from(progressBallBinding15.e).setTextStyle(R.string.F_X02).setTextColor(R.color.CAM_X0101);
            }
            if (data.g() > 0 && data.g() != this.f.g()) {
                ProgressBallBinding progressBallBinding16 = this.g;
                if (progressBallBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    progressBallBinding16 = null;
                }
                progressBallBinding16.e.setMaxLines(data.g());
            }
            if (data.d() > 0 && data.d() != this.f.d()) {
                ProgressBallBinding progressBallBinding17 = this.g;
                if (progressBallBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    progressBallBinding = progressBallBinding17;
                }
                progressBallBinding.e.setMaxEms(data.d());
            }
            this.f = data;
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (i < 0) {
                this.e = 0;
            } else if (i > 100) {
                this.e = 100;
            } else {
                this.e = i;
            }
            post(new Runnable() { // from class: com.baidu.tieba.nva
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        ProgressBall.d(ProgressBall.this);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (canvas != null) {
                canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            }
            if (canvas != null) {
                canvas.clipPath(this.d);
            }
            super.draw(canvas);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            int i5 = i3 - i;
            this.b = i5;
            this.c = i4 - i2;
            float f = i5 / 2.0f;
            this.d.reset();
            this.d.addCircle(f, f, f, Path.Direction.CW);
        }
    }
}

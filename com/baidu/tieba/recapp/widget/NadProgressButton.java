package com.baidu.tieba.recapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.kz5;
import com.baidu.tieba.xj0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\u0012\u0010=\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0002J\b\u0010>\u001a\u00020\u0001H\u0016J \u0010?\u001a\u0002042\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0001H\u0016J\b\u0010E\u001a\u000207H\u0002J\u0010\u0010F\u001a\u0002072\u0006\u0010G\u001a\u00020\bH\u0016J\u0012\u0010H\u001a\u00020C2\b\u0010I\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010J\u001a\u0002072\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\u0018\u0010K\u001a\u0002072\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0014J\u0012\u0010N\u001a\u0002072\b\u0010O\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010P\u001a\u0002072\b\u0010Q\u001a\u0004\u0018\u00010\u000b2\u0006\u0010R\u001a\u00020SH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b#\u0010\u0012R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b/\u00100R\u0010\u00102\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/baidu/tieba/recapp/widget/NadProgressButton;", "Landroid/view/View;", "Lcom/baidu/tieba/ad/download/mvp/IDownloadView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonText", "", "clickInterceptListener", "Lcom/baidu/tieba/ad/download/mvp/IDownloadView$OnClickInterceptListener;", "horizontalDistance", "measurePaint", "Landroid/graphics/Paint;", "getMeasurePaint", "()Landroid/graphics/Paint;", "measurePaint$delegate", "Lkotlin/Lazy;", "measureRec", "Landroid/graphics/Rect;", "getMeasureRec", "()Landroid/graphics/Rect;", "measureRec$delegate", "progress", "progressBgColor", "progressBgColorRes", "progressOval", "Landroid/graphics/RectF;", "getProgressOval", "()Landroid/graphics/RectF;", "progressOval$delegate", "progressPaint", "getProgressPaint", "progressPaint$delegate", "progressShader", "Landroid/graphics/Shader;", "radius", "status", "Lcom/baidu/nadcore/download/consts/AdDownloadStatus;", "strokeWidth", "textColorInProgress", "textColorInProgressRes", "textPaint", "Landroid/text/TextPaint;", "getTextPaint", "()Landroid/text/TextPaint;", "textPaint$delegate", "textShader", "textSize", "", "verticalDistance", "bind", "", "p0", "Landroid/view/ViewGroup;", "drawProgress", "canvas", "Landroid/graphics/Canvas;", "drawText", "getActionBar", "getMeasuredSizeBySpec", "measureSpec", "originSize", "isWidth", "", "getRealView", "initPaint", "onChangeSkinType", "type", "onClickIntercept", NativeConstants.TYPE_VIEW, "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setOnClickInterceptListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, StickerDataChangeType.UPDATE, "text", "adDownloadBean", "Lcom/baidu/nadcore/download/model/AdDownloadBean;", "recApp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NadProgressButton extends View implements kz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public int c;
    public int d;
    public int e;
    public AdDownloadStatus f;
    public String g;
    public float h;
    public kz5.a i;
    public int j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public Shader n;
    public Shader o;
    public int p;
    public int q;
    public final int r;
    public final Lazy s;
    public final Lazy t;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1412596279, "Lcom/baidu/tieba/recapp/widget/NadProgressButton$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1412596279, "Lcom/baidu/tieba/recapp/widget/NadProgressButton$a;");
                    return;
                }
            }
            int[] iArr = new int[AdDownloadStatus.values().length];
            iArr[AdDownloadStatus.NONE.ordinal()] = 1;
            iArr[AdDownloadStatus.FAILED.ordinal()] = 2;
            iArr[AdDownloadStatus.INSTALLED.ordinal()] = 3;
            iArr[AdDownloadStatus.COMPLETED.ordinal()] = 4;
            iArr[AdDownloadStatus.PAUSE.ordinal()] = 5;
            iArr[AdDownloadStatus.DOWNLOADING.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadProgressButton(Context context) {
        this(context, null, 0, 6, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.qk0
    public void b(ViewGroup p0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p0) == null) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }
    }

    public View getActionBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qk0
    public View getRealView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this : (View) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadProgressButton(Context context, AttributeSet attributeSet, int i) {
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
        new LinkedHashMap();
        this.a = R.color.CAM_X0101;
        this.b = R.color.CAM_X0302;
        this.c = SkinManager.getColor(R.color.CAM_X0101);
        this.d = SkinManager.getColor(this.b);
        this.f = AdDownloadStatus.NONE;
        this.g = "";
        this.h = getResources().getDimensionPixelSize(R.dimen.T_X08);
        this.j = getResources().getDimensionPixelSize(R.dimen.tbds42);
        this.k = LazyKt__LazyJVMKt.lazy(NadProgressButton$progressOval$2.INSTANCE);
        this.l = LazyKt__LazyJVMKt.lazy(NadProgressButton$progressPaint$2.INSTANCE);
        this.m = LazyKt__LazyJVMKt.lazy(NadProgressButton$textPaint$2.INSTANCE);
        this.p = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
        this.q = getResources().getDimensionPixelSize(R.dimen.M_H_X003);
        this.r = getResources().getDimensionPixelSize(R.dimen.L_X01);
        this.s = LazyKt__LazyJVMKt.lazy(NadProgressButton$measureRec$2.INSTANCE);
        this.t = LazyKt__LazyJVMKt.lazy(NadProgressButton$measurePaint$2.INSTANCE);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        f();
    }

    public /* synthetic */ NadProgressButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final RectF getProgressOval() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return (RectF) this.k.getValue();
        }
        return (RectF) invokeV.objValue;
    }

    private final Paint getProgressPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            return (Paint) this.l.getValue();
        }
        return (Paint) invokeV.objValue;
    }

    private final TextPaint getTextPaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            return (TextPaint) this.m.getValue();
        }
        return (TextPaint) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            getProgressPaint().setAntiAlias(true);
            getProgressPaint().setStyle(Paint.Style.FILL);
            getProgressPaint().setColor(this.d);
        }
    }

    public final Paint getMeasurePaint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (Paint) this.t.getValue();
        }
        return (Paint) invokeV.objValue;
    }

    public final Rect getMeasureRec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (Rect) this.s.getValue();
        }
        return (Rect) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz5
    public boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            kz5.a aVar = this.i;
            if (aVar != null) {
                return aVar.a(view2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kz5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            SkinManager.setBackgroundResource(this, R.drawable.obfuscated_res_0x7f0800c1);
            this.c = SkinManager.getColor(this.a);
            this.d = SkinManager.getColor(this.b);
            postInvalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.onDraw(canvas);
            c(canvas);
            d(canvas);
        }
    }

    @Override // com.baidu.tieba.kz5
    public void setOnClickInterceptListener(kz5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.i = aVar;
        }
    }

    public final void c(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            getProgressOval().left = this.r;
            getProgressOval().top = this.r;
            getProgressOval().right = getMeasuredWidth() - this.r;
            getProgressOval().bottom = getMeasuredHeight() - this.r;
            float f = this.e / 100.0f;
            switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    getProgressPaint().setShader(null);
                    getProgressPaint().setColor(this.d);
                    break;
                case 5:
                case 6:
                    this.n = new LinearGradient(0.0f, 0.0f, getMeasuredWidth(), 0.0f, new int[]{this.d, 0}, new float[]{f, f + 0.001f}, Shader.TileMode.CLAMP);
                    getProgressPaint().setShader(this.n);
                    break;
            }
            if (canvas != null) {
                RectF progressOval = getProgressOval();
                int i = this.j;
                canvas.drawRoundRect(progressOval, i, i, getProgressPaint());
            }
        }
    }

    public final void d(Canvas canvas) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            getTextPaint().setAntiAlias(true);
            getTextPaint().setTextSize(this.h);
            float measureText = getTextPaint().measureText(this.g);
            float f = 2;
            float f2 = measureText / f;
            float measuredWidth = (getMeasuredWidth() / 2) - f2;
            float measuredWidth2 = (getMeasuredWidth() / 2) + f2;
            float measuredWidth3 = getMeasuredWidth() * (this.e / 100.0f);
            float f3 = (measuredWidth3 - measuredWidth) / measureText;
            switch (a.$EnumSwitchMapping$0[this.f.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    getTextPaint().setShader(null);
                    getTextPaint().setColor(this.c);
                    break;
                case 5:
                case 6:
                    if (measuredWidth3 <= measuredWidth) {
                        getTextPaint().setShader(null);
                        getTextPaint().setColor(this.d);
                        break;
                    } else {
                        if (measuredWidth <= measuredWidth3 && measuredWidth3 <= measuredWidth2) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            this.o = new LinearGradient(measuredWidth, 0.0f, measuredWidth2, 0.0f, new int[]{this.c, this.d}, new float[]{f3, f3 + 0.001f}, Shader.TileMode.CLAMP);
                            getTextPaint().setShader(this.o);
                            getTextPaint().setColor(this.d);
                            break;
                        } else {
                            getTextPaint().setShader(null);
                            getTextPaint().setColor(this.c);
                            break;
                        }
                    }
                    break;
            }
            Paint.FontMetrics fontMetrics = getTextPaint().getFontMetrics();
            Intrinsics.checkNotNullExpressionValue(fontMetrics, "textPaint.fontMetrics");
            float f4 = fontMetrics.descent;
            float height = ((getHeight() / 2) - f4) + ((f4 - fontMetrics.ascent) / f);
            if (canvas != null) {
                canvas.drawText(this.g, measuredWidth, height, getTextPaint());
            }
        }
    }

    public final float e(int i, float f, boolean z) {
        InterceptResult invokeCommon;
        int suggestedMinimumHeight;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z)})) == null) {
            if (View.MeasureSpec.getMode(i) != Integer.MIN_VALUE && i != 0) {
                if (z) {
                    suggestedMinimumHeight = getSuggestedMinimumWidth();
                } else {
                    suggestedMinimumHeight = getSuggestedMinimumHeight();
                }
                return View.getDefaultSize(suggestedMinimumHeight, i);
            }
            return f;
        }
        return invokeCommon.floatValue;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            getMeasurePaint().setAntiAlias(true);
            getMeasurePaint().setStyle(Paint.Style.FILL);
            getMeasurePaint().setTextSize(this.h);
            getMeasurePaint().setTextAlign(Paint.Align.CENTER);
            String string = getResources().getString(R.string.install_app);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.install_app)");
            getMeasurePaint().getTextBounds(string, 0, string.length(), getMeasureRec());
            float height = (this.q * 2) + getMeasureRec().height();
            setMeasuredDimension((int) e(i, (this.p * 2) + getMeasureRec().width(), true), (int) e(i2, height, false));
        }
    }

    @Override // com.baidu.tieba.qk0
    public void update(String str, xj0 adDownloadBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, adDownloadBean) == null) {
            Intrinsics.checkNotNullParameter(adDownloadBean, "adDownloadBean");
            AdDownloadStatus adDownloadStatus = adDownloadBean.c;
            Intrinsics.checkNotNullExpressionValue(adDownloadStatus, "adDownloadBean.status");
            this.f = adDownloadStatus;
            if (str == null) {
                str = getResources().getString(R.string.install_app);
                Intrinsics.checkNotNullExpressionValue(str, "resources.getString(R.string.install_app)");
            }
            this.g = str;
            float f = 100;
            this.e = (int) RangesKt___RangesKt.coerceAtLeast(adDownloadBean.i * f, adDownloadBean.j * f);
            postInvalidate();
        }
    }
}

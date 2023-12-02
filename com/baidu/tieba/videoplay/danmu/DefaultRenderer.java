package com.baidu.tieba.videoplay.danmu;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.math.MathUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.au6;
import com.baidu.tieba.es6;
import com.baidu.tieba.eu6;
import com.baidu.tieba.fs6;
import com.baidu.tieba.mu6;
import com.baidu.tieba.yr6;
import com.baidu.tieba.z07;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "()V", "SELF_SEND_LEFT_PADDING", "", "SELF_SEND_TOP_PADDING", "borderPaint", "Landroid/graphics/Paint;", "strokePaint", "Landroid/text/TextPaint;", "textPaint", "draw", "", "item", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "canvas", "Landroid/graphics/Canvas;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "makeLayout", "Landroid/text/StaticLayout;", "charSequence", "", "width", "measure", "Lcom/baidu/tieba/danmu/utils/Size;", "updatePaint", "Companion", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DefaultRenderer implements au6 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static final Map<Float, Float> g;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public final int b;
    public final TextPaint c;
    public final TextPaint d;
    public final Paint e;

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final float b(Paint paint) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, paint)) == null) {
                float textSize = paint.getTextSize();
                Float f = (Float) DefaultRenderer.g.get(Float.valueOf(textSize));
                if (f != null) {
                    return f.floatValue();
                }
                Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                float f2 = fontMetrics.leading + (fontMetrics.descent - fontMetrics.ascent);
                DefaultRenderer.g.put(Float.valueOf(textSize), Float.valueOf(f2));
                return f2;
            }
            return invokeL.floatValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(264785595, "Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(264785595, "Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;");
                return;
            }
        }
        f = new a(null);
        Color.argb(255, 34, 34, 34);
        g = new HashMap();
    }

    public DefaultRenderer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.M_H_X001);
        this.b = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        this.c = textPaint;
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(this.c.getTextSize());
        textPaint2.setColor(-16777216);
        textPaint2.setStrokeWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X03));
        textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint2.setAntiAlias(true);
        this.d = textPaint2;
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X02));
        this.e = paint;
    }

    @Override // com.baidu.tieba.au6
    public mu6 a(es6 item, eu6 displayer, yr6 config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i(item, displayer, config);
            fs6 e = item.e();
            int b = z07.b(e.c());
            float textSize = b * (this.c.getTextSize() + UtilHelper.getDimenPixelSize(R.dimen.tbds6));
            String replace = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").replace(e.c(), "");
            if (TextUtils.isEmpty(replace)) {
                item.e().r(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            } else if (b > 0) {
                item.e().r(-UtilHelper.getDimenPixelSize(R.dimen.tbds6));
            }
            float measureText = this.c.measureText(replace, 0, replace.length()) + textSize + e.h();
            if (e.g() == 8) {
                measureText += this.b * 2;
            }
            return new mu6(MathKt__MathJVMKt.roundToInt(measureText) + 6, MathKt__MathJVMKt.roundToInt(f.b(this.c)) + MathKt__MathJVMKt.roundToInt(34.86f));
        }
        return (mu6) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.au6
    public void b(es6 item, Canvas canvas, eu6 displayer, yr6 config) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i(item, displayer, config);
            fs6 e = item.e();
            if (e.d().length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DefaultRenderer$draw$1(e, canvas, this, null), 3, null);
            }
        }
    }

    public final StaticLayout h(CharSequence charSequence, TextPaint textPaint, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, charSequence, textPaint, i)) == null) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            Intrinsics.checkNotNullParameter(textPaint, "textPaint");
            if (Build.VERSION.SDK_INT >= 23) {
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i);
                Intrinsics.checkNotNullExpressionValue(obtain, "obtain(charSequence, 0, …        textPaint, width)");
                obtain.setAlignment(Layout.Alignment.ALIGN_CENTER);
                obtain.setIncludePad(true);
                obtain.setLineSpacing(0.0f, 1.0f);
                obtain.setMaxLines(1);
                obtain.setEllipsize(TextUtils.TruncateAt.END);
                StaticLayout build = obtain.build();
                Intrinsics.checkNotNullExpressionValue(build, "{\n            val builde…builder.build()\n        }");
                return build;
            }
            return new StaticLayout(charSequence, textPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        }
        return (StaticLayout) invokeLLI.objValue;
    }

    public void i(es6 item, eu6 displayer, yr6 config) {
        Typeface typeface;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            fs6 e = item.e();
            float clamp = MathUtils.clamp(e.o(), 12.0f, 25.0f) * (displayer.b() - 0.6f);
            this.c.setColor(e.n() | Color.argb(255, 0, 0, 0));
            this.c.setTextSize(clamp * config.v());
            TextPaint textPaint = this.c;
            if (config.g()) {
                typeface = Typeface.DEFAULT_BOLD;
            } else {
                typeface = Typeface.DEFAULT;
            }
            textPaint.setTypeface(typeface);
            this.d.setTextSize(this.c.getTextSize());
            this.d.setTypeface(this.c.getTypeface());
            this.d.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0608));
        }
    }
}

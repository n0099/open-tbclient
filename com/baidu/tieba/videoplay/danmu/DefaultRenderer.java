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
import c.a.p0.n0.j.b;
import c.a.p0.n0.k.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
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
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/tieba/videoplay/danmu/DefaultRenderer;", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "()V", "SELF_SEND_LEFT_PADDING", "", "SELF_SEND_TOP_PADDING", "borderPaint", "Landroid/graphics/Paint;", "strokePaint", "Landroid/text/TextPaint;", "textPaint", "draw", "", "item", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "canvas", "Landroid/graphics/Canvas;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "makeLayout", "Landroid/text/StaticLayout;", "charSequence", "", "width", "measure", "Lcom/baidu/tieba/danmu/utils/Size;", "updatePaint", "Companion", "VideoPlay_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class DefaultRenderer implements c.a.p0.n0.i.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final a f36663f;

    /* renamed from: g  reason: collision with root package name */
    public static final Map<Float, Float> f36664g;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36665b;

    /* renamed from: c  reason: collision with root package name */
    public final TextPaint f36666c;

    /* renamed from: d  reason: collision with root package name */
    public final TextPaint f36667d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f36668e;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float b(Paint paint) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, paint)) == null) {
                float textSize = paint.getTextSize();
                Float f2 = (Float) DefaultRenderer.f36664g.get(Float.valueOf(textSize));
                if (f2 == null) {
                    Paint.FontMetrics fontMetrics = paint.getFontMetrics();
                    float f3 = (fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading;
                    DefaultRenderer.f36664g.put(Float.valueOf(textSize), Float.valueOf(f3));
                    return f3;
                }
                return f2.floatValue();
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
        f36663f = new a(null);
        Color.argb(255, 34, 34, 34);
        f36664g = new HashMap();
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
        this.f36665b = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.f36666c = textPaint;
        TextPaint textPaint2 = new TextPaint();
        textPaint2.setTextSize(this.f36666c.getTextSize());
        textPaint2.setColor(-16777216);
        textPaint2.setStrokeWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X03));
        textPaint2.setStyle(Paint.Style.FILL_AND_STROKE);
        textPaint2.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        this.f36667d = textPaint2;
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(UtilHelper.getDimenPixelSize(R.dimen.L_X02));
        Unit unit3 = Unit.INSTANCE;
        this.f36668e = paint;
    }

    @Override // c.a.p0.n0.i.a
    public g a(c.a.p0.n0.e.a item, b displayer, c.a.p0.n0.a config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i(item, displayer, config);
            c.a.p0.n0.e.b e2 = item.e();
            int b2 = c.a.p0.z0.a.b(e2.c());
            float textSize = b2 * (this.f36666c.getTextSize() + UtilHelper.getDimenPixelSize(R.dimen.tbds6));
            String replace = new Regex("#\\([a-zA-Z0-9_~！\\-\\u4E00-\\u9FA5]+\\)").replace(e2.c(), "");
            if (TextUtils.isEmpty(replace)) {
                item.e().q(UtilHelper.getDimenPixelSize(R.dimen.tbds4));
            } else if (b2 > 0) {
                item.e().q(-UtilHelper.getDimenPixelSize(R.dimen.tbds6));
            }
            float measureText = this.f36666c.measureText(replace, 0, replace.length()) + textSize + e2.h();
            if (e2.g() == 8) {
                measureText += this.f36665b * 2;
            }
            return new g(MathKt__MathJVMKt.roundToInt(measureText) + 6, MathKt__MathJVMKt.roundToInt(f36663f.b(this.f36666c)) + MathKt__MathJVMKt.roundToInt(34.86f));
        }
        return (g) invokeLLL.objValue;
    }

    @Override // c.a.p0.n0.i.a
    public void b(c.a.p0.n0.e.a item, Canvas canvas, b displayer, c.a.p0.n0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i(item, displayer, config);
            c.a.p0.n0.e.b e2 = item.e();
            if (e2.d().length() > 0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new DefaultRenderer$draw$1(e2, canvas, this, null), 3, null);
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

    public void i(c.a.p0.n0.e.a item, b displayer, c.a.p0.n0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            c.a.p0.n0.e.b e2 = item.e();
            float clamp = MathUtils.clamp(e2.n(), 12.0f, 25.0f) * (displayer.b() - 0.6f);
            this.f36666c.setColor(e2.m() | Color.argb(255, 0, 0, 0));
            this.f36666c.setTextSize(clamp * config.v());
            this.f36666c.setTypeface(config.g() ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
            this.f36667d.setTextSize(this.f36666c.getTextSize());
            this.f36667d.setTypeface(this.f36666c.getTypeface());
            this.f36667d.setColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0608));
        }
    }
}

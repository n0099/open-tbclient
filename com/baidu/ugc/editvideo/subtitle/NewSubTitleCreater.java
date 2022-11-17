package com.baidu.ugc.editvideo.subtitle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gj9;
import com.baidu.tieba.wj9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import com.baidu.ugc.editvideo.subtitle.ninepatchchunk.NinePatchChunk;
import com.baidu.ugc.utils.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class NewSubTitleCreater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mEmptyBitMap;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mIsSync;
    public int mLineCount;
    public Bitmap mNineBitmap;
    public NinePatchChunk mNinePatchChunk;
    public SubTitleConfig mSubTitleConfig;
    public List<SubTitleUnit> mSubTitleUnits;
    public volatile HashMap<String, Bitmap> mSubtitleCache;
    public SubtitleCreaterCallBack mSubtitleCreaterCallBack;
    public List<String> mTextContents;
    public boolean saveBitmap;
    public String savePath;

    /* renamed from: com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater$2  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Paint$Align;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2008998110, "Lcom/baidu/ugc/editvideo/subtitle/NewSubTitleCreater$2;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2008998110, "Lcom/baidu/ugc/editvideo/subtitle/NewSubTitleCreater$2;");
                    return;
                }
            }
            int[] iArr = new int[Paint.Align.values().length];
            $SwitchMap$android$graphics$Paint$Align = iArr;
            try {
                iArr[Paint.Align.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Paint$Align[Paint.Align.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$graphics$Paint$Align[Paint.Align.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface SubtitleCreaterCallBack {
        void onSubtitleBitmapCreated();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewSubTitleCreater(List<SubTitleUnit> list) {
        this(list, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public NewSubTitleCreater(List<SubTitleUnit> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.saveBitmap = false;
        this.savePath = "/sdcard/avdata/temp/";
        this.mTextContents = new ArrayList();
        this.mIsSync = z;
        this.mSubTitleUnits = list;
        this.mSubtitleCache = new LinkedHashMap();
        startHandleThreadIfNeed(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createSubtitleBitmap(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, subTitleUnit)) == null) {
            SubTitleConfig subTitleConfig = this.mSubTitleConfig;
            if (subTitleConfig != null && subTitleConfig.mVideoWidth > 0 && subTitleConfig.mVideoHeight > 0 && !TextUtils.isEmpty(subTitleUnit.line)) {
                initConfig(subTitleUnit);
                initXY(subTitleUnit);
                int i2 = subTitleUnit.width;
                if (i2 > 0 && (i = subTitleUnit.height) > 0) {
                    Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    gj9.b(this.mNineBitmap, this.mNinePatchChunk, canvas, subTitleUnit.padding);
                    int i3 = 0;
                    if (!TextUtils.isEmpty(subTitleUnit.line)) {
                        SubTitleConfig.StrokeConfig strokeConfig = subTitleUnit.chineseStrokeConfig;
                        if (strokeConfig != null && strokeConfig.strokeWidth > 0.0f) {
                            i3 = drawChineseText(subTitleUnit, canvas, Paint.Style.STROKE);
                        }
                        if (subTitleUnit.isChineseCenterBlank != 1) {
                            i3 = drawChineseText(subTitleUnit, canvas, Paint.Style.FILL);
                        }
                    }
                    if (this.mSubTitleConfig.mIsNeedEng && !TextUtils.isEmpty(subTitleUnit.engLine)) {
                        SubTitleConfig.StrokeConfig strokeConfig2 = subTitleUnit.engStrokeConfig;
                        if (strokeConfig2 != null && strokeConfig2.strokeWidth > 0.0f) {
                            drawEngText(subTitleUnit, canvas, i3, Paint.Style.STROKE);
                        }
                        if (subTitleUnit.isEngCenterBlank != 1) {
                            drawEngText(subTitleUnit, canvas, i3, Paint.Style.FILL);
                        }
                    }
                    return createBitmap;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0141 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int drawChineseText(SubTitleUnit subTitleUnit, Canvas canvas, Paint.Style style) {
        InterceptResult invokeLLL;
        float measureText;
        int i;
        int[] d;
        int i2;
        int i3;
        SubTitleConfig.StrokeConfig strokeConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65545, this, subTitleUnit, canvas, style)) == null) {
            int i4 = 1;
            TextPaint textPaint = new TextPaint(1);
            TextPaint textPaint2 = new TextPaint();
            TextPaint textPaint3 = new TextPaint();
            textPaint.setStyle(style);
            SubTitleConfig.ShadowConfig shadowConfig = subTitleUnit.chineseShadowConfig;
            if (shadowConfig != null) {
                textPaint.setShadowLayer(shadowConfig.shadowRadius, shadowConfig.shadowDx, shadowConfig.shadowDy, subTitleUnit.chineseShadowColor);
            }
            gj9.c(textPaint, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
            textPaint.setFakeBoldText(subTitleUnit.isChineseBold == 1);
            textPaint.setTextSkewX(subTitleUnit.isChineseItalic == 1 ? -0.5f : 0.0f);
            Typeface typeface = subTitleUnit.chineseTypeface;
            if (typeface != null) {
                textPaint.setTypeface(typeface);
                textPaint2.setTypeface(subTitleUnit.chineseTypeface);
                textPaint3.setTypeface(subTitleUnit.chineseTypeface);
            }
            textPaint.setColor(subTitleUnit.textColor);
            textPaint.setTextSize(subTitleUnit.textSize);
            if (style == Paint.Style.STROKE && (strokeConfig = subTitleUnit.chineseStrokeConfig) != null) {
                float f = strokeConfig.strokeWidth;
                if (f > 0.0f) {
                    textPaint.setStrokeWidth(f);
                    textPaint.setColor(subTitleUnit.chineseStrokeConfig.strokeColor);
                }
            }
            int g = gj9.g(textPaint);
            int i5 = subTitleUnit.padding;
            int i6 = subTitleUnit.backgroudPaddingLeft;
            int abs = (g / 2) + ((int) (Math.abs(textPaint.ascent() + textPaint.descent()) / 2.0f)) + subTitleUnit.padding + subTitleUnit.backgroudPaddingTop;
            int i7 = 0;
            while (i7 < this.mLineCount) {
                int i8 = subTitleUnit.padding;
                int i9 = subTitleUnit.backgroudPaddingTop;
                int i10 = (g * i7) + i8 + i9;
                int i11 = i7 + 1;
                int i12 = i8 + (g * i11) + i9;
                int i13 = AnonymousClass2.$SwitchMap$android$graphics$Paint$Align[subTitleUnit.textGravity.ordinal()];
                if (i13 == i4) {
                    measureText = (subTitleUnit.width - textPaint.measureText(this.mTextContents.get(i7))) - subTitleUnit.padding;
                } else if (i13 != 3) {
                    i = subTitleUnit.padding + subTitleUnit.backgroudPaddingLeft;
                    int i14 = i;
                    d = gj9.d(textPaint, textPaint2, textPaint3, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
                    int i15 = i7;
                    int i16 = abs;
                    gj9.e(canvas, textPaint, i14, i10, i12, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
                    if (d[0] == 0) {
                        i2 = i14;
                        i3 = i16;
                        canvas.drawText(this.mTextContents.get(i15), i2, i3, textPaint2);
                    } else {
                        i2 = i14;
                        i3 = i16;
                    }
                    if (d[1] == 0) {
                        canvas.drawText(this.mTextContents.get(i15), i2, i3, textPaint3);
                    }
                    canvas.drawText(this.mTextContents.get(i15), i2, i3, textPaint);
                    abs = i3 + g;
                    i7 = i11;
                    i4 = 1;
                } else {
                    measureText = (subTitleUnit.width - textPaint.measureText(this.mTextContents.get(i7))) / 2.0f;
                }
                i = (int) measureText;
                int i142 = i;
                d = gj9.d(textPaint, textPaint2, textPaint3, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
                int i152 = i7;
                int i162 = abs;
                gj9.e(canvas, textPaint, i142, i10, i12, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
                if (d[0] == 0) {
                }
                if (d[1] == 0) {
                }
                canvas.drawText(this.mTextContents.get(i152), i2, i3, textPaint);
                abs = i3 + g;
                i7 = i11;
                i4 = 1;
            }
            return abs - subTitleUnit.padding;
        }
        return invokeLLL.intValue;
    }

    private void drawEngText(SubTitleUnit subTitleUnit, Canvas canvas, int i, Paint.Style style) {
        SubTitleConfig.StrokeConfig strokeConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65546, this, subTitleUnit, canvas, i, style) == null) {
            canvas.save();
            SubTitleConfig subTitleConfig = this.mSubTitleConfig;
            canvas.translate(0.0f, i + (subTitleConfig.mLinePadding / subTitleConfig.mScale));
            TextPaint textPaint = new TextPaint(1);
            textPaint.setColor(subTitleUnit.engTextColor);
            textPaint.setStyle(style);
            textPaint.setTextSize(subTitleUnit.engTextSize);
            SubTitleConfig.ShadowConfig shadowConfig = subTitleUnit.engShadowConfig;
            if (shadowConfig != null) {
                textPaint.setShadowLayer(shadowConfig.shadowRadius, shadowConfig.shadowDx, shadowConfig.shadowDy, subTitleUnit.engShadowColor);
            }
            textPaint.setFakeBoldText(subTitleUnit.isEngBold == 1);
            textPaint.setTextSkewX(subTitleUnit.isEngItalic == 1 ? -0.5f : 0.0f);
            Typeface typeface = subTitleUnit.engTypeface;
            if (typeface != null) {
                textPaint.setTypeface(typeface);
            }
            if (style == Paint.Style.STROKE && (strokeConfig = subTitleUnit.engStrokeConfig) != null) {
                float f = strokeConfig.strokeWidth;
                if (f > 0.0f) {
                    textPaint.setStrokeWidth(f);
                    textPaint.setColor(subTitleUnit.engStrokeConfig.strokeColor);
                }
            }
            Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
            int i2 = AnonymousClass2.$SwitchMap$android$graphics$Paint$Align[subTitleUnit.textGravity.ordinal()];
            Layout.Alignment alignment2 = i2 != 1 ? i2 != 2 ? Layout.Alignment.ALIGN_CENTER : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
            String str = subTitleUnit.engLine;
            int width = canvas.getWidth();
            int i3 = subTitleUnit.padding;
            getMeasuredStaticLayout(str, textPaint, width + i3, this.mSubTitleConfig.maxEngLineNum, alignment2, i3).draw(canvas);
            canvas.restore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheKey(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, subTitleUnit)) == null) {
            if (subTitleUnit == null || this.mSubTitleConfig == null) {
                return "";
            }
            return subTitleUnit.line + this.mSubTitleConfig.mIsNeedEng + subTitleUnit.startTime + subTitleUnit.endTime;
        }
        return (String) invokeL.objValue;
    }

    private SubTitleUnit getEmptySubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            SubTitleUnit subTitleUnit = new SubTitleUnit();
            Bitmap bitmap = this.mEmptyBitMap;
            if (bitmap == null || bitmap.isRecycled()) {
                this.mEmptyBitMap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            subTitleUnit.line = "";
            subTitleUnit.textBitmap = this.mEmptyBitMap;
            return subTitleUnit;
        }
        return (SubTitleUnit) invokeV.objValue;
    }

    private int getMaxSubtitleWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            SubTitleConfig subTitleConfig = this.mSubTitleConfig;
            if (subTitleConfig != null) {
                float f = subTitleConfig.mScale;
                return (int) ((subTitleConfig.mVideoWidth - (subTitleConfig.mMinLeftPadding / f)) - (subTitleConfig.mMinRightPadding / f));
            }
            return (int) (wj9.e() * 0.8d);
        }
        return invokeV.intValue;
    }

    public static StaticLayout getMeasuredStaticLayout(String str, TextPaint textPaint, int i, int i2, Layout.Alignment alignment, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{str, textPaint, Integer.valueOf(i), Integer.valueOf(i2), alignment, Integer.valueOf(i3)})) == null) {
            StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), textPaint, i, alignment, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i);
            if (staticLayout.getLineCount() > i2) {
                String substring = str.substring(0, staticLayout.getLineEnd(i2 - 1));
                return new StaticLayout(substring, 0, substring.length(), textPaint, i, alignment, 1.0f, i3, false, TextUtils.TruncateAt.END, i);
            }
            return staticLayout;
        }
        return (StaticLayout) invokeCommon.objValue;
    }

    private int[] getSubtileDefaultCenterPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, this, new Object[]{subTitleUnit, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (i2 - (i4 / 2)) - i5} : (int[]) invokeCommon.objValue;
    }

    private int[] getSubtileDefaultPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, this, new Object[]{subTitleUnit, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f)})) == null) ? (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (int) ((i2 * f) - (i4 / 2))} : (int[]) invokeCommon.objValue;
    }

    private int[] getSubtileDefaultPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, this, new Object[]{subTitleUnit, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (i2 - i4) - i5} : (int[]) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] getSubtileWH(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        float abs;
        float abs2;
        float f;
        float f2;
        float f3;
        SubTitleConfig subTitleConfig;
        int i;
        float abs3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, this, subTitleUnit)) == null) {
            if (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            TextPaint textPaint = new TextPaint(1);
            textPaint.setStyle(Paint.Style.FILL);
            SubTitleConfig.ShadowConfig shadowConfig = subTitleUnit.chineseShadowConfig;
            float f4 = 2.0f;
            if (shadowConfig == null) {
                textPaint.setShadowLayer(2.0f, 0.0f, 2.0f, subTitleUnit.chineseShadowColor);
                abs = 2.0f;
                abs2 = 2.0f;
            } else {
                textPaint.setShadowLayer(shadowConfig.shadowRadius, shadowConfig.shadowDx, shadowConfig.shadowDy, subTitleUnit.chineseShadowColor);
                abs = Math.abs(subTitleUnit.chineseShadowConfig.shadowDx);
                abs2 = Math.abs(subTitleUnit.chineseShadowConfig.shadowDy);
            }
            textPaint.setFakeBoldText(subTitleUnit.isChineseBold == 1);
            textPaint.setTextSkewX(subTitleUnit.isChineseItalic == 1 ? -0.5f : 0.0f);
            Typeface typeface = subTitleUnit.chineseTypeface;
            if (typeface != null) {
                textPaint.setTypeface(typeface);
            }
            textPaint.setColor(subTitleUnit.textColor);
            textPaint.setTextSize(subTitleUnit.textSize);
            float measureText = textPaint.measureText(subTitleUnit.line) + abs + (subTitleUnit.padding * 2);
            if (measureText > getMaxSubtitleWidth()) {
                measureText = getMaxSubtitleWidth();
            }
            if (this.mSubTitleConfig.mIsNeedEng && !TextUtils.isEmpty(subTitleUnit.engLine)) {
                TextPaint textPaint2 = new TextPaint(1);
                textPaint2.setColor(subTitleUnit.engTextColor);
                textPaint2.setStyle(Paint.Style.FILL);
                textPaint2.setTextSize(subTitleUnit.engTextSize);
                SubTitleConfig.ShadowConfig shadowConfig2 = subTitleUnit.engShadowConfig;
                if (shadowConfig2 == null) {
                    textPaint2.setShadowLayer(2.0f, 0.0f, 2.0f, subTitleUnit.engShadowColor);
                    abs3 = 2.0f;
                } else {
                    textPaint2.setShadowLayer(shadowConfig2.shadowRadius, shadowConfig2.shadowDx, shadowConfig2.shadowDy, subTitleUnit.engShadowColor);
                    f4 = Math.abs(subTitleUnit.engShadowConfig.shadowDx);
                    abs3 = Math.abs(subTitleUnit.engShadowConfig.shadowDy);
                }
                textPaint2.setFakeBoldText(subTitleUnit.isEngBold == 1);
                textPaint2.setTextSkewX(subTitleUnit.isEngItalic == 1 ? -0.5f : 0.0f);
                Typeface typeface2 = subTitleUnit.engTypeface;
                if (typeface2 != null) {
                    textPaint2.setTypeface(typeface2);
                }
                float measureText2 = textPaint2.measureText(subTitleUnit.engLine) + f4 + (subTitleUnit.padding * 2);
                if (measureText2 > measureText) {
                    measureText = measureText2 > ((float) getMaxSubtitleWidth()) ? getMaxSubtitleWidth() : measureText2;
                }
                if (measureText > 0.0f) {
                    String str = subTitleUnit.engLine;
                    int i2 = subTitleUnit.padding;
                    f = measureText;
                    f2 = getMeasuredStaticLayout(str, textPaint2, (int) ((measureText - f4) - (i2 * 2)), this.mSubTitleConfig.maxEngLineNum, Layout.Alignment.ALIGN_CENTER, i2).getHeight() + abs3;
                    if (f <= 0.0f) {
                        StaticLayout measuredStaticLayout = getMeasuredStaticLayout(subTitleUnit.line, textPaint, (int) ((f - abs) - (i * 2)), this.mSubTitleConfig.maxChineseLineNum, Layout.Alignment.ALIGN_CENTER, subTitleUnit.padding);
                        f3 = measuredStaticLayout.getHeight() + abs2;
                        this.mLineCount = measuredStaticLayout.getLineCount();
                        int i3 = 0;
                        for (int i4 = 0; i4 < this.mLineCount; i4++) {
                            int lineEnd = measuredStaticLayout.getLineEnd(i4);
                            if (lineEnd != 0) {
                                this.mTextContents.add(subTitleUnit.line.substring(i3, lineEnd));
                                f = Math.max(f, textPaint.measureText(this.mTextContents.get(i4)) + abs + (subTitleUnit.padding * 2));
                                i3 = lineEnd;
                            }
                        }
                    } else {
                        f3 = 0.0f;
                    }
                    iArr[0] = (int) f;
                    float f5 = f3 + (subTitleUnit.padding * 2);
                    if (f2 != 0.0f) {
                        f5 += (subTitleConfig.mLinePadding / this.mSubTitleConfig.mScale) + f2;
                    }
                    iArr[1] = (int) f5;
                    return iArr;
                }
            }
            f = measureText;
            f2 = 0.0f;
            if (f <= 0.0f) {
            }
            iArr[0] = (int) f;
            float f52 = f3 + (subTitleUnit.padding * 2);
            if (f2 != 0.0f) {
            }
            iArr[1] = (int) f52;
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    private void initConfig(SubTitleUnit subTitleUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, subTitleUnit) == null) {
            this.mTextContents.clear();
            if (subTitleUnit.textColor == 0) {
                subTitleUnit.textColor = this.mSubTitleConfig.mDefaultChsTextColor;
            }
            if (subTitleUnit.textSize == 0.0f) {
                SubTitleConfig subTitleConfig = this.mSubTitleConfig;
                subTitleUnit.textSize = subTitleConfig.mDefaultChsTextSize / subTitleConfig.mScale;
            }
            if (subTitleUnit.engTextColor == 0) {
                subTitleUnit.engTextColor = this.mSubTitleConfig.mDefaultEngTextColor;
            }
            if (subTitleUnit.engTextSize == 0.0f) {
                SubTitleConfig subTitleConfig2 = this.mSubTitleConfig;
                subTitleUnit.engTextSize = subTitleConfig2.mDefaultEngTextSize / subTitleConfig2.mScale;
            }
            if (subTitleUnit.chineseShadowColor == 0) {
                subTitleUnit.chineseShadowColor = this.mSubTitleConfig.mShadowColor;
            }
            if (subTitleUnit.engShadowColor == 0) {
                subTitleUnit.engShadowColor = this.mSubTitleConfig.engShadowColor;
            }
            TextWordsEntity.TextColorEntity textColorEntity = this.mSubTitleConfig.mTextColorEntity;
            if (textColorEntity != null) {
                subTitleUnit.mTextColorEntity = textColorEntity;
            }
            SubTitleConfig subTitleConfig3 = this.mSubTitleConfig;
            subTitleUnit.chineseTypeface = subTitleConfig3.chineseTypeface;
            subTitleUnit.engTypeface = subTitleConfig3.engTypeface;
            subTitleUnit.mTextStyleEntity = subTitleConfig3.mTextStyleEntity;
            if (subTitleUnit.isChineseBold == -1) {
                subTitleUnit.isChineseBold = subTitleConfig3.isChineseBold;
            }
            if (subTitleUnit.isChineseItalic == -1) {
                subTitleUnit.isChineseItalic = this.mSubTitleConfig.isChineseItalic;
            }
            if (subTitleUnit.isEngBold == -1) {
                subTitleUnit.isEngBold = this.mSubTitleConfig.isEngBold;
            }
            if (subTitleUnit.isEngItalic == -1) {
                subTitleUnit.isEngItalic = this.mSubTitleConfig.isEngItalic;
            }
            if (subTitleUnit.chineseShadowConfig == null) {
                subTitleUnit.chineseShadowConfig = this.mSubTitleConfig.chineseShadowConfig;
            }
            if (subTitleUnit.engShadowConfig == null) {
                subTitleUnit.engShadowConfig = this.mSubTitleConfig.engShadowConfig;
            }
            if (subTitleUnit.chineseStrokeConfig == null) {
                subTitleUnit.chineseStrokeConfig = this.mSubTitleConfig.chineseStrokeConfig;
            }
            if (subTitleUnit.engStrokeConfig == null) {
                subTitleUnit.engStrokeConfig = this.mSubTitleConfig.engStrokeConfig;
            }
            if (subTitleUnit.isChineseCenterBlank == -1) {
                subTitleUnit.isChineseCenterBlank = this.mSubTitleConfig.isChineseCenterBlank;
            }
            if (subTitleUnit.isEngCenterBlank == -1) {
                subTitleUnit.isEngCenterBlank = this.mSubTitleConfig.isEngCenterBlank;
            }
            SubTitleConfig subTitleConfig4 = this.mSubTitleConfig;
            subTitleUnit.padding = subTitleConfig4.innerPadding;
            subTitleUnit.textGravity = subTitleConfig4.textGravity;
        }
    }

    private void initXY(SubTitleUnit subTitleUnit) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, subTitleUnit) == null) {
            int[] subtileWH = getSubtileWH(subTitleUnit);
            Bitmap a = gj9.a(subTitleUnit.mTextStyleEntity);
            this.mNineBitmap = a;
            NinePatchChunk f = gj9.f(a, subTitleUnit.mTextStyleEntity);
            this.mNinePatchChunk = f;
            int i = subtileWH[0];
            subTitleUnit.width = i;
            int i2 = subtileWH[1];
            subTitleUnit.height = i2;
            subTitleUnit.backgroudPaddingLeft = 0;
            subTitleUnit.backgroudPaddingTop = 0;
            if (f != null) {
                Rect rect = f.padding;
                int i3 = rect.left;
                subTitleUnit.backgroudPaddingLeft = i3;
                int i4 = rect.top;
                subTitleUnit.backgroudPaddingTop = i4;
                int i5 = i + i3;
                subTitleUnit.width = i5;
                int i6 = i2 + i4;
                subTitleUnit.height = i6;
                int i7 = i5 + rect.right;
                subTitleUnit.width = i7;
                subTitleUnit.height = i6 + rect.bottom;
                Bitmap bitmap = this.mNineBitmap;
                if (bitmap != null && i7 < bitmap.getWidth()) {
                    subTitleUnit.width = this.mNineBitmap.getWidth();
                }
            }
            if (subTitleUnit.leftPercent == -1.0f || subTitleUnit.topPercent == -1.0f) {
                SubTitleConfig subTitleConfig = this.mSubTitleConfig;
                int i8 = subTitleConfig.gravity;
                int[] subtileDefaultPosition = i8 == 1 ? getSubtileDefaultPosition(subTitleUnit, subTitleConfig.mVideoWidth, subTitleConfig.mVideoHeight, subTitleUnit.width, subTitleUnit.height, subTitleConfig.mBottomPadding) : i8 == 2 ? getSubtileDefaultCenterPosition(subTitleUnit, subTitleConfig.mVideoWidth, subTitleConfig.mVideoHeight, subTitleUnit.width, subTitleUnit.height, subTitleConfig.mBottomPadding) : getSubtileDefaultPosition(subTitleUnit, subTitleConfig.mVideoWidth, subTitleConfig.mVideoHeight, subTitleUnit.width, subTitleUnit.height, 0.5f);
                if (subTitleUnit.leftPercent == -1.0f || subTitleUnit.x == -1) {
                    subTitleUnit.x = subtileDefaultPosition[0];
                }
                if (subTitleUnit.topPercent == -1.0f || subTitleUnit.y == -1) {
                    subTitleUnit.y = subtileDefaultPosition[1];
                }
                SubTitleConfig subTitleConfig2 = this.mSubTitleConfig;
                PointF pointF = subTitleConfig2.mCenterPoint;
                if (pointF == null) {
                    subTitleConfig2.mCenterPoint = new PointF(subTitleUnit.x + (subTitleUnit.width / 2.0f), subTitleUnit.y + (subTitleUnit.height / 2.0f));
                    return;
                }
                subTitleUnit.x = (int) (pointF.x - (subTitleUnit.width / 2.0f));
                subTitleUnit.y = (int) (pointF.y - (subTitleUnit.height / 2.0f));
            }
        }
    }

    private void onGetSubtitleBitmap(SubTitleUnit subTitleUnit, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, this, subTitleUnit, z) == null) {
            if (!this.mIsSync) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    return;
                }
                handler.post(new Runnable(this, subTitleUnit, z) { // from class: com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ NewSubTitleCreater this$0;
                    public final /* synthetic */ boolean val$isCurrent;
                    public final /* synthetic */ SubTitleUnit val$subTitleUnit;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, subTitleUnit, Boolean.valueOf(z)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$subTitleUnit = subTitleUnit;
                        this.val$isCurrent = z;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            Bitmap createSubtitleBitmap = this.this$0.createSubtitleBitmap(this.val$subTitleUnit);
                            if (this.this$0.saveBitmap) {
                                String str = this.this$0.savePath;
                                FileUtils.saveBitmap2JPG(str, System.currentTimeMillis() + ".jpg", createSubtitleBitmap, 90);
                            }
                            if (createSubtitleBitmap == null || createSubtitleBitmap.isRecycled()) {
                                return;
                            }
                            synchronized (this.this$0.mSubtitleCache) {
                                this.val$subTitleUnit.textBitmap = createSubtitleBitmap;
                                if (this.val$isCurrent && this.this$0.mSubtitleCreaterCallBack != null) {
                                    this.this$0.mSubtitleCreaterCallBack.onSubtitleBitmapCreated();
                                }
                                this.this$0.mSubtitleCache.put(this.this$0.getCacheKey(this.val$subTitleUnit), createSubtitleBitmap);
                                this.val$subTitleUnit.mIsNeedCache = true;
                            }
                        }
                    }
                });
                return;
            }
            Bitmap createSubtitleBitmap = createSubtitleBitmap(subTitleUnit);
            if (createSubtitleBitmap != null && !createSubtitleBitmap.isRecycled()) {
                this.mSubtitleCache.put(getCacheKey(subTitleUnit), createSubtitleBitmap);
                subTitleUnit.mIsNeedCache = true;
            }
            subTitleUnit.textBitmap = createSubtitleBitmap;
        }
    }

    private void startHandleThreadIfNeed(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65558, this, z) == null) || z) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("createsubtitlebitmap");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public SubTitleUnit getSubTitle(long j, long j2) {
        InterceptResult invokeCommon;
        Bitmap value;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (this.mSubTitleUnits == null || this.mSubtitleCache == null) {
                return getEmptySubTitle();
            }
            synchronized (this.mSubtitleCache) {
                SubTitleUnit subTitleUnit = null;
                for (SubTitleUnit subTitleUnit2 : this.mSubTitleUnits) {
                    if (subTitleUnit2.startTime <= j2) {
                        if (subTitleUnit != null) {
                            if (this.mSubtitleCache.get(getCacheKey(subTitleUnit2)) == null) {
                                onGetSubtitleBitmap(subTitleUnit2, false);
                            }
                            if (this.mSubtitleCache.size() > 2) {
                                Iterator<Map.Entry<String, Bitmap>> it = this.mSubtitleCache.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry<String, Bitmap> next = it.next();
                                    if (!TextUtils.equals(next.getKey(), getCacheKey(subTitleUnit)) && !TextUtils.equals(next.getKey(), getCacheKey(subTitleUnit2)) && (value = next.getValue()) != null) {
                                        value.recycle();
                                        it.remove();
                                    }
                                }
                            }
                            return subTitleUnit;
                        } else if (j < subTitleUnit2.startTime || j > subTitleUnit2.endTime) {
                            String cacheKey = getCacheKey(subTitleUnit2);
                            Bitmap bitmap = this.mSubtitleCache.get(cacheKey);
                            if (bitmap != null) {
                                bitmap.recycle();
                                this.mSubtitleCache.remove(cacheKey);
                            }
                        } else {
                            Bitmap bitmap2 = subTitleUnit2.mIsNeedCache ? this.mSubtitleCache.get(getCacheKey(subTitleUnit2)) : null;
                            if (bitmap2 == null || bitmap2.isRecycled()) {
                                onGetSubtitleBitmap(subTitleUnit2, true);
                            } else {
                                if (subTitleUnit2.x == -1 && subTitleUnit2.y == -1) {
                                    initConfig(subTitleUnit2);
                                    initXY(subTitleUnit2);
                                }
                                subTitleUnit2.textBitmap = bitmap2;
                            }
                            subTitleUnit = subTitleUnit2;
                        }
                    }
                }
                return subTitleUnit != null ? subTitleUnit : getEmptySubTitle();
            }
        }
        return (SubTitleUnit) invokeCommon.objValue;
    }

    public SubTitleConfig getSubTitleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mSubTitleConfig : (SubTitleConfig) invokeV.objValue;
    }

    public SubTitleUnit getSubTitleSync(long j) {
        InterceptResult invokeJ;
        SubTitleUnit subTitleUnit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
            List<SubTitleUnit> list = this.mSubTitleUnits;
            if (list == null) {
                return getEmptySubTitle();
            }
            for (SubTitleUnit subTitleUnit2 : list) {
                if (j >= subTitleUnit2.startTime && j <= subTitleUnit2.endTime) {
                    Bitmap bitmap = this.mSubtitleCache.get(getCacheKey(subTitleUnit2));
                    if (bitmap == null || bitmap.isRecycled()) {
                        if (!this.mSubtitleCache.isEmpty()) {
                            ArrayList<String> arrayList = new ArrayList();
                            for (Map.Entry<String, Bitmap> entry : this.mSubtitleCache.entrySet()) {
                                entry.getValue().recycle();
                                arrayList.add(entry.getKey());
                            }
                            for (String str : arrayList) {
                                this.mSubtitleCache.remove(str);
                            }
                            arrayList.clear();
                        }
                        bitmap = createSubtitleBitmap(subTitleUnit2);
                        if (bitmap != null && !bitmap.isRecycled()) {
                            this.mSubtitleCache.put(getCacheKey(subTitleUnit2), bitmap);
                        }
                        subTitleUnit = new SubTitleUnit();
                    } else {
                        subTitleUnit = new SubTitleUnit();
                    }
                    subTitleUnit.line = subTitleUnit2.line;
                    subTitleUnit.textBitmap = bitmap;
                    return subTitleUnit;
                }
            }
            return getEmptySubTitle();
        }
        return (SubTitleUnit) invokeJ.objValue;
    }

    public List<SubTitleUnit> getSubTitleUnits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mSubTitleUnits : (List) invokeV.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            HandlerThread handlerThread = this.mHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            releaseBitmap();
            this.mSubtitleCache = null;
        }
    }

    public void releaseBitmap() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Bitmap bitmap = this.mEmptyBitMap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            if (this.mSubtitleCache != null) {
                for (Bitmap bitmap2 : this.mSubtitleCache.values()) {
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        bitmap2.recycle();
                    }
                }
                this.mSubtitleCache.clear();
            }
        }
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, subTitleConfig) == null) {
            this.mSubTitleConfig = subTitleConfig;
        }
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mSubTitleUnits = list;
        }
    }

    public void setSubtitleCreaterCallBack(SubtitleCreaterCallBack subtitleCreaterCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, subtitleCreaterCallBack) == null) {
            this.mSubtitleCreaterCallBack = subtitleCreaterCallBack;
        }
    }
}

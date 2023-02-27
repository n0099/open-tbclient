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
import com.baidu.tieba.g1a;
import com.baidu.tieba.w1a;
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
/* loaded from: classes7.dex */
public class NewSubTitleCreater {
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
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Paint$Align;

        static {
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

    /* loaded from: classes7.dex */
    public interface SubtitleCreaterCallBack {
        void onSubtitleBitmapCreated();
    }

    public NewSubTitleCreater(List<SubTitleUnit> list) {
        this(list, false);
    }

    public NewSubTitleCreater(List<SubTitleUnit> list, boolean z) {
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
        int i;
        SubTitleConfig subTitleConfig = this.mSubTitleConfig;
        if (subTitleConfig != null && subTitleConfig.mVideoWidth > 0 && subTitleConfig.mVideoHeight > 0 && !TextUtils.isEmpty(subTitleUnit.line)) {
            initConfig(subTitleUnit);
            initXY(subTitleUnit);
            int i2 = subTitleUnit.width;
            if (i2 > 0 && (i = subTitleUnit.height) > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                g1a.b(this.mNineBitmap, this.mNinePatchChunk, canvas, subTitleUnit.padding);
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int drawChineseText(SubTitleUnit subTitleUnit, Canvas canvas, Paint.Style style) {
        float measureText;
        int i;
        int[] d;
        int i2;
        int i3;
        SubTitleConfig.StrokeConfig strokeConfig;
        int i4 = 1;
        TextPaint textPaint = new TextPaint(1);
        TextPaint textPaint2 = new TextPaint();
        TextPaint textPaint3 = new TextPaint();
        textPaint.setStyle(style);
        SubTitleConfig.ShadowConfig shadowConfig = subTitleUnit.chineseShadowConfig;
        if (shadowConfig != null) {
            textPaint.setShadowLayer(shadowConfig.shadowRadius, shadowConfig.shadowDx, shadowConfig.shadowDy, subTitleUnit.chineseShadowColor);
        }
        g1a.c(textPaint, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
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
        int g = g1a.g(textPaint);
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
                d = g1a.d(textPaint, textPaint2, textPaint3, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
                int i15 = i7;
                int i16 = abs;
                g1a.e(canvas, textPaint, i14, i10, i12, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
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
            d = g1a.d(textPaint, textPaint2, textPaint3, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
            int i152 = i7;
            int i162 = abs;
            g1a.e(canvas, textPaint, i142, i10, i12, subTitleUnit.mTextStyleEntity, subTitleUnit.mTextColorEntity);
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

    private void drawEngText(SubTitleUnit subTitleUnit, Canvas canvas, int i, Paint.Style style) {
        SubTitleConfig.StrokeConfig strokeConfig;
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

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheKey(SubTitleUnit subTitleUnit) {
        if (subTitleUnit == null || this.mSubTitleConfig == null) {
            return "";
        }
        return subTitleUnit.line + this.mSubTitleConfig.mIsNeedEng + subTitleUnit.startTime + subTitleUnit.endTime;
    }

    private SubTitleUnit getEmptySubTitle() {
        SubTitleUnit subTitleUnit = new SubTitleUnit();
        Bitmap bitmap = this.mEmptyBitMap;
        if (bitmap == null || bitmap.isRecycled()) {
            this.mEmptyBitMap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        subTitleUnit.line = "";
        subTitleUnit.textBitmap = this.mEmptyBitMap;
        return subTitleUnit;
    }

    private int getMaxSubtitleWidth() {
        SubTitleConfig subTitleConfig = this.mSubTitleConfig;
        if (subTitleConfig != null) {
            float f = subTitleConfig.mScale;
            return (int) ((subTitleConfig.mVideoWidth - (subTitleConfig.mMinLeftPadding / f)) - (subTitleConfig.mMinRightPadding / f));
        }
        return (int) (w1a.e() * 0.8d);
    }

    public static StaticLayout getMeasuredStaticLayout(String str, TextPaint textPaint, int i, int i2, Layout.Alignment alignment, int i3) {
        StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), textPaint, i, alignment, 1.0f, 0.0f, false, TextUtils.TruncateAt.END, i);
        if (staticLayout.getLineCount() > i2) {
            String substring = str.substring(0, staticLayout.getLineEnd(i2 - 1));
            return new StaticLayout(substring, 0, substring.length(), textPaint, i, alignment, 1.0f, i3, false, TextUtils.TruncateAt.END, i);
        }
        return staticLayout;
    }

    private int[] getSubtileDefaultCenterPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, int i5) {
        return (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (i2 - (i4 / 2)) - i5};
    }

    private int[] getSubtileDefaultPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, float f) {
        return (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (int) ((i2 * f) - (i4 / 2))};
    }

    private int[] getSubtileDefaultPosition(SubTitleUnit subTitleUnit, int i, int i2, int i3, int i4, int i5) {
        return (subTitleUnit == null || TextUtils.isEmpty(subTitleUnit.line)) ? new int[]{0, 0} : new int[]{(i - i3) / 2, (i2 - i4) - i5};
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int[] getSubtileWH(SubTitleUnit subTitleUnit) {
        float abs;
        float abs2;
        float f;
        float f2;
        float f3;
        SubTitleConfig subTitleConfig;
        int i;
        float abs3;
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

    private void initConfig(SubTitleUnit subTitleUnit) {
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

    private void initXY(SubTitleUnit subTitleUnit) {
        int[] subtileWH = getSubtileWH(subTitleUnit);
        Bitmap a = g1a.a(subTitleUnit.mTextStyleEntity);
        this.mNineBitmap = a;
        NinePatchChunk f = g1a.f(a, subTitleUnit.mTextStyleEntity);
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

    private void onGetSubtitleBitmap(final SubTitleUnit subTitleUnit, final boolean z) {
        if (!this.mIsSync) {
            Handler handler = this.mHandler;
            if (handler == null) {
                return;
            }
            handler.post(new Runnable() { // from class: com.baidu.ugc.editvideo.subtitle.NewSubTitleCreater.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap createSubtitleBitmap = NewSubTitleCreater.this.createSubtitleBitmap(subTitleUnit);
                    if (NewSubTitleCreater.this.saveBitmap) {
                        String str = NewSubTitleCreater.this.savePath;
                        FileUtils.saveBitmap2JPG(str, System.currentTimeMillis() + ".jpg", createSubtitleBitmap, 90);
                    }
                    if (createSubtitleBitmap == null || createSubtitleBitmap.isRecycled()) {
                        return;
                    }
                    synchronized (NewSubTitleCreater.this.mSubtitleCache) {
                        subTitleUnit.textBitmap = createSubtitleBitmap;
                        if (z && NewSubTitleCreater.this.mSubtitleCreaterCallBack != null) {
                            NewSubTitleCreater.this.mSubtitleCreaterCallBack.onSubtitleBitmapCreated();
                        }
                        NewSubTitleCreater.this.mSubtitleCache.put(NewSubTitleCreater.this.getCacheKey(subTitleUnit), createSubtitleBitmap);
                        subTitleUnit.mIsNeedCache = true;
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

    private void startHandleThreadIfNeed(boolean z) {
        if (z) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("createsubtitlebitmap");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public SubTitleUnit getSubTitle(long j, long j2) {
        Bitmap value;
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

    public SubTitleConfig getSubTitleConfig() {
        return this.mSubTitleConfig;
    }

    public SubTitleUnit getSubTitleSync(long j) {
        SubTitleUnit subTitleUnit;
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

    public List<SubTitleUnit> getSubTitleUnits() {
        return this.mSubTitleUnits;
    }

    public void release() {
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

    public void releaseBitmap() {
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

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        this.mSubTitleConfig = subTitleConfig;
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        this.mSubTitleUnits = list;
    }

    public void setSubtitleCreaterCallBack(SubtitleCreaterCallBack subtitleCreaterCallBack) {
        this.mSubtitleCreaterCallBack = subtitleCreaterCallBack;
    }
}

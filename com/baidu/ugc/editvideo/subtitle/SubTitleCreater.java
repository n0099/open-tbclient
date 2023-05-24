package com.baidu.ugc.editvideo.subtitle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.tieba.gna;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class SubTitleCreater {
    public boolean isUseInSDK;
    public int mBottomPadding;
    public int mDefaultChsTextColor;
    public int mDefaultChsTextSize;
    public int mDefaultEngTextColor;
    public int mDefaultEngTextSize;
    public Bitmap mEmptyBitMap;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean mIsNeedEng;
    public boolean mIsSync;
    public int mLinePadding;
    public int mMinLeftPadding;
    public int mMinRightPadding;
    public int mShadowColor;
    public SubTitleConfig mSubTitleConfig;
    public List<SubTitleUnit> mSubTitleUnits;
    public int mSubTitleX;
    public int mSubTitleY;
    public volatile HashMap<String, Bitmap> mSubtitleCache;
    public TextWordsEntity.TextColorEntity mTextColor;
    public int mVideoHeight;
    public int mVideoWidth;

    public SubTitleCreater(List<SubTitleUnit> list) {
        this(list, false);
    }

    public SubTitleCreater(List<SubTitleUnit> list, boolean z) {
        this.mIsSync = z;
        this.mSubTitleUnits = list;
        this.mSubtitleCache = new HashMap<>();
        this.mBottomPadding = 5;
        this.mLinePadding = 5;
        this.mMinRightPadding = 5;
        this.mMinLeftPadding = 5;
        this.mIsNeedEng = false;
        startHandleThreadIfNeed(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap createSubtitleBitmap(SubTitleUnit subTitleUnit) {
        int i;
        int i2;
        if (this.mVideoWidth <= 0 || this.mSubTitleY <= 0 || TextUtils.isEmpty(subTitleUnit.line)) {
            gna.e("SubTitleCreater", "mVideoWidth:" + this.mVideoWidth + ",mSubTitleY:" + this.mSubTitleY + "title:" + subTitleUnit.line);
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(this.mVideoWidth, this.mSubTitleY, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i3 = 1;
        Paint paint = new Paint(1);
        paint.setShadowLayer(2.0f, 0.0f, 2.0f, this.mShadowColor);
        if (subTitleUnit.textColor == 0) {
            subTitleUnit.textColor = this.mDefaultChsTextColor;
        }
        if (subTitleUnit.textSize == 0.0f) {
            subTitleUnit.textSize = this.mDefaultChsTextSize;
        }
        if (subTitleUnit.engTextColor == 0) {
            subTitleUnit.engTextColor = this.mDefaultEngTextColor;
        }
        if (subTitleUnit.engTextSize == 0.0f) {
            subTitleUnit.engTextSize = this.mDefaultEngTextSize;
        }
        int i4 = 0;
        if (!this.mIsNeedEng || TextUtils.isEmpty(subTitleUnit.engLine)) {
            i3 = 0;
        } else {
            paint.setColor(subTitleUnit.engTextColor);
            paint.setTextSize(subTitleUnit.engTextSize);
            float measureText = paint.measureText(subTitleUnit.engLine);
            int i5 = this.mVideoWidth;
            if (measureText > (i5 - this.mMinLeftPadding) - this.mMinRightPadding) {
                canvas.save();
                canvas.translate(this.mMinLeftPadding, (this.mSubTitleY - this.mBottomPadding) - (subTitleUnit.engTextSize * 2.0f));
                TextPaint textPaint = new TextPaint();
                textPaint.setColor(subTitleUnit.engTextColor);
                textPaint.setStyle(Paint.Style.FILL);
                textPaint.setTextSize(subTitleUnit.engTextSize);
                textPaint.setShadowLayer(2.0f, 0.0f, 2.0f, this.mShadowColor);
                String str = subTitleUnit.engLine;
                StaticLayout staticLayout = new StaticLayout(str, 0, str.length(), textPaint, (canvas.getWidth() - this.mMinLeftPadding) - this.mMinRightPadding, Layout.Alignment.ALIGN_CENTER, 0.9f, 0.0f, false, TextUtils.TruncateAt.END, (canvas.getWidth() - this.mMinLeftPadding) - this.mMinRightPadding);
                int lineCount = staticLayout.getLineCount();
                if (lineCount > 2) {
                    String substring = subTitleUnit.engLine.substring(0, staticLayout.getLineEnd(1));
                    staticLayout = new StaticLayout(substring, 0, substring.length(), textPaint, (canvas.getWidth() - this.mMinLeftPadding) - this.mMinRightPadding, Layout.Alignment.ALIGN_CENTER, 0.9f, 0.0f, false, TextUtils.TruncateAt.END, (canvas.getWidth() - this.mMinLeftPadding) - this.mMinRightPadding);
                }
                i4 = staticLayout.getHeight();
                staticLayout.draw(canvas);
                canvas.restore();
                i3 = lineCount;
            } else {
                i4 = (int) subTitleUnit.engTextSize;
                canvas.drawText(subTitleUnit.engLine, (i5 - measureText) / 2.0f, this.mSubTitleY - this.mBottomPadding, paint);
            }
        }
        if (i3 == 0) {
            i = this.mSubTitleY;
            i2 = this.mBottomPadding;
        } else {
            i = (this.mSubTitleY - this.mBottomPadding) - i4;
            i2 = this.mLinePadding;
        }
        int i6 = i - i2;
        paint.setColor(subTitleUnit.textColor);
        paint.setTextSize(subTitleUnit.textSize);
        float measureText2 = paint.measureText(subTitleUnit.line);
        int i7 = this.mVideoWidth;
        int i8 = this.mMinLeftPadding;
        int i9 = (measureText2 > ((i7 - i8) - this.mMinRightPadding) ? 1 : (measureText2 == ((i7 - i8) - this.mMinRightPadding) ? 0 : -1));
        String str2 = subTitleUnit.line;
        if (i9 > 0) {
            canvas.drawText(str2, i8, i6, paint);
        } else {
            canvas.drawText(str2, (i7 - measureText2) / 2.0f, i6, paint);
        }
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheKey(SubTitleUnit subTitleUnit) {
        if (subTitleUnit == null) {
            return "";
        }
        return subTitleUnit.line + isNeedEng();
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

    private void startHandleThreadIfNeed(boolean z) {
        if (z) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("createsubtitlebitmap");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public int getLinePadding() {
        return this.mLinePadding;
    }

    public int getMinLeftPadding() {
        return this.mMinLeftPadding;
    }

    public int getMinRightPadding() {
        return this.mMinRightPadding;
    }

    public SubTitleUnit getSubTitle(final long j) {
        List<SubTitleUnit> list = this.mSubTitleUnits;
        if (list == null) {
            return getEmptySubTitle();
        }
        for (final SubTitleUnit subTitleUnit : list) {
            if (j >= subTitleUnit.startTime && j <= subTitleUnit.endTime) {
                synchronized (this.mSubtitleCache) {
                    Bitmap bitmap = this.mSubtitleCache.get(getCacheKey(subTitleUnit));
                    if (bitmap != null && !bitmap.isRecycled()) {
                        SubTitleUnit subTitleUnit2 = new SubTitleUnit();
                        subTitleUnit2.line = subTitleUnit.line;
                        subTitleUnit2.textBitmap = bitmap;
                        return subTitleUnit2;
                    }
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
                    if (!this.mIsSync) {
                        this.mHandler.post(new Runnable() { // from class: com.baidu.ugc.editvideo.subtitle.SubTitleCreater.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap createSubtitleBitmap = SubTitleCreater.this.createSubtitleBitmap(subTitleUnit);
                                if (createSubtitleBitmap == null || createSubtitleBitmap.isRecycled()) {
                                    return;
                                }
                                synchronized (SubTitleCreater.this.mSubtitleCache) {
                                    gna.e("subcreater", subTitleUnit.line + "," + subTitleUnit.engLine + "," + j);
                                    SubTitleCreater.this.mSubtitleCache.put(SubTitleCreater.this.getCacheKey(subTitleUnit), createSubtitleBitmap);
                                }
                            }
                        });
                        return getEmptySubTitle();
                    }
                    Bitmap createSubtitleBitmap = createSubtitleBitmap(subTitleUnit);
                    if (createSubtitleBitmap != null && !createSubtitleBitmap.isRecycled()) {
                        this.mSubtitleCache.put(getCacheKey(subTitleUnit), createSubtitleBitmap);
                        gna.e("subcreater", subTitleUnit.line + "," + subTitleUnit.engLine + "," + j);
                    }
                    SubTitleUnit subTitleUnit3 = new SubTitleUnit();
                    subTitleUnit3.line = subTitleUnit.line;
                    subTitleUnit3.textBitmap = createSubtitleBitmap;
                    return subTitleUnit3;
                }
            }
        }
        return getEmptySubTitle();
    }

    public SubTitleConfig getSubTitleConfig() {
        if (this.mSubTitleConfig == null) {
            SubTitleConfig subTitleConfig = new SubTitleConfig();
            this.mSubTitleConfig = subTitleConfig;
            subTitleConfig.mVideoHeight = this.mVideoHeight;
            subTitleConfig.mVideoWidth = this.mVideoWidth;
            subTitleConfig.mSubTitleY = this.mSubTitleY;
            subTitleConfig.mSubTitleX = this.mSubTitleX;
            subTitleConfig.mDefaultChsTextSize = this.mDefaultChsTextSize;
            subTitleConfig.mDefaultChsTextColor = this.mDefaultChsTextColor;
            subTitleConfig.mDefaultEngTextColor = this.mDefaultEngTextColor;
            subTitleConfig.mDefaultEngTextSize = this.mDefaultEngTextSize;
            subTitleConfig.mMinLeftPadding = this.mMinLeftPadding;
            subTitleConfig.mMinRightPadding = this.mMinRightPadding;
            subTitleConfig.mLinePadding = this.mLinePadding;
            subTitleConfig.mIsNeedEng = this.mIsNeedEng;
            subTitleConfig.mShadowColor = this.mShadowColor;
            subTitleConfig.mBottomPadding = this.mBottomPadding;
            subTitleConfig.mTextColorEntity = this.mTextColor;
        }
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
                        gna.e("subcreater", subTitleUnit2.line + "," + subTitleUnit2.engLine + "," + j);
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

    public int getSubTitleX() {
        return this.mSubTitleX;
    }

    public int getSubTitleY() {
        return this.mSubTitleY;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public boolean isNeedEng() {
        return this.mIsNeedEng;
    }

    public boolean isUseInSDK() {
        return this.isUseInSDK;
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
        Bitmap bitmap = this.mEmptyBitMap;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public void setBottomPadding(int i) {
        this.mBottomPadding = i;
    }

    public void setDefaultChsTextColor(int i) {
        this.mDefaultChsTextColor = i;
    }

    public void setDefaultChsTextSize(int i) {
        this.mDefaultChsTextSize = i;
    }

    public void setDefaultEngTextColor(int i) {
        this.mDefaultEngTextColor = i;
    }

    public void setDefaultEngTextSize(int i) {
        this.mDefaultEngTextSize = i;
    }

    public void setLinePadding(int i) {
        this.mLinePadding = i;
    }

    public void setMinLeftPadding(int i) {
        this.mMinLeftPadding = i;
    }

    public void setMinRightPadding(int i) {
        this.mMinRightPadding = i;
    }

    public void setNeedEng(boolean z) {
        this.mIsNeedEng = z;
    }

    public void setShadowColor(int i) {
        this.mShadowColor = i;
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        this.mSubTitleConfig = subTitleConfig;
        if (subTitleConfig != null) {
            this.mVideoHeight = subTitleConfig.mVideoHeight;
            this.mVideoWidth = subTitleConfig.mVideoWidth;
            this.mSubTitleY = subTitleConfig.mSubTitleY;
            this.mSubTitleX = subTitleConfig.mSubTitleX;
            this.mDefaultChsTextSize = subTitleConfig.mDefaultChsTextSize;
            this.mDefaultChsTextColor = subTitleConfig.mDefaultChsTextColor;
            this.mDefaultEngTextColor = subTitleConfig.mDefaultEngTextColor;
            this.mDefaultEngTextSize = subTitleConfig.mDefaultEngTextSize;
            this.mTextColor = subTitleConfig.mTextColorEntity;
            this.mMinLeftPadding = subTitleConfig.mMinLeftPadding;
            this.mMinRightPadding = subTitleConfig.mMinRightPadding;
            this.mLinePadding = subTitleConfig.mLinePadding;
            this.mIsNeedEng = subTitleConfig.mIsNeedEng;
            this.mShadowColor = subTitleConfig.mShadowColor;
            this.mBottomPadding = subTitleConfig.mBottomPadding;
        }
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        this.mSubTitleUnits = list;
    }

    public void setSubTitleX(int i) {
        this.mSubTitleX = i;
    }

    public void setSubTitleY(int i) {
        this.mSubTitleY = i;
    }

    public void setUseInSDK(boolean z) {
        this.isUseInSDK = z;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }
}

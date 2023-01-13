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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vr9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class SubTitleCreater {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SubTitleCreater(List<SubTitleUnit> list) {
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

    public SubTitleCreater(List<SubTitleUnit> list, boolean z) {
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
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, subTitleUnit)) == null) {
            if (this.mVideoWidth <= 0 || this.mSubTitleY <= 0 || TextUtils.isEmpty(subTitleUnit.line)) {
                vr9.e("SubTitleCreater", "mVideoWidth:" + this.mVideoWidth + ",mSubTitleY:" + this.mSubTitleY + "title:" + subTitleUnit.line);
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
        return (Bitmap) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheKey(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, subTitleUnit)) == null) {
            if (subTitleUnit == null) {
                return "";
            }
            return subTitleUnit.line + isNeedEng();
        }
        return (String) invokeL.objValue;
    }

    private SubTitleUnit getEmptySubTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
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

    private void startHandleThreadIfNeed(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65544, this, z) == null) || z) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("createsubtitlebitmap");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public int getLinePadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mLinePadding : invokeV.intValue;
    }

    public int getMinLeftPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mMinLeftPadding : invokeV.intValue;
    }

    public int getMinRightPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMinRightPadding : invokeV.intValue;
    }

    public SubTitleUnit getSubTitle(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            List<SubTitleUnit> list = this.mSubTitleUnits;
            if (list == null) {
                return getEmptySubTitle();
            }
            for (SubTitleUnit subTitleUnit : list) {
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
                            this.mHandler.post(new Runnable(this, subTitleUnit, j) { // from class: com.baidu.ugc.editvideo.subtitle.SubTitleCreater.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ SubTitleCreater this$0;
                                public final /* synthetic */ SubTitleUnit val$subTitleUnit;
                                public final /* synthetic */ long val$time;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, subTitleUnit, Long.valueOf(j)};
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
                                    this.val$time = j;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Bitmap createSubtitleBitmap;
                                    Interceptable interceptable2 = $ic;
                                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (createSubtitleBitmap = this.this$0.createSubtitleBitmap(this.val$subTitleUnit)) == null || createSubtitleBitmap.isRecycled()) {
                                        return;
                                    }
                                    synchronized (this.this$0.mSubtitleCache) {
                                        vr9.e("subcreater", this.val$subTitleUnit.line + "," + this.val$subTitleUnit.engLine + "," + this.val$time);
                                        this.this$0.mSubtitleCache.put(this.this$0.getCacheKey(this.val$subTitleUnit), createSubtitleBitmap);
                                    }
                                }
                            });
                            return getEmptySubTitle();
                        }
                        Bitmap createSubtitleBitmap = createSubtitleBitmap(subTitleUnit);
                        if (createSubtitleBitmap != null && !createSubtitleBitmap.isRecycled()) {
                            this.mSubtitleCache.put(getCacheKey(subTitleUnit), createSubtitleBitmap);
                            vr9.e("subcreater", subTitleUnit.line + "," + subTitleUnit.engLine + "," + j);
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
        return (SubTitleUnit) invokeJ.objValue;
    }

    public SubTitleConfig getSubTitleConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (SubTitleConfig) invokeV.objValue;
    }

    public SubTitleUnit getSubTitleSync(long j) {
        InterceptResult invokeJ;
        SubTitleUnit subTitleUnit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
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
                            vr9.e("subcreater", subTitleUnit2.line + "," + subTitleUnit2.engLine + "," + j);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mSubTitleUnits : (List) invokeV.objValue;
    }

    public int getSubTitleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSubTitleX : invokeV.intValue;
    }

    public int getSubTitleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSubTitleY : invokeV.intValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    public boolean isNeedEng() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mIsNeedEng : invokeV.booleanValue;
    }

    public boolean isUseInSDK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.isUseInSDK : invokeV.booleanValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
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
    }

    public void setBottomPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.mBottomPadding = i;
        }
    }

    public void setDefaultChsTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mDefaultChsTextColor = i;
        }
    }

    public void setDefaultChsTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mDefaultChsTextSize = i;
        }
    }

    public void setDefaultEngTextColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mDefaultEngTextColor = i;
        }
    }

    public void setDefaultEngTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.mDefaultEngTextSize = i;
        }
    }

    public void setLinePadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.mLinePadding = i;
        }
    }

    public void setMinLeftPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mMinLeftPadding = i;
        }
    }

    public void setMinRightPadding(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mMinRightPadding = i;
        }
    }

    public void setNeedEng(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.mIsNeedEng = z;
        }
    }

    public void setShadowColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.mShadowColor = i;
        }
    }

    public void setSubTitleConfig(SubTitleConfig subTitleConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, subTitleConfig) == null) {
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
    }

    public void setSubTitleUnits(List<SubTitleUnit> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.mSubTitleUnits = list;
        }
    }

    public void setSubTitleX(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mSubTitleX = i;
        }
    }

    public void setSubTitleY(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mSubTitleY = i;
        }
    }

    public void setUseInSDK(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isUseInSDK = z;
        }
    }

    public void setVideoHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.mVideoHeight = i;
        }
    }

    public void setVideoWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.mVideoWidth = i;
        }
    }
}

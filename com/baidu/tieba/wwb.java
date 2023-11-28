package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ugc.editvideo.data.Div;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.ninepatchchunk.NinePatchChunk;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class wwb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(TextWordsEntity.TextStyleEntity textStyleEntity) {
        InterceptResult invokeL;
        TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, textStyleEntity)) == null) {
            if (textStyleEntity == null || (styleBackgroudInfoEntity = textStyleEntity.mBackgroudInfoEntity) == null || !styleBackgroudInfoEntity.isLoaded()) {
                return null;
            }
            return uwb.f(styleBackgroudInfoEntity.getSourceFile().getAbsolutePath());
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void b(Bitmap bitmap, NinePatchChunk ninePatchChunk, Canvas canvas, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, bitmap, ninePatchChunk, canvas, i) == null) || bitmap == null || ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk.toBytes())) {
            return;
        }
        new NinePatch(bitmap, ninePatchChunk.toBytes(), null).draw(canvas, new Rect(i, i, canvas.getWidth() - i, canvas.getHeight() - i));
        bitmap.recycle();
    }

    public static void c(TextPaint textPaint, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextColorEntity textColorEntity) {
        TextWordsEntity.StyleShadowInfoEntity styleShadowInfoEntity;
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, textPaint, textStyleEntity, textColorEntity) == null) || textStyleEntity == null) {
            return;
        }
        List<TextWordsEntity.StyleShadowInfoEntity> list = textStyleEntity.mShadowInfoList;
        if (ywb.e(list) || (styleShadowInfoEntity = list.get(0)) == null) {
            return;
        }
        int i2 = i(styleShadowInfoEntity.mShadowColor, styleShadowInfoEntity.mShadowAlpha);
        if (textColorEntity != null && ((i = textStyleEntity.mTextStyleType) == 1 || i == 5)) {
            i2 = textColorEntity.mColorInfo;
        }
        textPaint.setShadowLayer(mxb.a(Integer.parseInt(styleShadowInfoEntity.mShadowBlur)), mxb.a(Integer.parseInt(styleShadowInfoEntity.mShadowOffsetX)), mxb.a(Integer.parseInt(styleShadowInfoEntity.mShadowOffsetY)), i2);
    }

    public static int[] d(TextPaint textPaint, TextPaint textPaint2, TextPaint textPaint3, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextColorEntity textColorEntity) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65539, null, textPaint, textPaint2, textPaint3, textStyleEntity, textColorEntity)) == null) {
            int[] iArr = new int[2];
            if (textStyleEntity == null) {
                return iArr;
            }
            List<TextWordsEntity.StyleStrokeInfoEntity> list = textStyleEntity.mStrokeInfoList;
            if (ywb.e(list)) {
                return iArr;
            }
            TextWordsEntity.StyleStrokeInfoEntity styleStrokeInfoEntity = list.get(0);
            if (styleStrokeInfoEntity != null) {
                textPaint2.setTextSize(textPaint.getTextSize());
                textPaint2.setFlags(textPaint.getFlags());
                textPaint2.setAlpha(textPaint.getAlpha());
                textPaint2.setFakeBoldText(textPaint.isFakeBoldText());
                textPaint2.setTextSkewX(textPaint.getTextSkewX());
                int i = i(styleStrokeInfoEntity.mStrokeColor, styleStrokeInfoEntity.mStrokeAlpha);
                if (textColorEntity != null && textStyleEntity.mTextStyleType == 2) {
                    i = textColorEntity.mColorInfo;
                }
                textPaint2.setStyle(Paint.Style.STROKE);
                textPaint2.setColor(i);
                textPaint2.setStrokeWidth(mxb.a(Integer.parseInt(styleStrokeInfoEntity.mStrokeWidth)));
            }
            iArr[0] = 1;
            if (list.size() <= 1) {
                return iArr;
            }
            TextWordsEntity.StyleStrokeInfoEntity styleStrokeInfoEntity2 = list.get(1);
            if (styleStrokeInfoEntity2 != null) {
                textPaint3.setTextSize(textPaint.getTextSize());
                textPaint3.setFlags(textPaint.getFlags());
                textPaint3.setAlpha(textPaint.getAlpha());
                textPaint3.setFakeBoldText(textPaint.isFakeBoldText());
                textPaint3.setTextSkewX(textPaint.getTextSkewX());
                textPaint3.setStyle(Paint.Style.STROKE);
                textPaint3.setColor(i(styleStrokeInfoEntity2.mStrokeColor, styleStrokeInfoEntity2.mStrokeAlpha));
                textPaint3.setStrokeWidth(mxb.a(Integer.parseInt(styleStrokeInfoEntity2.mStrokeWidth)));
            }
            iArr[1] = 1;
            return iArr;
        }
        return (int[]) invokeLLLLL.objValue;
    }

    public static void e(Canvas canvas, TextPaint textPaint, int i, int i2, int i3, TextWordsEntity.TextStyleEntity textStyleEntity, TextWordsEntity.TextColorEntity textColorEntity) {
        int i4;
        LinearGradient linearGradient;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{canvas, textPaint, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), textStyleEntity, textColorEntity}) == null) || textStyleEntity == null) {
            return;
        }
        List<TextWordsEntity.StyleTextInfoEntity> list = textStyleEntity.mTextInfoList;
        if (ywb.e(list)) {
            return;
        }
        if (TextUtils.equals(textStyleEntity.mTextType, "0") || list.size() > 1) {
            if (TextUtils.equals(textStyleEntity.mTextType, "1")) {
                linearGradient = new LinearGradient(0.0f, i2, canvas.getWidth(), i3, new int[]{h(list.get(0)), h(list.get(1))}, (float[]) null, Shader.TileMode.CLAMP);
            } else if (!TextUtils.equals(textStyleEntity.mTextType, "2")) {
                int h = h(list.get(0));
                if (textColorEntity != null && ((i4 = textStyleEntity.mTextStyleType) == 1 || i4 == 2 || i4 == 3)) {
                    h = textColorEntity.mColorInfo;
                }
                textPaint.setColor(h);
                return;
            } else {
                linearGradient = new LinearGradient(canvas.getWidth(), i2, canvas.getWidth(), i3, new int[]{h(list.get(0)), h(list.get(1))}, (float[]) null, Shader.TileMode.CLAMP);
            }
            textPaint.setShader(linearGradient);
        }
    }

    public static NinePatchChunk f(Bitmap bitmap, TextWordsEntity.TextStyleEntity textStyleEntity) {
        InterceptResult invokeLL;
        TextWordsEntity.StyleBackgroudInfoEntity styleBackgroudInfoEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bitmap, textStyleEntity)) == null) {
            if (bitmap == null || textStyleEntity == null || (styleBackgroudInfoEntity = textStyleEntity.mBackgroudInfoEntity) == null) {
                return null;
            }
            NinePatchChunk ninePatchChunk = new NinePatchChunk();
            ArrayList<Div> arrayList = styleBackgroudInfoEntity.mStretchableX;
            ArrayList<Div> arrayList2 = styleBackgroudInfoEntity.mStretchableY;
            ninePatchChunk.xDivs = arrayList;
            ninePatchChunk.yDivs = arrayList2;
            Rect rect = new Rect();
            ninePatchChunk.padding = rect;
            rect.left = styleBackgroudInfoEntity.mBackgroudLeft;
            rect.top = styleBackgroudInfoEntity.mBackgroudTop;
            rect.right = styleBackgroudInfoEntity.mBackgroudRight;
            rect.bottom = styleBackgroudInfoEntity.mBackgroudBottom;
            NinePatchChunk.createColors(bitmap, ninePatchChunk);
            return ninePatchChunk;
        }
        return (NinePatchChunk) invokeLL.objValue;
    }

    public static int g(TextPaint textPaint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, textPaint)) == null) {
            Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
            return Math.abs(fontMetricsInt.ascent) + Math.abs(fontMetricsInt.descent);
        }
        return invokeL.intValue;
    }

    public static int h(TextWordsEntity.StyleTextInfoEntity styleTextInfoEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, styleTextInfoEntity)) == null) {
            if (styleTextInfoEntity == null) {
                return 0;
            }
            return i(styleTextInfoEntity.mTextColor, styleTextInfoEntity.mTextAlpha);
        }
        return invokeL.intValue;
    }

    public static int i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            try {
                String hexString = Integer.toHexString((int) (Float.parseFloat(str2) * 255.0f));
                return Color.parseColor("#" + hexString + str);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeLL.intValue;
    }
}

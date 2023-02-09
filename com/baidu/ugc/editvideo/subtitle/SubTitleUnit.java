package com.baidu.ugc.editvideo.subtitle;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.kx9;
import com.baidu.tieba.lx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.RichStickerBaseUnit;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import com.baidu.ugc.editvideo.subtitle.SubTitleConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SubTitleUnit extends RichStickerBaseUnit implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int backgroudPaddingLeft;
    public int backgroudPaddingTop;
    public int chineseShadowColor;
    public SubTitleConfig.ShadowConfig chineseShadowConfig;
    public SubTitleConfig.StrokeConfig chineseStrokeConfig;
    public Typeface chineseTypeface;
    public SubTitleConfig.TypefaceConfig chineseTypefaceConfig;
    public int currentIndex;
    public float energy;
    public String engLine;
    public int engShadowColor;
    public SubTitleConfig.ShadowConfig engShadowConfig;
    public SubTitleConfig.StrokeConfig engStrokeConfig;
    public int engTextColor;
    public float engTextSize;
    public Typeface engTypeface;
    public SubTitleConfig.TypefaceConfig engTypefaceConfig;
    public int height;
    public int isChineseBold;
    public int isChineseCenterBlank;
    public int isChineseItalic;
    public int isEngBold;
    public int isEngCenterBlank;
    public int isEngItalic;
    public boolean isPreviousRotated;
    public float leftPaddingPercent;
    public float leftPercent;
    public String line;
    public boolean mIsNeedCache;
    public SubTitleUnit mOriginalUnit;
    public TextWordsEntity.TextColorEntity mTextColorEntity;
    public TextWordsEntity.TextStyleEntity mTextStyleEntity;
    public int padding;
    public int rotate;
    public float scale;
    public Bitmap textBitmap;
    public int textColor;
    public Paint.Align textGravity;
    public float textSize;
    public float topPaddingPercent;
    public float topPercent;
    public int width;
    public int x;
    public int y;

    public SubTitleUnit() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isChineseBold = -1;
        this.isChineseItalic = -1;
        this.isChineseCenterBlank = -1;
        this.isEngBold = -1;
        this.isEngItalic = -1;
        this.isEngCenterBlank = -1;
        this.x = -1;
        this.y = -1;
        this.leftPercent = -1.0f;
        this.topPercent = -1.0f;
        this.padding = 20;
        this.backgroudPaddingTop = 0;
        this.backgroudPaddingLeft = 0;
        this.textGravity = Paint.Align.LEFT;
    }

    public static String arrayToJson(List<SubTitleUnit> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            if (lx9.e(list)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            try {
                for (SubTitleUnit subTitleUnit : list) {
                    String beanToJson = beanToJson(subTitleUnit);
                    if (!TextUtils.isEmpty(beanToJson)) {
                        jSONArray.put(beanToJson);
                    }
                }
                return jSONArray.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static String beanToJson(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, subTitleUnit)) == null) {
            if (subTitleUnit == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("line", subTitleUnit.line);
                jSONObject.put("engLine", subTitleUnit.engLine);
                jSONObject.put("textSize", String.valueOf(subTitleUnit.textSize));
                jSONObject.put("scale", String.valueOf(subTitleUnit.scale));
                jSONObject.put("rotate", subTitleUnit.rotate);
                jSONObject.put("textColor", subTitleUnit.textColor);
                jSONObject.put("chineseShadowColor", subTitleUnit.chineseShadowColor);
                jSONObject.put("isChineseBold", subTitleUnit.isChineseBold);
                jSONObject.put("isChineseItalic", subTitleUnit.isChineseItalic);
                jSONObject.put("engTextColor", subTitleUnit.engTextColor);
                jSONObject.put("engTextSize", String.valueOf(subTitleUnit.engTextSize));
                jSONObject.put("engShadowColor", subTitleUnit.engShadowColor);
                jSONObject.put("isEngBold", subTitleUnit.isEngBold);
                jSONObject.put("isEngItalic", subTitleUnit.isEngItalic);
                jSONObject.put("startTime", subTitleUnit.startTime);
                jSONObject.put("endTime", subTitleUnit.endTime);
                jSONObject.put("energy", String.valueOf(subTitleUnit.energy));
                jSONObject.put("currentIndex", subTitleUnit.currentIndex);
                jSONObject.put("isPreviousRotated", subTitleUnit.isPreviousRotated);
                jSONObject.put("leftPercent", String.valueOf(subTitleUnit.leftPercent));
                jSONObject.put("topPercent", String.valueOf(subTitleUnit.topPercent));
                jSONObject.put("x", subTitleUnit.x);
                jSONObject.put("y", subTitleUnit.y);
                jSONObject.put("width", subTitleUnit.width);
                jSONObject.put("height", subTitleUnit.height);
                jSONObject.put("isChineseCenterBlank", subTitleUnit.isChineseCenterBlank);
                jSONObject.put("isEngCenterBlank", subTitleUnit.isEngCenterBlank);
                if (subTitleUnit.chineseShadowConfig != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("shadowRadius", String.valueOf(subTitleUnit.chineseShadowConfig.shadowRadius));
                    jSONObject2.put("shadowDx", String.valueOf(subTitleUnit.chineseShadowConfig.shadowDx));
                    jSONObject2.put("shadowDy", String.valueOf(subTitleUnit.chineseShadowConfig.shadowDy));
                    jSONObject.put("chinese_shadow_config", jSONObject2);
                }
                if (subTitleUnit.engShadowConfig != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("shadowRadius", String.valueOf(subTitleUnit.engShadowConfig.shadowRadius));
                    jSONObject3.put("shadowDx", String.valueOf(subTitleUnit.engShadowConfig.shadowDx));
                    jSONObject3.put("shadowDy", String.valueOf(subTitleUnit.engShadowConfig.shadowDy));
                    jSONObject.put("eng_shadow_config", jSONObject3);
                }
                if (subTitleUnit.chineseStrokeConfig != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("strokeColor", subTitleUnit.chineseStrokeConfig.strokeColor);
                    jSONObject4.put("strokeWidth", subTitleUnit.chineseStrokeConfig.strokeWidth);
                    jSONObject.put("chineseStrokeConfig", jSONObject4);
                }
                if (subTitleUnit.engStrokeConfig != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("strokeColor", subTitleUnit.engStrokeConfig.strokeColor);
                    jSONObject5.put("strokeWidth", subTitleUnit.engStrokeConfig.strokeWidth);
                    jSONObject.put("engStrokeConfig", jSONObject5);
                }
                if (subTitleUnit.chineseTypefaceConfig != null) {
                    jSONObject.put("chineseTypefaceConfig", SubTitleConfig.TypefaceConfig.toJson(subTitleUnit.chineseTypefaceConfig));
                }
                if (subTitleUnit.engTypefaceConfig != null) {
                    jSONObject.put("engTypefaceConfig", SubTitleConfig.TypefaceConfig.toJson(subTitleUnit.engTypefaceConfig));
                }
                return jSONObject.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<SubTitleUnit> parseArray(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    SubTitleUnit parseBean = parseBean(jSONArray.optString(i));
                    if (parseBean != null) {
                        arrayList.add(parseBean);
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    public static SubTitleUnit parseBean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            SubTitleUnit subTitleUnit = new SubTitleUnit();
            try {
                JSONObject jSONObject = new JSONObject(str);
                subTitleUnit.line = jSONObject.optString("line");
                subTitleUnit.engLine = jSONObject.optString("engLine");
                subTitleUnit.textSize = kx9.a(jSONObject.optString("textSize"), 0.0f);
                subTitleUnit.scale = kx9.a(jSONObject.optString("scale"), 0.0f);
                subTitleUnit.rotate = jSONObject.optInt("rotate");
                subTitleUnit.textColor = jSONObject.optInt("textColor");
                subTitleUnit.chineseShadowColor = jSONObject.optInt("chineseShadowColor");
                subTitleUnit.isChineseBold = jSONObject.optInt("isChineseBold", -1);
                subTitleUnit.isChineseItalic = jSONObject.optInt("isChineseItalic", -1);
                subTitleUnit.engTextColor = jSONObject.optInt("engTextColor");
                subTitleUnit.engTextSize = kx9.a(jSONObject.optString("engTextSize"), 0.0f);
                subTitleUnit.engShadowColor = jSONObject.optInt("engShadowColor");
                subTitleUnit.isEngBold = jSONObject.optInt("isEngBold", -1);
                subTitleUnit.isEngItalic = jSONObject.optInt("isEngItalic", -1);
                subTitleUnit.startTime = jSONObject.optLong("startTime");
                subTitleUnit.endTime = jSONObject.optLong("endTime");
                subTitleUnit.energy = kx9.a(jSONObject.optString("energy"), 0.0f);
                subTitleUnit.currentIndex = jSONObject.optInt("currentIndex");
                subTitleUnit.isPreviousRotated = jSONObject.optBoolean("isPreviousRotated");
                subTitleUnit.leftPercent = kx9.a(jSONObject.optString("leftPercent"), 0.0f);
                subTitleUnit.topPercent = kx9.a(jSONObject.optString("topPercent"), 0.0f);
                subTitleUnit.x = jSONObject.optInt("x");
                subTitleUnit.y = jSONObject.optInt("y");
                subTitleUnit.width = jSONObject.optInt("width");
                subTitleUnit.height = jSONObject.optInt("height");
                subTitleUnit.isChineseCenterBlank = jSONObject.optInt("isChineseCenterBlank");
                subTitleUnit.isEngCenterBlank = jSONObject.optInt("isEngCenterBlank");
                JSONObject optJSONObject = jSONObject.optJSONObject("chinese_shadow_config");
                if (optJSONObject != null) {
                    SubTitleConfig.ShadowConfig shadowConfig = new SubTitleConfig.ShadowConfig();
                    shadowConfig.shadowRadius = kx9.a(optJSONObject.optString("shadowRadius"), 2.0f);
                    shadowConfig.shadowDx = kx9.a(optJSONObject.optString("shadowDx"), 0.0f);
                    shadowConfig.shadowDy = kx9.a(optJSONObject.optString("shadowDy"), 2.0f);
                    subTitleUnit.chineseShadowConfig = shadowConfig;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("eng_shadow_config");
                if (optJSONObject2 != null) {
                    SubTitleConfig.ShadowConfig shadowConfig2 = new SubTitleConfig.ShadowConfig();
                    shadowConfig2.shadowRadius = kx9.a(optJSONObject2.optString("shadowRadius"), 2.0f);
                    shadowConfig2.shadowDx = kx9.a(optJSONObject2.optString("shadowDx"), 0.0f);
                    shadowConfig2.shadowDy = kx9.a(optJSONObject2.optString("shadowDy"), 2.0f);
                    subTitleUnit.engShadowConfig = shadowConfig2;
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("chineseStrokeConfig");
                if (optJSONObject3 != null) {
                    SubTitleConfig.StrokeConfig strokeConfig = new SubTitleConfig.StrokeConfig();
                    strokeConfig.strokeWidth = kx9.a(optJSONObject3.optString("strokeWidth"), 0.0f);
                    strokeConfig.strokeColor = optJSONObject3.optInt("strokeColor");
                    subTitleUnit.chineseStrokeConfig = strokeConfig;
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("engStrokeConfig");
                if (optJSONObject4 != null) {
                    SubTitleConfig.StrokeConfig strokeConfig2 = new SubTitleConfig.StrokeConfig();
                    strokeConfig2.strokeWidth = kx9.a(optJSONObject4.optString("strokeWidth"), 0.0f);
                    strokeConfig2.strokeColor = optJSONObject4.optInt("strokeColor");
                    subTitleUnit.engStrokeConfig = strokeConfig2;
                }
                String optString = jSONObject.optString("chineseTypefaceConfig");
                if (!TextUtils.isEmpty(optString)) {
                    SubTitleConfig.TypefaceConfig parseJson = SubTitleConfig.TypefaceConfig.parseJson(optString);
                    subTitleUnit.chineseTypefaceConfig = parseJson;
                    subTitleUnit.chineseTypeface = SubTitleConfig.TypefaceConfig.toTypeFace(parseJson);
                }
                String optString2 = jSONObject.optString("engTypefaceConfig");
                if (!TextUtils.isEmpty(optString2)) {
                    SubTitleConfig.TypefaceConfig parseJson2 = SubTitleConfig.TypefaceConfig.parseJson(optString2);
                    subTitleUnit.engTypefaceConfig = parseJson2;
                    subTitleUnit.engTypeface = SubTitleConfig.TypefaceConfig.toTypeFace(parseJson2);
                }
                return subTitleUnit;
            } catch (Exception unused) {
                return null;
            }
        }
        return (SubTitleUnit) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public SubTitleUnit m76clone() throws CloneNotSupportedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (SubTitleUnit) super.clone() : (SubTitleUnit) invokeV.objValue;
    }

    public AnimatorSet generateFrame(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        InterceptResult invokeL;
        float f;
        ValueAnimator ofFloat;
        LinearInterpolator linearInterpolator;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animatorUpdateListener)) == null) {
            float f2 = (float) (this.endTime - this.startTime);
            ArrayList arrayList = new ArrayList();
            if (f2 < 1000.0f) {
                int i = this.currentIndex;
                ofFloat = ValueAnimator.ofFloat(i, i + 0.999999f);
                ofFloat.setDuration(f2);
                ofFloat.addUpdateListener(animatorUpdateListener);
                linearInterpolator = new LinearInterpolator();
            } else {
                if (this.isPreviousRotated) {
                    int i2 = this.currentIndex;
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2, i2 + 0.3f);
                    ofFloat2.setDuration(10L);
                    ofFloat2.addUpdateListener(animatorUpdateListener);
                    ofFloat2.setInterpolator(new LinearInterpolator());
                    arrayList.add(ofFloat2);
                    f = 10.0f;
                } else {
                    int i3 = this.currentIndex;
                    ValueAnimator ofFloat3 = ValueAnimator.ofFloat(i3, i3 + 0.3f);
                    ofFloat3.setDuration(300L);
                    ofFloat3.addUpdateListener(animatorUpdateListener);
                    ofFloat3.setInterpolator(new LinearInterpolator());
                    arrayList.add(ofFloat3);
                    f = 300.0f;
                }
                float f3 = f2 - f;
                int i4 = this.currentIndex;
                ValueAnimator ofFloat4 = ValueAnimator.ofFloat(i4 + 0.3f, i4 + 0.5f);
                ofFloat4.setDuration(200L);
                ofFloat4.addUpdateListener(animatorUpdateListener);
                ofFloat4.setInterpolator(new LinearInterpolator());
                arrayList.add(ofFloat4);
                float f4 = f3 - 200.0f;
                if (this.rotate != 0) {
                    int i5 = this.currentIndex;
                    ofFloat = ValueAnimator.ofFloat(i5 + 0.8f, i5 + 0.999999f);
                    ofFloat.setDuration(200L);
                    ofFloat.addUpdateListener(animatorUpdateListener);
                    ofFloat.setInterpolator(new LinearInterpolator());
                    int i6 = this.currentIndex;
                    ValueAnimator ofFloat5 = ValueAnimator.ofFloat(i6 + 0.5f, i6 + 0.8f);
                    ofFloat5.setDuration(f4 - 200.0f);
                    ofFloat5.addUpdateListener(animatorUpdateListener);
                    ofFloat5.setInterpolator(new LinearInterpolator());
                    arrayList.add(ofFloat5);
                    arrayList.add(ofFloat);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playSequentially(arrayList);
                    return animatorSet;
                }
                int i7 = this.currentIndex;
                ofFloat = ValueAnimator.ofFloat(i7 + 0.5f, i7 + 0.999999f);
                ofFloat.setDuration(f4);
                ofFloat.addUpdateListener(animatorUpdateListener);
                linearInterpolator = new LinearInterpolator();
            }
            ofFloat.setInterpolator(linearInterpolator);
            arrayList.add(ofFloat);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playSequentially(arrayList);
            return animatorSet2;
        }
        return (AnimatorSet) invokeL.objValue;
    }

    public boolean isSameProperty(SubTitleUnit subTitleUnit) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, subTitleUnit)) == null) ? subTitleUnit != null && Float.compare(subTitleUnit.textSize, this.textSize) == 0 && Float.compare(subTitleUnit.scale, this.scale) == 0 && this.rotate == subTitleUnit.rotate && this.textColor == subTitleUnit.textColor && this.engTextColor == subTitleUnit.engTextColor && Float.compare(subTitleUnit.engTextSize, this.engTextSize) == 0 && this.startTime == subTitleUnit.startTime && this.endTime == subTitleUnit.endTime && Float.compare(subTitleUnit.energy, this.energy) == 0 && this.currentIndex == subTitleUnit.currentIndex && this.isPreviousRotated == subTitleUnit.isPreviousRotated && Float.compare(subTitleUnit.leftPercent, this.leftPercent) == 0 && Float.compare(subTitleUnit.topPercent, this.topPercent) == 0 && Objects.equals(this.line, subTitleUnit.line) && Objects.equals(this.engLine, subTitleUnit.engLine) : invokeL.booleanValue;
    }
}

package com.baidu.ugc.editvideo.subtitle;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import com.baidu.tieba.usa;
import com.baidu.tieba.vwa;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class SubTitleConfig {
    public static final int CENTER = 0;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_HORIZONTAL_CENTER_POSITION = 2;
    public StrokeConfig chineseStrokeConfig;
    public Typeface chineseTypeface;
    public TypefaceConfig chineseTypefaceConfig;
    public int engShadowColor;
    public StrokeConfig engStrokeConfig;
    public Typeface engTypeface;
    public TypefaceConfig engTypefaceConfig;
    public int isChineseBold;
    public int isChineseItalic;
    public int isEngBold;
    public int isEngItalic;
    public boolean isHorizontal;
    public int mBottomPadding;
    public PointF mCenterPoint;
    public int mDefaultChsTextColor;
    public int mDefaultChsTextSize;
    public int mDefaultEngTextColor;
    public int mDefaultEngTextSize;
    public boolean mIsNeedEng;
    public int mLinePadding;
    public int mMinLeftPadding;
    public int mMinRightPadding;
    public int mShadowColor;
    @Deprecated
    public int mSubTitleX;
    @Deprecated
    public int mSubTitleY;
    public TextWordsEntity.TextColorEntity mTextColorEntity;
    public TextWordsEntity.TextStyleEntity mTextStyleEntity;
    public int mVideoHeight;
    public int mVideoWidth;
    public int gravity = 1;
    public int maxChineseLineNum = 1;
    public int maxEngLineNum = 2;
    public int isChineseCenterBlank = 0;
    public int isEngCenterBlank = 0;
    public ShadowConfig chineseShadowConfig = new ShadowConfig();
    public ShadowConfig engShadowConfig = new ShadowConfig();
    public int innerPadding = 20;
    public Paint.Align textGravity = Paint.Align.CENTER;
    public float mScale = 1.0f;

    /* loaded from: classes8.dex */
    public static class ShadowConfig {
        public float shadowRadius = 2.0f;
        public float shadowDx = 0.0f;
        public float shadowDy = 2.0f;
    }

    /* loaded from: classes8.dex */
    public static class StrokeConfig {
        public float strokeWidth = 0.0f;
        public int strokeColor = 0;
    }

    /* loaded from: classes8.dex */
    public static class TypefaceConfig {
        public static final int CREATE_FROM_ASSET = 1;
        public static final int CREATE_FROM_FILE = 2;
        public String mId;
        public int mInputType;
        public String mSource;

        public static TypefaceConfig parseJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                TypefaceConfig typefaceConfig = new TypefaceConfig();
                typefaceConfig.mInputType = jSONObject.optInt("input_type");
                typefaceConfig.mSource = jSONObject.optString("source");
                typefaceConfig.mId = jSONObject.optString("id");
                return typefaceConfig;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static String toJson(TypefaceConfig typefaceConfig) {
            if (typefaceConfig == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("input_type", typefaceConfig.mInputType);
                jSONObject.put("source", typefaceConfig.mSource);
                jSONObject.put("id", typefaceConfig.mId);
                return jSONObject.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }

        public static Typeface toTypeFace(TypefaceConfig typefaceConfig) {
            Typeface typeface = null;
            if (typefaceConfig == null) {
                return null;
            }
            if (typefaceConfig != null) {
                try {
                    int i = typefaceConfig.mInputType;
                    if (i == 1) {
                        typeface = Typeface.createFromAsset(usa.c().getContext().getAssets(), typefaceConfig.mSource);
                    } else if (i == 2) {
                        typeface = Typeface.createFromFile(typefaceConfig.mSource);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return typeface;
        }

        public static Typeface toTypeFace(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return toTypeFace(parseJson(str));
        }
    }

    public static String beanToJson(SubTitleConfig subTitleConfig) {
        if (subTitleConfig == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mVideoWidth", subTitleConfig.mVideoWidth);
            jSONObject.put("mVideoHeight", subTitleConfig.mVideoHeight);
            jSONObject.put("mSubTitleX", subTitleConfig.mSubTitleX);
            jSONObject.put("mSubTitleY", subTitleConfig.mSubTitleY);
            jSONObject.put("mMinLeftPadding", subTitleConfig.mMinLeftPadding);
            jSONObject.put("mMinRightPadding", subTitleConfig.mMinRightPadding);
            jSONObject.put("mLinePadding", subTitleConfig.mLinePadding);
            jSONObject.put("mIsNeedEng", subTitleConfig.mIsNeedEng);
            jSONObject.put(NotificationCompat.WearableExtender.KEY_GRAVITY, subTitleConfig.gravity);
            jSONObject.put("mDefaultChsTextSize", subTitleConfig.mDefaultChsTextSize);
            jSONObject.put("mDefaultChsTextColor", subTitleConfig.mDefaultChsTextColor);
            jSONObject.put("mDefaultEngTextColor", subTitleConfig.mDefaultEngTextColor);
            jSONObject.put("mDefaultEngTextSize", subTitleConfig.mDefaultEngTextSize);
            jSONObject.put("mShadowColor", subTitleConfig.mShadowColor);
            jSONObject.put("mBottomPadding", subTitleConfig.mBottomPadding);
            jSONObject.put("isChineseBold", subTitleConfig.isChineseBold);
            jSONObject.put("isChineseItalic", subTitleConfig.isChineseItalic);
            jSONObject.put("engShadowColor", subTitleConfig.engShadowColor);
            jSONObject.put("isEngBold", subTitleConfig.isEngBold);
            jSONObject.put("isEngItalic", subTitleConfig.isEngItalic);
            jSONObject.put("maxChineseLineNum", subTitleConfig.maxChineseLineNum);
            jSONObject.put("maxEngLineNum", subTitleConfig.maxEngLineNum);
            jSONObject.put("isChineseCenterBlank", subTitleConfig.isChineseCenterBlank);
            jSONObject.put("isEngCenterBlank", subTitleConfig.isEngCenterBlank);
            if (subTitleConfig.mTextColorEntity != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("color", subTitleConfig.mTextColorEntity.mColor);
                jSONObject2.put(Key.ALPHA, subTitleConfig.mTextColorEntity.mAlpha);
                jSONObject.put("textColor", jSONObject2);
            }
            if (subTitleConfig.chineseShadowConfig != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("shadowRadius", String.valueOf(subTitleConfig.chineseShadowConfig.shadowRadius));
                jSONObject3.put("shadowDx", String.valueOf(subTitleConfig.chineseShadowConfig.shadowDx));
                jSONObject3.put("shadowDy", String.valueOf(subTitleConfig.chineseShadowConfig.shadowDy));
                jSONObject.put("chinese_shadow_config", jSONObject3);
            }
            if (subTitleConfig.engShadowConfig != null) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("shadowRadius", String.valueOf(subTitleConfig.engShadowConfig.shadowRadius));
                jSONObject4.put("shadowDx", String.valueOf(subTitleConfig.engShadowConfig.shadowDx));
                jSONObject4.put("shadowDy", String.valueOf(subTitleConfig.engShadowConfig.shadowDy));
                jSONObject.put("eng_shadow_config", jSONObject4);
            }
            if (subTitleConfig.chineseStrokeConfig != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("strokeColor", subTitleConfig.chineseStrokeConfig.strokeColor);
                jSONObject5.put("strokeWidth", subTitleConfig.chineseStrokeConfig.strokeWidth);
                jSONObject.put("chineseStrokeConfig", jSONObject5);
            }
            if (subTitleConfig.engStrokeConfig != null) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("strokeColor", subTitleConfig.engStrokeConfig.strokeColor);
                jSONObject6.put("strokeWidth", subTitleConfig.engStrokeConfig.strokeWidth);
                jSONObject.put("engStrokeConfig", jSONObject6);
            }
            jSONObject.put("isHorizontal", subTitleConfig.isHorizontal);
            jSONObject.put("mScale", String.valueOf(subTitleConfig.mScale));
            if (subTitleConfig.chineseTypefaceConfig != null) {
                jSONObject.put("chineseTypefaceConfig", TypefaceConfig.toJson(subTitleConfig.chineseTypefaceConfig));
            }
            if (subTitleConfig.engTypefaceConfig != null) {
                jSONObject.put("engTypefaceConfig", TypefaceConfig.toJson(subTitleConfig.engTypefaceConfig));
            }
            if (subTitleConfig.mCenterPoint != null) {
                jSONObject.put("centerPointerX", String.valueOf(subTitleConfig.mCenterPoint.x));
                jSONObject.put("centerPointerY", String.valueOf(subTitleConfig.mCenterPoint.y));
            }
            if (subTitleConfig.mTextStyleEntity != null) {
                jSONObject.put("textStyleEntity", TextWordsEntity.TextStyleEntity.toJson(subTitleConfig.mTextStyleEntity));
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static SubTitleConfig parseBean(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SubTitleConfig subTitleConfig = new SubTitleConfig();
        try {
            JSONObject jSONObject = new JSONObject(str);
            subTitleConfig.mVideoWidth = jSONObject.optInt("mVideoWidth");
            subTitleConfig.mVideoHeight = jSONObject.optInt("mVideoHeight");
            subTitleConfig.mSubTitleX = jSONObject.optInt("mSubTitleX");
            subTitleConfig.mSubTitleY = jSONObject.optInt("mSubTitleY");
            subTitleConfig.mMinLeftPadding = jSONObject.optInt("mMinLeftPadding");
            subTitleConfig.mMinRightPadding = jSONObject.optInt("mMinRightPadding");
            subTitleConfig.mLinePadding = jSONObject.optInt("mLinePadding");
            subTitleConfig.mIsNeedEng = jSONObject.optBoolean("mIsNeedEng");
            subTitleConfig.gravity = jSONObject.optInt(NotificationCompat.WearableExtender.KEY_GRAVITY);
            subTitleConfig.mDefaultChsTextSize = jSONObject.optInt("mDefaultChsTextSize");
            subTitleConfig.mDefaultChsTextColor = jSONObject.optInt("mDefaultChsTextColor");
            subTitleConfig.mDefaultEngTextColor = jSONObject.optInt("mDefaultEngTextColor");
            subTitleConfig.mDefaultEngTextSize = jSONObject.optInt("mDefaultEngTextSize");
            subTitleConfig.mShadowColor = jSONObject.optInt("mShadowColor");
            subTitleConfig.mBottomPadding = jSONObject.optInt("mBottomPadding");
            subTitleConfig.isChineseBold = jSONObject.optInt("isChineseBold");
            subTitleConfig.isChineseItalic = jSONObject.optInt("isChineseItalic");
            subTitleConfig.engShadowColor = jSONObject.optInt("engShadowColor");
            subTitleConfig.isEngItalic = jSONObject.optInt("isEngItalic");
            subTitleConfig.maxChineseLineNum = jSONObject.optInt("maxChineseLineNum", 1);
            subTitleConfig.maxEngLineNum = jSONObject.optInt("maxEngLineNum", 2);
            subTitleConfig.isChineseCenterBlank = jSONObject.optInt("isChineseCenterBlank");
            subTitleConfig.isEngCenterBlank = jSONObject.optInt("isEngCenterBlank");
            JSONObject optJSONObject = jSONObject.optJSONObject("textColor");
            if (optJSONObject != null) {
                subTitleConfig.mTextColorEntity = TextWordsEntity.TextColorEntity.parse(optJSONObject);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("chinese_shadow_config");
            if (optJSONObject2 != null) {
                ShadowConfig shadowConfig = new ShadowConfig();
                shadowConfig.shadowRadius = vwa.a(optJSONObject2.optString("shadowRadius"), 2.0f);
                shadowConfig.shadowDx = vwa.a(optJSONObject2.optString("shadowDx"), 0.0f);
                shadowConfig.shadowDy = vwa.a(optJSONObject2.optString("shadowDy"), 2.0f);
                subTitleConfig.chineseShadowConfig = shadowConfig;
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("eng_shadow_config");
            if (optJSONObject3 != null) {
                ShadowConfig shadowConfig2 = new ShadowConfig();
                shadowConfig2.shadowRadius = vwa.a(optJSONObject3.optString("shadowRadius"), 2.0f);
                shadowConfig2.shadowDx = vwa.a(optJSONObject3.optString("shadowDx"), 0.0f);
                shadowConfig2.shadowDy = vwa.a(optJSONObject3.optString("shadowDy"), 2.0f);
                subTitleConfig.engShadowConfig = shadowConfig2;
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("chineseStrokeConfig");
            if (optJSONObject4 != null) {
                StrokeConfig strokeConfig = new StrokeConfig();
                strokeConfig.strokeWidth = vwa.a(optJSONObject4.optString("strokeWidth"), 0.0f);
                strokeConfig.strokeColor = optJSONObject4.optInt("strokeColor");
                subTitleConfig.chineseStrokeConfig = strokeConfig;
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("engStrokeConfig");
            if (optJSONObject5 != null) {
                StrokeConfig strokeConfig2 = new StrokeConfig();
                strokeConfig2.strokeWidth = vwa.a(optJSONObject5.optString("strokeWidth"), 0.0f);
                strokeConfig2.strokeColor = optJSONObject5.optInt("strokeColor");
                subTitleConfig.engStrokeConfig = strokeConfig2;
            }
            subTitleConfig.isHorizontal = jSONObject.optBoolean("isHorizontal", false);
            subTitleConfig.mScale = vwa.a(jSONObject.optString("mScale"), 1.0f);
            String optString = jSONObject.optString("chineseTypefaceConfig");
            if (!TextUtils.isEmpty(optString)) {
                TypefaceConfig parseJson = TypefaceConfig.parseJson(optString);
                subTitleConfig.chineseTypefaceConfig = parseJson;
                subTitleConfig.chineseTypeface = TypefaceConfig.toTypeFace(parseJson);
            }
            String optString2 = jSONObject.optString("engTypefaceConfig");
            if (!TextUtils.isEmpty(optString2)) {
                TypefaceConfig parseJson2 = TypefaceConfig.parseJson(optString2);
                subTitleConfig.engTypefaceConfig = parseJson2;
                subTitleConfig.engTypeface = TypefaceConfig.toTypeFace(parseJson2);
            }
            float a = vwa.a(jSONObject.optString("centerPointerX"), -2.1474836E9f);
            float a2 = vwa.a(jSONObject.optString("centerPointerY"), -2.1474836E9f);
            if (a != -2.1474836E9f && a2 != -2.1474836E9f) {
                subTitleConfig.mCenterPoint = new PointF(a, a2);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("textStyleEntity");
            if (optJSONObject6 != null) {
                subTitleConfig.mTextStyleEntity = TextWordsEntity.TextStyleEntity.parse(optJSONObject6);
            }
            return subTitleConfig;
        } catch (Exception unused) {
            return null;
        }
    }
}

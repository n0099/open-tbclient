package com.baidu.ugc.editvideo.subtitle;

import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.pi9;
import com.baidu.tieba.qm9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.data.TextWordsEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class SubTitleConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CENTER = 0;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_HORIZONTAL_CENTER_POSITION = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ShadowConfig chineseShadowConfig;
    public StrokeConfig chineseStrokeConfig;
    public Typeface chineseTypeface;
    public TypefaceConfig chineseTypefaceConfig;
    public int engShadowColor;
    public ShadowConfig engShadowConfig;
    public StrokeConfig engStrokeConfig;
    public Typeface engTypeface;
    public TypefaceConfig engTypefaceConfig;
    public int gravity;
    public int innerPadding;
    public int isChineseBold;
    public int isChineseCenterBlank;
    public int isChineseItalic;
    public int isEngBold;
    public int isEngCenterBlank;
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
    public float mScale;
    public int mShadowColor;
    @Deprecated
    public int mSubTitleX;
    @Deprecated
    public int mSubTitleY;
    public TextWordsEntity.TextColorEntity mTextColorEntity;
    public TextWordsEntity.TextStyleEntity mTextStyleEntity;
    public int mVideoHeight;
    public int mVideoWidth;
    public int maxChineseLineNum;
    public int maxEngLineNum;
    public Paint.Align textGravity;

    /* loaded from: classes7.dex */
    public static class ShadowConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float shadowDx;
        public float shadowDy;
        public float shadowRadius;

        public ShadowConfig() {
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
            this.shadowRadius = 2.0f;
            this.shadowDx = 0.0f;
            this.shadowDy = 2.0f;
        }
    }

    /* loaded from: classes7.dex */
    public static class StrokeConfig {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int strokeColor;
        public float strokeWidth;

        public StrokeConfig() {
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
            this.strokeWidth = 0.0f;
            this.strokeColor = 0;
        }
    }

    /* loaded from: classes7.dex */
    public static class TypefaceConfig {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int CREATE_FROM_ASSET = 1;
        public static final int CREATE_FROM_FILE = 2;
        public transient /* synthetic */ FieldHolder $fh;
        public String mId;
        public int mInputType;
        public String mSource;

        public TypefaceConfig() {
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

        public static TypefaceConfig parseJson(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
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
            return (TypefaceConfig) invokeL.objValue;
        }

        public static String toJson(TypefaceConfig typefaceConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, typefaceConfig)) == null) {
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
            return (String) invokeL.objValue;
        }

        public static Typeface toTypeFace(TypefaceConfig typefaceConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, typefaceConfig)) == null) {
                Typeface typeface = null;
                if (typefaceConfig == null) {
                    return null;
                }
                if (typefaceConfig != null) {
                    try {
                        int i = typefaceConfig.mInputType;
                        if (i == 1) {
                            typeface = Typeface.createFromAsset(pi9.c().getContext().getAssets(), typefaceConfig.mSource);
                        } else if (i == 2) {
                            typeface = Typeface.createFromFile(typefaceConfig.mSource);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return typeface;
            }
            return (Typeface) invokeL.objValue;
        }

        public static Typeface toTypeFace(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return toTypeFace(parseJson(str));
            }
            return (Typeface) invokeL.objValue;
        }
    }

    public SubTitleConfig() {
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
        this.gravity = 1;
        this.maxChineseLineNum = 1;
        this.maxEngLineNum = 2;
        this.isChineseCenterBlank = 0;
        this.isEngCenterBlank = 0;
        this.chineseShadowConfig = new ShadowConfig();
        this.engShadowConfig = new ShadowConfig();
        this.innerPadding = 20;
        this.textGravity = Paint.Align.CENTER;
        this.mScale = 1.0f;
    }

    public static String beanToJson(SubTitleConfig subTitleConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, subTitleConfig)) == null) {
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
        return (String) invokeL.objValue;
    }

    public static SubTitleConfig parseBean(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
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
                    shadowConfig.shadowRadius = qm9.a(optJSONObject2.optString("shadowRadius"), 2.0f);
                    shadowConfig.shadowDx = qm9.a(optJSONObject2.optString("shadowDx"), 0.0f);
                    shadowConfig.shadowDy = qm9.a(optJSONObject2.optString("shadowDy"), 2.0f);
                    subTitleConfig.chineseShadowConfig = shadowConfig;
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("eng_shadow_config");
                if (optJSONObject3 != null) {
                    ShadowConfig shadowConfig2 = new ShadowConfig();
                    shadowConfig2.shadowRadius = qm9.a(optJSONObject3.optString("shadowRadius"), 2.0f);
                    shadowConfig2.shadowDx = qm9.a(optJSONObject3.optString("shadowDx"), 0.0f);
                    shadowConfig2.shadowDy = qm9.a(optJSONObject3.optString("shadowDy"), 2.0f);
                    subTitleConfig.engShadowConfig = shadowConfig2;
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("chineseStrokeConfig");
                if (optJSONObject4 != null) {
                    StrokeConfig strokeConfig = new StrokeConfig();
                    strokeConfig.strokeWidth = qm9.a(optJSONObject4.optString("strokeWidth"), 0.0f);
                    strokeConfig.strokeColor = optJSONObject4.optInt("strokeColor");
                    subTitleConfig.chineseStrokeConfig = strokeConfig;
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("engStrokeConfig");
                if (optJSONObject5 != null) {
                    StrokeConfig strokeConfig2 = new StrokeConfig();
                    strokeConfig2.strokeWidth = qm9.a(optJSONObject5.optString("strokeWidth"), 0.0f);
                    strokeConfig2.strokeColor = optJSONObject5.optInt("strokeColor");
                    subTitleConfig.engStrokeConfig = strokeConfig2;
                }
                subTitleConfig.isHorizontal = jSONObject.optBoolean("isHorizontal", false);
                subTitleConfig.mScale = qm9.a(jSONObject.optString("mScale"), 1.0f);
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
                float a = qm9.a(jSONObject.optString("centerPointerX"), -2.1474836E9f);
                float a2 = qm9.a(jSONObject.optString("centerPointerY"), -2.1474836E9f);
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
        return (SubTitleConfig) invokeL.objValue;
    }
}

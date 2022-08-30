package com.baidu.ugc.editvideo.data;

import androidx.constraintlayout.motion.widget.Key;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.cc9;
import com.baidu.tieba.jc9;
import com.baidu.tieba.uc9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.producers.ProducerConstants;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TextWordsEntity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<TextFontEntity> mCoverFontList;
    public List<TextStyleEntity> mCoverStyleList;
    public List<TextColorEntity> mCoverTextColorList;

    /* loaded from: classes6.dex */
    public static class StyleBackgroudInfoEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(Key.ALPHA)
        public String mBackgroudAlpha;
        @SerializedName("bottom")
        public int mBackgroudBottom;
        @SerializedName("color")
        public String mBackgroudColor;
        @SerializedName("imageUrl")
        public String mBackgroudImageUrl;
        @SerializedName("left")
        public int mBackgroudLeft;
        @SerializedName("right")
        public int mBackgroudRight;
        @SerializedName("top")
        public int mBackgroudTop;
        @SerializedName("width")
        public int mBackgroudWidth;
        @SerializedName(ProducerConstants.EXTRA_IMAGE_TYPE)
        public int mImageType;
        @SerializedName("localParentFile")
        public String mLocalParentFile;
        public File mSourceFile;
        @SerializedName("stretchableX")
        public ArrayList<Div> mStretchableX;
        @SerializedName("stretchableY")
        public ArrayList<Div> mStretchableY;

        public StyleBackgroudInfoEntity() {
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
            this.mSourceFile = null;
            this.mLocalParentFile = null;
        }

        public static StyleBackgroudInfoEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                StyleBackgroudInfoEntity styleBackgroudInfoEntity = new StyleBackgroudInfoEntity();
                try {
                    styleBackgroudInfoEntity.mBackgroudColor = jSONObject.optString("color");
                    styleBackgroudInfoEntity.mBackgroudAlpha = jSONObject.optString(Key.ALPHA);
                    styleBackgroudInfoEntity.mBackgroudImageUrl = jSONObject.optString("imageUrl");
                    styleBackgroudInfoEntity.mLocalParentFile = jSONObject.optString("localParentFile");
                    styleBackgroudInfoEntity.mBackgroudLeft = jSONObject.optInt("left");
                    styleBackgroudInfoEntity.mBackgroudTop = jSONObject.optInt("top");
                    styleBackgroudInfoEntity.mBackgroudRight = jSONObject.optInt("right");
                    styleBackgroudInfoEntity.mBackgroudBottom = jSONObject.optInt("bottom");
                    styleBackgroudInfoEntity.mBackgroudWidth = jSONObject.optInt("width");
                    styleBackgroudInfoEntity.mImageType = jSONObject.optInt(ProducerConstants.EXTRA_IMAGE_TYPE);
                    JSONArray optJSONArray = jSONObject.optJSONArray("stretchableX");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("stretchableY");
                    ArrayList<Div> arrayList = new ArrayList<>();
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            Div div = new Div();
                            div.start = optJSONObject.optInt("start");
                            div.stop = optJSONObject.optInt(IntentConfig.STOP);
                            arrayList.add(div);
                        }
                    }
                    styleBackgroudInfoEntity.mStretchableX = arrayList;
                    ArrayList<Div> arrayList2 = new ArrayList<>();
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            Div div2 = new Div();
                            div2.parse(optJSONObject2);
                            arrayList2.add(div2);
                        }
                    }
                    styleBackgroudInfoEntity.mStretchableY = arrayList2;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return styleBackgroudInfoEntity;
            }
            return (StyleBackgroudInfoEntity) invokeL.objValue;
        }

        public static JSONObject toJson(StyleBackgroudInfoEntity styleBackgroudInfoEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, styleBackgroudInfoEntity)) == null) {
                if (styleBackgroudInfoEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("color", styleBackgroudInfoEntity.mBackgroudColor);
                    jSONObject.put(Key.ALPHA, styleBackgroudInfoEntity.mBackgroudAlpha);
                    jSONObject.put("imageUrl", styleBackgroudInfoEntity.mBackgroudImageUrl);
                    jSONObject.put("localParentFile", styleBackgroudInfoEntity.mLocalParentFile);
                    jSONObject.put("left", styleBackgroudInfoEntity.mBackgroudLeft);
                    jSONObject.put("top", styleBackgroudInfoEntity.mBackgroudTop);
                    jSONObject.put("right", styleBackgroudInfoEntity.mBackgroudRight);
                    jSONObject.put("bottom", styleBackgroudInfoEntity.mBackgroudBottom);
                    jSONObject.put("width", styleBackgroudInfoEntity.mBackgroudWidth);
                    jSONObject.put(ProducerConstants.EXTRA_IMAGE_TYPE, styleBackgroudInfoEntity.mImageType);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<Div> it = styleBackgroudInfoEntity.mStretchableX.iterator();
                    while (it.hasNext()) {
                        Div next = it.next();
                        if (next != null) {
                            jSONArray.put(next.toJson());
                        }
                    }
                    jSONObject.put("stretchableX", jSONArray);
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator<Div> it2 = styleBackgroudInfoEntity.mStretchableY.iterator();
                    while (it2.hasNext()) {
                        Div next2 = it2.next();
                        if (next2 != null) {
                            jSONArray2.put(next2.toJson());
                        }
                    }
                    jSONObject.put("stretchableY", jSONArray2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public File getSourceFile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (uc9.a(this.mBackgroudImageUrl)) {
                    return new File("");
                }
                if (this.mSourceFile == null) {
                    String str = this.mLocalParentFile;
                    StringBuilder sb = new StringBuilder();
                    sb.append(jc9.b(this.mBackgroudImageUrl));
                    String str2 = this.mBackgroudImageUrl;
                    sb.append(str2.substring(str2.lastIndexOf(".")));
                    this.mSourceFile = new File(str, sb.toString());
                }
                return this.mSourceFile;
            }
            return (File) invokeV.objValue;
        }

        public boolean isLoaded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? getSourceFile() != null && getSourceFile().exists() : invokeV.booleanValue;
        }

        public boolean isNeedDown() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? uc9.a(this.mBackgroudImageUrl) : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class StyleShadowInfoEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(Key.ALPHA)
        public String mShadowAlpha;
        @SerializedName(ConstPath.KEY_BLUR)
        public String mShadowBlur;
        @SerializedName("color")
        public String mShadowColor;
        @SerializedName("offset_x")
        public String mShadowOffsetX;
        @SerializedName("offset_y")
        public String mShadowOffsetY;
        @SerializedName("width")
        public String mShadowWidth;

        public StyleShadowInfoEntity() {
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

        public static StyleShadowInfoEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                StyleShadowInfoEntity styleShadowInfoEntity = new StyleShadowInfoEntity();
                try {
                    styleShadowInfoEntity.mShadowColor = jSONObject.optString("color");
                    styleShadowInfoEntity.mShadowAlpha = jSONObject.optString(Key.ALPHA);
                    styleShadowInfoEntity.mShadowOffsetX = jSONObject.optString("offset_x");
                    styleShadowInfoEntity.mShadowOffsetY = jSONObject.optString("offset_y");
                    styleShadowInfoEntity.mShadowBlur = jSONObject.optString(ConstPath.KEY_BLUR);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return styleShadowInfoEntity;
            }
            return (StyleShadowInfoEntity) invokeL.objValue;
        }

        public static JSONObject toJson(StyleShadowInfoEntity styleShadowInfoEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, styleShadowInfoEntity)) == null) {
                if (styleShadowInfoEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("color", styleShadowInfoEntity.mShadowColor);
                    jSONObject.put(Key.ALPHA, styleShadowInfoEntity.mShadowAlpha);
                    jSONObject.put("offset_x", styleShadowInfoEntity.mShadowOffsetX);
                    jSONObject.put("offset_y", styleShadowInfoEntity.mShadowOffsetY);
                    jSONObject.put(ConstPath.KEY_BLUR, styleShadowInfoEntity.mShadowBlur);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class StyleStrokeInfoEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(Key.ALPHA)
        public String mStrokeAlpha;
        @SerializedName("color")
        public String mStrokeColor;
        @SerializedName("width")
        public String mStrokeWidth;

        public StyleStrokeInfoEntity() {
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

        public static StyleStrokeInfoEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                StyleStrokeInfoEntity styleStrokeInfoEntity = new StyleStrokeInfoEntity();
                try {
                    styleStrokeInfoEntity.mStrokeColor = jSONObject.optString("color");
                    styleStrokeInfoEntity.mStrokeAlpha = jSONObject.optString(Key.ALPHA);
                    styleStrokeInfoEntity.mStrokeWidth = jSONObject.optString("width");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return styleStrokeInfoEntity;
            }
            return (StyleStrokeInfoEntity) invokeL.objValue;
        }

        public static JSONObject toJson(StyleStrokeInfoEntity styleStrokeInfoEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, styleStrokeInfoEntity)) == null) {
                if (styleStrokeInfoEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("color", styleStrokeInfoEntity.mStrokeColor);
                    jSONObject.put(Key.ALPHA, styleStrokeInfoEntity.mStrokeAlpha);
                    jSONObject.put("width", styleStrokeInfoEntity.mStrokeWidth);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class StyleTextInfoEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName(Key.ALPHA)
        public String mTextAlpha;
        @SerializedName("color")
        public String mTextColor;

        public StyleTextInfoEntity() {
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

        public static StyleTextInfoEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                StyleTextInfoEntity styleTextInfoEntity = new StyleTextInfoEntity();
                try {
                    styleTextInfoEntity.mTextColor = jSONObject.optString("color");
                    styleTextInfoEntity.mTextAlpha = jSONObject.optString(Key.ALPHA);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return styleTextInfoEntity;
            }
            return (StyleTextInfoEntity) invokeL.objValue;
        }

        public static JSONObject toJson(StyleTextInfoEntity styleTextInfoEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, styleTextInfoEntity)) == null) {
                if (styleTextInfoEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("color", styleTextInfoEntity.mTextColor);
                    jSONObject.put(Key.ALPHA, styleTextInfoEntity.mTextAlpha);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class TextColorEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mAlpha;
        public String mColor;
        public int mColorInfo;

        public TextColorEntity() {
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

        public static TextColorEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                TextColorEntity textColorEntity = new TextColorEntity();
                try {
                    textColorEntity.mColor = jSONObject.optString("color");
                    String optString = jSONObject.optString(Key.ALPHA);
                    textColorEntity.mAlpha = optString;
                    textColorEntity.mColorInfo = cc9.b(textColorEntity.mColor, optString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return textColorEntity;
            }
            return (TextColorEntity) invokeL.objValue;
        }

        public static JSONObject toJson(TextColorEntity textColorEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textColorEntity)) == null) {
                if (textColorEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("color", textColorEntity.mColor);
                    jSONObject.put(Key.ALPHA, textColorEntity.mAlpha);
                    jSONObject.put("color_info", textColorEntity.mColorInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class TextFontEntity {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String mDownloadUrl;
        public String mIconUrl;
        public String mId;
        public int mIsDefault;
        public String mName;
        public File mRootDir;
        public File mSourceFile;

        public TextFontEntity() {
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
            this.mIsDefault = 0;
            this.mSourceFile = null;
        }

        public static TextFontEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                TextFontEntity textFontEntity = new TextFontEntity();
                try {
                    textFontEntity.mId = jSONObject.optString("id");
                    textFontEntity.mName = jSONObject.optString("name");
                    textFontEntity.mIconUrl = jSONObject.optString("icon_url");
                    textFontEntity.mDownloadUrl = jSONObject.optString("download_url");
                    textFontEntity.mIsDefault = jSONObject.optInt(AddressField.KEY_IS_DEFAULT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return textFontEntity;
            }
            return (TextFontEntity) invokeL.objValue;
        }

        public static JSONObject toJson(TextFontEntity textFontEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textFontEntity)) == null) {
                if (textFontEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", textFontEntity.mId);
                    jSONObject.put("name", textFontEntity.mName);
                    jSONObject.put("icon_url", textFontEntity.mIconUrl);
                    jSONObject.put("download_url", textFontEntity.mDownloadUrl);
                    jSONObject.put(AddressField.KEY_IS_DEFAULT, textFontEntity.mIsDefault);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }

        public File getSourceFile() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mSourceFile == null) {
                    File file = this.mRootDir;
                    this.mSourceFile = new File(file, jc9.b(this.mDownloadUrl) + getSuffix());
                }
                return this.mSourceFile;
            }
            return (File) invokeV.objValue;
        }

        public String getSuffix() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDownloadUrl.contains(".otf") ? ".otf" : ".ttf" : (String) invokeV.objValue;
        }

        public boolean isDefault() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mIsDefault == 1 : invokeV.booleanValue;
        }

        public boolean isLoaded() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getSourceFile() != null && getSourceFile().exists() : invokeV.booleanValue;
        }

        public void setFontRootDir(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, file) == null) {
                this.mRootDir = file;
            }
        }

        public void setSourceFile(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, file) == null) {
                this.mSourceFile = file;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class TextStyleEntity {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int TEXT_STYLE_TYPE_1 = 1;
        public static final int TEXT_STYLE_TYPE_2 = 2;
        public static final int TEXT_STYLE_TYPE_3 = 3;
        public static final int TEXT_STYLE_TYPE_4 = 4;
        public static final int TEXT_STYLE_TYPE_5 = 5;
        public static final int TEXT_STYLE_TYPE_NONE = 0;
        public static final String TEXT_TYPE_HORIZONTAL = "1";
        public static final String TEXT_TYPE_NONE = "0";
        public static final String TEXT_TYPE_VERTICAL = "2";
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("background_infos")
        public StyleBackgroudInfoEntity mBackgroudInfoEntity;
        @SerializedName("icon_url")
        public String mIconUrl;
        @SerializedName("id")
        public String mId;
        @SerializedName("name")
        public String mName;
        @SerializedName("shadow_infos")
        public List<StyleShadowInfoEntity> mShadowInfoList;
        @SerializedName("stroke_infos")
        public List<StyleStrokeInfoEntity> mStrokeInfoList;
        @SerializedName("text_infos")
        public List<StyleTextInfoEntity> mTextInfoList;
        @SerializedName("type")
        public int mTextStyleType;
        @SerializedName("text_type")
        public String mTextType;

        public TextStyleEntity() {
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
            this.mTextType = "0";
            this.mTextStyleType = 0;
        }

        public static TextStyleEntity parse(JSONObject jSONObject) {
            InterceptResult invokeL;
            JSONArray optJSONArray;
            StyleShadowInfoEntity parse;
            JSONArray optJSONArray2;
            StyleStrokeInfoEntity parse2;
            JSONArray optJSONArray3;
            StyleTextInfoEntity parse3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return null;
                }
                TextStyleEntity textStyleEntity = new TextStyleEntity();
                try {
                    textStyleEntity.mId = jSONObject.optString("id");
                    textStyleEntity.mName = jSONObject.optString("name");
                    textStyleEntity.mIconUrl = jSONObject.optString("icon_url");
                    textStyleEntity.mTextType = jSONObject.optString("text_type");
                    textStyleEntity.mTextStyleType = jSONObject.optInt("type");
                    if (jSONObject.has("text_infos") && (optJSONArray3 = jSONObject.optJSONArray("text_infos")) != null && optJSONArray3.length() > 0) {
                        textStyleEntity.mTextInfoList = new ArrayList();
                        for (int i = 0; i < optJSONArray3.length(); i++) {
                            JSONObject optJSONObject = optJSONArray3.optJSONObject(i);
                            if (optJSONObject != null && (parse3 = StyleTextInfoEntity.parse(optJSONObject)) != null) {
                                textStyleEntity.mTextInfoList.add(parse3);
                            }
                        }
                    }
                    if (jSONObject.has("stroke_infos") && (optJSONArray2 = jSONObject.optJSONArray("stroke_infos")) != null && optJSONArray2.length() > 0) {
                        textStyleEntity.mStrokeInfoList = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject2 != null && (parse2 = StyleStrokeInfoEntity.parse(optJSONObject2)) != null) {
                                textStyleEntity.mStrokeInfoList.add(parse2);
                            }
                        }
                    }
                    if (jSONObject.has("shadow_infos") && (optJSONArray = jSONObject.optJSONArray("shadow_infos")) != null && optJSONArray.length() > 0) {
                        textStyleEntity.mShadowInfoList = new ArrayList();
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                            if (optJSONObject3 != null && (parse = StyleShadowInfoEntity.parse(optJSONObject3)) != null) {
                                textStyleEntity.mShadowInfoList.add(parse);
                            }
                        }
                    }
                    if (jSONObject.has("background_infos")) {
                        textStyleEntity.mBackgroudInfoEntity = StyleBackgroudInfoEntity.parse(jSONObject.optJSONObject("background_infos"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return textStyleEntity;
            }
            return (TextStyleEntity) invokeL.objValue;
        }

        public static JSONObject toJson(TextStyleEntity textStyleEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textStyleEntity)) == null) {
                if (textStyleEntity == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", textStyleEntity.mId);
                    jSONObject.put("name", textStyleEntity.mName);
                    jSONObject.put("icon_url", textStyleEntity.mIconUrl);
                    jSONObject.put("text_type", textStyleEntity.mTextType);
                    jSONObject.put("type", textStyleEntity.mTextStyleType);
                    if (textStyleEntity.mTextInfoList != null && textStyleEntity.mTextInfoList.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (StyleTextInfoEntity styleTextInfoEntity : textStyleEntity.mTextInfoList) {
                            jSONArray.put(StyleTextInfoEntity.toJson(styleTextInfoEntity));
                        }
                        jSONObject.put("text_infos", jSONArray);
                    }
                    if (textStyleEntity.mStrokeInfoList != null && textStyleEntity.mStrokeInfoList.size() > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StyleStrokeInfoEntity styleStrokeInfoEntity : textStyleEntity.mStrokeInfoList) {
                            jSONArray2.put(StyleStrokeInfoEntity.toJson(styleStrokeInfoEntity));
                        }
                        jSONObject.put("stroke_infos", jSONArray2);
                    }
                    if (textStyleEntity.mShadowInfoList != null && textStyleEntity.mShadowInfoList.size() > 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        for (StyleShadowInfoEntity styleShadowInfoEntity : textStyleEntity.mShadowInfoList) {
                            jSONArray3.put(StyleShadowInfoEntity.toJson(styleShadowInfoEntity));
                        }
                        jSONObject.put("shadow_infos", jSONArray3);
                    }
                    jSONObject.put("background_infos", StyleBackgroudInfoEntity.toJson(textStyleEntity.mBackgroudInfoEntity));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return jSONObject;
            }
            return (JSONObject) invokeL.objValue;
        }
    }

    public TextWordsEntity() {
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

    public static TextWordsEntity parse(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONArray optJSONArray;
        TextColorEntity parse;
        JSONArray optJSONArray2;
        TextFontEntity parse2;
        JSONArray optJSONArray3;
        TextStyleEntity parse3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            TextWordsEntity textWordsEntity = new TextWordsEntity();
            try {
                if (jSONObject.has("style") && (optJSONArray3 = jSONObject.optJSONArray("style")) != null && optJSONArray3.length() > 0) {
                    textWordsEntity.mCoverStyleList = new ArrayList();
                    for (int i = 0; i < optJSONArray3.length(); i++) {
                        JSONObject optJSONObject = optJSONArray3.optJSONObject(i);
                        if (optJSONObject != null && (parse3 = TextStyleEntity.parse(optJSONObject)) != null) {
                            textWordsEntity.mCoverStyleList.add(parse3);
                        }
                    }
                }
                if (jSONObject.has("font") && (optJSONArray2 = jSONObject.optJSONArray("font")) != null && optJSONArray2.length() > 0) {
                    textWordsEntity.mCoverFontList = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null && (parse2 = TextFontEntity.parse(optJSONObject2)) != null) {
                            textWordsEntity.mCoverFontList.add(parse2);
                        }
                    }
                }
                if (jSONObject.has("color") && (optJSONArray = jSONObject.optJSONArray("color")) != null && optJSONArray.length() > 0) {
                    textWordsEntity.mCoverTextColorList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i3);
                        if (optJSONObject3 != null && (parse = TextColorEntity.parse(optJSONObject3)) != null) {
                            textWordsEntity.mCoverTextColorList.add(parse);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return textWordsEntity;
        }
        return (TextWordsEntity) invokeL.objValue;
    }

    public static JSONObject toJson(TextWordsEntity textWordsEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, textWordsEntity)) == null) {
            if (textWordsEntity == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (textWordsEntity.mCoverStyleList != null && textWordsEntity.mCoverStyleList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (TextStyleEntity textStyleEntity : textWordsEntity.mCoverStyleList) {
                        jSONArray.put(TextStyleEntity.toJson(textStyleEntity));
                    }
                    jSONObject.put("style", jSONArray);
                }
                if (textWordsEntity.mCoverFontList != null && textWordsEntity.mCoverFontList.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (TextFontEntity textFontEntity : textWordsEntity.mCoverFontList) {
                        jSONArray2.put(TextFontEntity.toJson(textFontEntity));
                    }
                    jSONObject.put("font", jSONArray2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}

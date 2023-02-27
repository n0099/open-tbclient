package com.baidu.ugc.editvideo.data;

import androidx.constraintlayout.motion.widget.Key;
import com.baidu.pass.ecommerce.bean.AddressField;
import com.baidu.pass.face.platform.ConstPath;
import com.baidu.tieba.f1a;
import com.baidu.tieba.m1a;
import com.baidu.tieba.x1a;
import com.facebook.imagepipeline.producers.ProducerConstants;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class TextWordsEntity {
    public List<TextFontEntity> mCoverFontList;
    public List<TextStyleEntity> mCoverStyleList;
    public List<TextColorEntity> mCoverTextColorList;

    /* loaded from: classes7.dex */
    public static class StyleBackgroudInfoEntity {
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
        @SerializedName("stretchableX")
        public ArrayList<Div> mStretchableX;
        @SerializedName("stretchableY")
        public ArrayList<Div> mStretchableY;
        public File mSourceFile = null;
        @SerializedName("localParentFile")
        public String mLocalParentFile = null;

        public boolean isLoaded() {
            if (getSourceFile() != null && getSourceFile().exists()) {
                return true;
            }
            return false;
        }

        public boolean isNeedDown() {
            return x1a.a(this.mBackgroudImageUrl);
        }

        public static StyleBackgroudInfoEntity parse(JSONObject jSONObject) {
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
                        div.stop = optJSONObject.optInt("stop");
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

        public static JSONObject toJson(StyleBackgroudInfoEntity styleBackgroudInfoEntity) {
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

        public File getSourceFile() {
            if (x1a.a(this.mBackgroudImageUrl)) {
                return new File("");
            }
            if (this.mSourceFile == null) {
                String str = this.mLocalParentFile;
                StringBuilder sb = new StringBuilder();
                sb.append(m1a.b(this.mBackgroudImageUrl));
                String str2 = this.mBackgroudImageUrl;
                sb.append(str2.substring(str2.lastIndexOf(".")));
                this.mSourceFile = new File(str, sb.toString());
            }
            return this.mSourceFile;
        }
    }

    /* loaded from: classes7.dex */
    public static class TextFontEntity {
        public String mDownloadUrl;
        public String mIconUrl;
        public String mId;
        public String mName;
        public File mRootDir;
        public int mIsDefault = 0;
        public File mSourceFile = null;

        public File getSourceFile() {
            if (this.mSourceFile == null) {
                File file = this.mRootDir;
                this.mSourceFile = new File(file, m1a.b(this.mDownloadUrl) + getSuffix());
            }
            return this.mSourceFile;
        }

        public String getSuffix() {
            if (this.mDownloadUrl.contains(".otf")) {
                return ".otf";
            }
            return ".ttf";
        }

        public boolean isDefault() {
            if (this.mIsDefault == 1) {
                return true;
            }
            return false;
        }

        public boolean isLoaded() {
            if (getSourceFile() != null && getSourceFile().exists()) {
                return true;
            }
            return false;
        }

        public static TextFontEntity parse(JSONObject jSONObject) {
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

        public static JSONObject toJson(TextFontEntity textFontEntity) {
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

        public void setFontRootDir(File file) {
            this.mRootDir = file;
        }

        public void setSourceFile(File file) {
            this.mSourceFile = file;
        }
    }

    /* loaded from: classes7.dex */
    public static class StyleShadowInfoEntity {
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

        public static StyleShadowInfoEntity parse(JSONObject jSONObject) {
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

        public static JSONObject toJson(StyleShadowInfoEntity styleShadowInfoEntity) {
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
    }

    /* loaded from: classes7.dex */
    public static class StyleStrokeInfoEntity {
        @SerializedName(Key.ALPHA)
        public String mStrokeAlpha;
        @SerializedName("color")
        public String mStrokeColor;
        @SerializedName("width")
        public String mStrokeWidth;

        public static StyleStrokeInfoEntity parse(JSONObject jSONObject) {
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

        public static JSONObject toJson(StyleStrokeInfoEntity styleStrokeInfoEntity) {
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
    }

    /* loaded from: classes7.dex */
    public static class StyleTextInfoEntity {
        @SerializedName(Key.ALPHA)
        public String mTextAlpha;
        @SerializedName("color")
        public String mTextColor;

        public static StyleTextInfoEntity parse(JSONObject jSONObject) {
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

        public static JSONObject toJson(StyleTextInfoEntity styleTextInfoEntity) {
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
    }

    /* loaded from: classes7.dex */
    public static class TextColorEntity {
        public String mAlpha;
        public String mColor;
        public int mColorInfo;

        public static TextColorEntity parse(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            TextColorEntity textColorEntity = new TextColorEntity();
            try {
                textColorEntity.mColor = jSONObject.optString("color");
                String optString = jSONObject.optString(Key.ALPHA);
                textColorEntity.mAlpha = optString;
                textColorEntity.mColorInfo = f1a.b(textColorEntity.mColor, optString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return textColorEntity;
        }

        public static JSONObject toJson(TextColorEntity textColorEntity) {
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
    }

    /* loaded from: classes7.dex */
    public static class TextStyleEntity {
        public static final int TEXT_STYLE_TYPE_1 = 1;
        public static final int TEXT_STYLE_TYPE_2 = 2;
        public static final int TEXT_STYLE_TYPE_3 = 3;
        public static final int TEXT_STYLE_TYPE_4 = 4;
        public static final int TEXT_STYLE_TYPE_5 = 5;
        public static final int TEXT_STYLE_TYPE_NONE = 0;
        public static final String TEXT_TYPE_HORIZONTAL = "1";
        public static final String TEXT_TYPE_NONE = "0";
        public static final String TEXT_TYPE_VERTICAL = "2";
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
        @SerializedName("text_type")
        public String mTextType = "0";
        @SerializedName("type")
        public int mTextStyleType = 0;

        public static TextStyleEntity parse(JSONObject jSONObject) {
            JSONArray optJSONArray;
            StyleShadowInfoEntity parse;
            JSONArray optJSONArray2;
            StyleStrokeInfoEntity parse2;
            JSONArray optJSONArray3;
            StyleTextInfoEntity parse3;
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

        public static JSONObject toJson(TextStyleEntity textStyleEntity) {
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
    }

    public static TextWordsEntity parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        TextColorEntity parse;
        JSONArray optJSONArray2;
        TextFontEntity parse2;
        JSONArray optJSONArray3;
        TextStyleEntity parse3;
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

    public static JSONObject toJson(TextWordsEntity textWordsEntity) {
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
}

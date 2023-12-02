package com.baidu.ugc.editvideo.filter;

import android.text.TextUtils;
import com.baidu.minivideo.arface.bean.Filter;
import com.baidu.tieba.mxb;
import com.google.gson.Gson;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class FilterValue implements Serializable {
    public static final String DEFAULT_FILTER_VALUE = "origin";
    public static final int DU_FILTER = 2;
    public static final int FU_FILTER = 1;
    public String id;
    public int mComplex;
    public Filter mFilter;
    public String mFilterPath;
    public int mFilterType;
    public float mLevel;
    public String mName;
    public String mRootFilePath;
    public String mValue;

    public FilterValue() {
        this.mValue = "origin";
        this.mLevel = 0.4f;
        this.mFilterType = 1;
        this.mComplex = 0;
    }

    public FilterValue(int i, String str) {
        this.mValue = "origin";
        this.mLevel = 0.4f;
        this.mFilterType = 1;
        this.mComplex = 0;
        this.mFilterType = i;
        this.mFilterPath = str;
    }

    public FilterValue(String str) {
        this.mValue = "origin";
        this.mLevel = 0.4f;
        this.mFilterType = 1;
        this.mComplex = 0;
        this.mValue = str;
    }

    public FilterValue(String str, float f) {
        this.mValue = "origin";
        this.mLevel = 0.4f;
        this.mFilterType = 1;
        this.mComplex = 0;
        this.mValue = str;
        this.mLevel = f;
    }

    public static FilterValue parseToBean(String str) {
        if (mxb.a(str)) {
            return null;
        }
        try {
            return (FilterValue) new Gson().fromJson(str, (Class<Object>) FilterValue.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(FilterValue filterValue) {
        if (filterValue == null) {
            return "";
        }
        try {
            return new Gson().toJson(filterValue);
        } catch (Exception unused) {
            return "";
        }
    }

    public String getFilterPath() {
        return this.mFilterPath;
    }

    public int getFilterType() {
        return this.mFilterType;
    }

    public String getId() {
        return this.id;
    }

    public float getLevel() {
        return this.mLevel;
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
    }

    public boolean parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mName = jSONObject.optString("mName");
            this.mValue = jSONObject.optString("mValue");
            this.mLevel = ((Float) jSONObject.opt("mLevel")).floatValue();
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public void setFilterPath(String str) {
        this.mFilterPath = str;
    }

    public void setFilterType(int i) {
        this.mFilterType = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLevel(float f) {
        this.mLevel = f;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setValue(String str) {
        this.mValue = str;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mName", this.mName);
            jSONObject.put("mValue", this.mValue);
            jSONObject.put("mLevel", this.mLevel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}

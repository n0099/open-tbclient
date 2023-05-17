package com.baidu.ugc.editvideo.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ImageQualityData {
    public boolean isOpen;
    public boolean needDefog;
    public boolean needDenoise;

    public ImageQualityData() {
    }

    public ImageQualityData(boolean z, boolean z2, boolean z3) {
        this.isOpen = z;
        this.needDefog = z2;
        this.needDenoise = z3;
    }

    public static int isUseImageQuality(ImageQualityData imageQualityData) {
        return isValidStatus(imageQualityData) ? 1 : 0;
    }

    public static boolean isValidStatus(ImageQualityData imageQualityData) {
        return imageQualityData != null && imageQualityData.isOpen && (imageQualityData.needDefog || imageQualityData.needDenoise);
    }

    public static ImageQualityData parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ImageQualityData imageQualityData = new ImageQualityData();
        try {
            JSONObject jSONObject = new JSONObject(str);
            imageQualityData.isOpen = jSONObject.optBoolean("isOpen", false);
            imageQualityData.needDefog = jSONObject.optBoolean("needDefog", false);
            imageQualityData.needDenoise = jSONObject.optBoolean("needDenoise", false);
            return imageQualityData;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String toJson(ImageQualityData imageQualityData) {
        if (imageQualityData == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isOpen", imageQualityData.isOpen);
            jSONObject.put("needDefog", imageQualityData.needDefog);
            jSONObject.put("needDenoise", imageQualityData.needDenoise);
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}

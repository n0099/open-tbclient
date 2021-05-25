package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TbCdnIpListData {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<String>> f17663e;

    /* renamed from: a  reason: collision with root package name */
    public int f17659a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f17660b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f17661c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f17662d = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f17664f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f17665g = null;

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.f17659a = optJSONObject.optInt("errorno");
                this.f17660b = optJSONObject.optString("errmsg");
            }
            if (1 == jSONObject.optInt("cdn_switch")) {
                this.f17664f = true;
            } else {
                this.f17664f = false;
            }
            this.f17665g = jSONObject.optString("cdn_domain");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
            if (optJSONObject2 != null) {
                this.f17661c = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                this.f17662d = optJSONObject2.optString("img_md5");
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("ip")) != null) {
                        int length2 = optJSONArray.length();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < length2; i3++) {
                            String string = optJSONArray.getString(i3);
                            if (string != null && string.length() > 0) {
                                arrayList2.add(string);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            arrayList.add(arrayList2);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.f17663e = arrayList;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

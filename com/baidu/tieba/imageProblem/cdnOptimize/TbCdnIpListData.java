package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TbCdnIpListData {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ArrayList<String>> f18407e;

    /* renamed from: a  reason: collision with root package name */
    public int f18403a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f18404b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f18405c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f18406d = null;

    /* renamed from: f  reason: collision with root package name */
    public boolean f18408f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f18409g = null;

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("error");
            if (optJSONObject != null) {
                this.f18403a = optJSONObject.optInt("errorno");
                this.f18404b = optJSONObject.optString("errmsg");
            }
            if (1 == jSONObject.optInt("cdn_switch")) {
                this.f18408f = true;
            } else {
                this.f18408f = false;
            }
            this.f18409g = jSONObject.optString("cdn_domain");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
            if (optJSONObject2 != null) {
                this.f18405c = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                this.f18406d = optJSONObject2.optString("img_md5");
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
            if (optJSONArray2 != null) {
                int length = optJSONArray2.length();
                ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                    if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray("ip")) != null) {
                        int length2 = optJSONArray.length();
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        for (int i2 = 0; i2 < length2; i2++) {
                            String string = optJSONArray.getString(i2);
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
                    this.f18407e = arrayList;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

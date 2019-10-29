package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TbCdnIpListData {
    public ArrayList<ArrayList<String>> hah;
    public int haf = 0;
    public String errorString = null;
    public String imageUrl = null;
    public String hag = null;
    boolean hai = false;
    public String haj = null;

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
                if (optJSONObject != null) {
                    this.haf = optJSONObject.optInt("errorno");
                    this.errorString = optJSONObject.optString("errmsg");
                }
                if (1 == jSONObject.optInt("cdn_switch")) {
                    this.hai = true;
                } else {
                    this.hai = false;
                }
                this.haj = jSONObject.optString("cdn_domain");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
                if (optJSONObject2 != null) {
                    this.imageUrl = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                    this.hag = optJSONObject2.optString("img_md5");
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("ip_list");
                if (optJSONArray2 != null) {
                    int length = optJSONArray2.length();
                    ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i);
                        if (jSONObject2 != null && (optJSONArray = jSONObject2.optJSONArray(TableDefine.UserInfoColumns.COLUMN_IP)) != null) {
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
                        this.hah = arrayList;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

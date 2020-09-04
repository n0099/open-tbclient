package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class TbCdnIpListData {
    public ArrayList<ArrayList<String>> jJR;
    public int jJP = 0;
    public String errorString = null;
    public String imageUrl = null;
    public String jJQ = null;
    boolean jJS = false;
    public String jJT = null;

    public void parseJson(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
                if (optJSONObject != null) {
                    this.jJP = optJSONObject.optInt("errorno");
                    this.errorString = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
                }
                if (1 == jSONObject.optInt("cdn_switch")) {
                    this.jJS = true;
                } else {
                    this.jJS = false;
                }
                this.jJT = jSONObject.optString("cdn_domain");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("cdn_img_info");
                if (optJSONObject2 != null) {
                    this.imageUrl = optJSONObject2.optString(BigdayActivityConfig.IMG_URL);
                    this.jJQ = optJSONObject2.optString("img_md5");
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
                        this.jJR = arrayList;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

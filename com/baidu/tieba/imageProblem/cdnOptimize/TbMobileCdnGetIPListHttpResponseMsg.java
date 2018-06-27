package com.baidu.tieba.imageProblem.cdnOptimize;

import android.support.v4.app.NotificationCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TbMobileCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public TBCdnMobileListData mobileCdnData;

    /* loaded from: classes2.dex */
    public static class TBCdnMobileListData {
        public String eHl = null;
        public String eHm = null;
        public ArrayList<String> mobileIpList = new ArrayList<>();
    }

    public TbMobileCdnGetIPListHttpResponseMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1) == 0) {
                    if (this.mobileCdnData == null) {
                        this.mobileCdnData = new TBCdnMobileListData();
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("vips");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        for (int i2 = 0; i2 < optJSONArray.length() && this.mobileCdnData.mobileIpList.size() <= 5; i2++) {
                            String string = optJSONArray.getString(i2);
                            if (string != null) {
                                this.mobileCdnData.mobileIpList.add(string);
                            }
                        }
                    }
                    this.mobileCdnData.eHl = optJSONObject.optString("testimg_url");
                    this.mobileCdnData.eHm = optJSONObject.optString("testimg_md5");
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}

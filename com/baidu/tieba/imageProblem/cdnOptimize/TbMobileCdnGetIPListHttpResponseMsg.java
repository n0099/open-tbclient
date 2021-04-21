package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TbMobileCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public TBCdnMobileListData mobileCdnData;

    /* loaded from: classes4.dex */
    public static class TBCdnMobileListData {

        /* renamed from: a  reason: collision with root package name */
        public String f18110a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f18111b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f18112c = new ArrayList<>();
    }

    public TbMobileCdnGetIPListHttpResponseMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.optInt("status", -1) != 0) {
                return;
            }
            if (this.mobileCdnData == null) {
                this.mobileCdnData = new TBCdnMobileListData();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = optJSONObject.optJSONArray("vips");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length() && this.mobileCdnData.f18112c.size() <= 5; i2++) {
                    String string = optJSONArray.getString(i2);
                    if (string != null) {
                        this.mobileCdnData.f18112c.add(string);
                    }
                }
            }
            this.mobileCdnData.f18110a = optJSONObject.optString("testimg_url");
            this.mobileCdnData.f18111b = optJSONObject.optString("testimg_md5");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}

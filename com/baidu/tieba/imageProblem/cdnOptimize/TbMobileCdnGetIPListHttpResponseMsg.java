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
        public String f17681a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f17682b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f17683c = new ArrayList<>();
    }

    public TbMobileCdnGetIPListHttpResponseMsg(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
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
                for (int i3 = 0; i3 < optJSONArray.length() && this.mobileCdnData.f17683c.size() <= 5; i3++) {
                    String string = optJSONArray.getString(i3);
                    if (string != null) {
                        this.mobileCdnData.f17683c.add(string);
                    }
                }
            }
            this.mobileCdnData.f17681a = optJSONObject.optString("testimg_url");
            this.mobileCdnData.f17682b = optJSONObject.optString("testimg_md5");
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}

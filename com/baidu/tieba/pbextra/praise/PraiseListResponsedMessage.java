package com.baidu.tieba.pbextra.praise;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.j0.e2.c.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PraiseListResponsedMessage extends JsonHttpResponsedMessage {
    public int mErrCode;
    public String mErrMsg;
    public int mTotalNum;
    public List<a> mZanItemDataList;

    public PraiseListResponsedMessage(int i2) {
        super(i2);
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mTotalNum = 0;
        this.mZanItemDataList = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString("error_msg");
            this.mTotalNum = jSONObject.optInt("num");
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                this.mZanItemDataList = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    this.mZanItemDataList.add(new a(jSONObject2.optString("id"), jSONObject2.optString("name"), jSONObject2.optString("portrait"), jSONObject2.optString("name_show"), 1000 * jSONObject2.optLong("zan_time")));
                }
            }
        }
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public List<a> getmZanItemDataList() {
        return this.mZanItemDataList;
    }
}

package com.baidu.tieba.pb.pb.praise;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PraiseListResponsedMessage extends JsonHttpResponsedMessage {
    private int mErrCode;
    private String mErrMsg;
    private int mTotalNum;
    private List<a> mZanItemDataList;

    public PraiseListResponsedMessage(int i) {
        super(i);
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mTotalNum = 0;
        this.mZanItemDataList = null;
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }

    public List<a> getmZanItemDataList() {
        return this.mZanItemDataList;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
            this.mErrMsg = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
            this.mTotalNum = jSONObject.optInt("num");
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                this.mZanItemDataList = new ArrayList();
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        this.mZanItemDataList.add(new a(jSONObject2.optString("id"), jSONObject2.optString("name"), jSONObject2.optString(IntentConfig.PORTRAIT), jSONObject2.optString(IntentConfig.NAME_SHOW), jSONObject2.optLong("zan_time") * 1000));
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}

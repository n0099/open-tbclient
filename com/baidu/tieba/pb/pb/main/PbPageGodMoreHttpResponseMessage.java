package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbPageGodMoreHttpResponseMessage extends JsonHttpResponsedMessage {
    public List<PostData> mDatas;
    private int mErrCode;
    private String mErrMsg;

    public PbPageGodMoreHttpResponseMessage(int i) {
        super(i);
        this.mErrCode = 0;
        this.mErrMsg = "";
        this.mDatas = new ArrayList();
    }

    public int getErrCode() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public List<PostData> getData() {
        return this.mDatas;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONArray optJSONArray;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("errno");
            this.mErrMsg = jSONObject.optString("errmsg");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("post_list")) != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    PostData postData = new PostData();
                    postData.parserJson(optJSONArray.optJSONObject(i2));
                    this.mDatas.add(postData);
                }
            }
        }
    }
}

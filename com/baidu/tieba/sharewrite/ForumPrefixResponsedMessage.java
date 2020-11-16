package com.baidu.tieba.sharewrite;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class ForumPrefixResponsedMessage extends JsonHttpResponsedMessage {
    private PostPrefixData data;
    private boolean hasPostpre;

    public ForumPrefixResponsedMessage(int i) {
        super(i);
        this.data = new PostPrefixData();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            if (jSONObject.getInt("has_postpre") == 1) {
                this.hasPostpre = true;
                this.data.parserJson(jSONObject.optJSONObject("post_prefix"));
                return;
            }
            this.hasPostpre = false;
        }
    }

    public PostPrefixData getData() {
        return this.data;
    }

    public boolean isHasPostpre() {
        return this.hasPostpre;
    }
}

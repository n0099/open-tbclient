package com.baidu.tieba.imMessageCenter;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.coreExtra.relationship.a;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ResponseFriendListMessage extends JsonHttpResponsedMessage {
    private LinkedList<a> friendList;

    public ResponseFriendListMessage(int i) {
        super(1003004);
        this.friendList = new LinkedList<>();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        MetaData metaData = new MetaData();
                        metaData.parserJson(optJSONArray.getJSONObject(i2));
                        if (!TextUtils.isEmpty(metaData.getName_show())) {
                            a aVar = new a();
                            aVar.setUserName(metaData.getUserName());
                            aVar.xu(metaData.getName_show());
                            aVar.eo(metaData.getPortrait());
                            aVar.setUserId(metaData.getUserIdLong());
                            this.friendList.add(aVar);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public LinkedList<a> getFriendList() {
        return this.friendList;
    }
}

package com.baidu.tieba.imMessageCenter;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.s.f.a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseFriendListMessage extends JsonHttpResponsedMessage {
    public LinkedList<a> friendList;

    public ResponseFriendListMessage(int i2) {
        super(CmdConfigHttp.CMD_GET_FRIEND_LIST);
        this.friendList = new LinkedList<>();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    MetaData metaData = new MetaData();
                    metaData.parserJson(optJSONArray.getJSONObject(i3));
                    if (!TextUtils.isEmpty(metaData.getName_show())) {
                        a aVar = new a();
                        aVar.o(metaData.getUserName());
                        aVar.p(metaData.getName_show());
                        aVar.q(metaData.getPortrait());
                        aVar.n(metaData.getUserIdLong());
                        this.friendList.add(aVar);
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public LinkedList<a> getFriendList() {
        return this.friendList;
    }
}

package com.baidu.tieba.personPolymeric.mode.message;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class UserReportHttpResponseMessage extends JsonHttpResponsedMessage {
    public UserReportHttpResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            setError(-1);
            setErrorString(TbadkCoreApplication.getInst().getApp().getString(e.j.error_unkown_try_again));
        }
    }
}

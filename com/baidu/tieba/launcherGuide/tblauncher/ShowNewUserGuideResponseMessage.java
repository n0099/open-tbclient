package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShowNewUserGuideResponseMessage extends JsonHttpResponsedMessage {
    public int isJump;

    public ShowNewUserGuideResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (i2 == 1001520 && jSONObject != null) {
            if (getError() == 0) {
                try {
                    this.isJump = jSONObject.optInt("is_jump", 0);
                    return;
                } catch (Exception unused) {
                    this.isJump = 0;
                    return;
                }
            }
            this.isJump = 0;
            return;
        }
        this.isJump = 0;
    }
}

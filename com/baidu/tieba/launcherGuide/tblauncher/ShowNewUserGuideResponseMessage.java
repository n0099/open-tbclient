package com.baidu.tieba.launcherGuide.tblauncher;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShowNewUserGuideResponseMessage extends JsonHttpResponsedMessage {
    public int isJump;

    public ShowNewUserGuideResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (i != 1001520 || jSONObject == null) {
            this.isJump = 0;
        } else if (getError() == 0) {
            try {
                this.isJump = jSONObject.optInt("is_jump", 0);
            } catch (Exception e) {
                this.isJump = 0;
            }
        } else {
            this.isJump = 0;
        }
    }
}

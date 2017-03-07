package com.baidu.tieba.imMessageCenter.im.chat;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ PersonalChatActivity diK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PersonalChatActivity personalChatActivity, int i) {
        super(i);
        this.diK = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        PersonalMsglistModel personalMsglistModel;
        PersonalChatView personalChatView;
        PersonalMsglistModel personalMsglistModel2;
        PersonalMsglistModel personalMsglistModel3;
        PersonalChatView personalChatView2;
        PersonalChatView personalChatView3;
        PersonalMsglistModel personalMsglistModel4;
        PersonalChatView personalChatView4;
        PersonalMsglistModel personalMsglistModel5;
        PersonalMsglistModel personalMsglistModel6;
        PersonalChatView personalChatView5;
        PersonalChatView personalChatView6;
        PersonalMsglistModel personalMsglistModel7;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                String content = p.getContent();
                if (!TextUtils.isEmpty(content)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            long optLong = optJSONObject.optLong("user_id");
                            personalMsglistModel = this.diK.diD;
                            if (optLong == com.baidu.adp.lib.g.b.c(personalMsglistModel.getUser().getUserId(), 0L)) {
                                String optString = optJSONObject.optString("message");
                                if (cmd.equals("apply_new_friend")) {
                                    personalChatView6 = this.diK.diE;
                                    personalChatView6.a(PersonalMsglistModel.CardStatus.AGREE, true, optString);
                                    personalMsglistModel7 = this.diK.diD;
                                    personalMsglistModel7.a(PersonalMsglistModel.CardStatus.AGREE);
                                } else if (cmd.equals("passed_new_friend")) {
                                    personalChatView4 = this.diK.diE;
                                    personalChatView4.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    personalMsglistModel5 = this.diK.diD;
                                    personalMsglistModel5.a(PersonalMsglistModel.CardStatus.PASS);
                                    personalMsglistModel6 = this.diK.diD;
                                    personalMsglistModel6.setIsFriend(1);
                                    personalChatView5 = this.diK.diE;
                                    personalChatView5.getBtnGroupInfo().setVisibility(0);
                                } else if (cmd.equals("apply_add_friend")) {
                                    personalChatView3 = this.diK.diE;
                                    personalChatView3.a(PersonalMsglistModel.CardStatus.WAIT, true, new String[0]);
                                    personalMsglistModel4 = this.diK.diD;
                                    personalMsglistModel4.a(PersonalMsglistModel.CardStatus.WAIT);
                                } else if (cmd.equals("apply_pass_friend")) {
                                    personalChatView = this.diK.diE;
                                    personalChatView.a(PersonalMsglistModel.CardStatus.PASS, true, new String[0]);
                                    personalMsglistModel2 = this.diK.diD;
                                    personalMsglistModel2.a(PersonalMsglistModel.CardStatus.PASS);
                                    personalMsglistModel3 = this.diK.diD;
                                    personalMsglistModel3.setIsFriend(1);
                                    personalChatView2 = this.diK.diE;
                                    personalChatView2.getBtnGroupInfo().setVisibility(0);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        BdLog.i(e.getMessage());
                    }
                }
            }
        }
    }
}

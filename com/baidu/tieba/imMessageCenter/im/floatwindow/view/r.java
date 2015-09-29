package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
class r extends CustomMessageListener {
    final /* synthetic */ FloatingPersonalChatActivity bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(FloatingPersonalChatActivity floatingPersonalChatActivity, int i) {
        super(i);
        this.bMm = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GroupNewsPojo p;
        FloatingPersonalChatView floatingPersonalChatView;
        FloatingPersonalChatView floatingPersonalChatView2;
        FloatingPersonalChatView floatingPersonalChatView3;
        FloatingPersonalChatView floatingPersonalChatView4;
        if (customResponsedMessage != null && (customResponsedMessage instanceof PushMessage) && (p = ((PushMessage) customResponsedMessage).getP()) != null) {
            String cmd = p.getCmd();
            if (!TextUtils.isEmpty(cmd)) {
                String content = p.getContent();
                if (!TextUtils.isEmpty(content)) {
                    try {
                        JSONObject optJSONObject = new JSONObject(content).optJSONObject("eventParam");
                        if (optJSONObject != null) {
                            long optLong = optJSONObject.optLong("user_id");
                            if (optLong != 0) {
                                if (!cmd.equals("apply_new_friend")) {
                                    if (!cmd.equals("passed_new_friend")) {
                                        if (!cmd.equals("apply_reply_message")) {
                                            if (!cmd.equals("apply_add_friend")) {
                                                if (!cmd.equals("apply_pass_friend")) {
                                                    return;
                                                }
                                                floatingPersonalChatView = this.bMm.bMk;
                                                floatingPersonalChatView.c(optLong, 3);
                                                return;
                                            }
                                            floatingPersonalChatView2 = this.bMm.bMk;
                                            floatingPersonalChatView2.c(optLong, 2);
                                            return;
                                        }
                                        return;
                                    }
                                    floatingPersonalChatView3 = this.bMm.bMk;
                                    floatingPersonalChatView3.c(optLong, 3);
                                    return;
                                }
                                floatingPersonalChatView4 = this.bMm.bMk;
                                floatingPersonalChatView4.c(optLong, 4);
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

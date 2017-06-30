package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity dtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.dtk = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        CustomMessageListener customMessageListener3;
        CustomMessageListener customMessageListener4;
        com.baidu.tbadk.coreExtra.relationship.a item = this.dtk.dtf.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Av = item.Av();
            i2 = this.dtk.dte;
            if (i2 != 0) {
                i3 = this.dtk.dte;
                if (i3 == 1) {
                    customMessageListener = this.dtk.dth;
                    if (customMessageListener == null) {
                        this.dtk.dth = new e(this, CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, userId, userName, Av);
                        SelectFriendActivity selectFriendActivity = this.dtk;
                        customMessageListener2 = this.dtk.dth;
                        selectFriendActivity.registerListener(customMessageListener2);
                    }
                    this.dtk.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA));
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, Av);
                this.dtk.setResult(-1, intent);
                this.dtk.finish();
                return;
            }
            customMessageListener3 = this.dtk.dtg;
            if (customMessageListener3 == null) {
                this.dtk.dtg = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Av);
                SelectFriendActivity selectFriendActivity2 = this.dtk;
                customMessageListener4 = this.dtk.dtg;
                selectFriendActivity2.registerListener(customMessageListener4);
            }
            this.dtk.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
        }
    }
}

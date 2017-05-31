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
    final /* synthetic */ SelectFriendActivity dlo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.dlo = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        int i3;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        CustomMessageListener customMessageListener3;
        CustomMessageListener customMessageListener4;
        com.baidu.tbadk.coreExtra.relationship.a item = this.dlo.dlj.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Aa = item.Aa();
            i2 = this.dlo.dli;
            if (i2 != 0) {
                i3 = this.dlo.dli;
                if (i3 == 1) {
                    customMessageListener = this.dlo.dll;
                    if (customMessageListener == null) {
                        this.dlo.dll = new e(this, CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA, userId, userName, Aa);
                        SelectFriendActivity selectFriendActivity = this.dlo;
                        customMessageListener2 = this.dlo.dll;
                        selectFriendActivity.registerListener(customMessageListener2);
                    }
                    this.dlo.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_DISCOVER_DATA));
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
                intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, Aa);
                this.dlo.setResult(-1, intent);
                this.dlo.finish();
                return;
            }
            customMessageListener3 = this.dlo.dlk;
            if (customMessageListener3 == null) {
                this.dlo.dlk = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Aa);
                SelectFriendActivity selectFriendActivity2 = this.dlo;
                customMessageListener4 = this.dlo.dlk;
                selectFriendActivity2.registerListener(customMessageListener4);
            }
            this.dlo.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
        }
    }
}

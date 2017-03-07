package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity dkZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.dkZ = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.dkZ.dkV.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Ax = item.Ax();
            i2 = this.dkZ.dkU;
            if (i2 == 0) {
                customMessageListener = this.dkZ.dkW;
                if (customMessageListener == null) {
                    this.dkZ.dkW = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Ax);
                    SelectFriendActivity selectFriendActivity = this.dkZ;
                    customMessageListener2 = this.dkZ.dkW;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.dkZ.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, Ax);
            this.dkZ.setResult(-1, intent);
            this.dkZ.finish();
        }
    }
}

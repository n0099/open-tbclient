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
    final /* synthetic */ SelectFriendActivity diG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.diG = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.diG.diD.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Ag = item.Ag();
            i2 = this.diG.diC;
            if (i2 == 0) {
                customMessageListener = this.diG.diE;
                if (customMessageListener == null) {
                    this.diG.diE = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Ag);
                    SelectFriendActivity selectFriendActivity = this.diG;
                    customMessageListener2 = this.diG.diE;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.diG.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, Ag);
            this.diG.setResult(-1, intent);
            this.diG.finish();
        }
    }
}

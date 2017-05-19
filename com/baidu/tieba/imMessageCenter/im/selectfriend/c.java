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
    final /* synthetic */ SelectFriendActivity dfT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.dfT = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.dfT.dfP.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Ah = item.Ah();
            i2 = this.dfT.dfO;
            if (i2 == 0) {
                customMessageListener = this.dfT.dfQ;
                if (customMessageListener == null) {
                    this.dfT.dfQ = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Ah);
                    SelectFriendActivity selectFriendActivity = this.dfT;
                    customMessageListener2 = this.dfT.dfQ;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.dfT.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_ID, userId);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_NAME, userName);
            intent.putExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT, Ah);
            this.dfT.setResult(-1, intent);
            this.dfT.finish();
        }
    }
}

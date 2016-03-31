package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity cwB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.cwB = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.cwB.cwy.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String userPortrait = item.getUserPortrait();
            i2 = this.cwB.cwx;
            if (i2 == 0) {
                customMessageListener = this.cwB.cwz;
                if (customMessageListener == null) {
                    this.cwB.cwz = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, userPortrait);
                    SelectFriendActivity selectFriendActivity = this.cwB;
                    customMessageListener2 = this.cwB.cwz;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.cwB.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_user_id", userId);
            intent.putExtra("key_user_name", userName);
            intent.putExtra("key_user_portait", userPortrait);
            this.cwB.setResult(-1, intent);
            this.cwB.finish();
        }
    }
}

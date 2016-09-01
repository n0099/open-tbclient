package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity drx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.drx = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.drx.dru.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String Ao = item.Ao();
            i2 = this.drx.drt;
            if (i2 == 0) {
                customMessageListener = this.drx.drv;
                if (customMessageListener == null) {
                    this.drx.drv = new d(this, CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA, userId, userName, Ao);
                    SelectFriendActivity selectFriendActivity = this.drx;
                    customMessageListener2 = this.drx.drv;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.drx.sendMessage(new CustomMessage(CmdConfigCustom.CMD_GET_SHARE_FROM_GAME_CENTER_DATA));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_user_id", userId);
            intent.putExtra("key_user_name", userName);
            intent.putExtra("key_user_portait", Ao);
            this.drx.setResult(-1, intent);
            this.drx.finish();
        }
    }
}

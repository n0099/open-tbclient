package com.baidu.tieba.imMessageCenter.im.selectfriend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class c implements AdapterView.OnItemClickListener {
    final /* synthetic */ SelectFriendActivity bte;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SelectFriendActivity selectFriendActivity) {
        this.bte = selectFriendActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int i2;
        CustomMessageListener customMessageListener;
        CustomMessageListener customMessageListener2;
        com.baidu.tbadk.coreExtra.relationship.a item = this.bte.btb.getItem(i);
        if (item != null) {
            long userId = item.getUserId();
            String userName = item.getUserName();
            String userPortrait = item.getUserPortrait();
            i2 = this.bte.bta;
            if (i2 == 0) {
                customMessageListener = this.bte.btc;
                if (customMessageListener == null) {
                    this.bte.btc = new d(this, 2001268, userId, userName, userPortrait);
                    SelectFriendActivity selectFriendActivity = this.bte;
                    customMessageListener2 = this.bte.btc;
                    selectFriendActivity.registerListener(customMessageListener2);
                }
                this.bte.sendMessage(new CustomMessage(2001268));
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_user_id", userId);
            intent.putExtra("key_user_name", userName);
            intent.putExtra("key_user_portait", userPortrait);
            this.bte.setResult(-1, intent);
            this.bte.finish();
        }
    }
}

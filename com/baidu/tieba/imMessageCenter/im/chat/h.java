package com.baidu.tieba.imMessageCenter.im.chat;

import android.location.Address;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
/* loaded from: classes.dex */
class h implements com.baidu.adp.lib.d.d {
    final /* synthetic */ PersonalChatActivity boY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalChatActivity personalChatActivity) {
        this.boY = personalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.boY.mListModel;
            UserData user = ((PersonalMsglistModel) msglistModel).getUser();
            if (user != null) {
                this.boY.mUser = user;
                this.boY.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}

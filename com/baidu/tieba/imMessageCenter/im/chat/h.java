package com.baidu.tieba.imMessageCenter.im.chat;

import android.location.Address;
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class h implements a.InterfaceC0005a {
    final /* synthetic */ PersonalChatActivity dui;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PersonalChatActivity personalChatActivity) {
        this.dui = personalChatActivity;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0005a
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.dui.dbq;
            UserData user = ((PersonalMsglistModel) msglistModel).getUser();
            if (user != null) {
                this.dui.mUser = user;
                this.dui.sendMessage(new RequestPersonalLbsInfoMessage(205101, user.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}

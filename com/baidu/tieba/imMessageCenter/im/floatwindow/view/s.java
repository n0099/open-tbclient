package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.location.Address;
import com.baidu.adp.lib.e.a;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class s implements a.InterfaceC0005a {
    final /* synthetic */ FloatingPersonalChatActivity dwY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.dwY = floatingPersonalChatActivity;
    }

    @Override // com.baidu.adp.lib.e.a.InterfaceC0005a
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        UserData userData;
        MsglistModel msglistModel2;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.dwY.dbq;
            if (msglistModel instanceof PersonalMsglistModel) {
                msglistModel2 = this.dwY.dbq;
                userData = ((PersonalMsglistModel) msglistModel2).getUser();
            } else {
                userData = null;
            }
            if (userData != null) {
                this.dwY.mUser = userData;
                this.dwY.sendMessage(new RequestPersonalLbsInfoMessage(205101, userData.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}

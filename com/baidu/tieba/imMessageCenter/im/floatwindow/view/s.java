package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.location.Address;
import com.baidu.adp.lib.d.a;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class s implements a.InterfaceC0003a {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.bMS = floatingPersonalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.a.InterfaceC0003a
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        UserData userData;
        MsglistModel msglistModel2;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.bMS.mListModel;
            if (msglistModel instanceof PersonalMsglistModel) {
                msglistModel2 = this.bMS.mListModel;
                userData = ((PersonalMsglistModel) msglistModel2).getUser();
            } else {
                userData = null;
            }
            if (userData != null) {
                this.bMS.mUser = userData;
                this.bMS.sendMessage(new RequestPersonalLbsInfoMessage(205101, userData.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}

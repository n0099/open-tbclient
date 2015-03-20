package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.location.Address;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.RequestPersonalLbsInfoMessage;
/* loaded from: classes.dex */
class u implements com.baidu.adp.lib.d.d {
    final /* synthetic */ FloatingPersonalChatActivity brH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FloatingPersonalChatActivity floatingPersonalChatActivity) {
        this.brH = floatingPersonalChatActivity;
    }

    @Override // com.baidu.adp.lib.d.d
    public void b(int i, String str, Address address) {
        MsglistModel msglistModel;
        UserData userData;
        MsglistModel msglistModel2;
        if (i == 0 && address != null) {
            String valueOf = String.valueOf(address.getLatitude());
            String valueOf2 = String.valueOf(address.getLongitude());
            msglistModel = this.brH.mListModel;
            if (msglistModel instanceof PersonalMsglistModel) {
                msglistModel2 = this.brH.mListModel;
                userData = ((PersonalMsglistModel) msglistModel2).getUser();
            } else {
                userData = null;
            }
            if (userData != null) {
                this.brH.mUser = userData;
                this.brH.sendMessage(new RequestPersonalLbsInfoMessage(205101, userData.getUserIdLong(), valueOf, valueOf2));
            }
        }
    }
}

package com.baidu.tieba.setting.usermutelist;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.setting.usermutelist.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.UserMuteQuery.MuteUser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ m cOQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(m mVar, int i, int i2) {
        super(i, i2);
        this.cOQ = mVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        m.a aVar;
        m.a aVar2;
        if (responsedMessage instanceof UserMuteQuerySocketResponsedMessage) {
            UserMuteQuerySocketResponsedMessage userMuteQuerySocketResponsedMessage = (UserMuteQuerySocketResponsedMessage) responsedMessage;
            if (userMuteQuerySocketResponsedMessage.getResult() != null) {
                List<MuteUser> list = userMuteQuerySocketResponsedMessage.getResult().mute_user;
                ArrayList<MuteUser> arrayList = new ArrayList<>();
                if (list != null) {
                    arrayList.addAll(list);
                }
                aVar2 = this.cOQ.cOC;
                aVar2.a(arrayList, userMuteQuerySocketResponsedMessage.getError(), userMuteQuerySocketResponsedMessage.getErrorString());
            } else {
                return;
            }
        }
        if (responsedMessage instanceof UserMuteQueryHttpResponsedMessage) {
            UserMuteQueryHttpResponsedMessage userMuteQueryHttpResponsedMessage = (UserMuteQueryHttpResponsedMessage) responsedMessage;
            if (userMuteQueryHttpResponsedMessage.getResult() != null) {
                List<MuteUser> list2 = userMuteQueryHttpResponsedMessage.getResult().mute_user;
                ArrayList<MuteUser> arrayList2 = new ArrayList<>();
                if (list2 != null) {
                    for (MuteUser muteUser : list2) {
                        arrayList2.add(muteUser);
                    }
                }
                aVar = this.cOQ.cOC;
                aVar.a(arrayList2, userMuteQueryHttpResponsedMessage.getError(), userMuteQueryHttpResponsedMessage.getErrorString());
            }
        }
    }
}

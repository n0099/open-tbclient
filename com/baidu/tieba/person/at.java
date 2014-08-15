package com.baidu.tieba.person;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ as a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.a = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PersonCenterListTopData personCenterListTopData;
        PersonCenterListTopData personCenterListTopData2;
        PersonCenterListTopData personCenterListTopData3;
        PersonCenterListTopData personCenterListTopData4;
        PersonCenterListTopData personCenterListTopData5;
        PersonCenterListTopData personCenterListTopData6;
        Context context;
        Context context2;
        PersonCenterListTopData personCenterListTopData7;
        PersonCenterListTopData personCenterListTopData8;
        PersonCenterListTopData personCenterListTopData9;
        PersonCenterListTopData personCenterListTopData10;
        PersonCenterListTopData personCenterListTopData11;
        BaseFragmentActivity baseFragmentActivity;
        PersonCenterListTopData personCenterListTopData12;
        PersonCenterListTopData personCenterListTopData13;
        PersonCenterListTopData personCenterListTopData14;
        PersonCenterListTopData personCenterListTopData15;
        PersonCenterListTopData personCenterListTopData16;
        PersonCenterListTopData personCenterListTopData17;
        if (view.getId() == com.baidu.tieba.u.topbuttonview_content) {
            personCenterListTopData2 = this.a.d;
            if (personCenterListTopData2.getmDataType() == 1) {
                personCenterListTopData8 = this.a.d;
                if (personCenterListTopData8 != null) {
                    personCenterListTopData9 = this.a.d;
                    if (personCenterListTopData9.getmModel() != null) {
                        personCenterListTopData10 = this.a.d;
                        if (personCenterListTopData10.getmModel().k() != null) {
                            personCenterListTopData11 = this.a.d;
                            if (personCenterListTopData11.getmModel().a() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                baseFragmentActivity = this.a.b;
                                personCenterListTopData12 = this.a.d;
                                String userId = personCenterListTopData12.getmModel().k().getUserId();
                                personCenterListTopData13 = this.a.d;
                                String name_show = personCenterListTopData13.getmModel().k().getName_show();
                                personCenterListTopData14 = this.a.d;
                                String portrait = personCenterListTopData14.getmModel().k().getPortrait();
                                personCenterListTopData15 = this.a.d;
                                String r = personCenterListTopData15.getmModel().r();
                                personCenterListTopData16 = this.a.d;
                                boolean z = personCenterListTopData16.getmModel().a().e;
                                personCenterListTopData17 = this.a.d;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(baseFragmentActivity, userId, name_show, portrait, r, z, personCenterListTopData17.getmModel().d())));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            personCenterListTopData3 = this.a.d;
            if (personCenterListTopData3.getmDataType() == 2) {
                personCenterListTopData6 = this.a.d;
                if (personCenterListTopData6.getmModel().k() != null) {
                    if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0) {
                        context = this.a.a;
                        context2 = this.a.a;
                        LoginActivity.a((Activity) context, context2.getResources().getString(com.baidu.tieba.x.login_to_chat), true, 11028);
                        return;
                    }
                    personCenterListTopData7 = this.a.d;
                    if (personCenterListTopData7.getmModel().j()) {
                        return;
                    }
                    this.a.b();
                    return;
                }
                return;
            }
            personCenterListTopData4 = this.a.d;
            if (personCenterListTopData4.getmDataType() == 3) {
                com.baidu.tbadk.newFriends.a a = com.baidu.tbadk.newFriends.a.a();
                personCenterListTopData5 = this.a.d;
                a.a(com.baidu.adp.lib.e.b.a(personCenterListTopData5.getmModel().i(), 0), "pers_pg");
            }
        } else if (view.getId() == com.baidu.tieba.u.topattention_content) {
            personCenterListTopData = this.a.d;
            personCenterListTopData.getmModel().l();
        }
    }
}

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
        Context context;
        Context context2;
        PersonCenterListTopData personCenterListTopData6;
        PersonCenterListTopData personCenterListTopData7;
        PersonCenterListTopData personCenterListTopData8;
        PersonCenterListTopData personCenterListTopData9;
        PersonCenterListTopData personCenterListTopData10;
        BaseFragmentActivity baseFragmentActivity;
        PersonCenterListTopData personCenterListTopData11;
        PersonCenterListTopData personCenterListTopData12;
        PersonCenterListTopData personCenterListTopData13;
        PersonCenterListTopData personCenterListTopData14;
        PersonCenterListTopData personCenterListTopData15;
        if (view.getId() == com.baidu.tieba.v.topbuttonview_content) {
            personCenterListTopData = this.a.d;
            if (personCenterListTopData.getmDataType() == 1) {
                personCenterListTopData7 = this.a.d;
                if (personCenterListTopData7 != null) {
                    personCenterListTopData8 = this.a.d;
                    if (personCenterListTopData8.getmModel() != null) {
                        personCenterListTopData9 = this.a.d;
                        if (personCenterListTopData9.getmModel().j() != null) {
                            personCenterListTopData10 = this.a.d;
                            if (personCenterListTopData10.getmModel().a() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                baseFragmentActivity = this.a.b;
                                personCenterListTopData11 = this.a.d;
                                String userId = personCenterListTopData11.getmModel().j().getUserId();
                                personCenterListTopData12 = this.a.d;
                                String name_show = personCenterListTopData12.getmModel().j().getName_show();
                                personCenterListTopData13 = this.a.d;
                                String portrait = personCenterListTopData13.getmModel().j().getPortrait();
                                personCenterListTopData14 = this.a.d;
                                String q = personCenterListTopData14.getmModel().q();
                                personCenterListTopData15 = this.a.d;
                                messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(baseFragmentActivity, userId, name_show, portrait, q, personCenterListTopData15.getmModel().a().e)));
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
            personCenterListTopData2 = this.a.d;
            if (personCenterListTopData2.getmDataType() == 2) {
                personCenterListTopData5 = this.a.d;
                if (personCenterListTopData5.getmModel().j() != null) {
                    if (TbadkApplication.getCurrentAccount() == null || TbadkApplication.getCurrentAccount().length() <= 0) {
                        context = this.a.a;
                        context2 = this.a.a;
                        LoginActivity.a((Activity) context, context2.getResources().getString(com.baidu.tieba.y.login_to_chat), true, 11028);
                        return;
                    }
                    personCenterListTopData6 = this.a.d;
                    if (personCenterListTopData6.getmModel().i()) {
                        return;
                    }
                    this.a.b();
                    return;
                }
                return;
            }
            personCenterListTopData3 = this.a.d;
            if (personCenterListTopData3.getmDataType() == 3) {
                com.baidu.tbadk.newFriends.a a = com.baidu.tbadk.newFriends.a.a();
                personCenterListTopData4 = this.a.d;
                a.b(com.baidu.adp.lib.f.b.a(personCenterListTopData4.getmModel().h(), 0), "pers_pg");
            }
        }
    }
}

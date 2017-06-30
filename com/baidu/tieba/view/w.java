package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    com.baidu.tieba.f.b gaS = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView gaT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PersonHeaderAttentionView personHeaderAttentionView) {
        this.gaT = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
        if (r0.getPersonPrivate().Cd() == 2) goto L35;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        UserData userData;
        Context context;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        UserData userData5;
        UserData userData6;
        UserData userData7;
        UserData userData8;
        r rVar;
        UserData userData9;
        r rVar2;
        userData = this.gaT.mUserData;
        if (userData != null && view != null) {
            context = this.gaT.mContext;
            if (bl.aN(context)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                userData2 = this.gaT.mUserData;
                boolean equals = currentAccount.equals(userData2.getUserId());
                userData3 = this.gaT.mUserData;
                boolean z = userData3.getIsFriend() == 1;
                int id = view.getId();
                if (w.h.person_header_attention_container == id) {
                    this.gaS.bVd = 4;
                } else if (w.h.person_header_fans_container == id) {
                    this.gaS.bVd = 5;
                } else if (w.h.person_header_bar_container == id) {
                    userData4 = this.gaT.mUserData;
                    if (userData4.getPersonPrivate() != null) {
                        userData5 = this.gaT.mUserData;
                        if (userData5.getPersonPrivate().Cd() != 1 && !equals) {
                            if (z) {
                                userData7 = this.gaT.mUserData;
                            }
                            PersonHeaderAttentionView personHeaderAttentionView = this.gaT;
                            userData6 = this.gaT.mUserData;
                            personHeaderAttentionView.tv(userData6.getSex());
                            return;
                        }
                        this.gaS.bVd = 7;
                    } else {
                        PersonHeaderAttentionView personHeaderAttentionView2 = this.gaT;
                        userData8 = this.gaT.mUserData;
                        personHeaderAttentionView2.tv(userData8.getSex());
                        return;
                    }
                }
                rVar = this.gaT.eRa;
                if (rVar != null) {
                    this.gaS.bVe = new Bundle();
                    Bundle bundle = this.gaS.bVe;
                    userData9 = this.gaT.mUserData;
                    bundle.putSerializable(UserData.TYPE_USER, userData9);
                    rVar2 = this.gaT.eRa;
                    rVar2.a(view, this.gaS);
                }
            }
        }
    }
}

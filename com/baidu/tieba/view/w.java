package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    com.baidu.tieba.f.b bxX = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView fQS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fQS = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
        if (r0.getPersonPrivate().BI() == 2) goto L35;
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
        userData = this.fQS.mUserData;
        if (userData != null && view != null) {
            context = this.fQS.mContext;
            if (bh.aN(context)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                userData2 = this.fQS.mUserData;
                boolean equals = currentAccount.equals(userData2.getUserId());
                userData3 = this.fQS.mUserData;
                boolean z = userData3.getIsFriend() == 1;
                int id = view.getId();
                if (w.h.person_header_attention_container == id) {
                    this.bxX.bOi = 4;
                } else if (w.h.person_header_fans_container == id) {
                    this.bxX.bOi = 5;
                } else if (w.h.person_header_bar_container == id) {
                    userData4 = this.fQS.mUserData;
                    if (userData4.getPersonPrivate() != null) {
                        userData5 = this.fQS.mUserData;
                        if (userData5.getPersonPrivate().BI() != 1 && !equals) {
                            if (z) {
                                userData7 = this.fQS.mUserData;
                            }
                            PersonHeaderAttentionView personHeaderAttentionView = this.fQS;
                            userData6 = this.fQS.mUserData;
                            personHeaderAttentionView.he(userData6.getSex());
                            return;
                        }
                        this.bxX.bOi = 7;
                    } else {
                        PersonHeaderAttentionView personHeaderAttentionView2 = this.fQS;
                        userData8 = this.fQS.mUserData;
                        personHeaderAttentionView2.he(userData8.getSex());
                        return;
                    }
                }
                rVar = this.fQS.bxW;
                if (rVar != null) {
                    this.bxX.bOj = new Bundle();
                    Bundle bundle = this.bxX.bOj;
                    userData9 = this.fQS.mUserData;
                    bundle.putSerializable(UserData.TYPE_USER, userData9);
                    rVar2 = this.fQS.bxW;
                    rVar2.a(view, this.bxX);
                }
            }
        }
    }
}

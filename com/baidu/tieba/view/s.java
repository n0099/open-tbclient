package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.e.b fYL = new com.baidu.tieba.e.b();
    final /* synthetic */ PersonHeaderAttentionView fYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fYM = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r0.getPersonPrivate().Cf() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (r0.getPersonPrivate().Cd() == 2) goto L44;
     */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onClick(View view) {
        UserData userData;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        UserData userData5;
        UserData userData6;
        UserData userData7;
        UserData userData8;
        UserData userData9;
        m mVar;
        UserData userData10;
        m mVar2;
        Context context;
        userData = this.fYM.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fYM.mContext;
                bm.ai(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fYM.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fYM.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (r.g.person_header_attention_container == id) {
                this.fYL.bJq = 4;
            } else if (r.g.person_header_fans_container == id) {
                this.fYL.bJq = 5;
            } else if (r.g.person_header_post_container == id) {
                userData7 = this.fYM.mUserData;
                if (userData7.getPersonPrivate().Cf() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fYM.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fYM;
                    userData8 = this.fYM.mUserData;
                    personHeaderAttentionView.hB(userData8.getSex());
                    return;
                }
                this.fYL.bJq = 6;
            } else if (r.g.person_header_bar_container == id) {
                userData4 = this.fYM.mUserData;
                if (userData4.getPersonPrivate().Cd() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fYM.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fYM;
                    userData5 = this.fYM.mUserData;
                    personHeaderAttentionView2.hB(userData5.getSex());
                    return;
                }
                this.fYL.bJq = 7;
            }
            mVar = this.fYM.eFl;
            if (mVar != null) {
                this.fYL.bJr = new Bundle();
                Bundle bundle = this.fYL.bJr;
                userData10 = this.fYM.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fYM.eFl;
                mVar2.a(view, this.fYL);
            }
        }
    }
}

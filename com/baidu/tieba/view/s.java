package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bk;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.e.b ggg = new com.baidu.tieba.e.b();
    final /* synthetic */ PersonHeaderAttentionView ggh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.ggh = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (r0.getPersonPrivate().Cl() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r0.getPersonPrivate().Cj() == 2) goto L44;
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
        userData = this.ggh.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.ggh.mContext;
                bk.ai(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.ggh.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.ggh.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (r.g.person_header_attention_container == id) {
                this.ggg.bMj = 4;
            } else if (r.g.person_header_fans_container == id) {
                this.ggg.bMj = 5;
            } else if (r.g.person_header_post_container == id) {
                userData7 = this.ggh.mUserData;
                if (userData7.getPersonPrivate().Cl() != 1 && !equals) {
                    if (z) {
                        userData9 = this.ggh.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.ggh;
                    userData8 = this.ggh.mUserData;
                    personHeaderAttentionView.hC(userData8.getSex());
                    return;
                }
                this.ggg.bMj = 6;
            } else if (r.g.person_header_bar_container == id) {
                userData4 = this.ggh.mUserData;
                if (userData4.getPersonPrivate().Cj() != 1 && !equals) {
                    if (z) {
                        userData6 = this.ggh.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.ggh;
                    userData5 = this.ggh.mUserData;
                    personHeaderAttentionView2.hC(userData5.getSex());
                    return;
                }
                this.ggg.bMj = 7;
            }
            mVar = this.ggh.eLK;
            if (mVar != null) {
                this.ggg.bMk = new Bundle();
                Bundle bundle = this.ggg.bMk;
                userData10 = this.ggh.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.ggh.eLK;
                mVar2.a(view, this.ggg);
            }
        }
    }
}

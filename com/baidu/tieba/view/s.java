package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.f.b fMy = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView fMz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fMz = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r0.getPersonPrivate().CK() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (r0.getPersonPrivate().CI() == 2) goto L44;
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
        userData = this.fMz.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fMz.mContext;
                bg.aI(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fMz.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fMz.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (w.h.person_header_attention_container == id) {
                this.fMy.bJo = 4;
            } else if (w.h.person_header_fans_container == id) {
                this.fMy.bJo = 5;
            } else if (w.h.person_header_post_container == id) {
                userData7 = this.fMz.mUserData;
                if (userData7.getPersonPrivate().CK() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fMz.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fMz;
                    userData8 = this.fMz.mUserData;
                    personHeaderAttentionView.hD(userData8.getSex());
                    return;
                }
                this.fMy.bJo = 6;
            } else if (w.h.person_header_bar_container == id) {
                userData4 = this.fMz.mUserData;
                if (userData4.getPersonPrivate().CI() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fMz.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fMz;
                    userData5 = this.fMz.mUserData;
                    personHeaderAttentionView2.hD(userData5.getSex());
                    return;
                }
                this.fMy.bJo = 7;
            }
            mVar = this.fMz.eCN;
            if (mVar != null) {
                this.fMy.bJp = new Bundle();
                Bundle bundle = this.fMy.bJp;
                userData10 = this.fMz.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fMz.eCN;
                mVar2.a(view, this.fMy);
            }
        }
    }
}

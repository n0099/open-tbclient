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
    com.baidu.tieba.f.b fIt = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView fIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fIu = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r0.getPersonPrivate().Cm() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (r0.getPersonPrivate().Ck() == 2) goto L44;
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
        userData = this.fIu.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fIu.mContext;
                bg.aG(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fIu.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fIu.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (w.h.person_header_attention_container == id) {
                this.fIt.bHe = 4;
            } else if (w.h.person_header_fans_container == id) {
                this.fIt.bHe = 5;
            } else if (w.h.person_header_post_container == id) {
                userData7 = this.fIu.mUserData;
                if (userData7.getPersonPrivate().Cm() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fIu.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fIu;
                    userData8 = this.fIu.mUserData;
                    personHeaderAttentionView.hu(userData8.getSex());
                    return;
                }
                this.fIt.bHe = 6;
            } else if (w.h.person_header_bar_container == id) {
                userData4 = this.fIu.mUserData;
                if (userData4.getPersonPrivate().Ck() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fIu.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fIu;
                    userData5 = this.fIu.mUserData;
                    personHeaderAttentionView2.hu(userData5.getSex());
                    return;
                }
                this.fIt.bHe = 7;
            }
            mVar = this.fIu.eCA;
            if (mVar != null) {
                this.fIt.bHf = new Bundle();
                Bundle bundle = this.fIt.bHf;
                userData10 = this.fIu.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fIu.eCA;
                mVar2.a(view, this.fIt);
            }
        }
    }
}

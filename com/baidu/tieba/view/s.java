package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.f.b fWG = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView fWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fWH = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (r0.getPersonPrivate().Cc() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r0.getPersonPrivate().Ca() == 2) goto L44;
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
        userData = this.fWH.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fWH.mContext;
                bn.aj(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fWH.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fWH.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (t.g.person_header_attention_container == id) {
                this.fWG.bJp = 4;
            } else if (t.g.person_header_fans_container == id) {
                this.fWG.bJp = 5;
            } else if (t.g.person_header_post_container == id) {
                userData7 = this.fWH.mUserData;
                if (userData7.getPersonPrivate().Cc() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fWH.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fWH;
                    userData8 = this.fWH.mUserData;
                    personHeaderAttentionView.hx(userData8.getSex());
                    return;
                }
                this.fWG.bJp = 6;
            } else if (t.g.person_header_bar_container == id) {
                userData4 = this.fWH.mUserData;
                if (userData4.getPersonPrivate().Ca() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fWH.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fWH;
                    userData5 = this.fWH.mUserData;
                    personHeaderAttentionView2.hx(userData5.getSex());
                    return;
                }
                this.fWG.bJp = 7;
            }
            mVar = this.fWH.eDi;
            if (mVar != null) {
                this.fWG.bJq = new Bundle();
                Bundle bundle = this.fWG.bJq;
                userData10 = this.fWH.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fWH.eDi;
                mVar2.a(view, this.fWG);
            }
        }
    }
}

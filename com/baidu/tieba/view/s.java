package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.g.b fDS = new com.baidu.tieba.g.b();
    final /* synthetic */ PersonHeaderAttentionView fDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fDT = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r0.getPersonPrivate().BT() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
        if (r0.getPersonPrivate().BR() == 2) goto L44;
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
        userData = this.fDT.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fDT.mContext;
                bf.ai(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fDT.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fDT.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (r.h.person_header_attention_container == id) {
                this.fDS.bzY = 4;
            } else if (r.h.person_header_fans_container == id) {
                this.fDS.bzY = 5;
            } else if (r.h.person_header_post_container == id) {
                userData7 = this.fDT.mUserData;
                if (userData7.getPersonPrivate().BT() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fDT.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fDT;
                    userData8 = this.fDT.mUserData;
                    personHeaderAttentionView.hy(userData8.getSex());
                    return;
                }
                this.fDS.bzY = 6;
            } else if (r.h.person_header_bar_container == id) {
                userData4 = this.fDT.mUserData;
                if (userData4.getPersonPrivate().BR() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fDT.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fDT;
                    userData5 = this.fDT.mUserData;
                    personHeaderAttentionView2.hy(userData5.getSex());
                    return;
                }
                this.fDS.bzY = 7;
            }
            mVar = this.fDT.ezb;
            if (mVar != null) {
                this.fDS.bzZ = new Bundle();
                Bundle bundle = this.fDS.bzZ;
                userData10 = this.fDT.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fDT.ezb;
                mVar2.a(view, this.fDS);
            }
        }
    }
}

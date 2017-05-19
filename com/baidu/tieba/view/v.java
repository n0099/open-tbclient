package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class v implements View.OnClickListener {
    com.baidu.tieba.f.b fJk = new com.baidu.tieba.f.b();
    final /* synthetic */ PersonHeaderAttentionView fJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fJl = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (r0.getPersonPrivate().BP() == 2) goto L33;
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
        p pVar;
        UserData userData7;
        p pVar2;
        Context context;
        userData = this.fJl.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fJl.mContext;
                bg.aL(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fJl.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fJl.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (w.h.person_header_attention_container == id) {
                this.fJk.bIu = 4;
            } else if (w.h.person_header_fans_container == id) {
                this.fJk.bIu = 5;
            } else if (w.h.person_header_bar_container == id) {
                userData4 = this.fJl.mUserData;
                if (userData4.getPersonPrivate().BP() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fJl.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fJl;
                    userData5 = this.fJl.mUserData;
                    personHeaderAttentionView.sG(userData5.getSex());
                    return;
                }
                this.fJk.bIu = 7;
            }
            pVar = this.fJl.eyy;
            if (pVar != null) {
                this.fJk.bIv = new Bundle();
                Bundle bundle = this.fJk.bIv;
                userData7 = this.fJl.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData7);
                pVar2 = this.fJl.eyy;
                pVar2.a(view, this.fJk);
            }
        }
    }
}

package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    com.baidu.tieba.e.b fuY = new com.baidu.tieba.e.b();
    final /* synthetic */ PersonHeaderAttentionView fuZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PersonHeaderAttentionView personHeaderAttentionView) {
        this.fuZ = personHeaderAttentionView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ab, code lost:
        if (r0.getPersonPrivate().BY() == 2) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ea, code lost:
        if (r0.getPersonPrivate().BW() == 2) goto L44;
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
        userData = this.fuZ.mUserData;
        if (userData != null && view != null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                context = this.fuZ.mContext;
                bh.ag(context);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            userData2 = this.fuZ.mUserData;
            boolean equals = currentAccount.equals(userData2.getUserId());
            userData3 = this.fuZ.mUserData;
            boolean z = userData3.getIsFriend() == 1;
            int id = view.getId();
            if (r.g.person_header_attention_container == id) {
                this.fuY.bsn = 4;
            } else if (r.g.person_header_fans_container == id) {
                this.fuY.bsn = 5;
            } else if (r.g.person_header_post_container == id) {
                userData7 = this.fuZ.mUserData;
                if (userData7.getPersonPrivate().BY() != 1 && !equals) {
                    if (z) {
                        userData9 = this.fuZ.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView = this.fuZ;
                    userData8 = this.fuZ.mUserData;
                    personHeaderAttentionView.gM(userData8.getSex());
                    return;
                }
                this.fuY.bsn = 6;
            } else if (r.g.person_header_bar_container == id) {
                userData4 = this.fuZ.mUserData;
                if (userData4.getPersonPrivate().BW() != 1 && !equals) {
                    if (z) {
                        userData6 = this.fuZ.mUserData;
                    }
                    PersonHeaderAttentionView personHeaderAttentionView2 = this.fuZ;
                    userData5 = this.fuZ.mUserData;
                    personHeaderAttentionView2.gM(userData5.getSex());
                    return;
                }
                this.fuY.bsn = 7;
            }
            mVar = this.fuZ.epg;
            if (mVar != null) {
                this.fuY.bso = new Bundle();
                Bundle bundle = this.fuY.bso;
                userData10 = this.fuZ.mUserData;
                bundle.putSerializable(UserData.TYPE_USER, userData10);
                mVar2 = this.fuZ.epg;
                mVar2.a(view, this.fuY);
            }
        }
    }
}

package com.baidu.tieba.personPolymeric.b;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {
    final /* synthetic */ as eLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(as asVar) {
        this.eLK = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.view.r rVar;
        UserData userData;
        com.baidu.tieba.view.r rVar2;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        UserData userData2;
        com.baidu.tbadk.coreExtra.c.a aVar;
        boolean z;
        UserData userData3;
        UserData userData4;
        UserData userData5;
        boolean isUseSingleGod;
        TbPageContext tbPageContext3;
        if (view != null) {
            if (view.getId() == w.h.attention_btn) {
                tbPageContext2 = this.eLK.aas;
                if (bh.aN(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11592"));
                    userData2 = this.eLK.mUserData;
                    if (userData2 != null) {
                        aVar = this.eLK.dUV;
                        z = this.eLK.mIsLiked;
                        boolean z2 = !z;
                        userData3 = this.eLK.mUserData;
                        String portrait = userData3.getPortrait();
                        userData4 = this.eLK.mUserData;
                        String userId = userData4.getUserId();
                        as asVar = this.eLK;
                        userData5 = this.eLK.mUserData;
                        isUseSingleGod = asVar.isUseSingleGod(userData5);
                        tbPageContext3 = this.eLK.aas;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == w.h.chat_btn) {
                tbPageContext = this.eLK.aas;
                if (!bh.aN(tbPageContext.getPageActivity())) {
                    return;
                }
                this.eLK.aEk();
            } else if (view.getId() == w.h.gift_btn) {
                rVar = this.eLK.bxW;
                if (rVar != null) {
                    com.baidu.tieba.personPolymeric.event.a aVar2 = new com.baidu.tieba.personPolymeric.event.a();
                    aVar2.bOi = 12;
                    aVar2.bOj = new Bundle();
                    Bundle bundle = aVar2.bOj;
                    userData = this.eLK.mUserData;
                    bundle.putSerializable(UserData.TYPE_USER, userData);
                    rVar2 = this.eLK.bxW;
                    rVar2.a(view, aVar2);
                }
            }
        }
    }
}

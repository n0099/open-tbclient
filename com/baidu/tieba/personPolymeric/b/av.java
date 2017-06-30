package com.baidu.tieba.personPolymeric.b;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ at eVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.eVS = atVar;
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
                tbPageContext2 = this.eVS.aat;
                if (bl.aN(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11592"));
                    userData2 = this.eVS.mUserData;
                    if (userData2 != null) {
                        aVar = this.eVS.edt;
                        z = this.eVS.mIsLiked;
                        boolean z2 = !z;
                        userData3 = this.eVS.mUserData;
                        String portrait = userData3.getPortrait();
                        userData4 = this.eVS.mUserData;
                        String userId = userData4.getUserId();
                        at atVar = this.eVS;
                        userData5 = this.eVS.mUserData;
                        isUseSingleGod = atVar.isUseSingleGod(userData5);
                        tbPageContext3 = this.eVS.aat;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == w.h.chat_btn) {
                tbPageContext = this.eVS.aat;
                if (!bl.aN(tbPageContext.getPageActivity())) {
                    return;
                }
                this.eVS.aIc();
            } else if (view.getId() == w.h.gift_btn) {
                rVar = this.eVS.eRa;
                if (rVar != null) {
                    com.baidu.tieba.personPolymeric.event.a aVar2 = new com.baidu.tieba.personPolymeric.event.a();
                    aVar2.bVd = 12;
                    aVar2.bVe = new Bundle();
                    Bundle bundle = aVar2.bVe;
                    userData = this.eVS.mUserData;
                    bundle.putSerializable(UserData.TYPE_USER, userData);
                    rVar2 = this.eVS.eRa;
                    rVar2.a(view, aVar2);
                }
            }
        }
    }
}

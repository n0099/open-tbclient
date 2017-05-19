package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ aj eCY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(aj ajVar) {
        this.eCY = ajVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        UserData userData;
        com.baidu.tbadk.coreExtra.c.a aVar;
        boolean z;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        boolean isUseSingleGod;
        TbPageContext tbPageContext3;
        if (view != null) {
            if (view.getId() == w.h.attention_btn) {
                tbPageContext2 = this.eCY.aat;
                if (bg.aN(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new as("c11592"));
                    userData = this.eCY.mUserData;
                    if (userData != null) {
                        aVar = this.eCY.dPz;
                        z = this.eCY.mIsLiked;
                        boolean z2 = !z;
                        userData2 = this.eCY.mUserData;
                        String portrait = userData2.getPortrait();
                        userData3 = this.eCY.mUserData;
                        String userId = userData3.getUserId();
                        aj ajVar = this.eCY;
                        userData4 = this.eCY.mUserData;
                        isUseSingleGod = ajVar.isUseSingleGod(userData4);
                        tbPageContext3 = this.eCY.aat;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == w.h.chat_btn) {
                tbPageContext = this.eCY.aat;
                if (!bg.aN(tbPageContext.getPageActivity())) {
                    return;
                }
                this.eCY.aDn();
            }
        }
    }
}

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
public class ah implements View.OnClickListener {
    final /* synthetic */ af eFn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.eFn = afVar;
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
                tbPageContext2 = this.eFn.aaX;
                if (bg.aK(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new as("c11592"));
                    userData = this.eFn.mUserData;
                    if (userData != null) {
                        aVar = this.eFn.dSy;
                        z = this.eFn.mIsLiked;
                        boolean z2 = !z;
                        userData2 = this.eFn.mUserData;
                        String portrait = userData2.getPortrait();
                        userData3 = this.eFn.mUserData;
                        String userId = userData3.getUserId();
                        af afVar = this.eFn;
                        userData4 = this.eFn.mUserData;
                        isUseSingleGod = afVar.isUseSingleGod(userData4);
                        tbPageContext3 = this.eFn.aaX;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == w.h.chat_btn) {
                tbPageContext = this.eFn.aaX;
                if (!bg.aK(tbPageContext.getPageActivity())) {
                    return;
                }
                this.eFn.aFf();
            }
        }
    }
}

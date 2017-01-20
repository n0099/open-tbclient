package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ af eDP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.eDP = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        UserData userData;
        com.baidu.tbadk.coreExtra.d.a aVar;
        boolean z;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        boolean isUseSingleGod;
        TbPageContext tbPageContext3;
        if (view != null) {
            if (view.getId() == r.h.attention_btn) {
                tbPageContext2 = this.eDP.Fp;
                if (bf.ak(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new ar("c11592"));
                    userData = this.eDP.mUserData;
                    if (userData != null) {
                        aVar = this.eDP.dSm;
                        z = this.eDP.mIsLiked;
                        boolean z2 = !z;
                        userData2 = this.eDP.mUserData;
                        String portrait = userData2.getPortrait();
                        userData3 = this.eDP.mUserData;
                        String userId = userData3.getUserId();
                        af afVar = this.eDP;
                        userData4 = this.eDP.mUserData;
                        isUseSingleGod = afVar.isUseSingleGod(userData4);
                        tbPageContext3 = this.eDP.Fp;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == r.h.chat_btn) {
                tbPageContext = this.eDP.Fp;
                if (!bf.ak(tbPageContext.getPageActivity())) {
                    return;
                }
                this.eDP.aFV();
            }
        }
    }
}

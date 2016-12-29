package com.baidu.tieba.personPolymeric.b;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ af etV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.etV = afVar;
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
            if (view.getId() == r.g.attention_btn) {
                tbPageContext2 = this.etV.Gf;
                if (bh.ai(tbPageContext2.getPageActivity())) {
                    TiebaStatic.log(new at("c11592"));
                    userData = this.etV.mUserData;
                    if (userData != null) {
                        aVar = this.etV.dJo;
                        z = this.etV.mIsLiked;
                        boolean z2 = !z;
                        userData2 = this.etV.mUserData;
                        String portrait = userData2.getPortrait();
                        userData3 = this.etV.mUserData;
                        String userId = userData3.getUserId();
                        af afVar = this.etV;
                        userData4 = this.etV.mUserData;
                        isUseSingleGod = afVar.isUseSingleGod(userData4);
                        tbPageContext3 = this.etV.Gf;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext3.getUniqueId());
                    }
                }
            } else if (view.getId() == r.g.chat_btn) {
                tbPageContext = this.etV.Gf;
                if (!bh.ai(tbPageContext.getPageActivity())) {
                    return;
                }
                this.etV.aEi();
            }
        }
    }
}

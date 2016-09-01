package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ af eHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.eHU = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        UserData userData;
        com.baidu.tbadk.coreExtra.d.a aVar;
        boolean z;
        UserData userData2;
        UserData userData3;
        UserData userData4;
        boolean isUseSingleGod;
        TbPageContext tbPageContext5;
        if (view != null) {
            if (view.getId() == t.g.attention_btn) {
                tbPageContext4 = this.eHU.Gd;
                if (bn.al(tbPageContext4.getPageActivity())) {
                    TiebaStatic.log(new ay("c11592"));
                    userData = this.eHU.mUserData;
                    if (userData != null) {
                        aVar = this.eHU.bwf;
                        z = this.eHU.eHS;
                        boolean z2 = z ? false : true;
                        userData2 = this.eHU.mUserData;
                        String portrait = userData2.getPortrait();
                        userData3 = this.eHU.mUserData;
                        String userId = userData3.getUserId();
                        af afVar = this.eHU;
                        userData4 = this.eHU.mUserData;
                        isUseSingleGod = afVar.isUseSingleGod(userData4);
                        tbPageContext5 = this.eHU.Gd;
                        aVar.a(z2, portrait, userId, isUseSingleGod, tbPageContext5.getUniqueId());
                    }
                }
            } else if (view.getId() == t.g.chat_btn) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication m9getInst = TbadkCoreApplication.m9getInst();
                    tbPageContext = this.eHU.Gd;
                    tbPageContext2 = this.eHU.Gd;
                    Activity pageActivity = tbPageContext2.getPageActivity();
                    tbPageContext3 = this.eHU.Gd;
                    m9getInst.login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) pageActivity, tbPageContext3.getString(t.j.login_to_chat), true, 11028)));
                    return;
                }
                this.eHU.aHL();
            }
        }
    }
}

package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ af eHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.eHU = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        BaseActivity baseActivity;
        com.baidu.tieba.personPolymeric.d.ad adVar;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null) {
                if (updateAttentionMessage.getData().vS) {
                    this.eHU.eHS = updateAttentionMessage.getData().akW;
                    adVar = this.eHU.eHR;
                    adVar.setData(updateAttentionMessage.getData().akW);
                    z = this.eHU.eHS;
                    if (!z) {
                        tbPageContext3 = this.eHU.Gd;
                        Activity pageActivity = tbPageContext3.getPageActivity();
                        tbPageContext4 = this.eHU.Gd;
                        BdToast.a(pageActivity, tbPageContext4.getString(t.j.unlike_success)).tf();
                        return;
                    }
                    tbPageContext = this.eHU.Gd;
                    Activity pageActivity2 = tbPageContext.getPageActivity();
                    tbPageContext2 = this.eHU.Gd;
                    BdToast.a(pageActivity2, tbPageContext2.getString(t.j.like_success)).tf();
                } else if (updateAttentionMessage.getData().errorString != null) {
                    baseActivity = this.eHU.aPR;
                    baseActivity.showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    }
}

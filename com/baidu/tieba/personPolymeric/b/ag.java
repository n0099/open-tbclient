package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ af eQw;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.eQw = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Message<?> message;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        com.baidu.tieba.personPolymeric.d.ad adVar;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null) {
                BdUniqueId tag = message.getTag();
                baseActivity = this.eQw.aTb;
                if (tag.equals(baseActivity.getUniqueId())) {
                    if (updateAttentionMessage.getData().vS) {
                        this.eQw.mIsLiked = updateAttentionMessage.getData().alx;
                        adVar = this.eQw.eQu;
                        adVar.setData(updateAttentionMessage.getData().alx);
                        z = this.eQw.mIsLiked;
                        if (!z) {
                            tbPageContext3 = this.eQw.Gf;
                            Activity pageActivity = tbPageContext3.getPageActivity();
                            tbPageContext4 = this.eQw.Gf;
                            BdToast.a(pageActivity, tbPageContext4.getString(r.j.unlike_success)).ty();
                            return;
                        }
                        tbPageContext = this.eQw.Gf;
                        Activity pageActivity2 = tbPageContext.getPageActivity();
                        tbPageContext2 = this.eQw.Gf;
                        BdToast.a(pageActivity2, tbPageContext2.getString(r.j.like_success)).ty();
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        baseActivity2 = this.eQw.aTb;
                        baseActivity2.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    }
}

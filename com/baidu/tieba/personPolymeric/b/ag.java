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
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ af eHr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.eHr = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Message<?> message;
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        com.baidu.tieba.personPolymeric.d.af afVar;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null) {
                BdUniqueId tag = message.getTag();
                baseActivity = this.eHr.bcF;
                if (tag.equals(baseActivity.getUniqueId())) {
                    if (updateAttentionMessage.getData().CX) {
                        this.eHr.mIsLiked = updateAttentionMessage.getData().isAttention;
                        afVar = this.eHr.eHp;
                        afVar.setData(updateAttentionMessage.getData().isAttention);
                        z = this.eHr.mIsLiked;
                        if (!z) {
                            tbPageContext3 = this.eHr.aaI;
                            Activity pageActivity = tbPageContext3.getPageActivity();
                            tbPageContext4 = this.eHr.aaI;
                            BdToast.a(pageActivity, tbPageContext4.getString(w.l.unlike_success)).tA();
                            return;
                        }
                        tbPageContext = this.eHr.aaI;
                        Activity pageActivity2 = tbPageContext.getPageActivity();
                        tbPageContext2 = this.eHr.aaI;
                        BdToast.a(pageActivity2, tbPageContext2.getString(w.l.attention_success)).tA();
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        baseActivity2 = this.eHr.bcF;
                        baseActivity2.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    }
}

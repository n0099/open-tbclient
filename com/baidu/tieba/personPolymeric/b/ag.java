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
    final /* synthetic */ af eHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.eHD = afVar;
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
                baseActivity = this.eHD.bdG;
                if (tag.equals(baseActivity.getUniqueId())) {
                    if (updateAttentionMessage.getData().CB) {
                        this.eHD.mIsLiked = updateAttentionMessage.getData().isAttention;
                        afVar = this.eHD.eHB;
                        afVar.setData(updateAttentionMessage.getData().isAttention);
                        z = this.eHD.mIsLiked;
                        if (!z) {
                            tbPageContext3 = this.eHD.aaY;
                            Activity pageActivity = tbPageContext3.getPageActivity();
                            tbPageContext4 = this.eHD.aaY;
                            BdToast.a(pageActivity, tbPageContext4.getString(w.l.unlike_success)).tY();
                            return;
                        }
                        tbPageContext = this.eHD.aaY;
                        Activity pageActivity2 = tbPageContext.getPageActivity();
                        tbPageContext2 = this.eHD.aaY;
                        BdToast.a(pageActivity2, tbPageContext2.getString(w.l.attention_success)).tY();
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        baseActivity2 = this.eHD.bdG;
                        baseActivity2.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    }
}

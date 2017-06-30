package com.baidu.tieba.personPolymeric.b;

import android.app.Activity;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends CustomMessageListener {
    final /* synthetic */ at eVS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(at atVar, int i) {
        super(i);
        this.eVS = atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Message<?> message;
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        com.baidu.tieba.personPolymeric.d.ai aiVar;
        boolean z;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        TbPageContext tbPageContext4;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null) {
                BdUniqueId tag = message.getTag();
                baseFragmentActivity = this.eVS.bzr;
                if (tag.equals(baseFragmentActivity.getUniqueId())) {
                    if (updateAttentionMessage.getData().CB) {
                        this.eVS.mIsLiked = updateAttentionMessage.getData().isAttention;
                        aiVar = this.eVS.eVQ;
                        aiVar.setAttentionData(updateAttentionMessage.getData().isAttention);
                        z = this.eVS.mIsLiked;
                        if (!z) {
                            tbPageContext3 = this.eVS.aat;
                            Activity pageActivity = tbPageContext3.getPageActivity();
                            tbPageContext4 = this.eVS.aat;
                            BdToast.a(pageActivity, tbPageContext4.getString(w.l.unlike_success)).ti();
                            return;
                        }
                        tbPageContext = this.eVS.aat;
                        Activity pageActivity2 = tbPageContext.getPageActivity();
                        tbPageContext2 = this.eVS.aat;
                        BdToast.a(pageActivity2, tbPageContext2.getString(w.l.attention_success)).ti();
                    } else if (updateAttentionMessage.getData().errorString != null) {
                        baseFragmentActivity2 = this.eVS.bzr;
                        baseFragmentActivity2.showToast(updateAttentionMessage.getData().errorString);
                    }
                }
            }
        }
    }
}

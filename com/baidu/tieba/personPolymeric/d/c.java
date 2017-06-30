package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b eXj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.eXj = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        com.baidu.tieba.personPolymeric.c.b bVar;
        com.baidu.tieba.personPolymeric.c.b bVar2;
        TextView textView;
        if (customResponsedMessage != null) {
            z = this.eXj.boT;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                    long j = aVar.forumId;
                    bVar = this.eXj.eXi;
                    if (j == bVar.forumId) {
                        if (aVar.isSuccess) {
                            bVar2 = this.eXj.eXi;
                            bVar2.isAttention = true;
                            textView = this.eXj.czW;
                            textView.setVisibility(0);
                            this.eXj.jX(true);
                            com.baidu.adp.lib.util.k.showToast(this.eXj.mContext, w.l.attention_success);
                        } else if (StringUtils.isNull(aVar.errorMessage)) {
                            com.baidu.adp.lib.util.k.showToast(this.eXj.mContext, w.l.attention_fail);
                        } else {
                            com.baidu.adp.lib.util.k.showToast(this.eXj.mContext, aVar.errorMessage);
                        }
                    }
                }
            }
        }
    }
}

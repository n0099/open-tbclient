package com.baidu.tieba.personPolymeric.d;

import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ b eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i) {
        super(i);
        this.eET = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        com.baidu.tieba.personPolymeric.c.a aVar;
        com.baidu.tieba.personPolymeric.c.a aVar2;
        TextView textView;
        if (customResponsedMessage != null) {
            z = this.eET.baK;
            if (!z) {
                Object data = customResponsedMessage.getData();
                if (data instanceof com.baidu.tieba.tbadkCore.writeModel.a) {
                    com.baidu.tieba.tbadkCore.writeModel.a aVar3 = (com.baidu.tieba.tbadkCore.writeModel.a) data;
                    long j = aVar3.forumId;
                    aVar = this.eET.eES;
                    if (j == aVar.forumId) {
                        if (aVar3.isSuccess) {
                            aVar2 = this.eET.eES;
                            aVar2.isAttention = true;
                            textView = this.eET.cmy;
                            textView.setVisibility(0);
                            this.eET.jr(true);
                            com.baidu.adp.lib.util.k.showToast(this.eET.mContext, r.l.attention_success);
                        } else if (StringUtils.isNull(aVar3.errorMessage)) {
                            com.baidu.adp.lib.util.k.showToast(this.eET.mContext, r.l.attention_fail);
                        } else {
                            com.baidu.adp.lib.util.k.showToast(this.eET.mContext, aVar3.errorMessage);
                        }
                    }
                }
            }
        }
    }
}

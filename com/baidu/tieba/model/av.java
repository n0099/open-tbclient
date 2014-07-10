package com.baidu.tieba.model;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends CustomMessageListener {
    final /* synthetic */ au a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av(au auVar, int i) {
        super(i);
        this.a = auVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        Context context;
        com.baidu.adp.base.h hVar;
        com.baidu.adp.base.h hVar2;
        if (customResponsedMessage != null) {
            switch (customResponsedMessage.getCmd()) {
                case 2001118:
                    if ((customResponsedMessage instanceof UpdateAttentionMessage) && this.a.j() != null) {
                        UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                        com.baidu.tbadk.coreExtra.message.a data = updateAttentionMessage.getData();
                        if (this.a.j().getUserId() != null && data != null && this.a.j().getUserId().equals(data.c) && data.a) {
                            this.a.j().setHave_attention(updateAttentionMessage.isAttention() ? 0 : 1);
                            this.a.mLoadDataMode = 3;
                            this.a.setErrorString(updateAttentionMessage.getErrorString());
                            hVar = this.a.mLoadDataCallBack;
                            if (hVar != null) {
                                hVar2 = this.a.mLoadDataCallBack;
                                hVar2.a(Boolean.valueOf(updateAttentionMessage.isSucc()));
                                return;
                            }
                            return;
                        } else if (data != null && !TextUtils.isEmpty(data.b)) {
                            context = this.a.v;
                            com.baidu.adp.lib.util.j.a(context, data.b);
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

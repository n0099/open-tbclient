package com.baidu.tieba.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aw extends com.baidu.adp.framework.c.a {
    final /* synthetic */ av a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aw(av avVar, int i) {
        super(2001118);
        this.a = avVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.a.h hVar;
        com.baidu.adp.a.h hVar2;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            switch (customResponsedMessage2.g()) {
                case 2001118:
                    if (!(customResponsedMessage2 instanceof UpdateAttentionMessage) || this.a.g() == null) {
                        return;
                    }
                    UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage2;
                    com.baidu.tbadk.coreExtra.message.d a = updateAttentionMessage.a();
                    if (this.a.g().getUserId() == null || a == null || !this.a.g().getUserId().equals(a.c)) {
                        return;
                    }
                    this.a.g().setHave_attention(updateAttentionMessage.c() ? 0 : 1);
                    this.a.mLoadDataMode = 3;
                    this.a.setErrorString(updateAttentionMessage.f());
                    hVar = this.a.mLoadDataCallBack;
                    if (hVar != null) {
                        hVar2 = this.a.mLoadDataCallBack;
                        hVar2.a(Boolean.valueOf(updateAttentionMessage.b()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ReplyMe.ReplyMeResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements CustomMessageTask.CustomRunnable {
    final /* synthetic */ SingleMentionActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(SingleMentionActivity singleMentionActivity) {
        this.a = singleMentionActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.model.al> run(CustomMessage customMessage) {
        com.baidu.adp.lib.cache.t i;
        if (customMessage == null) {
            return null;
        }
        i = this.a.i();
        byte[] bArr = (byte[]) i.a("replyme_cache");
        com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
        if (bArr != null && this.a.d != null && this.a.d.a() != null && this.a.d.a().h() == 1) {
            try {
                alVar.a(((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class)).data);
                if (!alVar.a()) {
                    this.a.h();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        return new CustomResponsedMessage<>(2001229, alVar);
    }
}

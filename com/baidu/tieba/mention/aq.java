package com.baidu.tieba.mention;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.ReplyMe.ReplyMeResIdl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements CustomMessageTask.CustomRunnable {
    final /* synthetic */ SingleMentionActivity bom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SingleMentionActivity singleMentionActivity) {
        this.bom = singleMentionActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.model.am> run(CustomMessage customMessage) {
        com.baidu.adp.lib.cache.t wQ;
        if (customMessage == null) {
            return null;
        }
        wQ = this.bom.wQ();
        byte[] bArr = (byte[]) wQ.get("replyme_cache");
        com.baidu.tieba.model.am amVar = new com.baidu.tieba.model.am(this.bom);
        if (bArr != null && this.bom.boj != null && this.bom.boj.ST() != null && this.bom.boj.ST().SX() == 1) {
            try {
                amVar.a(((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class)).data);
                if (!amVar.isSucc()) {
                    this.bom.tE();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        return new CustomResponsedMessage<>(2001229, amVar);
    }
}

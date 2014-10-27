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
    final /* synthetic */ SingleMentionActivity bnY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SingleMentionActivity singleMentionActivity) {
        this.bnY = singleMentionActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tieba.model.am> run(CustomMessage customMessage) {
        com.baidu.adp.lib.cache.t wO;
        if (customMessage == null) {
            return null;
        }
        wO = this.bnY.wO();
        byte[] bArr = (byte[]) wO.get("replyme_cache");
        com.baidu.tieba.model.am amVar = new com.baidu.tieba.model.am(this.bnY);
        if (bArr != null && this.bnY.bnV != null && this.bnY.bnV.SQ() != null && this.bnY.bnV.SQ().SU() == 1) {
            try {
                amVar.a(((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class)).data);
                if (!amVar.isSucc()) {
                    this.bnY.tC();
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
        return new CustomResponsedMessage<>(2001229, amVar);
    }
}

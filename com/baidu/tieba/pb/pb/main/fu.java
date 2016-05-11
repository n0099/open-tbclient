package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class fu implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
        if (customMessage == null || !(customMessage instanceof PbPageReadLocalRequestMessage)) {
            return null;
        }
        PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = (PbPageReadLocalRequestMessage) customMessage;
        byte[] E = cg.axh().E(pbPageReadLocalRequestMessage.getCacheKey(), pbPageReadLocalRequestMessage.isMarkCache());
        PbPageReadLocalResponseMessage pbPageReadLocalResponseMessage = new PbPageReadLocalResponseMessage();
        pbPageReadLocalResponseMessage.setPostId(pbPageReadLocalRequestMessage.getPostId());
        pbPageReadLocalResponseMessage.setMarkCache(pbPageReadLocalRequestMessage.isMarkCache());
        pbPageReadLocalResponseMessage.setUpdateType(pbPageReadLocalRequestMessage.getUpdateType());
        pbPageReadLocalResponseMessage.setContext(pbPageReadLocalRequestMessage.getContext());
        try {
            pbPageReadLocalResponseMessage.decodeInBackGround(CmdConfigCustom.PB_PAGE_CACHE_CMD, E);
            return pbPageReadLocalResponseMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return pbPageReadLocalResponseMessage;
        }
    }
}

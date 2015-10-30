package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ a cIB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.cIB = aVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        scrollFragmentTabHost = this.cIB.cIv;
        if (scrollFragmentTabHost.aqs()) {
            scrollFragmentTabHost2 = this.cIB.cIv;
            scrollFragmentTabHost2.aqu();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}

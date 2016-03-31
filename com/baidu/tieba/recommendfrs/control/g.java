package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ a dVV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dVV = aVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.dVV.dVM;
        if (scrollFragmentTabHost.aof()) {
            scrollFragmentTabHost2 = this.dVV.dVM;
            if (scrollFragmentTabHost2.dXo) {
                scrollFragmentTabHost3 = this.dVV.dVM;
                scrollFragmentTabHost3.aoh();
                scrollFragmentTabHost4 = this.dVV.dVM;
                scrollFragmentTabHost4.dXo = false;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}

package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ a dYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dYW = aVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.dYW.dYN;
        if (scrollFragmentTabHost.aol()) {
            scrollFragmentTabHost2 = this.dYW.dYN;
            if (scrollFragmentTabHost2.eax) {
                scrollFragmentTabHost3 = this.dYW.dYN;
                scrollFragmentTabHost3.aon();
                scrollFragmentTabHost4 = this.dYW.dYN;
                scrollFragmentTabHost4.eax = false;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}

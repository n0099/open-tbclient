package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ a diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.diB = aVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.diB.div;
        if (scrollFragmentTabHost.aww()) {
            scrollFragmentTabHost2 = this.diB.div;
            if (scrollFragmentTabHost2.diY) {
                scrollFragmentTabHost3 = this.diB.div;
                scrollFragmentTabHost3.awy();
                scrollFragmentTabHost4 = this.diB.div;
                scrollFragmentTabHost4.diY = false;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}

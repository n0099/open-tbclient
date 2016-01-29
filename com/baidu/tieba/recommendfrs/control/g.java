package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements CustomMessageTask.CustomRunnable<Boolean> {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.dEd = aVar;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        ScrollFragmentTabHost scrollFragmentTabHost4;
        scrollFragmentTabHost = this.dEd.dDV;
        if (scrollFragmentTabHost.aFI()) {
            scrollFragmentTabHost2 = this.dEd.dDV;
            if (scrollFragmentTabHost2.dFp) {
                scrollFragmentTabHost3 = this.dEd.dDV;
                scrollFragmentTabHost3.aFK();
                scrollFragmentTabHost4 = this.dEd.dDV;
                scrollFragmentTabHost4.dFp = false;
            }
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, true);
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, false);
    }
}

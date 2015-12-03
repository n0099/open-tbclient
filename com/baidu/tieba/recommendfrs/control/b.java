package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import tbclient.ExcFrsPage.ExcellentTagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a diB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.diB = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof ExcellentTagInfo) {
                ExcellentTagInfo excellentTagInfo = (ExcellentTagInfo) data;
                scrollFragmentTabHost = this.diB.div;
                if (scrollFragmentTabHost != null) {
                    scrollFragmentTabHost2 = this.diB.div;
                    int bA = scrollFragmentTabHost2.bA(excellentTagInfo.tag_code.longValue());
                    if (bA >= 0) {
                        scrollFragmentTabHost3 = this.diB.div;
                        scrollFragmentTabHost3.setCurrentTab(bA);
                    }
                }
            }
        }
    }
}

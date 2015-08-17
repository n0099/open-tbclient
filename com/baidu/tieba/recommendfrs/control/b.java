package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.csI = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                scrollFragmentTabHost = this.csI.csC;
                if (scrollFragmentTabHost != null) {
                    scrollFragmentTabHost2 = this.csI.csC;
                    int jY = scrollFragmentTabHost2.jY(str);
                    if (jY >= 0) {
                        scrollFragmentTabHost3 = this.csI.csC;
                        scrollFragmentTabHost3.setCurrentTab(jY);
                    }
                }
            }
        }
    }
}

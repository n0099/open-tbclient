package com.baidu.tieba.recommendfrs.control;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import tbclient.Personalized.TagInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends CustomMessageListener {
    final /* synthetic */ a dEd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.dEd = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ScrollFragmentTabHost scrollFragmentTabHost;
        ScrollFragmentTabHost scrollFragmentTabHost2;
        ScrollFragmentTabHost scrollFragmentTabHost3;
        if (customResponsedMessage != null) {
            Object data = customResponsedMessage.getData();
            if (data instanceof TagInfo) {
                TagInfo tagInfo = (TagInfo) data;
                scrollFragmentTabHost = this.dEd.dDV;
                if (scrollFragmentTabHost != null) {
                    scrollFragmentTabHost2 = this.dEd.dDV;
                    int bM = scrollFragmentTabHost2.bM(tagInfo.tag_code.longValue());
                    if (bM >= 0) {
                        scrollFragmentTabHost3 = this.dEd.dDV;
                        scrollFragmentTabHost3.setCurrentTab(bM);
                    }
                }
            }
        }
    }
}

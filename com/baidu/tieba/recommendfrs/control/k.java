package com.baidu.tieba.recommendfrs.control;

import android.widget.ImageView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ RecommendFrsDelegateStatic dEg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(RecommendFrsDelegateStatic recommendFrsDelegateStatic, int i) {
        super(i);
        this.dEg = recommendFrsDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        FragmentTabIndicator fragmentTabIndicator;
        ImageView imageView;
        ImageView imageView2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016325 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = ((Integer) customResponsedMessage.getData()).intValue();
            fragmentTabIndicator = this.dEg.ayb;
            FragmentTabIndicator.a fO = fragmentTabIndicator.fO("godFeed");
            if (fO != null) {
                if (intValue <= 0) {
                    imageView2 = this.dEg.dEe;
                    imageView2.setVisibility(8);
                    return;
                }
                imageView = this.dEg.dEe;
                imageView.setVisibility(0);
                fO.dk(TbadkCoreApplication.m411getInst().getSkinType());
            }
        }
    }
}

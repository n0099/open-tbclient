package com.baidu.tieba.recommendfrs;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d zL;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
            ((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
            if (((com.baidu.tbadk.mainTab.f) customResponsedMessage.getData()).getContext() != null && (zL = recommendFrsDelegateStatic.zL()) != null) {
                zL.alV.setArguments(new Bundle());
            }
        }
    }
}

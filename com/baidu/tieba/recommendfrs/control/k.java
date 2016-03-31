package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.c Fl;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
            ((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
            if (((com.baidu.tbadk.mainTab.d) customResponsedMessage.getData()).getContext() != null && (Fl = recommendFrsDelegateStatic.Fl()) != null) {
                Fl.ayV.setArguments(new Bundle());
            }
        }
    }
}

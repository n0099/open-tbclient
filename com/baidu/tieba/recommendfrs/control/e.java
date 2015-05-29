package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.f;
/* loaded from: classes.dex */
class e extends CustomMessageListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.mainTab.d AD;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
            RecommendFrsDelegateStatic recommendFrsDelegateStatic = new RecommendFrsDelegateStatic();
            ((f) customResponsedMessage.getData()).a(recommendFrsDelegateStatic);
            if (((f) customResponsedMessage.getData()).getContext() != null && (AD = recommendFrsDelegateStatic.AD()) != null) {
                AD.anf.setArguments(new Bundle());
            }
        }
    }
}

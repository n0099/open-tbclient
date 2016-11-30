package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ek extends CustomMessageListener {
    final /* synthetic */ ei eAa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek(ei eiVar, int i) {
        super(i);
        this.eAa = eiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.core.data.bg)) {
            int rr = ((com.baidu.tbadk.core.data.bg) customResponsedMessage.getData()).rr();
            this.eAa.ezW = false;
            switch (rr) {
                case 9:
                    this.eAa.O(this.eAa.ezP, false);
                    return;
                case 10:
                    this.eAa.O(this.eAa.ezP + 1, true);
                    return;
                case 11:
                    this.eAa.ezW = true;
                    this.eAa.O(this.eAa.ezP - 1, true);
                    return;
                case 12:
                default:
                    return;
                case 13:
                    this.eAa.ezT = 0;
                    this.eAa.ezP = 0;
                    return;
            }
        }
    }
}

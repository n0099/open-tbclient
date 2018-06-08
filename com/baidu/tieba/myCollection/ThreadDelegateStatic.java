package com.baidu.tieba.myCollection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class ThreadDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ja() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.aQP = ThreadFragment.aXQ();
        cVar.type = 1;
        cVar.aQQ = d.k.collect_thread;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aQB = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        return this.aQB;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2016207) { // from class: com.baidu.tieba.myCollection.ThreadDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c Jb;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016207 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.collectTab.a)) {
                    com.baidu.tbadk.collectTab.a aVar = (com.baidu.tbadk.collectTab.a) customResponsedMessage.getData();
                    ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
                    aVar.a(threadDelegateStatic);
                    if (aVar.getContext() != null && (Jb = threadDelegateStatic.Jb()) != null) {
                        Jb.aQP.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}

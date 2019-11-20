package com.baidu.tieba.myCollection;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class ThreadDelegateStatic extends com.baidu.tbadk.mainTab.b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c avw() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.frag = ThreadFragment.bNF();
        cVar.type = 1;
        cVar.textResId = R.string.collect_thread;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cJk = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        return this.cJk;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.COLLECT_TAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.myCollection.ThreadDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.tbadk.mainTab.c avx;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016207 && (customResponsedMessage.getData() instanceof com.baidu.tbadk.collectTab.a)) {
                    com.baidu.tbadk.collectTab.a aVar = (com.baidu.tbadk.collectTab.a) customResponsedMessage.getData();
                    ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
                    aVar.a(threadDelegateStatic);
                    if (aVar.getContext() != null && (avx = threadDelegateStatic.avx()) != null) {
                        avx.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(1);
        MessageManager.getInstance().registerListener(customMessageListener);
    }
}

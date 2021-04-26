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
import com.baidu.tieba.R;
import d.a.i0.e0.b;
import d.a.i0.e0.c;
/* loaded from: classes3.dex */
public class ThreadDelegateStatic extends b {

    /* loaded from: classes3.dex */
    public static class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c fragmentTabStructure;
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016207 && (customResponsedMessage.getData() instanceof d.a.i0.q.a)) {
                d.a.i0.q.a aVar = (d.a.i0.q.a) customResponsedMessage.getData();
                ThreadDelegateStatic threadDelegateStatic = new ThreadDelegateStatic();
                aVar.a(threadDelegateStatic);
                if (aVar.b() == null || (fragmentTabStructure = threadDelegateStatic.getFragmentTabStructure()) == null) {
                    return;
                }
                fragmentTabStructure.f48462a.setArguments(new Bundle());
            }
        }
    }

    static {
        a aVar = new a(2016207);
        aVar.setPriority(1);
        MessageManager.getInstance().registerListener(aVar);
    }

    @Override // d.a.i0.e0.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.f48462a = ThreadFragment.T0();
        cVar.f48466e = 1;
        cVar.f48463b = R.string.collect_thread;
        return cVar;
    }

    @Override // d.a.i0.e0.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(R.layout.fragmenttabindicator, (ViewGroup) null);
        this.mIndicator = fragmentTabIndicator;
        return fragmentTabIndicator;
    }

    @Override // d.a.i0.e0.b
    public boolean isAvailable() {
        return true;
    }
}

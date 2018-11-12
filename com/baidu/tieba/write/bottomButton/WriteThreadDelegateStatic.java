package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class WriteThreadDelegateStatic extends b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c MK() {
        c cVar = new c();
        cVar.bam = new WriteThreadFragment();
        cVar.type = 9;
        cVar.aBR = e.j.send;
        cVar.aBS = e.f.icon_tabbar_add_n;
        cVar.ban = e.f.icon_tabbar_chaticon_n;
        cVar.bat = c.bao;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c ML;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    WriteThreadDelegateStatic writeThreadDelegateStatic = new WriteThreadDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(writeThreadDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (ML = writeThreadDelegateStatic.ML()) != null) {
                        ML.bam.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(3);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bO(Context context) {
        this.aZY = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        return this.aZY;
    }
}

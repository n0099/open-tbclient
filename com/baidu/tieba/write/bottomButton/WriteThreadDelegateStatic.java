package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class WriteThreadDelegateStatic extends b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c avy() {
        c cVar = new c();
        cVar.frag = new WriteThreadFragment();
        cVar.type = 9;
        cVar.textResId = R.string.send;
        cVar.drawableResId = R.drawable.icon_tabbar_add_n;
        cVar.backgroundId = R.drawable.icon_tabbar_chaticon_n;
        cVar.showIconType = c.SHOWICON;
        return cVar;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.write.bottomButton.WriteThreadDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c avz;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    WriteThreadDelegateStatic writeThreadDelegateStatic = new WriteThreadDelegateStatic();
                    ((d) customResponsedMessage.getData()).a(writeThreadDelegateStatic);
                    if (((d) customResponsedMessage.getData()).getContext() != null && (avz = writeThreadDelegateStatic.avz()) != null) {
                        avz.frag.setArguments(new Bundle());
                    }
                }
            }
        };
        customMessageListener.setPriority(3);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        return this.cKb;
    }
}

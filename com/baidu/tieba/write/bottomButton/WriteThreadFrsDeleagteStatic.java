package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes.dex */
public class WriteThreadFrsDeleagteStatic extends b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c EO() {
        c cVar = new c();
        cVar.aGr = new a();
        cVar.type = 99;
        cVar.aGs = d.l.home_write;
        cVar.aGt = d.g.home_bottom_selector;
        cVar.aGx = c.aGu;
        return cVar;
    }

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.write.bottomButton.WriteThreadFrsDeleagteStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c EP;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null && ((ad) customResponsedMessage.getData()).iN(99)) {
                    WriteThreadFrsDeleagteStatic writeThreadFrsDeleagteStatic = new WriteThreadFrsDeleagteStatic();
                    ((ad) customResponsedMessage.getData()).b(writeThreadFrsDeleagteStatic);
                    if (((ad) customResponsedMessage.getData()).getContext() != null && (EP = writeThreadFrsDeleagteStatic.EP()) != null) {
                        EP.aGr.setArguments(new Bundle());
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aGe = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aGe.setTextSize(2.0f);
        return this.aGe;
    }
}

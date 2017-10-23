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
import com.baidu.tbadk.mainTab.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ae;
/* loaded from: classes2.dex */
public class WriteThreadFrsDeleagteStatic extends b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Et() {
        c cVar = new c();
        cVar.aGi = new a();
        cVar.type = 99;
        cVar.aGj = d.l.send;
        cVar.aGq = c.aGn;
        return cVar;
    }

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.write.bottomButton.WriteThreadFrsDeleagteStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Eu;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null && ((ae) customResponsedMessage.getData()).jk(99)) {
                    WriteThreadFrsDeleagteStatic writeThreadFrsDeleagteStatic = new WriteThreadFrsDeleagteStatic();
                    ((ae) customResponsedMessage.getData()).b(writeThreadFrsDeleagteStatic);
                    if (((ae) customResponsedMessage.getData()).getContext() != null && (Eu = writeThreadFrsDeleagteStatic.Eu()) != null) {
                        Eu.aGi.setArguments(new Bundle());
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.mainTab.b
    public e aY(Context context) {
        this.aFZ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.j.fragmenttabindicator, (ViewGroup) null);
        this.aFZ.setTextSize(2.0f);
        return this.aFZ;
    }
}

package com.baidu.tieba.write.bottomButton;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ad;
/* loaded from: classes3.dex */
public class WriteThreadFrsDeleagteStatic extends b {
    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return true;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Js() {
        c cVar = new c();
        cVar.aRL = new WriteThreadFragment();
        cVar.type = 99;
        cVar.aRM = d.k.send;
        cVar.aRS = c.aRP;
        return cVar;
    }

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001616) { // from class: com.baidu.tieba.write.bottomButton.WriteThreadFrsDeleagteStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c Jt;
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001616 && customResponsedMessage.getData() != null && ((ad) customResponsedMessage.getData()).ky(99)) {
                    WriteThreadFrsDeleagteStatic writeThreadFrsDeleagteStatic = new WriteThreadFrsDeleagteStatic();
                    ((ad) customResponsedMessage.getData()).b(writeThreadFrsDeleagteStatic);
                    if (((ad) customResponsedMessage.getData()).getContext() != null && (Jt = writeThreadFrsDeleagteStatic.Jt()) != null) {
                        Jt.aRL.setArguments(new Bundle());
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRx = (FragmentTabIndicator) LayoutInflater.from(context).inflate(d.i.fragmenttabindicator, (ViewGroup) null);
        this.aRx.setTextSize(2.0f);
        return this.aRx;
    }
}

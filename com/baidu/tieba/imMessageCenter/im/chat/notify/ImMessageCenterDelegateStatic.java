package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends b {
    private MessageRedDotView eEj;
    private CustomMessageListener eEk;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c Jn() {
        c cVar = new c();
        cVar.aRI = new MessageCenterFragment();
        cVar.type = 3;
        cVar.aRJ = f.j.my_message;
        cVar.aRK = f.C0146f.s_tabbar_icon_three_bg;
        cVar.jU = f.C0146f.tabbar_message_anim;
        cVar.aRQ = c.aRO;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bd(Context context) {
        this.aRu = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(f.h.maintab_bottom_indicator, (ViewGroup) null);
        this.eEj = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aSf = this.aRu;
        aVar.view = this.eEj;
        aVar.aSc = true;
        this.aRu.b("msg", aVar);
        this.eEj.setVisibility(4);
        return this.aRu;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(2007002) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2007002 && customResponsedMessage.getData() != null) {
                    ((d) customResponsedMessage.getData()).a(new ImMessageCenterDelegateStatic());
                }
            }
        };
        customMessageListener.setPriority(6);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Jm() {
        this.eEk = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                int i;
                boolean z;
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Pair)) {
                    try {
                        Pair pair = (Pair) customResponsedMessage.getData();
                        int intValue = ((Integer) pair.first).intValue();
                        try {
                            z = ((Boolean) pair.second).booleanValue();
                            i = intValue;
                        } catch (Exception e) {
                            i = intValue;
                            z = false;
                            ImMessageCenterDelegateStatic.this.f(z, i);
                        }
                    } catch (Exception e2) {
                        i = 0;
                    }
                    ImMessageCenterDelegateStatic.this.f(z, i);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eEk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z, int i) {
        if (this.eEj != null) {
            if (z) {
                this.eEj.refresh(i);
                this.eEj.setVisibility(0);
                return;
            }
            this.eEj.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void eX() {
        super.eX();
        MessageManager.getInstance().unRegisterListener(this.eEk);
    }
}

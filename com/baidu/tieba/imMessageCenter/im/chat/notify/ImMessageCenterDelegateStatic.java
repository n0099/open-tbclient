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
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
/* loaded from: classes4.dex */
public class ImMessageCenterDelegateStatic extends b {
    private MessageRedDotView fbp;
    private CustomMessageListener fbq;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c NO() {
        c cVar = new c();
        cVar.bdK = new MessageCenterFragment();
        cVar.type = 3;
        cVar.aFr = e.j.my_message;
        cVar.aFs = e.f.s_tabbar_icon_three_bg;
        cVar.nk = e.f.tabbar_message_anim;
        cVar.bdQ = c.bdO;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.bdw = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.fbp = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.bee = this.bdw;
        aVar.view = this.fbp;
        aVar.beb = true;
        this.bdw.b("msg", aVar);
        this.fbp.setVisibility(4);
        return this.bdw;
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
    public void NN() {
        this.fbq = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
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
                            ImMessageCenterDelegateStatic.this.h(z, i);
                        }
                    } catch (Exception e2) {
                        i = 0;
                    }
                    ImMessageCenterDelegateStatic.this.h(z, i);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fbq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z, int i) {
        if (this.fbp != null) {
            if (z) {
                this.fbp.refresh(i);
                this.fbp.setVisibility(0);
                return;
            }
            this.fbp.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
        super.gy();
        MessageManager.getInstance().unRegisterListener(this.fbq);
    }
}

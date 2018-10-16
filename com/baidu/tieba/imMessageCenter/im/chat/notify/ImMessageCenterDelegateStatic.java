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
    private MessageRedDotView eTh;
    private CustomMessageListener eTi;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c MB() {
        c cVar = new c();
        cVar.aZz = new MessageCenterFragment();
        cVar.type = 3;
        cVar.aBc = e.j.my_message;
        cVar.aBd = e.f.s_tabbar_icon_three_bg;
        cVar.nk = e.f.tabbar_message_anim;
        cVar.aZF = c.aZD;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator bR(Context context) {
        this.aZl = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(e.h.maintab_bottom_indicator, (ViewGroup) null);
        this.eTh = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.aZT = this.aZl;
        aVar.view = this.eTh;
        aVar.aZQ = true;
        this.aZl.b("msg", aVar);
        this.eTh.setVisibility(4);
        return this.aZl;
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
    public void MA() {
        this.eTi = new CustomMessageListener(2921002) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
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
                            ImMessageCenterDelegateStatic.this.g(z, i);
                        }
                    } catch (Exception e2) {
                        i = 0;
                    }
                    ImMessageCenterDelegateStatic.this.g(z, i);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eTi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, int i) {
        if (this.eTh != null) {
            if (z) {
                this.eTh.refresh(i);
                this.eTh.setVisibility(0);
                return;
            }
            this.eTh.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void gy() {
        super.gy();
        MessageManager.getInstance().unRegisterListener(this.eTi);
    }
}

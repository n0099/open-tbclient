package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
/* loaded from: classes4.dex */
public class ImMessageCenterDelegateStatic extends b {
    private MessageRedDotView gSZ;
    private CustomMessageListener gTa;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c avy() {
        c cVar = new c();
        cVar.frag = new MessageCenterFragment();
        cVar.type = 3;
        cVar.textResId = R.string.my_message;
        cVar.animationResId = R.raw.message;
        cVar.showIconType = c.SHOWBOTH;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator cB(Context context) {
        this.cKb = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.gSZ = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.cKv = this.cKb;
        aVar.view = this.gSZ;
        aVar.isRight = true;
        this.cKb.b("msg", aVar);
        this.gSZ.setVisibility(4);
        return this.cKb;
    }

    static {
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.1
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
    public void onAdd() {
        this.gTa = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
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
                            ImMessageCenterDelegateStatic.this.m(z, i);
                        }
                    } catch (Exception e2) {
                        i = 0;
                    }
                    ImMessageCenterDelegateStatic.this.m(z, i);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.gTa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(boolean z, int i) {
        if (this.gSZ != null) {
            if (z) {
                this.gSZ.refresh(i);
                this.gSZ.setVisibility(0);
                return;
            }
            this.gSZ.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.gTa);
    }
}

package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.mainTab.b;
import com.baidu.tbadk.mainTab.c;
import com.baidu.tbadk.mainTab.d;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.MessageCenterFragment;
import com.vivo.push.PushClientConstants;
/* loaded from: classes22.dex */
public class ImMessageCenterDelegateStatic extends b {
    private CustomMessageListener kFy;
    private MessageRedDotView tipView;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public c createFragmentTabStructure() {
        c cVar = new c();
        cVar.frag = new MessageCenterFragment();
        cVar.type = 3;
        cVar.textResId = R.string.my_message;
        cVar.animationResId = R.raw.lottie_tab_msg;
        cVar.showIconType = c.SHOWBOTH;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public TbFragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (MaintabBottomIndicator) LayoutInflater.from(context).inflate(R.layout.maintab_bottom_indicator, (ViewGroup) null);
        this.tipView = new MessageRedDotView(context);
        TbFragmentTabIndicator.a aVar = new TbFragmentTabIndicator.a();
        aVar.fAk = this.mIndicator;
        aVar.view = this.tipView;
        aVar.isRight = true;
        this.mIndicator.b("msg", aVar);
        this.tipView.setVisibility(4);
        if (!TbSingleton.getInstance().isShowVivoBadge()) {
            N(this.tipView.getContext(), 0);
        }
        return this.mIndicator;
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
        customMessageListener.setPriority(7);
        MessageManager.getInstance().registerListener(customMessageListener);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.kFy = new CustomMessageListener(CmdConfigCustom.CMD_HOME_NOTIFY_MSG) { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic.2
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
                            ImMessageCenterDelegateStatic.this.A(z, i);
                        }
                    } catch (Exception e2) {
                        i = 0;
                    }
                    ImMessageCenterDelegateStatic.this.A(z, i);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.kFy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z, int i) {
        if (this.tipView != null) {
            if (z) {
                this.tipView.setThreeDotMode(2);
                this.tipView.refresh(i);
                this.tipView.setVisibility(0);
                if (TbSingleton.getInstance().isShowVivoBadge()) {
                    N(this.tipView.getContext(), i);
                    return;
                }
                return;
            }
            this.tipView.setVisibility(8);
            if (TbSingleton.getInstance().isShowVivoBadge()) {
                N(this.tipView.getContext(), 0);
            }
        }
    }

    private void N(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
        intent.putExtra("packageName", "com.baidu.tieba");
        intent.putExtra(PushClientConstants.TAG_CLASS_NAME, "com.baidu.tieba.LogoActivity");
        intent.putExtra("notificationNum", i);
        intent.addFlags(16777216);
        context.sendBroadcast(intent);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.kFy);
    }
}

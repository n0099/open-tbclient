package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.ad;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView awx;
    private CustomMessageListener drj;
    private com.baidu.adp.framework.listener.e drk = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Ey() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ad adVar = new ad();
        adVar.gM(true);
        cVar.aFj = adVar;
        cVar.type = 3;
        cVar.aFk = w.l.my_message;
        cVar.aFl = w.g.s_tabbar_icon_three_bg;
        cVar.aFp = com.baidu.tbadk.mainTab.c.aFm;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aEW = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.awx = (TextView) LayoutInflater.from(context).inflate(w.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aFi = this.aEW;
        aVar.uS = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.awx;
        aVar.aFg = w.g.icon_dot_orange;
        aVar.aFh = w.e.common_color_10225;
        this.awx.setVisibility(8);
        this.aEW.a(AddFriendActivityConfig.MSG, aVar);
        return this.aEW;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT).setPriority(6);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ex() {
        this.drj = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.drj);
        MessageManager.getInstance().registerListener(this.drk);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.drj);
        MessageManager.getInstance().unRegisterListener(this.drk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            as.c(textView, w.e.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                as.j(textView, w.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                as.j(textView, w.g.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                as.j(textView, w.g.icon_news_head_prompt_more);
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.ad;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView avE;
    private com.baidu.adp.framework.listener.e dhA = new d(this, 104106);
    private CustomMessageListener dhz;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fd() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ad adVar = new ad();
        adVar.gw(true);
        cVar.aEf = adVar;
        cVar.type = 3;
        cVar.aEg = w.l.my_message;
        cVar.aEh = w.g.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aP(Context context) {
        this.aDS = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.avE = (TextView) LayoutInflater.from(context).inflate(w.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aEe = this.aDS;
        aVar.uN = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.avE;
        aVar.aEc = w.g.icon_dot_orange;
        aVar.aEd = w.e.common_color_10225;
        this.avE.setVisibility(8);
        this.aDS.a(AddFriendActivityConfig.MSG, aVar);
        return this.aDS;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(4);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fc() {
        this.dhz = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.dhz);
        MessageManager.getInstance().registerListener(this.dhA);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.dhz);
        MessageManager.getInstance().unRegisterListener(this.dhA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            aq.c(textView, w.e.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                aq.j(textView, w.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                aq.j(textView, w.g.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                aq.j(textView, w.g.icon_news_head_prompt_more);
            }
        }
    }
}

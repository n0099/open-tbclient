package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.ad;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView avu;
    private CustomMessageListener djn;
    private com.baidu.adp.framework.listener.e djo = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Eb() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ad adVar = new ad();
        adVar.gu(true);
        cVar.aDV = adVar;
        cVar.type = 3;
        cVar.aDW = w.l.my_message;
        cVar.aDX = w.g.s_tabbar_icon_three_bg;
        cVar.aEb = com.baidu.tbadk.mainTab.c.aDY;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aDI = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.avu = (TextView) LayoutInflater.from(context).inflate(w.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aDU = this.aDI;
        aVar.uT = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.avu;
        aVar.aDS = w.g.icon_dot_orange;
        aVar.aDT = w.e.common_color_10225;
        this.avu.setVisibility(8);
        return this.aDI;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT).setPriority(6);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Ea() {
        this.djn = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.djn);
        MessageManager.getInstance().registerListener(this.djo);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.djn);
        MessageManager.getInstance().unRegisterListener(this.djo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TextView textView, int i) {
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

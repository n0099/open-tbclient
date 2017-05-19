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
    private TextView avK;
    private CustomMessageListener ddS;
    private com.baidu.adp.framework.listener.e ddT = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Eh() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ad adVar = new ad();
        adVar.gh(true);
        cVar.aEi = adVar;
        cVar.type = 3;
        cVar.aEj = w.l.my_message;
        cVar.aEk = w.g.s_tabbar_icon_three_bg;
        cVar.aEo = com.baidu.tbadk.mainTab.c.aEl;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aS(Context context) {
        this.aDV = (FragmentTabIndicator) LayoutInflater.from(context).inflate(w.j.fragmenttabindicator, (ViewGroup) null);
        this.avK = (TextView) LayoutInflater.from(context).inflate(w.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.aEh = this.aDV;
        aVar.uT = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.avK;
        aVar.aEf = w.g.icon_dot_orange;
        aVar.aEg = w.e.common_color_10225;
        this.avK.setVisibility(8);
        return this.aDV;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT).setPriority(6);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Eg() {
        this.ddS = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.ddS);
        MessageManager.getInstance().registerListener(this.ddT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void cB() {
        super.cB();
        MessageManager.getInstance().unRegisterListener(this.ddS);
        MessageManager.getInstance().unRegisterListener(this.ddT);
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

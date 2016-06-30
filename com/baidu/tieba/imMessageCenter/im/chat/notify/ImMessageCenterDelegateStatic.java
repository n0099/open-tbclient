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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.bf;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView amN;
    private CustomMessageListener cYN;
    private com.baidu.adp.framework.listener.e cYO = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dl() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bf bfVar = new bf();
        bfVar.setPageType(1);
        cVar.avM = bfVar;
        cVar.type = 3;
        cVar.avN = u.j.enter_message;
        cVar.avO = u.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.avz = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        this.amN = (TextView) LayoutInflater.from(context).inflate(u.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.avL = this.avz;
        aVar.kD = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.amN;
        aVar.avJ = u.f.icon_dot_orange;
        aVar.avK = u.d.common_color_10225;
        this.amN.setVisibility(8);
        this.avz.a(AddFriendActivityConfig.MSG, aVar);
        return this.avz;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dk() {
        this.cYN = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.cYN);
        MessageManager.getInstance().registerListener(this.cYO);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.cYN);
        MessageManager.getInstance().unRegisterListener(this.cYO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            av.c(textView, u.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, u.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, u.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, u.f.icon_news_head_prompt_more);
            }
        }
    }
}

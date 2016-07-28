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
    private TextView anC;
    private CustomMessageListener dbK;
    private com.baidu.adp.framework.listener.e dbL = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bf bfVar = new bf();
        bfVar.setPageType(1);
        cVar.awB = bfVar;
        cVar.type = 3;
        cVar.awC = u.j.enter_message;
        cVar.awD = u.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ah(Context context) {
        this.awo = (FragmentTabIndicator) LayoutInflater.from(context).inflate(u.h.fragmenttabindicator, (ViewGroup) null);
        this.anC = (TextView) LayoutInflater.from(context).inflate(u.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.awA = this.awo;
        aVar.lg = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.anC;
        aVar.awy = u.f.icon_dot_orange;
        aVar.awz = u.d.common_color_10225;
        this.anC.setVisibility(8);
        this.awo.a(AddFriendActivityConfig.MSG, aVar);
        return this.awo;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Dj() {
        this.dbK = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.dbK);
        MessageManager.getInstance().registerListener(this.dbL);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.dbK);
        MessageManager.getInstance().unRegisterListener(this.dbL);
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

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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.bf;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView amh;
    private CustomMessageListener ctx;
    private com.baidu.adp.framework.listener.e cty = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Dc() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bf bfVar = new bf();
        bfVar.setPageType(1);
        cVar.auW = bfVar;
        cVar.type = 3;
        cVar.auX = t.j.enter_message;
        cVar.auY = t.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ai(Context context) {
        this.auJ = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.amh = (TextView) LayoutInflater.from(context).inflate(t.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.auV = this.auJ;
        aVar.kF = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.amh;
        aVar.auT = t.f.icon_dot_orange;
        aVar.auU = t.d.frs_slidebar_message_text;
        this.amh.setVisibility(8);
        this.auJ.a(AddFriendActivityConfig.MSG, aVar);
        return this.auJ;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Db() {
        this.ctx = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.ctx);
        MessageManager.getInstance().registerListener(this.cty);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ay() {
        super.ay();
        MessageManager.getInstance().unRegisterListener(this.ctx);
        MessageManager.getInstance().unRegisterListener(this.cty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            at.c(textView, t.d.frs_slidebar_message_text, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                at.k(textView, t.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                at.k(textView, t.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                at.k(textView, t.f.icon_news_head_prompt_more);
            }
        }
    }
}

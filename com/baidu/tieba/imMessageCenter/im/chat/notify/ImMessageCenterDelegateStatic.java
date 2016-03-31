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
import com.baidu.tieba.imMessageCenter.mention.be;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView aqt;
    private com.baidu.adp.framework.listener.e csA = new d(this, 104106);
    private CustomMessageListener csz;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Fk() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        be beVar = new be();
        beVar.setPageType(1);
        cVar.ayV = beVar;
        cVar.type = 3;
        cVar.ayW = t.j.enter_message;
        cVar.ayX = t.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.ayI = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.aqt = (TextView) LayoutInflater.from(context).inflate(t.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayU = this.ayI;
        aVar.uO = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aqt;
        aVar.ayS = t.f.icon_dot_orange;
        aVar.ayT = t.d.frs_slidebar_message_text;
        this.aqt.setVisibility(8);
        this.ayI.a(AddFriendActivityConfig.MSG, aVar);
        return this.ayI;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(6);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Fj() {
        this.csz = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.csz);
        MessageManager.getInstance().registerListener(this.csA);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ei() {
        super.ei();
        MessageManager.getInstance().unRegisterListener(this.csz);
        MessageManager.getInstance().unRegisterListener(this.csA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            at.b(textView, t.d.frs_slidebar_message_text, 1);
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

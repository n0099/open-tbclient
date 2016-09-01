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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView aqJ;
    private CustomMessageListener dns;
    private com.baidu.adp.framework.listener.e dnt = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EE() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bf bfVar = new bf();
        bfVar.setPageType(1);
        cVar.azI = bfVar;
        cVar.type = 3;
        cVar.azJ = t.j.enter_message;
        cVar.azK = t.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ar(Context context) {
        this.azv = (FragmentTabIndicator) LayoutInflater.from(context).inflate(t.h.fragmenttabindicator, (ViewGroup) null);
        this.aqJ = (TextView) LayoutInflater.from(context).inflate(t.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azH = this.azv;
        aVar.nB = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aqJ;
        aVar.azF = t.f.icon_dot_orange;
        aVar.azG = t.d.common_color_10225;
        this.aqJ.setVisibility(8);
        this.azv.a(AddFriendActivityConfig.MSG, aVar);
        return this.azv;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ED() {
        this.dns = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.dns);
        MessageManager.getInstance().registerListener(this.dnt);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.dns);
        MessageManager.getInstance().unRegisterListener(this.dnt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            av.c(textView, t.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, t.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, t.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, t.f.icon_news_head_prompt_more);
            }
        }
    }
}

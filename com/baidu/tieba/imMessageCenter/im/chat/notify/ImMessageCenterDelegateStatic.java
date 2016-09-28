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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView aqr;
    private CustomMessageListener doQ;
    private com.baidu.adp.framework.listener.e doR = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c EE() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bf bfVar = new bf();
        bfVar.setPageType(1);
        cVar.azl = bfVar;
        cVar.type = 3;
        cVar.azm = r.j.enter_message;
        cVar.azn = r.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.ayY = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.aqr = (TextView) LayoutInflater.from(context).inflate(r.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azk = this.ayY;
        aVar.nB = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aqr;
        aVar.azi = r.f.icon_dot_orange;
        aVar.azj = r.d.common_color_10225;
        this.aqr.setVisibility(8);
        this.ayY.a(AddFriendActivityConfig.MSG, aVar);
        return this.ayY;
    }

    static {
        new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ED() {
        this.doQ = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.doQ);
        MessageManager.getInstance().registerListener(this.doR);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.doQ);
        MessageManager.getInstance().unRegisterListener(this.doR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            av.c(textView, r.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                av.k(textView, r.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                av.k(textView, r.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                av.k(textView, r.f.icon_news_head_prompt_more);
            }
        }
    }
}

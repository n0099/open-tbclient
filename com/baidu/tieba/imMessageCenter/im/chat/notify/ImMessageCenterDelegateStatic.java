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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.ag;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView aqO;
    private CustomMessageListener cZt;
    private com.baidu.adp.framework.listener.e cZu = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Er() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ag agVar = new ag();
        agVar.gC(true);
        cVar.azA = agVar;
        cVar.type = 3;
        cVar.azB = r.j.enter_message;
        cVar.azC = r.f.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator an(Context context) {
        this.azn = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.h.fragmenttabindicator, (ViewGroup) null);
        this.aqO = (TextView) LayoutInflater.from(context).inflate(r.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.azz = this.azn;
        aVar.nC = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.aqO;
        aVar.azx = r.f.icon_dot_orange;
        aVar.azy = r.d.common_color_10225;
        this.aqO.setVisibility(8);
        this.azn.a(AddFriendActivityConfig.MSG, aVar);
        return this.azn;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(4);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Eq() {
        this.cZt = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.cZt);
        MessageManager.getInstance().registerListener(this.cZu);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.cZt);
        MessageManager.getInstance().unRegisterListener(this.cZu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            ar.c(textView, r.d.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                ar.k(textView, r.f.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                ar.k(textView, r.f.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                ar.k(textView, r.f.icon_news_head_prompt_more);
            }
        }
    }
}

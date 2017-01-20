package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.ad;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView apU;
    private CustomMessageListener dgI;
    private com.baidu.adp.framework.listener.e dgJ = new d(this, 104106);

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Em() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        ad adVar = new ad();
        adVar.gF(true);
        cVar.ayv = adVar;
        cVar.type = 3;
        cVar.ayw = r.l.my_message;
        cVar.ayx = r.g.s_tabbar_icon_three_bg;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator ap(Context context) {
        this.ayi = (FragmentTabIndicator) LayoutInflater.from(context).inflate(r.j.fragmenttabindicator, (ViewGroup) null);
        this.apU = (TextView) LayoutInflater.from(context).inflate(r.j.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.ayu = this.ayi;
        aVar.nv = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.apU;
        aVar.ays = r.g.icon_dot_orange;
        aVar.ayt = r.e.common_color_10225;
        this.apU.setVisibility(8);
        this.ayi.a(AddFriendActivityConfig.MSG, aVar);
        return this.ayi;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(4);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void El() {
        this.dgI = new e(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.dgI);
        MessageManager.getInstance().registerListener(this.dgJ);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void bt() {
        super.bt();
        MessageManager.getInstance().unRegisterListener(this.dgI);
        MessageManager.getInstance().unRegisterListener(this.dgJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(TextView textView, int i) {
        if (textView != null) {
            textView.setVisibility(0);
            ap.c(textView, r.e.common_color_10225, 1);
            if (i <= 0) {
                textView.setVisibility(8);
            } else if (i < 10) {
                textView.setText(String.valueOf(i));
                ap.j((View) textView, r.g.icon_news_head_prompt_one);
            } else if (i < 100) {
                textView.setText(String.valueOf(i));
                ap.j((View) textView, r.g.icon_news_head_prompt_two);
            } else {
                textView.setText("   ");
                ap.j((View) textView, r.g.icon_news_head_prompt_more);
            }
        }
    }
}

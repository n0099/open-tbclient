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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView alW;
    private CustomMessageListener bKr;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.atN = new e();
        cVar.type = 3;
        cVar.atO = i.h.enter_message;
        cVar.atP = i.e.s_icon_tabbar_imcenter;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        this.alW = (TextView) LayoutInflater.from(context).inflate(i.g.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.atM = this.mIndicator;
        aVar.view = this.alW;
        aVar.atK = i.e.icon_dot_orange;
        aVar.atL = i.c.frs_slidebar_message_text;
        this.alW.setVisibility(8);
        this.mIndicator.a(AddFriendActivityConfig.MSG, aVar);
        return this.mIndicator;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(4);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.bKr = new d(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.bKr);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.bKr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(TextView textView, int i) {
        textView.setVisibility(0);
        an.b(textView, i.c.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            an.i((View) textView, i.e.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            an.i((View) textView, i.e.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            an.i((View) textView, i.e.icon_news_head_prompt_more);
        }
    }
}

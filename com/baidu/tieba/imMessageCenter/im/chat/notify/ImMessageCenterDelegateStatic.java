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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.imMessageCenter.mention.bc;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView anJ;
    private CustomMessageListener bZw;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bc bcVar = new bc();
        bcVar.iY(1);
        cVar.avR = bcVar;
        cVar.type = 3;
        cVar.avS = n.i.enter_message;
        cVar.avT = n.e.s_icon_tabbar_imcenter;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.g.fragmenttabindicator, (ViewGroup) null);
        this.anJ = (TextView) LayoutInflater.from(context).inflate(n.g.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.avQ = this.mIndicator;
        aVar.uu = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.anJ;
        aVar.avO = n.e.icon_dot_orange;
        aVar.avP = n.c.frs_slidebar_message_text;
        this.anJ.setVisibility(8);
        this.mIndicator.a(AddFriendActivityConfig.MSG, aVar);
        return this.mIndicator;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(5);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onAdd() {
        this.bZw = new d(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.bZw);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.bZw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(TextView textView, int i) {
        textView.setVisibility(0);
        as.b(textView, n.c.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            as.i((View) textView, n.e.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            as.i((View) textView, n.e.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            as.i((View) textView, n.e.icon_news_head_prompt_more);
        }
    }
}

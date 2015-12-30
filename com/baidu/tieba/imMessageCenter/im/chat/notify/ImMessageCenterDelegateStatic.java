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
import com.baidu.tieba.imMessageCenter.mention.bd;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView apj;
    private CustomMessageListener cdw;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c createFragmentTabStructure() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        bd bdVar = new bd();
        bdVar.jx(1);
        cVar.axv = bdVar;
        cVar.type = 3;
        cVar.axw = n.j.enter_message;
        cVar.axx = n.f.s_icon_tabbar_imcenter;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator getTabIndicator(Context context) {
        this.mIndicator = (FragmentTabIndicator) LayoutInflater.from(context).inflate(n.h.fragmenttabindicator, (ViewGroup) null);
        this.apj = (TextView) LayoutInflater.from(context).inflate(n.h.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.axu = this.mIndicator;
        aVar.uw = com.baidu.adp.lib.util.k.dip2px(context, 3.0f);
        aVar.view = this.apj;
        aVar.axs = n.f.icon_dot_orange;
        aVar.axt = n.d.frs_slidebar_message_text;
        this.apj.setVisibility(8);
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
        this.cdw = new d(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.cdw);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void onRemove() {
        super.onRemove();
        MessageManager.getInstance().unRegisterListener(this.cdw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(TextView textView, int i) {
        textView.setVisibility(0);
        as.b(textView, n.d.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            as.i((View) textView, n.f.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            as.i((View) textView, n.f.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            as.i((View) textView, n.f.icon_news_head_prompt_more);
        }
    }
}

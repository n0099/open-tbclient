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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private TextView alN;
    private CustomMessageListener bFZ;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.c Cz() {
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.auR = new e();
        cVar.type = 3;
        cVar.auS = i.C0057i.enter_message;
        cVar.auT = i.e.icon_tabbar_imcenter;
        return cVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator an(Context context) {
        this.auE = (FragmentTabIndicator) LayoutInflater.from(context).inflate(i.g.fragmenttabindicator, (ViewGroup) null);
        this.alN = (TextView) LayoutInflater.from(context).inflate(i.g.message_tip_item, (ViewGroup) null);
        FragmentTabIndicator.a aVar = new FragmentTabIndicator.a();
        aVar.auQ = this.auE;
        aVar.view = this.alN;
        aVar.auO = i.e.icon_dot_orange;
        aVar.auP = i.c.frs_slidebar_message_text;
        this.alN.setVisibility(8);
        this.auE.a(AddFriendActivityConfig.MSG, aVar);
        return this.auE;
    }

    static {
        c cVar = new c(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        cVar.setPriority(4);
        MessageManager.getInstance().registerListener(cVar);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void Cy() {
        this.bFZ = new d(this, CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        MessageManager.getInstance().registerListener(this.bFZ);
    }

    @Override // com.baidu.tbadk.mainTab.b
    public void ef() {
        super.ef();
        MessageManager.getInstance().unRegisterListener(this.bFZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(TextView textView, int i) {
        textView.setVisibility(0);
        al.b(textView, i.c.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            al.i((View) textView, i.e.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            al.i((View) textView, i.e.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            al.i((View) textView, i.e.icon_news_head_prompt_more);
        }
    }
}

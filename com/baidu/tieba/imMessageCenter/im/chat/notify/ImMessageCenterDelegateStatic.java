package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView agH;

    @Override // com.baidu.tbadk.mainTab.b
    public boolean isAvailable() {
        return MainTabActivityConfig.IMMESSAGE_CENTER_DELEGATE_AVAIBLE;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d AC() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.anf = new d();
        dVar.type = 3;
        dVar.ang = t.enter_message;
        dVar.anh = com.baidu.tieba.p.icon_tabbar_imcenter;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator aj(Context context) {
        this.amS = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hr().inflate(context, r.fragmenttabindicator, null);
        agH = (TextView) com.baidu.adp.lib.g.b.hr().inflate(context, r.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.ane = this.amS;
        cVar.view = agH;
        cVar.anc = com.baidu.tieba.p.icon_dot_orange;
        cVar.and = com.baidu.tieba.n.frs_slidebar_message_text;
        agH.setVisibility(8);
        this.amS.a(AddFriendActivityConfig.MSG, cVar);
        return this.amS;
    }

    static {
        b bVar = new b(2007002);
        bVar.setPriority(4);
        MessageManager.getInstance().registerListener(bVar);
        MessageManager.getInstance().registerListener(new c(2001124));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(TextView textView, int i) {
        textView.setVisibility(0);
        ay.b(textView, com.baidu.tieba.n.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_more);
        }
    }
}

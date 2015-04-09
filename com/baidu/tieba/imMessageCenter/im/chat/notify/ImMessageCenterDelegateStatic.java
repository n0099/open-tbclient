package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class ImMessageCenterDelegateStatic extends com.baidu.tbadk.mainTab.b {
    private static TextView afG;

    @Override // com.baidu.tbadk.mainTab.b
    public com.baidu.tbadk.mainTab.d zQ() {
        com.baidu.tbadk.mainTab.d dVar = new com.baidu.tbadk.mainTab.d();
        dVar.amd = new d();
        dVar.type = 3;
        dVar.ame = y.enter_message;
        dVar.alU = u.icon_tabbar_imcenter;
        return dVar;
    }

    @Override // com.baidu.tbadk.mainTab.b
    public FragmentTabIndicator af(Context context) {
        this.alR = (FragmentTabIndicator) com.baidu.adp.lib.g.b.hH().inflate(context, w.fragmenttabindicator, null);
        afG = (TextView) com.baidu.adp.lib.g.b.hH().inflate(context, w.message_tip_item, null);
        com.baidu.tbadk.mainTab.c cVar = new com.baidu.tbadk.mainTab.c();
        cVar.amc = this.alR;
        cVar.view = afG;
        cVar.ama = u.icon_dot_orange;
        cVar.amb = s.frs_slidebar_message_text;
        afG.setVisibility(8);
        this.alR.a(AddFriendActivityConfig.MSG, cVar);
        return this.alR;
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
        ba.b(textView, s.frs_slidebar_message_text, 1);
        if (i <= 0) {
            textView.setVisibility(8);
        } else if (i < 10) {
            textView.setText(String.valueOf(i));
            ba.i((View) textView, u.icon_news_head_prompt_one);
        } else if (i < 100) {
            textView.setText(String.valueOf(i));
            ba.i((View) textView, u.icon_news_head_prompt_two);
        } else {
            textView.setText("   ");
            ba.i((View) textView, u.icon_news_head_prompt_more);
        }
    }
}

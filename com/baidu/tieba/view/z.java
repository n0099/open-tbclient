package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ SearchBoxView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(SearchBoxView searchBoxView) {
        this.a = searchBoxView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        Activity activity2;
        if (view.getId() == com.baidu.tieba.v.search_bg_layout) {
            activity = this.a.a;
            str = this.a.b;
            TiebaStatic.eventStat(activity, str, "click", 1, new Object[0]);
            MessageManager messageManager = MessageManager.getInstance();
            activity2 = this.a.a;
            messageManager.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(activity2)));
        }
    }
}

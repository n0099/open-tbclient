package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ w bRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.bRT = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        String str;
        Activity activity2;
        if (view.getId() == com.baidu.tieba.v.search_bg_layout) {
            activity = this.bRT.mCurrentActivity;
            str = this.bRT.bRO;
            TiebaStatic.eventStat(activity, str, "click", 1, new Object[0]);
            MessageManager messageManager = MessageManager.getInstance();
            activity2 = this.bRT.mCurrentActivity;
            messageManager.sendMessage(new CustomMessage(2015002, new com.baidu.tbadk.core.frameworkData.a(activity2)));
        }
    }
}

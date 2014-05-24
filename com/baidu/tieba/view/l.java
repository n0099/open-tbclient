package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.as;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ k a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, Context context) {
        this.a = kVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (view.getId() == com.baidu.tieba.v.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.a.a;
            if (context2 instanceof BaseFragmentActivity) {
                context3 = this.a.a;
                context4 = this.a.a;
                ((BaseFragmentActivity) context3).a(new CustomMessage(2005000, new com.baidu.tbadk.core.atomData.m(context4).a(obj, "")));
            }
            TiebaStatic.eventStat(this.b, "forum_feed_frsclick", "frs_click", 1, new Object[0]);
            return;
        }
        m mVar = (m) view.getTag();
        if (mVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.a.a;
            messageManager.sendMessage(new CustomMessage(2006001, new as(context).a(mVar.l, null, null)));
            TiebaStatic.eventStat(this.b, "forum_feed_pbclick", "pb_click", 1, new Object[0]);
        }
    }
}

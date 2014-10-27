package com.baidu.tieba.view;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j bQX;
    private final /* synthetic */ Context val$context;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, Context context) {
        this.bQX = jVar;
        this.val$context = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (view.getId() == com.baidu.tieba.v.textHomeListFrsName) {
            String obj = view.getTag().toString();
            context2 = this.bQX.mContext;
            if (context2 instanceof BaseFragmentActivity) {
                context3 = this.bQX.mContext;
                context4 = this.bQX.mContext;
                ((BaseFragmentActivity) context3).sendMessage(new CustomMessage(2003000, new FrsActivityConfig(context4).createNormalCfg(obj, "")));
            }
            TiebaStatic.eventStat(this.val$context, "forum_feed_frsclick", "frs_click", 1, new Object[0]);
            return;
        }
        l lVar = (l) view.getTag();
        if (lVar != null) {
            MessageManager messageManager = MessageManager.getInstance();
            context = this.bQX.mContext;
            messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(lVar.threadId, null, null)));
            TiebaStatic.eventStat(this.val$context, "forum_feed_pbclick", "pb_click", 1, new Object[0]);
        }
    }
}

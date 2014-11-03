package com.baidu.tieba.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ FeedBackTopListView bTd;
    private final /* synthetic */ String bTe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, String str) {
        this.bTd = feedBackTopListView;
        this.bTe = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.bTd.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(this.bTe, null, WriteActivityConfig.FEED_BACK)));
    }
}

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
    final /* synthetic */ FeedBackTopListView cek;
    private final /* synthetic */ String cel;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, String str) {
        this.cek = feedBackTopListView;
        this.cel = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cek.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(this.cel, null, WriteActivityConfig.FEED_BACK)));
    }
}

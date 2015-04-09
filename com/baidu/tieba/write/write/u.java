package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ FeedBackTopListView cxm;
    private final /* synthetic */ String cxn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FeedBackTopListView feedBackTopListView, String str) {
        this.cxm = feedBackTopListView;
        this.cxn = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cxm.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(this.cxn, null, WriteActivityConfig.FEED_BACK)));
    }
}

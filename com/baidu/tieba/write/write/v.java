package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ FeedBackTopListView cBE;
    private final /* synthetic */ String cBF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FeedBackTopListView feedBackTopListView, String str) {
        this.cBE = feedBackTopListView;
        this.cBF = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.cBE.mContext;
        messageManager.sendMessage(new CustomMessage(2004001, new PbActivityConfig(context).createNormalCfg(this.cBF, null, WriteActivityConfig.FEED_BACK)));
    }
}

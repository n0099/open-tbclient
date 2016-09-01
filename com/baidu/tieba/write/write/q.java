package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.bg bRf;
    private final /* synthetic */ String eoo;
    final /* synthetic */ FeedBackTopListView gea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.bg bgVar, String str) {
        this.gea = feedBackTopListView;
        this.bRf = bgVar;
        this.eoo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bRf.getThreadType() == 33) {
            context2 = this.gea.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bRf.getTid()).ci(this.bRf.rQ()).oW()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.gea.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.eoo, null, "feed_back")));
    }
}

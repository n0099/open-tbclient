package com.baidu.tieba.write.write;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.bm clj;
    private final /* synthetic */ String cmM;
    final /* synthetic */ FeedBackTopListView gkk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.bm bmVar, String str) {
        this.gkk = feedBackTopListView;
        this.clj = bmVar;
        this.cmM = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.clj.getThreadType() == 33) {
            context2 = this.gkk.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.clj.getTid()).co(this.clj.rH()).pa()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.gkk.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.cmM, null, WriteActivityConfig.FEED_BACK)));
    }
}

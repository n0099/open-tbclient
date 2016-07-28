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
    private final /* synthetic */ com.baidu.tbadk.core.data.be bFX;
    private final /* synthetic */ String ecf;
    final /* synthetic */ FeedBackTopListView fTW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.be beVar, String str) {
        this.fTW = feedBackTopListView;
        this.bFX = beVar;
        this.ecf = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bFX.getThreadType() == 33) {
            context2 = this.fTW.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bFX.getTid()).ch(this.bFX.qL()).oa()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fTW.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.ecf, null, "feed_back")));
    }
}

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
    private final /* synthetic */ com.baidu.tbadk.core.data.bj bWS;
    private final /* synthetic */ String bZG;
    final /* synthetic */ FeedBackTopListView fPf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.bj bjVar, String str) {
        this.fPf = feedBackTopListView;
        this.bWS = bjVar;
        this.bZG = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bWS.getThreadType() == 33) {
            context2 = this.fPf.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bWS.getTid()).cb(this.bWS.sg()).pg()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fPf.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.bZG, null, WriteActivityConfig.FEED_BACK)));
    }
}

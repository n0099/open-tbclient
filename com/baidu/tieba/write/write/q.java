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
public class q implements View.OnClickListener {
    private final /* synthetic */ com.baidu.tbadk.core.data.as bnE;
    private final /* synthetic */ String dhI;
    final /* synthetic */ FeedBackTopListView eLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.as asVar, String str) {
        this.eLO = feedBackTopListView;
        this.bnE = asVar;
        this.dhI = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bnE.getThreadType() == 33) {
            context2 = this.eLO.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bnE.getTid()).cj(this.bnE.tB()).qT()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.eLO.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.dhI, null, WriteActivityConfig.FEED_BACK)));
    }
}

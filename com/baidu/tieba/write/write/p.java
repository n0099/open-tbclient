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
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bWY;
    private final /* synthetic */ String bYo;
    final /* synthetic */ FeedBackTopListView fRp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.bk bkVar, String str) {
        this.fRp = feedBackTopListView;
        this.bWY = bkVar;
        this.bYo = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bWY.getThreadType() == 33) {
            context2 = this.fRp.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bWY.getTid()).ci(this.bWY.rO()).pl()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.fRp.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.bYo, null, WriteActivityConfig.FEED_BACK)));
    }
}

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
    private final /* synthetic */ com.baidu.tbadk.core.data.bk bXx;
    private final /* synthetic */ String ewa;
    final /* synthetic */ FeedBackTopListView gnO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.bk bkVar, String str) {
        this.gnO = feedBackTopListView;
        this.bXx = bkVar;
        this.ewa = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.bXx.getThreadType() == 33) {
            context2 = this.gnO.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.bXx.getTid()).cj(this.bXx.se()).oZ()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.gnO.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.ewa, null, "feed_back")));
    }
}

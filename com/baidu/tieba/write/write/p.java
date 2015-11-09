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
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXA;
    private final /* synthetic */ String axL;
    final /* synthetic */ FeedBackTopListView dqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.w wVar, String str) {
        this.dqz = feedBackTopListView;
        this.aXA = wVar;
        this.axL = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.aXA.sq() == 33) {
            context2 = this.dqz.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.aXA.getTid()).ce(this.aXA.ss()).ri()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.dqz.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.axL, null, WriteActivityConfig.FEED_BACK)));
    }
}

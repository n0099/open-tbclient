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
    private final /* synthetic */ com.baidu.tbadk.core.data.w aXr;
    private final /* synthetic */ String ayW;
    final /* synthetic */ FeedBackTopListView doK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FeedBackTopListView feedBackTopListView, com.baidu.tbadk.core.data.w wVar, String str) {
        this.doK = feedBackTopListView;
        this.aXr = wVar;
        this.ayW = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        if (this.aXr.sn() == 33) {
            context2 = this.doK.mContext;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(context2, this.aXr.getTid()).cg(this.aXr.sp()).rh()));
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        context = this.doK.mContext;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(context).createNormalCfg(this.ayW, null, WriteActivityConfig.FEED_BACK)));
    }
}

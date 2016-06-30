package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e dML;
    private final /* synthetic */ y dMM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar, y yVar) {
        this.dML = eVar;
        this.dMM = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Context context;
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        PbActivity pbActivity2;
        if (this.dMM.aJJ.isPlaying()) {
            this.dMM.aJJ.pause();
            this.dML.d(false, 2);
        }
        pbActivity = this.dML.dOg;
        if (PbActivityConfig.FROM_VIDEO_LIST.equals(pbActivity.aFd())) {
            pbActivity2 = this.dML.dOg;
            pbActivity2.finish();
        } else {
            context = this.dML.mContext;
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(context);
            hVar = this.dML.dMC;
            String valueOf = String.valueOf(hVar.getForumId());
            hVar2 = this.dML.dMC;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, hVar2.getThreadId(), "pb")));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}

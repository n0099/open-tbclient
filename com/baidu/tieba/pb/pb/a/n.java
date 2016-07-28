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
    final /* synthetic */ e dYX;
    private final /* synthetic */ y dYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar, y yVar) {
        this.dYX = eVar;
        this.dYY = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Context context;
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        PbActivity pbActivity2;
        if (this.dYY.aKC.isPlaying()) {
            this.dYY.aKC.pause();
            this.dYX.e(false, 2);
        }
        pbActivity = this.dYX.eat;
        if (PbActivityConfig.FROM_VIDEO_LIST.equals(pbActivity.aIo())) {
            pbActivity2 = this.dYX.eat;
            pbActivity2.finish();
        } else {
            context = this.dYX.mContext;
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(context);
            hVar = this.dYX.dYM;
            String valueOf = String.valueOf(hVar.getForumId());
            hVar2 = this.dYX.dYM;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, hVar2.getThreadId(), "pb")));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}

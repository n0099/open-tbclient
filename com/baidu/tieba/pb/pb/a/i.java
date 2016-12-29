package com.baidu.tieba.pb.pb.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ d dXu;
    private final /* synthetic */ s dXv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar, s sVar) {
        this.dXu = dVar;
        this.dXv = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Context context;
        com.baidu.tieba.pb.data.f fVar;
        com.baidu.tieba.pb.data.f fVar2;
        PbActivity pbActivity2;
        if (this.dXv.aNV.isPlaying()) {
            this.dXv.aNV.pause();
            this.dXu.e(false, 2);
        }
        pbActivity = this.dXu.dYB;
        if ("midpage".equals(pbActivity.aIZ())) {
            pbActivity2 = this.dXu.dYB;
            pbActivity2.finish();
        } else {
            context = this.dXu.mContext;
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(context);
            fVar = this.dXu.dXl;
            String valueOf = String.valueOf(fVar.getForumId());
            fVar2 = this.dXu.dXl;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, fVar2.getThreadId(), "pb")));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}

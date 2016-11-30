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
public class j implements View.OnClickListener {
    final /* synthetic */ e esY;
    private final /* synthetic */ t esZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, t tVar) {
        this.esY = eVar;
        this.esZ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Context context;
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        PbActivity pbActivity2;
        if (this.esZ.aOE.isPlaying()) {
            this.esZ.aOE.pause();
            this.esY.e(false, 2);
        }
        pbActivity = this.esY.eug;
        if ("midpage".equals(pbActivity.aPa())) {
            pbActivity2 = this.esY.eug;
            pbActivity2.finish();
        } else {
            context = this.esY.mContext;
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(context);
            hVar = this.esY.esP;
            String valueOf = String.valueOf(hVar.getForumId());
            hVar2 = this.esY.esP;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, hVar2.getThreadId(), "pb")));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}

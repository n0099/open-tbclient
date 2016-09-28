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
public class k implements View.OnClickListener {
    final /* synthetic */ e emY;
    private final /* synthetic */ v emZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, v vVar) {
        this.emY = eVar;
        this.emZ = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        Context context;
        com.baidu.tieba.pb.data.h hVar;
        com.baidu.tieba.pb.data.h hVar2;
        PbActivity pbActivity2;
        if (this.emZ.aMF.isPlaying()) {
            this.emZ.aMF.pause();
            this.emY.e(false, 2);
        }
        pbActivity = this.emY.eow;
        if (PbActivityConfig.FROM_VIDEO_LIST.equals(pbActivity.aNM())) {
            pbActivity2 = this.emY.eow;
            pbActivity2.finish();
        } else {
            context = this.emY.mContext;
            VideoListActivityConfig videoListActivityConfig = new VideoListActivityConfig(context);
            hVar = this.emY.emS;
            String valueOf = String.valueOf(hVar.getForumId());
            hVar2 = this.emY.emS;
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, videoListActivityConfig.createNormalCfg(valueOf, hVar2.getThreadId(), "pb")));
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RESET_EDITOR_TOOL, false));
    }
}

package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag eKO;
    private final /* synthetic */ ac eKP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, ac acVar) {
        this.eKO = agVar;
        this.eKP = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKP == null) {
            return;
        }
        this.eKO.pk(this.eKP.threadId);
        au auVar = new au("c11927");
        auVar.r("obj_locate", this.eKP.position);
        auVar.Z("tid", this.eKP.threadId);
        auVar.f("fid", this.eKP.forumId);
        auVar.Z("obj_param1", this.eKP.eKA);
        auVar.Z("obj_param2", "1");
        auVar.f("obj_param3", System.currentTimeMillis() / 1000);
        auVar.Z("obj_name", this.eKP.eKy);
        auVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eKP.eKz);
        auVar.f("obj_id", this.eKP.channelId);
        TiebaStatic.log(auVar);
    }
}

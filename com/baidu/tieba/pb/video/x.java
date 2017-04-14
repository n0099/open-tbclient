package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w evt;
    private final /* synthetic */ s evu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, s sVar) {
        this.evt = wVar;
        this.evu = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.evu == null) {
            return;
        }
        this.evt.nT(this.evu.threadId);
        as asVar = new as("c11927");
        asVar.s("obj_locate", this.evu.position);
        asVar.aa("tid", this.evu.threadId);
        asVar.g("fid", this.evu.forumId);
        asVar.aa("obj_param1", this.evu.evf);
        asVar.aa("obj_param2", "1");
        asVar.g("obj_param3", System.currentTimeMillis() / 1000);
        asVar.aa("obj_name", this.evu.evd);
        asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.evu.eve);
        asVar.g("obj_id", this.evu.channelId);
        TiebaStatic.log(asVar);
    }
}

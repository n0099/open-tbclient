package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w exn;
    private final /* synthetic */ s exo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, s sVar) {
        this.exn = wVar;
        this.exo = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exo == null) {
            return;
        }
        this.exn.nP(this.exo.threadId);
        as asVar = new as("c11927");
        asVar.s("obj_locate", this.exo.position);
        asVar.Z("tid", this.exo.threadId);
        asVar.g("fid", this.exo.forumId);
        asVar.Z("obj_param1", this.exo.ewZ);
        asVar.Z("obj_param2", "1");
        asVar.g("obj_param3", System.currentTimeMillis() / 1000);
        asVar.Z("obj_name", this.exo.ewX);
        asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.exo.ewY);
        asVar.g("obj_id", this.exo.channelId);
        TiebaStatic.log(asVar);
    }
}

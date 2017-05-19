package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ z etu;
    private final /* synthetic */ v etv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, v vVar) {
        this.etu = zVar;
        this.etv = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.etv == null) {
            return;
        }
        this.etu.oa(this.etv.threadId);
        as asVar = new as("c11927");
        asVar.s("obj_locate", this.etv.position);
        asVar.aa("tid", this.etv.threadId);
        asVar.g("fid", this.etv.forumId);
        asVar.aa("obj_param1", this.etv.etg);
        asVar.aa("obj_param2", "1");
        asVar.g("obj_param3", System.currentTimeMillis() / 1000);
        asVar.aa("obj_name", this.etv.ete);
        asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.etv.etf);
        asVar.g("obj_id", this.etv.channelId);
        TiebaStatic.log(asVar);
    }
}

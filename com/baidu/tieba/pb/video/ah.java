package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ ag eBq;
    private final /* synthetic */ ac eBr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, ac acVar) {
        this.eBq = agVar;
        this.eBr = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eBr == null) {
            return;
        }
        this.eBq.op(this.eBr.threadId);
        as asVar = new as("c11927");
        asVar.r("obj_locate", this.eBr.position);
        asVar.Z("tid", this.eBr.threadId);
        asVar.f("fid", this.eBr.forumId);
        asVar.Z("obj_param1", this.eBr.eBc);
        asVar.Z("obj_param2", "1");
        asVar.f("obj_param3", System.currentTimeMillis() / 1000);
        asVar.Z("obj_name", this.eBr.eBa);
        asVar.Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.eBr.eBb);
        asVar.f("obj_id", this.eBr.channelId);
        TiebaStatic.log(asVar);
    }
}

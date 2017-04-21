package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ w exK;
    private final /* synthetic */ s exL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, s sVar) {
        this.exK = wVar;
        this.exL = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.exL == null) {
            return;
        }
        this.exK.nU(this.exL.threadId);
        as asVar = new as("c11927");
        asVar.s("obj_locate", this.exL.position);
        asVar.aa("tid", this.exL.threadId);
        asVar.g("fid", this.exL.forumId);
        asVar.aa("obj_param1", this.exL.exw);
        asVar.aa("obj_param2", "1");
        asVar.g("obj_param3", System.currentTimeMillis() / 1000);
        asVar.aa("obj_name", this.exL.exu);
        asVar.aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.exL.exv);
        asVar.g("obj_id", this.exL.channelId);
        TiebaStatic.log(asVar);
    }
}

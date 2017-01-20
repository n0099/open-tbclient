package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p etS;
    private final /* synthetic */ l etT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, l lVar) {
        this.etS = pVar;
        this.etT = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.etT == null) {
            return;
        }
        this.etS.oH(this.etT.threadId);
        ar arVar = new ar("c11927");
        arVar.s("obj_locate", this.etT.position);
        arVar.ab("tid", this.etT.threadId);
        arVar.g("fid", this.etT.forumId);
        arVar.ab("obj_param1", this.etT.etE);
        arVar.ab("obj_param2", "1");
        arVar.g("obj_param3", System.currentTimeMillis() / 1000);
        arVar.ab("obj_name", this.etT.etC);
        arVar.ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.etT.etD);
        arVar.g("obj_id", this.etT.channelId);
        TiebaStatic.log(arVar);
    }
}

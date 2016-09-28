package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements c.b {
    final /* synthetic */ PbActivity eqa;
    private final /* synthetic */ SparseArray eqb;
    private final /* synthetic */ boolean eqc;
    private final /* synthetic */ String eqd;
    private final /* synthetic */ String eqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.eqa = pbActivity;
        this.eqb = sparseArray;
        this.eqc = z;
        this.eqd = str;
        this.eqe = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.eqb.get(r.g.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eqc;
                String str2 = this.eqd;
                String str3 = this.eqe;
                bdUniqueId = this.eqa.epu;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.eqb.get(r.g.tag_user_mute_thread_id), (String) this.eqb.get(r.g.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.eqa.epu;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.eqa.a(this.eqc, userMuteAddAndDelCustomMessage, this.eqe, str);
                break;
        }
        cVar.dismiss();
    }
}

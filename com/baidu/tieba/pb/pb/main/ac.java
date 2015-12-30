package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements c.b {
    final /* synthetic */ PbActivity cFS;
    private final /* synthetic */ SparseArray cFT;
    private final /* synthetic */ boolean cFU;
    private final /* synthetic */ String cFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cFS = pbActivity;
        this.cFT = sparseArray;
        this.cFU = z;
        this.cFV = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        dk dkVar;
        switch (i) {
            case 0:
                dkVar = this.cFS.cFq;
                dkVar.a(((Integer) this.cFT.get(n.g.tag_del_post_type)).intValue(), (String) this.cFT.get(n.g.tag_del_post_id), ((Integer) this.cFT.get(n.g.tag_manage_user_identity)).intValue(), ((Boolean) this.cFT.get(n.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.cFS.cFo;
                userMuteAddAndDelModel.a(this.cFU, this.cFV, (String) this.cFT.get(n.g.tag_user_mute_mute_username), (String) this.cFT.get(n.g.tag_user_mute_thread_id), (String) this.cFT.get(n.g.tag_user_mute_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

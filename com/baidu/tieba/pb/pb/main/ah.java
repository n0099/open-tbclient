package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements c.b {
    final /* synthetic */ PbActivity cNq;
    private final /* synthetic */ SparseArray cNr;
    private final /* synthetic */ boolean cNs;
    private final /* synthetic */ String cNt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cNq = pbActivity;
        this.cNr = sparseArray;
        this.cNs = z;
        this.cNt = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        dz dzVar;
        switch (i) {
            case 0:
                dzVar = this.cNq.cMK;
                dzVar.a(((Integer) this.cNr.get(t.g.tag_del_post_type)).intValue(), (String) this.cNr.get(t.g.tag_del_post_id), ((Integer) this.cNr.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) this.cNr.get(t.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.cNq.cMI;
                userMuteAddAndDelModel.a(this.cNs, this.cNt, (String) this.cNr.get(t.g.tag_user_mute_mute_username), (String) this.cNr.get(t.g.tag_user_mute_thread_id), (String) this.cNr.get(t.g.tag_user_mute_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

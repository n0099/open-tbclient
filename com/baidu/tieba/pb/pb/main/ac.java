package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements c.b {
    final /* synthetic */ PbActivity cCm;
    private final /* synthetic */ SparseArray cCn;
    private final /* synthetic */ boolean cCo;
    private final /* synthetic */ String cCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cCm = pbActivity;
        this.cCn = sparseArray;
        this.cCo = z;
        this.cCp = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        switch (i) {
            case 0:
                userMuteAddAndDelModel = this.cCm.cBJ;
                userMuteAddAndDelModel.a(this.cCo, this.cCp, (String) this.cCn.get(n.f.tag_user_mute_mute_username), (String) this.cCn.get(n.f.tag_user_mute_thread_id), (String) this.cCn.get(n.f.tag_user_mute_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

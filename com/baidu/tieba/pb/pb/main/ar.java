package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements c.b {
    final /* synthetic */ PbActivity djE;
    private final /* synthetic */ SparseArray djF;
    private final /* synthetic */ boolean djG;
    private final /* synthetic */ String djH;
    private final /* synthetic */ String djI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.djE = pbActivity;
        this.djF = sparseArray;
        this.djG = z;
        this.djH = str;
        this.djI = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        switch (i) {
            case 0:
                userMuteAddAndDelModel = this.djE.diP;
                userMuteAddAndDelModel.a(this.djG, this.djH, (String) this.djF.get(t.g.tag_user_mute_mute_username), (String) this.djF.get(t.g.tag_user_mute_thread_id), (String) this.djF.get(t.g.tag_user_mute_post_id), UserMuteAddAndDelModel.From.PB, this.djI);
                break;
        }
        cVar.dismiss();
    }
}

package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements c.b {
    final /* synthetic */ PbActivity dht;
    private final /* synthetic */ SparseArray dhw;
    private final /* synthetic */ boolean dhx;
    private final /* synthetic */ String dhy;
    private final /* synthetic */ String dhz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.dht = pbActivity;
        this.dhw = sparseArray;
        this.dhx = z;
        this.dhy = str;
        this.dhz = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        eu euVar;
        switch (i) {
            case 0:
                euVar = this.dht.dgF;
                euVar.a(((Integer) this.dhw.get(t.g.tag_del_post_type)).intValue(), (String) this.dhw.get(t.g.tag_del_post_id), ((Integer) this.dhw.get(t.g.tag_manage_user_identity)).intValue(), ((Boolean) this.dhw.get(t.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.dht.dgD;
                userMuteAddAndDelModel.a(this.dhx, this.dhy, (String) this.dhw.get(t.g.tag_user_mute_mute_username), (String) this.dhw.get(t.g.tag_user_mute_thread_id), (String) this.dhw.get(t.g.tag_user_mute_post_id), UserMuteAddAndDelModel.From.PB, this.dhz);
                break;
        }
        cVar.dismiss();
    }
}

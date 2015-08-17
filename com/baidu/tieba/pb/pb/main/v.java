package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ PbActivity cbo;
    private final /* synthetic */ SparseArray cbp;
    private final /* synthetic */ boolean cbq;
    private final /* synthetic */ String cbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cbo = pbActivity;
        this.cbp = sparseArray;
        this.cbq = z;
        this.cbr = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        cb cbVar;
        switch (i) {
            case 0:
                cbVar = this.cbo.caQ;
                cbVar.a(((Integer) this.cbp.get(i.f.tag_del_post_type)).intValue(), (String) this.cbp.get(i.f.tag_del_post_id), ((Integer) this.cbp.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) this.cbp.get(i.f.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.cbo.caO;
                userMuteAddAndDelModel.a(this.cbq, this.cbr, (String) this.cbp.get(i.f.tag_disable_reply_mute_username), (String) this.cbp.get(i.f.tag_disable_reply_thread_id), (String) this.cbp.get(i.f.tag_disable_reply_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    private final /* synthetic */ SparseArray ciA;
    private final /* synthetic */ boolean ciB;
    private final /* synthetic */ String ciC;
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.ciz = pbActivity;
        this.ciA = sparseArray;
        this.ciB = z;
        this.ciC = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        cc ccVar;
        switch (i) {
            case 0:
                ccVar = this.ciz.cia;
                ccVar.a(((Integer) this.ciA.get(i.f.tag_del_post_type)).intValue(), (String) this.ciA.get(i.f.tag_del_post_id), ((Integer) this.ciA.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) this.ciA.get(i.f.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.ciz.chY;
                userMuteAddAndDelModel.a(this.ciB, this.ciC, (String) this.ciA.get(i.f.tag_disable_reply_mute_username), (String) this.ciA.get(i.f.tag_disable_reply_thread_id), (String) this.ciA.get(i.f.tag_disable_reply_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

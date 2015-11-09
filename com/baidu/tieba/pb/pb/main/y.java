package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements c.b {
    final /* synthetic */ PbActivity cjN;
    private final /* synthetic */ SparseArray cjO;
    private final /* synthetic */ boolean cjP;
    private final /* synthetic */ String cjQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cjN = pbActivity;
        this.cjO = sparseArray;
        this.cjP = z;
        this.cjQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        ct ctVar;
        switch (i) {
            case 0:
                ctVar = this.cjN.cjo;
                ctVar.a(((Integer) this.cjO.get(i.f.tag_del_post_type)).intValue(), (String) this.cjO.get(i.f.tag_del_post_id), ((Integer) this.cjO.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) this.cjO.get(i.f.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.cjN.cjm;
                userMuteAddAndDelModel.a(this.cjP, this.cjQ, (String) this.cjO.get(i.f.tag_disable_reply_mute_username), (String) this.cjO.get(i.f.tag_disable_reply_thread_id), (String) this.cjO.get(i.f.tag_disable_reply_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

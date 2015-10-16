package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ PbActivity ciK;
    private final /* synthetic */ SparseArray ciL;
    private final /* synthetic */ boolean ciM;
    private final /* synthetic */ String ciN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.ciK = pbActivity;
        this.ciL = sparseArray;
        this.ciM = z;
        this.ciN = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        cc ccVar;
        switch (i) {
            case 0:
                ccVar = this.ciK.cim;
                ccVar.a(((Integer) this.ciL.get(i.f.tag_del_post_type)).intValue(), (String) this.ciL.get(i.f.tag_del_post_id), ((Integer) this.ciL.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) this.ciL.get(i.f.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.ciK.cik;
                userMuteAddAndDelModel.a(this.ciM, this.ciN, (String) this.ciL.get(i.f.tag_disable_reply_mute_username), (String) this.ciL.get(i.f.tag_disable_reply_thread_id), (String) this.ciL.get(i.f.tag_disable_reply_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

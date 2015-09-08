package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements c.b {
    final /* synthetic */ PbActivity ccj;
    private final /* synthetic */ SparseArray cck;
    private final /* synthetic */ boolean ccl;
    private final /* synthetic */ String ccm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str) {
        this.ccj = pbActivity;
        this.cck = sparseArray;
        this.ccl = z;
        this.ccm = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        cb cbVar;
        switch (i) {
            case 0:
                cbVar = this.ccj.cbL;
                cbVar.a(((Integer) this.cck.get(i.f.tag_del_post_type)).intValue(), (String) this.cck.get(i.f.tag_del_post_id), ((Integer) this.cck.get(i.f.tag_manage_user_identity)).intValue(), ((Boolean) this.cck.get(i.f.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                userMuteAddAndDelModel = this.ccj.cbJ;
                userMuteAddAndDelModel.a(this.ccl, this.ccm, (String) this.cck.get(i.f.tag_disable_reply_mute_username), (String) this.cck.get(i.f.tag_disable_reply_thread_id), (String) this.cck.get(i.f.tag_disable_reply_post_id), UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

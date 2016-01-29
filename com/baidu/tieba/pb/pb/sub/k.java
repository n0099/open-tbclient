package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ SparseArray cNr;
    private final /* synthetic */ boolean cNs;
    private final /* synthetic */ String cNt;
    final /* synthetic */ NewSubPbActivity cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cTK = newSubPbActivity;
        this.cNr = sparseArray;
        this.cNs = z;
        this.cNt = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        w wVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.cNr.get(t.g.tag_del_post_type) instanceof Integer ? ((Integer) this.cNr.get(t.g.tag_del_post_type)).intValue() : 0;
                if (this.cNr.get(t.g.tag_del_post_id) instanceof String) {
                    str = (String) this.cNr.get(t.g.tag_del_post_id);
                }
                int intValue2 = this.cNr.get(t.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.cNr.get(t.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.cNr.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.cNr.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                wVar = this.cTK.cTB;
                wVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.cNr.get(t.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.cNr.get(t.g.tag_user_mute_mute_username);
                }
                if (this.cNr.get(t.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.cNr.get(t.g.tag_user_mute_thread_id);
                }
                if (this.cNr.get(t.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.cNr.get(t.g.tag_user_mute_post_id);
                }
                userMuteAddAndDelModel = this.cTK.cMI;
                userMuteAddAndDelModel.a(this.cNs, this.cNt, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

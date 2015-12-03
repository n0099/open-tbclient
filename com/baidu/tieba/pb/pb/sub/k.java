package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ SparseArray cCn;
    private final /* synthetic */ boolean cCo;
    private final /* synthetic */ String cCp;
    final /* synthetic */ NewSubPbActivity cHd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cHd = newSubPbActivity;
        this.cCn = sparseArray;
        this.cCo = z;
        this.cCp = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        w wVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.cCn.get(n.f.tag_del_post_type) instanceof Integer ? ((Integer) this.cCn.get(n.f.tag_del_post_type)).intValue() : 0;
                if (this.cCn.get(n.f.tag_del_post_id) instanceof String) {
                    str = (String) this.cCn.get(n.f.tag_del_post_id);
                }
                int intValue2 = this.cCn.get(n.f.tag_manage_user_identity) instanceof Integer ? ((Integer) this.cCn.get(n.f.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.cCn.get(n.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.cCn.get(n.f.tag_del_post_is_self)).booleanValue() : false;
                wVar = this.cHd.cGU;
                wVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.cCn.get(n.f.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.cCn.get(n.f.tag_user_mute_mute_username);
                }
                if (this.cCn.get(n.f.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.cCn.get(n.f.tag_user_mute_thread_id);
                }
                if (this.cCn.get(n.f.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.cCn.get(n.f.tag_user_mute_post_id);
                }
                userMuteAddAndDelModel = this.cHd.cBJ;
                userMuteAddAndDelModel.a(this.cCo, this.cCp, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

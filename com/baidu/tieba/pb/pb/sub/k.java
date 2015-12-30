package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.n;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ SparseArray cFT;
    private final /* synthetic */ boolean cFU;
    private final /* synthetic */ String cFV;
    final /* synthetic */ NewSubPbActivity cLc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cLc = newSubPbActivity;
        this.cFT = sparseArray;
        this.cFU = z;
        this.cFV = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        w wVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.cFT.get(n.g.tag_del_post_type) instanceof Integer ? ((Integer) this.cFT.get(n.g.tag_del_post_type)).intValue() : 0;
                if (this.cFT.get(n.g.tag_del_post_id) instanceof String) {
                    str = (String) this.cFT.get(n.g.tag_del_post_id);
                }
                int intValue2 = this.cFT.get(n.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.cFT.get(n.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.cFT.get(n.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.cFT.get(n.g.tag_del_post_is_self)).booleanValue() : false;
                wVar = this.cLc.cKT;
                wVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.cFT.get(n.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.cFT.get(n.g.tag_user_mute_mute_username);
                }
                if (this.cFT.get(n.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.cFT.get(n.g.tag_user_mute_thread_id);
                }
                if (this.cFT.get(n.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.cFT.get(n.g.tag_user_mute_post_id);
                }
                userMuteAddAndDelModel = this.cLc.cFo;
                userMuteAddAndDelModel.a(this.cFU, this.cFV, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

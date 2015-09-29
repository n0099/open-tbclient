package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements c.b {
    private final /* synthetic */ SparseArray ciA;
    private final /* synthetic */ boolean ciB;
    private final /* synthetic */ String ciC;
    final /* synthetic */ NewSubPbActivity cmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cmr = newSubPbActivity;
        this.ciA = sparseArray;
        this.ciB = z;
        this.ciC = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        t tVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.ciA.get(i.f.tag_del_post_type) instanceof Integer ? ((Integer) this.ciA.get(i.f.tag_del_post_type)).intValue() : 0;
                if (this.ciA.get(i.f.tag_del_post_id) instanceof String) {
                    str = (String) this.ciA.get(i.f.tag_del_post_id);
                }
                int intValue2 = this.ciA.get(i.f.tag_manage_user_identity) instanceof Integer ? ((Integer) this.ciA.get(i.f.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.ciA.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.ciA.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                tVar = this.cmr.cmk;
                tVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.ciA.get(i.f.tag_disable_reply_mute_username) instanceof String) {
                    str2 = (String) this.ciA.get(i.f.tag_disable_reply_mute_username);
                }
                if (this.ciA.get(i.f.tag_disable_reply_thread_id) instanceof String) {
                    str3 = (String) this.ciA.get(i.f.tag_disable_reply_thread_id);
                }
                if (this.ciA.get(i.f.tag_disable_reply_post_id) instanceof String) {
                    str4 = (String) this.ciA.get(i.f.tag_disable_reply_post_id);
                }
                userMuteAddAndDelModel = this.cmr.chY;
                userMuteAddAndDelModel.a(this.ciB, this.ciC, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

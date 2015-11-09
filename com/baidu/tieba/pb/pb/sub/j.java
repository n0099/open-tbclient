package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.i;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c.b {
    private final /* synthetic */ SparseArray cjO;
    private final /* synthetic */ boolean cjP;
    private final /* synthetic */ String cjQ;
    final /* synthetic */ NewSubPbActivity cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.cnS = newSubPbActivity;
        this.cjO = sparseArray;
        this.cjP = z;
        this.cjQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void itemClick(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        v vVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.cjO.get(i.f.tag_del_post_type) instanceof Integer ? ((Integer) this.cjO.get(i.f.tag_del_post_type)).intValue() : 0;
                if (this.cjO.get(i.f.tag_del_post_id) instanceof String) {
                    str = (String) this.cjO.get(i.f.tag_del_post_id);
                }
                int intValue2 = this.cjO.get(i.f.tag_manage_user_identity) instanceof Integer ? ((Integer) this.cjO.get(i.f.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.cjO.get(i.f.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.cjO.get(i.f.tag_del_post_is_self)).booleanValue() : false;
                vVar = this.cnS.cnJ;
                vVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                if (this.cjO.get(i.f.tag_disable_reply_mute_username) instanceof String) {
                    str2 = (String) this.cjO.get(i.f.tag_disable_reply_mute_username);
                }
                if (this.cjO.get(i.f.tag_disable_reply_thread_id) instanceof String) {
                    str3 = (String) this.cjO.get(i.f.tag_disable_reply_thread_id);
                }
                if (this.cjO.get(i.f.tag_disable_reply_post_id) instanceof String) {
                    str4 = (String) this.cjO.get(i.f.tag_disable_reply_post_id);
                }
                userMuteAddAndDelModel = this.cnS.cjm;
                userMuteAddAndDelModel.a(this.cjP, this.cjQ, str2, str3, str4, UserMuteAddAndDelModel.From.PB);
                break;
        }
        cVar.dismiss();
    }
}

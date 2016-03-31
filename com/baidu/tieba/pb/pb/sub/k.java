package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ SparseArray dhw;
    private final /* synthetic */ boolean dhx;
    private final /* synthetic */ String dhy;
    final /* synthetic */ NewSubPbActivity doF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.doF = newSubPbActivity;
        this.dhw = sparseArray;
        this.dhx = z;
        this.dhy = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        x xVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.dhw.get(t.g.tag_del_post_type) instanceof Integer ? ((Integer) this.dhw.get(t.g.tag_del_post_type)).intValue() : 0;
                if (this.dhw.get(t.g.tag_del_post_id) instanceof String) {
                    str = (String) this.dhw.get(t.g.tag_del_post_id);
                }
                int intValue2 = this.dhw.get(t.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.dhw.get(t.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.dhw.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.dhw.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                xVar = this.doF.dow;
                xVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.dhw.get(t.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.dhw.get(t.g.tag_user_mute_mute_username);
                }
                if (this.dhw.get(t.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.dhw.get(t.g.tag_user_mute_thread_id);
                }
                if (this.dhw.get(t.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.dhw.get(t.g.tag_user_mute_post_id);
                }
                if (this.dhw.get(t.g.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.dhw.get(t.g.tag_user_mute_msg);
                }
                userMuteAddAndDelModel = this.doF.dgD;
                userMuteAddAndDelModel.a(this.dhx, this.dhy, str2, str3, str4, UserMuteAddAndDelModel.From.PB, str5);
                break;
        }
        cVar.dismiss();
    }
}

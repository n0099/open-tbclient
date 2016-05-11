package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements c.b {
    private final /* synthetic */ SparseArray djF;
    private final /* synthetic */ boolean djG;
    private final /* synthetic */ String djH;
    final /* synthetic */ NewSubPbActivity dqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.dqn = newSubPbActivity;
        this.djF = sparseArray;
        this.djG = z;
        this.djH = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        UserMuteAddAndDelModel userMuteAddAndDelModel;
        y yVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.djF.get(t.g.tag_del_post_type) instanceof Integer ? ((Integer) this.djF.get(t.g.tag_del_post_type)).intValue() : 0;
                if (this.djF.get(t.g.tag_del_post_id) instanceof String) {
                    str = (String) this.djF.get(t.g.tag_del_post_id);
                }
                int intValue2 = this.djF.get(t.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.djF.get(t.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.djF.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.djF.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                yVar = this.dqn.dqe;
                yVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.djF.get(t.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.djF.get(t.g.tag_user_mute_mute_username);
                }
                if (this.djF.get(t.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.djF.get(t.g.tag_user_mute_thread_id);
                }
                if (this.djF.get(t.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.djF.get(t.g.tag_user_mute_post_id);
                }
                if (this.djF.get(t.g.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.djF.get(t.g.tag_user_mute_msg);
                }
                userMuteAddAndDelModel = this.dqn.diP;
                userMuteAddAndDelModel.a(this.djG, this.djH, str2, str3, str4, UserMuteAddAndDelModel.From.PB, str5);
                break;
        }
        cVar.dismiss();
    }
}

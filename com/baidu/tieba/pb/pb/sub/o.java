package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c.b {
    private final /* synthetic */ SparseArray eqb;
    private final /* synthetic */ boolean eqc;
    private final /* synthetic */ String eqd;
    final /* synthetic */ NewSubPbActivity exF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.exF = newSubPbActivity;
        this.eqb = sparseArray;
        this.eqc = z;
        this.eqd = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ag agVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.eqb.get(r.g.tag_del_post_type) instanceof Integer ? ((Integer) this.eqb.get(r.g.tag_del_post_type)).intValue() : 0;
                if (this.eqb.get(r.g.tag_del_post_id) instanceof String) {
                    str = (String) this.eqb.get(r.g.tag_del_post_id);
                }
                int intValue2 = this.eqb.get(r.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.eqb.get(r.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.eqb.get(r.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.eqb.get(r.g.tag_del_post_is_self)).booleanValue() : false;
                agVar = this.exF.exu;
                agVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.eqb.get(r.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.eqb.get(r.g.tag_user_mute_mute_username);
                }
                if (this.eqb.get(r.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.eqb.get(r.g.tag_user_mute_thread_id);
                }
                if (this.eqb.get(r.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.eqb.get(r.g.tag_user_mute_post_id);
                }
                if (this.eqb.get(r.g.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.eqb.get(r.g.tag_user_mute_msg);
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eqc;
                String str6 = this.eqd;
                bdUniqueId = this.exF.exD;
                userMuteAddAndDelCustomMessage.setData(z, str6, str2, str3, str4, 1, str5, bdUniqueId);
                bdUniqueId2 = this.exF.exD;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.exF.a(this.eqc, userMuteAddAndDelCustomMessage, str5, str2);
                break;
        }
        cVar.dismiss();
    }
}

package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements c.b {
    private final /* synthetic */ SparseArray eoc;
    private final /* synthetic */ boolean eod;
    private final /* synthetic */ String eoe;
    final /* synthetic */ NewSubPbActivity evy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.evy = newSubPbActivity;
        this.eoc = sparseArray;
        this.eod = z;
        this.eoe = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ag agVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.eoc.get(t.g.tag_del_post_type) instanceof Integer ? ((Integer) this.eoc.get(t.g.tag_del_post_type)).intValue() : 0;
                if (this.eoc.get(t.g.tag_del_post_id) instanceof String) {
                    str = (String) this.eoc.get(t.g.tag_del_post_id);
                }
                int intValue2 = this.eoc.get(t.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.eoc.get(t.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.eoc.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.eoc.get(t.g.tag_del_post_is_self)).booleanValue() : false;
                agVar = this.evy.evn;
                agVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.eoc.get(t.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.eoc.get(t.g.tag_user_mute_mute_username);
                }
                if (this.eoc.get(t.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.eoc.get(t.g.tag_user_mute_thread_id);
                }
                if (this.eoc.get(t.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.eoc.get(t.g.tag_user_mute_post_id);
                }
                if (this.eoc.get(t.g.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.eoc.get(t.g.tag_user_mute_msg);
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eod;
                String str6 = this.eoe;
                bdUniqueId = this.evy.evw;
                userMuteAddAndDelCustomMessage.setData(z, str6, str2, str3, str4, 1, str5, bdUniqueId);
                bdUniqueId2 = this.evy.evw;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.evy.a(this.eod, userMuteAddAndDelCustomMessage, str5, str2);
                break;
        }
        cVar.dismiss();
    }
}

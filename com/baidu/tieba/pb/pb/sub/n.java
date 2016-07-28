package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements c.b {
    private final /* synthetic */ SparseArray ebU;
    private final /* synthetic */ boolean ebV;
    private final /* synthetic */ String ebW;
    final /* synthetic */ NewSubPbActivity ejr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.ejr = newSubPbActivity;
        this.ebU = sparseArray;
        this.ebV = z;
        this.ebW = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        af afVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.ebU.get(u.g.tag_del_post_type) instanceof Integer ? ((Integer) this.ebU.get(u.g.tag_del_post_type)).intValue() : 0;
                if (this.ebU.get(u.g.tag_del_post_id) instanceof String) {
                    str = (String) this.ebU.get(u.g.tag_del_post_id);
                }
                int intValue2 = this.ebU.get(u.g.tag_manage_user_identity) instanceof Integer ? ((Integer) this.ebU.get(u.g.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.ebU.get(u.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.ebU.get(u.g.tag_del_post_is_self)).booleanValue() : false;
                afVar = this.ejr.ejg;
                afVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.ebU.get(u.g.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.ebU.get(u.g.tag_user_mute_mute_username);
                }
                if (this.ebU.get(u.g.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.ebU.get(u.g.tag_user_mute_thread_id);
                }
                if (this.ebU.get(u.g.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.ebU.get(u.g.tag_user_mute_post_id);
                }
                if (this.ebU.get(u.g.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.ebU.get(u.g.tag_user_mute_msg);
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.ebV;
                String str6 = this.ebW;
                bdUniqueId = this.ejr.ejp;
                userMuteAddAndDelCustomMessage.setData(z, str6, str2, str3, str4, 1, str5, bdUniqueId);
                bdUniqueId2 = this.ejr.ejp;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.ejr.a(this.ebV, userMuteAddAndDelCustomMessage, str5, str2);
                break;
        }
        cVar.dismiss();
    }
}

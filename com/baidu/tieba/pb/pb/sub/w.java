package com.baidu.tieba.pb.pb.sub;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements c.b {
    private final /* synthetic */ SparseArray elP;
    private final /* synthetic */ boolean elQ;
    private final /* synthetic */ String elR;
    final /* synthetic */ NewSubPbActivity euQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.euQ = newSubPbActivity;
        this.elP = sparseArray;
        this.elQ = z;
        this.elR = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ao aoVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.elP.get(w.h.tag_del_post_type) instanceof Integer ? ((Integer) this.elP.get(w.h.tag_del_post_type)).intValue() : 0;
                if (this.elP.get(w.h.tag_del_post_id) instanceof String) {
                    str = (String) this.elP.get(w.h.tag_del_post_id);
                }
                int intValue2 = this.elP.get(w.h.tag_manage_user_identity) instanceof Integer ? ((Integer) this.elP.get(w.h.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.elP.get(w.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.elP.get(w.h.tag_del_post_is_self)).booleanValue() : false;
                aoVar = this.euQ.euB;
                aoVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.elP.get(w.h.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.elP.get(w.h.tag_user_mute_mute_username);
                }
                if (this.elP.get(w.h.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.elP.get(w.h.tag_user_mute_thread_id);
                }
                if (this.elP.get(w.h.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.elP.get(w.h.tag_user_mute_post_id);
                }
                if (this.elP.get(w.h.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.elP.get(w.h.tag_user_mute_msg);
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.elQ;
                String str6 = this.elR;
                bdUniqueId = this.euQ.euL;
                userMuteAddAndDelCustomMessage.setData(z, str6, str2, str3, str4, 1, str5, bdUniqueId);
                bdUniqueId2 = this.euQ.euL;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.euQ.a(this.elQ, userMuteAddAndDelCustomMessage, str5, str2);
                break;
        }
        cVar.dismiss();
    }
}

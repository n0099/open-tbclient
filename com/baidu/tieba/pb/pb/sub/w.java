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
public class w implements c.b {
    private final /* synthetic */ SparseArray eiW;
    private final /* synthetic */ boolean eiX;
    private final /* synthetic */ String eiY;
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
        this.erC = newSubPbActivity;
        this.eiW = sparseArray;
        this.eiX = z;
        this.eiY = str;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ao aoVar;
        switch (i) {
            case 0:
                String str = "";
                int intValue = this.eiW.get(r.h.tag_del_post_type) instanceof Integer ? ((Integer) this.eiW.get(r.h.tag_del_post_type)).intValue() : 0;
                if (this.eiW.get(r.h.tag_del_post_id) instanceof String) {
                    str = (String) this.eiW.get(r.h.tag_del_post_id);
                }
                int intValue2 = this.eiW.get(r.h.tag_manage_user_identity) instanceof Integer ? ((Integer) this.eiW.get(r.h.tag_manage_user_identity)).intValue() : 0;
                boolean booleanValue = this.eiW.get(r.h.tag_del_post_is_self) instanceof Boolean ? ((Boolean) this.eiW.get(r.h.tag_del_post_is_self)).booleanValue() : false;
                aoVar = this.erC.ern;
                aoVar.a(intValue, str, intValue2, booleanValue);
                break;
            case 1:
                String str2 = "";
                String str3 = "";
                String str4 = "";
                String str5 = "";
                if (this.eiW.get(r.h.tag_user_mute_mute_username) instanceof String) {
                    str2 = (String) this.eiW.get(r.h.tag_user_mute_mute_username);
                }
                if (this.eiW.get(r.h.tag_user_mute_thread_id) instanceof String) {
                    str3 = (String) this.eiW.get(r.h.tag_user_mute_thread_id);
                }
                if (this.eiW.get(r.h.tag_user_mute_post_id) instanceof String) {
                    str4 = (String) this.eiW.get(r.h.tag_user_mute_post_id);
                }
                if (this.eiW.get(r.h.tag_user_mute_msg) instanceof String) {
                    str5 = (String) this.eiW.get(r.h.tag_user_mute_msg);
                }
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eiX;
                String str6 = this.eiY;
                bdUniqueId = this.erC.erx;
                userMuteAddAndDelCustomMessage.setData(z, str6, str2, str3, str4, 1, str5, bdUniqueId);
                bdUniqueId2 = this.erC.erx;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.erC.a(this.eiX, userMuteAddAndDelCustomMessage, str5, str2);
                break;
        }
        cVar.dismiss();
    }
}

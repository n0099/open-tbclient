package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements c.b {
    final /* synthetic */ PbActivity emk;
    private final /* synthetic */ SparseArray eml;
    private final /* synthetic */ boolean emm;
    private final /* synthetic */ String emn;
    private final /* synthetic */ String emo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.emk = pbActivity;
        this.eml = sparseArray;
        this.emm = z;
        this.emn = str;
        this.emo = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ey eyVar;
        switch (i) {
            case 0:
                eyVar = this.emk.eli;
                eyVar.a(((Integer) this.eml.get(w.h.tag_del_post_type)).intValue(), (String) this.eml.get(w.h.tag_del_post_id), ((Integer) this.eml.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) this.eml.get(w.h.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.eml.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.emm;
                String str2 = this.emn;
                String str3 = this.emo;
                bdUniqueId = this.emk.elz;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.eml.get(w.h.tag_user_mute_thread_id), (String) this.eml.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.emk.elz;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.emk.a(this.emm, userMuteAddAndDelCustomMessage, this.emo, str);
                break;
        }
        cVar.dismiss();
    }
}

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
public class aw implements c.b {
    private final /* synthetic */ boolean ehA;
    private final /* synthetic */ String ehB;
    private final /* synthetic */ String ehC;
    final /* synthetic */ PbActivity ehy;
    private final /* synthetic */ SparseArray ehz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.ehy = pbActivity;
        this.ehz = sparseArray;
        this.ehA = z;
        this.ehB = str;
        this.ehC = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        fm fmVar;
        switch (i) {
            case 0:
                fmVar = this.ehy.egt;
                fmVar.a(((Integer) this.ehz.get(w.h.tag_del_post_type)).intValue(), (String) this.ehz.get(w.h.tag_del_post_id), ((Integer) this.ehz.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) this.ehz.get(w.h.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.ehz.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.ehA;
                String str2 = this.ehB;
                String str3 = this.ehC;
                bdUniqueId = this.ehy.egL;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.ehz.get(w.h.tag_user_mute_thread_id), (String) this.ehz.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.ehy.egL;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.ehy.a(this.ehA, userMuteAddAndDelCustomMessage, this.ehC, str);
                break;
        }
        cVar.dismiss();
    }
}

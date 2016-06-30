package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements c.b {
    final /* synthetic */ PbActivity dPF;
    private final /* synthetic */ SparseArray dPG;
    private final /* synthetic */ boolean dPH;
    private final /* synthetic */ String dPI;
    private final /* synthetic */ String dPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.dPF = pbActivity;
        this.dPG = sparseArray;
        this.dPH = z;
        this.dPI = str;
        this.dPJ = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        es esVar;
        switch (i) {
            case 0:
                esVar = this.dPF.dOO;
                esVar.a(((Integer) this.dPG.get(u.g.tag_del_post_type)).intValue(), (String) this.dPG.get(u.g.tag_del_post_id), ((Integer) this.dPG.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) this.dPG.get(u.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.dPG.get(u.g.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.dPH;
                String str2 = this.dPI;
                String str3 = this.dPJ;
                bdUniqueId = this.dPF.dPc;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.dPG.get(u.g.tag_user_mute_thread_id), (String) this.dPG.get(u.g.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.dPF.dPc;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.dPF.a(this.dPH, userMuteAddAndDelCustomMessage, this.dPJ, str);
                break;
        }
        cVar.dismiss();
    }
}

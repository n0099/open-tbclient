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
public class bb implements c.b {
    final /* synthetic */ PbActivity enc;
    private final /* synthetic */ SparseArray ene;
    private final /* synthetic */ boolean enf;
    private final /* synthetic */ String eng;
    private final /* synthetic */ String enh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.enc = pbActivity;
        this.ene = sparseArray;
        this.enf = z;
        this.eng = str;
        this.enh = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        fx fxVar;
        switch (i) {
            case 0:
                fxVar = this.enc.elU;
                fxVar.a(((Integer) this.ene.get(w.h.tag_del_post_type)).intValue(), (String) this.ene.get(w.h.tag_del_post_id), ((Integer) this.ene.get(w.h.tag_manage_user_identity)).intValue(), ((Boolean) this.ene.get(w.h.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.ene.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.enf;
                String str2 = this.eng;
                String str3 = this.enh;
                bdUniqueId = this.enc.emm;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.ene.get(w.h.tag_user_mute_thread_id), (String) this.ene.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.enc.emm;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.enc.a(this.enf, userMuteAddAndDelCustomMessage, this.enh, str);
                break;
        }
        cVar.dismiss();
    }
}

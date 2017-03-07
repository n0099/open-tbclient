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
    final /* synthetic */ PbActivity elO;
    private final /* synthetic */ SparseArray elP;
    private final /* synthetic */ boolean elQ;
    private final /* synthetic */ String elR;
    private final /* synthetic */ String elS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.elO = pbActivity;
        this.elP = sparseArray;
        this.elQ = z;
        this.elR = str;
        this.elS = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.elP.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.elQ;
                String str2 = this.elR;
                String str3 = this.elS;
                bdUniqueId = this.elO.eld;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.elP.get(w.h.tag_user_mute_thread_id), (String) this.elP.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.elO.eld;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.elO.a(this.elQ, userMuteAddAndDelCustomMessage, this.elS, str);
                break;
        }
        cVar.dismiss();
    }
}

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
    final /* synthetic */ PbActivity ejU;
    private final /* synthetic */ SparseArray ejV;
    private final /* synthetic */ boolean ejW;
    private final /* synthetic */ String ejX;
    private final /* synthetic */ String ejY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.ejU = pbActivity;
        this.ejV = sparseArray;
        this.ejW = z;
        this.ejX = str;
        this.ejY = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.ejV.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.ejW;
                String str2 = this.ejX;
                String str3 = this.ejY;
                bdUniqueId = this.ejU.ejj;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.ejV.get(w.h.tag_user_mute_thread_id), (String) this.ejV.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.ejU.ejj;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.ejU.a(this.ejW, userMuteAddAndDelCustomMessage, this.ejY, str);
                break;
        }
        cVar.dismiss();
    }
}

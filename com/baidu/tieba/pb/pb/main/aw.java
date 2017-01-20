package com.baidu.tieba.pb.pb.main;

import android.util.SparseArray;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements c.b {
    final /* synthetic */ PbActivity eiV;
    private final /* synthetic */ SparseArray eiW;
    private final /* synthetic */ boolean eiX;
    private final /* synthetic */ String eiY;
    private final /* synthetic */ String eiZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.eiV = pbActivity;
        this.eiW = sparseArray;
        this.eiX = z;
        this.eiY = str;
        this.eiZ = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.eiW.get(r.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eiX;
                String str2 = this.eiY;
                String str3 = this.eiZ;
                bdUniqueId = this.eiV.eim;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.eiW.get(r.h.tag_user_mute_thread_id), (String) this.eiW.get(r.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.eiV.eim;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.eiV.a(this.eiX, userMuteAddAndDelCustomMessage, this.eiZ, str);
                break;
        }
        cVar.dismiss();
    }
}

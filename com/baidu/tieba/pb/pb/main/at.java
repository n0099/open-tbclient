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
    final /* synthetic */ PbActivity ebT;
    private final /* synthetic */ SparseArray ebU;
    private final /* synthetic */ boolean ebV;
    private final /* synthetic */ String ebW;
    private final /* synthetic */ String ebX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.ebT = pbActivity;
        this.ebU = sparseArray;
        this.ebV = z;
        this.ebW = str;
        this.ebX = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ew ewVar;
        switch (i) {
            case 0:
                ewVar = this.ebT.ebb;
                ewVar.a(((Integer) this.ebU.get(u.g.tag_del_post_type)).intValue(), (String) this.ebU.get(u.g.tag_del_post_id), ((Integer) this.ebU.get(u.g.tag_manage_user_identity)).intValue(), ((Boolean) this.ebU.get(u.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.ebU.get(u.g.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.ebV;
                String str2 = this.ebW;
                String str3 = this.ebX;
                bdUniqueId = this.ebT.ebp;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.ebU.get(u.g.tag_user_mute_thread_id), (String) this.ebU.get(u.g.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.ebT.ebp;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.ebT.a(this.ebV, userMuteAddAndDelCustomMessage, this.ebX, str);
                break;
        }
        cVar.dismiss();
    }
}

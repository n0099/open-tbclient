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
public class av implements c.b {
    final /* synthetic */ PbActivity evL;
    private final /* synthetic */ SparseArray evM;
    private final /* synthetic */ boolean evN;
    private final /* synthetic */ String evO;
    private final /* synthetic */ String evP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.evL = pbActivity;
        this.evM = sparseArray;
        this.evN = z;
        this.evO = str;
        this.evP = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        ey eyVar;
        switch (i) {
            case 0:
                eyVar = this.evL.euP;
                eyVar.a(((Integer) this.evM.get(r.g.tag_del_post_type)).intValue(), (String) this.evM.get(r.g.tag_del_post_id), ((Integer) this.evM.get(r.g.tag_manage_user_identity)).intValue(), ((Boolean) this.evM.get(r.g.tag_del_post_is_self)).booleanValue());
                break;
            case 1:
                String str = (String) this.evM.get(r.g.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.evN;
                String str2 = this.evO;
                String str3 = this.evP;
                bdUniqueId = this.evL.evg;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.evM.get(r.g.tag_user_mute_thread_id), (String) this.evM.get(r.g.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.evL.evg;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.evL.a(this.evN, userMuteAddAndDelCustomMessage, this.evP, str);
                break;
        }
        cVar.dismiss();
    }
}

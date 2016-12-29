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
    final /* synthetic */ PbActivity eah;
    private final /* synthetic */ SparseArray eai;
    private final /* synthetic */ boolean eaj;
    private final /* synthetic */ String eak;
    private final /* synthetic */ String eal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.eah = pbActivity;
        this.eai = sparseArray;
        this.eaj = z;
        this.eak = str;
        this.eal = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.eai.get(r.g.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.eaj;
                String str2 = this.eak;
                String str3 = this.eal;
                bdUniqueId = this.eah.dZB;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.eai.get(r.g.tag_user_mute_thread_id), (String) this.eai.get(r.g.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.eah.dZB;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.eah.a(this.eaj, userMuteAddAndDelCustomMessage, this.eal, str);
                break;
        }
        cVar.dismiss();
    }
}

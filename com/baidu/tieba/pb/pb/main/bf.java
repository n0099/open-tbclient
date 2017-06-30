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
public class bf implements c.b {
    final /* synthetic */ PbActivity ewh;
    private final /* synthetic */ SparseArray ewi;
    private final /* synthetic */ boolean ewj;
    private final /* synthetic */ String ewk;
    private final /* synthetic */ String ewl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(PbActivity pbActivity, SparseArray sparseArray, boolean z, String str, String str2) {
        this.ewh = pbActivity;
        this.ewi = sparseArray;
        this.ewj = z;
        this.ewk = str;
        this.ewl = str2;
    }

    @Override // com.baidu.tbadk.core.dialog.c.b
    public void a(com.baidu.tbadk.core.dialog.c cVar, int i, View view) {
        BdUniqueId bdUniqueId;
        BdUniqueId bdUniqueId2;
        switch (i) {
            case 0:
                String str = (String) this.ewi.get(w.h.tag_user_mute_mute_username);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                boolean z = this.ewj;
                String str2 = this.ewk;
                String str3 = this.ewl;
                bdUniqueId = this.ewh.evm;
                userMuteAddAndDelCustomMessage.setData(z, str2, str, (String) this.ewi.get(w.h.tag_user_mute_thread_id), (String) this.ewi.get(w.h.tag_user_mute_post_id), 1, str3, bdUniqueId);
                bdUniqueId2 = this.ewh.evm;
                userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
                this.ewh.a(this.ewj, userMuteAddAndDelCustomMessage, this.ewl, str);
                break;
        }
        cVar.dismiss();
    }
}

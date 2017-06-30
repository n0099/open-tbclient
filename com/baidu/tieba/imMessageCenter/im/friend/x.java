package com.baidu.tieba.imMessageCenter.im.friend;

import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class x implements TbCheckBox.a {
    final /* synthetic */ p dsU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar) {
        this.dsU = pVar;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        InviteFriendCandidateList inviteFriendCandidateList;
        InviteFriendListActivity inviteFriendListActivity;
        InviteFriendListActivity inviteFriendListActivity2;
        int i;
        this.dsU.axr();
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
            if (z) {
                int axs = this.dsU.axs();
                inviteFriendCandidateList = this.dsU.dsK;
                if (axs <= inviteFriendCandidateList.getItemLength()) {
                    inviteFriendListActivity = this.dsU.dsH;
                    inviteFriendListActivity2 = this.dsU.dsH;
                    String string = inviteFriendListActivity2.getPageContext().getString(w.l.invite_friend_exceed_max_count);
                    i = this.dsU.dsN;
                    inviteFriendListActivity.showToast(String.format(string, Integer.valueOf(i)));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.a) obj).setChecked(false);
                    return;
                }
                this.dsU.g((com.baidu.tbadk.coreExtra.relationship.a) obj);
                return;
            }
            this.dsU.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
        }
    }
}

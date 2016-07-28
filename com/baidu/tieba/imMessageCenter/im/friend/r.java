package com.baidu.tieba.imMessageCenter.im.friend;

import android.view.View;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements InviteFriendCandidateList.a {
    final /* synthetic */ p dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.dfx = pVar;
    }

    @Override // com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.a
    public void a(View view, Object obj) {
        BdListView bdListView;
        if (obj != null) {
            if (obj instanceof TbCheckBox.b) {
                ((TbCheckBox.b) obj).setChecked(false);
            }
            bdListView = this.dfx.zU;
            View findViewWithTag = bdListView.findViewWithTag(obj);
            if (findViewWithTag != null && (findViewWithTag instanceof TbCheckBox)) {
                ((TbCheckBox) findViewWithTag).setChecked(false);
            } else if (obj instanceof com.baidu.tbadk.coreExtra.relationship.a) {
                this.dfx.h((com.baidu.tbadk.coreExtra.relationship.a) obj);
            }
        }
    }
}

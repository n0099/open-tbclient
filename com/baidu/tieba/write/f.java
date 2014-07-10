package com.baidu.tieba.write;

import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.o
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.relationship.b)) {
            if (z) {
                atSelectFriendList = this.a.e;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((com.baidu.tbadk.coreExtra.relationship.b) obj).setChecked(false);
                    return;
                }
                this.a.a((com.baidu.tbadk.coreExtra.relationship.b) obj);
                return;
            }
            this.a.b((com.baidu.tbadk.coreExtra.relationship.b) obj);
        }
    }
}

package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* loaded from: classes.dex */
final class h implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.o
    public final void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.a.e;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.a.k.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.a.b((MetaData) obj);
                return;
            }
            this.a.c((MetaData) obj);
        }
    }
}

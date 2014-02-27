package com.baidu.tieba.write;

import com.baidu.tieba.data.MetaData;
import com.baidu.tieba.view.TbCheckBox;
import com.baidu.tieba.view.cq;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class h implements cq {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tieba.view.cq
    public final void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.a.e;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.a.showToast(String.format(this.a.getString(R.string.invite_friend_exceed_max_count), 5));
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.a.a((MetaData) obj);
                return;
            }
            this.a.b((MetaData) obj);
        }
    }
}

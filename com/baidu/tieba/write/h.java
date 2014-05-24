package com.baidu.tieba.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements com.baidu.tbadk.core.view.o {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.o
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.a.e;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.a.showToast(String.format(this.a.getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5));
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

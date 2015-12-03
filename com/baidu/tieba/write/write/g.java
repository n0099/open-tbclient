package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbCheckBox.a {
    final /* synthetic */ AtListActivity dPq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.dPq = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.dPq.dPe;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.dPq.showToastWithIcon(String.format(this.dPq.getPageContext().getString(n.i.invite_friend_exceed_max_count), 5), n.e.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.dPq.a((MetaData) obj);
                return;
            }
            this.dPq.b((MetaData) obj);
        }
    }
}

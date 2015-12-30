package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbCheckBox.a {
    final /* synthetic */ AtListActivity dWP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.dWP = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void handler(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.dWP.dWD;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.dWP.showToastWithIcon(String.format(this.dWP.getPageContext().getString(n.j.invite_friend_exceed_max_count), 5), n.f.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.dWP.a((MetaData) obj);
                return;
            }
            this.dWP.b((MetaData) obj);
        }
    }
}

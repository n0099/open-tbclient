package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.view.aa {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.aa
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.cwI.cwx;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.cwI.showToastWithIcon(String.format(this.cwI.getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5), com.baidu.tieba.u.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.cwI.b((MetaData) obj);
                return;
            }
            this.cwI.c((MetaData) obj);
        }
    }
}

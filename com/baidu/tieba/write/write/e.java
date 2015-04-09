package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.view.aa {
    final /* synthetic */ AtListActivity cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.cxb = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.aa
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.cxb.cwQ;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.cxb.showToastWithIcon(String.format(this.cxb.getPageContext().getString(com.baidu.tieba.y.invite_friend_exceed_max_count), 5), com.baidu.tieba.u.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.cxb.b((MetaData) obj);
                return;
            }
            this.cxb.c((MetaData) obj);
        }
    }
}

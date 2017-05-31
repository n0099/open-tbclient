package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbCheckBox.a {
    final /* synthetic */ AtListActivity fYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.fYZ = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.fYZ.fYO;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.fYZ.showToastWithIcon(String.format(this.fYZ.getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.fYZ.c((MetaData) obj);
                return;
            }
            this.fYZ.d((MetaData) obj);
        }
    }
}

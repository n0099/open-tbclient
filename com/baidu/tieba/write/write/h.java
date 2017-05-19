package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbCheckBox.a {
    final /* synthetic */ AtListActivity fRd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.fRd = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.fRd.fQS;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.fRd.showToastWithIcon(String.format(this.fRd.getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.fRd.b((MetaData) obj);
                return;
            }
            this.fRd.c((MetaData) obj);
        }
    }
}

package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbCheckBox.a {
    final /* synthetic */ AtListActivity eLC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.eLC = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.eLC.eLq;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.eLC.showToastWithIcon(String.format(this.eLC.getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.eLC.a((MetaData) obj);
                return;
            }
            this.eLC.b((MetaData) obj);
        }
    }
}

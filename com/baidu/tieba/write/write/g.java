package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements TbCheckBox.a {
    final /* synthetic */ AtListActivity erI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.erI = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.erI.erw;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.erI.showToastWithIcon(String.format(this.erI.getPageContext().getString(t.j.invite_friend_exceed_max_count), 5), t.f.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.erI.a((MetaData) obj);
                return;
            }
            this.erI.b((MetaData) obj);
        }
    }
}

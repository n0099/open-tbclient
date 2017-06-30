package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TbCheckBox.a {
    final /* synthetic */ AtListActivity gjY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AtListActivity atListActivity) {
        this.gjY = atListActivity;
    }

    @Override // com.baidu.tbadk.core.view.TbCheckBox.a
    public void a(TbCheckBox tbCheckBox, boolean z, Object obj) {
        AtSelectFriendList atSelectFriendList;
        if (obj != null && (obj instanceof MetaData)) {
            if (z) {
                atSelectFriendList = this.gjY.gjN;
                if (5 <= atSelectFriendList.getItemLength()) {
                    this.gjY.showToastWithIcon(String.format(this.gjY.getPageContext().getString(w.l.invite_friend_exceed_max_count), 5), w.g.icon_toast_game_error);
                    tbCheckBox.setChecked(false);
                    ((MetaData) obj).setChecked(false);
                    return;
                }
                this.gjY.c((MetaData) obj);
                return;
            }
            this.gjY.d((MetaData) obj);
        }
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class e extends g {
    protected TextView a;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.a = null;
        c(com.baidu.tieba.im.i.update_group_info_activity);
        d(com.baidu.tieba.im.j.group_update_info);
        this.a = (TextView) this.h.findViewById(com.baidu.tieba.im.h.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void g() {
        int length = this.c.getText().length();
        a(length, length, 15, 300);
        int i = 300 - length;
        this.a.setText(String.valueOf(i));
        if (i <= 50) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (i == 0) {
            this.a.setTextColor(this.h.getResources().getColor(com.baidu.tieba.im.e.group_create_info_count_color));
            return;
        }
        this.h.getLayoutMode().a(TbadkApplication.j().l() == 1);
        this.h.getLayoutMode().a(this.a);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final int j() {
        return com.baidu.tieba.im.j.group_step_info_error;
    }
}

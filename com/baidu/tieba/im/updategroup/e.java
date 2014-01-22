package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends g {
    protected TextView a;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.a = null;
        c(R.layout.update_group_info_activity);
        d(R.string.group_update_info);
        this.a = (TextView) this.h.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void g() {
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
            this.a.setTextColor(this.h.getResources().getColor(R.color.group_create_info_count_color));
        } else {
            n();
        }
    }

    private void n() {
        this.h.getLayoutMode().a(TiebaApplication.h().al() == 1);
        this.h.getLayoutMode().a(this.a);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int j() {
        return R.string.group_step_info_error;
    }
}

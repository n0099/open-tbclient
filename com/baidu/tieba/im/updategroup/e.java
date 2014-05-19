package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.o;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends g {
    protected TextView a;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.a = null;
        c(s.update_group_info_activity);
        d(u.group_update_info);
        this.a = (TextView) this.g.findViewById(r.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void g() {
        int length = this.b.getText().length();
        a(length, length, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        int i = 300 - length;
        this.a.setText(String.valueOf(i));
        if (i <= 50) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
        if (i == 0) {
            this.a.setTextColor(this.g.getResources().getColor(o.group_create_info_count_color));
        } else {
            n();
        }
    }

    private void n() {
        this.g.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.g.getLayoutMode().a(this.a);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int j() {
        return u.group_step_info_error;
    }
}

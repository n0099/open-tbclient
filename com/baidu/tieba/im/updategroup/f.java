package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.im.f.t;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends g {
    public f(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        c(s.update_group_name_activity);
        d(u.group_update_name);
        this.f = (ImageButton) updateGroupActivity.findViewById(r.button_del);
        this.f.setOnClickListener(updateGroupActivity);
        this.b.setFilters(new InputFilter[]{new com.baidu.tieba.im.f.a(20)});
    }

    @Override // com.baidu.tieba.im.updategroup.g
    protected void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        if (i < 1) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void g() {
        a(this.b.length(), t.a(this.b), 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int j() {
        return u.group_step_name_error;
    }
}

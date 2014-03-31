package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.im.f.r;
/* loaded from: classes.dex */
public final class f extends g {
    public f(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        c(com.baidu.tieba.im.i.update_group_name_activity);
        d(com.baidu.tieba.im.j.group_update_name);
        this.g = (ImageButton) updateGroupActivity.findViewById(com.baidu.tieba.im.h.button_del);
        this.g.setOnClickListener(updateGroupActivity);
        this.c.setFilters(new InputFilter[]{new com.baidu.tieba.im.f.a(20)});
    }

    @Override // com.baidu.tieba.im.updategroup.g
    protected final void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        if (i <= 0) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final void g() {
        a(this.c.length(), r.a(this.c), 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public final int j() {
        return com.baidu.tieba.im.j.group_step_name_error;
    }
}

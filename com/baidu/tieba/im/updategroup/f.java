package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.im.util.p;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f extends g {
    public f(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        c(R.layout.update_group_name_activity);
        d(R.string.group_update_name);
        this.g = (ImageButton) updateGroupActivity.findViewById(R.id.button_del);
        this.g.setOnClickListener(updateGroupActivity);
        this.c.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    @Override // com.baidu.tieba.im.updategroup.g
    protected void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        if (i < 1) {
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void g() {
        a(this.c.length(), p.a(this.c), 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int j() {
        return R.string.group_step_name_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.Button;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f extends g {
    public f(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        c(R.layout.update_group_name_activity);
        d(R.string.group_update_name);
        this.g = (Button) updateGroupActivity.findViewById(R.id.button_del);
        this.g.setOnClickListener(updateGroupActivity);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int a() {
        return 1;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void h() {
        a(this.c.length(), com.baidu.tieba.im.d.f.a(this.c), 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int k() {
        return R.string.group_step_name_error;
    }
}

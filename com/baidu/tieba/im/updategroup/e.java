package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f1798a;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.f1798a = null;
        c(R.layout.update_group_info_activity);
        d(R.string.group_update_info);
        this.f1798a = (TextView) this.h.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void h() {
        int length = this.c.getText().length();
        a(length, length, 15, 300);
        int i = 300 - length;
        this.f1798a.setText(String.valueOf(i));
        if (i <= 50) {
            this.f1798a.setVisibility(0);
        } else {
            this.f1798a.setVisibility(8);
        }
        if (i == 0) {
            this.f1798a.setTextColor(this.h.getResources().getColor(R.color.group_create_info_count_color));
        } else {
            o();
        }
    }

    private void o() {
        this.h.getLayoutMode().a(false);
        this.h.getLayoutMode().a(this.f1798a);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int a() {
        return 2;
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int k() {
        return R.string.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class e extends g {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f1889a;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.f1889a = null;
        c(R.layout.update_group_info_activity);
        d(R.string.group_update_info);
        this.f1889a = (TextView) this.h.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void g() {
        int length = this.c.getText().length();
        a(length, length, 15, 300);
        int i = 300 - length;
        this.f1889a.setText(String.valueOf(i));
        if (i <= 50) {
            this.f1889a.setVisibility(0);
        } else {
            this.f1889a.setVisibility(8);
        }
        if (i == 0) {
            this.f1889a.setTextColor(this.h.getResources().getColor(R.color.group_create_info_count_color));
        } else {
            n();
        }
    }

    private void n() {
        this.h.getLayoutMode().a(TiebaApplication.h().an() == 1);
        this.h.getLayoutMode().a(this.f1889a);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int j() {
        return R.string.group_step_info_error;
    }
}

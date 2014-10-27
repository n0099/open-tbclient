package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class f extends g {
    public f(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(w.update_group_name_activity);
        gm(y.group_update_name);
        this.aTo = (ImageButton) updateGroupActivity.findViewById(v.button_del);
        this.aTo.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    @Override // com.baidu.tieba.im.updategroup.g
    protected void e(int i, int i2, int i3, int i4) {
        super.e(i, i2, i3, i4);
        if (i < 1) {
            this.aTo.setVisibility(8);
        } else {
            this.aTo.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void RK() {
        e(this.mEditText.length(), com.baidu.tieba.im.util.j.b(this.mEditText), 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int RL() {
        return y.group_step_name_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
/* loaded from: classes3.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(d.i.update_group_name_activity);
        nZ(d.k.group_info_name);
        this.dUA = (ImageButton) updateGroupActivity.findViewById(d.g.button_del);
        this.dUA.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void u(int i, int i2, int i3, int i4) {
        super.u(i, i2, i3, i4);
        if (i < 1) {
            this.dUA.setVisibility(8);
        } else {
            this.dUA.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aHg() {
        u(this.mEditText.length(), f.d(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aHh() {
        return d.k.group_step_name_error;
    }
}

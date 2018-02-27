package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.d;
import com.baidu.tieba.im.util.f;
/* loaded from: classes3.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(d.h.update_group_name_activity);
        qE(d.j.group_info_name);
        this.ezJ = (ImageButton) updateGroupActivity.findViewById(d.g.button_del);
        this.ezJ.setOnClickListener(updateGroupActivity);
        this.rD.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void B(int i, int i2, int i3, int i4) {
        super.B(i, i2, i3, i4);
        if (i < 1) {
            this.ezJ.setVisibility(8);
        } else {
            this.ezJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMf() {
        B(this.rD.length(), f.d(this.rD) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMg() {
        return d.j.group_step_name_error;
    }
}

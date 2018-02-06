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
        this.ezV = (ImageButton) updateGroupActivity.findViewById(d.g.button_del);
        this.ezV.setOnClickListener(updateGroupActivity);
        this.rE.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void B(int i, int i2, int i3, int i4) {
        super.B(i, i2, i3, i4);
        if (i < 1) {
            this.ezV.setVisibility(8);
        } else {
            this.ezV.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMg() {
        B(this.rE.length(), f.d(this.rE) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMh() {
        return d.j.group_step_name_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.e;
import com.baidu.tieba.im.util.f;
/* loaded from: classes3.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(e.h.update_group_name_activity);
        pH(e.j.group_info_name);
        this.eDJ = (ImageButton) updateGroupActivity.findViewById(e.g.button_del);
        this.eDJ.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void u(int i, int i2, int i3, int i4) {
        super.u(i, i2, i3, i4);
        if (i < 1) {
            this.eDJ.setVisibility(8);
        } else {
            this.eDJ.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aTf() {
        u(this.mEditText.length(), f.d(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aTg() {
        return e.j.group_step_name_error;
    }
}

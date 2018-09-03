package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(f.h.update_group_name_activity);
        oF(f.j.group_info_name);
        this.eoC = (ImageButton) updateGroupActivity.findViewById(f.g.button_del);
        this.eoC.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void t(int i, int i2, int i3, int i4) {
        super.t(i, i2, i3, i4);
        if (i < 1) {
            this.eoC.setVisibility(8);
        } else {
            this.eoC.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aNC() {
        t(this.mEditText.length(), com.baidu.tieba.im.util.f.d(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aND() {
        return f.j.group_step_name_error;
    }
}

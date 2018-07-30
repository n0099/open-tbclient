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
        oF(d.j.group_info_name);
        this.eoG = (ImageButton) updateGroupActivity.findViewById(d.g.button_del);
        this.eoG.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void t(int i, int i2, int i3, int i4) {
        super.t(i, i2, i3, i4);
        if (i < 1) {
            this.eoG.setVisibility(8);
        } else {
            this.eoG.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aNF() {
        t(this.mEditText.length(), f.d(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aNG() {
        return d.j.group_step_name_error;
    }
}

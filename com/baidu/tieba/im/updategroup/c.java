package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
/* loaded from: classes5.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(R.layout.update_group_name_activity);
        vY(R.string.group_info_name);
        this.gDF = (ImageButton) updateGroupActivity.findViewById(R.id.button_del);
        this.gDF.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void z(int i, int i2, int i3, int i4) {
        super.z(i, i2, i3, i4);
        if (i < 1) {
            this.gDF.setVisibility(8);
        } else {
            this.gDF.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bGQ() {
        z(this.mEditText.length(), f.h(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bGR() {
        return R.string.group_step_name_error;
    }
}

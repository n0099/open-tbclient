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
        wc(R.string.group_info_name);
        this.gFw = (ImageButton) updateGroupActivity.findViewById(R.id.button_del);
        this.gFw.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void C(int i, int i2, int i3, int i4) {
        super.C(i, i2, i3, i4);
        if (i < 1) {
            this.gFw.setVisibility(8);
        } else {
            this.gFw.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bHE() {
        C(this.mEditText.length(), f.h(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bHF() {
        return R.string.group_step_name_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
/* loaded from: classes23.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(R.layout.update_group_name_activity);
        EK(R.string.group_info_name);
        this.koP = (ImageButton) updateGroupActivity.findViewById(R.id.button_del);
        this.koP.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void J(int i, int i2, int i3, int i4) {
        super.J(i, i2, i3, i4);
        if (i < 1) {
            this.koP.setVisibility(8);
        } else {
            this.koP.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void dai() {
        J(this.mEditText.length(), f.getTextLength(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int daj() {
        return R.string.group_step_name_error;
    }
}

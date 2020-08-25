package com.baidu.tieba.im.updategroup;

import android.text.InputFilter;
import android.widget.ImageButton;
import com.baidu.tieba.R;
import com.baidu.tieba.im.util.f;
/* loaded from: classes17.dex */
public class c extends d {
    public c(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        setContentView(R.layout.update_group_name_activity);
        BK(R.string.group_info_name);
        this.jky = (ImageButton) updateGroupActivity.findViewById(R.id.button_del);
        this.jky.setOnClickListener(updateGroupActivity);
        this.mEditText.setFilters(new InputFilter[]{new com.baidu.tieba.im.util.a(20)});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.updategroup.d
    public void D(int i, int i2, int i3, int i4) {
        super.D(i, i2, i3, i4);
        if (i < 1) {
            this.jky.setVisibility(8);
        } else {
            this.jky.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cIt() {
        D(this.mEditText.length(), f.getTextLength(this.mEditText) / 2, 2, 20);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cIu() {
        return R.string.group_step_name_error;
    }
}

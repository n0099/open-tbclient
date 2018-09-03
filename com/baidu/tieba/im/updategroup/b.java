package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eCl;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eCl = null;
        setContentView(f.h.update_group_info_activity);
        oF(f.j.group_update_info);
        this.eCl = (TextView) this.eCm.findViewById(f.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aNC() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            t(length, length, 15, 300);
            int i = 300 - length;
            this.eCl.setText(String.valueOf(i));
            if (i <= 50) {
                this.eCl.setVisibility(0);
            } else {
                this.eCl.setVisibility(8);
            }
            if (i == 0) {
                this.eCl.setTextColor(this.eCm.getResources().getColor(f.d.common_color_10170));
            } else {
                aIj();
            }
        }
    }

    private void aIj() {
        this.eCm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eCm.getLayoutMode().onModeChanged(this.eCl);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aND() {
        return f.j.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eCp;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eCp = null;
        setContentView(d.h.update_group_info_activity);
        oF(d.j.group_update_info);
        this.eCp = (TextView) this.eCq.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aNF() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            t(length, length, 15, 300);
            int i = 300 - length;
            this.eCp.setText(String.valueOf(i));
            if (i <= 50) {
                this.eCp.setVisibility(0);
            } else {
                this.eCp.setVisibility(8);
            }
            if (i == 0) {
                this.eCp.setTextColor(this.eCq.getResources().getColor(d.C0140d.common_color_10170));
            } else {
                aIm();
            }
        }
    }

    private void aIm() {
        this.eCq.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eCq.getLayoutMode().onModeChanged(this.eCp);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aNG() {
        return d.j.group_step_info_error;
    }
}

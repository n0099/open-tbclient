package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eRl;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eRl = null;
        setContentView(e.h.update_group_info_activity);
        pH(e.j.group_update_info);
        this.eRl = (TextView) this.eRm.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aTf() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eRl.setText(String.valueOf(i));
            if (i <= 50) {
                this.eRl.setVisibility(0);
            } else {
                this.eRl.setVisibility(8);
            }
            if (i == 0) {
                this.eRl.setTextColor(this.eRm.getResources().getColor(e.d.common_color_10170));
            } else {
                aNO();
            }
        }
    }

    private void aNO() {
        this.eRm.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eRm.getLayoutMode().onModeChanged(this.eRl);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aTg() {
        return e.j.group_step_info_error;
    }
}

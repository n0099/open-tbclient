package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eRm;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eRm = null;
        setContentView(e.h.update_group_info_activity);
        pH(e.j.group_update_info);
        this.eRm = (TextView) this.eRn.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aTf() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eRm.setText(String.valueOf(i));
            if (i <= 50) {
                this.eRm.setVisibility(0);
            } else {
                this.eRm.setVisibility(8);
            }
            if (i == 0) {
                this.eRm.setTextColor(this.eRn.getResources().getColor(e.d.common_color_10170));
            } else {
                aNO();
            }
        }
    }

    private void aNO() {
        this.eRn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eRn.getLayoutMode().onModeChanged(this.eRm);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aTg() {
        return e.j.group_step_info_error;
    }
}

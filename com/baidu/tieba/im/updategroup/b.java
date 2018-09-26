package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eJC;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eJC = null;
        setContentView(e.h.update_group_info_activity);
        pj(e.j.group_update_info);
        this.eJC = (TextView) this.eJD.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aPR() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eJC.setText(String.valueOf(i));
            if (i <= 50) {
                this.eJC.setVisibility(0);
            } else {
                this.eJC.setVisibility(8);
            }
            if (i == 0) {
                this.eJC.setTextColor(this.eJD.getResources().getColor(e.d.common_color_10170));
            } else {
                aKy();
            }
        }
    }

    private void aKy() {
        this.eJD.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eJD.getLayoutMode().onModeChanged(this.eJC);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aPS() {
        return e.j.group_step_info_error;
    }
}

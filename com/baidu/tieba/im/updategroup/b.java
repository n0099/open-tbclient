package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView fck;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.fck = null;
        setContentView(e.h.update_group_info_activity);
        qH(e.j.group_update_info);
        this.fck = (TextView) this.fcl.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aVh() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            v(length, length, 15, 300);
            int i = 300 - length;
            this.fck.setText(String.valueOf(i));
            if (i <= 50) {
                this.fck.setVisibility(0);
            } else {
                this.fck.setVisibility(8);
            }
            if (i == 0) {
                this.fck.setTextColor(this.fcl.getResources().getColor(e.d.common_color_10170));
            } else {
                aPQ();
            }
        }
    }

    private void aPQ() {
        this.fcl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.fcl.getLayoutMode().onModeChanged(this.fck);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aVi() {
        return e.j.group_step_info_error;
    }
}

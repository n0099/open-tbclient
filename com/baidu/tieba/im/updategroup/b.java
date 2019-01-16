package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView fcX;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.fcX = null;
        setContentView(e.h.update_group_info_activity);
        qI(e.j.group_update_info);
        this.fcX = (TextView) this.fcY.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aVH() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            v(length, length, 15, 300);
            int i = 300 - length;
            this.fcX.setText(String.valueOf(i));
            if (i <= 50) {
                this.fcX.setVisibility(0);
            } else {
                this.fcX.setVisibility(8);
            }
            if (i == 0) {
                this.fcX.setTextColor(this.fcY.getResources().getColor(e.d.common_color_10170));
            } else {
                aQq();
            }
        }
    }

    private void aQq() {
        this.fcY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.fcY.getLayoutMode().onModeChanged(this.fcX);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aVI() {
        return e.j.group_step_info_error;
    }
}

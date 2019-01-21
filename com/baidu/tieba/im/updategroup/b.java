package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView fcY;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.fcY = null;
        setContentView(e.h.update_group_info_activity);
        qI(e.j.group_update_info);
        this.fcY = (TextView) this.fcZ.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aVH() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            v(length, length, 15, 300);
            int i = 300 - length;
            this.fcY.setText(String.valueOf(i));
            if (i <= 50) {
                this.fcY.setVisibility(0);
            } else {
                this.fcY.setVisibility(8);
            }
            if (i == 0) {
                this.fcY.setTextColor(this.fcZ.getResources().getColor(e.d.common_color_10170));
            } else {
                aQq();
            }
        }
    }

    private void aQq() {
        this.fcZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.fcZ.getLayoutMode().onModeChanged(this.fcY);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aVI() {
        return e.j.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gtd;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gtd = null;
        setContentView(d.h.update_group_info_activity);
        us(d.j.group_update_info);
        this.gtd = (TextView) this.gte.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bwm() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gtd.setText(String.valueOf(i));
            if (i <= 50) {
                this.gtd.setVisibility(0);
            } else {
                this.gtd.setVisibility(8);
            }
            if (i == 0) {
                this.gtd.setTextColor(this.gte.getResources().getColor(d.C0277d.common_color_10170));
            } else {
                bqV();
            }
        }
    }

    private void bqV() {
        this.gte.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gte.getLayoutMode().onModeChanged(this.gtd);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bwn() {
        return d.j.group_step_info_error;
    }
}

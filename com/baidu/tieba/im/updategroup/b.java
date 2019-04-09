package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gsR;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gsR = null;
        setContentView(d.h.update_group_info_activity);
        uo(d.j.group_update_info);
        this.gsR = (TextView) this.gsS.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bwj() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gsR.setText(String.valueOf(i));
            if (i <= 50) {
                this.gsR.setVisibility(0);
            } else {
                this.gsR.setVisibility(8);
            }
            if (i == 0) {
                this.gsR.setTextColor(this.gsS.getResources().getColor(d.C0277d.common_color_10170));
            } else {
                bqS();
            }
        }
    }

    private void bqS() {
        this.gsS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gsS.getLayoutMode().onModeChanged(this.gsR);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bwk() {
        return d.j.group_step_info_error;
    }
}

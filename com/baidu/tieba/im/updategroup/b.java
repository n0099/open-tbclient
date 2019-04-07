package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gsQ;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gsQ = null;
        setContentView(d.h.update_group_info_activity);
        uo(d.j.group_update_info);
        this.gsQ = (TextView) this.gsR.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bwj() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gsQ.setText(String.valueOf(i));
            if (i <= 50) {
                this.gsQ.setVisibility(0);
            } else {
                this.gsQ.setVisibility(8);
            }
            if (i == 0) {
                this.gsQ.setTextColor(this.gsR.getResources().getColor(d.C0277d.common_color_10170));
            } else {
                bqS();
            }
        }
    }

    private void bqS() {
        this.gsR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gsR.getLayoutMode().onModeChanged(this.gsQ);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bwk() {
        return d.j.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eNq;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eNq = null;
        setContentView(d.h.update_group_info_activity);
        qE(d.j.group_update_info);
        this.eNq = (TextView) this.eNr.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMf() {
        String obj;
        if (this.rD.getText() != null && (obj = this.rD.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.eNq.setText(String.valueOf(i));
            if (i <= 50) {
                this.eNq.setVisibility(0);
            } else {
                this.eNq.setVisibility(8);
            }
            if (i == 0) {
                this.eNq.setTextColor(this.eNr.getResources().getColor(d.C0141d.common_color_10170));
            } else {
                aGL();
            }
        }
    }

    private void aGL() {
        this.eNr.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eNr.getLayoutMode().aM(this.eNq);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMg() {
        return d.j.group_step_info_error;
    }
}

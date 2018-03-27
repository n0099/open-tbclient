package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eNG;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eNG = null;
        setContentView(d.h.update_group_info_activity);
        qF(d.j.group_update_info);
        this.eNG = (TextView) this.eNH.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMg() {
        String obj;
        if (this.rD.getText() != null && (obj = this.rD.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.eNG.setText(String.valueOf(i));
            if (i <= 50) {
                this.eNG.setVisibility(0);
            } else {
                this.eNG.setVisibility(8);
            }
            if (i == 0) {
                this.eNG.setTextColor(this.eNH.getResources().getColor(d.C0141d.common_color_10170));
            } else {
                aGM();
            }
        }
    }

    private void aGM() {
        this.eNH.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eNH.getLayoutMode().aM(this.eNG);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMh() {
        return d.j.group_step_info_error;
    }
}

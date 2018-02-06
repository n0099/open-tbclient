package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eNC;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eNC = null;
        setContentView(d.h.update_group_info_activity);
        qE(d.j.group_update_info);
        this.eNC = (TextView) this.eND.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMg() {
        String obj;
        if (this.rE.getText() != null && (obj = this.rE.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.eNC.setText(String.valueOf(i));
            if (i <= 50) {
                this.eNC.setVisibility(0);
            } else {
                this.eNC.setVisibility(8);
            }
            if (i == 0) {
                this.eNC.setTextColor(this.eND.getResources().getColor(d.C0140d.common_color_10170));
            } else {
                aGM();
            }
        }
    }

    private void aGM() {
        this.eND.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eND.getLayoutMode().aM(this.eNC);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMh() {
        return d.j.group_step_info_error;
    }
}

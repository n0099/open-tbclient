package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eij;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eij = null;
        setContentView(d.i.update_group_info_activity);
        nZ(d.k.group_update_info);
        this.eij = (TextView) this.eik.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aHg() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eij.setText(String.valueOf(i));
            if (i <= 50) {
                this.eij.setVisibility(0);
            } else {
                this.eij.setVisibility(8);
            }
            if (i == 0) {
                this.eij.setTextColor(this.eik.getResources().getColor(d.C0126d.common_color_10170));
            } else {
                aBM();
            }
        }
    }

    private void aBM() {
        this.eik.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eik.getLayoutMode().u(this.eij);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aHh() {
        return d.k.group_step_info_error;
    }
}

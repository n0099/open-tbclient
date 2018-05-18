package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView ejq;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.ejq = null;
        setContentView(d.i.update_group_info_activity);
        nY(d.k.group_update_info);
        this.ejq = (TextView) this.ejr.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aHe() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.ejq.setText(String.valueOf(i));
            if (i <= 50) {
                this.ejq.setVisibility(0);
            } else {
                this.ejq.setVisibility(8);
            }
            if (i == 0) {
                this.ejq.setTextColor(this.ejr.getResources().getColor(d.C0126d.common_color_10170));
            } else {
                aBK();
            }
        }
    }

    private void aBK() {
        this.ejr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ejr.getLayoutMode().u(this.ejq);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aHf() {
        return d.k.group_step_info_error;
    }
}

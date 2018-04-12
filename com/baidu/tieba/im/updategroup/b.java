package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eim;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eim = null;
        setContentView(d.i.update_group_info_activity);
        oa(d.k.group_update_info);
        this.eim = (TextView) this.ein.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aHg() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eim.setText(String.valueOf(i));
            if (i <= 50) {
                this.eim.setVisibility(0);
            } else {
                this.eim.setVisibility(8);
            }
            if (i == 0) {
                this.eim.setTextColor(this.ein.getResources().getColor(d.C0126d.common_color_10170));
            } else {
                aBM();
            }
        }
    }

    private void aBM() {
        this.ein.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ein.getLayoutMode().u(this.eim);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aHh() {
        return d.k.group_step_info_error;
    }
}

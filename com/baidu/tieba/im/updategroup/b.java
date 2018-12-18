package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eZt;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eZt = null;
        setContentView(e.h.update_group_info_activity);
        qu(e.j.group_update_info);
        this.eZt = (TextView) this.eZu.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aUt() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            v(length, length, 15, 300);
            int i = 300 - length;
            this.eZt.setText(String.valueOf(i));
            if (i <= 50) {
                this.eZt.setVisibility(0);
            } else {
                this.eZt.setVisibility(8);
            }
            if (i == 0) {
                this.eZt.setTextColor(this.eZu.getResources().getColor(e.d.common_color_10170));
            } else {
                aPc();
            }
        }
    }

    private void aPc() {
        this.eZu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eZu.getLayoutMode().onModeChanged(this.eZt);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aUu() {
        return e.j.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends d {
    protected TextView jIb;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jIb = null;
        setContentView(R.layout.update_group_info_activity);
        Cl(R.string.group_update_info);
        this.jIb = (TextView) this.jIc.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cMa() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jIb.setText(String.valueOf(i));
            if (i <= 50) {
                this.jIb.setVisibility(0);
            } else {
                this.jIb.setVisibility(8);
            }
            if (i == 0) {
                this.jIb.setTextColor(this.jIc.getResources().getColor(R.color.common_color_10170));
            } else {
                cGt();
            }
        }
    }

    private void cGt() {
        this.jIc.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jIc.getLayoutMode().onModeChanged(this.jIb);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cMb() {
        return R.string.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class b extends d {
    protected TextView hEq;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hEq = null;
        setContentView(R.layout.update_group_info_activity);
        wJ(R.string.group_update_info);
        this.hEq = (TextView) this.hEr.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bVz() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hEq.setText(String.valueOf(i));
            if (i <= 50) {
                this.hEq.setVisibility(0);
            } else {
                this.hEq.setVisibility(8);
            }
            if (i == 0) {
                this.hEq.setTextColor(this.hEr.getResources().getColor(R.color.common_color_10170));
            } else {
                bQp();
            }
        }
    }

    private void bQp() {
        this.hEr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hEr.getLayoutMode().onModeChanged(this.hEq);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bVA() {
        return R.string.group_step_info_error;
    }
}

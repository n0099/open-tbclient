package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView iKV;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.iKV = null;
        setContentView(R.layout.update_group_info_activity);
        yi(R.string.group_update_info);
        this.iKV = (TextView) this.iKW.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cpK() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            C(length, length, 15, 300);
            int i = 300 - length;
            this.iKV.setText(String.valueOf(i));
            if (i <= 50) {
                this.iKV.setVisibility(0);
            } else {
                this.iKV.setVisibility(8);
            }
            if (i == 0) {
                this.iKV.setTextColor(this.iKW.getResources().getColor(R.color.common_color_10170));
            } else {
                ckA();
            }
        }
    }

    private void ckA() {
        this.iKW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iKW.getLayoutMode().onModeChanged(this.iKV);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cpL() {
        return R.string.group_step_info_error;
    }
}

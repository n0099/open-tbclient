package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends d {
    protected TextView kDC;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.kDC = null;
        setContentView(R.layout.update_group_info_activity);
        EK(R.string.group_update_info);
        this.kDC = (TextView) this.kDD.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void daj() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            J(length, length, 15, 300);
            int i = 300 - length;
            this.kDC.setText(String.valueOf(i));
            if (i <= 50) {
                this.kDC.setVisibility(0);
            } else {
                this.kDC.setVisibility(8);
            }
            if (i == 0) {
                this.kDC.setTextColor(this.kDD.getResources().getColor(R.color.common_color_10170));
            } else {
                cUF();
            }
        }
    }

    private void cUF() {
        this.kDD.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kDD.getLayoutMode().onModeChanged(this.kDC);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int dak() {
        return R.string.group_step_info_error;
    }
}

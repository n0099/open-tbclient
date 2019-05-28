package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gKf;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gKf = null;
        setContentView(R.layout.update_group_info_activity);
        vv(R.string.group_update_info);
        this.gKf = (TextView) this.gKg.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bDU() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gKf.setText(String.valueOf(i));
            if (i <= 50) {
                this.gKf.setVisibility(0);
            } else {
                this.gKf.setVisibility(8);
            }
            if (i == 0) {
                this.gKf.setTextColor(this.gKg.getResources().getColor(R.color.common_color_10170));
            } else {
                byH();
            }
        }
    }

    private void byH() {
        this.gKg.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gKg.getLayoutMode().onModeChanged(this.gKf);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bDV() {
        return R.string.group_step_info_error;
    }
}

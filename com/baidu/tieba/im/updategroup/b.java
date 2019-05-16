package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gKe;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gKe = null;
        setContentView(R.layout.update_group_info_activity);
        vv(R.string.group_update_info);
        this.gKe = (TextView) this.gKf.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bDR() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gKe.setText(String.valueOf(i));
            if (i <= 50) {
                this.gKe.setVisibility(0);
            } else {
                this.gKe.setVisibility(8);
            }
            if (i == 0) {
                this.gKe.setTextColor(this.gKf.getResources().getColor(R.color.common_color_10170));
            } else {
                byE();
            }
        }
    }

    private void byE() {
        this.gKf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gKf.getLayoutMode().onModeChanged(this.gKe);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bDS() {
        return R.string.group_step_info_error;
    }
}

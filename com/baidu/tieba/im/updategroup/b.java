package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gKh;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gKh = null;
        setContentView(R.layout.update_group_info_activity);
        vv(R.string.group_update_info);
        this.gKh = (TextView) this.gKi.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bDV() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            y(length, length, 15, 300);
            int i = 300 - length;
            this.gKh.setText(String.valueOf(i));
            if (i <= 50) {
                this.gKh.setVisibility(0);
            } else {
                this.gKh.setVisibility(8);
            }
            if (i == 0) {
                this.gKh.setTextColor(this.gKi.getResources().getColor(R.color.common_color_10170));
            } else {
                byI();
            }
        }
    }

    private void byI() {
        this.gKi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gKi.getLayoutMode().onModeChanged(this.gKh);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bDW() {
        return R.string.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends d {
    protected TextView kqe;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.kqe = null;
        setContentView(R.layout.update_group_info_activity);
        DV(R.string.group_update_info);
        this.kqe = (TextView) this.kqf.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cUW() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            F(length, length, 15, 300);
            int i = 300 - length;
            this.kqe.setText(String.valueOf(i));
            if (i <= 50) {
                this.kqe.setVisibility(0);
            } else {
                this.kqe.setVisibility(8);
            }
            if (i == 0) {
                this.kqe.setTextColor(this.kqf.getResources().getColor(R.color.common_color_10170));
            } else {
                cPq();
            }
        }
    }

    private void cPq() {
        this.kqf.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kqf.getLayoutMode().onModeChanged(this.kqe);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cUX() {
        return R.string.group_step_info_error;
    }
}

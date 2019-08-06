package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gRj;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gRj = null;
        setContentView(R.layout.update_group_info_activity);
        vY(R.string.group_update_info);
        this.gRj = (TextView) this.gRk.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bGQ() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            z(length, length, 15, 300);
            int i = 300 - length;
            this.gRj.setText(String.valueOf(i));
            if (i <= 50) {
                this.gRj.setVisibility(0);
            } else {
                this.gRj.setVisibility(8);
            }
            if (i == 0) {
                this.gRj.setTextColor(this.gRk.getResources().getColor(R.color.common_color_10170));
            } else {
                bBB();
            }
        }
    }

    private void bBB() {
        this.gRk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gRk.getLayoutMode().onModeChanged(this.gRj);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bGR() {
        return R.string.group_step_info_error;
    }
}

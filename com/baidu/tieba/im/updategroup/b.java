package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gRd;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gRd = null;
        setContentView(R.layout.update_group_info_activity);
        uI(R.string.group_update_info);
        this.gRd = (TextView) this.gRe.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bEp() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            x(length, length, 15, 300);
            int i = 300 - length;
            this.gRd.setText(String.valueOf(i));
            if (i <= 50) {
                this.gRd.setVisibility(0);
            } else {
                this.gRd.setVisibility(8);
            }
            if (i == 0) {
                this.gRd.setTextColor(this.gRe.getResources().getColor(R.color.common_color_10170));
            } else {
                bza();
            }
        }
    }

    private void bza() {
        this.gRe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gRe.getLayoutMode().onModeChanged(this.gRd);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bEq() {
        return R.string.group_step_info_error;
    }
}

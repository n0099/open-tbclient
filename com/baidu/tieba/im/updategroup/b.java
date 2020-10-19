package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends d {
    protected TextView jWY;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jWY = null;
        setContentView(R.layout.update_group_info_activity);
        CR(R.string.group_update_info);
        this.jWY = (TextView) this.jWZ.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cPI() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jWY.setText(String.valueOf(i));
            if (i <= 50) {
                this.jWY.setVisibility(0);
            } else {
                this.jWY.setVisibility(8);
            }
            if (i == 0) {
                this.jWY.setTextColor(this.jWZ.getResources().getColor(R.color.common_color_10170));
            } else {
                cKc();
            }
        }
    }

    private void cKc() {
        this.jWZ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jWZ.getLayoutMode().onModeChanged(this.jWY);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cPJ() {
        return R.string.group_step_info_error;
    }
}

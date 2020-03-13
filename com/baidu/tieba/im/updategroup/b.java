package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView hKg;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hKg = null;
        setContentView(R.layout.update_group_info_activity);
        wU(R.string.group_update_info);
        this.hKg = (TextView) this.hKh.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bYm() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hKg.setText(String.valueOf(i));
            if (i <= 50) {
                this.hKg.setVisibility(0);
            } else {
                this.hKg.setVisibility(8);
            }
            if (i == 0) {
                this.hKg.setTextColor(this.hKh.getResources().getColor(R.color.common_color_10170));
            } else {
                bTc();
            }
        }
    }

    private void bTc() {
        this.hKh.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hKh.getLayoutMode().onModeChanged(this.hKg);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bYn() {
        return R.string.group_step_info_error;
    }
}

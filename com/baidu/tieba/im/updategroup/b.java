package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends d {
    protected TextView kjy;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.kjy = null;
        setContentView(R.layout.update_group_info_activity);
        Dk(R.string.group_update_info);
        this.kjy = (TextView) this.kjz.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cSP() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            E(length, length, 15, 300);
            int i = 300 - length;
            this.kjy.setText(String.valueOf(i));
            if (i <= 50) {
                this.kjy.setVisibility(0);
            } else {
                this.kjy.setVisibility(8);
            }
            if (i == 0) {
                this.kjy.setTextColor(this.kjz.getResources().getColor(R.color.common_color_10170));
            } else {
                cNj();
            }
        }
    }

    private void cNj() {
        this.kjz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kjz.getLayoutMode().onModeChanged(this.kjy);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cSQ() {
        return R.string.group_step_info_error;
    }
}

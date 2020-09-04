package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends d {
    protected TextView jzz;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jzz = null;
        setContentView(R.layout.update_group_info_activity);
        BK(R.string.group_update_info);
        this.jzz = (TextView) this.jzA.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cIu() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jzz.setText(String.valueOf(i));
            if (i <= 50) {
                this.jzz.setVisibility(0);
            } else {
                this.jzz.setVisibility(8);
            }
            if (i == 0) {
                this.jzz.setTextColor(this.jzA.getResources().getColor(R.color.common_color_10170));
            } else {
                cCN();
            }
        }
    }

    private void cCN() {
        this.jzA.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jzA.getLayoutMode().onModeChanged(this.jzz);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cIv() {
        return R.string.group_step_info_error;
    }
}

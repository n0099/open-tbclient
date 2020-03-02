package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView hJU;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hJU = null;
        setContentView(R.layout.update_group_info_activity);
        wU(R.string.group_update_info);
        this.hJU = (TextView) this.hJV.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bYl() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hJU.setText(String.valueOf(i));
            if (i <= 50) {
                this.hJU.setVisibility(0);
            } else {
                this.hJU.setVisibility(8);
            }
            if (i == 0) {
                this.hJU.setTextColor(this.hJV.getResources().getColor(R.color.common_color_10170));
            } else {
                bTb();
            }
        }
    }

    private void bTb() {
        this.hJV.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hJV.getLayoutMode().onModeChanged(this.hJU);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bYm() {
        return R.string.group_step_info_error;
    }
}

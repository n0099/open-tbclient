package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView hJS;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hJS = null;
        setContentView(R.layout.update_group_info_activity);
        wU(R.string.group_update_info);
        this.hJS = (TextView) this.hJT.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bYj() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hJS.setText(String.valueOf(i));
            if (i <= 50) {
                this.hJS.setVisibility(0);
            } else {
                this.hJS.setVisibility(8);
            }
            if (i == 0) {
                this.hJS.setTextColor(this.hJT.getResources().getColor(R.color.common_color_10170));
            } else {
                bSZ();
            }
        }
    }

    private void bSZ() {
        this.hJT.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hJT.getLayoutMode().onModeChanged(this.hJS);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bYk() {
        return R.string.group_step_info_error;
    }
}

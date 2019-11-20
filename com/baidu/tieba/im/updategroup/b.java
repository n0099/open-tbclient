package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gQm;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gQm = null;
        setContentView(R.layout.update_group_info_activity);
        uH(R.string.group_update_info);
        this.gQm = (TextView) this.gQn.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bEn() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            x(length, length, 15, 300);
            int i = 300 - length;
            this.gQm.setText(String.valueOf(i));
            if (i <= 50) {
                this.gQm.setVisibility(0);
            } else {
                this.gQm.setVisibility(8);
            }
            if (i == 0) {
                this.gQm.setTextColor(this.gQn.getResources().getColor(R.color.common_color_10170));
            } else {
                byY();
            }
        }
    }

    private void byY() {
        this.gQn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gQn.getLayoutMode().onModeChanged(this.gQm);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bEo() {
        return R.string.group_step_info_error;
    }
}

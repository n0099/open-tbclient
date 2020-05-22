package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView iKi;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.iKi = null;
        setContentView(R.layout.update_group_info_activity);
        yg(R.string.group_update_info);
        this.iKi = (TextView) this.iKj.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cpB() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            C(length, length, 15, 300);
            int i = 300 - length;
            this.iKi.setText(String.valueOf(i));
            if (i <= 50) {
                this.iKi.setVisibility(0);
            } else {
                this.iKi.setVisibility(8);
            }
            if (i == 0) {
                this.iKi.setTextColor(this.iKj.getResources().getColor(R.color.common_color_10170));
            } else {
                ckr();
            }
        }
    }

    private void ckr() {
        this.iKj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iKj.getLayoutMode().onModeChanged(this.iKi);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cpC() {
        return R.string.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView jbX;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jbX = null;
        setContentView(R.layout.update_group_info_activity);
        yS(R.string.group_update_info);
        this.jbX = (TextView) this.jbY.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void ctA() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            C(length, length, 15, 300);
            int i = 300 - length;
            this.jbX.setText(String.valueOf(i));
            if (i <= 50) {
                this.jbX.setVisibility(0);
            } else {
                this.jbX.setVisibility(8);
            }
            if (i == 0) {
                this.jbX.setTextColor(this.jbY.getResources().getColor(R.color.common_color_10170));
            } else {
                coq();
            }
        }
    }

    private void coq() {
        this.jbY.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jbY.getLayoutMode().onModeChanged(this.jbX);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int ctB() {
        return R.string.group_step_info_error;
    }
}

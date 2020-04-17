package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView ivw;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.ivw = null;
        setContentView(R.layout.update_group_info_activity);
        xA(R.string.group_update_info);
        this.ivw = (TextView) this.ivx.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cjf() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.ivw.setText(String.valueOf(i));
            if (i <= 50) {
                this.ivw.setVisibility(0);
            } else {
                this.ivw.setVisibility(8);
            }
            if (i == 0) {
                this.ivw.setTextColor(this.ivx.getResources().getColor(R.color.common_color_10170));
            } else {
                cdU();
            }
        }
    }

    private void cdU() {
        this.ivx.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ivx.getLayoutMode().onModeChanged(this.ivw);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cjg() {
        return R.string.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView ivC;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.ivC = null;
        setContentView(R.layout.update_group_info_activity);
        xA(R.string.group_update_info);
        this.ivC = (TextView) this.ivD.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cje() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.ivC.setText(String.valueOf(i));
            if (i <= 50) {
                this.ivC.setVisibility(0);
            } else {
                this.ivC.setVisibility(8);
            }
            if (i == 0) {
                this.ivC.setTextColor(this.ivD.getResources().getColor(R.color.common_color_10170));
            } else {
                cdT();
            }
        }
    }

    private void cdT() {
        this.ivD.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ivD.getLayoutMode().onModeChanged(this.ivC);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cjf() {
        return R.string.group_step_info_error;
    }
}

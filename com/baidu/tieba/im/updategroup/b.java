package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends d {
    protected TextView kDA;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.kDA = null;
        setContentView(R.layout.update_group_info_activity);
        EK(R.string.group_update_info);
        this.kDA = (TextView) this.kDB.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void dai() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            J(length, length, 15, 300);
            int i = 300 - length;
            this.kDA.setText(String.valueOf(i));
            if (i <= 50) {
                this.kDA.setVisibility(0);
            } else {
                this.kDA.setVisibility(8);
            }
            if (i == 0) {
                this.kDA.setTextColor(this.kDB.getResources().getColor(R.color.common_color_10170));
            } else {
                cUE();
            }
        }
    }

    private void cUE() {
        this.kDB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kDB.getLayoutMode().onModeChanged(this.kDA);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int daj() {
        return R.string.group_step_info_error;
    }
}

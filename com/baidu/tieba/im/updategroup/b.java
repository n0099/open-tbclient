package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gTd;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gTd = null;
        setContentView(R.layout.update_group_info_activity);
        wc(R.string.group_update_info);
        this.gTd = (TextView) this.gTe.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bHE() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            C(length, length, 15, 300);
            int i = 300 - length;
            this.gTd.setText(String.valueOf(i));
            if (i <= 50) {
                this.gTd.setVisibility(0);
            } else {
                this.gTd.setVisibility(8);
            }
            if (i == 0) {
                this.gTd.setTextColor(this.gTe.getResources().getColor(R.color.common_color_10170));
            } else {
                bCp();
            }
        }
    }

    private void bCp() {
        this.gTe.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gTe.getLayoutMode().onModeChanged(this.gTd);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bHF() {
        return R.string.group_step_info_error;
    }
}

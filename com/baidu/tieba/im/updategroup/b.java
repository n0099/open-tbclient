package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends d {
    protected TextView hLG;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hLG = null;
        setContentView(R.layout.update_group_info_activity);
        xc(R.string.group_update_info);
        this.hLG = (TextView) this.hLH.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bYE() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hLG.setText(String.valueOf(i));
            if (i <= 50) {
                this.hLG.setVisibility(0);
            } else {
                this.hLG.setVisibility(8);
            }
            if (i == 0) {
                this.hLG.setTextColor(this.hLH.getResources().getColor(R.color.common_color_10170));
            } else {
                bTu();
            }
        }
    }

    private void bTu() {
        this.hLH.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hLH.getLayoutMode().onModeChanged(this.hLG);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bYF() {
        return R.string.group_step_info_error;
    }
}

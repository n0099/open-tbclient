package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b extends d {
    protected TextView hHT;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.hHT = null;
        setContentView(R.layout.update_group_info_activity);
        wO(R.string.group_update_info);
        this.hHT = (TextView) this.hHU.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bWI() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            B(length, length, 15, 300);
            int i = 300 - length;
            this.hHT.setText(String.valueOf(i));
            if (i <= 50) {
                this.hHT.setVisibility(0);
            } else {
                this.hHT.setVisibility(8);
            }
            if (i == 0) {
                this.hHT.setTextColor(this.hHU.getResources().getColor(R.color.common_color_10170));
            } else {
                bRy();
            }
        }
    }

    private void bRy() {
        this.hHU.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hHU.getLayoutMode().onModeChanged(this.hHT);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bWJ() {
        return R.string.group_step_info_error;
    }
}

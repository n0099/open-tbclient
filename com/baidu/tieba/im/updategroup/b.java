package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends d {
    protected TextView jzt;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jzt = null;
        setContentView(R.layout.update_group_info_activity);
        BK(R.string.group_update_info);
        this.jzt = (TextView) this.jzu.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cIt() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jzt.setText(String.valueOf(i));
            if (i <= 50) {
                this.jzt.setVisibility(0);
            } else {
                this.jzt.setVisibility(8);
            }
            if (i == 0) {
                this.jzt.setTextColor(this.jzu.getResources().getColor(R.color.common_color_10170));
            } else {
                cCM();
            }
        }
    }

    private void cCM() {
        this.jzu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jzu.getLayoutMode().onModeChanged(this.jzt);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cIu() {
        return R.string.group_step_info_error;
    }
}

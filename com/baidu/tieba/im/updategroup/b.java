package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class b extends d {
    protected TextView kpu;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.kpu = null;
        setContentView(R.layout.update_group_info_activity);
        Dx(R.string.group_update_info);
        this.kpu = (TextView) this.kpv.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cVq() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            E(length, length, 15, 300);
            int i = 300 - length;
            this.kpu.setText(String.valueOf(i));
            if (i <= 50) {
                this.kpu.setVisibility(0);
            } else {
                this.kpu.setVisibility(8);
            }
            if (i == 0) {
                this.kpu.setTextColor(this.kpv.getResources().getColor(R.color.common_color_10170));
            } else {
                cPK();
            }
        }
    }

    private void cPK() {
        this.kpv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kpv.getLayoutMode().onModeChanged(this.kpu);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cVr() {
        return R.string.group_step_info_error;
    }
}

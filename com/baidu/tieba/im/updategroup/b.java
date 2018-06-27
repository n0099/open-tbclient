package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eyy;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eyy = null;
        setContentView(d.i.update_group_info_activity);
        or(d.k.group_update_info);
        this.eyy = (TextView) this.eyz.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aMF() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eyy.setText(String.valueOf(i));
            if (i <= 50) {
                this.eyy.setVisibility(0);
            } else {
                this.eyy.setVisibility(8);
            }
            if (i == 0) {
                this.eyy.setTextColor(this.eyz.getResources().getColor(d.C0142d.common_color_10170));
            } else {
                aHm();
            }
        }
    }

    private void aHm() {
        this.eyz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eyz.getLayoutMode().onModeChanged(this.eyy);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMG() {
        return d.k.group_step_info_error;
    }
}

package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView euH;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.euH = null;
        setContentView(d.i.update_group_info_activity);
        ok(d.k.group_update_info);
        this.euH = (TextView) this.euI.findViewById(d.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aLZ() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.euH.setText(String.valueOf(i));
            if (i <= 50) {
                this.euH.setVisibility(0);
            } else {
                this.euH.setVisibility(8);
            }
            if (i == 0) {
                this.euH.setTextColor(this.euI.getResources().getColor(d.C0141d.common_color_10170));
            } else {
                aGF();
            }
        }
    }

    private void aGF() {
        this.euI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.euI.getLayoutMode().onModeChanged(this.euH);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aMa() {
        return d.k.group_step_info_error;
    }
}

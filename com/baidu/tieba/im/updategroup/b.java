package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b extends d {
    protected TextView eSE;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.eSE = null;
        setContentView(e.h.update_group_info_activity);
        qa(e.j.group_update_info);
        this.eSE = (TextView) this.eSF.findViewById(e.g.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void aSC() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            u(length, length, 15, 300);
            int i = 300 - length;
            this.eSE.setText(String.valueOf(i));
            if (i <= 50) {
                this.eSE.setVisibility(0);
            } else {
                this.eSE.setVisibility(8);
            }
            if (i == 0) {
                this.eSE.setTextColor(this.eSF.getResources().getColor(e.d.common_color_10170));
            } else {
                aNl();
            }
        }
    }

    private void aNl() {
        this.eSF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eSF.getLayoutMode().onModeChanged(this.eSE);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int aSD() {
        return e.j.group_step_info_error;
    }
}

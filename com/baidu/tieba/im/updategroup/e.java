package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class e extends g {
    protected TextView biA;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.biA = null;
        setContentView(w.update_group_info_activity);
        gm(y.group_update_info);
        this.biA = (TextView) this.biB.findViewById(v.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void RK() {
        int length = this.mEditText.getText().length();
        e(length, length, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        int i = 300 - length;
        this.biA.setText(String.valueOf(i));
        if (i <= 50) {
            this.biA.setVisibility(0);
        } else {
            this.biA.setVisibility(8);
        }
        if (i == 0) {
            this.biA.setTextColor(this.biB.getResources().getColor(s.group_create_info_count_color));
        } else {
            Ld();
        }
    }

    private void Ld() {
        this.biB.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.biB.getLayoutMode().h(this.biA);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int RL() {
        return y.group_step_info_error;
    }
}

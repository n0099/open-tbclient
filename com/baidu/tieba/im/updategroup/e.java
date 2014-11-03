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
    protected TextView biO;

    public e(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.biO = null;
        setContentView(w.update_group_info_activity);
        gm(y.group_update_info);
        this.biO = (TextView) this.biP.findViewById(v.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void RN() {
        int length = this.mEditText.getText().length();
        e(length, length, 15, TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        int i = 300 - length;
        this.biO.setText(String.valueOf(i));
        if (i <= 50) {
            this.biO.setVisibility(0);
        } else {
            this.biO.setVisibility(8);
        }
        if (i == 0) {
            this.biO.setTextColor(this.biP.getResources().getColor(s.group_create_info_count_color));
        } else {
            Lh();
        }
    }

    private void Lh() {
        this.biP.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.biP.getLayoutMode().h(this.biO);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int RO() {
        return y.group_step_info_error;
    }
}

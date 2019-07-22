package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b extends d {
    protected TextView gQr;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.gQr = null;
        setContentView(R.layout.update_group_info_activity);
        vW(R.string.group_update_info);
        this.gQr = (TextView) this.gQs.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void bGC() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            z(length, length, 15, 300);
            int i = 300 - length;
            this.gQr.setText(String.valueOf(i));
            if (i <= 50) {
                this.gQr.setVisibility(0);
            } else {
                this.gQr.setVisibility(8);
            }
            if (i == 0) {
                this.gQr.setTextColor(this.gQs.getResources().getColor(R.color.common_color_10170));
            } else {
                bBn();
            }
        }
    }

    private void bBn() {
        this.gQs.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gQs.getLayoutMode().onModeChanged(this.gQr);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int bGD() {
        return R.string.group_step_info_error;
    }
}

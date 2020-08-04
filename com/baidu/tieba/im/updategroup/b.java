package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends d {
    protected TextView jku;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jku = null;
        setContentView(R.layout.update_group_info_activity);
        zr(R.string.group_update_info);
        this.jku = (TextView) this.jkv.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cxC() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jku.setText(String.valueOf(i));
            if (i <= 50) {
                this.jku.setVisibility(0);
            } else {
                this.jku.setVisibility(8);
            }
            if (i == 0) {
                this.jku.setTextColor(this.jkv.getResources().getColor(R.color.common_color_10170));
            } else {
                crV();
            }
        }
    }

    private void crV() {
        this.jkv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jkv.getLayoutMode().onModeChanged(this.jku);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cxD() {
        return R.string.group_step_info_error;
    }
}

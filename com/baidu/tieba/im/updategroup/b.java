package com.baidu.tieba.im.updategroup;

import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class b extends d {
    protected TextView jks;

    public b(UpdateGroupActivity updateGroupActivity) {
        super(updateGroupActivity);
        this.jks = null;
        setContentView(R.layout.update_group_info_activity);
        zr(R.string.group_update_info);
        this.jks = (TextView) this.jkt.findViewById(R.id.edit_count);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public void cxC() {
        String obj;
        if (this.mEditText.getText() != null && (obj = this.mEditText.getText().toString()) != null) {
            int length = obj.length();
            D(length, length, 15, 300);
            int i = 300 - length;
            this.jks.setText(String.valueOf(i));
            if (i <= 50) {
                this.jks.setVisibility(0);
            } else {
                this.jks.setVisibility(8);
            }
            if (i == 0) {
                this.jks.setTextColor(this.jkt.getResources().getColor(R.color.common_color_10170));
            } else {
                crV();
            }
        }
    }

    private void crV() {
        this.jkt.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jkt.getLayoutMode().onModeChanged(this.jks);
    }

    @Override // com.baidu.tieba.im.updategroup.a
    public int cxD() {
        return R.string.group_step_info_error;
    }
}

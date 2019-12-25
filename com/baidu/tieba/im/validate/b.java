package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes10.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private ValidateActivity hEG;
    private TextView hEH;
    private TextView hEI;
    private TextView hEJ;
    private ValidateItemData hEK;
    private View hzt;
    private HeadImageView hzu;
    private TextView hzv;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hEG = validateActivity;
        initView();
    }

    void initView() {
        this.hzt = this.mConvertView.findViewById(R.id.root_view);
        this.hzu = (HeadImageView) this.hzt.findViewById(R.id.iv_head);
        this.hzu.setIsRound(false);
        this.hEH = (TextView) this.hzt.findViewById(R.id.tv_user_name);
        this.hzv = (TextView) this.hzt.findViewById(R.id.tv_group_name);
        this.hEI = (TextView) this.hzt.findViewById(R.id.tv_apply_reason);
        this.hEJ = (TextView) this.hzt.findViewById(R.id.btn_pass);
        this.hEJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hEG.a(b.this.hEJ, 100, 0, 0L, b.this.hEK);
            }
        });
        this.hzu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hEG.a(b.this.hzu, 101, 0, 0L, b.this.hEK);
            }
        });
        this.hzt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hEG.b(b.this.hzt, 200, 0, 0L, b.this.hEK);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hEK != null) {
            this.hEG.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hEG.getLayoutMode().onModeChanged(this.hzt);
            String portrait = this.hEK.getPortrait();
            this.hzu.setTag(portrait);
            this.hzu.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hEK.getUserName())) {
                this.hEH.setText(this.hEK.getUserName());
            }
            if (!TextUtils.isEmpty(this.hEK.getGroupName())) {
                this.hzv.setText(this.hEG.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hEK.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hEK.getApplyReason())) {
                this.hEI.setText(this.hEG.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hEK.getApplyReason());
            }
            if (this.hEK.isPass()) {
                this.hEJ.setEnabled(false);
                this.hEJ.setText(this.hEG.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hEJ, (int) R.color.cp_cont_d);
                this.hEJ.setBackgroundDrawable(null);
            } else {
                this.hEJ.setEnabled(true);
                this.hEJ.setText(this.hEG.getPageContext().getString(R.string.pass));
            }
            if (!this.hEK.isShown()) {
                am.setBackgroundResource(this.hzt, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hEK = validateItemData;
    }
}

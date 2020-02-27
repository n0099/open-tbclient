package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View hEV;
    private HeadImageView hEW;
    private TextView hEX;
    private ValidateActivity hKi;
    private TextView hKj;
    private TextView hKk;
    private TextView hKl;
    private ValidateItemData hKm;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hKi = validateActivity;
        initView();
    }

    void initView() {
        this.hEV = this.mConvertView.findViewById(R.id.root_view);
        this.hEW = (HeadImageView) this.hEV.findViewById(R.id.iv_head);
        this.hEW.setIsRound(false);
        this.hKj = (TextView) this.hEV.findViewById(R.id.tv_user_name);
        this.hEX = (TextView) this.hEV.findViewById(R.id.tv_group_name);
        this.hKk = (TextView) this.hEV.findViewById(R.id.tv_apply_reason);
        this.hKl = (TextView) this.hEV.findViewById(R.id.btn_pass);
        this.hKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKi.a(b.this.hKl, 100, 0, 0L, b.this.hKm);
            }
        });
        this.hEW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKi.a(b.this.hEW, 101, 0, 0L, b.this.hKm);
            }
        });
        this.hEV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hKi.b(b.this.hEV, 200, 0, 0L, b.this.hKm);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hKm != null) {
            this.hKi.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hKi.getLayoutMode().onModeChanged(this.hEV);
            String portrait = this.hKm.getPortrait();
            this.hEW.setTag(portrait);
            this.hEW.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hKm.getUserName())) {
                this.hKj.setText(this.hKm.getUserName());
            }
            if (!TextUtils.isEmpty(this.hKm.getGroupName())) {
                this.hEX.setText(this.hKi.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hKm.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hKm.getApplyReason())) {
                this.hKk.setText(this.hKi.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hKm.getApplyReason());
            }
            if (this.hKm.isPass()) {
                this.hKl.setEnabled(false);
                this.hKl.setText(this.hKi.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hKl, (int) R.color.cp_cont_d);
                this.hKl.setBackgroundDrawable(null);
            } else {
                this.hKl.setEnabled(true);
                this.hKl.setText(this.hKi.getPageContext().getString(R.string.pass));
            }
            if (!this.hKm.isShown()) {
                am.setBackgroundResource(this.hEV, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hKm = validateItemData;
    }
}

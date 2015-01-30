package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<ValidateActivity> {
    private View awy;
    private HeadImageView bhl;
    private TextView bhm;
    private ValidateActivity bpR;
    private TextView bpS;
    private TextView bpT;
    private TextView bpU;
    private ValidateItemData bpV;

    public i(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), x.validate_item);
        this.bpR = validateActivity;
        initView();
    }

    void initView() {
        this.awy = this.mConvertView.findViewById(w.root_view);
        this.bhl = (HeadImageView) this.awy.findViewById(w.iv_head);
        this.bhl.setIsRound(false);
        this.bpS = (TextView) this.awy.findViewById(w.tv_user_name);
        this.bhm = (TextView) this.awy.findViewById(w.tv_group_name);
        this.bpT = (TextView) this.awy.findViewById(w.tv_apply_reason);
        this.bpU = (TextView) this.awy.findViewById(w.btn_pass);
        this.bpU.setOnClickListener(new j(this));
        this.bhl.setOnClickListener(new k(this));
        this.awy.setOnLongClickListener(new l(this));
    }

    public void refresh() {
        if (this.bpV != null) {
            this.bpR.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bpR.getLayoutMode().h(this.awy);
            String portrait = this.bpV.getPortrait();
            this.bhl.setTag(portrait);
            this.bhl.d(portrait, 12, false);
            if (!TextUtils.isEmpty(this.bpV.getUserName())) {
                this.bpS.setText(this.bpV.getUserName());
            }
            if (!TextUtils.isEmpty(this.bpV.getGroupName())) {
                this.bhm.setText(String.valueOf(this.bpR.getPageContext().getString(z.validate_im_apply_prefix)) + this.bpV.getGroupName());
            }
            if (!TextUtils.isEmpty(this.bpV.getApplyReason())) {
                this.bpT.setText(String.valueOf(this.bpR.getPageContext().getString(z.validate_im_reason_prefix)) + this.bpV.getApplyReason());
            }
            if (this.bpV.isPass()) {
                this.bpU.setEnabled(false);
                this.bpU.setText(this.bpR.getPageContext().getString(z.validate_im_btn_passed));
                this.bpU.setTextColor(getPageContext().getPageActivity().getResources().getColor(t.cp_cont_d));
                this.bpU.setBackgroundDrawable(null);
            } else {
                this.bpU.setEnabled(true);
                this.bpU.setText(this.bpR.getPageContext().getString(z.validate_im_btn_pass));
            }
            if (!this.bpV.isShown()) {
                bc.i(this.awy, t.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.bpV = validateItemData;
    }
}

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
    private View awv;
    private HeadImageView bhk;
    private TextView bhl;
    private ValidateActivity bpQ;
    private TextView bpR;
    private TextView bpS;
    private TextView bpT;
    private ValidateItemData bpU;

    public i(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), x.validate_item);
        this.bpQ = validateActivity;
        initView();
    }

    void initView() {
        this.awv = this.mConvertView.findViewById(w.root_view);
        this.bhk = (HeadImageView) this.awv.findViewById(w.iv_head);
        this.bhk.setIsRound(false);
        this.bpR = (TextView) this.awv.findViewById(w.tv_user_name);
        this.bhl = (TextView) this.awv.findViewById(w.tv_group_name);
        this.bpS = (TextView) this.awv.findViewById(w.tv_apply_reason);
        this.bpT = (TextView) this.awv.findViewById(w.btn_pass);
        this.bpT.setOnClickListener(new j(this));
        this.bhk.setOnClickListener(new k(this));
        this.awv.setOnLongClickListener(new l(this));
    }

    public void refresh() {
        if (this.bpU != null) {
            this.bpQ.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bpQ.getLayoutMode().h(this.awv);
            String portrait = this.bpU.getPortrait();
            this.bhk.setTag(portrait);
            this.bhk.d(portrait, 12, false);
            if (!TextUtils.isEmpty(this.bpU.getUserName())) {
                this.bpR.setText(this.bpU.getUserName());
            }
            if (!TextUtils.isEmpty(this.bpU.getGroupName())) {
                this.bhl.setText(String.valueOf(this.bpQ.getPageContext().getString(z.validate_im_apply_prefix)) + this.bpU.getGroupName());
            }
            if (!TextUtils.isEmpty(this.bpU.getApplyReason())) {
                this.bpS.setText(String.valueOf(this.bpQ.getPageContext().getString(z.validate_im_reason_prefix)) + this.bpU.getApplyReason());
            }
            if (this.bpU.isPass()) {
                this.bpT.setEnabled(false);
                this.bpT.setText(this.bpQ.getPageContext().getString(z.validate_im_btn_passed));
                this.bpT.setTextColor(getPageContext().getPageActivity().getResources().getColor(t.cp_cont_d));
                this.bpT.setBackgroundDrawable(null);
            } else {
                this.bpT.setEnabled(true);
                this.bpT.setText(this.bpQ.getPageContext().getString(z.validate_im_btn_pass));
            }
            if (!this.bpU.isShown()) {
                bc.i(this.awv, t.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.bpU = validateItemData;
    }
}

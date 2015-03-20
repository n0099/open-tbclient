package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.s;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<ValidateActivity> {
    private View aCi;
    private HeadImageView biA;
    private TextView biB;
    private ValidateActivity bnH;
    private TextView bnI;
    private TextView bnJ;
    private TextView bnK;
    private ValidateItemData bnL;

    public i(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), w.validate_item);
        this.bnH = validateActivity;
        initView();
    }

    void initView() {
        this.aCi = this.mConvertView.findViewById(v.root_view);
        this.biA = (HeadImageView) this.aCi.findViewById(v.iv_head);
        this.biA.setIsRound(false);
        this.bnI = (TextView) this.aCi.findViewById(v.tv_user_name);
        this.biB = (TextView) this.aCi.findViewById(v.tv_group_name);
        this.bnJ = (TextView) this.aCi.findViewById(v.tv_apply_reason);
        this.bnK = (TextView) this.aCi.findViewById(v.btn_pass);
        this.bnK.setOnClickListener(new j(this));
        this.biA.setOnClickListener(new k(this));
        this.aCi.setOnLongClickListener(new l(this));
    }

    public void refresh() {
        if (this.bnL != null) {
            this.bnH.getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
            this.bnH.getLayoutMode().h(this.aCi);
            String portrait = this.bnL.getPortrait();
            this.biA.setTag(portrait);
            this.biA.c(portrait, 12, false);
            if (!TextUtils.isEmpty(this.bnL.getUserName())) {
                this.bnI.setText(this.bnL.getUserName());
            }
            if (!TextUtils.isEmpty(this.bnL.getGroupName())) {
                this.biB.setText(String.valueOf(this.bnH.getPageContext().getString(y.validate_im_apply_prefix)) + this.bnL.getGroupName());
            }
            if (!TextUtils.isEmpty(this.bnL.getApplyReason())) {
                this.bnJ.setText(String.valueOf(this.bnH.getPageContext().getString(y.validate_im_reason_prefix)) + this.bnL.getApplyReason());
            }
            if (this.bnL.isPass()) {
                this.bnK.setEnabled(false);
                this.bnK.setText(this.bnH.getPageContext().getString(y.validate_im_btn_passed));
                this.bnK.setTextColor(getPageContext().getPageActivity().getResources().getColor(s.cp_cont_d));
                this.bnK.setBackgroundDrawable(null);
            } else {
                this.bnK.setEnabled(true);
                this.bnK.setText(this.bnH.getPageContext().getString(y.validate_im_btn_pass));
            }
            if (!this.bnL.isShown()) {
                ba.i(this.aCi, s.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.bnL = validateItemData;
    }
}

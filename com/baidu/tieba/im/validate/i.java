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
    private View aCq;
    private HeadImageView biQ;
    private TextView biR;
    private ValidateActivity bnX;
    private TextView bnY;
    private TextView bnZ;
    private TextView boa;
    private ValidateItemData bob;

    public i(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), w.validate_item);
        this.bnX = validateActivity;
        initView();
    }

    void initView() {
        this.aCq = this.mConvertView.findViewById(v.root_view);
        this.biQ = (HeadImageView) this.aCq.findViewById(v.iv_head);
        this.biQ.setIsRound(false);
        this.bnY = (TextView) this.aCq.findViewById(v.tv_user_name);
        this.biR = (TextView) this.aCq.findViewById(v.tv_group_name);
        this.bnZ = (TextView) this.aCq.findViewById(v.tv_apply_reason);
        this.boa = (TextView) this.aCq.findViewById(v.btn_pass);
        this.boa.setOnClickListener(new j(this));
        this.biQ.setOnClickListener(new k(this));
        this.aCq.setOnLongClickListener(new l(this));
    }

    public void refresh() {
        if (this.bob != null) {
            this.bnX.getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
            this.bnX.getLayoutMode().h(this.aCq);
            String portrait = this.bob.getPortrait();
            this.biQ.setTag(portrait);
            this.biQ.c(portrait, 12, false);
            if (!TextUtils.isEmpty(this.bob.getUserName())) {
                this.bnY.setText(this.bob.getUserName());
            }
            if (!TextUtils.isEmpty(this.bob.getGroupName())) {
                this.biR.setText(String.valueOf(this.bnX.getPageContext().getString(y.validate_im_apply_prefix)) + this.bob.getGroupName());
            }
            if (!TextUtils.isEmpty(this.bob.getApplyReason())) {
                this.bnZ.setText(String.valueOf(this.bnX.getPageContext().getString(y.validate_im_reason_prefix)) + this.bob.getApplyReason());
            }
            if (this.bob.isPass()) {
                this.boa.setEnabled(false);
                this.boa.setText(this.bnX.getPageContext().getString(y.validate_im_btn_passed));
                this.boa.setTextColor(getPageContext().getPageActivity().getResources().getColor(s.cp_cont_d));
                this.boa.setBackgroundDrawable(null);
            } else {
                this.boa.setEnabled(true);
                this.boa.setText(this.bnX.getPageContext().getString(y.validate_im_btn_pass));
            }
            if (!this.bob.isShown()) {
                ba.i(this.aCq, s.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.bob = validateItemData;
    }
}

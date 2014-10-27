package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.d<ValidateItemData> {
    private View bbX;
    private HeadImageView bbY;
    private TextView bbZ;
    private ValidateActivity biS;
    private TextView biT;
    private TextView biU;
    private TextView biV;
    private ValidateItemData biW;

    public h(ValidateActivity validateActivity) {
        super(validateActivity, w.validate_item);
        this.biS = validateActivity;
        nu();
    }

    void nu() {
        this.bbX = this.ay.findViewById(v.root_view);
        this.bbY = (HeadImageView) this.bbX.findViewById(v.iv_head);
        this.bbY.setIsRound(false);
        this.biT = (TextView) this.bbX.findViewById(v.tv_user_name);
        this.bbZ = (TextView) this.bbX.findViewById(v.tv_group_name);
        this.biU = (TextView) this.bbX.findViewById(v.tv_apply_reason);
        this.biV = (TextView) this.bbX.findViewById(v.btn_pass);
        this.biV.setOnClickListener(new i(this));
        this.bbY.setOnClickListener(new j(this));
        this.bbX.setOnLongClickListener(new k(this));
    }

    public void refresh() {
        if (this.biW != null) {
            this.biS.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.biS.getLayoutMode().h(this.bbX);
            String portrait = this.biW.getPortrait();
            this.bbY.setTag(portrait);
            this.bbY.c(portrait, 12, false);
            if (!TextUtils.isEmpty(this.biW.getUserName())) {
                this.biT.setText(this.biW.getUserName());
            }
            if (!TextUtils.isEmpty(this.biW.getGroupName())) {
                this.bbZ.setText(String.valueOf(this.biS.getString(y.validate_im_apply_prefix)) + this.biW.getGroupName());
            }
            if (!TextUtils.isEmpty(this.biW.getApplyReason())) {
                this.biU.setText(String.valueOf(this.biS.getString(y.validate_im_reason_prefix)) + this.biW.getApplyReason());
            }
            if (this.biW.isPass()) {
                this.biV.setEnabled(false);
                this.biV.setText(this.biS.getString(y.validate_im_btn_passed));
                this.biV.setTextColor(getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                this.biV.setBackgroundDrawable(null);
            } else {
                this.biV.setEnabled(true);
                this.biV.setText(this.biS.getString(y.validate_im_btn_pass));
            }
            if (!this.biW.isShown()) {
                aw.h(this.bbX, com.baidu.tieba.s.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.biW = validateItemData;
    }
}

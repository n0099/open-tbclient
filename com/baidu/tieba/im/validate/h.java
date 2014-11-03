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
    private View bcl;
    private HeadImageView bcm;
    private TextView bcn;
    private ValidateActivity bjg;
    private TextView bjh;
    private TextView bji;
    private TextView bjj;
    private ValidateItemData bjk;

    public h(ValidateActivity validateActivity) {
        super(validateActivity, w.validate_item);
        this.bjg = validateActivity;
        nu();
    }

    void nu() {
        this.bcl = this.ay.findViewById(v.root_view);
        this.bcm = (HeadImageView) this.bcl.findViewById(v.iv_head);
        this.bcm.setIsRound(false);
        this.bjh = (TextView) this.bcl.findViewById(v.tv_user_name);
        this.bcn = (TextView) this.bcl.findViewById(v.tv_group_name);
        this.bji = (TextView) this.bcl.findViewById(v.tv_apply_reason);
        this.bjj = (TextView) this.bcl.findViewById(v.btn_pass);
        this.bjj.setOnClickListener(new i(this));
        this.bcm.setOnClickListener(new j(this));
        this.bcl.setOnLongClickListener(new k(this));
    }

    public void refresh() {
        if (this.bjk != null) {
            this.bjg.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
            this.bjg.getLayoutMode().h(this.bcl);
            String portrait = this.bjk.getPortrait();
            this.bcm.setTag(portrait);
            this.bcm.c(portrait, 12, false);
            if (!TextUtils.isEmpty(this.bjk.getUserName())) {
                this.bjh.setText(this.bjk.getUserName());
            }
            if (!TextUtils.isEmpty(this.bjk.getGroupName())) {
                this.bcn.setText(String.valueOf(this.bjg.getString(y.validate_im_apply_prefix)) + this.bjk.getGroupName());
            }
            if (!TextUtils.isEmpty(this.bjk.getApplyReason())) {
                this.bji.setText(String.valueOf(this.bjg.getString(y.validate_im_reason_prefix)) + this.bjk.getApplyReason());
            }
            if (this.bjk.isPass()) {
                this.bjj.setEnabled(false);
                this.bjj.setText(this.bjg.getString(y.validate_im_btn_passed));
                this.bjj.setTextColor(getContext().getResources().getColor(com.baidu.tieba.s.cp_cont_d));
                this.bjj.setBackgroundDrawable(null);
            } else {
                this.bjj.setEnabled(true);
                this.bjj.setText(this.bjg.getString(y.validate_im_btn_pass));
            }
            if (!this.bjk.isShown()) {
                aw.h(this.bcl, com.baidu.tieba.s.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.bjk = validateItemData;
    }
}

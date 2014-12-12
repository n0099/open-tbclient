package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.t;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<ValidateActivity> {
    private View avy;
    private HeadImageView bfT;
    private TextView bfU;
    private ValidateActivity bou;
    private TextView bov;
    private TextView bow;
    private TextView box;
    private ValidateItemData boy;

    public i(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), x.validate_item);
        this.bou = validateActivity;
        initView();
    }

    void initView() {
        this.avy = this.mConvertView.findViewById(w.root_view);
        this.bfT = (HeadImageView) this.avy.findViewById(w.iv_head);
        this.bfT.setIsRound(false);
        this.bov = (TextView) this.avy.findViewById(w.tv_user_name);
        this.bfU = (TextView) this.avy.findViewById(w.tv_group_name);
        this.bow = (TextView) this.avy.findViewById(w.tv_apply_reason);
        this.box = (TextView) this.avy.findViewById(w.btn_pass);
        this.box.setOnClickListener(new j(this));
        this.bfT.setOnClickListener(new k(this));
        this.avy.setOnLongClickListener(new l(this));
    }

    public void refresh() {
        if (this.boy != null) {
            this.bou.getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
            this.bou.getLayoutMode().h(this.avy);
            String portrait = this.boy.getPortrait();
            this.bfT.setTag(portrait);
            this.bfT.d(portrait, 12, false);
            if (!TextUtils.isEmpty(this.boy.getUserName())) {
                this.bov.setText(this.boy.getUserName());
            }
            if (!TextUtils.isEmpty(this.boy.getGroupName())) {
                this.bfU.setText(String.valueOf(this.bou.getPageContext().getString(z.validate_im_apply_prefix)) + this.boy.getGroupName());
            }
            if (!TextUtils.isEmpty(this.boy.getApplyReason())) {
                this.bow.setText(String.valueOf(this.bou.getPageContext().getString(z.validate_im_reason_prefix)) + this.boy.getApplyReason());
            }
            if (this.boy.isPass()) {
                this.box.setEnabled(false);
                this.box.setText(this.bou.getPageContext().getString(z.validate_im_btn_passed));
                this.box.setTextColor(getPageContext().getPageActivity().getResources().getColor(t.cp_cont_d));
                this.box.setBackgroundDrawable(null);
            } else {
                this.box.setEnabled(true);
                this.box.setText(this.bou.getPageContext().getString(z.validate_im_btn_pass));
            }
            if (!this.boy.isShown()) {
                ax.i(this.avy, t.validate_item_background_sean);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.boy = validateItemData;
    }
}

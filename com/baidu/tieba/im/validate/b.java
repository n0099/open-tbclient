package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View eYa;
    private HeadImageView eYb;
    private TextView eYc;
    private ValidateActivity fdn;
    private TextView fdo;
    private TextView fdp;
    private TextView fdq;
    private ValidateItemData fdr;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.fdn = validateActivity;
        initView();
    }

    void initView() {
        this.eYa = this.vo.findViewById(e.g.root_view);
        this.eYb = (HeadImageView) this.eYa.findViewById(e.g.iv_head);
        this.eYb.setIsRound(false);
        this.fdo = (TextView) this.eYa.findViewById(e.g.tv_user_name);
        this.eYc = (TextView) this.eYa.findViewById(e.g.tv_group_name);
        this.fdp = (TextView) this.eYa.findViewById(e.g.tv_apply_reason);
        this.fdq = (TextView) this.eYa.findViewById(e.g.btn_pass);
        this.fdq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fdn.a(b.this.fdq, 100, 0, 0L, b.this.fdr);
            }
        });
        this.eYb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fdn.a(b.this.eYb, 101, 0, 0L, b.this.fdr);
            }
        });
        this.eYa.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.fdn.b(b.this.eYa, 200, 0, 0L, b.this.fdr);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.fdr != null) {
            this.fdn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.fdn.getLayoutMode().onModeChanged(this.eYa);
            String portrait = this.fdr.getPortrait();
            this.eYb.setTag(portrait);
            this.eYb.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.fdr.getUserName())) {
                this.fdo.setText(this.fdr.getUserName());
            }
            if (!TextUtils.isEmpty(this.fdr.getGroupName())) {
                this.eYc.setText(this.fdn.getPageContext().getString(e.j.validate_im_apply_prefix) + this.fdr.getGroupName());
            }
            if (!TextUtils.isEmpty(this.fdr.getApplyReason())) {
                this.fdp.setText(this.fdn.getPageContext().getString(e.j.validate_im_reason_prefix) + this.fdr.getApplyReason());
            }
            if (this.fdr.isPass()) {
                this.fdq.setEnabled(false);
                this.fdq.setText(this.fdn.getPageContext().getString(e.j.passed));
                al.h(this.fdq, e.d.cp_cont_d);
                this.fdq.setBackgroundDrawable(null);
            } else {
                this.fdq.setEnabled(true);
                this.fdq.setText(this.fdn.getPageContext().getString(e.j.pass));
            }
            if (!this.fdr.isShown()) {
                al.i(this.eYa, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.fdr = validateItemData;
    }
}

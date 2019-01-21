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
    private View eYb;
    private HeadImageView eYc;
    private TextView eYd;
    private ValidateActivity fdo;
    private TextView fdp;
    private TextView fdq;
    private TextView fdr;
    private ValidateItemData fds;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.fdo = validateActivity;
        initView();
    }

    void initView() {
        this.eYb = this.vo.findViewById(e.g.root_view);
        this.eYc = (HeadImageView) this.eYb.findViewById(e.g.iv_head);
        this.eYc.setIsRound(false);
        this.fdp = (TextView) this.eYb.findViewById(e.g.tv_user_name);
        this.eYd = (TextView) this.eYb.findViewById(e.g.tv_group_name);
        this.fdq = (TextView) this.eYb.findViewById(e.g.tv_apply_reason);
        this.fdr = (TextView) this.eYb.findViewById(e.g.btn_pass);
        this.fdr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fdo.a(b.this.fdr, 100, 0, 0L, b.this.fds);
            }
        });
        this.eYc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fdo.a(b.this.eYc, 101, 0, 0L, b.this.fds);
            }
        });
        this.eYb.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.fdo.b(b.this.eYb, 200, 0, 0L, b.this.fds);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.fds != null) {
            this.fdo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.fdo.getLayoutMode().onModeChanged(this.eYb);
            String portrait = this.fds.getPortrait();
            this.eYc.setTag(portrait);
            this.eYc.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.fds.getUserName())) {
                this.fdp.setText(this.fds.getUserName());
            }
            if (!TextUtils.isEmpty(this.fds.getGroupName())) {
                this.eYd.setText(this.fdo.getPageContext().getString(e.j.validate_im_apply_prefix) + this.fds.getGroupName());
            }
            if (!TextUtils.isEmpty(this.fds.getApplyReason())) {
                this.fdq.setText(this.fdo.getPageContext().getString(e.j.validate_im_reason_prefix) + this.fds.getApplyReason());
            }
            if (this.fds.isPass()) {
                this.fdr.setEnabled(false);
                this.fdr.setText(this.fdo.getPageContext().getString(e.j.passed));
                al.h(this.fdr, e.d.cp_cont_d);
                this.fdr.setBackgroundDrawable(null);
            } else {
                this.fdr.setEnabled(true);
                this.fdr.setText(this.fdo.getPageContext().getString(e.j.pass));
            }
            if (!this.fds.isShown()) {
                al.i(this.eYb, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.fds = validateItemData;
    }
}

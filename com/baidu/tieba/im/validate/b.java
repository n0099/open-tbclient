package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private ValidateActivity eCB;
    private TextView eCC;
    private TextView eCD;
    private TextView eCE;
    private ValidateItemData eCF;
    private View exm;
    private HeadImageView exn;
    private TextView exo;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), f.h.validate_item);
        this.eCB = validateActivity;
        initView();
    }

    void initView() {
        this.exm = this.rW.findViewById(f.g.root_view);
        this.exn = (HeadImageView) this.exm.findViewById(f.g.iv_head);
        this.exn.setIsRound(false);
        this.eCC = (TextView) this.exm.findViewById(f.g.tv_user_name);
        this.exo = (TextView) this.exm.findViewById(f.g.tv_group_name);
        this.eCD = (TextView) this.exm.findViewById(f.g.tv_apply_reason);
        this.eCE = (TextView) this.exm.findViewById(f.g.btn_pass);
        this.eCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eCB.a(b.this.eCE, 100, 0, 0L, b.this.eCF);
            }
        });
        this.exn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eCB.a(b.this.exn, 101, 0, 0L, b.this.eCF);
            }
        });
        this.exm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eCB.b(b.this.exm, 200, 0, 0L, b.this.eCF);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eCF != null) {
            this.eCB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eCB.getLayoutMode().onModeChanged(this.exm);
            String portrait = this.eCF.getPortrait();
            this.exn.setTag(portrait);
            this.exn.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eCF.getUserName())) {
                this.eCC.setText(this.eCF.getUserName());
            }
            if (!TextUtils.isEmpty(this.eCF.getGroupName())) {
                this.exo.setText(this.eCB.getPageContext().getString(f.j.validate_im_apply_prefix) + this.eCF.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eCF.getApplyReason())) {
                this.eCD.setText(this.eCB.getPageContext().getString(f.j.validate_im_reason_prefix) + this.eCF.getApplyReason());
            }
            if (this.eCF.isPass()) {
                this.eCE.setEnabled(false);
                this.eCE.setText(this.eCB.getPageContext().getString(f.j.passed));
                am.h(this.eCE, f.d.cp_cont_d);
                this.eCE.setBackgroundDrawable(null);
            } else {
                this.eCE.setEnabled(true);
                this.eCE.setText(this.eCB.getPageContext().getString(f.j.pass));
            }
            if (!this.eCF.isShown()) {
                am.i(this.exm, f.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eCF = validateItemData;
    }
}

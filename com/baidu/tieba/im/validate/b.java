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
    private View eMo;
    private HeadImageView eMp;
    private TextView eMq;
    private ValidateActivity eRB;
    private TextView eRC;
    private TextView eRD;
    private TextView eRE;
    private ValidateItemData eRF;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.eRB = validateActivity;
        initView();
    }

    void initView() {
        this.eMo = this.vm.findViewById(e.g.root_view);
        this.eMp = (HeadImageView) this.eMo.findViewById(e.g.iv_head);
        this.eMp.setIsRound(false);
        this.eRC = (TextView) this.eMo.findViewById(e.g.tv_user_name);
        this.eMq = (TextView) this.eMo.findViewById(e.g.tv_group_name);
        this.eRD = (TextView) this.eMo.findViewById(e.g.tv_apply_reason);
        this.eRE = (TextView) this.eMo.findViewById(e.g.btn_pass);
        this.eRE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eRB.a(b.this.eRE, 100, 0, 0L, b.this.eRF);
            }
        });
        this.eMp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eRB.a(b.this.eMp, 101, 0, 0L, b.this.eRF);
            }
        });
        this.eMo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eRB.b(b.this.eMo, 200, 0, 0L, b.this.eRF);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eRF != null) {
            this.eRB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eRB.getLayoutMode().onModeChanged(this.eMo);
            String portrait = this.eRF.getPortrait();
            this.eMp.setTag(portrait);
            this.eMp.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eRF.getUserName())) {
                this.eRC.setText(this.eRF.getUserName());
            }
            if (!TextUtils.isEmpty(this.eRF.getGroupName())) {
                this.eMq.setText(this.eRB.getPageContext().getString(e.j.validate_im_apply_prefix) + this.eRF.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eRF.getApplyReason())) {
                this.eRD.setText(this.eRB.getPageContext().getString(e.j.validate_im_reason_prefix) + this.eRF.getApplyReason());
            }
            if (this.eRF.isPass()) {
                this.eRE.setEnabled(false);
                this.eRE.setText(this.eRB.getPageContext().getString(e.j.passed));
                al.h(this.eRE, e.d.cp_cont_d);
                this.eRE.setBackgroundDrawable(null);
            } else {
                this.eRE.setEnabled(true);
                this.eRE.setText(this.eRB.getPageContext().getString(e.j.pass));
            }
            if (!this.eRF.isShown()) {
                al.i(this.eMo, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eRF = validateItemData;
    }
}

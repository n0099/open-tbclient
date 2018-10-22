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
    private View eMp;
    private HeadImageView eMq;
    private TextView eMr;
    private ValidateActivity eRC;
    private TextView eRD;
    private TextView eRE;
    private TextView eRF;
    private ValidateItemData eRG;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.eRC = validateActivity;
        initView();
    }

    void initView() {
        this.eMp = this.vm.findViewById(e.g.root_view);
        this.eMq = (HeadImageView) this.eMp.findViewById(e.g.iv_head);
        this.eMq.setIsRound(false);
        this.eRD = (TextView) this.eMp.findViewById(e.g.tv_user_name);
        this.eMr = (TextView) this.eMp.findViewById(e.g.tv_group_name);
        this.eRE = (TextView) this.eMp.findViewById(e.g.tv_apply_reason);
        this.eRF = (TextView) this.eMp.findViewById(e.g.btn_pass);
        this.eRF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eRC.a(b.this.eRF, 100, 0, 0L, b.this.eRG);
            }
        });
        this.eMq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eRC.a(b.this.eMq, 101, 0, 0L, b.this.eRG);
            }
        });
        this.eMp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eRC.b(b.this.eMp, 200, 0, 0L, b.this.eRG);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eRG != null) {
            this.eRC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eRC.getLayoutMode().onModeChanged(this.eMp);
            String portrait = this.eRG.getPortrait();
            this.eMq.setTag(portrait);
            this.eMq.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eRG.getUserName())) {
                this.eRD.setText(this.eRG.getUserName());
            }
            if (!TextUtils.isEmpty(this.eRG.getGroupName())) {
                this.eMr.setText(this.eRC.getPageContext().getString(e.j.validate_im_apply_prefix) + this.eRG.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eRG.getApplyReason())) {
                this.eRE.setText(this.eRC.getPageContext().getString(e.j.validate_im_reason_prefix) + this.eRG.getApplyReason());
            }
            if (this.eRG.isPass()) {
                this.eRF.setEnabled(false);
                this.eRF.setText(this.eRC.getPageContext().getString(e.j.passed));
                al.h(this.eRF, e.d.cp_cont_d);
                this.eRF.setBackgroundDrawable(null);
            } else {
                this.eRF.setEnabled(true);
                this.eRF.setText(this.eRC.getPageContext().getString(e.j.pass));
            }
            if (!this.eRG.isShown()) {
                al.i(this.eMp, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eRG = validateItemData;
    }
}

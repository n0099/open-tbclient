package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View gnV;
    private HeadImageView gnW;
    private TextView gnX;
    private ValidateActivity gti;
    private TextView gtj;
    private TextView gtk;
    private TextView gtl;
    private ValidateItemData gtm;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.gti = validateActivity;
        initView();
    }

    void initView() {
        this.gnV = this.vk.findViewById(d.g.root_view);
        this.gnW = (HeadImageView) this.gnV.findViewById(d.g.iv_head);
        this.gnW.setIsRound(false);
        this.gtj = (TextView) this.gnV.findViewById(d.g.tv_user_name);
        this.gnX = (TextView) this.gnV.findViewById(d.g.tv_group_name);
        this.gtk = (TextView) this.gnV.findViewById(d.g.tv_apply_reason);
        this.gtl = (TextView) this.gnV.findViewById(d.g.btn_pass);
        this.gtl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gti.a(b.this.gtl, 100, 0, 0L, b.this.gtm);
            }
        });
        this.gnW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gti.a(b.this.gnW, 101, 0, 0L, b.this.gtm);
            }
        });
        this.gnV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gti.b(b.this.gnV, 200, 0, 0L, b.this.gtm);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gtm != null) {
            this.gti.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gti.getLayoutMode().onModeChanged(this.gnV);
            String portrait = this.gtm.getPortrait();
            this.gnW.setTag(portrait);
            this.gnW.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gtm.getUserName())) {
                this.gtj.setText(this.gtm.getUserName());
            }
            if (!TextUtils.isEmpty(this.gtm.getGroupName())) {
                this.gnX.setText(this.gti.getPageContext().getString(d.j.validate_im_apply_prefix) + this.gtm.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gtm.getApplyReason())) {
                this.gtk.setText(this.gti.getPageContext().getString(d.j.validate_im_reason_prefix) + this.gtm.getApplyReason());
            }
            if (this.gtm.isPass()) {
                this.gtl.setEnabled(false);
                this.gtl.setText(this.gti.getPageContext().getString(d.j.passed));
                al.j(this.gtl, d.C0277d.cp_cont_d);
                this.gtl.setBackgroundDrawable(null);
            } else {
                this.gtl.setEnabled(true);
                this.gtl.setText(this.gti.getPageContext().getString(d.j.pass));
            }
            if (!this.gtm.isShown()) {
                al.k(this.gnV, d.C0277d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gtm = validateItemData;
    }
}

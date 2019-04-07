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
    private View gnU;
    private HeadImageView gnV;
    private TextView gnW;
    private ValidateActivity gth;
    private TextView gti;
    private TextView gtj;
    private TextView gtk;
    private ValidateItemData gtl;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.gth = validateActivity;
        initView();
    }

    void initView() {
        this.gnU = this.vk.findViewById(d.g.root_view);
        this.gnV = (HeadImageView) this.gnU.findViewById(d.g.iv_head);
        this.gnV.setIsRound(false);
        this.gti = (TextView) this.gnU.findViewById(d.g.tv_user_name);
        this.gnW = (TextView) this.gnU.findViewById(d.g.tv_group_name);
        this.gtj = (TextView) this.gnU.findViewById(d.g.tv_apply_reason);
        this.gtk = (TextView) this.gnU.findViewById(d.g.btn_pass);
        this.gtk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gth.a(b.this.gtk, 100, 0, 0L, b.this.gtl);
            }
        });
        this.gnV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gth.a(b.this.gnV, 101, 0, 0L, b.this.gtl);
            }
        });
        this.gnU.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gth.b(b.this.gnU, 200, 0, 0L, b.this.gtl);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gtl != null) {
            this.gth.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gth.getLayoutMode().onModeChanged(this.gnU);
            String portrait = this.gtl.getPortrait();
            this.gnV.setTag(portrait);
            this.gnV.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gtl.getUserName())) {
                this.gti.setText(this.gtl.getUserName());
            }
            if (!TextUtils.isEmpty(this.gtl.getGroupName())) {
                this.gnW.setText(this.gth.getPageContext().getString(d.j.validate_im_apply_prefix) + this.gtl.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gtl.getApplyReason())) {
                this.gtj.setText(this.gth.getPageContext().getString(d.j.validate_im_reason_prefix) + this.gtl.getApplyReason());
            }
            if (this.gtl.isPass()) {
                this.gtk.setEnabled(false);
                this.gtk.setText(this.gth.getPageContext().getString(d.j.passed));
                al.j(this.gtk, d.C0277d.cp_cont_d);
                this.gtk.setBackgroundDrawable(null);
            } else {
                this.gtk.setEnabled(true);
                this.gtk.setText(this.gth.getPageContext().getString(d.j.pass));
            }
            if (!this.gtl.isShown()) {
                al.k(this.gnU, d.C0277d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gtl = validateItemData;
    }
}

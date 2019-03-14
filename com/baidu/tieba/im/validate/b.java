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
    private View goh;
    private HeadImageView goi;
    private TextView goj;
    private ValidateActivity gtu;
    private TextView gtv;
    private TextView gtw;
    private TextView gtx;
    private ValidateItemData gty;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.gtu = validateActivity;
        initView();
    }

    void initView() {
        this.goh = this.vk.findViewById(d.g.root_view);
        this.goi = (HeadImageView) this.goh.findViewById(d.g.iv_head);
        this.goi.setIsRound(false);
        this.gtv = (TextView) this.goh.findViewById(d.g.tv_user_name);
        this.goj = (TextView) this.goh.findViewById(d.g.tv_group_name);
        this.gtw = (TextView) this.goh.findViewById(d.g.tv_apply_reason);
        this.gtx = (TextView) this.goh.findViewById(d.g.btn_pass);
        this.gtx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gtu.a(b.this.gtx, 100, 0, 0L, b.this.gty);
            }
        });
        this.goi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gtu.a(b.this.goi, 101, 0, 0L, b.this.gty);
            }
        });
        this.goh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gtu.b(b.this.goh, 200, 0, 0L, b.this.gty);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gty != null) {
            this.gtu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gtu.getLayoutMode().onModeChanged(this.goh);
            String portrait = this.gty.getPortrait();
            this.goi.setTag(portrait);
            this.goi.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gty.getUserName())) {
                this.gtv.setText(this.gty.getUserName());
            }
            if (!TextUtils.isEmpty(this.gty.getGroupName())) {
                this.goj.setText(this.gtu.getPageContext().getString(d.j.validate_im_apply_prefix) + this.gty.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gty.getApplyReason())) {
                this.gtw.setText(this.gtu.getPageContext().getString(d.j.validate_im_reason_prefix) + this.gty.getApplyReason());
            }
            if (this.gty.isPass()) {
                this.gtx.setEnabled(false);
                this.gtx.setText(this.gtu.getPageContext().getString(d.j.passed));
                al.j(this.gtx, d.C0277d.cp_cont_d);
                this.gtx.setBackgroundDrawable(null);
            } else {
                this.gtx.setEnabled(true);
                this.gtx.setText(this.gtu.getPageContext().getString(d.j.pass));
            }
            if (!this.gty.isShown()) {
                al.k(this.goh, d.C0277d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gty = validateItemData;
    }
}

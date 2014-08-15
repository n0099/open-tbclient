package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.d<ValidateItemData> {
    private View b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ValidateActivity h;
    private ValidateItemData i;

    public h(ValidateActivity validateActivity) {
        super(validateActivity, v.validate_item);
        this.h = validateActivity;
        b();
    }

    void b() {
        this.b = this.a.findViewById(u.root_view);
        this.c = (HeadImageView) this.b.findViewById(u.iv_head);
        this.c.setIsRound(true);
        this.d = (TextView) this.b.findViewById(u.tv_user_name);
        this.e = (TextView) this.b.findViewById(u.tv_group_name);
        this.f = (TextView) this.b.findViewById(u.tv_apply_reason);
        this.g = (TextView) this.b.findViewById(u.btn_pass);
        this.g.setOnClickListener(new i(this));
        this.c.setOnClickListener(new j(this));
        this.b.setOnLongClickListener(new k(this));
    }

    public void c() {
        if (this.i != null) {
            this.h.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.h.getLayoutMode().a(this.b);
            String portrait = this.i.getPortrait();
            this.c.setTag(portrait);
            this.c.a(portrait, 12, false);
            if (!TextUtils.isEmpty(this.i.getUserName())) {
                this.d.setText(this.i.getUserName());
            }
            if (!TextUtils.isEmpty(this.i.getGroupName())) {
                this.e.setText(String.valueOf(this.h.getString(x.validate_im_apply_prefix)) + this.i.getGroupName());
            }
            if (!TextUtils.isEmpty(this.i.getApplyReason())) {
                this.f.setText(String.valueOf(this.h.getString(x.validate_im_reason_prefix)) + this.i.getApplyReason());
            }
            if (this.i.isPass()) {
                this.g.setEnabled(false);
                this.g.setText(this.h.getString(x.validate_im_btn_passed));
            } else {
                this.g.setEnabled(true);
                this.g.setText(this.h.getString(x.validate_im_btn_pass));
            }
            if (!this.i.isShown()) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.b.setBackgroundResource(com.baidu.tieba.r.validate_item_background_sean_1);
                } else {
                    this.b.setBackgroundResource(com.baidu.tieba.r.validate_item_background_sean);
                }
            }
        }
    }

    public void a(ValidateItemData validateItemData) {
        b(validateItemData);
        c();
    }

    public void b(ValidateItemData validateItemData) {
        this.i = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.a.d<ValidateItemData> {
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ValidateActivity i;
    private ValidateItemData j;

    public i(ValidateActivity validateActivity) {
        super(validateActivity, com.baidu.tieba.im.i.validate_item);
        this.i = validateActivity;
        this.c = this.a.findViewById(com.baidu.tieba.im.h.root_view);
        this.d = (HeadImageView) this.c.findViewById(com.baidu.tieba.im.h.iv_head);
        this.d.setIsRound(true);
        this.e = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_user_name);
        this.f = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_group_name);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.im.h.tv_apply_reason);
        this.h = (TextView) this.c.findViewById(com.baidu.tieba.im.h.btn_pass);
        this.h.setOnClickListener(new j(this));
        this.d.setOnClickListener(new k(this));
        this.c.setOnLongClickListener(new l(this));
    }

    public final void d() {
        if (this.j != null) {
            this.i.getLayoutMode().a(TbadkApplication.j().l() == 1);
            this.i.getLayoutMode().a(this.c);
            String portrait = this.j.getPortrait();
            this.d.setTag(portrait);
            this.i.a().d(portrait, new m(this));
            if (!TextUtils.isEmpty(this.j.getUserName())) {
                this.e.setText(this.j.getUserName());
            }
            if (!TextUtils.isEmpty(this.j.getGroupName())) {
                this.f.setText(String.valueOf(this.i.getString(com.baidu.tieba.im.j.validate_im_apply_prefix)) + this.j.getGroupName());
            }
            if (!TextUtils.isEmpty(this.j.getApplyReason())) {
                this.g.setText(String.valueOf(this.i.getString(com.baidu.tieba.im.j.validate_im_reason_prefix)) + this.j.getApplyReason());
            }
            if (this.j.isPass()) {
                this.h.setEnabled(false);
                this.h.setText(this.i.getString(com.baidu.tieba.im.j.validate_im_btn_passed));
            } else {
                this.h.setEnabled(true);
                this.h.setText(this.i.getString(com.baidu.tieba.im.j.validate_im_btn_pass));
            }
            com.baidu.adp.lib.util.f.e("isShown:" + this.j.isShown());
            if (!this.j.isShown()) {
                if (TbadkApplication.j().l() == 1) {
                    this.c.setBackgroundResource(com.baidu.tieba.im.e.validate_item_background_sean_1);
                } else {
                    this.c.setBackgroundResource(com.baidu.tieba.im.e.validate_item_background_sean);
                }
            }
        }
    }

    public final void a(ValidateItemData validateItemData) {
        this.j = validateItemData;
    }
}

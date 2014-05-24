package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.a<ValidateItemData> {
    private View b;
    private HeadImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private ValidateActivity h;
    private ValidateItemData i;

    public i(ValidateActivity validateActivity) {
        super(validateActivity, w.validate_item);
        this.h = validateActivity;
        b();
    }

    void b() {
        this.b = this.a.findViewById(v.root_view);
        this.c = (HeadImageView) this.b.findViewById(v.iv_head);
        this.c.setIsRound(true);
        this.d = (TextView) this.b.findViewById(v.tv_user_name);
        this.e = (TextView) this.b.findViewById(v.tv_group_name);
        this.f = (TextView) this.b.findViewById(v.tv_apply_reason);
        this.g = (TextView) this.b.findViewById(v.btn_pass);
        this.g.setOnClickListener(new j(this));
        this.c.setOnClickListener(new k(this));
        this.b.setOnLongClickListener(new l(this));
    }

    public void c() {
        if (this.i != null) {
            this.h.getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
            this.h.getLayoutMode().a(this.b);
            String portrait = this.i.getPortrait();
            this.c.setTag(portrait);
            this.h.b().d(portrait, new m(this));
            if (!TextUtils.isEmpty(this.i.getUserName())) {
                this.d.setText(this.i.getUserName());
            }
            if (!TextUtils.isEmpty(this.i.getGroupName())) {
                this.e.setText(String.valueOf(this.h.getString(y.validate_im_apply_prefix)) + this.i.getGroupName());
            }
            if (!TextUtils.isEmpty(this.i.getApplyReason())) {
                this.f.setText(String.valueOf(this.h.getString(y.validate_im_reason_prefix)) + this.i.getApplyReason());
            }
            if (this.i.isPass()) {
                this.g.setEnabled(false);
                this.g.setText(this.h.getString(y.validate_im_btn_passed));
            } else {
                this.g.setEnabled(true);
                this.g.setText(this.h.getString(y.validate_im_btn_pass));
            }
            BdLog.d("isShown:" + this.i.isShown());
            if (!this.i.isShown()) {
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.b.setBackgroundResource(com.baidu.tieba.s.validate_item_background_sean_1);
                } else {
                    this.b.setBackgroundResource(com.baidu.tieba.s.validate_item_background_sean);
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

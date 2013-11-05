package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.a.c<ValidateItemData> {
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private Button h;
    private ValidateActivity i;
    private ValidateItemData j;

    public f(ValidateActivity validateActivity) {
        super(validateActivity, R.layout.validate_item);
        this.i = validateActivity;
        e();
    }

    void e() {
        this.c = this.f399a.findViewById(R.id.root_view);
        this.d = (HeadImageView) this.c.findViewById(R.id.iv_head);
        this.e = (TextView) this.c.findViewById(R.id.tv_user_name);
        this.f = (TextView) this.c.findViewById(R.id.tv_group_name);
        this.g = (TextView) this.c.findViewById(R.id.tv_apply_reason);
        this.h = (Button) this.c.findViewById(R.id.btn_pass);
        this.h.setOnClickListener(new g(this));
        this.d.setOnClickListener(new h(this));
        this.c.setOnLongClickListener(new i(this));
    }

    public void f() {
        if (this.j != null) {
            String portrait = this.j.getPortrait();
            this.d.setTag(portrait);
            com.baidu.adp.widget.ImageView.e c = this.i.b().c(portrait);
            if (c != null) {
                c.a(this.d);
            } else {
                this.i.b().d(portrait, new j(this));
            }
            if (!TextUtils.isEmpty(this.j.getUserName())) {
                this.e.setText(this.j.getUserName());
            }
            if (!TextUtils.isEmpty(this.j.getGroupName())) {
                this.f.setText(this.i.getString(R.string.validate_im_apply_prefix) + this.j.getGroupName());
            }
            if (!TextUtils.isEmpty(this.j.getApplyReason())) {
                this.g.setText(this.i.getString(R.string.validate_im_reason_prefix) + this.j.getApplyReason());
            }
            if (this.j.isPass()) {
                this.h.setEnabled(false);
                this.h.setText(this.i.getString(R.string.validate_im_btn_passed));
            } else {
                this.h.setEnabled(true);
                this.h.setText(this.i.getString(R.string.validate_im_btn_pass));
            }
            this.i.m().a(TiebaApplication.g().as() == 1);
            this.i.m().a(this.c);
            com.baidu.adp.lib.h.d.d("isShown:" + this.j.isShown());
            if (!this.j.isShown()) {
                if (TiebaApplication.g().as() == 1) {
                    this.c.setBackgroundResource(R.color.validate_item_background_sean_1);
                } else {
                    this.c.setBackgroundResource(R.color.validate_item_background_sean);
                }
            }
        }
    }

    public void a(ValidateItemData validateItemData) {
        b(validateItemData);
        f();
    }

    public void b(ValidateItemData validateItemData) {
        this.j = validateItemData;
    }
}

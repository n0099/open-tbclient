package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.a.c<ValidateItemData> {
    private View c;
    private HeadImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ValidateActivity i;
    private ValidateItemData j;

    public g(ValidateActivity validateActivity) {
        super(validateActivity, R.layout.validate_item);
        this.i = validateActivity;
        this.c = this.a.findViewById(R.id.root_view);
        this.d = (HeadImageView) this.c.findViewById(R.id.iv_head);
        this.d.setIsRound(true);
        this.e = (TextView) this.c.findViewById(R.id.tv_user_name);
        this.f = (TextView) this.c.findViewById(R.id.tv_group_name);
        this.g = (TextView) this.c.findViewById(R.id.tv_apply_reason);
        this.h = (TextView) this.c.findViewById(R.id.btn_pass);
        this.h.setOnClickListener(new h(this));
        this.d.setOnClickListener(new i(this));
        this.c.setOnLongClickListener(new j(this));
    }

    public final void d() {
        if (this.j != null) {
            this.i.getLayoutMode().a(TiebaApplication.g().ae() == 1);
            this.i.getLayoutMode().a(this.c);
            String portrait = this.j.getPortrait();
            this.d.setTag(portrait);
            this.i.a().d(portrait, new k(this));
            if (!TextUtils.isEmpty(this.j.getUserName())) {
                this.e.setText(this.j.getUserName());
            }
            if (!TextUtils.isEmpty(this.j.getGroupName())) {
                this.f.setText(String.valueOf(this.i.getString(R.string.validate_im_apply_prefix)) + this.j.getGroupName());
            }
            if (!TextUtils.isEmpty(this.j.getApplyReason())) {
                this.g.setText(String.valueOf(this.i.getString(R.string.validate_im_reason_prefix)) + this.j.getApplyReason());
            }
            if (this.j.isPass()) {
                this.h.setEnabled(false);
                this.h.setText(this.i.getString(R.string.validate_im_btn_passed));
            } else {
                this.h.setEnabled(true);
                this.h.setText(this.i.getString(R.string.validate_im_btn_pass));
            }
            com.baidu.adp.lib.util.e.e("isShown:" + this.j.isShown());
            if (!this.j.isShown()) {
                if (TiebaApplication.g().ae() == 1) {
                    this.c.setBackgroundResource(R.color.validate_item_background_sean_1);
                } else {
                    this.c.setBackgroundResource(R.color.validate_item_background_sean);
                }
            }
        }
    }

    public final void a(ValidateItemData validateItemData) {
        this.j = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View ees;
    private HeadImageView eet;
    private TextView eeu;
    private ValidateActivity ejG;
    private TextView ejH;
    private TextView ejI;
    private TextView ejJ;
    private ValidateItemData ejK;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.i.validate_item);
        this.ejG = validateActivity;
        initView();
    }

    void initView() {
        this.ees = this.lJ.findViewById(d.g.root_view);
        this.eet = (HeadImageView) this.ees.findViewById(d.g.iv_head);
        this.eet.setIsRound(false);
        this.ejH = (TextView) this.ees.findViewById(d.g.tv_user_name);
        this.eeu = (TextView) this.ees.findViewById(d.g.tv_group_name);
        this.ejI = (TextView) this.ees.findViewById(d.g.tv_apply_reason);
        this.ejJ = (TextView) this.ees.findViewById(d.g.btn_pass);
        this.ejJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.ejG.a(b.this.ejJ, 100, 0, 0L, b.this.ejK);
            }
        });
        this.eet.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.ejG.a(b.this.eet, 101, 0, 0L, b.this.ejK);
            }
        });
        this.ees.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.ejG.b(b.this.ees, 200, 0, 0L, b.this.ejK);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.ejK != null) {
            this.ejG.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.ejG.getLayoutMode().u(this.ees);
            String portrait = this.ejK.getPortrait();
            this.eet.setTag(portrait);
            this.eet.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.ejK.getUserName())) {
                this.ejH.setText(this.ejK.getUserName());
            }
            if (!TextUtils.isEmpty(this.ejK.getGroupName())) {
                this.eeu.setText(this.ejG.getPageContext().getString(d.k.validate_im_apply_prefix) + this.ejK.getGroupName());
            }
            if (!TextUtils.isEmpty(this.ejK.getApplyReason())) {
                this.ejI.setText(this.ejG.getPageContext().getString(d.k.validate_im_reason_prefix) + this.ejK.getApplyReason());
            }
            if (this.ejK.isPass()) {
                this.ejJ.setEnabled(false);
                this.ejJ.setText(this.ejG.getPageContext().getString(d.k.passed));
                ak.h(this.ejJ, d.C0126d.cp_cont_d);
                this.ejJ.setBackgroundDrawable(null);
            } else {
                this.ejJ.setEnabled(true);
                this.ejJ.setText(this.ejG.getPageContext().getString(d.k.pass));
            }
            if (!this.ejK.isShown()) {
                ak.i(this.ees, d.C0126d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.ejK = validateItemData;
    }
}

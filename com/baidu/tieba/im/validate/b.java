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
    private View edl;
    private HeadImageView edm;
    private TextView edn;
    private TextView eiA;
    private TextView eiB;
    private TextView eiC;
    private ValidateItemData eiD;
    private ValidateActivity eiz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.i.validate_item);
        this.eiz = validateActivity;
        initView();
    }

    void initView() {
        this.edl = this.lJ.findViewById(d.g.root_view);
        this.edm = (HeadImageView) this.edl.findViewById(d.g.iv_head);
        this.edm.setIsRound(false);
        this.eiA = (TextView) this.edl.findViewById(d.g.tv_user_name);
        this.edn = (TextView) this.edl.findViewById(d.g.tv_group_name);
        this.eiB = (TextView) this.edl.findViewById(d.g.tv_apply_reason);
        this.eiC = (TextView) this.edl.findViewById(d.g.btn_pass);
        this.eiC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.eiz.a(b.this.eiC, 100, 0, 0L, b.this.eiD);
            }
        });
        this.edm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.eiz.a(b.this.edm, 101, 0, 0L, b.this.eiD);
            }
        });
        this.edl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.eiz.b(b.this.edl, 200, 0, 0L, b.this.eiD);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eiD != null) {
            this.eiz.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eiz.getLayoutMode().u(this.edl);
            String portrait = this.eiD.getPortrait();
            this.edm.setTag(portrait);
            this.edm.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eiD.getUserName())) {
                this.eiA.setText(this.eiD.getUserName());
            }
            if (!TextUtils.isEmpty(this.eiD.getGroupName())) {
                this.edn.setText(this.eiz.getPageContext().getString(d.k.validate_im_apply_prefix) + this.eiD.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eiD.getApplyReason())) {
                this.eiB.setText(this.eiz.getPageContext().getString(d.k.validate_im_reason_prefix) + this.eiD.getApplyReason());
            }
            if (this.eiD.isPass()) {
                this.eiC.setEnabled(false);
                this.eiC.setText(this.eiz.getPageContext().getString(d.k.passed));
                ak.h(this.eiC, d.C0126d.cp_cont_d);
                this.eiC.setBackgroundDrawable(null);
            } else {
                this.eiC.setEnabled(true);
                this.eiC.setText(this.eiz.getPageContext().getString(d.k.pass));
            }
            if (!this.eiD.isShown()) {
                ak.i(this.edl, d.C0126d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eiD = validateItemData;
    }
}

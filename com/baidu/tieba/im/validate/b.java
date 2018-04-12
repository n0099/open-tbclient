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
    private View edo;
    private HeadImageView edp;
    private TextView edq;
    private ValidateActivity eiC;
    private TextView eiD;
    private TextView eiE;
    private TextView eiF;
    private ValidateItemData eiG;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.i.validate_item);
        this.eiC = validateActivity;
        initView();
    }

    void initView() {
        this.edo = this.lJ.findViewById(d.g.root_view);
        this.edp = (HeadImageView) this.edo.findViewById(d.g.iv_head);
        this.edp.setIsRound(false);
        this.eiD = (TextView) this.edo.findViewById(d.g.tv_user_name);
        this.edq = (TextView) this.edo.findViewById(d.g.tv_group_name);
        this.eiE = (TextView) this.edo.findViewById(d.g.tv_apply_reason);
        this.eiF = (TextView) this.edo.findViewById(d.g.btn_pass);
        this.eiF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.eiC.a(b.this.eiF, 100, 0, 0L, b.this.eiG);
            }
        });
        this.edp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.eiC.a(b.this.edp, 101, 0, 0L, b.this.eiG);
            }
        });
        this.edo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                b.this.eiC.b(b.this.edo, 200, 0, 0L, b.this.eiG);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eiG != null) {
            this.eiC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eiC.getLayoutMode().u(this.edo);
            String portrait = this.eiG.getPortrait();
            this.edp.setTag(portrait);
            this.edp.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eiG.getUserName())) {
                this.eiD.setText(this.eiG.getUserName());
            }
            if (!TextUtils.isEmpty(this.eiG.getGroupName())) {
                this.edq.setText(this.eiC.getPageContext().getString(d.k.validate_im_apply_prefix) + this.eiG.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eiG.getApplyReason())) {
                this.eiE.setText(this.eiC.getPageContext().getString(d.k.validate_im_reason_prefix) + this.eiG.getApplyReason());
            }
            if (this.eiG.isPass()) {
                this.eiF.setEnabled(false);
                this.eiF.setText(this.eiC.getPageContext().getString(d.k.passed));
                ak.h(this.eiF, d.C0126d.cp_cont_d);
                this.eiF.setBackgroundDrawable(null);
            } else {
                this.eiF.setEnabled(true);
                this.eiF.setText(this.eiC.getPageContext().getString(d.k.pass));
            }
            if (!this.eiG.isShown()) {
                ak.i(this.edo, d.C0126d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eiG = validateItemData;
    }
}

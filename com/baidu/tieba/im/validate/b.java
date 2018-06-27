package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private HeadImageView etA;
    private TextView etB;
    private View etz;
    private ValidateActivity eyO;
    private TextView eyP;
    private TextView eyQ;
    private TextView eyR;
    private ValidateItemData eyS;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.i.validate_item);
        this.eyO = validateActivity;
        initView();
    }

    void initView() {
        this.etz = this.sd.findViewById(d.g.root_view);
        this.etA = (HeadImageView) this.etz.findViewById(d.g.iv_head);
        this.etA.setIsRound(false);
        this.eyP = (TextView) this.etz.findViewById(d.g.tv_user_name);
        this.etB = (TextView) this.etz.findViewById(d.g.tv_group_name);
        this.eyQ = (TextView) this.etz.findViewById(d.g.tv_apply_reason);
        this.eyR = (TextView) this.etz.findViewById(d.g.btn_pass);
        this.eyR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eyO.a(b.this.eyR, 100, 0, 0L, b.this.eyS);
            }
        });
        this.etA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eyO.a(b.this.etA, 101, 0, 0L, b.this.eyS);
            }
        });
        this.etz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eyO.b(b.this.etz, 200, 0, 0L, b.this.eyS);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eyS != null) {
            this.eyO.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eyO.getLayoutMode().onModeChanged(this.etz);
            String portrait = this.eyS.getPortrait();
            this.etA.setTag(portrait);
            this.etA.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eyS.getUserName())) {
                this.eyP.setText(this.eyS.getUserName());
            }
            if (!TextUtils.isEmpty(this.eyS.getGroupName())) {
                this.etB.setText(this.eyO.getPageContext().getString(d.k.validate_im_apply_prefix) + this.eyS.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eyS.getApplyReason())) {
                this.eyQ.setText(this.eyO.getPageContext().getString(d.k.validate_im_reason_prefix) + this.eyS.getApplyReason());
            }
            if (this.eyS.isPass()) {
                this.eyR.setEnabled(false);
                this.eyR.setText(this.eyO.getPageContext().getString(d.k.passed));
                am.h(this.eyR, d.C0142d.cp_cont_d);
                this.eyR.setBackgroundDrawable(null);
            } else {
                this.eyR.setEnabled(true);
                this.eyR.setText(this.eyO.getPageContext().getString(d.k.pass));
            }
            if (!this.eyS.isShown()) {
                am.i(this.etz, d.C0142d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eyS = validateItemData;
    }
}

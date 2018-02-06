package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View eIF;
    private HeadImageView eIG;
    private TextView eIH;
    private ValidateActivity eNS;
    private TextView eNT;
    private TextView eNU;
    private TextView eNV;
    private ValidateItemData eNW;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.eNS = validateActivity;
        initView();
    }

    void initView() {
        this.eIF = this.abC.findViewById(d.g.root_view);
        this.eIG = (HeadImageView) this.eIF.findViewById(d.g.iv_head);
        this.eIG.setIsRound(false);
        this.eNT = (TextView) this.eIF.findViewById(d.g.tv_user_name);
        this.eIH = (TextView) this.eIF.findViewById(d.g.tv_group_name);
        this.eNU = (TextView) this.eIF.findViewById(d.g.tv_apply_reason);
        this.eNV = (TextView) this.eIF.findViewById(d.g.btn_pass);
        this.eNV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNS.a(b.this.eNV, 100, 0, 0L, b.this.eNW);
            }
        });
        this.eIG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNS.a(b.this.eIG, 101, 0, 0L, b.this.eNW);
            }
        });
        this.eIF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eNS.b(b.this.eIF, 200, 0, 0L, b.this.eNW);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eNW != null) {
            this.eNS.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eNS.getLayoutMode().aM(this.eIF);
            String portrait = this.eNW.getPortrait();
            this.eIG.setTag(portrait);
            this.eIG.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eNW.getUserName())) {
                this.eNT.setText(this.eNW.getUserName());
            }
            if (!TextUtils.isEmpty(this.eNW.getGroupName())) {
                this.eIH.setText(this.eNS.getPageContext().getString(d.j.validate_im_apply_prefix) + this.eNW.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eNW.getApplyReason())) {
                this.eNU.setText(this.eNS.getPageContext().getString(d.j.validate_im_reason_prefix) + this.eNW.getApplyReason());
            }
            if (this.eNW.isPass()) {
                this.eNV.setEnabled(false);
                this.eNV.setText(this.eNS.getPageContext().getString(d.j.passed));
                aj.r(this.eNV, d.C0140d.cp_cont_d);
                this.eNV.setBackgroundDrawable(null);
            } else {
                this.eNV.setEnabled(true);
                this.eNV.setText(this.eNS.getPageContext().getString(d.j.pass));
            }
            if (!this.eNW.isShown()) {
                aj.s(this.eIF, d.C0140d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eNW = validateItemData;
    }
}

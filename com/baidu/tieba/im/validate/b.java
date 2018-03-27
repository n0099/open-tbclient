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
    private View eIJ;
    private HeadImageView eIK;
    private TextView eIL;
    private ValidateActivity eNW;
    private TextView eNX;
    private TextView eNY;
    private TextView eNZ;
    private ValidateItemData eOa;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.eNW = validateActivity;
        initView();
    }

    void initView() {
        this.eIJ = this.abw.findViewById(d.g.root_view);
        this.eIK = (HeadImageView) this.eIJ.findViewById(d.g.iv_head);
        this.eIK.setIsRound(false);
        this.eNX = (TextView) this.eIJ.findViewById(d.g.tv_user_name);
        this.eIL = (TextView) this.eIJ.findViewById(d.g.tv_group_name);
        this.eNY = (TextView) this.eIJ.findViewById(d.g.tv_apply_reason);
        this.eNZ = (TextView) this.eIJ.findViewById(d.g.btn_pass);
        this.eNZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNW.a(b.this.eNZ, 100, 0, 0L, b.this.eOa);
            }
        });
        this.eIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNW.a(b.this.eIK, 101, 0, 0L, b.this.eOa);
            }
        });
        this.eIJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eNW.b(b.this.eIJ, 200, 0, 0L, b.this.eOa);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eOa != null) {
            this.eNW.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eNW.getLayoutMode().aM(this.eIJ);
            String portrait = this.eOa.getPortrait();
            this.eIK.setTag(portrait);
            this.eIK.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eOa.getUserName())) {
                this.eNX.setText(this.eOa.getUserName());
            }
            if (!TextUtils.isEmpty(this.eOa.getGroupName())) {
                this.eIL.setText(this.eNW.getPageContext().getString(d.j.validate_im_apply_prefix) + this.eOa.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eOa.getApplyReason())) {
                this.eNY.setText(this.eNW.getPageContext().getString(d.j.validate_im_reason_prefix) + this.eOa.getApplyReason());
            }
            if (this.eOa.isPass()) {
                this.eNZ.setEnabled(false);
                this.eNZ.setText(this.eNW.getPageContext().getString(d.j.passed));
                aj.r(this.eNZ, d.C0141d.cp_cont_d);
                this.eNZ.setBackgroundDrawable(null);
            } else {
                this.eNZ.setEnabled(true);
                this.eNZ.setText(this.eNW.getPageContext().getString(d.j.pass));
            }
            if (!this.eOa.isShown()) {
                aj.s(this.eIJ, d.C0141d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eOa = validateItemData;
    }
}

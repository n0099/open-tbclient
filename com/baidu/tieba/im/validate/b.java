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
    private ValidateActivity eCF;
    private TextView eCG;
    private TextView eCH;
    private TextView eCI;
    private ValidateItemData eCJ;
    private View exq;
    private HeadImageView exr;
    private TextView exs;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.eCF = validateActivity;
        initView();
    }

    void initView() {
        this.exq = this.rV.findViewById(d.g.root_view);
        this.exr = (HeadImageView) this.exq.findViewById(d.g.iv_head);
        this.exr.setIsRound(false);
        this.eCG = (TextView) this.exq.findViewById(d.g.tv_user_name);
        this.exs = (TextView) this.exq.findViewById(d.g.tv_group_name);
        this.eCH = (TextView) this.exq.findViewById(d.g.tv_apply_reason);
        this.eCI = (TextView) this.exq.findViewById(d.g.btn_pass);
        this.eCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eCF.a(b.this.eCI, 100, 0, 0L, b.this.eCJ);
            }
        });
        this.exr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eCF.a(b.this.exr, 101, 0, 0L, b.this.eCJ);
            }
        });
        this.exq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eCF.b(b.this.exq, 200, 0, 0L, b.this.eCJ);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eCJ != null) {
            this.eCF.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eCF.getLayoutMode().onModeChanged(this.exq);
            String portrait = this.eCJ.getPortrait();
            this.exr.setTag(portrait);
            this.exr.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eCJ.getUserName())) {
                this.eCG.setText(this.eCJ.getUserName());
            }
            if (!TextUtils.isEmpty(this.eCJ.getGroupName())) {
                this.exs.setText(this.eCF.getPageContext().getString(d.j.validate_im_apply_prefix) + this.eCJ.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eCJ.getApplyReason())) {
                this.eCH.setText(this.eCF.getPageContext().getString(d.j.validate_im_reason_prefix) + this.eCJ.getApplyReason());
            }
            if (this.eCJ.isPass()) {
                this.eCI.setEnabled(false);
                this.eCI.setText(this.eCF.getPageContext().getString(d.j.passed));
                am.h(this.eCI, d.C0140d.cp_cont_d);
                this.eCI.setBackgroundDrawable(null);
            } else {
                this.eCI.setEnabled(true);
                this.eCI.setText(this.eCF.getPageContext().getString(d.j.pass));
            }
            if (!this.eCJ.isShown()) {
                am.i(this.exq, d.C0140d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eCJ = validateItemData;
    }
}

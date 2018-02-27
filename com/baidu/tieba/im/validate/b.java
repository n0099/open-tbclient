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
    private View eIt;
    private HeadImageView eIu;
    private TextView eIv;
    private ValidateActivity eNG;
    private TextView eNH;
    private TextView eNI;
    private TextView eNJ;
    private ValidateItemData eNK;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.h.validate_item);
        this.eNG = validateActivity;
        initView();
    }

    void initView() {
        this.eIt = this.abw.findViewById(d.g.root_view);
        this.eIu = (HeadImageView) this.eIt.findViewById(d.g.iv_head);
        this.eIu.setIsRound(false);
        this.eNH = (TextView) this.eIt.findViewById(d.g.tv_user_name);
        this.eIv = (TextView) this.eIt.findViewById(d.g.tv_group_name);
        this.eNI = (TextView) this.eIt.findViewById(d.g.tv_apply_reason);
        this.eNJ = (TextView) this.eIt.findViewById(d.g.btn_pass);
        this.eNJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNG.a(b.this.eNJ, 100, 0, 0L, b.this.eNK);
            }
        });
        this.eIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eNG.a(b.this.eIu, 101, 0, 0L, b.this.eNK);
            }
        });
        this.eIt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eNG.b(b.this.eIt, 200, 0, 0L, b.this.eNK);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eNK != null) {
            this.eNG.getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
            this.eNG.getLayoutMode().aM(this.eIt);
            String portrait = this.eNK.getPortrait();
            this.eIu.setTag(portrait);
            this.eIu.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eNK.getUserName())) {
                this.eNH.setText(this.eNK.getUserName());
            }
            if (!TextUtils.isEmpty(this.eNK.getGroupName())) {
                this.eIv.setText(this.eNG.getPageContext().getString(d.j.validate_im_apply_prefix) + this.eNK.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eNK.getApplyReason())) {
                this.eNI.setText(this.eNG.getPageContext().getString(d.j.validate_im_reason_prefix) + this.eNK.getApplyReason());
            }
            if (this.eNK.isPass()) {
                this.eNJ.setEnabled(false);
                this.eNJ.setText(this.eNG.getPageContext().getString(d.j.passed));
                aj.r(this.eNJ, d.C0141d.cp_cont_d);
                this.eNJ.setBackgroundDrawable(null);
            } else {
                this.eNJ.setEnabled(true);
                this.eNJ.setText(this.eNG.getPageContext().getString(d.j.pass));
            }
            if (!this.eNK.isShown()) {
                aj.s(this.eIt, d.C0141d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eNK = validateItemData;
    }
}

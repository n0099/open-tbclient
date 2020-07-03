package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View iXc;
    private HeadImageView iXd;
    private TextView iXe;
    private ValidateActivity jcn;
    private TextView jco;
    private TextView jcp;
    private TextView jcq;
    private ValidateItemData jcr;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jcn = validateActivity;
        initView();
    }

    void initView() {
        this.iXc = this.mConvertView.findViewById(R.id.root_view);
        this.iXd = (HeadImageView) this.iXc.findViewById(R.id.iv_head);
        this.iXd.setIsRound(false);
        this.jco = (TextView) this.iXc.findViewById(R.id.tv_user_name);
        this.iXe = (TextView) this.iXc.findViewById(R.id.tv_group_name);
        this.jcp = (TextView) this.iXc.findViewById(R.id.tv_apply_reason);
        this.jcq = (TextView) this.iXc.findViewById(R.id.btn_pass);
        this.jcq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jcn.a(b.this.jcq, 100, 0, 0L, b.this.jcr);
            }
        });
        this.iXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jcn.a(b.this.iXd, 101, 0, 0L, b.this.jcr);
            }
        });
        this.iXc.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jcn.b(b.this.iXc, 200, 0, 0L, b.this.jcr);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jcr != null) {
            this.jcn.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jcn.getLayoutMode().onModeChanged(this.iXc);
            String portrait = this.jcr.getPortrait();
            this.iXd.setTag(portrait);
            this.iXd.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jcr.getUserName())) {
                this.jco.setText(this.jcr.getUserName());
            }
            if (!TextUtils.isEmpty(this.jcr.getGroupName())) {
                this.iXe.setText(this.jcn.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jcr.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jcr.getApplyReason())) {
                this.jcp.setText(this.jcn.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jcr.getApplyReason());
            }
            if (this.jcr.isPass()) {
                this.jcq.setEnabled(false);
                this.jcq.setText(this.jcn.getPageContext().getString(R.string.passed));
                an.setViewTextColor(this.jcq, (int) R.color.cp_cont_d);
                this.jcq.setBackgroundDrawable(null);
            } else {
                this.jcq.setEnabled(true);
                this.jcq.setText(this.jcn.getPageContext().getString(R.string.pass));
            }
            if (!this.jcr.isShown()) {
                an.setBackgroundResource(this.iXc, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jcr = validateItemData;
    }
}

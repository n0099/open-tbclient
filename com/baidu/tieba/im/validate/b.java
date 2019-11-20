package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View gLp;
    private HeadImageView gLq;
    private TextView gLr;
    private ValidateActivity gQC;
    private TextView gQD;
    private TextView gQE;
    private TextView gQF;
    private ValidateItemData gQG;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gQC = validateActivity;
        initView();
    }

    void initView() {
        this.gLp = this.mConvertView.findViewById(R.id.root_view);
        this.gLq = (HeadImageView) this.gLp.findViewById(R.id.iv_head);
        this.gLq.setIsRound(false);
        this.gQD = (TextView) this.gLp.findViewById(R.id.tv_user_name);
        this.gLr = (TextView) this.gLp.findViewById(R.id.tv_group_name);
        this.gQE = (TextView) this.gLp.findViewById(R.id.tv_apply_reason);
        this.gQF = (TextView) this.gLp.findViewById(R.id.btn_pass);
        this.gQF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gQC.a(b.this.gQF, 100, 0, 0L, b.this.gQG);
            }
        });
        this.gLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gQC.a(b.this.gLq, 101, 0, 0L, b.this.gQG);
            }
        });
        this.gLp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gQC.b(b.this.gLp, 200, 0, 0L, b.this.gQG);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gQG != null) {
            this.gQC.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gQC.getLayoutMode().onModeChanged(this.gLp);
            String portrait = this.gQG.getPortrait();
            this.gLq.setTag(portrait);
            this.gLq.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gQG.getUserName())) {
                this.gQD.setText(this.gQG.getUserName());
            }
            if (!TextUtils.isEmpty(this.gQG.getGroupName())) {
                this.gLr.setText(this.gQC.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gQG.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gQG.getApplyReason())) {
                this.gQE.setText(this.gQC.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gQG.getApplyReason());
            }
            if (this.gQG.isPass()) {
                this.gQF.setEnabled(false);
                this.gQF.setText(this.gQC.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.gQF, (int) R.color.cp_cont_d);
                this.gQF.setBackgroundDrawable(null);
            } else {
                this.gQF.setEnabled(true);
                this.gQF.setText(this.gQC.getPageContext().getString(R.string.pass));
            }
            if (!this.gQG.isShown()) {
                am.setBackgroundResource(this.gLp, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gQG = validateItemData;
    }
}

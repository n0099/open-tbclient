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
    private View gMn;
    private HeadImageView gMo;
    private TextView gMp;
    private ValidateActivity gRA;
    private TextView gRB;
    private TextView gRC;
    private TextView gRD;
    private ValidateItemData gRE;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gRA = validateActivity;
        initView();
    }

    void initView() {
        this.gMn = this.sP.findViewById(R.id.root_view);
        this.gMo = (HeadImageView) this.gMn.findViewById(R.id.iv_head);
        this.gMo.setIsRound(false);
        this.gRB = (TextView) this.gMn.findViewById(R.id.tv_user_name);
        this.gMp = (TextView) this.gMn.findViewById(R.id.tv_group_name);
        this.gRC = (TextView) this.gMn.findViewById(R.id.tv_apply_reason);
        this.gRD = (TextView) this.gMn.findViewById(R.id.btn_pass);
        this.gRD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gRA.a(b.this.gRD, 100, 0, 0L, b.this.gRE);
            }
        });
        this.gMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gRA.a(b.this.gMo, 101, 0, 0L, b.this.gRE);
            }
        });
        this.gMn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gRA.b(b.this.gMn, 200, 0, 0L, b.this.gRE);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gRE != null) {
            this.gRA.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gRA.getLayoutMode().onModeChanged(this.gMn);
            String portrait = this.gRE.getPortrait();
            this.gMo.setTag(portrait);
            this.gMo.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gRE.getUserName())) {
                this.gRB.setText(this.gRE.getUserName());
            }
            if (!TextUtils.isEmpty(this.gRE.getGroupName())) {
                this.gMp.setText(this.gRA.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gRE.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gRE.getApplyReason())) {
                this.gRC.setText(this.gRA.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gRE.getApplyReason());
            }
            if (this.gRE.isPass()) {
                this.gRD.setEnabled(false);
                this.gRD.setText(this.gRA.getPageContext().getString(R.string.passed));
                am.j(this.gRD, R.color.cp_cont_d);
                this.gRD.setBackgroundDrawable(null);
            } else {
                this.gRD.setEnabled(true);
                this.gRD.setText(this.gRA.getPageContext().getString(R.string.pass));
            }
            if (!this.gRE.isShown()) {
                am.k(this.gMn, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gRE = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<ValidateActivity> {
    private View kHt;
    private HeadImageView kHu;
    private TextView kHv;
    private ValidateActivity kMB;
    private TextView kMC;
    private TextView kMD;
    private TextView kME;
    private ValidateItemData kMF;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kMB = validateActivity;
        initView();
    }

    void initView() {
        this.kHt = this.mConvertView.findViewById(R.id.root_view);
        this.kHu = (HeadImageView) this.kHt.findViewById(R.id.iv_head);
        this.kHu.setIsRound(false);
        this.kMC = (TextView) this.kHt.findViewById(R.id.tv_user_name);
        this.kHv = (TextView) this.kHt.findViewById(R.id.tv_group_name);
        this.kMD = (TextView) this.kHt.findViewById(R.id.tv_apply_reason);
        this.kME = (TextView) this.kHt.findViewById(R.id.btn_pass);
        this.kME.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMB.a(b.this.kME, 100, 0, 0L, b.this.kMF);
            }
        });
        this.kHu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMB.a(b.this.kHu, 101, 0, 0L, b.this.kMF);
            }
        });
        this.kHt.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kMB.b(b.this.kHt, 200, 0, 0L, b.this.kMF);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kMF != null) {
            this.kMB.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kMB.getLayoutMode().onModeChanged(this.kHt);
            String portrait = this.kMF.getPortrait();
            this.kHu.setTag(portrait);
            this.kHu.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kMF.getUserName())) {
                this.kMC.setText(this.kMF.getUserName());
            }
            if (!TextUtils.isEmpty(this.kMF.getGroupName())) {
                this.kHv.setText(this.kMB.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kMF.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kMF.getApplyReason())) {
                this.kMD.setText(this.kMB.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kMF.getApplyReason());
            }
            if (this.kMF.isPass()) {
                this.kME.setEnabled(false);
                this.kME.setText(this.kMB.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kME, R.color.CAM_X0109);
                this.kME.setBackgroundDrawable(null);
            } else {
                this.kME.setEnabled(true);
                this.kME.setText(this.kMB.getPageContext().getString(R.string.pass));
            }
            if (!this.kMF.isShown()) {
                ap.setBackgroundResource(this.kHt, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kMF = validateItemData;
    }
}

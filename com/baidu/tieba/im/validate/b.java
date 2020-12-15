package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private ValidateActivity kDS;
    private TextView kDT;
    private TextView kDU;
    private TextView kDV;
    private ValidateItemData kDW;
    private TextView kyA;
    private View kyy;
    private HeadImageView kyz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kDS = validateActivity;
        initView();
    }

    void initView() {
        this.kyy = this.mConvertView.findViewById(R.id.root_view);
        this.kyz = (HeadImageView) this.kyy.findViewById(R.id.iv_head);
        this.kyz.setIsRound(false);
        this.kDT = (TextView) this.kyy.findViewById(R.id.tv_user_name);
        this.kyA = (TextView) this.kyy.findViewById(R.id.tv_group_name);
        this.kDU = (TextView) this.kyy.findViewById(R.id.tv_apply_reason);
        this.kDV = (TextView) this.kyy.findViewById(R.id.btn_pass);
        this.kDV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kDS.a(b.this.kDV, 100, 0, 0L, b.this.kDW);
            }
        });
        this.kyz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kDS.a(b.this.kyz, 101, 0, 0L, b.this.kDW);
            }
        });
        this.kyy.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kDS.b(b.this.kyy, 200, 0, 0L, b.this.kDW);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kDW != null) {
            this.kDS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kDS.getLayoutMode().onModeChanged(this.kyy);
            String portrait = this.kDW.getPortrait();
            this.kyz.setTag(portrait);
            this.kyz.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kDW.getUserName())) {
                this.kDT.setText(this.kDW.getUserName());
            }
            if (!TextUtils.isEmpty(this.kDW.getGroupName())) {
                this.kyA.setText(this.kDS.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kDW.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kDW.getApplyReason())) {
                this.kDU.setText(this.kDS.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kDW.getApplyReason());
            }
            if (this.kDW.isPass()) {
                this.kDV.setEnabled(false);
                this.kDV.setText(this.kDS.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kDV, R.color.CAM_X0109);
                this.kDV.setBackgroundDrawable(null);
            } else {
                this.kDV.setEnabled(true);
                this.kDV.setText(this.kDS.getPageContext().getString(R.string.pass));
            }
            if (!this.kDW.isShown()) {
                ap.setBackgroundResource(this.kyy, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kDW = validateItemData;
    }
}

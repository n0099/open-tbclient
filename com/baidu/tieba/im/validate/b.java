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
    private ValidateActivity kDQ;
    private TextView kDR;
    private TextView kDS;
    private TextView kDT;
    private ValidateItemData kDU;
    private View kyw;
    private HeadImageView kyx;
    private TextView kyy;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kDQ = validateActivity;
        initView();
    }

    void initView() {
        this.kyw = this.mConvertView.findViewById(R.id.root_view);
        this.kyx = (HeadImageView) this.kyw.findViewById(R.id.iv_head);
        this.kyx.setIsRound(false);
        this.kDR = (TextView) this.kyw.findViewById(R.id.tv_user_name);
        this.kyy = (TextView) this.kyw.findViewById(R.id.tv_group_name);
        this.kDS = (TextView) this.kyw.findViewById(R.id.tv_apply_reason);
        this.kDT = (TextView) this.kyw.findViewById(R.id.btn_pass);
        this.kDT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kDQ.a(b.this.kDT, 100, 0, 0L, b.this.kDU);
            }
        });
        this.kyx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kDQ.a(b.this.kyx, 101, 0, 0L, b.this.kDU);
            }
        });
        this.kyw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kDQ.b(b.this.kyw, 200, 0, 0L, b.this.kDU);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kDU != null) {
            this.kDQ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kDQ.getLayoutMode().onModeChanged(this.kyw);
            String portrait = this.kDU.getPortrait();
            this.kyx.setTag(portrait);
            this.kyx.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kDU.getUserName())) {
                this.kDR.setText(this.kDU.getUserName());
            }
            if (!TextUtils.isEmpty(this.kDU.getGroupName())) {
                this.kyy.setText(this.kDQ.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kDU.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kDU.getApplyReason())) {
                this.kDS.setText(this.kDQ.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kDU.getApplyReason());
            }
            if (this.kDU.isPass()) {
                this.kDT.setEnabled(false);
                this.kDT.setText(this.kDQ.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kDT, R.color.CAM_X0109);
                this.kDT.setBackgroundDrawable(null);
            } else {
                this.kDT.setEnabled(true);
                this.kDT.setText(this.kDQ.getPageContext().getString(R.string.pass));
            }
            if (!this.kDU.isShown()) {
                ap.setBackgroundResource(this.kyw, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kDU = validateItemData;
    }
}

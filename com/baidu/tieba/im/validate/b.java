package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View iqF;
    private HeadImageView iqG;
    private TextView iqH;
    private ValidateActivity ivS;
    private TextView ivT;
    private TextView ivU;
    private TextView ivV;
    private ValidateItemData ivW;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.ivS = validateActivity;
        initView();
    }

    void initView() {
        this.iqF = this.mConvertView.findViewById(R.id.root_view);
        this.iqG = (HeadImageView) this.iqF.findViewById(R.id.iv_head);
        this.iqG.setIsRound(false);
        this.ivT = (TextView) this.iqF.findViewById(R.id.tv_user_name);
        this.iqH = (TextView) this.iqF.findViewById(R.id.tv_group_name);
        this.ivU = (TextView) this.iqF.findViewById(R.id.tv_apply_reason);
        this.ivV = (TextView) this.iqF.findViewById(R.id.btn_pass);
        this.ivV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ivS.a(b.this.ivV, 100, 0, 0L, b.this.ivW);
            }
        });
        this.iqG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ivS.a(b.this.iqG, 101, 0, 0L, b.this.ivW);
            }
        });
        this.iqF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ivS.b(b.this.iqF, 200, 0, 0L, b.this.ivW);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.ivW != null) {
            this.ivS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.ivS.getLayoutMode().onModeChanged(this.iqF);
            String portrait = this.ivW.getPortrait();
            this.iqG.setTag(portrait);
            this.iqG.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.ivW.getUserName())) {
                this.ivT.setText(this.ivW.getUserName());
            }
            if (!TextUtils.isEmpty(this.ivW.getGroupName())) {
                this.iqH.setText(this.ivS.getPageContext().getString(R.string.validate_im_apply_prefix) + this.ivW.getGroupName());
            }
            if (!TextUtils.isEmpty(this.ivW.getApplyReason())) {
                this.ivU.setText(this.ivS.getPageContext().getString(R.string.validate_im_reason_prefix) + this.ivW.getApplyReason());
            }
            if (this.ivW.isPass()) {
                this.ivV.setEnabled(false);
                this.ivV.setText(this.ivS.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.ivV, (int) R.color.cp_cont_d);
                this.ivV.setBackgroundDrawable(null);
            } else {
                this.ivV.setEnabled(true);
                this.ivV.setText(this.ivS.getPageContext().getString(R.string.pass));
            }
            if (!this.ivW.isShown()) {
                am.setBackgroundResource(this.iqF, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.ivW = validateItemData;
    }
}

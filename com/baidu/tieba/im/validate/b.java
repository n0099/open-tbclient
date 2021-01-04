package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<ValidateActivity> {
    private View kDT;
    private HeadImageView kDU;
    private TextView kDV;
    private ValidateActivity kJb;
    private TextView kJc;
    private TextView kJd;
    private TextView kJe;
    private ValidateItemData kJf;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kJb = validateActivity;
        initView();
    }

    void initView() {
        this.kDT = this.mConvertView.findViewById(R.id.root_view);
        this.kDU = (HeadImageView) this.kDT.findViewById(R.id.iv_head);
        this.kDU.setIsRound(false);
        this.kJc = (TextView) this.kDT.findViewById(R.id.tv_user_name);
        this.kDV = (TextView) this.kDT.findViewById(R.id.tv_group_name);
        this.kJd = (TextView) this.kDT.findViewById(R.id.tv_apply_reason);
        this.kJe = (TextView) this.kDT.findViewById(R.id.btn_pass);
        this.kJe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kJb.a(b.this.kJe, 100, 0, 0L, b.this.kJf);
            }
        });
        this.kDU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kJb.a(b.this.kDU, 101, 0, 0L, b.this.kJf);
            }
        });
        this.kDT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kJb.b(b.this.kDT, 200, 0, 0L, b.this.kJf);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kJf != null) {
            this.kJb.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kJb.getLayoutMode().onModeChanged(this.kDT);
            String portrait = this.kJf.getPortrait();
            this.kDU.setTag(portrait);
            this.kDU.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kJf.getUserName())) {
                this.kJc.setText(this.kJf.getUserName());
            }
            if (!TextUtils.isEmpty(this.kJf.getGroupName())) {
                this.kDV.setText(this.kJb.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kJf.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kJf.getApplyReason())) {
                this.kJd.setText(this.kJb.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kJf.getApplyReason());
            }
            if (this.kJf.isPass()) {
                this.kJe.setEnabled(false);
                this.kJe.setText(this.kJb.getPageContext().getString(R.string.passed));
                ao.setViewTextColor(this.kJe, R.color.CAM_X0109);
                this.kJe.setBackgroundDrawable(null);
            } else {
                this.kJe.setEnabled(true);
                this.kJe.setText(this.kJb.getPageContext().getString(R.string.pass));
            }
            if (!this.kJf.isShown()) {
                ao.setBackgroundResource(this.kDT, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kJf = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View juo;
    private HeadImageView jup;
    private TextView juq;
    private ValidateActivity jzJ;
    private TextView jzK;
    private TextView jzL;
    private TextView jzM;
    private ValidateItemData jzN;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jzJ = validateActivity;
        initView();
    }

    void initView() {
        this.juo = this.mConvertView.findViewById(R.id.root_view);
        this.jup = (HeadImageView) this.juo.findViewById(R.id.iv_head);
        this.jup.setIsRound(false);
        this.jzK = (TextView) this.juo.findViewById(R.id.tv_user_name);
        this.juq = (TextView) this.juo.findViewById(R.id.tv_group_name);
        this.jzL = (TextView) this.juo.findViewById(R.id.tv_apply_reason);
        this.jzM = (TextView) this.juo.findViewById(R.id.btn_pass);
        this.jzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jzJ.a(b.this.jzM, 100, 0, 0L, b.this.jzN);
            }
        });
        this.jup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jzJ.a(b.this.jup, 101, 0, 0L, b.this.jzN);
            }
        });
        this.juo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jzJ.b(b.this.juo, 200, 0, 0L, b.this.jzN);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jzN != null) {
            this.jzJ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jzJ.getLayoutMode().onModeChanged(this.juo);
            String portrait = this.jzN.getPortrait();
            this.jup.setTag(portrait);
            this.jup.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jzN.getUserName())) {
                this.jzK.setText(this.jzN.getUserName());
            }
            if (!TextUtils.isEmpty(this.jzN.getGroupName())) {
                this.juq.setText(this.jzJ.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jzN.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jzN.getApplyReason())) {
                this.jzL.setText(this.jzJ.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jzN.getApplyReason());
            }
            if (this.jzN.isPass()) {
                this.jzM.setEnabled(false);
                this.jzM.setText(this.jzJ.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.jzM, R.color.cp_cont_d);
                this.jzM.setBackgroundDrawable(null);
            } else {
                this.jzM.setEnabled(true);
                this.jzM.setText(this.jzJ.getPageContext().getString(R.string.pass));
            }
            if (!this.jzN.isShown()) {
                ap.setBackgroundResource(this.juo, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jzN = validateItemData;
    }
}

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
    private View iFl;
    private HeadImageView iFm;
    private TextView iFn;
    private TextView iKA;
    private TextView iKB;
    private ValidateItemData iKC;
    private ValidateActivity iKy;
    private TextView iKz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.iKy = validateActivity;
        initView();
    }

    void initView() {
        this.iFl = this.mConvertView.findViewById(R.id.root_view);
        this.iFm = (HeadImageView) this.iFl.findViewById(R.id.iv_head);
        this.iFm.setIsRound(false);
        this.iKz = (TextView) this.iFl.findViewById(R.id.tv_user_name);
        this.iFn = (TextView) this.iFl.findViewById(R.id.tv_group_name);
        this.iKA = (TextView) this.iFl.findViewById(R.id.tv_apply_reason);
        this.iKB = (TextView) this.iFl.findViewById(R.id.btn_pass);
        this.iKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iKy.a(b.this.iKB, 100, 0, 0L, b.this.iKC);
            }
        });
        this.iFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iKy.a(b.this.iFm, 101, 0, 0L, b.this.iKC);
            }
        });
        this.iFl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iKy.b(b.this.iFl, 200, 0, 0L, b.this.iKC);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.iKC != null) {
            this.iKy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iKy.getLayoutMode().onModeChanged(this.iFl);
            String portrait = this.iKC.getPortrait();
            this.iFm.setTag(portrait);
            this.iFm.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.iKC.getUserName())) {
                this.iKz.setText(this.iKC.getUserName());
            }
            if (!TextUtils.isEmpty(this.iKC.getGroupName())) {
                this.iFn.setText(this.iKy.getPageContext().getString(R.string.validate_im_apply_prefix) + this.iKC.getGroupName());
            }
            if (!TextUtils.isEmpty(this.iKC.getApplyReason())) {
                this.iKA.setText(this.iKy.getPageContext().getString(R.string.validate_im_reason_prefix) + this.iKC.getApplyReason());
            }
            if (this.iKC.isPass()) {
                this.iKB.setEnabled(false);
                this.iKB.setText(this.iKy.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.iKB, (int) R.color.cp_cont_d);
                this.iKB.setBackgroundDrawable(null);
            } else {
                this.iKB.setEnabled(true);
                this.iKB.setText(this.iKy.getPageContext().getString(R.string.pass));
            }
            if (!this.iKC.isShown()) {
                am.setBackgroundResource(this.iFl, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.iKC = validateItemData;
    }
}

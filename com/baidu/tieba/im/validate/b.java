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
    private View hFj;
    private HeadImageView hFk;
    private TextView hFl;
    private ValidateItemData hKA;
    private ValidateActivity hKw;
    private TextView hKx;
    private TextView hKy;
    private TextView hKz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hKw = validateActivity;
        initView();
    }

    void initView() {
        this.hFj = this.mConvertView.findViewById(R.id.root_view);
        this.hFk = (HeadImageView) this.hFj.findViewById(R.id.iv_head);
        this.hFk.setIsRound(false);
        this.hKx = (TextView) this.hFj.findViewById(R.id.tv_user_name);
        this.hFl = (TextView) this.hFj.findViewById(R.id.tv_group_name);
        this.hKy = (TextView) this.hFj.findViewById(R.id.tv_apply_reason);
        this.hKz = (TextView) this.hFj.findViewById(R.id.btn_pass);
        this.hKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKw.a(b.this.hKz, 100, 0, 0L, b.this.hKA);
            }
        });
        this.hFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKw.a(b.this.hFk, 101, 0, 0L, b.this.hKA);
            }
        });
        this.hFj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hKw.b(b.this.hFj, 200, 0, 0L, b.this.hKA);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hKA != null) {
            this.hKw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hKw.getLayoutMode().onModeChanged(this.hFj);
            String portrait = this.hKA.getPortrait();
            this.hFk.setTag(portrait);
            this.hFk.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hKA.getUserName())) {
                this.hKx.setText(this.hKA.getUserName());
            }
            if (!TextUtils.isEmpty(this.hKA.getGroupName())) {
                this.hFl.setText(this.hKw.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hKA.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hKA.getApplyReason())) {
                this.hKy.setText(this.hKw.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hKA.getApplyReason());
            }
            if (this.hKA.isPass()) {
                this.hKz.setEnabled(false);
                this.hKz.setText(this.hKw.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hKz, (int) R.color.cp_cont_d);
                this.hKz.setBackgroundDrawable(null);
            } else {
                this.hKz.setEnabled(true);
                this.hKz.setText(this.hKw.getPageContext().getString(R.string.pass));
            }
            if (!this.hKA.isShown()) {
                am.setBackgroundResource(this.hFj, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hKA = validateItemData;
    }
}

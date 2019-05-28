package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View gFj;
    private HeadImageView gFk;
    private TextView gFl;
    private ValidateItemData gKA;
    private ValidateActivity gKw;
    private TextView gKx;
    private TextView gKy;
    private TextView gKz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gKw = validateActivity;
        initView();
    }

    void initView() {
        this.gFj = this.sN.findViewById(R.id.root_view);
        this.gFk = (HeadImageView) this.gFj.findViewById(R.id.iv_head);
        this.gFk.setIsRound(false);
        this.gKx = (TextView) this.gFj.findViewById(R.id.tv_user_name);
        this.gFl = (TextView) this.gFj.findViewById(R.id.tv_group_name);
        this.gKy = (TextView) this.gFj.findViewById(R.id.tv_apply_reason);
        this.gKz = (TextView) this.gFj.findViewById(R.id.btn_pass);
        this.gKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKw.a(b.this.gKz, 100, 0, 0L, b.this.gKA);
            }
        });
        this.gFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKw.a(b.this.gFk, 101, 0, 0L, b.this.gKA);
            }
        });
        this.gFj.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gKw.b(b.this.gFj, 200, 0, 0L, b.this.gKA);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gKA != null) {
            this.gKw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gKw.getLayoutMode().onModeChanged(this.gFj);
            String portrait = this.gKA.getPortrait();
            this.gFk.setTag(portrait);
            this.gFk.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gKA.getUserName())) {
                this.gKx.setText(this.gKA.getUserName());
            }
            if (!TextUtils.isEmpty(this.gKA.getGroupName())) {
                this.gFl.setText(this.gKw.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gKA.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gKA.getApplyReason())) {
                this.gKy.setText(this.gKw.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gKA.getApplyReason());
            }
            if (this.gKA.isPass()) {
                this.gKz.setEnabled(false);
                this.gKz.setText(this.gKw.getPageContext().getString(R.string.passed));
                al.j(this.gKz, R.color.cp_cont_d);
                this.gKz.setBackgroundDrawable(null);
            } else {
                this.gKz.setEnabled(true);
                this.gKz.setText(this.gKw.getPageContext().getString(R.string.pass));
            }
            if (!this.gKA.isShown()) {
                al.k(this.gFj, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gKA = validateItemData;
    }
}

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
    private View gFl;
    private HeadImageView gFm;
    private TextView gFn;
    private TextView gKA;
    private TextView gKB;
    private ValidateItemData gKC;
    private ValidateActivity gKy;
    private TextView gKz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gKy = validateActivity;
        initView();
    }

    void initView() {
        this.gFl = this.sM.findViewById(R.id.root_view);
        this.gFm = (HeadImageView) this.gFl.findViewById(R.id.iv_head);
        this.gFm.setIsRound(false);
        this.gKz = (TextView) this.gFl.findViewById(R.id.tv_user_name);
        this.gFn = (TextView) this.gFl.findViewById(R.id.tv_group_name);
        this.gKA = (TextView) this.gFl.findViewById(R.id.tv_apply_reason);
        this.gKB = (TextView) this.gFl.findViewById(R.id.btn_pass);
        this.gKB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKy.a(b.this.gKB, 100, 0, 0L, b.this.gKC);
            }
        });
        this.gFm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKy.a(b.this.gFm, 101, 0, 0L, b.this.gKC);
            }
        });
        this.gFl.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gKy.b(b.this.gFl, 200, 0, 0L, b.this.gKC);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gKC != null) {
            this.gKy.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gKy.getLayoutMode().onModeChanged(this.gFl);
            String portrait = this.gKC.getPortrait();
            this.gFm.setTag(portrait);
            this.gFm.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gKC.getUserName())) {
                this.gKz.setText(this.gKC.getUserName());
            }
            if (!TextUtils.isEmpty(this.gKC.getGroupName())) {
                this.gFn.setText(this.gKy.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gKC.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gKC.getApplyReason())) {
                this.gKA.setText(this.gKy.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gKC.getApplyReason());
            }
            if (this.gKC.isPass()) {
                this.gKB.setEnabled(false);
                this.gKB.setText(this.gKy.getPageContext().getString(R.string.passed));
                al.j(this.gKB, R.color.cp_cont_d);
                this.gKB.setBackgroundDrawable(null);
            } else {
                this.gKB.setEnabled(true);
                this.gKB.setText(this.gKy.getPageContext().getString(R.string.pass));
            }
            if (!this.gKC.isShown()) {
                al.k(this.gFl, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gKC = validateItemData;
    }
}

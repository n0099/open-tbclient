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
    private View gFi;
    private HeadImageView gFj;
    private TextView gFk;
    private ValidateActivity gKv;
    private TextView gKw;
    private TextView gKx;
    private TextView gKy;
    private ValidateItemData gKz;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gKv = validateActivity;
        initView();
    }

    void initView() {
        this.gFi = this.sN.findViewById(R.id.root_view);
        this.gFj = (HeadImageView) this.gFi.findViewById(R.id.iv_head);
        this.gFj.setIsRound(false);
        this.gKw = (TextView) this.gFi.findViewById(R.id.tv_user_name);
        this.gFk = (TextView) this.gFi.findViewById(R.id.tv_group_name);
        this.gKx = (TextView) this.gFi.findViewById(R.id.tv_apply_reason);
        this.gKy = (TextView) this.gFi.findViewById(R.id.btn_pass);
        this.gKy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKv.a(b.this.gKy, 100, 0, 0L, b.this.gKz);
            }
        });
        this.gFj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gKv.a(b.this.gFj, 101, 0, 0L, b.this.gKz);
            }
        });
        this.gFi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gKv.b(b.this.gFi, 200, 0, 0L, b.this.gKz);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gKz != null) {
            this.gKv.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gKv.getLayoutMode().onModeChanged(this.gFi);
            String portrait = this.gKz.getPortrait();
            this.gFj.setTag(portrait);
            this.gFj.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gKz.getUserName())) {
                this.gKw.setText(this.gKz.getUserName());
            }
            if (!TextUtils.isEmpty(this.gKz.getGroupName())) {
                this.gFk.setText(this.gKv.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gKz.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gKz.getApplyReason())) {
                this.gKx.setText(this.gKv.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gKz.getApplyReason());
            }
            if (this.gKz.isPass()) {
                this.gKy.setEnabled(false);
                this.gKy.setText(this.gKv.getPageContext().getString(R.string.passed));
                al.j(this.gKy, R.color.cp_cont_d);
                this.gKy.setBackgroundDrawable(null);
            } else {
                this.gKy.setEnabled(true);
                this.gKy.setText(this.gKv.getPageContext().getString(R.string.pass));
            }
            if (!this.gKz.isShown()) {
                al.k(this.gFi, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gKz = validateItemData;
    }
}

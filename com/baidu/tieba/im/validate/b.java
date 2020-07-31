package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View jfm;
    private HeadImageView jfn;
    private TextView jfo;
    private ValidateActivity jkI;
    private TextView jkJ;
    private TextView jkK;
    private TextView jkL;
    private ValidateItemData jkM;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jkI = validateActivity;
        initView();
    }

    void initView() {
        this.jfm = this.mConvertView.findViewById(R.id.root_view);
        this.jfn = (HeadImageView) this.jfm.findViewById(R.id.iv_head);
        this.jfn.setIsRound(false);
        this.jkJ = (TextView) this.jfm.findViewById(R.id.tv_user_name);
        this.jfo = (TextView) this.jfm.findViewById(R.id.tv_group_name);
        this.jkK = (TextView) this.jfm.findViewById(R.id.tv_apply_reason);
        this.jkL = (TextView) this.jfm.findViewById(R.id.btn_pass);
        this.jkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jkI.a(b.this.jkL, 100, 0, 0L, b.this.jkM);
            }
        });
        this.jfn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jkI.a(b.this.jfn, 101, 0, 0L, b.this.jkM);
            }
        });
        this.jfm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jkI.b(b.this.jfm, 200, 0, 0L, b.this.jkM);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jkM != null) {
            this.jkI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jkI.getLayoutMode().onModeChanged(this.jfm);
            String portrait = this.jkM.getPortrait();
            this.jfn.setTag(portrait);
            this.jfn.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jkM.getUserName())) {
                this.jkJ.setText(this.jkM.getUserName());
            }
            if (!TextUtils.isEmpty(this.jkM.getGroupName())) {
                this.jfo.setText(this.jkI.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jkM.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jkM.getApplyReason())) {
                this.jkK.setText(this.jkI.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jkM.getApplyReason());
            }
            if (this.jkM.isPass()) {
                this.jkL.setEnabled(false);
                this.jkL.setText(this.jkI.getPageContext().getString(R.string.passed));
                ao.setViewTextColor(this.jkL, R.color.cp_cont_d);
                this.jkL.setBackgroundDrawable(null);
            } else {
                this.jkL.setEnabled(true);
                this.jkL.setText(this.jkI.getPageContext().getString(R.string.pass));
            }
            if (!this.jkM.isShown()) {
                ao.setBackgroundResource(this.jfm, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jkM = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View eUw;
    private HeadImageView eUx;
    private TextView eUy;
    private ValidateActivity eZJ;
    private TextView eZK;
    private TextView eZL;
    private TextView eZM;
    private ValidateItemData eZN;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.eZJ = validateActivity;
        initView();
    }

    void initView() {
        this.eUw = this.vo.findViewById(e.g.root_view);
        this.eUx = (HeadImageView) this.eUw.findViewById(e.g.iv_head);
        this.eUx.setIsRound(false);
        this.eZK = (TextView) this.eUw.findViewById(e.g.tv_user_name);
        this.eUy = (TextView) this.eUw.findViewById(e.g.tv_group_name);
        this.eZL = (TextView) this.eUw.findViewById(e.g.tv_apply_reason);
        this.eZM = (TextView) this.eUw.findViewById(e.g.btn_pass);
        this.eZM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eZJ.a(b.this.eZM, 100, 0, 0L, b.this.eZN);
            }
        });
        this.eUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eZJ.a(b.this.eUx, 101, 0, 0L, b.this.eZN);
            }
        });
        this.eUw.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eZJ.b(b.this.eUw, 200, 0, 0L, b.this.eZN);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eZN != null) {
            this.eZJ.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eZJ.getLayoutMode().onModeChanged(this.eUw);
            String portrait = this.eZN.getPortrait();
            this.eUx.setTag(portrait);
            this.eUx.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eZN.getUserName())) {
                this.eZK.setText(this.eZN.getUserName());
            }
            if (!TextUtils.isEmpty(this.eZN.getGroupName())) {
                this.eUy.setText(this.eZJ.getPageContext().getString(e.j.validate_im_apply_prefix) + this.eZN.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eZN.getApplyReason())) {
                this.eZL.setText(this.eZJ.getPageContext().getString(e.j.validate_im_reason_prefix) + this.eZN.getApplyReason());
            }
            if (this.eZN.isPass()) {
                this.eZM.setEnabled(false);
                this.eZM.setText(this.eZJ.getPageContext().getString(e.j.passed));
                al.h(this.eZM, e.d.cp_cont_d);
                this.eZM.setBackgroundDrawable(null);
            } else {
                this.eZM.setEnabled(true);
                this.eZM.setText(this.eZJ.getPageContext().getString(e.j.pass));
            }
            if (!this.eZN.isShown()) {
                al.i(this.eUw, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eZN = validateItemData;
    }
}

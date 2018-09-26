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
    private View eEF;
    private HeadImageView eEG;
    private TextView eEH;
    private ValidateActivity eJS;
    private TextView eJT;
    private TextView eJU;
    private TextView eJV;
    private ValidateItemData eJW;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.eJS = validateActivity;
        initView();
    }

    void initView() {
        this.eEF = this.uz.findViewById(e.g.root_view);
        this.eEG = (HeadImageView) this.eEF.findViewById(e.g.iv_head);
        this.eEG.setIsRound(false);
        this.eJT = (TextView) this.eEF.findViewById(e.g.tv_user_name);
        this.eEH = (TextView) this.eEF.findViewById(e.g.tv_group_name);
        this.eJU = (TextView) this.eEF.findViewById(e.g.tv_apply_reason);
        this.eJV = (TextView) this.eEF.findViewById(e.g.btn_pass);
        this.eJV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eJS.a(b.this.eJV, 100, 0, 0L, b.this.eJW);
            }
        });
        this.eEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eJS.a(b.this.eEG, 101, 0, 0L, b.this.eJW);
            }
        });
        this.eEF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eJS.b(b.this.eEF, 200, 0, 0L, b.this.eJW);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eJW != null) {
            this.eJS.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eJS.getLayoutMode().onModeChanged(this.eEF);
            String portrait = this.eJW.getPortrait();
            this.eEG.setTag(portrait);
            this.eEG.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eJW.getUserName())) {
                this.eJT.setText(this.eJW.getUserName());
            }
            if (!TextUtils.isEmpty(this.eJW.getGroupName())) {
                this.eEH.setText(this.eJS.getPageContext().getString(e.j.validate_im_apply_prefix) + this.eJW.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eJW.getApplyReason())) {
                this.eJU.setText(this.eJS.getPageContext().getString(e.j.validate_im_reason_prefix) + this.eJW.getApplyReason());
            }
            if (this.eJW.isPass()) {
                this.eJV.setEnabled(false);
                this.eJV.setText(this.eJS.getPageContext().getString(e.j.passed));
                al.h(this.eJV, e.d.cp_cont_d);
                this.eJV.setBackgroundDrawable(null);
            } else {
                this.eJV.setEnabled(true);
                this.eJV.setText(this.eJS.getPageContext().getString(e.j.pass));
            }
            if (!this.eJW.isShown()) {
                al.i(this.eEF, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eJW = validateItemData;
    }
}

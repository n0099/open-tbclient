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
    private View eXn;
    private HeadImageView eXo;
    private TextView eXp;
    private ValidateActivity fcA;
    private TextView fcB;
    private TextView fcC;
    private TextView fcD;
    private ValidateItemData fcE;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.fcA = validateActivity;
        initView();
    }

    void initView() {
        this.eXn = this.vo.findViewById(e.g.root_view);
        this.eXo = (HeadImageView) this.eXn.findViewById(e.g.iv_head);
        this.eXo.setIsRound(false);
        this.fcB = (TextView) this.eXn.findViewById(e.g.tv_user_name);
        this.eXp = (TextView) this.eXn.findViewById(e.g.tv_group_name);
        this.fcC = (TextView) this.eXn.findViewById(e.g.tv_apply_reason);
        this.fcD = (TextView) this.eXn.findViewById(e.g.btn_pass);
        this.fcD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fcA.a(b.this.fcD, 100, 0, 0L, b.this.fcE);
            }
        });
        this.eXo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.fcA.a(b.this.eXo, 101, 0, 0L, b.this.fcE);
            }
        });
        this.eXn.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.fcA.b(b.this.eXn, 200, 0, 0L, b.this.fcE);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.fcE != null) {
            this.fcA.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.fcA.getLayoutMode().onModeChanged(this.eXn);
            String portrait = this.fcE.getPortrait();
            this.eXo.setTag(portrait);
            this.eXo.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.fcE.getUserName())) {
                this.fcB.setText(this.fcE.getUserName());
            }
            if (!TextUtils.isEmpty(this.fcE.getGroupName())) {
                this.eXp.setText(this.fcA.getPageContext().getString(e.j.validate_im_apply_prefix) + this.fcE.getGroupName());
            }
            if (!TextUtils.isEmpty(this.fcE.getApplyReason())) {
                this.fcC.setText(this.fcA.getPageContext().getString(e.j.validate_im_reason_prefix) + this.fcE.getApplyReason());
            }
            if (this.fcE.isPass()) {
                this.fcD.setEnabled(false);
                this.fcD.setText(this.fcA.getPageContext().getString(e.j.passed));
                al.h(this.fcD, e.d.cp_cont_d);
                this.fcD.setBackgroundDrawable(null);
            } else {
                this.fcD.setEnabled(true);
                this.fcD.setText(this.fcA.getPageContext().getString(e.j.pass));
            }
            if (!this.fcE.isShown()) {
                al.i(this.eXn, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.fcE = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View epH;
    private HeadImageView epI;
    private TextView epJ;
    private ValidateActivity euX;
    private TextView euY;
    private TextView euZ;
    private TextView eva;
    private ValidateItemData evb;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), d.i.validate_item);
        this.euX = validateActivity;
        initView();
    }

    void initView() {
        this.epH = this.sf.findViewById(d.g.root_view);
        this.epI = (HeadImageView) this.epH.findViewById(d.g.iv_head);
        this.epI.setIsRound(false);
        this.euY = (TextView) this.epH.findViewById(d.g.tv_user_name);
        this.epJ = (TextView) this.epH.findViewById(d.g.tv_group_name);
        this.euZ = (TextView) this.epH.findViewById(d.g.tv_apply_reason);
        this.eva = (TextView) this.epH.findViewById(d.g.btn_pass);
        this.eva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.euX.a(b.this.eva, 100, 0, 0L, b.this.evb);
            }
        });
        this.epI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.euX.a(b.this.epI, 101, 0, 0L, b.this.evb);
            }
        });
        this.epH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.euX.b(b.this.epH, 200, 0, 0L, b.this.evb);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.evb != null) {
            this.euX.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.euX.getLayoutMode().onModeChanged(this.epH);
            String portrait = this.evb.getPortrait();
            this.epI.setTag(portrait);
            this.epI.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.evb.getUserName())) {
                this.euY.setText(this.evb.getUserName());
            }
            if (!TextUtils.isEmpty(this.evb.getGroupName())) {
                this.epJ.setText(this.euX.getPageContext().getString(d.k.validate_im_apply_prefix) + this.evb.getGroupName());
            }
            if (!TextUtils.isEmpty(this.evb.getApplyReason())) {
                this.euZ.setText(this.euX.getPageContext().getString(d.k.validate_im_reason_prefix) + this.evb.getApplyReason());
            }
            if (this.evb.isPass()) {
                this.eva.setEnabled(false);
                this.eva.setText(this.euX.getPageContext().getString(d.k.passed));
                al.h(this.eva, d.C0141d.cp_cont_d);
                this.eva.setBackgroundDrawable(null);
            } else {
                this.eva.setEnabled(true);
                this.eva.setText(this.euX.getPageContext().getString(d.k.pass));
            }
            if (!this.evb.isShown()) {
                al.i(this.epH, d.C0141d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.evb = validateItemData;
    }
}

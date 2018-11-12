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
    private View eNH;
    private HeadImageView eNI;
    private TextView eNJ;
    private ValidateActivity eSU;
    private TextView eSV;
    private TextView eSW;
    private TextView eSX;
    private ValidateItemData eSY;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), e.h.validate_item);
        this.eSU = validateActivity;
        initView();
    }

    void initView() {
        this.eNH = this.vo.findViewById(e.g.root_view);
        this.eNI = (HeadImageView) this.eNH.findViewById(e.g.iv_head);
        this.eNI.setIsRound(false);
        this.eSV = (TextView) this.eNH.findViewById(e.g.tv_user_name);
        this.eNJ = (TextView) this.eNH.findViewById(e.g.tv_group_name);
        this.eSW = (TextView) this.eNH.findViewById(e.g.tv_apply_reason);
        this.eSX = (TextView) this.eNH.findViewById(e.g.btn_pass);
        this.eSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eSU.a(b.this.eSX, 100, 0, 0L, b.this.eSY);
            }
        });
        this.eNI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.eSU.a(b.this.eNI, 101, 0, 0L, b.this.eSY);
            }
        });
        this.eNH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.eSU.b(b.this.eNH, 200, 0, 0L, b.this.eSY);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.eSY != null) {
            this.eSU.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.eSU.getLayoutMode().onModeChanged(this.eNH);
            String portrait = this.eSY.getPortrait();
            this.eNI.setTag(portrait);
            this.eNI.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.eSY.getUserName())) {
                this.eSV.setText(this.eSY.getUserName());
            }
            if (!TextUtils.isEmpty(this.eSY.getGroupName())) {
                this.eNJ.setText(this.eSU.getPageContext().getString(e.j.validate_im_apply_prefix) + this.eSY.getGroupName());
            }
            if (!TextUtils.isEmpty(this.eSY.getApplyReason())) {
                this.eSW.setText(this.eSU.getPageContext().getString(e.j.validate_im_reason_prefix) + this.eSY.getApplyReason());
            }
            if (this.eSY.isPass()) {
                this.eSX.setEnabled(false);
                this.eSX.setText(this.eSU.getPageContext().getString(e.j.passed));
                al.h(this.eSX, e.d.cp_cont_d);
                this.eSX.setBackgroundDrawable(null);
            } else {
                this.eSX.setEnabled(true);
                this.eSX.setText(this.eSU.getPageContext().getString(e.j.pass));
            }
            if (!this.eSY.isShown()) {
                al.i(this.eNH, e.d.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.eSY = validateItemData;
    }
}

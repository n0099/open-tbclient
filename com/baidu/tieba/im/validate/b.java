package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<ValidateActivity> {
    private ValidateItemData kEA;
    private ValidateActivity kEw;
    private TextView kEx;
    private TextView kEy;
    private TextView kEz;
    private View kzo;
    private HeadImageView kzp;
    private TextView kzq;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kEw = validateActivity;
        initView();
    }

    void initView() {
        this.kzo = this.mConvertView.findViewById(R.id.root_view);
        this.kzp = (HeadImageView) this.kzo.findViewById(R.id.iv_head);
        this.kzp.setIsRound(false);
        this.kEx = (TextView) this.kzo.findViewById(R.id.tv_user_name);
        this.kzq = (TextView) this.kzo.findViewById(R.id.tv_group_name);
        this.kEy = (TextView) this.kzo.findViewById(R.id.tv_apply_reason);
        this.kEz = (TextView) this.kzo.findViewById(R.id.btn_pass);
        this.kEz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kEw.a(b.this.kEz, 100, 0, 0L, b.this.kEA);
            }
        });
        this.kzp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kEw.a(b.this.kzp, 101, 0, 0L, b.this.kEA);
            }
        });
        this.kzo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kEw.b(b.this.kzo, 200, 0, 0L, b.this.kEA);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kEA != null) {
            this.kEw.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kEw.getLayoutMode().onModeChanged(this.kzo);
            String portrait = this.kEA.getPortrait();
            this.kzp.setTag(portrait);
            this.kzp.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kEA.getUserName())) {
                this.kEx.setText(this.kEA.getUserName());
            }
            if (!TextUtils.isEmpty(this.kEA.getGroupName())) {
                this.kzq.setText(this.kEw.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kEA.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kEA.getApplyReason())) {
                this.kEy.setText(this.kEw.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kEA.getApplyReason());
            }
            if (this.kEA.isPass()) {
                this.kEz.setEnabled(false);
                this.kEz.setText(this.kEw.getPageContext().getString(R.string.passed));
                ao.setViewTextColor(this.kEz, R.color.CAM_X0109);
                this.kEz.setBackgroundDrawable(null);
            } else {
                this.kEz.setEnabled(true);
                this.kEz.setText(this.kEw.getPageContext().getString(R.string.pass));
            }
            if (!this.kEA.isShown()) {
                ao.setBackgroundResource(this.kzo, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kEA = validateItemData;
    }
}

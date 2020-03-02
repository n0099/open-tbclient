package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes13.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View hEX;
    private HeadImageView hEY;
    private TextView hEZ;
    private ValidateActivity hKk;
    private TextView hKl;
    private TextView hKm;
    private TextView hKn;
    private ValidateItemData hKo;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hKk = validateActivity;
        initView();
    }

    void initView() {
        this.hEX = this.mConvertView.findViewById(R.id.root_view);
        this.hEY = (HeadImageView) this.hEX.findViewById(R.id.iv_head);
        this.hEY.setIsRound(false);
        this.hKl = (TextView) this.hEX.findViewById(R.id.tv_user_name);
        this.hEZ = (TextView) this.hEX.findViewById(R.id.tv_group_name);
        this.hKm = (TextView) this.hEX.findViewById(R.id.tv_apply_reason);
        this.hKn = (TextView) this.hEX.findViewById(R.id.btn_pass);
        this.hKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKk.a(b.this.hKn, 100, 0, 0L, b.this.hKo);
            }
        });
        this.hEY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hKk.a(b.this.hEY, 101, 0, 0L, b.this.hKo);
            }
        });
        this.hEX.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hKk.b(b.this.hEX, 200, 0, 0L, b.this.hKo);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hKo != null) {
            this.hKk.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hKk.getLayoutMode().onModeChanged(this.hEX);
            String portrait = this.hKo.getPortrait();
            this.hEY.setTag(portrait);
            this.hEY.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hKo.getUserName())) {
                this.hKl.setText(this.hKo.getUserName());
            }
            if (!TextUtils.isEmpty(this.hKo.getGroupName())) {
                this.hEZ.setText(this.hKk.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hKo.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hKo.getApplyReason())) {
                this.hKm.setText(this.hKk.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hKo.getApplyReason());
            }
            if (this.hKo.isPass()) {
                this.hKn.setEnabled(false);
                this.hKn.setText(this.hKk.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hKn, (int) R.color.cp_cont_d);
                this.hKn.setBackgroundDrawable(null);
            } else {
                this.hKn.setEnabled(true);
                this.hKn.setText(this.hKk.getPageContext().getString(R.string.pass));
            }
            if (!this.hKo.isShown()) {
                am.setBackgroundResource(this.hEX, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hKo = validateItemData;
    }
}

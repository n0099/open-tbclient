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
    private View iFY;
    private HeadImageView iFZ;
    private TextView iGa;
    private ValidateActivity iLl;
    private TextView iLm;
    private TextView iLn;
    private TextView iLo;
    private ValidateItemData iLp;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.iLl = validateActivity;
        initView();
    }

    void initView() {
        this.iFY = this.mConvertView.findViewById(R.id.root_view);
        this.iFZ = (HeadImageView) this.iFY.findViewById(R.id.iv_head);
        this.iFZ.setIsRound(false);
        this.iLm = (TextView) this.iFY.findViewById(R.id.tv_user_name);
        this.iGa = (TextView) this.iFY.findViewById(R.id.tv_group_name);
        this.iLn = (TextView) this.iFY.findViewById(R.id.tv_apply_reason);
        this.iLo = (TextView) this.iFY.findViewById(R.id.btn_pass);
        this.iLo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iLl.a(b.this.iLo, 100, 0, 0L, b.this.iLp);
            }
        });
        this.iFZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.iLl.a(b.this.iFZ, 101, 0, 0L, b.this.iLp);
            }
        });
        this.iFY.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.iLl.b(b.this.iFY, 200, 0, 0L, b.this.iLp);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.iLp != null) {
            this.iLl.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.iLl.getLayoutMode().onModeChanged(this.iFY);
            String portrait = this.iLp.getPortrait();
            this.iFZ.setTag(portrait);
            this.iFZ.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.iLp.getUserName())) {
                this.iLm.setText(this.iLp.getUserName());
            }
            if (!TextUtils.isEmpty(this.iLp.getGroupName())) {
                this.iGa.setText(this.iLl.getPageContext().getString(R.string.validate_im_apply_prefix) + this.iLp.getGroupName());
            }
            if (!TextUtils.isEmpty(this.iLp.getApplyReason())) {
                this.iLn.setText(this.iLl.getPageContext().getString(R.string.validate_im_reason_prefix) + this.iLp.getApplyReason());
            }
            if (this.iLp.isPass()) {
                this.iLo.setEnabled(false);
                this.iLo.setText(this.iLl.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.iLo, (int) R.color.cp_cont_d);
                this.iLo.setBackgroundDrawable(null);
            } else {
                this.iLo.setEnabled(true);
                this.iLo.setText(this.iLl.getPageContext().getString(R.string.pass));
            }
            if (!this.iLp.isShown()) {
                am.setBackgroundResource(this.iFY, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.iLp = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View kkq;
    private HeadImageView kkr;
    private TextView kks;
    private ValidateActivity kpK;
    private TextView kpL;
    private TextView kpM;
    private TextView kpN;
    private ValidateItemData kpO;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kpK = validateActivity;
        initView();
    }

    void initView() {
        this.kkq = this.mConvertView.findViewById(R.id.root_view);
        this.kkr = (HeadImageView) this.kkq.findViewById(R.id.iv_head);
        this.kkr.setIsRound(false);
        this.kpL = (TextView) this.kkq.findViewById(R.id.tv_user_name);
        this.kks = (TextView) this.kkq.findViewById(R.id.tv_group_name);
        this.kpM = (TextView) this.kkq.findViewById(R.id.tv_apply_reason);
        this.kpN = (TextView) this.kkq.findViewById(R.id.btn_pass);
        this.kpN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kpK.a(b.this.kpN, 100, 0, 0L, b.this.kpO);
            }
        });
        this.kkr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kpK.a(b.this.kkr, 101, 0, 0L, b.this.kpO);
            }
        });
        this.kkq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kpK.b(b.this.kkq, 200, 0, 0L, b.this.kpO);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kpO != null) {
            this.kpK.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kpK.getLayoutMode().onModeChanged(this.kkq);
            String portrait = this.kpO.getPortrait();
            this.kkr.setTag(portrait);
            this.kkr.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kpO.getUserName())) {
                this.kpL.setText(this.kpO.getUserName());
            }
            if (!TextUtils.isEmpty(this.kpO.getGroupName())) {
                this.kks.setText(this.kpK.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kpO.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kpO.getApplyReason())) {
                this.kpM.setText(this.kpK.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kpO.getApplyReason());
            }
            if (this.kpO.isPass()) {
                this.kpN.setEnabled(false);
                this.kpN.setText(this.kpK.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kpN, R.color.cp_cont_d);
                this.kpN.setBackgroundDrawable(null);
            } else {
                this.kpN.setEnabled(true);
                this.kpN.setText(this.kpK.getPageContext().getString(R.string.pass));
            }
            if (!this.kpO.isShown()) {
                ap.setBackgroundResource(this.kkq, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kpO = validateItemData;
    }
}

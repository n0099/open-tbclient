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
    private View jRT;
    private HeadImageView jRU;
    private TextView jRV;
    private ValidateActivity jXo;
    private TextView jXp;
    private TextView jXq;
    private TextView jXr;
    private ValidateItemData jXs;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jXo = validateActivity;
        initView();
    }

    void initView() {
        this.jRT = this.mConvertView.findViewById(R.id.root_view);
        this.jRU = (HeadImageView) this.jRT.findViewById(R.id.iv_head);
        this.jRU.setIsRound(false);
        this.jXp = (TextView) this.jRT.findViewById(R.id.tv_user_name);
        this.jRV = (TextView) this.jRT.findViewById(R.id.tv_group_name);
        this.jXq = (TextView) this.jRT.findViewById(R.id.tv_apply_reason);
        this.jXr = (TextView) this.jRT.findViewById(R.id.btn_pass);
        this.jXr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jXo.a(b.this.jXr, 100, 0, 0L, b.this.jXs);
            }
        });
        this.jRU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jXo.a(b.this.jRU, 101, 0, 0L, b.this.jXs);
            }
        });
        this.jRT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jXo.b(b.this.jRT, 200, 0, 0L, b.this.jXs);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jXs != null) {
            this.jXo.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jXo.getLayoutMode().onModeChanged(this.jRT);
            String portrait = this.jXs.getPortrait();
            this.jRU.setTag(portrait);
            this.jRU.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jXs.getUserName())) {
                this.jXp.setText(this.jXs.getUserName());
            }
            if (!TextUtils.isEmpty(this.jXs.getGroupName())) {
                this.jRV.setText(this.jXo.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jXs.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jXs.getApplyReason())) {
                this.jXq.setText(this.jXo.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jXs.getApplyReason());
            }
            if (this.jXs.isPass()) {
                this.jXr.setEnabled(false);
                this.jXr.setText(this.jXo.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.jXr, R.color.cp_cont_d);
                this.jXr.setBackgroundDrawable(null);
            } else {
                this.jXr.setEnabled(true);
                this.jXr.setText(this.jXo.getPageContext().getString(R.string.pass));
            }
            if (!this.jXs.isShown()) {
                ap.setBackgroundResource(this.jRT, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jXs = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View jfo;
    private HeadImageView jfp;
    private TextView jfq;
    private ValidateActivity jkK;
    private TextView jkL;
    private TextView jkM;
    private TextView jkN;
    private ValidateItemData jkO;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jkK = validateActivity;
        initView();
    }

    void initView() {
        this.jfo = this.mConvertView.findViewById(R.id.root_view);
        this.jfp = (HeadImageView) this.jfo.findViewById(R.id.iv_head);
        this.jfp.setIsRound(false);
        this.jkL = (TextView) this.jfo.findViewById(R.id.tv_user_name);
        this.jfq = (TextView) this.jfo.findViewById(R.id.tv_group_name);
        this.jkM = (TextView) this.jfo.findViewById(R.id.tv_apply_reason);
        this.jkN = (TextView) this.jfo.findViewById(R.id.btn_pass);
        this.jkN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jkK.a(b.this.jkN, 100, 0, 0L, b.this.jkO);
            }
        });
        this.jfp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jkK.a(b.this.jfp, 101, 0, 0L, b.this.jkO);
            }
        });
        this.jfo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jkK.b(b.this.jfo, 200, 0, 0L, b.this.jkO);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jkO != null) {
            this.jkK.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jkK.getLayoutMode().onModeChanged(this.jfo);
            String portrait = this.jkO.getPortrait();
            this.jfp.setTag(portrait);
            this.jfp.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jkO.getUserName())) {
                this.jkL.setText(this.jkO.getUserName());
            }
            if (!TextUtils.isEmpty(this.jkO.getGroupName())) {
                this.jfq.setText(this.jkK.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jkO.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jkO.getApplyReason())) {
                this.jkM.setText(this.jkK.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jkO.getApplyReason());
            }
            if (this.jkO.isPass()) {
                this.jkN.setEnabled(false);
                this.jkN.setText(this.jkK.getPageContext().getString(R.string.passed));
                ao.setViewTextColor(this.jkN, R.color.cp_cont_d);
                this.jkN.setBackgroundDrawable(null);
            } else {
                this.jkN.setEnabled(true);
                this.jkN.setText(this.jkK.getPageContext().getString(R.string.pass));
            }
            if (!this.jkO.isShown()) {
                ao.setBackgroundResource(this.jfo, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jkO = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes25.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View jCW;
    private HeadImageView jCX;
    private TextView jCY;
    private ValidateActivity jIr;
    private TextView jIs;
    private TextView jIt;
    private TextView jIu;
    private ValidateItemData jIv;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jIr = validateActivity;
        initView();
    }

    void initView() {
        this.jCW = this.mConvertView.findViewById(R.id.root_view);
        this.jCX = (HeadImageView) this.jCW.findViewById(R.id.iv_head);
        this.jCX.setIsRound(false);
        this.jIs = (TextView) this.jCW.findViewById(R.id.tv_user_name);
        this.jCY = (TextView) this.jCW.findViewById(R.id.tv_group_name);
        this.jIt = (TextView) this.jCW.findViewById(R.id.tv_apply_reason);
        this.jIu = (TextView) this.jCW.findViewById(R.id.btn_pass);
        this.jIu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jIr.a(b.this.jIu, 100, 0, 0L, b.this.jIv);
            }
        });
        this.jCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jIr.a(b.this.jCX, 101, 0, 0L, b.this.jIv);
            }
        });
        this.jCW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jIr.b(b.this.jCW, 200, 0, 0L, b.this.jIv);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jIv != null) {
            this.jIr.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jIr.getLayoutMode().onModeChanged(this.jCW);
            String portrait = this.jIv.getPortrait();
            this.jCX.setTag(portrait);
            this.jCX.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jIv.getUserName())) {
                this.jIs.setText(this.jIv.getUserName());
            }
            if (!TextUtils.isEmpty(this.jIv.getGroupName())) {
                this.jCY.setText(this.jIr.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jIv.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jIv.getApplyReason())) {
                this.jIt.setText(this.jIr.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jIv.getApplyReason());
            }
            if (this.jIv.isPass()) {
                this.jIu.setEnabled(false);
                this.jIu.setText(this.jIr.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.jIu, R.color.cp_cont_d);
                this.jIu.setBackgroundDrawable(null);
            } else {
                this.jIu.setEnabled(true);
                this.jIu.setText(this.jIr.getPageContext().getString(R.string.pass));
            }
            if (!this.jIv.isShown()) {
                ap.setBackgroundResource(this.jCW, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jIv = validateItemData;
    }
}

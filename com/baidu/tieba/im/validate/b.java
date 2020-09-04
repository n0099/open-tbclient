package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes20.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View juu;
    private HeadImageView juv;
    private TextView juw;
    private ValidateActivity jzP;
    private TextView jzQ;
    private TextView jzR;
    private TextView jzS;
    private ValidateItemData jzT;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.jzP = validateActivity;
        initView();
    }

    void initView() {
        this.juu = this.mConvertView.findViewById(R.id.root_view);
        this.juv = (HeadImageView) this.juu.findViewById(R.id.iv_head);
        this.juv.setIsRound(false);
        this.jzQ = (TextView) this.juu.findViewById(R.id.tv_user_name);
        this.juw = (TextView) this.juu.findViewById(R.id.tv_group_name);
        this.jzR = (TextView) this.juu.findViewById(R.id.tv_apply_reason);
        this.jzS = (TextView) this.juu.findViewById(R.id.btn_pass);
        this.jzS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jzP.a(b.this.jzS, 100, 0, 0L, b.this.jzT);
            }
        });
        this.juv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.jzP.a(b.this.juv, 101, 0, 0L, b.this.jzT);
            }
        });
        this.juu.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.jzP.b(b.this.juu, 200, 0, 0L, b.this.jzT);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.jzT != null) {
            this.jzP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.jzP.getLayoutMode().onModeChanged(this.juu);
            String portrait = this.jzT.getPortrait();
            this.juv.setTag(portrait);
            this.juv.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.jzT.getUserName())) {
                this.jzQ.setText(this.jzT.getUserName());
            }
            if (!TextUtils.isEmpty(this.jzT.getGroupName())) {
                this.juw.setText(this.jzP.getPageContext().getString(R.string.validate_im_apply_prefix) + this.jzT.getGroupName());
            }
            if (!TextUtils.isEmpty(this.jzT.getApplyReason())) {
                this.jzR.setText(this.jzP.getPageContext().getString(R.string.validate_im_reason_prefix) + this.jzT.getApplyReason());
            }
            if (this.jzT.isPass()) {
                this.jzS.setEnabled(false);
                this.jzS.setText(this.jzP.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.jzS, R.color.cp_cont_d);
                this.jzS.setBackgroundDrawable(null);
            } else {
                this.jzS.setEnabled(true);
                this.jzS.setText(this.jzP.getPageContext().getString(R.string.pass));
            }
            if (!this.jzT.isShown()) {
                ap.setBackgroundResource(this.juu, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.jzT = validateItemData;
    }
}

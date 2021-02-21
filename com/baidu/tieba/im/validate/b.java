package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes8.dex */
public class b extends com.baidu.adp.base.c<ValidateActivity> {
    private View kHH;
    private HeadImageView kHI;
    private TextView kHJ;
    private ValidateActivity kMP;
    private TextView kMQ;
    private TextView kMR;
    private TextView kMS;
    private ValidateItemData kMT;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kMP = validateActivity;
        initView();
    }

    void initView() {
        this.kHH = this.mConvertView.findViewById(R.id.root_view);
        this.kHI = (HeadImageView) this.kHH.findViewById(R.id.iv_head);
        this.kHI.setIsRound(false);
        this.kMQ = (TextView) this.kHH.findViewById(R.id.tv_user_name);
        this.kHJ = (TextView) this.kHH.findViewById(R.id.tv_group_name);
        this.kMR = (TextView) this.kHH.findViewById(R.id.tv_apply_reason);
        this.kMS = (TextView) this.kHH.findViewById(R.id.btn_pass);
        this.kMS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMP.a(b.this.kMS, 100, 0, 0L, b.this.kMT);
            }
        });
        this.kHI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kMP.a(b.this.kHI, 101, 0, 0L, b.this.kMT);
            }
        });
        this.kHH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kMP.b(b.this.kHH, 200, 0, 0L, b.this.kMT);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kMT != null) {
            this.kMP.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kMP.getLayoutMode().onModeChanged(this.kHH);
            String portrait = this.kMT.getPortrait();
            this.kHI.setTag(portrait);
            this.kHI.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kMT.getUserName())) {
                this.kMQ.setText(this.kMT.getUserName());
            }
            if (!TextUtils.isEmpty(this.kMT.getGroupName())) {
                this.kHJ.setText(this.kMP.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kMT.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kMT.getApplyReason())) {
                this.kMR.setText(this.kMP.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kMT.getApplyReason());
            }
            if (this.kMT.isPass()) {
                this.kMS.setEnabled(false);
                this.kMS.setText(this.kMP.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kMS, R.color.CAM_X0109);
                this.kMS.setBackgroundDrawable(null);
            } else {
                this.kMS.setEnabled(true);
                this.kMS.setText(this.kMP.getPageContext().getString(R.string.pass));
            }
            if (!this.kMT.isShown()) {
                ap.setBackgroundResource(this.kHH, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kMT = validateItemData;
    }
}

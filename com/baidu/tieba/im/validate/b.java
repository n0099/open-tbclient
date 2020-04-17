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
    private HeadImageView iqA;
    private TextView iqB;
    private View iqz;
    private ValidateActivity ivM;
    private TextView ivN;
    private TextView ivO;
    private TextView ivP;
    private ValidateItemData ivQ;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.ivM = validateActivity;
        initView();
    }

    void initView() {
        this.iqz = this.mConvertView.findViewById(R.id.root_view);
        this.iqA = (HeadImageView) this.iqz.findViewById(R.id.iv_head);
        this.iqA.setIsRound(false);
        this.ivN = (TextView) this.iqz.findViewById(R.id.tv_user_name);
        this.iqB = (TextView) this.iqz.findViewById(R.id.tv_group_name);
        this.ivO = (TextView) this.iqz.findViewById(R.id.tv_apply_reason);
        this.ivP = (TextView) this.iqz.findViewById(R.id.btn_pass);
        this.ivP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ivM.a(b.this.ivP, 100, 0, 0L, b.this.ivQ);
            }
        });
        this.iqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.ivM.a(b.this.iqA, 101, 0, 0L, b.this.ivQ);
            }
        });
        this.iqz.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.ivM.b(b.this.iqz, 200, 0, 0L, b.this.ivQ);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.ivQ != null) {
            this.ivM.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.ivM.getLayoutMode().onModeChanged(this.iqz);
            String portrait = this.ivQ.getPortrait();
            this.iqA.setTag(portrait);
            this.iqA.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.ivQ.getUserName())) {
                this.ivN.setText(this.ivQ.getUserName());
            }
            if (!TextUtils.isEmpty(this.ivQ.getGroupName())) {
                this.iqB.setText(this.ivM.getPageContext().getString(R.string.validate_im_apply_prefix) + this.ivQ.getGroupName());
            }
            if (!TextUtils.isEmpty(this.ivQ.getApplyReason())) {
                this.ivO.setText(this.ivM.getPageContext().getString(R.string.validate_im_reason_prefix) + this.ivQ.getApplyReason());
            }
            if (this.ivQ.isPass()) {
                this.ivP.setEnabled(false);
                this.ivP.setText(this.ivM.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.ivP, (int) R.color.cp_cont_d);
                this.ivP.setBackgroundDrawable(null);
            } else {
                this.ivP.setEnabled(true);
                this.ivP.setText(this.ivM.getPageContext().getString(R.string.pass));
            }
            if (!this.ivQ.isShown()) {
                am.setBackgroundResource(this.iqz, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.ivQ = validateItemData;
    }
}

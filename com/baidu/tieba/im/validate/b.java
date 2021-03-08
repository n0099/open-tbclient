package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes7.dex */
public class b extends com.baidu.adp.base.c<ValidateActivity> {
    private View kJJ;
    private HeadImageView kJK;
    private TextView kJL;
    private ValidateActivity kOR;
    private TextView kOS;
    private TextView kOT;
    private TextView kOU;
    private ValidateItemData kOV;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kOR = validateActivity;
        initView();
    }

    void initView() {
        this.kJJ = this.mConvertView.findViewById(R.id.root_view);
        this.kJK = (HeadImageView) this.kJJ.findViewById(R.id.iv_head);
        this.kJK.setIsRound(false);
        this.kOS = (TextView) this.kJJ.findViewById(R.id.tv_user_name);
        this.kJL = (TextView) this.kJJ.findViewById(R.id.tv_group_name);
        this.kOT = (TextView) this.kJJ.findViewById(R.id.tv_apply_reason);
        this.kOU = (TextView) this.kJJ.findViewById(R.id.btn_pass);
        this.kOU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kOR.a(b.this.kOU, 100, 0, 0L, b.this.kOV);
            }
        });
        this.kJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kOR.a(b.this.kJK, 101, 0, 0L, b.this.kOV);
            }
        });
        this.kJJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kOR.b(b.this.kJJ, 200, 0, 0L, b.this.kOV);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kOV != null) {
            this.kOR.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kOR.getLayoutMode().onModeChanged(this.kJJ);
            String portrait = this.kOV.getPortrait();
            this.kJK.setTag(portrait);
            this.kJK.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kOV.getUserName())) {
                this.kOS.setText(this.kOV.getUserName());
            }
            if (!TextUtils.isEmpty(this.kOV.getGroupName())) {
                this.kJL.setText(this.kOR.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kOV.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kOV.getApplyReason())) {
                this.kOT.setText(this.kOR.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kOV.getApplyReason());
            }
            if (this.kOV.isPass()) {
                this.kOU.setEnabled(false);
                this.kOU.setText(this.kOR.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kOU, R.color.CAM_X0109);
                this.kOU.setBackgroundDrawable(null);
            } else {
                this.kOU.setEnabled(true);
                this.kOU.setText(this.kOR.getPageContext().getString(R.string.pass));
            }
            if (!this.kOV.isShown()) {
                ap.setBackgroundResource(this.kJJ, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kOV = validateItemData;
    }
}

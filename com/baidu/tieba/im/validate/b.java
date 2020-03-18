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
    private View hGJ;
    private HeadImageView hGK;
    private TextView hGL;
    private ValidateActivity hLW;
    private TextView hLX;
    private TextView hLY;
    private TextView hLZ;
    private ValidateItemData hMa;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hLW = validateActivity;
        initView();
    }

    void initView() {
        this.hGJ = this.mConvertView.findViewById(R.id.root_view);
        this.hGK = (HeadImageView) this.hGJ.findViewById(R.id.iv_head);
        this.hGK.setIsRound(false);
        this.hLX = (TextView) this.hGJ.findViewById(R.id.tv_user_name);
        this.hGL = (TextView) this.hGJ.findViewById(R.id.tv_group_name);
        this.hLY = (TextView) this.hGJ.findViewById(R.id.tv_apply_reason);
        this.hLZ = (TextView) this.hGJ.findViewById(R.id.btn_pass);
        this.hLZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hLW.a(b.this.hLZ, 100, 0, 0L, b.this.hMa);
            }
        });
        this.hGK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hLW.a(b.this.hGK, 101, 0, 0L, b.this.hMa);
            }
        });
        this.hGJ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hLW.b(b.this.hGJ, 200, 0, 0L, b.this.hMa);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hMa != null) {
            this.hLW.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hLW.getLayoutMode().onModeChanged(this.hGJ);
            String portrait = this.hMa.getPortrait();
            this.hGK.setTag(portrait);
            this.hGK.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hMa.getUserName())) {
                this.hLX.setText(this.hMa.getUserName());
            }
            if (!TextUtils.isEmpty(this.hMa.getGroupName())) {
                this.hGL.setText(this.hLW.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hMa.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hMa.getApplyReason())) {
                this.hLY.setText(this.hLW.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hMa.getApplyReason());
            }
            if (this.hMa.isPass()) {
                this.hLZ.setEnabled(false);
                this.hLZ.setText(this.hLW.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hLZ, (int) R.color.cp_cont_d);
                this.hLZ.setBackgroundDrawable(null);
            } else {
                this.hLZ.setEnabled(true);
                this.hLZ.setText(this.hLW.getPageContext().getString(R.string.pass));
            }
            if (!this.hMa.isShown()) {
                am.setBackgroundResource(this.hGJ, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hMa = validateItemData;
    }
}

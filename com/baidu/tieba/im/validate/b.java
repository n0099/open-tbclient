package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes11.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View hCW;
    private HeadImageView hCX;
    private TextView hCY;
    private ValidateActivity hIj;
    private TextView hIk;
    private TextView hIl;
    private TextView hIm;
    private ValidateItemData hIn;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.hIj = validateActivity;
        initView();
    }

    void initView() {
        this.hCW = this.mConvertView.findViewById(R.id.root_view);
        this.hCX = (HeadImageView) this.hCW.findViewById(R.id.iv_head);
        this.hCX.setIsRound(false);
        this.hIk = (TextView) this.hCW.findViewById(R.id.tv_user_name);
        this.hCY = (TextView) this.hCW.findViewById(R.id.tv_group_name);
        this.hIl = (TextView) this.hCW.findViewById(R.id.tv_apply_reason);
        this.hIm = (TextView) this.hCW.findViewById(R.id.btn_pass);
        this.hIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hIj.a(b.this.hIm, 100, 0, 0L, b.this.hIn);
            }
        });
        this.hCX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.hIj.a(b.this.hCX, 101, 0, 0L, b.this.hIn);
            }
        });
        this.hCW.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.hIj.b(b.this.hCW, 200, 0, 0L, b.this.hIn);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.hIn != null) {
            this.hIj.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.hIj.getLayoutMode().onModeChanged(this.hCW);
            String portrait = this.hIn.getPortrait();
            this.hCX.setTag(portrait);
            this.hCX.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.hIn.getUserName())) {
                this.hIk.setText(this.hIn.getUserName());
            }
            if (!TextUtils.isEmpty(this.hIn.getGroupName())) {
                this.hCY.setText(this.hIj.getPageContext().getString(R.string.validate_im_apply_prefix) + this.hIn.getGroupName());
            }
            if (!TextUtils.isEmpty(this.hIn.getApplyReason())) {
                this.hIl.setText(this.hIj.getPageContext().getString(R.string.validate_im_reason_prefix) + this.hIn.getApplyReason());
            }
            if (this.hIn.isPass()) {
                this.hIm.setEnabled(false);
                this.hIm.setText(this.hIj.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.hIm, (int) R.color.cp_cont_d);
                this.hIm.setBackgroundDrawable(null);
            } else {
                this.hIm.setEnabled(true);
                this.hIm.setText(this.hIj.getPageContext().getString(R.string.pass));
            }
            if (!this.hIn.isShown()) {
                am.setBackgroundResource(this.hCW, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.hIn = validateItemData;
    }
}

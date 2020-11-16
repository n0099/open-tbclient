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
    private View kla;
    private HeadImageView klb;
    private TextView klc;
    private ValidateActivity kqu;
    private TextView kqv;
    private TextView kqw;
    private TextView kqx;
    private ValidateItemData kqy;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kqu = validateActivity;
        initView();
    }

    void initView() {
        this.kla = this.mConvertView.findViewById(R.id.root_view);
        this.klb = (HeadImageView) this.kla.findViewById(R.id.iv_head);
        this.klb.setIsRound(false);
        this.kqv = (TextView) this.kla.findViewById(R.id.tv_user_name);
        this.klc = (TextView) this.kla.findViewById(R.id.tv_group_name);
        this.kqw = (TextView) this.kla.findViewById(R.id.tv_apply_reason);
        this.kqx = (TextView) this.kla.findViewById(R.id.btn_pass);
        this.kqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kqu.a(b.this.kqx, 100, 0, 0L, b.this.kqy);
            }
        });
        this.klb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kqu.a(b.this.klb, 101, 0, 0L, b.this.kqy);
            }
        });
        this.kla.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kqu.b(b.this.kla, 200, 0, 0L, b.this.kqy);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kqy != null) {
            this.kqu.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kqu.getLayoutMode().onModeChanged(this.kla);
            String portrait = this.kqy.getPortrait();
            this.klb.setTag(portrait);
            this.klb.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kqy.getUserName())) {
                this.kqv.setText(this.kqy.getUserName());
            }
            if (!TextUtils.isEmpty(this.kqy.getGroupName())) {
                this.klc.setText(this.kqu.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kqy.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kqy.getApplyReason())) {
                this.kqw.setText(this.kqu.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kqy.getApplyReason());
            }
            if (this.kqy.isPass()) {
                this.kqx.setEnabled(false);
                this.kqx.setText(this.kqu.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kqx, R.color.CAM_X0109);
                this.kqx.setBackgroundDrawable(null);
            } else {
                this.kqx.setEnabled(true);
                this.kqx.setText(this.kqu.getPageContext().getString(R.string.pass));
            }
            if (!this.kqy.isShown()) {
                ap.setBackgroundResource(this.kla, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kqy = validateItemData;
    }
}

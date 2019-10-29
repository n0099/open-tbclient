package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes3.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View gMg;
    private HeadImageView gMh;
    private TextView gMi;
    private ValidateActivity gRt;
    private TextView gRu;
    private TextView gRv;
    private TextView gRw;
    private ValidateItemData gRx;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gRt = validateActivity;
        initView();
    }

    void initView() {
        this.gMg = this.mConvertView.findViewById(R.id.root_view);
        this.gMh = (HeadImageView) this.gMg.findViewById(R.id.iv_head);
        this.gMh.setIsRound(false);
        this.gRu = (TextView) this.gMg.findViewById(R.id.tv_user_name);
        this.gMi = (TextView) this.gMg.findViewById(R.id.tv_group_name);
        this.gRv = (TextView) this.gMg.findViewById(R.id.tv_apply_reason);
        this.gRw = (TextView) this.gMg.findViewById(R.id.btn_pass);
        this.gRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gRt.a(b.this.gRw, 100, 0, 0L, b.this.gRx);
            }
        });
        this.gMh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gRt.a(b.this.gMh, 101, 0, 0L, b.this.gRx);
            }
        });
        this.gMg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gRt.b(b.this.gMg, 200, 0, 0L, b.this.gRx);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gRx != null) {
            this.gRt.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gRt.getLayoutMode().onModeChanged(this.gMg);
            String portrait = this.gRx.getPortrait();
            this.gMh.setTag(portrait);
            this.gMh.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gRx.getUserName())) {
                this.gRu.setText(this.gRx.getUserName());
            }
            if (!TextUtils.isEmpty(this.gRx.getGroupName())) {
                this.gMi.setText(this.gRt.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gRx.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gRx.getApplyReason())) {
                this.gRv.setText(this.gRt.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gRx.getApplyReason());
            }
            if (this.gRx.isPass()) {
                this.gRw.setEnabled(false);
                this.gRw.setText(this.gRt.getPageContext().getString(R.string.passed));
                am.setViewTextColor(this.gRw, (int) R.color.cp_cont_d);
                this.gRw.setBackgroundDrawable(null);
            } else {
                this.gRw.setEnabled(true);
                this.gRw.setText(this.gRt.getPageContext().getString(R.string.pass));
            }
            if (!this.gRx.isShown()) {
                am.setBackgroundResource(this.gMg, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gRx = validateItemData;
    }
}

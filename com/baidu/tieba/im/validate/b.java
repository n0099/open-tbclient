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
    private View gLv;
    private HeadImageView gLw;
    private TextView gLx;
    private ValidateActivity gQI;
    private TextView gQJ;
    private TextView gQK;
    private TextView gQL;
    private ValidateItemData gQM;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gQI = validateActivity;
        initView();
    }

    void initView() {
        this.gLv = this.sP.findViewById(R.id.root_view);
        this.gLw = (HeadImageView) this.gLv.findViewById(R.id.iv_head);
        this.gLw.setIsRound(false);
        this.gQJ = (TextView) this.gLv.findViewById(R.id.tv_user_name);
        this.gLx = (TextView) this.gLv.findViewById(R.id.tv_group_name);
        this.gQK = (TextView) this.gLv.findViewById(R.id.tv_apply_reason);
        this.gQL = (TextView) this.gLv.findViewById(R.id.btn_pass);
        this.gQL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gQI.a(b.this.gQL, 100, 0, 0L, b.this.gQM);
            }
        });
        this.gLw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gQI.a(b.this.gLw, 101, 0, 0L, b.this.gQM);
            }
        });
        this.gLv.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gQI.b(b.this.gLv, 200, 0, 0L, b.this.gQM);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gQM != null) {
            this.gQI.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gQI.getLayoutMode().onModeChanged(this.gLv);
            String portrait = this.gQM.getPortrait();
            this.gLw.setTag(portrait);
            this.gLw.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gQM.getUserName())) {
                this.gQJ.setText(this.gQM.getUserName());
            }
            if (!TextUtils.isEmpty(this.gQM.getGroupName())) {
                this.gLx.setText(this.gQI.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gQM.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gQM.getApplyReason())) {
                this.gQK.setText(this.gQI.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gQM.getApplyReason());
            }
            if (this.gQM.isPass()) {
                this.gQL.setEnabled(false);
                this.gQL.setText(this.gQI.getPageContext().getString(R.string.passed));
                am.j(this.gQL, R.color.cp_cont_d);
                this.gQL.setBackgroundDrawable(null);
            } else {
                this.gQL.setEnabled(true);
                this.gQL.setText(this.gQI.getPageContext().getString(R.string.pass));
            }
            if (!this.gQM.isShown()) {
                am.k(this.gLv, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gQM = validateItemData;
    }
}

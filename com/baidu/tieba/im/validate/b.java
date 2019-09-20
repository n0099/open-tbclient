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
    private View gOf;
    private HeadImageView gOg;
    private TextView gOh;
    private ValidateActivity gTt;
    private TextView gTu;
    private TextView gTv;
    private TextView gTw;
    private ValidateItemData gTx;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.gTt = validateActivity;
        initView();
    }

    void initView() {
        this.gOf = this.sP.findViewById(R.id.root_view);
        this.gOg = (HeadImageView) this.gOf.findViewById(R.id.iv_head);
        this.gOg.setIsRound(false);
        this.gTu = (TextView) this.gOf.findViewById(R.id.tv_user_name);
        this.gOh = (TextView) this.gOf.findViewById(R.id.tv_group_name);
        this.gTv = (TextView) this.gOf.findViewById(R.id.tv_apply_reason);
        this.gTw = (TextView) this.gOf.findViewById(R.id.btn_pass);
        this.gTw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gTt.a(b.this.gTw, 100, 0, 0L, b.this.gTx);
            }
        });
        this.gOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.gTt.a(b.this.gOg, 101, 0, 0L, b.this.gTx);
            }
        });
        this.gOf.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.gTt.b(b.this.gOf, 200, 0, 0L, b.this.gTx);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.gTx != null) {
            this.gTt.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.gTt.getLayoutMode().onModeChanged(this.gOf);
            String portrait = this.gTx.getPortrait();
            this.gOg.setTag(portrait);
            this.gOg.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.gTx.getUserName())) {
                this.gTu.setText(this.gTx.getUserName());
            }
            if (!TextUtils.isEmpty(this.gTx.getGroupName())) {
                this.gOh.setText(this.gTt.getPageContext().getString(R.string.validate_im_apply_prefix) + this.gTx.getGroupName());
            }
            if (!TextUtils.isEmpty(this.gTx.getApplyReason())) {
                this.gTv.setText(this.gTt.getPageContext().getString(R.string.validate_im_reason_prefix) + this.gTx.getApplyReason());
            }
            if (this.gTx.isPass()) {
                this.gTw.setEnabled(false);
                this.gTw.setText(this.gTt.getPageContext().getString(R.string.passed));
                am.j(this.gTw, R.color.cp_cont_d);
                this.gTw.setBackgroundDrawable(null);
            } else {
                this.gTw.setEnabled(true);
                this.gTw.setText(this.gTt.getPageContext().getString(R.string.pass));
            }
            if (!this.gTx.isShown()) {
                am.k(this.gOf, R.color.common_color_10178);
            }
        }
    }

    public void f(ValidateItemData validateItemData) {
        g(validateItemData);
        refresh();
    }

    public void g(ValidateItemData validateItemData) {
        this.gTx = validateItemData;
    }
}

package com.baidu.tieba.im.validate;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
/* loaded from: classes26.dex */
public class b extends com.baidu.adp.base.b<ValidateActivity> {
    private View kes;
    private HeadImageView ket;
    private TextView keu;
    private ValidateActivity kjO;
    private TextView kjP;
    private TextView kjQ;
    private TextView kjR;
    private ValidateItemData kjS;

    public b(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext(), R.layout.validate_item);
        this.kjO = validateActivity;
        initView();
    }

    void initView() {
        this.kes = this.mConvertView.findViewById(R.id.root_view);
        this.ket = (HeadImageView) this.kes.findViewById(R.id.iv_head);
        this.ket.setIsRound(false);
        this.kjP = (TextView) this.kes.findViewById(R.id.tv_user_name);
        this.keu = (TextView) this.kes.findViewById(R.id.tv_group_name);
        this.kjQ = (TextView) this.kes.findViewById(R.id.tv_apply_reason);
        this.kjR = (TextView) this.kes.findViewById(R.id.btn_pass);
        this.kjR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kjO.a(b.this.kjR, 100, 0, 0L, b.this.kjS);
            }
        });
        this.ket.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.validate.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.kjO.a(b.this.ket, 101, 0, 0L, b.this.kjS);
            }
        });
        this.kes.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.im.validate.b.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                b.this.kjO.b(b.this.kes, 200, 0, 0L, b.this.kjS);
                return true;
            }
        });
    }

    public void refresh() {
        if (this.kjS != null) {
            this.kjO.getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
            this.kjO.getLayoutMode().onModeChanged(this.kes);
            String portrait = this.kjS.getPortrait();
            this.ket.setTag(portrait);
            this.ket.startLoad(portrait, 12, false);
            if (!TextUtils.isEmpty(this.kjS.getUserName())) {
                this.kjP.setText(this.kjS.getUserName());
            }
            if (!TextUtils.isEmpty(this.kjS.getGroupName())) {
                this.keu.setText(this.kjO.getPageContext().getString(R.string.validate_im_apply_prefix) + this.kjS.getGroupName());
            }
            if (!TextUtils.isEmpty(this.kjS.getApplyReason())) {
                this.kjQ.setText(this.kjO.getPageContext().getString(R.string.validate_im_reason_prefix) + this.kjS.getApplyReason());
            }
            if (this.kjS.isPass()) {
                this.kjR.setEnabled(false);
                this.kjR.setText(this.kjO.getPageContext().getString(R.string.passed));
                ap.setViewTextColor(this.kjR, R.color.cp_cont_d);
                this.kjR.setBackgroundDrawable(null);
            } else {
                this.kjR.setEnabled(true);
                this.kjR.setText(this.kjO.getPageContext().getString(R.string.pass));
            }
            if (!this.kjS.isShown()) {
                ap.setBackgroundResource(this.kes, R.color.common_color_10178);
            }
        }
    }

    public void e(ValidateItemData validateItemData) {
        f(validateItemData);
        refresh();
    }

    public void f(ValidateItemData validateItemData) {
        this.kjS = validateItemData;
    }
}

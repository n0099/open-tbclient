package com.baidu.tieba.setting.more.youngster.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.atomData.YoungsterPasswordActivityConfig;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    private ImageView lSl;
    private TextView lSm;
    private TextView lSn;
    private TextView lSo;
    private TextView lSp;
    private TBSpecificationBtn lSq;
    private int mFrom;

    public YoungsterIntroduceView(Context context) {
        this(context, null);
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YoungsterIntroduceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.youngster_introduce, this);
        this.lSl = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.lSm = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.lSn = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.lSo = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.lSp = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.lSq = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.lSq.setConfig(new a());
        this.lSq.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.lSq.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lSl.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.lSm, R.color.cp_cont_b);
        ap.setViewTextColor(this.lSn, R.color.cp_cont_j);
        ap.setViewTextColor(this.lSo, R.color.cp_cont_j);
        ap.setViewTextColor(this.lSp, R.color.cp_cont_j);
        this.lSq.bkF();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lSq) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

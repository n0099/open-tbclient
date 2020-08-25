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
    private ImageView lRW;
    private TextView lRX;
    private TextView lRY;
    private TextView lRZ;
    private TextView lSa;
    private TBSpecificationBtn lSb;
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
        this.lRW = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.lRX = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.lRY = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.lRZ = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.lSa = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.lSb = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.lSb.setConfig(new a());
        this.lSb.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.lSb.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.lRW.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.lRX, R.color.cp_cont_b);
        ap.setViewTextColor(this.lRY, R.color.cp_cont_j);
        ap.setViewTextColor(this.lRZ, R.color.cp_cont_j);
        ap.setViewTextColor(this.lSa, R.color.cp_cont_j);
        this.lSb.bkF();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.lSb) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

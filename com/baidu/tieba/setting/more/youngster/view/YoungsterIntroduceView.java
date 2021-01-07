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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.a;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    private int mFrom;
    private ImageView ndM;
    private TextView ndN;
    private TextView ndO;
    private TextView ndP;
    private TextView ndQ;
    private TBSpecificationBtn ndR;

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
        this.ndM = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.ndN = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.ndO = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.ndP = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.ndQ = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.ndR = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.ndR.setConfig(new a());
        this.ndR.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.ndR.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.ndM.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(this.ndN, R.color.CAM_X0105);
        ao.setViewTextColor(this.ndO, R.color.CAM_X0107);
        ao.setViewTextColor(this.ndP, R.color.CAM_X0107);
        ao.setViewTextColor(this.ndQ, R.color.CAM_X0107);
        this.ndR.bxP();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ndR) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

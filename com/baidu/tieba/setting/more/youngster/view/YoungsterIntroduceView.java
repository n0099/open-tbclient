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
/* loaded from: classes7.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    private int mFrom;
    private ImageView mZh;
    private TextView mZi;
    private TextView mZj;
    private TextView mZk;
    private TextView mZl;
    private TBSpecificationBtn mZm;

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
        this.mZh = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.mZi = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.mZj = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.mZk = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.mZl = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.mZm = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.mZm.setConfig(new a());
        this.mZm.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.mZm.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mZh.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ao.setViewTextColor(this.mZi, R.color.CAM_X0105);
        ao.setViewTextColor(this.mZj, R.color.CAM_X0107);
        ao.setViewTextColor(this.mZk, R.color.CAM_X0107);
        ao.setViewTextColor(this.mZl, R.color.CAM_X0107);
        this.mZm.btV();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mZm) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

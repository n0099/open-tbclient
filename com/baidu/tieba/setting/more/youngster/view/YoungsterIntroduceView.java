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
/* loaded from: classes26.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    private int mFrom;
    private ImageView mJG;
    private TextView mJH;
    private TextView mJI;
    private TextView mJJ;
    private TextView mJK;
    private TBSpecificationBtn mJL;

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
        this.mJG = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.mJH = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.mJI = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.mJJ = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.mJK = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.mJL = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.mJL.setConfig(new a());
        this.mJL.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.mJL.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mJG.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.mJH, R.color.cp_cont_b);
        ap.setViewTextColor(this.mJI, R.color.cp_cont_j);
        ap.setViewTextColor(this.mJJ, R.color.cp_cont_j);
        ap.setViewTextColor(this.mJK, R.color.cp_cont_j);
        this.mJL.bsD();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mJL) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

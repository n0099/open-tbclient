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
/* loaded from: classes25.dex */
public class YoungsterIntroduceView extends LinearLayout implements View.OnClickListener {
    private int mFrom;
    private TBSpecificationBtn mbA;
    private ImageView mbv;
    private TextView mbw;
    private TextView mbx;
    private TextView mby;
    private TextView mbz;

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
        this.mbv = (ImageView) findViewById(R.id.img_youngster_introduce);
        this.mbw = (TextView) findViewById(R.id.txt_youngster_introduce_title);
        this.mbx = (TextView) findViewById(R.id.txt_youngster_introduce_content1);
        this.mby = (TextView) findViewById(R.id.txt_youngster_introduce_content2);
        this.mbz = (TextView) findViewById(R.id.txt_youngster_introduce_content3);
        this.mbA = (TBSpecificationBtn) findViewById(R.id.btn_youngster_open);
        this.mbA.setConfig(new a());
        this.mbA.setText(getContext().getString(R.string.youngster_settings_open_title));
        this.mbA.setOnClickListener(this);
        onChangeSkinType();
    }

    public void onChangeSkinType() {
        this.mbv.setImageDrawable(WebPManager.a(R.drawable.pic_mask_qingshaonian, WebPManager.ResourceStateType.NORMAL));
        ap.setViewTextColor(this.mbw, R.color.cp_cont_b);
        ap.setViewTextColor(this.mbx, R.color.cp_cont_j);
        ap.setViewTextColor(this.mby, R.color.cp_cont_j);
        ap.setViewTextColor(this.mbz, R.color.cp_cont_j);
        this.mbA.blA();
    }

    public void setFrom(int i) {
        this.mFrom = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mbA) {
            YoungsterPasswordActivityConfig youngsterPasswordActivityConfig = new YoungsterPasswordActivityConfig(getContext());
            youngsterPasswordActivityConfig.setYoungsterPasswordPageType(1);
            youngsterPasswordActivityConfig.setKeyYoungsterPasswordFrom(this.mFrom);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, youngsterPasswordActivityConfig));
        }
    }
}

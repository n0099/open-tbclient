package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    private RelativeLayout kZO;
    private TextView kZP;
    private TextView kZQ;
    private Context mContext;
    private TbPageContext<?> mTbPageContext;

    public SearchPageFocusBar(Context context) {
        super(context);
        init(context, null);
    }

    public SearchPageFocusBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, null);
    }

    public SearchPageFocusBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.home_search_focusbar, this);
        this.kZO = (RelativeLayout) findViewById(R.id.focusbar_container);
        this.kZQ = (TextView) findViewById(R.id.focusbar_hint);
        ap.setViewTextColor(this.kZQ, R.color.CAM_X0108, 1);
        this.kZQ.setVisibility(8);
        this.kZP = (TextView) findViewById(R.id.focusbar_show);
        ap.setViewTextColor(this.kZP, R.color.CAM_X0302, 1);
        this.kZP.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!StringUtils.isNull(charSequence)) {
                this.mTbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(charSequence, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}

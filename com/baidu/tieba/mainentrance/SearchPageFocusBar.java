package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    private RelativeLayout gNq;
    private TextView gNr;
    private TextView gNs;
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
        LayoutInflater.from(context).inflate(d.h.home_search_focusbar, this);
        this.gNq = (RelativeLayout) findViewById(d.g.focusbar_container);
        this.gNs = (TextView) findViewById(d.g.focusbar_hint);
        al.d(this.gNs, d.C0277d.cp_cont_c, 1);
        this.gNs.setVisibility(8);
        this.gNr = (TextView) findViewById(d.g.focusbar_show);
        al.d(this.gNr, d.C0277d.cp_link_tip_a, 1);
        this.gNr.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof TextView) {
            String charSequence = ((TextView) view).getText().toString();
            if (!StringUtils.isNull(charSequence)) {
                this.mTbPageContext.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.mTbPageContext.getPageActivity()).createNormalCfg(charSequence, FrsActivityConfig.FRS_FROM_SEARCH)));
            }
        }
    }
}

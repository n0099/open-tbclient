package com.baidu.tieba.mainentrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    private RelativeLayout cvM;
    private TextView cvN;
    private TextView cvO;
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
        LayoutInflater.from(context).inflate(t.h.home_search_focusbar, this);
        this.cvM = (RelativeLayout) findViewById(t.g.focusbar_container);
        this.cvO = (TextView) findViewById(t.g.focusbar_hint);
        com.baidu.tbadk.core.util.ar.b(this.cvO, t.d.cp_cont_c, 1);
        this.cvO.setVisibility(8);
        this.cvN = (TextView) findViewById(t.g.focusbar_show);
        com.baidu.tbadk.core.util.ar.b(this.cvN, t.d.cp_link_tip_a, 1);
        this.cvN.setVisibility(8);
    }

    public void c(List<String> list, TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cvM.removeAllViews();
        if (list != null && list.size() > 0) {
            this.cvO.setVisibility(0);
            for (int i = 0; i < list.size() && i <= 5; i++) {
                ab(list.get(i), i);
            }
        }
        if (list != null && list.size() >= 7) {
            this.cvN.setVisibility(0);
            this.cvN.setOnClickListener(new i(this, tbPageContext));
        }
    }

    private void ab(String str, int i) {
        int i2;
        if (i % 2 > 0) {
            i2 = (int) getResources().getDimension(t.e.ds330);
        } else {
            i2 = 0;
        }
        TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(t.h.home_search_focusbar_item, (ViewGroup) null);
        int dimension = (i / 2) * ((int) getResources().getDimension(t.e.ds110));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) getResources().getDimension(t.e.ds321), (int) getResources().getDimension(t.e.ds96));
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = dimension;
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setOnClickListener(this);
        com.baidu.tbadk.core.util.ar.k(textView, t.f.home_like_item_bg);
        com.baidu.tbadk.core.util.ar.b(textView, t.d.cp_cont_b, 1);
        this.cvM.addView(textView);
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

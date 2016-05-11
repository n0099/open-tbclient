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
    private RelativeLayout cLD;
    private TextView cLE;
    private TextView cLF;
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
        this.cLD = (RelativeLayout) findViewById(t.g.focusbar_container);
        this.cLF = (TextView) findViewById(t.g.focusbar_hint);
        com.baidu.tbadk.core.util.at.c(this.cLF, t.d.cp_cont_c, 1);
        this.cLF.setVisibility(8);
        this.cLE = (TextView) findViewById(t.g.focusbar_show);
        com.baidu.tbadk.core.util.at.c(this.cLE, t.d.cp_link_tip_a, 1);
        this.cLE.setVisibility(8);
    }

    public void c(List<String> list, TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.cLD.removeAllViews();
        if (list != null && list.size() > 0) {
            this.cLF.setVisibility(0);
            for (int i = 0; i < list.size() && i <= 5; i++) {
                ao(list.get(i), i);
            }
        }
        if (list != null && list.size() >= 7) {
            this.cLE.setVisibility(0);
            this.cLE.setOnClickListener(new i(this, tbPageContext));
        }
    }

    private void ao(String str, int i) {
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
        com.baidu.tbadk.core.util.at.k(textView, t.f.home_like_item_bg);
        com.baidu.tbadk.core.util.at.c(textView, t.d.cp_cont_b, 1);
        this.cLD.addView(textView);
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

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
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class SearchPageFocusBar extends RelativeLayout implements View.OnClickListener {
    private RelativeLayout bUn;
    private TextView bUo;
    private TextView bUp;
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
        LayoutInflater.from(context).inflate(i.g.home_search_focusbar, this);
        this.bUn = (RelativeLayout) findViewById(i.f.focusbar_container);
        this.bUp = (TextView) findViewById(i.f.focusbar_hint);
        com.baidu.tbadk.core.util.an.b(this.bUp, i.c.cp_cont_c, 1);
        this.bUp.setVisibility(8);
        this.bUo = (TextView) findViewById(i.f.focusbar_show);
        com.baidu.tbadk.core.util.an.b(this.bUo, i.c.cp_link_tip_a, 1);
        this.bUo.setVisibility(8);
    }

    public void b(List<String> list, TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.bUn.removeAllViews();
        if (list != null && list.size() > 0) {
            this.bUp.setVisibility(0);
            for (int i = 0; i < list.size() && i <= 5; i++) {
                U(list.get(i), i);
            }
        }
        if (list != null && list.size() >= 7) {
            this.bUo.setVisibility(0);
            this.bUo.setOnClickListener(new j(this, tbPageContext));
        }
    }

    private void U(String str, int i) {
        int i2;
        if (i % 2 > 0) {
            i2 = (int) getResources().getDimension(i.d.ds330);
        } else {
            i2 = 0;
        }
        TextView textView = (TextView) LayoutInflater.from(this.mContext).inflate(i.g.home_search_focusbar_item, (ViewGroup) null);
        int dimension = (i / 2) * ((int) getResources().getDimension(i.d.ds110));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) getResources().getDimension(i.d.ds321), (int) getResources().getDimension(i.d.ds96));
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = dimension;
        textView.setLayoutParams(layoutParams);
        textView.setText(str);
        textView.setOnClickListener(this);
        com.baidu.tbadk.core.util.an.i((View) textView, i.e.home_like_item_bg);
        com.baidu.tbadk.core.util.an.b(textView, i.c.cp_cont_b, 1);
        this.bUn.addView(textView);
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

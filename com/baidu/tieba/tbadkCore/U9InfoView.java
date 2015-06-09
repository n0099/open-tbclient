package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aDw;
    private TextView crA;
    private TextView crB;
    private TextView crC;
    private View crD;
    private TextView crE;
    private View crF;
    private ForegroundColorSpan crG;
    private ImageView crH;
    private RelativeLayout crx;
    private LinearLayout cry;
    private HeadImageView crz;
    private Context mContext;
    private com.baidu.tbadk.core.data.aa news_info;
    private com.baidu.tbadk.core.data.x top_code;

    public U9InfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public U9InfoView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public void initView() {
        com.baidu.adp.lib.g.b.hr().a(this.mContext, com.baidu.tieba.r.u9_info_layout, this, true);
        this.crx = (RelativeLayout) findViewById(com.baidu.tieba.q.u9_top_code);
        this.cry = (LinearLayout) findViewById(com.baidu.tieba.q.u9_news_info);
        this.crz = (HeadImageView) findViewById(com.baidu.tieba.q.top_code_img);
        this.crA = (TextView) findViewById(com.baidu.tieba.q.top_code_detail_summary_text);
        this.crB = (TextView) findViewById(com.baidu.tieba.q.top_code_detail_surplus_text);
        this.crC = (TextView) findViewById(com.baidu.tieba.q.top_code_getnum_btn);
        this.crD = findViewById(com.baidu.tieba.q.u9_top_code_divider);
        this.crH = (ImageView) findViewById(com.baidu.tieba.q.news_info_img);
        this.crH.setBackgroundDrawable(com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_frs_news));
        this.crE = (TextView) findViewById(com.baidu.tieba.q.news_info_text);
        this.crF = findViewById(com.baidu.tieba.q.u9_news_info_divider);
        this.crG = new ForegroundColorSpan(com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.cp_cont_c));
        this.aDw = new aw(this);
        aoi();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.crx.setVisibility(8);
            this.crD.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.crx.setVisibility(8);
            this.crD.setVisibility(8);
        } else {
            this.crx.setVisibility(0);
            this.crD.setVisibility(0);
            this.crz.c(this.top_code.rg(), 10, false);
            this.crA.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.rD()) || TextUtils.isEmpty(this.top_code.rD().trim())) {
                this.crB.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.t.u9_shengyu)) + this.top_code.rD());
                spannableString.setSpan(this.crG, 0, 2, 34);
                this.crB.setText(spannableString);
                this.crB.setVisibility(0);
            }
            if (this.top_code.rC() == 2) {
                this.crC.setText(this.mContext.getResources().getString(com.baidu.tieba.t.u9_taohao));
            } else {
                this.crC.setText(this.mContext.getResources().getString(com.baidu.tieba.t.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.cry.setVisibility(8);
            this.crF.setVisibility(8);
            return;
        }
        this.cry.setVisibility(0);
        this.crF.setVisibility(0);
        this.crE.setText(aaVar.getSummary());
    }

    public void aoi() {
        this.crx.setOnClickListener(this.aDw);
        this.cry.setOnClickListener(this.aDw);
    }

    public com.baidu.tbadk.core.data.x getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.x xVar) {
        this.top_code = xVar;
    }

    public com.baidu.tbadk.core.data.aa getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.aa aaVar) {
        this.news_info = aaVar;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.ay.i(this.crH, com.baidu.tieba.p.icon_frs_news);
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().j(this);
    }
}

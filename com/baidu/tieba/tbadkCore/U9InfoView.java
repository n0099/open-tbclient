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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aBz;
    private HeadImageView cnA;
    private TextView cnB;
    private TextView cnC;
    private TextView cnD;
    private View cnE;
    private TextView cnF;
    private View cnG;
    private ForegroundColorSpan cnH;
    private ImageView cnI;
    private RelativeLayout cny;
    private LinearLayout cnz;
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
        com.baidu.adp.lib.g.b.hH().a(this.mContext, com.baidu.tieba.w.u9_info_layout, this, true);
        this.cny = (RelativeLayout) findViewById(com.baidu.tieba.v.u9_top_code);
        this.cnz = (LinearLayout) findViewById(com.baidu.tieba.v.u9_news_info);
        this.cnA = (HeadImageView) findViewById(com.baidu.tieba.v.top_code_img);
        this.cnB = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_summary_text);
        this.cnC = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_surplus_text);
        this.cnD = (TextView) findViewById(com.baidu.tieba.v.top_code_getnum_btn);
        this.cnE = findViewById(com.baidu.tieba.v.u9_top_code_divider);
        this.cnI = (ImageView) findViewById(com.baidu.tieba.v.news_info_img);
        this.cnI.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.icon_frs_news));
        this.cnF = (TextView) findViewById(com.baidu.tieba.v.news_info_text);
        this.cnG = findViewById(com.baidu.tieba.v.u9_news_info_divider);
        this.cnH = new ForegroundColorSpan(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aBz = new aw(this);
        amv();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.cny.setVisibility(8);
            this.cnE.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cny.setVisibility(8);
            this.cnE.setVisibility(8);
        } else {
            this.cny.setVisibility(0);
            this.cnE.setVisibility(0);
            this.cnA.c(this.top_code.qA(), 10, false);
            this.cnB.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.qX()) || TextUtils.isEmpty(this.top_code.qX().trim())) {
                this.cnC.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.y.u9_shengyu)) + this.top_code.qX());
                spannableString.setSpan(this.cnH, 0, 2, 34);
                this.cnC.setText(spannableString);
                this.cnC.setVisibility(0);
            }
            if (this.top_code.qW() == 2) {
                this.cnD.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_taohao));
            } else {
                this.cnD.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.cnz.setVisibility(8);
            this.cnG.setVisibility(8);
            return;
        }
        this.cnz.setVisibility(0);
        this.cnG.setVisibility(0);
        this.cnF.setText(aaVar.getSummary());
    }

    public void amv() {
        this.cny.setOnClickListener(this.aBz);
        this.cnz.setOnClickListener(this.aBz);
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
        ba.i(this.cnI, com.baidu.tieba.u.icon_frs_news);
        tbPageContext.getLayoutMode().X(i == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}

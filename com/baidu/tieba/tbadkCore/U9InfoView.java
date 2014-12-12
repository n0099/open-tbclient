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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aYQ;
    private TextView bVA;
    private TextView bVB;
    private View bVC;
    private TextView bVD;
    private View bVE;
    private ForegroundColorSpan bVF;
    private ImageView bVG;
    private RelativeLayout bVw;
    private LinearLayout bVx;
    private HeadImageView bVy;
    private TextView bVz;
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
        com.baidu.adp.lib.g.b.ek().a(this.mContext, com.baidu.tieba.x.u9_info_layout, this, true);
        this.bVw = (RelativeLayout) findViewById(com.baidu.tieba.w.u9_top_code);
        this.bVx = (LinearLayout) findViewById(com.baidu.tieba.w.u9_news_info);
        this.bVy = (HeadImageView) findViewById(com.baidu.tieba.w.top_code_img);
        this.bVy.setSupportNoImage(false);
        this.bVz = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_summary_text);
        this.bVA = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_surplus_text);
        this.bVB = (TextView) findViewById(com.baidu.tieba.w.top_code_getnum_btn);
        this.bVC = findViewById(com.baidu.tieba.w.u9_top_code_divider);
        this.bVG = (ImageView) findViewById(com.baidu.tieba.w.news_info_img);
        this.bVG.setBackgroundDrawable(ax.getDrawable(com.baidu.tieba.v.icon_frs_news));
        this.bVD = (TextView) findViewById(com.baidu.tieba.w.news_info_text);
        this.bVE = findViewById(com.baidu.tieba.w.u9_news_info_divider);
        this.bVF = new ForegroundColorSpan(ax.getColor(com.baidu.tieba.t.cp_cont_c));
        this.aYQ = new at(this);
        agj();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.bVw.setVisibility(8);
            this.bVC.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.bVw.setVisibility(8);
            this.bVC.setVisibility(8);
        } else {
            this.bVw.setVisibility(0);
            this.bVC.setVisibility(0);
            this.bVy.d(this.top_code.mN(), 10, false);
            this.bVz.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.nN()) || TextUtils.isEmpty(this.top_code.nN().trim())) {
                this.bVA.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.z.u9_shengyu)) + this.top_code.nN());
                spannableString.setSpan(this.bVF, 0, 2, 34);
                this.bVA.setText(spannableString);
                this.bVA.setVisibility(0);
            }
            if (this.top_code.nM() == 2) {
                this.bVB.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_taohao));
            } else {
                this.bVB.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.bVx.setVisibility(8);
            this.bVE.setVisibility(8);
            return;
        }
        this.bVx.setVisibility(0);
        this.bVE.setVisibility(0);
        this.bVD.setText(aaVar.getSummary());
    }

    public void agj() {
        this.bVw.setOnClickListener(this.aYQ);
        this.bVx.setOnClickListener(this.aYQ);
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
        ax.i(this.bVG, com.baidu.tieba.v.icon_frs_news);
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}

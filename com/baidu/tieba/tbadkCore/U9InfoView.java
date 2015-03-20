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
    private View.OnClickListener aBr;
    private RelativeLayout cni;
    private LinearLayout cnj;
    private HeadImageView cnk;
    private TextView cnl;
    private TextView cnm;
    private TextView cnn;
    private View cno;
    private TextView cnp;
    private View cnq;
    private ForegroundColorSpan cnr;
    private ImageView cns;
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
        this.cni = (RelativeLayout) findViewById(com.baidu.tieba.v.u9_top_code);
        this.cnj = (LinearLayout) findViewById(com.baidu.tieba.v.u9_news_info);
        this.cnk = (HeadImageView) findViewById(com.baidu.tieba.v.top_code_img);
        this.cnl = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_summary_text);
        this.cnm = (TextView) findViewById(com.baidu.tieba.v.top_code_detail_surplus_text);
        this.cnn = (TextView) findViewById(com.baidu.tieba.v.top_code_getnum_btn);
        this.cno = findViewById(com.baidu.tieba.v.u9_top_code_divider);
        this.cns = (ImageView) findViewById(com.baidu.tieba.v.news_info_img);
        this.cns.setBackgroundDrawable(ba.getDrawable(com.baidu.tieba.u.icon_frs_news));
        this.cnp = (TextView) findViewById(com.baidu.tieba.v.news_info_text);
        this.cnq = findViewById(com.baidu.tieba.v.u9_news_info_divider);
        this.cnr = new ForegroundColorSpan(ba.getColor(com.baidu.tieba.s.cp_cont_c));
        this.aBr = new aw(this);
        amg();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.cni.setVisibility(8);
            this.cno.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cni.setVisibility(8);
            this.cno.setVisibility(8);
        } else {
            this.cni.setVisibility(0);
            this.cno.setVisibility(0);
            this.cnk.c(this.top_code.qA(), 10, false);
            this.cnl.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.qX()) || TextUtils.isEmpty(this.top_code.qX().trim())) {
                this.cnm.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.y.u9_shengyu)) + this.top_code.qX());
                spannableString.setSpan(this.cnr, 0, 2, 34);
                this.cnm.setText(spannableString);
                this.cnm.setVisibility(0);
            }
            if (this.top_code.qW() == 2) {
                this.cnn.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_taohao));
            } else {
                this.cnn.setText(this.mContext.getResources().getString(com.baidu.tieba.y.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.cnj.setVisibility(8);
            this.cnq.setVisibility(8);
            return;
        }
        this.cnj.setVisibility(0);
        this.cnq.setVisibility(0);
        this.cnp.setText(aaVar.getSummary());
    }

    public void amg() {
        this.cni.setOnClickListener(this.aBr);
        this.cnj.setOnClickListener(this.aBr);
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
        ba.i(this.cns, com.baidu.tieba.u.icon_frs_news);
        tbPageContext.getLayoutMode().X(i == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}

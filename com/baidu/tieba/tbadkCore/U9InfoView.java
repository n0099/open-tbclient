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
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private RelativeLayout bXo;
    private LinearLayout bXp;
    private HeadImageView bXq;
    private TextView bXr;
    private TextView bXs;
    private TextView bXt;
    private View bXu;
    private TextView bXv;
    private View bXw;
    private ForegroundColorSpan bXx;
    private ImageView bXy;
    private View.OnClickListener bam;
    private Context mContext;
    private com.baidu.tbadk.core.data.ab news_info;
    private com.baidu.tbadk.core.data.y top_code;

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
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.u9_info_layout, this, true);
        this.bXo = (RelativeLayout) findViewById(com.baidu.tieba.w.u9_top_code);
        this.bXp = (LinearLayout) findViewById(com.baidu.tieba.w.u9_news_info);
        this.bXq = (HeadImageView) findViewById(com.baidu.tieba.w.top_code_img);
        this.bXq.setSupportNoImage(false);
        this.bXr = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_summary_text);
        this.bXs = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_surplus_text);
        this.bXt = (TextView) findViewById(com.baidu.tieba.w.top_code_getnum_btn);
        this.bXu = findViewById(com.baidu.tieba.w.u9_top_code_divider);
        this.bXy = (ImageView) findViewById(com.baidu.tieba.w.news_info_img);
        this.bXy.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.icon_frs_news));
        this.bXv = (TextView) findViewById(com.baidu.tieba.w.news_info_text);
        this.bXw = findViewById(com.baidu.tieba.w.u9_news_info_divider);
        this.bXx = new ForegroundColorSpan(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        this.bam = new at(this);
        agO();
    }

    public void a(com.baidu.tbadk.core.data.y yVar, com.baidu.tbadk.core.data.ab abVar) {
        this.top_code = yVar;
        this.news_info = abVar;
        if (this.top_code == null) {
            this.bXo.setVisibility(8);
            this.bXu.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.bXo.setVisibility(8);
            this.bXu.setVisibility(8);
        } else {
            this.bXo.setVisibility(0);
            this.bXu.setVisibility(0);
            this.bXq.d(this.top_code.mP(), 10, false);
            this.bXr.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.nQ()) || TextUtils.isEmpty(this.top_code.nQ().trim())) {
                this.bXs.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.z.u9_shengyu)) + this.top_code.nQ());
                spannableString.setSpan(this.bXx, 0, 2, 34);
                this.bXs.setText(spannableString);
                this.bXs.setVisibility(0);
            }
            if (this.top_code.nP() == 2) {
                this.bXt.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_taohao));
            } else {
                this.bXt.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(abVar.getSummary())) {
            this.bXp.setVisibility(8);
            this.bXw.setVisibility(8);
            return;
        }
        this.bXp.setVisibility(0);
        this.bXw.setVisibility(0);
        this.bXv.setText(abVar.getSummary());
    }

    public void agO() {
        this.bXo.setOnClickListener(this.bam);
        this.bXp.setOnClickListener(this.bam);
    }

    public com.baidu.tbadk.core.data.y getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.y yVar) {
        this.top_code = yVar;
    }

    public com.baidu.tbadk.core.data.ab getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.ab abVar) {
        this.news_info = abVar;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        bc.i(this.bXy, com.baidu.tieba.v.icon_frs_news);
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}

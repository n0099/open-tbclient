package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aLg;
    private HeadImageView cQA;
    private TextView cQB;
    private TextView cQC;
    private TextView cQD;
    private View cQE;
    private TextView cQF;
    private ForegroundColorSpan cQG;
    private ImageView cQH;
    private RelativeLayout cQy;
    private LinearLayout cQz;
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
        LayoutInflater.from(this.mContext).inflate(i.g.u9_info_layout, (ViewGroup) this, true);
        this.cQy = (RelativeLayout) findViewById(i.f.u9_top_code);
        this.cQz = (LinearLayout) findViewById(i.f.u9_news_info);
        this.cQA = (HeadImageView) findViewById(i.f.top_code_img);
        this.cQB = (TextView) findViewById(i.f.top_code_detail_summary_text);
        this.cQC = (TextView) findViewById(i.f.top_code_detail_surplus_text);
        this.cQD = (TextView) findViewById(i.f.top_code_getnum_btn);
        this.cQE = findViewById(i.f.u9_top_code_divider);
        this.cQH = (ImageView) findViewById(i.f.news_info_img);
        this.cQH.setBackgroundDrawable(al.getDrawable(i.e.icon_frs_news));
        this.cQF = (TextView) findViewById(i.f.news_info_text);
        this.cQG = new ForegroundColorSpan(al.getColor(i.c.cp_cont_c));
        this.aLg = new ai(this);
        atO();
    }

    public void a(com.baidu.tbadk.core.data.y yVar, com.baidu.tbadk.core.data.ab abVar) {
        this.top_code = yVar;
        this.news_info = abVar;
        if (this.top_code == null) {
            this.cQy.setVisibility(8);
            this.cQE.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cQy.setVisibility(8);
            this.cQE.setVisibility(8);
        } else {
            this.cQy.setVisibility(0);
            this.cQE.setVisibility(0);
            this.cQA.d(this.top_code.sk(), 10, false);
            this.cQB.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.sM()) || TextUtils.isEmpty(this.top_code.sM().trim())) {
                this.cQC.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(i.h.u9_shengyu)) + this.top_code.sM());
                spannableString.setSpan(this.cQG, 0, 2, 34);
                this.cQC.setText(spannableString);
                this.cQC.setVisibility(0);
            }
            if (this.top_code.sL() == 2) {
                this.cQD.setText(this.mContext.getResources().getString(i.h.u9_taohao));
            } else {
                this.cQD.setText(this.mContext.getResources().getString(i.h.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(abVar.getSummary())) {
            this.cQz.setVisibility(8);
            return;
        }
        this.cQz.setVisibility(0);
        this.cQF.setText(abVar.getSummary());
    }

    public void atO() {
        this.cQy.setOnClickListener(this.aLg);
        this.cQz.setOnClickListener(this.aLg);
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

    public View getTopCodeView() {
        return this.cQy;
    }

    public View getTopCodeViewDivider() {
        return this.cQE;
    }

    public View getNewsInfoView() {
        return this.cQz;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        al.h(this.cQH, i.e.icon_frs_news);
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

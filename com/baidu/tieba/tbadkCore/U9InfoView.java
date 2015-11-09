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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aJd;
    private RelativeLayout cZM;
    private LinearLayout cZN;
    private HeadImageView cZO;
    private TextView cZP;
    private TextView cZQ;
    private TextView cZR;
    private View cZS;
    private TextView cZT;
    private ForegroundColorSpan cZU;
    private ImageView cZV;
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
        LayoutInflater.from(this.mContext).inflate(i.g.u9_info_layout, (ViewGroup) this, true);
        this.cZM = (RelativeLayout) findViewById(i.f.u9_top_code);
        this.cZN = (LinearLayout) findViewById(i.f.u9_news_info);
        this.cZO = (HeadImageView) findViewById(i.f.top_code_img);
        this.cZP = (TextView) findViewById(i.f.top_code_detail_summary_text);
        this.cZQ = (TextView) findViewById(i.f.top_code_detail_surplus_text);
        this.cZR = (TextView) findViewById(i.f.top_code_getnum_btn);
        this.cZS = findViewById(i.f.u9_top_code_divider);
        this.cZV = (ImageView) findViewById(i.f.news_info_img);
        this.cZV.setBackgroundDrawable(an.getDrawable(i.e.icon_frs_news));
        this.cZT = (TextView) findViewById(i.f.news_info_text);
        this.cZU = new ForegroundColorSpan(an.getColor(i.c.cp_cont_c));
        this.aJd = new ah(this);
        awO();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.cZM.setVisibility(8);
            this.cZS.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cZM.setVisibility(8);
            this.cZS.setVisibility(8);
        } else {
            this.cZM.setVisibility(0);
            this.cZS.setVisibility(0);
            this.cZO.d(this.top_code.se(), 10, false);
            this.cZP.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.sJ()) || TextUtils.isEmpty(this.top_code.sJ().trim())) {
                this.cZQ.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(i.h.u9_shengyu)) + this.top_code.sJ());
                spannableString.setSpan(this.cZU, 0, 2, 34);
                this.cZQ.setText(spannableString);
                this.cZQ.setVisibility(0);
            }
            if (this.top_code.sI() == 2) {
                this.cZR.setText(this.mContext.getResources().getString(i.h.u9_taohao));
            } else {
                this.cZR.setText(this.mContext.getResources().getString(i.h.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.cZN.setVisibility(8);
            return;
        }
        this.cZN.setVisibility(0);
        this.cZT.setText(aaVar.getSummary());
    }

    public void awO() {
        this.cZM.setOnClickListener(this.aJd);
        this.cZN.setOnClickListener(this.aJd);
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

    public View getTopCodeView() {
        return this.cZM;
    }

    public View getTopCodeViewDivider() {
        return this.cZS;
    }

    public View getNewsInfoView() {
        return this.cZN;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        an.i(this.cZV, i.e.icon_frs_news);
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

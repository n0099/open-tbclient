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
    private View.OnClickListener aKj;
    private RelativeLayout cYp;
    private LinearLayout cYq;
    private HeadImageView cYr;
    private TextView cYs;
    private TextView cYt;
    private TextView cYu;
    private View cYv;
    private TextView cYw;
    private ForegroundColorSpan cYx;
    private ImageView cYy;
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
        this.cYp = (RelativeLayout) findViewById(i.f.u9_top_code);
        this.cYq = (LinearLayout) findViewById(i.f.u9_news_info);
        this.cYr = (HeadImageView) findViewById(i.f.top_code_img);
        this.cYs = (TextView) findViewById(i.f.top_code_detail_summary_text);
        this.cYt = (TextView) findViewById(i.f.top_code_detail_surplus_text);
        this.cYu = (TextView) findViewById(i.f.top_code_getnum_btn);
        this.cYv = findViewById(i.f.u9_top_code_divider);
        this.cYy = (ImageView) findViewById(i.f.news_info_img);
        this.cYy.setBackgroundDrawable(an.getDrawable(i.e.icon_frs_news));
        this.cYw = (TextView) findViewById(i.f.news_info_text);
        this.cYx = new ForegroundColorSpan(an.getColor(i.c.cp_cont_c));
        this.aKj = new ah(this);
        awk();
    }

    public void a(com.baidu.tbadk.core.data.x xVar, com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = xVar;
        this.news_info = aaVar;
        if (this.top_code == null) {
            this.cYp.setVisibility(8);
            this.cYv.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cYp.setVisibility(8);
            this.cYv.setVisibility(8);
        } else {
            this.cYp.setVisibility(0);
            this.cYv.setVisibility(0);
            this.cYr.d(this.top_code.sf(), 10, false);
            this.cYs.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.sJ()) || TextUtils.isEmpty(this.top_code.sJ().trim())) {
                this.cYt.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(i.h.u9_shengyu)) + this.top_code.sJ());
                spannableString.setSpan(this.cYx, 0, 2, 34);
                this.cYt.setText(spannableString);
                this.cYt.setVisibility(0);
            }
            if (this.top_code.sI() == 2) {
                this.cYu.setText(this.mContext.getResources().getString(i.h.u9_taohao));
            } else {
                this.cYu.setText(this.mContext.getResources().getString(i.h.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(aaVar.getSummary())) {
            this.cYq.setVisibility(8);
            return;
        }
        this.cYq.setVisibility(0);
        this.cYw.setText(aaVar.getSummary());
    }

    public void awk() {
        this.cYp.setOnClickListener(this.aKj);
        this.cYq.setOnClickListener(this.aKj);
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
        return this.cYp;
    }

    public View getTopCodeViewDivider() {
        return this.cYv;
    }

    public View getNewsInfoView() {
        return this.cYq;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        an.i(this.cYy, i.e.icon_frs_news);
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

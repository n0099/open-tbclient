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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aJY;
    private RelativeLayout cXP;
    private LinearLayout cXQ;
    private HeadImageView cXR;
    private TextView cXS;
    private TextView cXT;
    private TextView cXU;
    private View cXV;
    private TextView cXW;
    private ForegroundColorSpan cXX;
    private ImageView cXY;
    private Context mContext;
    private com.baidu.tbadk.core.data.z news_info;
    private com.baidu.tbadk.core.data.w top_code;

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
        this.cXP = (RelativeLayout) findViewById(i.f.u9_top_code);
        this.cXQ = (LinearLayout) findViewById(i.f.u9_news_info);
        this.cXR = (HeadImageView) findViewById(i.f.top_code_img);
        this.cXS = (TextView) findViewById(i.f.top_code_detail_summary_text);
        this.cXT = (TextView) findViewById(i.f.top_code_detail_surplus_text);
        this.cXU = (TextView) findViewById(i.f.top_code_getnum_btn);
        this.cXV = findViewById(i.f.u9_top_code_divider);
        this.cXY = (ImageView) findViewById(i.f.news_info_img);
        this.cXY.setBackgroundDrawable(am.getDrawable(i.e.icon_frs_news));
        this.cXW = (TextView) findViewById(i.f.news_info_text);
        this.cXX = new ForegroundColorSpan(am.getColor(i.c.cp_cont_c));
        this.aJY = new ah(this);
        awc();
    }

    public void a(com.baidu.tbadk.core.data.w wVar, com.baidu.tbadk.core.data.z zVar) {
        this.top_code = wVar;
        this.news_info = zVar;
        if (this.top_code == null) {
            this.cXP.setVisibility(8);
            this.cXV.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cXP.setVisibility(8);
            this.cXV.setVisibility(8);
        } else {
            this.cXP.setVisibility(0);
            this.cXV.setVisibility(0);
            this.cXR.d(this.top_code.sf(), 10, false);
            this.cXS.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.sJ()) || TextUtils.isEmpty(this.top_code.sJ().trim())) {
                this.cXT.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(i.h.u9_shengyu)) + this.top_code.sJ());
                spannableString.setSpan(this.cXX, 0, 2, 34);
                this.cXT.setText(spannableString);
                this.cXT.setVisibility(0);
            }
            if (this.top_code.sI() == 2) {
                this.cXU.setText(this.mContext.getResources().getString(i.h.u9_taohao));
            } else {
                this.cXU.setText(this.mContext.getResources().getString(i.h.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(zVar.getSummary())) {
            this.cXQ.setVisibility(8);
            return;
        }
        this.cXQ.setVisibility(0);
        this.cXW.setText(zVar.getSummary());
    }

    public void awc() {
        this.cXP.setOnClickListener(this.aJY);
        this.cXQ.setOnClickListener(this.aJY);
    }

    public com.baidu.tbadk.core.data.w getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.w wVar) {
        this.top_code = wVar;
    }

    public com.baidu.tbadk.core.data.z getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.z zVar) {
        this.news_info = zVar;
    }

    public View getTopCodeView() {
        return this.cXP;
    }

    public View getTopCodeViewDivider() {
        return this.cXV;
    }

    public View getNewsInfoView() {
        return this.cXQ;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        am.i(this.cXY, i.e.icon_frs_news);
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

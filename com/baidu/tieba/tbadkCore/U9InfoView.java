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
    private View.OnClickListener aKT;
    private RelativeLayout cHY;
    private LinearLayout cHZ;
    private HeadImageView cIa;
    private TextView cIb;
    private TextView cIc;
    private TextView cId;
    private View cIe;
    private TextView cIf;
    private ForegroundColorSpan cIg;
    private ImageView cIh;
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
        this.cHY = (RelativeLayout) findViewById(i.f.u9_top_code);
        this.cHZ = (LinearLayout) findViewById(i.f.u9_news_info);
        this.cIa = (HeadImageView) findViewById(i.f.top_code_img);
        this.cIb = (TextView) findViewById(i.f.top_code_detail_summary_text);
        this.cIc = (TextView) findViewById(i.f.top_code_detail_surplus_text);
        this.cId = (TextView) findViewById(i.f.top_code_getnum_btn);
        this.cIe = findViewById(i.f.u9_top_code_divider);
        this.cIh = (ImageView) findViewById(i.f.news_info_img);
        this.cIh.setBackgroundDrawable(al.getDrawable(i.e.icon_frs_news));
        this.cIf = (TextView) findViewById(i.f.news_info_text);
        this.cIg = new ForegroundColorSpan(al.getColor(i.c.cp_cont_c));
        this.aKT = new ah(this);
        apB();
    }

    public void a(com.baidu.tbadk.core.data.w wVar, com.baidu.tbadk.core.data.z zVar) {
        this.top_code = wVar;
        this.news_info = zVar;
        if (this.top_code == null) {
            this.cHY.setVisibility(8);
            this.cIe.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.cHY.setVisibility(8);
            this.cIe.setVisibility(8);
        } else {
            this.cHY.setVisibility(0);
            this.cIe.setVisibility(0);
            this.cIa.d(this.top_code.sj(), 10, false);
            this.cIb.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.sH()) || TextUtils.isEmpty(this.top_code.sH().trim())) {
                this.cIc.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(i.C0057i.u9_shengyu)) + this.top_code.sH());
                spannableString.setSpan(this.cIg, 0, 2, 34);
                this.cIc.setText(spannableString);
                this.cIc.setVisibility(0);
            }
            if (this.top_code.sG() == 2) {
                this.cId.setText(this.mContext.getResources().getString(i.C0057i.u9_taohao));
            } else {
                this.cId.setText(this.mContext.getResources().getString(i.C0057i.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(zVar.getSummary())) {
            this.cHZ.setVisibility(8);
            return;
        }
        this.cHZ.setVisibility(0);
        this.cIf.setText(zVar.getSummary());
    }

    public void apB() {
        this.cHY.setOnClickListener(this.aKT);
        this.cHZ.setOnClickListener(this.aKT);
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
        return this.cHY;
    }

    public View getTopCodeViewDivider() {
        return this.cIe;
    }

    public View getNewsInfoView() {
        return this.cHZ;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        al.i(this.cIh, i.e.icon_frs_news);
        tbPageContext.getLayoutMode().ad(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

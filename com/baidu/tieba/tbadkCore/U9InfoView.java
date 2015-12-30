package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aRw;
    private RelativeLayout dFU;
    private LinearLayout dFV;
    private HeadImageView dFW;
    private TextView dFX;
    private TextView dFY;
    private TextView dFZ;
    private TextView dGa;
    private View dGb;
    private TextView dGc;
    private ImageView dGd;
    private Context mContext;
    private com.baidu.tbadk.core.data.ad news_info;
    private com.baidu.tbadk.core.data.aa top_code;

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
        LayoutInflater.from(this.mContext).inflate(n.h.u9_info_layout, (ViewGroup) this, true);
        this.dFU = (RelativeLayout) findViewById(n.g.u9_top_code);
        this.dFV = (LinearLayout) findViewById(n.g.u9_news_info);
        this.dFW = (HeadImageView) findViewById(n.g.top_code_img);
        this.dFX = (TextView) findViewById(n.g.top_code_detail_summary_text);
        this.dFY = (TextView) findViewById(n.g.top_code_detail_surplus_text);
        this.dFZ = (TextView) findViewById(n.g.top_code_detail_giftworth_text);
        this.dGa = (TextView) findViewById(n.g.top_code_getnum_btn);
        this.dGb = findViewById(n.g.u9_top_code_divider);
        this.dGd = (ImageView) findViewById(n.g.news_info_img);
        this.dGd.setBackgroundDrawable(as.getDrawable(n.f.icon_frs_news));
        this.dGc = (TextView) findViewById(n.g.news_info_text);
        this.aRw = new ai(this);
        aEH();
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar, com.baidu.tbadk.core.data.ad adVar) {
        this.top_code = aaVar;
        this.news_info = adVar;
        if (this.top_code == null) {
            this.dFU.setVisibility(8);
            this.dGb.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dFU.setVisibility(8);
            this.dGb.setVisibility(8);
        } else {
            this.dFU.setVisibility(0);
            this.dGb.setVisibility(0);
            this.dFW.d(this.top_code.sk(), 10, false);
            this.dFX.setText(this.top_code.getSummary());
            if (StringUtils.isNull(aaVar.sW())) {
                this.dGa.setVisibility(8);
            } else {
                this.dGa.setText(aaVar.sW());
                this.dGa.setVisibility(0);
            }
            int sT = this.top_code.sT();
            if (sT == 1 || sT == 2) {
                if (StringUtils.isNull(this.top_code.sU())) {
                    this.dFY.setVisibility(8);
                } else {
                    String str = String.valueOf(this.mContext.getResources().getString(n.j.u9_shengyu)) + this.top_code.sU();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.sU(), new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
                    this.dFY.setText(spannableString);
                    this.dFY.setVisibility(0);
                }
                if (aaVar.sV() <= 0) {
                    this.dFZ.setVisibility(8);
                } else {
                    String str2 = String.valueOf(this.mContext.getResources().getString(n.j.u9_worth)) + this.top_code.sV();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.sV()), new ForegroundColorSpan(as.getColor(n.d.cp_link_tip_d)));
                    this.dFZ.setText(spannableString2);
                    this.dFZ.setVisibility(0);
                }
            } else {
                this.dFZ.setVisibility(8);
                this.dFY.setText(aaVar.sX());
                this.dFY.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(adVar.getSummary())) {
            this.dFV.setVisibility(8);
            return;
        }
        this.dFV.setVisibility(0);
        this.dGc.setText(adVar.getSummary());
    }

    public void aEH() {
        this.dFU.setOnClickListener(this.aRw);
        this.dFV.setOnClickListener(this.aRw);
    }

    public com.baidu.tbadk.core.data.aa getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.aa aaVar) {
        this.top_code = aaVar;
    }

    public com.baidu.tbadk.core.data.ad getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.ad adVar) {
        this.news_info = adVar;
    }

    public View getTopCodeView() {
        return this.dFU;
    }

    public View getTopCodeViewDivider() {
        return this.dGb;
    }

    public View getNewsInfoView() {
        return this.dFV;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        as.i(this.dGd, n.f.icon_frs_news);
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

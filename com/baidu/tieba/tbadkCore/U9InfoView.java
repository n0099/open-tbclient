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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aTD;
    private RelativeLayout dVP;
    private LinearLayout dVQ;
    private HeadImageView dVR;
    private TextView dVS;
    private TextView dVT;
    private TextView dVU;
    private TextView dVV;
    private View dVW;
    private TextView dVX;
    private ImageView dVY;
    private Context mContext;
    private al news_info;
    private com.baidu.tbadk.core.data.ai top_code;

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
        LayoutInflater.from(this.mContext).inflate(t.h.u9_info_layout, (ViewGroup) this, true);
        this.dVP = (RelativeLayout) findViewById(t.g.u9_top_code);
        this.dVQ = (LinearLayout) findViewById(t.g.u9_news_info);
        this.dVR = (HeadImageView) findViewById(t.g.top_code_img);
        this.dVS = (TextView) findViewById(t.g.top_code_detail_summary_text);
        this.dVT = (TextView) findViewById(t.g.top_code_detail_surplus_text);
        this.dVU = (TextView) findViewById(t.g.top_code_detail_giftworth_text);
        this.dVV = (TextView) findViewById(t.g.top_code_getnum_btn);
        this.dVW = findViewById(t.g.u9_top_code_divider);
        this.dVY = (ImageView) findViewById(t.g.news_info_img);
        this.dVY.setBackgroundDrawable(ar.getDrawable(t.f.icon_frs_news));
        this.dVX = (TextView) findViewById(t.g.news_info_text);
        this.aTD = new ah(this);
        aLN();
    }

    public void a(com.baidu.tbadk.core.data.ai aiVar, al alVar) {
        this.top_code = aiVar;
        this.news_info = alVar;
        if (this.top_code == null) {
            this.dVP.setVisibility(8);
            this.dVW.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dVP.setVisibility(8);
            this.dVW.setVisibility(8);
        } else {
            this.dVP.setVisibility(0);
            this.dVW.setVisibility(0);
            this.dVR.d(this.top_code.sV(), 10, false);
            this.dVS.setText(this.top_code.getSummary());
            if (StringUtils.isNull(aiVar.tU())) {
                this.dVV.setVisibility(8);
            } else {
                this.dVV.setText(aiVar.tU());
                this.dVV.setVisibility(0);
            }
            int tR = this.top_code.tR();
            if (tR == 1 || tR == 2) {
                if (StringUtils.isNull(this.top_code.tS())) {
                    this.dVT.setVisibility(8);
                } else {
                    String str = String.valueOf(this.mContext.getResources().getString(t.j.u9_shengyu)) + this.top_code.tS();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tS(), new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
                    this.dVT.setText(spannableString);
                    this.dVT.setVisibility(0);
                }
                if (aiVar.tT() <= 0) {
                    this.dVU.setVisibility(8);
                } else {
                    String str2 = String.valueOf(this.mContext.getResources().getString(t.j.u9_worth)) + this.top_code.tT();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tT()), new ForegroundColorSpan(ar.getColor(t.d.cp_link_tip_d)));
                    this.dVU.setText(spannableString2);
                    this.dVU.setVisibility(0);
                }
            } else {
                this.dVU.setVisibility(8);
                this.dVT.setText(aiVar.tV());
                this.dVT.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(alVar.getSummary())) {
            this.dVQ.setVisibility(8);
            return;
        }
        this.dVQ.setVisibility(0);
        this.dVX.setText(alVar.getSummary());
    }

    public void aLN() {
        this.dVP.setOnClickListener(this.aTD);
        this.dVQ.setOnClickListener(this.aTD);
    }

    public com.baidu.tbadk.core.data.ai getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.ai aiVar) {
        this.top_code = aiVar;
    }

    public al getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(al alVar) {
        this.news_info = alVar;
    }

    public View getTopCodeView() {
        return this.dVP;
    }

    public View getTopCodeViewDivider() {
        return this.dVW;
    }

    public View getNewsInfoView() {
        return this.dVQ;
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        ar.k(this.dVY, t.f.icon_frs_news);
        tbPageContext.getLayoutMode().ac(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }
}

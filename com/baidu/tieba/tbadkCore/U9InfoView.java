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
    private View.OnClickListener aNE;
    private RelativeLayout dyA;
    private LinearLayout dyB;
    private HeadImageView dyC;
    private TextView dyD;
    private TextView dyE;
    private TextView dyF;
    private TextView dyG;
    private View dyH;
    private TextView dyI;
    private ImageView dyJ;
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
        LayoutInflater.from(this.mContext).inflate(n.g.u9_info_layout, (ViewGroup) this, true);
        this.dyA = (RelativeLayout) findViewById(n.f.u9_top_code);
        this.dyB = (LinearLayout) findViewById(n.f.u9_news_info);
        this.dyC = (HeadImageView) findViewById(n.f.top_code_img);
        this.dyD = (TextView) findViewById(n.f.top_code_detail_summary_text);
        this.dyE = (TextView) findViewById(n.f.top_code_detail_surplus_text);
        this.dyF = (TextView) findViewById(n.f.top_code_detail_giftworth_text);
        this.dyG = (TextView) findViewById(n.f.top_code_getnum_btn);
        this.dyH = findViewById(n.f.u9_top_code_divider);
        this.dyJ = (ImageView) findViewById(n.f.news_info_img);
        this.dyJ.setBackgroundDrawable(as.getDrawable(n.e.icon_frs_news));
        this.dyI = (TextView) findViewById(n.f.news_info_text);
        this.aNE = new ai(this);
        aCA();
    }

    public void a(com.baidu.tbadk.core.data.aa aaVar, com.baidu.tbadk.core.data.ad adVar) {
        this.top_code = aaVar;
        this.news_info = adVar;
        if (this.top_code == null) {
            this.dyA.setVisibility(8);
            this.dyH.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dyA.setVisibility(8);
            this.dyH.setVisibility(8);
        } else {
            this.dyA.setVisibility(0);
            this.dyH.setVisibility(0);
            this.dyC.d(this.top_code.sB(), 10, false);
            this.dyD.setText(this.top_code.getSummary());
            if (StringUtils.isNull(aaVar.tm())) {
                this.dyG.setVisibility(8);
            } else {
                this.dyG.setText(aaVar.tm());
                this.dyG.setVisibility(0);
            }
            int tj = this.top_code.tj();
            if (tj == 1 || tj == 2) {
                if (StringUtils.isNull(this.top_code.tk())) {
                    this.dyE.setVisibility(8);
                } else {
                    String str = String.valueOf(this.mContext.getResources().getString(n.i.u9_shengyu)) + this.top_code.tk();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tk(), new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
                    this.dyE.setText(spannableString);
                    this.dyE.setVisibility(0);
                }
                if (aaVar.tl() <= 0) {
                    this.dyF.setVisibility(8);
                } else {
                    String str2 = String.valueOf(this.mContext.getResources().getString(n.i.u9_worth)) + this.top_code.tl();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tl()), new ForegroundColorSpan(as.getColor(n.c.cp_link_tip_d)));
                    this.dyF.setText(spannableString2);
                    this.dyF.setVisibility(0);
                }
            } else {
                this.dyF.setVisibility(8);
                this.dyE.setText(aaVar.tn());
                this.dyE.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(adVar.getSummary())) {
            this.dyB.setVisibility(8);
            return;
        }
        this.dyB.setVisibility(0);
        this.dyI.setText(adVar.getSummary());
    }

    public void aCA() {
        this.dyA.setOnClickListener(this.aNE);
        this.dyB.setOnClickListener(this.aNE);
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
        return this.dyA;
    }

    public View getTopCodeViewDivider() {
        return this.dyH;
    }

    public View getNewsInfoView() {
        return this.dyB;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        as.i(this.dyJ, n.e.icon_frs_news);
        tbPageContext.getLayoutMode().af(i == 1);
        tbPageContext.getLayoutMode().k(this);
    }
}

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener cgg;
    private RelativeLayout dCG;
    private LinearLayout dCH;
    private TbImageView dCI;
    private TextView dCJ;
    private TextView dCK;
    private TextView dCL;
    private TextView dCM;
    private View dCN;
    private TextView dCO;
    private ImageView dCP;
    private Context mContext;
    private bg news_info;
    private bd top_code;

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
        LayoutInflater.from(this.mContext).inflate(e.h.u9_info_layout, (ViewGroup) this, true);
        this.dCG = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dCH = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dCI = (TbImageView) findViewById(e.g.top_code_img);
        this.dCJ = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dCK = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dCL = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dCM = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dCN = findViewById(e.g.u9_top_code_divider);
        this.dCP = (ImageView) findViewById(e.g.news_info_img);
        this.dCP.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dCO = (TextView) findViewById(e.g.news_info_text);
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bA(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.lb()) {
                    if (view == U9InfoView.this.dCG) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.xT())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.xT()});
                        }
                    } else if (view == U9InfoView.this.dCH && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.ya())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, "page", "frs");
                        ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.ya()});
                    }
                }
            }
        };
        setOnClickListener();
    }

    public void setData(bd bdVar, bg bgVar) {
        this.top_code = bdVar;
        this.news_info = bgVar;
        if (this.top_code == null) {
            this.dCG.setVisibility(8);
            this.dCN.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dCG.setVisibility(8);
            this.dCN.setVisibility(8);
        } else {
            this.dCG.setVisibility(0);
            this.dCN.setVisibility(0);
            this.dCI.startLoad(this.top_code.uW(), 10, false);
            this.dCJ.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.xX())) {
                this.dCM.setVisibility(8);
            } else {
                this.dCM.setText(bdVar.xX());
                this.dCM.setVisibility(0);
            }
            int xU = this.top_code.xU();
            if (xU == 1 || xU == 2) {
                if (StringUtils.isNull(this.top_code.xV())) {
                    this.dCK.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.xV();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.xV(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dCK.setText(spannableString);
                    this.dCK.setVisibility(0);
                }
                if (bdVar.xW() <= 0) {
                    this.dCL.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.xW();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.xW()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dCL.setText(spannableString2);
                    this.dCL.setVisibility(0);
                }
            } else {
                this.dCL.setVisibility(8);
                this.dCK.setText(bdVar.getSubTitle());
                this.dCK.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dCH.setVisibility(8);
            return;
        }
        this.dCH.setVisibility(0);
        this.dCO.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dCG.setOnClickListener(this.cgg);
        this.dCH.setOnClickListener(this.cgg);
    }

    public bd getTopCode() {
        return this.top_code;
    }

    public void setTopCode(bd bdVar) {
        this.top_code = bdVar;
    }

    public bg getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(bg bgVar) {
        this.news_info = bgVar;
    }

    public View getTopCodeView() {
        return this.dCG;
    }

    public View getTopCodeViewDivider() {
        return this.dCN;
    }

    public View getNewsInfoView() {
        return this.dCH;
    }
}

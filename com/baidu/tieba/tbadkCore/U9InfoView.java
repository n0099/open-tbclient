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
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
    private View.OnClickListener coU;
    private RelativeLayout dLK;
    private LinearLayout dLL;
    private TbImageView dLM;
    private TextView dLN;
    private TextView dLO;
    private TextView dLP;
    private TextView dLQ;
    private View dLR;
    private TextView dLS;
    private ImageView dLT;
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
        this.dLK = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dLL = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dLM = (TbImageView) findViewById(e.g.top_code_img);
        this.dLN = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dLO = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dLP = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dLQ = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dLR = findViewById(e.g.u9_top_code_divider);
        this.dLT = (ImageView) findViewById(e.g.news_info_img);
        this.dLT.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dLS = (TextView) findViewById(e.g.news_info_text);
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bG(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.lm()) {
                    if (view == U9InfoView.this.dLK) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.Aj())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.Aj()});
                        }
                    } else if (view == U9InfoView.this.dLL && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.Aq())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.Aq()});
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
            this.dLK.setVisibility(8);
            this.dLR.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dLK.setVisibility(8);
            this.dLR.setVisibility(8);
        } else {
            this.dLK.setVisibility(0);
            this.dLR.setVisibility(0);
            this.dLM.startLoad(this.top_code.xn(), 10, false);
            this.dLN.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.An())) {
                this.dLQ.setVisibility(8);
            } else {
                this.dLQ.setText(bdVar.An());
                this.dLQ.setVisibility(0);
            }
            int Ak = this.top_code.Ak();
            if (Ak == 1 || Ak == 2) {
                if (StringUtils.isNull(this.top_code.Al())) {
                    this.dLO.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Al();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.Al(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dLO.setText(spannableString);
                    this.dLO.setVisibility(0);
                }
                if (bdVar.Am() <= 0) {
                    this.dLP.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Am();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Am()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dLP.setText(spannableString2);
                    this.dLP.setVisibility(0);
                }
            } else {
                this.dLP.setVisibility(8);
                this.dLO.setText(bdVar.getSubTitle());
                this.dLO.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dLL.setVisibility(8);
            return;
        }
        this.dLL.setVisibility(0);
        this.dLS.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dLK.setOnClickListener(this.coU);
        this.dLL.setOnClickListener(this.coU);
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
        return this.dLK;
    }

    public View getTopCodeViewDivider() {
        return this.dLR;
    }

    public View getNewsInfoView() {
        return this.dLL;
    }
}

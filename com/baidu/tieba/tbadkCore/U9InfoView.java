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
    private View.OnClickListener coI;
    private RelativeLayout dKG;
    private LinearLayout dKH;
    private TbImageView dKI;
    private TextView dKJ;
    private TextView dKK;
    private TextView dKL;
    private TextView dKM;
    private View dKN;
    private TextView dKO;
    private ImageView dKP;
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
        this.dKG = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dKH = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dKI = (TbImageView) findViewById(e.g.top_code_img);
        this.dKJ = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dKK = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dKL = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dKM = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dKN = findViewById(e.g.u9_top_code_divider);
        this.dKP = (ImageView) findViewById(e.g.news_info_img);
        this.dKP.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dKO = (TextView) findViewById(e.g.news_info_text);
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bI(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.lo()) {
                    if (view == U9InfoView.this.dKG) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.Ac())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.Ac()});
                        }
                    } else if (view == U9InfoView.this.dKH && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.Aj())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.Aj()});
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
            this.dKG.setVisibility(8);
            this.dKN.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dKG.setVisibility(8);
            this.dKN.setVisibility(8);
        } else {
            this.dKG.setVisibility(0);
            this.dKN.setVisibility(0);
            this.dKI.startLoad(this.top_code.xf(), 10, false);
            this.dKJ.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.Ag())) {
                this.dKM.setVisibility(8);
            } else {
                this.dKM.setText(bdVar.Ag());
                this.dKM.setVisibility(0);
            }
            int Ad = this.top_code.Ad();
            if (Ad == 1 || Ad == 2) {
                if (StringUtils.isNull(this.top_code.Ae())) {
                    this.dKK.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Ae();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.Ae(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dKK.setText(spannableString);
                    this.dKK.setVisibility(0);
                }
                if (bdVar.Af() <= 0) {
                    this.dKL.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Af();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Af()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dKL.setText(spannableString2);
                    this.dKL.setVisibility(0);
                }
            } else {
                this.dKL.setVisibility(8);
                this.dKK.setText(bdVar.getSubTitle());
                this.dKK.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dKH.setVisibility(8);
            return;
        }
        this.dKH.setVisibility(0);
        this.dKO.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dKG.setOnClickListener(this.coI);
        this.dKH.setOnClickListener(this.coI);
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
        return this.dKG;
    }

    public View getTopCodeViewDivider() {
        return this.dKN;
    }

    public View getNewsInfoView() {
        return this.dKH;
    }
}

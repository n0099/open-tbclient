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
    private View.OnClickListener cts;
    private RelativeLayout dVe;
    private LinearLayout dVf;
    private TbImageView dVg;
    private TextView dVh;
    private TextView dVi;
    private TextView dVj;
    private TextView dVk;
    private View dVl;
    private TextView dVm;
    private ImageView dVn;
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
        this.dVe = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dVf = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dVg = (TbImageView) findViewById(e.g.top_code_img);
        this.dVh = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dVi = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dVj = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dVk = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dVl = findViewById(e.g.u9_top_code_divider);
        this.dVn = (ImageView) findViewById(e.g.news_info_img);
        this.dVn.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dVm = (TextView) findViewById(e.g.news_info_text);
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.ll()) {
                    if (view == U9InfoView.this.dVe) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.Bn())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.Bn()});
                        }
                    } else if (view == U9InfoView.this.dVf && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.Bu())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.Bu()});
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
            this.dVe.setVisibility(8);
            this.dVl.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dVe.setVisibility(8);
            this.dVl.setVisibility(8);
        } else {
            this.dVe.setVisibility(0);
            this.dVl.setVisibility(0);
            this.dVg.startLoad(this.top_code.ys(), 10, false);
            this.dVh.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.Br())) {
                this.dVk.setVisibility(8);
            } else {
                this.dVk.setText(bdVar.Br());
                this.dVk.setVisibility(0);
            }
            int Bo = this.top_code.Bo();
            if (Bo == 1 || Bo == 2) {
                if (StringUtils.isNull(this.top_code.Bp())) {
                    this.dVi.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Bp();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.Bp(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dVi.setText(spannableString);
                    this.dVi.setVisibility(0);
                }
                if (bdVar.Bq() <= 0) {
                    this.dVj.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Bq();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Bq()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dVj.setText(spannableString2);
                    this.dVj.setVisibility(0);
                }
            } else {
                this.dVj.setVisibility(8);
                this.dVi.setText(bdVar.getSubTitle());
                this.dVi.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dVf.setVisibility(8);
            return;
        }
        this.dVf.setVisibility(0);
        this.dVm.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dVe.setOnClickListener(this.cts);
        this.dVf.setOnClickListener(this.cts);
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
        return this.dVe;
    }

    public View getTopCodeViewDivider() {
        return this.dVl;
    }

    public View getNewsInfoView() {
        return this.dVf;
    }
}

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
    private View.OnClickListener csN;
    private RelativeLayout dSn;
    private LinearLayout dSo;
    private TbImageView dSp;
    private TextView dSq;
    private TextView dSr;
    private TextView dSs;
    private TextView dSt;
    private View dSu;
    private TextView dSv;
    private ImageView dSw;
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
        this.dSn = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dSo = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dSp = (TbImageView) findViewById(e.g.top_code_img);
        this.dSq = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dSr = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dSs = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dSt = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dSu = findViewById(e.g.u9_top_code_divider);
        this.dSw = (ImageView) findViewById(e.g.news_info_img);
        this.dSw.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dSv = (TextView) findViewById(e.g.news_info_text);
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.ll()) {
                    if (view == U9InfoView.this.dSn) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.Bn())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.Bn()});
                        }
                    } else if (view == U9InfoView.this.dSo && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.Bu())) {
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
            this.dSn.setVisibility(8);
            this.dSu.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dSn.setVisibility(8);
            this.dSu.setVisibility(8);
        } else {
            this.dSn.setVisibility(0);
            this.dSu.setVisibility(0);
            this.dSp.startLoad(this.top_code.ys(), 10, false);
            this.dSq.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.Br())) {
                this.dSt.setVisibility(8);
            } else {
                this.dSt.setText(bdVar.Br());
                this.dSt.setVisibility(0);
            }
            int Bo = this.top_code.Bo();
            if (Bo == 1 || Bo == 2) {
                if (StringUtils.isNull(this.top_code.Bp())) {
                    this.dSr.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.Bp();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.Bp(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dSr.setText(spannableString);
                    this.dSr.setVisibility(0);
                }
                if (bdVar.Bq() <= 0) {
                    this.dSs.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.Bq();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.Bq()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dSs.setText(spannableString2);
                    this.dSs.setVisibility(0);
                }
            } else {
                this.dSs.setVisibility(8);
                this.dSr.setText(bdVar.getSubTitle());
                this.dSr.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dSo.setVisibility(8);
            return;
        }
        this.dSo.setVisibility(0);
        this.dSv.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dSn.setOnClickListener(this.csN);
        this.dSo.setOnClickListener(this.csN);
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
        return this.dSn;
    }

    public View getTopCodeViewDivider() {
        return this.dSu;
    }

    public View getNewsInfoView() {
        return this.dSo;
    }
}

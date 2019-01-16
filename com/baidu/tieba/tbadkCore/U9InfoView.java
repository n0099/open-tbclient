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
    private View.OnClickListener cud;
    private RelativeLayout dVK;
    private LinearLayout dVL;
    private TbImageView dVM;
    private TextView dVN;
    private TextView dVO;
    private TextView dVP;
    private TextView dVQ;
    private View dVR;
    private TextView dVS;
    private ImageView dVT;
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
        this.dVK = (RelativeLayout) findViewById(e.g.u9_top_code);
        this.dVL = (LinearLayout) findViewById(e.g.u9_news_info);
        this.dVM = (TbImageView) findViewById(e.g.top_code_img);
        this.dVN = (TextView) findViewById(e.g.top_code_detail_summary_text);
        this.dVO = (TextView) findViewById(e.g.top_code_detail_surplus_text);
        this.dVP = (TextView) findViewById(e.g.top_code_detail_giftworth_text);
        this.dVQ = (TextView) findViewById(e.g.top_code_getnum_btn);
        this.dVR = findViewById(e.g.u9_top_code_divider);
        this.dVT = (ImageView) findViewById(e.g.news_info_img);
        this.dVT.setBackgroundDrawable(al.getDrawable(e.f.icon_frs_news));
        this.dVS = (TextView) findViewById(e.g.news_info_text);
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.bJ(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.ll()) {
                    if (view == U9InfoView.this.dVK) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.BA())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                            ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.BA()});
                        }
                    } else if (view == U9InfoView.this.dVL && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.BH())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", AiAppsUBCStatistic.TYPE_CLICK, 1, SystemScreenshotManager.PAGE, "frs");
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.BH()});
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
            this.dVK.setVisibility(8);
            this.dVR.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dVK.setVisibility(8);
            this.dVR.setVisibility(8);
        } else {
            this.dVK.setVisibility(0);
            this.dVR.setVisibility(0);
            this.dVM.startLoad(this.top_code.yF(), 10, false);
            this.dVN.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.BE())) {
                this.dVQ.setVisibility(8);
            } else {
                this.dVQ.setText(bdVar.BE());
                this.dVQ.setVisibility(0);
            }
            int BB = this.top_code.BB();
            if (BB == 1 || BB == 2) {
                if (StringUtils.isNull(this.top_code.BC())) {
                    this.dVO.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(e.j.u9_shengyu) + this.top_code.BC();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.BC(), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dVO.setText(spannableString);
                    this.dVO.setVisibility(0);
                }
                if (bdVar.BD() <= 0) {
                    this.dVP.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(e.j.u9_worth) + this.top_code.BD();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.BD()), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_d)));
                    this.dVP.setText(spannableString2);
                    this.dVP.setVisibility(0);
                }
            } else {
                this.dVP.setVisibility(8);
                this.dVO.setText(bdVar.getSubTitle());
                this.dVO.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dVL.setVisibility(8);
            return;
        }
        this.dVL.setVisibility(0);
        this.dVS.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dVK.setOnClickListener(this.cud);
        this.dVL.setOnClickListener(this.cud);
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
        return this.dVK;
    }

    public View getTopCodeViewDivider() {
        return this.dVR;
    }

    public View getNewsInfoView() {
        return this.dVL;
    }
}

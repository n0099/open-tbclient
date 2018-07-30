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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener cas;
    private RelativeLayout dvZ;
    private LinearLayout dwa;
    private TbImageView dwb;
    private TextView dwc;
    private TextView dwd;
    private TextView dwe;
    private TextView dwf;
    private View dwg;
    private TextView dwh;
    private ImageView dwi;
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
        LayoutInflater.from(this.mContext).inflate(d.h.u9_info_layout, (ViewGroup) this, true);
        this.dvZ = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dwa = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dwb = (TbImageView) findViewById(d.g.top_code_img);
        this.dwc = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dwd = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dwe = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dwf = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dwg = findViewById(d.g.u9_top_code_divider);
        this.dwi = (ImageView) findViewById(d.g.news_info_img);
        this.dwi.setBackgroundDrawable(am.getDrawable(d.f.icon_frs_news));
        this.dwh = (TextView) findViewById(d.g.news_info_text);
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aV(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.jV()) {
                    if (view == U9InfoView.this.dvZ) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.wN())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.wN()});
                        }
                    } else if (view == U9InfoView.this.dwa && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.wU())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, "page", "frs");
                        ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.wU()});
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
            this.dvZ.setVisibility(8);
            this.dwg.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dvZ.setVisibility(8);
            this.dwg.setVisibility(8);
        } else {
            this.dvZ.setVisibility(0);
            this.dwg.setVisibility(0);
            this.dwb.startLoad(this.top_code.tU(), 10, false);
            this.dwc.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.wR())) {
                this.dwf.setVisibility(8);
            } else {
                this.dwf.setText(bdVar.wR());
                this.dwf.setVisibility(0);
            }
            int wO = this.top_code.wO();
            if (wO == 1 || wO == 2) {
                if (StringUtils.isNull(this.top_code.wP())) {
                    this.dwd.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.j.u9_shengyu) + this.top_code.wP();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.wP(), new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_d)));
                    this.dwd.setText(spannableString);
                    this.dwd.setVisibility(0);
                }
                if (bdVar.wQ() <= 0) {
                    this.dwe.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.j.u9_worth) + this.top_code.wQ();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wQ()), new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_d)));
                    this.dwe.setText(spannableString2);
                    this.dwe.setVisibility(0);
                }
            } else {
                this.dwe.setVisibility(8);
                this.dwd.setText(bdVar.getSubTitle());
                this.dwd.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dwa.setVisibility(8);
            return;
        }
        this.dwa.setVisibility(0);
        this.dwh.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dvZ.setOnClickListener(this.cas);
        this.dwa.setOnClickListener(this.cas);
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
        return this.dvZ;
    }

    public View getTopCodeViewDivider() {
        return this.dwg;
    }

    public View getNewsInfoView() {
        return this.dwa;
    }
}

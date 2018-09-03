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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener caq;
    private RelativeLayout dvW;
    private LinearLayout dvX;
    private TbImageView dvY;
    private TextView dvZ;
    private TextView dwa;
    private TextView dwb;
    private TextView dwc;
    private View dwd;
    private TextView dwe;
    private ImageView dwf;
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
        LayoutInflater.from(this.mContext).inflate(f.h.u9_info_layout, (ViewGroup) this, true);
        this.dvW = (RelativeLayout) findViewById(f.g.u9_top_code);
        this.dvX = (LinearLayout) findViewById(f.g.u9_news_info);
        this.dvY = (TbImageView) findViewById(f.g.top_code_img);
        this.dvZ = (TextView) findViewById(f.g.top_code_detail_summary_text);
        this.dwa = (TextView) findViewById(f.g.top_code_detail_surplus_text);
        this.dwb = (TextView) findViewById(f.g.top_code_detail_giftworth_text);
        this.dwc = (TextView) findViewById(f.g.top_code_getnum_btn);
        this.dwd = findViewById(f.g.u9_top_code_divider);
        this.dwf = (ImageView) findViewById(f.g.news_info_img);
        this.dwf.setBackgroundDrawable(am.getDrawable(f.C0146f.icon_frs_news));
        this.dwe = (TextView) findViewById(f.g.news_info_text);
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.jV()) {
                    if (view == U9InfoView.this.dvW) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.wM())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.wM()});
                        }
                    } else if (view == U9InfoView.this.dvX && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.wT())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, "page", "frs");
                        az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.wT()});
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
            this.dvW.setVisibility(8);
            this.dwd.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dvW.setVisibility(8);
            this.dwd.setVisibility(8);
        } else {
            this.dvW.setVisibility(0);
            this.dwd.setVisibility(0);
            this.dvY.startLoad(this.top_code.tT(), 10, false);
            this.dvZ.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bdVar.wQ())) {
                this.dwc.setVisibility(8);
            } else {
                this.dwc.setText(bdVar.wQ());
                this.dwc.setVisibility(0);
            }
            int wN = this.top_code.wN();
            if (wN == 1 || wN == 2) {
                if (StringUtils.isNull(this.top_code.wO())) {
                    this.dwa.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(f.j.u9_shengyu) + this.top_code.wO();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.wO(), new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_d)));
                    this.dwa.setText(spannableString);
                    this.dwa.setVisibility(0);
                }
                if (bdVar.wP() <= 0) {
                    this.dwb.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(f.j.u9_worth) + this.top_code.wP();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wP()), new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_d)));
                    this.dwb.setText(spannableString2);
                    this.dwb.setVisibility(0);
                }
            } else {
                this.dwb.setVisibility(8);
                this.dwa.setText(bdVar.getSubTitle());
                this.dwa.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bgVar.getSummary())) {
            this.dvX.setVisibility(8);
            return;
        }
        this.dvX.setVisibility(0);
        this.dwe.setText(bgVar.getSummary());
    }

    public void setOnClickListener() {
        this.dvW.setOnClickListener(this.caq);
        this.dvX.setOnClickListener(this.caq);
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
        return this.dvW;
    }

    public View getTopCodeViewDivider() {
        return this.dwd;
    }

    public View getNewsInfoView() {
        return this.dvX;
    }
}

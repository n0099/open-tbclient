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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.aw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener aXp;
    private TextView eoA;
    private TextView eoB;
    private TextView eoC;
    private View eoD;
    private TextView eoE;
    private ImageView eoF;
    private RelativeLayout eow;
    private LinearLayout eox;
    private HeadImageView eoy;
    private TextView eoz;
    private Context mContext;
    private aw news_info;
    private at top_code;

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
        this.eow = (RelativeLayout) findViewById(t.g.u9_top_code);
        this.eox = (LinearLayout) findViewById(t.g.u9_news_info);
        this.eoy = (HeadImageView) findViewById(t.g.top_code_img);
        this.eoz = (TextView) findViewById(t.g.top_code_detail_summary_text);
        this.eoA = (TextView) findViewById(t.g.top_code_detail_surplus_text);
        this.eoB = (TextView) findViewById(t.g.top_code_detail_giftworth_text);
        this.eoC = (TextView) findViewById(t.g.top_code_getnum_btn);
        this.eoD = findViewById(t.g.u9_top_code_divider);
        this.eoF = (ImageView) findViewById(t.g.news_info_img);
        this.eoF.setBackgroundDrawable(com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_frs_news));
        this.eoE = (TextView) findViewById(t.g.news_info_text);
        this.aXp = new ai(this);
        aSH();
    }

    public void a(at atVar, aw awVar) {
        this.top_code = atVar;
        this.news_info = awVar;
        if (this.top_code == null) {
            this.eow.setVisibility(8);
            this.eoD.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.eow.setVisibility(8);
            this.eoD.setVisibility(8);
        } else {
            this.eow.setVisibility(0);
            this.eoD.setVisibility(0);
            this.eoy.c(this.top_code.sW(), 10, false);
            this.eoz.setText(this.top_code.getSummary());
            if (StringUtils.isNull(atVar.ub())) {
                this.eoC.setVisibility(8);
            } else {
                this.eoC.setText(atVar.ub());
                this.eoC.setVisibility(0);
            }
            int tY = this.top_code.tY();
            if (tY == 1 || tY == 2) {
                if (StringUtils.isNull(this.top_code.tZ())) {
                    this.eoA.setVisibility(8);
                } else {
                    String str = String.valueOf(this.mContext.getResources().getString(t.j.u9_shengyu)) + this.top_code.tZ();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tZ(), new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_d)));
                    this.eoA.setText(spannableString);
                    this.eoA.setVisibility(0);
                }
                if (atVar.ua() <= 0) {
                    this.eoB.setVisibility(8);
                } else {
                    String str2 = String.valueOf(this.mContext.getResources().getString(t.j.u9_worth)) + this.top_code.ua();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.ua()), new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_d)));
                    this.eoB.setText(spannableString2);
                    this.eoB.setVisibility(0);
                }
            } else {
                this.eoB.setVisibility(8);
                this.eoA.setText(atVar.getSubTitle());
                this.eoA.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(awVar.getSummary())) {
            this.eox.setVisibility(8);
            return;
        }
        this.eox.setVisibility(0);
        this.eoE.setText(awVar.getSummary());
    }

    public void aSH() {
        this.eow.setOnClickListener(this.aXp);
        this.eox.setOnClickListener(this.aXp);
    }

    public at getTopCode() {
        return this.top_code;
    }

    public void setTopCode(at atVar) {
        this.top_code = atVar;
    }

    public aw getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(aw awVar) {
        this.news_info = awVar;
    }

    public View getTopCodeView() {
        return this.eow;
    }

    public View getTopCodeViewDivider() {
        return this.eoD;
    }

    public View getNewsInfoView() {
        return this.eox;
    }

    public void e(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.core.util.at.k(this.eoF, t.f.icon_frs_news);
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().x(this);
    }
}

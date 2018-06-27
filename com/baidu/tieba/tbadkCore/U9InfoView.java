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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener bZi;
    private RelativeLayout dtm;
    private LinearLayout dtn;
    private TbImageView dto;
    private TextView dtp;
    private TextView dtq;
    private TextView dtr;
    private TextView dts;
    private View dtt;
    private TextView dtu;
    private ImageView dtv;
    private Context mContext;
    private bh news_info;
    private be top_code;

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
        LayoutInflater.from(this.mContext).inflate(d.i.u9_info_layout, (ViewGroup) this, true);
        this.dtm = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dtn = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dto = (TbImageView) findViewById(d.g.top_code_img);
        this.dtp = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dtq = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dtr = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dts = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dtt = findViewById(d.g.u9_top_code_divider);
        this.dtv = (ImageView) findViewById(d.g.news_info_img);
        this.dtv.setBackgroundDrawable(am.getDrawable(d.f.icon_frs_news));
        this.dtu = (TextView) findViewById(d.g.news_info_text);
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bb.aU(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.jU()) {
                    if (view == U9InfoView.this.dtm) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.wV())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.wV()});
                        }
                    } else if (view == U9InfoView.this.dtn && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.xc())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, "page", "frs");
                        az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.xc()});
                    }
                }
            }
        };
        setOnClickListener();
    }

    public void setData(be beVar, bh bhVar) {
        this.top_code = beVar;
        this.news_info = bhVar;
        if (this.top_code == null) {
            this.dtm.setVisibility(8);
            this.dtt.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dtm.setVisibility(8);
            this.dtt.setVisibility(8);
        } else {
            this.dtm.setVisibility(0);
            this.dtt.setVisibility(0);
            this.dto.startLoad(this.top_code.uh(), 10, false);
            this.dtp.setText(this.top_code.getSummary());
            if (StringUtils.isNull(beVar.wZ())) {
                this.dts.setVisibility(8);
            } else {
                this.dts.setText(beVar.wZ());
                this.dts.setVisibility(0);
            }
            int wW = this.top_code.wW();
            if (wW == 1 || wW == 2) {
                if (StringUtils.isNull(this.top_code.wX())) {
                    this.dtq.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.wX();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.wX(), new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_d)));
                    this.dtq.setText(spannableString);
                    this.dtq.setVisibility(0);
                }
                if (beVar.wY() <= 0) {
                    this.dtr.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.wY();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wY()), new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_d)));
                    this.dtr.setText(spannableString2);
                    this.dtr.setVisibility(0);
                }
            } else {
                this.dtr.setVisibility(8);
                this.dtq.setText(beVar.getSubTitle());
                this.dtq.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(bhVar.getSummary())) {
            this.dtn.setVisibility(8);
            return;
        }
        this.dtn.setVisibility(0);
        this.dtu.setText(bhVar.getSummary());
    }

    public void setOnClickListener() {
        this.dtm.setOnClickListener(this.bZi);
        this.dtn.setOnClickListener(this.bZi);
    }

    public be getTopCode() {
        return this.top_code;
    }

    public void setTopCode(be beVar) {
        this.top_code = beVar;
    }

    public bh getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(bh bhVar) {
        this.news_info = bhVar;
    }

    public View getTopCodeView() {
        return this.dtm;
    }

    public View getTopCodeViewDivider() {
        return this.dtt;
    }

    public View getNewsInfoView() {
        return this.dtn;
    }
}

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
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener bOY;
    private RelativeLayout dgO;
    private LinearLayout dgP;
    private TbImageView dgQ;
    private TextView dgR;
    private TextView dgS;
    private TextView dgT;
    private TextView dgU;
    private View dgV;
    private TextView dgW;
    private ImageView dgX;
    private Context mContext;
    private bi news_info;
    private bf top_code;

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
        this.dgO = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dgP = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dgQ = (TbImageView) findViewById(d.g.top_code_img);
        this.dgR = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dgS = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dgT = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dgU = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dgV = findViewById(d.g.u9_top_code_divider);
        this.dgX = (ImageView) findViewById(d.g.news_info_img);
        this.dgX.setBackgroundDrawable(ak.getDrawable(d.f.icon_frs_news));
        this.dgW = (TextView) findViewById(d.g.news_info_text);
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.hg()) {
                    if (view2 == U9InfoView.this.dgO) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.tj())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.tj()});
                        }
                    } else if (view2 == U9InfoView.this.dgP && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.tr())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.tr()});
                    }
                }
            }
        };
        setOnClickListener();
    }

    public void setData(bf bfVar, bi biVar) {
        this.top_code = bfVar;
        this.news_info = biVar;
        if (this.top_code == null) {
            this.dgO.setVisibility(8);
            this.dgV.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dgO.setVisibility(8);
            this.dgV.setVisibility(8);
        } else {
            this.dgO.setVisibility(0);
            this.dgV.setVisibility(0);
            this.dgQ.startLoad(this.top_code.qF(), 10, false);
            this.dgR.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bfVar.tn())) {
                this.dgU.setVisibility(8);
            } else {
                this.dgU.setText(bfVar.tn());
                this.dgU.setVisibility(0);
            }
            int tk = this.top_code.tk();
            if (tk == 1 || tk == 2) {
                if (StringUtils.isNull(this.top_code.tl())) {
                    this.dgS.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.tl();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tl(), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dgS.setText(spannableString);
                    this.dgS.setVisibility(0);
                }
                if (bfVar.tm() <= 0) {
                    this.dgT.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.tm();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tm()), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dgT.setText(spannableString2);
                    this.dgT.setVisibility(0);
                }
            } else {
                this.dgT.setVisibility(8);
                this.dgS.setText(bfVar.getSubTitle());
                this.dgS.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(biVar.getSummary())) {
            this.dgP.setVisibility(8);
            return;
        }
        this.dgP.setVisibility(0);
        this.dgW.setText(biVar.getSummary());
    }

    public void setOnClickListener() {
        this.dgO.setOnClickListener(this.bOY);
        this.dgP.setOnClickListener(this.bOY);
    }

    public bf getTopCode() {
        return this.top_code;
    }

    public void setTopCode(bf bfVar) {
        this.top_code = bfVar;
    }

    public bi getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(bi biVar) {
        this.news_info = biVar;
    }

    public View getTopCodeView() {
        return this.dgO;
    }

    public View getTopCodeViewDivider() {
        return this.dgV;
    }

    public View getNewsInfoView() {
        return this.dgP;
    }
}

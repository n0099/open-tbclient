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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.sina.weibo.sdk.constant.WBPageConstants;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private View.OnClickListener bWZ;
    private RelativeLayout dqd;
    private LinearLayout dqe;
    private TbImageView dqf;
    private TextView dqg;
    private TextView dqh;
    private TextView dqi;
    private TextView dqj;
    private View dqk;
    private TextView dql;
    private ImageView dqm;
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
        this.dqd = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dqe = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dqf = (TbImageView) findViewById(d.g.top_code_img);
        this.dqg = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dqh = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dqi = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dqj = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dqk = findViewById(d.g.u9_top_code_divider);
        this.dqm = (ImageView) findViewById(d.g.news_info_img);
        this.dqm.setBackgroundDrawable(al.getDrawable(d.f.icon_frs_news));
        this.dql = (TextView) findViewById(d.g.news_info_text);
        this.bWZ = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ba.aU(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.jU()) {
                    if (view == U9InfoView.this.dqd) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.wI())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.wI()});
                        }
                    } else if (view == U9InfoView.this.dqe && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.wP())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ay.zG().c((TbPageContext) com.baidu.adp.base.i.ad(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.wP()});
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
            this.dqd.setVisibility(8);
            this.dqk.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dqd.setVisibility(8);
            this.dqk.setVisibility(8);
        } else {
            this.dqd.setVisibility(0);
            this.dqk.setVisibility(0);
            this.dqf.startLoad(this.top_code.ub(), 10, false);
            this.dqg.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bfVar.wM())) {
                this.dqj.setVisibility(8);
            } else {
                this.dqj.setText(bfVar.wM());
                this.dqj.setVisibility(0);
            }
            int wJ = this.top_code.wJ();
            if (wJ == 1 || wJ == 2) {
                if (StringUtils.isNull(this.top_code.wK())) {
                    this.dqh.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.wK();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.wK(), new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_d)));
                    this.dqh.setText(spannableString);
                    this.dqh.setVisibility(0);
                }
                if (bfVar.wL() <= 0) {
                    this.dqi.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.wL();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.wL()), new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_d)));
                    this.dqi.setText(spannableString2);
                    this.dqi.setVisibility(0);
                }
            } else {
                this.dqi.setVisibility(8);
                this.dqh.setText(bfVar.getSubTitle());
                this.dqh.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(biVar.getSummary())) {
            this.dqe.setVisibility(8);
            return;
        }
        this.dqe.setVisibility(0);
        this.dql.setText(biVar.getSummary());
    }

    public void setOnClickListener() {
        this.dqd.setOnClickListener(this.bWZ);
        this.dqe.setOnClickListener(this.bWZ);
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
        return this.dqd;
    }

    public View getTopCodeViewDivider() {
        return this.dqk;
    }

    public View getNewsInfoView() {
        return this.dqe;
    }
}

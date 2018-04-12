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
    private View.OnClickListener bOj;
    private RelativeLayout dfK;
    private LinearLayout dfL;
    private TbImageView dfM;
    private TextView dfN;
    private TextView dfO;
    private TextView dfP;
    private TextView dfQ;
    private View dfR;
    private TextView dfS;
    private ImageView dfT;
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
        this.dfK = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dfL = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dfM = (TbImageView) findViewById(d.g.top_code_img);
        this.dfN = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dfO = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dfP = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dfQ = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dfR = findViewById(d.g.u9_top_code_divider);
        this.dfT = (ImageView) findViewById(d.g.news_info_img);
        this.dfT.setBackgroundDrawable(ak.getDrawable(d.f.icon_frs_news));
        this.dfS = (TextView) findViewById(d.g.news_info_text);
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.hg()) {
                    if (view2 == U9InfoView.this.dfK) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.tk())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.tk()});
                        }
                    } else if (view2 == U9InfoView.this.dfL && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.ts())) {
                        TiebaStatic.eventStat(U9InfoView.this.mContext, "info_click", "click", 1, WBPageConstants.ParamKey.PAGE, "frs");
                        ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(U9InfoView.this.mContext), new String[]{U9InfoView.this.news_info.ts()});
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
            this.dfK.setVisibility(8);
            this.dfR.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dfK.setVisibility(8);
            this.dfR.setVisibility(8);
        } else {
            this.dfK.setVisibility(0);
            this.dfR.setVisibility(0);
            this.dfM.startLoad(this.top_code.qG(), 10, false);
            this.dfN.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bfVar.tp())) {
                this.dfQ.setVisibility(8);
            } else {
                this.dfQ.setText(bfVar.tp());
                this.dfQ.setVisibility(0);
            }
            int tl = this.top_code.tl();
            if (tl == 1 || tl == 2) {
                if (StringUtils.isNull(this.top_code.tm())) {
                    this.dfO.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.tm();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tm(), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dfO.setText(spannableString);
                    this.dfO.setVisibility(0);
                }
                if (bfVar.tn() <= 0) {
                    this.dfP.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.tn();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tn()), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dfP.setText(spannableString2);
                    this.dfP.setVisibility(0);
                }
            } else {
                this.dfP.setVisibility(8);
                this.dfO.setText(bfVar.getSubTitle());
                this.dfO.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(biVar.getSummary())) {
            this.dfL.setVisibility(8);
            return;
        }
        this.dfL.setVisibility(0);
        this.dfS.setText(biVar.getSummary());
    }

    public void setOnClickListener() {
        this.dfK.setOnClickListener(this.bOj);
        this.dfL.setOnClickListener(this.bOj);
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
        return this.dfK;
    }

    public View getTopCodeViewDivider() {
        return this.dfR;
    }

    public View getNewsInfoView() {
        return this.dfL;
    }
}

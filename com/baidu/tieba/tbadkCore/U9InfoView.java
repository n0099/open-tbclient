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
    private View.OnClickListener bOi;
    private RelativeLayout dfH;
    private LinearLayout dfI;
    private TbImageView dfJ;
    private TextView dfK;
    private TextView dfL;
    private TextView dfM;
    private TextView dfN;
    private View dfO;
    private TextView dfP;
    private ImageView dfQ;
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
        this.dfH = (RelativeLayout) findViewById(d.g.u9_top_code);
        this.dfI = (LinearLayout) findViewById(d.g.u9_news_info);
        this.dfJ = (TbImageView) findViewById(d.g.top_code_img);
        this.dfK = (TextView) findViewById(d.g.top_code_detail_summary_text);
        this.dfL = (TextView) findViewById(d.g.top_code_detail_surplus_text);
        this.dfM = (TextView) findViewById(d.g.top_code_detail_giftworth_text);
        this.dfN = (TextView) findViewById(d.g.top_code_getnum_btn);
        this.dfO = findViewById(d.g.u9_top_code_divider);
        this.dfQ = (ImageView) findViewById(d.g.news_info_img);
        this.dfQ.setBackgroundDrawable(ak.getDrawable(d.f.icon_frs_news));
        this.dfP = (TextView) findViewById(d.g.news_info_text);
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.tbadkCore.U9InfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (az.aK(U9InfoView.this.mContext) && com.baidu.adp.lib.util.l.hg()) {
                    if (view2 == U9InfoView.this.dfH) {
                        if (U9InfoView.this.top_code != null && !TextUtils.isEmpty(U9InfoView.this.top_code.tk())) {
                            TiebaStatic.eventStat(U9InfoView.this.mContext, "num_click", "click", 1, new Object[0]);
                            ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(U9InfoView.this.mContext), new String[]{U9InfoView.this.top_code.tk()});
                        }
                    } else if (view2 == U9InfoView.this.dfI && U9InfoView.this.news_info != null && !TextUtils.isEmpty(U9InfoView.this.news_info.ts())) {
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
            this.dfH.setVisibility(8);
            this.dfO.setVisibility(8);
        } else if (StringUtils.isNull(this.top_code.getSummary())) {
            this.dfH.setVisibility(8);
            this.dfO.setVisibility(8);
        } else {
            this.dfH.setVisibility(0);
            this.dfO.setVisibility(0);
            this.dfJ.startLoad(this.top_code.qG(), 10, false);
            this.dfK.setText(this.top_code.getSummary());
            if (StringUtils.isNull(bfVar.tp())) {
                this.dfN.setVisibility(8);
            } else {
                this.dfN.setText(bfVar.tp());
                this.dfN.setVisibility(0);
            }
            int tl = this.top_code.tl();
            if (tl == 1 || tl == 2) {
                if (StringUtils.isNull(this.top_code.tm())) {
                    this.dfL.setVisibility(8);
                } else {
                    String str = this.mContext.getResources().getString(d.k.u9_shengyu) + this.top_code.tm();
                    SpannableString spannableString = new SpannableString(str);
                    UtilHelper.setSpan(spannableString, str, this.top_code.tm(), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dfL.setText(spannableString);
                    this.dfL.setVisibility(0);
                }
                if (bfVar.tn() <= 0) {
                    this.dfM.setVisibility(8);
                } else {
                    String str2 = this.mContext.getResources().getString(d.k.u9_worth) + this.top_code.tn();
                    SpannableString spannableString2 = new SpannableString(str2);
                    UtilHelper.setSpan(spannableString2, str2, String.valueOf(this.top_code.tn()), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_d)));
                    this.dfM.setText(spannableString2);
                    this.dfM.setVisibility(0);
                }
            } else {
                this.dfM.setVisibility(8);
                this.dfL.setText(bfVar.getSubTitle());
                this.dfL.setVisibility(0);
            }
        }
        if (this.news_info == null || StringUtils.isNull(biVar.getSummary())) {
            this.dfI.setVisibility(8);
            return;
        }
        this.dfI.setVisibility(0);
        this.dfP.setText(biVar.getSummary());
    }

    public void setOnClickListener() {
        this.dfH.setOnClickListener(this.bOi);
        this.dfI.setOnClickListener(this.bOi);
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
        return this.dfH;
    }

    public View getTopCodeViewDivider() {
        return this.dfO;
    }

    public View getNewsInfoView() {
        return this.dfI;
    }
}

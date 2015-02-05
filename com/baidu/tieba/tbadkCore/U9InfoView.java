package com.baidu.tieba.tbadkCore;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
/* loaded from: classes.dex */
public class U9InfoView extends LinearLayout {
    private RelativeLayout bXn;
    private LinearLayout bXo;
    private HeadImageView bXp;
    private TextView bXq;
    private TextView bXr;
    private TextView bXs;
    private View bXt;
    private TextView bXu;
    private View bXv;
    private ForegroundColorSpan bXw;
    private ImageView bXx;
    private View.OnClickListener bal;
    private Context mContext;
    private com.baidu.tbadk.core.data.ab news_info;
    private com.baidu.tbadk.core.data.y top_code;

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
        com.baidu.adp.lib.g.b.ei().a(this.mContext, com.baidu.tieba.x.u9_info_layout, this, true);
        this.bXn = (RelativeLayout) findViewById(com.baidu.tieba.w.u9_top_code);
        this.bXo = (LinearLayout) findViewById(com.baidu.tieba.w.u9_news_info);
        this.bXp = (HeadImageView) findViewById(com.baidu.tieba.w.top_code_img);
        this.bXp.setSupportNoImage(false);
        this.bXq = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_summary_text);
        this.bXr = (TextView) findViewById(com.baidu.tieba.w.top_code_detail_surplus_text);
        this.bXs = (TextView) findViewById(com.baidu.tieba.w.top_code_getnum_btn);
        this.bXt = findViewById(com.baidu.tieba.w.u9_top_code_divider);
        this.bXx = (ImageView) findViewById(com.baidu.tieba.w.news_info_img);
        this.bXx.setBackgroundDrawable(bc.getDrawable(com.baidu.tieba.v.icon_frs_news));
        this.bXu = (TextView) findViewById(com.baidu.tieba.w.news_info_text);
        this.bXv = findViewById(com.baidu.tieba.w.u9_news_info_divider);
        this.bXw = new ForegroundColorSpan(bc.getColor(com.baidu.tieba.t.cp_cont_c));
        this.bal = new at(this);
        agJ();
    }

    public void a(com.baidu.tbadk.core.data.y yVar, com.baidu.tbadk.core.data.ab abVar) {
        this.top_code = yVar;
        this.news_info = abVar;
        if (this.top_code == null) {
            this.bXn.setVisibility(8);
            this.bXt.setVisibility(8);
        } else if (TextUtils.isEmpty(this.top_code.getSummary()) || TextUtils.isEmpty(this.top_code.getSummary().trim())) {
            this.bXn.setVisibility(8);
            this.bXt.setVisibility(8);
        } else {
            this.bXn.setVisibility(0);
            this.bXt.setVisibility(0);
            this.bXp.d(this.top_code.mI(), 10, false);
            this.bXq.setText(this.top_code.getSummary());
            if (TextUtils.isEmpty(this.top_code.nJ()) || TextUtils.isEmpty(this.top_code.nJ().trim())) {
                this.bXr.setVisibility(8);
            } else {
                SpannableString spannableString = new SpannableString(String.valueOf(this.mContext.getResources().getString(com.baidu.tieba.z.u9_shengyu)) + this.top_code.nJ());
                spannableString.setSpan(this.bXw, 0, 2, 34);
                this.bXr.setText(spannableString);
                this.bXr.setVisibility(0);
            }
            if (this.top_code.nI() == 2) {
                this.bXs.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_taohao));
            } else {
                this.bXs.setText(this.mContext.getResources().getString(com.baidu.tieba.z.u9_linghao));
            }
        }
        if (this.news_info == null || TextUtils.isEmpty(abVar.getSummary())) {
            this.bXo.setVisibility(8);
            this.bXv.setVisibility(8);
            return;
        }
        this.bXo.setVisibility(0);
        this.bXv.setVisibility(0);
        this.bXu.setText(abVar.getSummary());
    }

    public void agJ() {
        this.bXn.setOnClickListener(this.bal);
        this.bXo.setOnClickListener(this.bal);
    }

    public com.baidu.tbadk.core.data.y getTopCode() {
        return this.top_code;
    }

    public void setTopCode(com.baidu.tbadk.core.data.y yVar) {
        this.top_code = yVar;
    }

    public com.baidu.tbadk.core.data.ab getNewsInfo() {
        return this.news_info;
    }

    public void setNewsInfo(com.baidu.tbadk.core.data.ab abVar) {
        this.news_info = abVar;
    }

    public void c(TbPageContext<?> tbPageContext, int i) {
        bc.i(this.bXx, com.baidu.tieba.v.icon_frs_news);
        tbPageContext.getLayoutMode().ab(i == 1);
        tbPageContext.getLayoutMode().h(this);
    }
}

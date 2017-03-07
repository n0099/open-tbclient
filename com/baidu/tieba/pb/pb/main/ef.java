package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ef extends y.a {
    private TbPageContext aaI;
    View.OnClickListener bgU;
    public View epA;
    public RelativeLayout epB;
    public TbImageView epC;
    public TextView epD;
    public TextView epE;
    public TextView epF;
    public LinearLayout epG;
    public ImageView epH;
    public TextView epI;
    public LinearLayout epJ;
    public ImageView epK;
    public TextView epL;
    public View epM;
    private com.baidu.tbadk.core.data.as epN;
    private com.baidu.tbadk.core.data.as epO;
    private com.baidu.tbadk.core.data.as epP;
    public LinearLayout epz;
    private int mSkinType;

    public ef(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bgU = new eg(this);
        this.aaI = tbPageContext;
        this.epz = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.epA = view.findViewById(w.h.pb_list_item_top_line);
        this.epB = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.epC = (TbImageView) view.findViewById(w.h.top_code_img);
        this.epD = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.epE = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.epF = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.epG = (LinearLayout) view.findViewById(w.h.news_info);
        this.epH = (ImageView) view.findViewById(w.h.news_info_img);
        this.epI = (TextView) view.findViewById(w.h.news_info_text);
        this.epJ = (LinearLayout) view.findViewById(w.h.game_info);
        this.epK = (ImageView) view.findViewById(w.h.game_info_img);
        this.epL = (TextView) view.findViewById(w.h.game_info_text);
        this.epM = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.bgU);
    }

    public void a(dw dwVar) {
        if (dwVar != null) {
            this.epN = dwVar.eoR;
            this.epO = dwVar.eoS;
            this.epP = dwVar.eoT;
            if (this.epN != null) {
                this.epC.c(this.epN.WQ, 10, false);
                this.epE.setText(this.epN.summary);
                this.epF.setText(this.epN.subtitle);
                this.epD.setText(this.epN.buttonText);
                com.baidu.tbadk.core.util.aq.j(this.epD, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aq.i((View) this.epD, w.g.news_text_color_selector);
            } else {
                this.epB.setVisibility(8);
            }
            if (this.epO != null) {
                this.epI.setText(this.epO.summary);
                com.baidu.tbadk.core.util.aq.j(this.epH, w.g.icon_frs_news);
            } else {
                this.epG.setVisibility(8);
                this.epI.setVisibility(8);
                this.epH.setVisibility(8);
            }
            if (this.epP != null) {
                this.epL.setText(this.epP.summary);
                com.baidu.tbadk.core.util.aq.j(this.epK, w.g.icon_frs_game);
            } else {
                this.epJ.setVisibility(8);
                this.epL.setVisibility(8);
                this.epL.setVisibility(8);
            }
            this.epz.setTag(dwVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aaI.getLayoutMode().ah(i == 1);
            this.aaI.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.epB.setOnClickListener(onClickListener);
        this.epG.setOnClickListener(onClickListener);
        this.epJ.setOnClickListener(onClickListener);
    }
}

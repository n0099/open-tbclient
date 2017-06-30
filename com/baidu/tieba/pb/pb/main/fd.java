package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class fd extends z.a {
    private TbPageContext aat;
    View.OnClickListener boh;
    public ImageView eAA;
    public TextView eAB;
    public LinearLayout eAC;
    public ImageView eAD;
    public TextView eAE;
    public View eAF;
    private com.baidu.tbadk.core.data.au eAG;
    private com.baidu.tbadk.core.data.au eAH;
    private com.baidu.tbadk.core.data.au eAI;
    public LinearLayout eAs;
    public View eAt;
    public RelativeLayout eAu;
    public TbImageView eAv;
    public TextView eAw;
    public TextView eAx;
    public TextView eAy;
    public LinearLayout eAz;
    private int mSkinType;

    public fd(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.boh = new fe(this);
        this.aat = tbPageContext;
        this.eAs = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.eAt = view.findViewById(w.h.pb_list_item_top_line);
        this.eAu = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.eAv = (TbImageView) view.findViewById(w.h.top_code_img);
        this.eAw = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.eAx = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.eAy = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.eAz = (LinearLayout) view.findViewById(w.h.news_info);
        this.eAA = (ImageView) view.findViewById(w.h.news_info_img);
        this.eAB = (TextView) view.findViewById(w.h.news_info_text);
        this.eAC = (LinearLayout) view.findViewById(w.h.game_info);
        this.eAD = (ImageView) view.findViewById(w.h.game_info_img);
        this.eAE = (TextView) view.findViewById(w.h.game_info_text);
        this.eAF = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.boh);
    }

    public void a(fb fbVar) {
        if (fbVar != null) {
            this.eAG = fbVar.eAn;
            this.eAH = fbVar.eAo;
            this.eAI = fbVar.eAp;
            if (this.eAG != null) {
                this.eAv.c(this.eAG.Wt, 10, false);
                this.eAx.setText(this.eAG.summary);
                this.eAy.setText(this.eAG.subtitle);
                this.eAw.setText(this.eAG.buttonText);
                com.baidu.tbadk.core.util.as.j(this.eAw, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.as.i(this.eAw, w.g.news_text_color_selector);
            } else {
                this.eAu.setVisibility(8);
            }
            if (this.eAH != null) {
                this.eAB.setText(this.eAH.summary);
                com.baidu.tbadk.core.util.as.j(this.eAA, w.g.icon_frs_news);
            } else {
                this.eAz.setVisibility(8);
                this.eAB.setVisibility(8);
                this.eAA.setVisibility(8);
            }
            if (this.eAI != null) {
                this.eAE.setText(this.eAI.summary);
                com.baidu.tbadk.core.util.as.j(this.eAD, w.g.icon_frs_game);
            } else {
                this.eAC.setVisibility(8);
                this.eAE.setVisibility(8);
                this.eAE.setVisibility(8);
            }
            this.eAs.setTag(fbVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aat.getLayoutMode().ah(i == 1);
            this.aat.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eAu.setOnClickListener(onClickListener);
        this.eAz.setOnClickListener(onClickListener);
        this.eAC.setOnClickListener(onClickListener);
    }
}

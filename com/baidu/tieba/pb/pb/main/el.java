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
public class el extends y.a {
    private TbPageContext aat;
    View.OnClickListener bjv;
    public TextView elA;
    public LinearLayout elB;
    public ImageView elC;
    public TextView elD;
    public LinearLayout elE;
    public ImageView elF;
    public TextView elG;
    public View elH;
    private com.baidu.tbadk.core.data.as elI;
    private com.baidu.tbadk.core.data.as elJ;
    private com.baidu.tbadk.core.data.as elK;
    public LinearLayout elu;
    public View elv;
    public RelativeLayout elw;
    public TbImageView elx;
    public TextView ely;
    public TextView elz;
    private int mSkinType;

    public el(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bjv = new em(this);
        this.aat = tbPageContext;
        this.elu = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.elv = view.findViewById(w.h.pb_list_item_top_line);
        this.elw = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.elx = (TbImageView) view.findViewById(w.h.top_code_img);
        this.ely = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.elz = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.elA = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.elB = (LinearLayout) view.findViewById(w.h.news_info);
        this.elC = (ImageView) view.findViewById(w.h.news_info_img);
        this.elD = (TextView) view.findViewById(w.h.news_info_text);
        this.elE = (LinearLayout) view.findViewById(w.h.game_info);
        this.elF = (ImageView) view.findViewById(w.h.game_info_img);
        this.elG = (TextView) view.findViewById(w.h.game_info_text);
        this.elH = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.bjv);
    }

    public void a(ej ejVar) {
        if (ejVar != null) {
            this.elI = ejVar.elp;
            this.elJ = ejVar.elq;
            this.elK = ejVar.elr;
            if (this.elI != null) {
                this.elx.c(this.elI.Wy, 10, false);
                this.elz.setText(this.elI.summary);
                this.elA.setText(this.elI.subtitle);
                this.ely.setText(this.elI.buttonText);
                com.baidu.tbadk.core.util.aq.j(this.ely, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aq.i(this.ely, w.g.news_text_color_selector);
            } else {
                this.elw.setVisibility(8);
            }
            if (this.elJ != null) {
                this.elD.setText(this.elJ.summary);
                com.baidu.tbadk.core.util.aq.j(this.elC, w.g.icon_frs_news);
            } else {
                this.elB.setVisibility(8);
                this.elD.setVisibility(8);
                this.elC.setVisibility(8);
            }
            if (this.elK != null) {
                this.elG.setText(this.elK.summary);
                com.baidu.tbadk.core.util.aq.j(this.elF, w.g.icon_frs_game);
            } else {
                this.elE.setVisibility(8);
                this.elG.setVisibility(8);
                this.elG.setVisibility(8);
            }
            this.elu.setTag(ejVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aat.getLayoutMode().ai(i == 1);
            this.aat.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.elw.setOnClickListener(onClickListener);
        this.elB.setOnClickListener(onClickListener);
        this.elE.setOnClickListener(onClickListener);
    }
}

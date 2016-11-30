package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class ee extends y.a {
    private TbPageContext Gf;
    View.OnClickListener bgP;
    public TextView ezA;
    public TextView ezB;
    public TextView ezC;
    public LinearLayout ezD;
    public ImageView ezE;
    public TextView ezF;
    public LinearLayout ezG;
    public ImageView ezH;
    public TextView ezI;
    public View ezJ;
    private com.baidu.tbadk.core.data.aq ezK;
    private com.baidu.tbadk.core.data.aq ezL;
    private com.baidu.tbadk.core.data.aq ezM;
    public LinearLayout ezw;
    public View ezx;
    public RelativeLayout ezy;
    public TbImageView ezz;
    private int mSkinType;

    public ee(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bgP = new ef(this);
        this.Gf = tbPageContext;
        this.ezw = (LinearLayout) view.findViewById(r.g.pb_news_info_layout);
        this.ezx = view.findViewById(r.g.pb_list_item_top_line);
        this.ezy = (RelativeLayout) view.findViewById(r.g.pb_top_code);
        this.ezz = (TbImageView) view.findViewById(r.g.top_code_img);
        this.ezA = (TextView) view.findViewById(r.g.top_code_get_btn);
        this.ezB = (TextView) view.findViewById(r.g.top_code_detail_summary_text);
        this.ezC = (TextView) view.findViewById(r.g.top_code_detail_subtitle_text);
        this.ezD = (LinearLayout) view.findViewById(r.g.news_info);
        this.ezE = (ImageView) view.findViewById(r.g.news_info_img);
        this.ezF = (TextView) view.findViewById(r.g.news_info_text);
        this.ezG = (LinearLayout) view.findViewById(r.g.game_info);
        this.ezH = (ImageView) view.findViewById(r.g.game_info_img);
        this.ezI = (TextView) view.findViewById(r.g.game_info_text);
        this.ezJ = view.findViewById(r.g.pb_news_info_divider);
        setOnClickListener(this.bgP);
    }

    public void a(dv dvVar) {
        if (dvVar != null) {
            this.ezK = dvVar.eyP;
            this.ezL = dvVar.eyQ;
            this.ezM = dvVar.eyR;
            if (this.ezK != null) {
                this.ezz.c(this.ezK.Sy, 10, false);
                this.ezB.setText(this.ezK.summary);
                this.ezC.setText(this.ezK.subtitle);
                this.ezA.setText(this.ezK.buttonText);
                com.baidu.tbadk.core.util.at.k(this.ezA, r.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.at.j((View) this.ezA, r.f.news_text_color_selector);
            } else {
                this.ezy.setVisibility(8);
            }
            if (this.ezL != null) {
                this.ezF.setText(this.ezL.summary);
                com.baidu.tbadk.core.util.at.k(this.ezE, r.f.icon_frs_news);
            } else {
                this.ezD.setVisibility(8);
                this.ezF.setVisibility(8);
                this.ezE.setVisibility(8);
            }
            if (this.ezM != null) {
                this.ezI.setText(this.ezM.summary);
                com.baidu.tbadk.core.util.at.k(this.ezH, r.f.icon_frs_game);
            } else {
                this.ezG.setVisibility(8);
                this.ezI.setVisibility(8);
                this.ezI.setVisibility(8);
            }
            this.ezw.setTag(dvVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.Gf.getLayoutMode().ai(i == 1);
            this.Gf.getLayoutMode().x(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ezy.setOnClickListener(onClickListener);
        this.ezD.setOnClickListener(onClickListener);
        this.ezG.setOnClickListener(onClickListener);
    }
}

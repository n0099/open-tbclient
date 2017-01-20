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
    private TbPageContext Fp;
    View.OnClickListener baj;
    public View emA;
    public RelativeLayout emB;
    public TbImageView emC;
    public TextView emD;
    public TextView emE;
    public TextView emF;
    public LinearLayout emG;
    public ImageView emH;
    public TextView emI;
    public LinearLayout emJ;
    public ImageView emK;
    public TextView emL;
    public View emM;
    private com.baidu.tbadk.core.data.aq emN;
    private com.baidu.tbadk.core.data.aq emO;
    private com.baidu.tbadk.core.data.aq emP;
    public LinearLayout emz;
    private int mSkinType;

    public ee(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.baj = new ef(this);
        this.Fp = tbPageContext;
        this.emz = (LinearLayout) view.findViewById(r.h.pb_news_info_layout);
        this.emA = view.findViewById(r.h.pb_list_item_top_line);
        this.emB = (RelativeLayout) view.findViewById(r.h.pb_top_code);
        this.emC = (TbImageView) view.findViewById(r.h.top_code_img);
        this.emD = (TextView) view.findViewById(r.h.top_code_get_btn);
        this.emE = (TextView) view.findViewById(r.h.top_code_detail_summary_text);
        this.emF = (TextView) view.findViewById(r.h.top_code_detail_subtitle_text);
        this.emG = (LinearLayout) view.findViewById(r.h.news_info);
        this.emH = (ImageView) view.findViewById(r.h.news_info_img);
        this.emI = (TextView) view.findViewById(r.h.news_info_text);
        this.emJ = (LinearLayout) view.findViewById(r.h.game_info);
        this.emK = (ImageView) view.findViewById(r.h.game_info_img);
        this.emL = (TextView) view.findViewById(r.h.game_info_text);
        this.emM = view.findViewById(r.h.pb_news_info_divider);
        setOnClickListener(this.baj);
    }

    public void a(dv dvVar) {
        if (dvVar != null) {
            this.emN = dvVar.elU;
            this.emO = dvVar.elV;
            this.emP = dvVar.elW;
            if (this.emN != null) {
                this.emC.c(this.emN.RC, 10, false);
                this.emE.setText(this.emN.summary);
                this.emF.setText(this.emN.subtitle);
                this.emD.setText(this.emN.buttonText);
                com.baidu.tbadk.core.util.ap.j((View) this.emD, r.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.i((View) this.emD, r.g.news_text_color_selector);
            } else {
                this.emB.setVisibility(8);
            }
            if (this.emO != null) {
                this.emI.setText(this.emO.summary);
                com.baidu.tbadk.core.util.ap.j(this.emH, r.g.icon_frs_news);
            } else {
                this.emG.setVisibility(8);
                this.emI.setVisibility(8);
                this.emH.setVisibility(8);
            }
            if (this.emP != null) {
                this.emL.setText(this.emP.summary);
                com.baidu.tbadk.core.util.ap.j(this.emK, r.g.icon_frs_game);
            } else {
                this.emJ.setVisibility(8);
                this.emL.setVisibility(8);
                this.emL.setVisibility(8);
            }
            this.emz.setTag(dvVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.Fp.getLayoutMode().ai(i == 1);
            this.Fp.getLayoutMode().v(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.emB.setOnClickListener(onClickListener);
        this.emG.setOnClickListener(onClickListener);
        this.emJ.setOnClickListener(onClickListener);
    }
}

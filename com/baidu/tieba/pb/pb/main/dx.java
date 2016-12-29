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
public class dx extends y.a {
    private TbPageContext Gf;
    View.OnClickListener bgh;
    public LinearLayout edF;
    public View edG;
    public RelativeLayout edH;
    public TbImageView edI;
    public TextView edJ;
    public TextView edK;
    public TextView edL;
    public LinearLayout edM;
    public ImageView edN;
    public TextView edO;
    public LinearLayout edP;
    public ImageView edQ;
    public TextView edR;
    public View edS;
    private com.baidu.tbadk.core.data.ap edT;
    private com.baidu.tbadk.core.data.ap edU;
    private com.baidu.tbadk.core.data.ap edV;
    private int mSkinType;

    public dx(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bgh = new dy(this);
        this.Gf = tbPageContext;
        this.edF = (LinearLayout) view.findViewById(r.g.pb_news_info_layout);
        this.edG = view.findViewById(r.g.pb_list_item_top_line);
        this.edH = (RelativeLayout) view.findViewById(r.g.pb_top_code);
        this.edI = (TbImageView) view.findViewById(r.g.top_code_img);
        this.edJ = (TextView) view.findViewById(r.g.top_code_get_btn);
        this.edK = (TextView) view.findViewById(r.g.top_code_detail_summary_text);
        this.edL = (TextView) view.findViewById(r.g.top_code_detail_subtitle_text);
        this.edM = (LinearLayout) view.findViewById(r.g.news_info);
        this.edN = (ImageView) view.findViewById(r.g.news_info_img);
        this.edO = (TextView) view.findViewById(r.g.news_info_text);
        this.edP = (LinearLayout) view.findViewById(r.g.game_info);
        this.edQ = (ImageView) view.findViewById(r.g.game_info_img);
        this.edR = (TextView) view.findViewById(r.g.game_info_text);
        this.edS = view.findViewById(r.g.pb_news_info_divider);
        setOnClickListener(this.bgh);
    }

    public void a(Cdo cdo) {
        if (cdo != null) {
            this.edT = cdo.edb;
            this.edU = cdo.edc;
            this.edV = cdo.edd;
            if (this.edT != null) {
                this.edI.c(this.edT.St, 10, false);
                this.edK.setText(this.edT.summary);
                this.edL.setText(this.edT.subtitle);
                this.edJ.setText(this.edT.buttonText);
                com.baidu.tbadk.core.util.ar.k(this.edJ, r.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.ar.j((View) this.edJ, r.f.news_text_color_selector);
            } else {
                this.edH.setVisibility(8);
            }
            if (this.edU != null) {
                this.edO.setText(this.edU.summary);
                com.baidu.tbadk.core.util.ar.k(this.edN, r.f.icon_frs_news);
            } else {
                this.edM.setVisibility(8);
                this.edO.setVisibility(8);
                this.edN.setVisibility(8);
            }
            if (this.edV != null) {
                this.edR.setText(this.edV.summary);
                com.baidu.tbadk.core.util.ar.k(this.edQ, r.f.icon_frs_game);
            } else {
                this.edP.setVisibility(8);
                this.edR.setVisibility(8);
                this.edR.setVisibility(8);
            }
            this.edF.setTag(cdo);
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
        this.edH.setOnClickListener(onClickListener);
        this.edM.setOnClickListener(onClickListener);
        this.edP.setOnClickListener(onClickListener);
    }
}

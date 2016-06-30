package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class ec extends y.a {
    private TbPageContext Dp;
    View.OnClickListener aWE;
    public LinearLayout dSA;
    public View dSB;
    public RelativeLayout dSC;
    public TbImageView dSD;
    public TextView dSE;
    public TextView dSF;
    public TextView dSG;
    public LinearLayout dSH;
    public ImageView dSI;
    public TextView dSJ;
    public LinearLayout dSK;
    public ImageView dSL;
    public TextView dSM;
    public View dSN;
    private com.baidu.tbadk.core.data.ah dSO;
    private com.baidu.tbadk.core.data.ah dSP;
    private com.baidu.tbadk.core.data.ah dSQ;
    private int mSkinType;

    public ec(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.aWE = new ed(this);
        this.Dp = tbPageContext;
        this.dSA = (LinearLayout) view.findViewById(u.g.pb_news_info_layout);
        this.dSB = view.findViewById(u.g.pb_list_item_top_line);
        this.dSC = (RelativeLayout) view.findViewById(u.g.pb_top_code);
        this.dSD = (TbImageView) view.findViewById(u.g.top_code_img);
        this.dSE = (TextView) view.findViewById(u.g.top_code_get_btn);
        this.dSF = (TextView) view.findViewById(u.g.top_code_detail_summary_text);
        this.dSG = (TextView) view.findViewById(u.g.top_code_detail_subtitle_text);
        this.dSH = (LinearLayout) view.findViewById(u.g.news_info);
        this.dSI = (ImageView) view.findViewById(u.g.news_info_img);
        this.dSJ = (TextView) view.findViewById(u.g.news_info_text);
        this.dSK = (LinearLayout) view.findViewById(u.g.game_info);
        this.dSL = (ImageView) view.findViewById(u.g.game_info_img);
        this.dSM = (TextView) view.findViewById(u.g.game_info_text);
        this.dSN = view.findViewById(u.g.pb_news_info_divider);
        setOnClickListener(this.aWE);
    }

    public void a(dr drVar) {
        if (drVar != null) {
            this.dSO = drVar.dSd;
            this.dSP = drVar.dSe;
            this.dSQ = drVar.dSf;
            if (this.dSO != null) {
                this.dSD.c(this.dSO.OX, 10, false);
                this.dSF.setText(this.dSO.summary);
                this.dSG.setText(this.dSO.subtitle);
                this.dSE.setText(this.dSO.Fg);
                com.baidu.tbadk.core.util.av.k(this.dSE, u.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.av.j((View) this.dSE, u.f.news_text_color_selector);
            } else {
                this.dSC.setVisibility(8);
            }
            if (this.dSP != null) {
                this.dSJ.setText(this.dSP.summary);
                com.baidu.tbadk.core.util.av.k(this.dSI, u.f.icon_frs_news);
            } else {
                this.dSH.setVisibility(8);
                this.dSJ.setVisibility(8);
                this.dSI.setVisibility(8);
            }
            if (this.dSQ != null) {
                this.dSM.setText(this.dSQ.summary);
                com.baidu.tbadk.core.util.av.k(this.dSL, u.f.icon_frs_game);
            } else {
                this.dSK.setVisibility(8);
                this.dSM.setVisibility(8);
                this.dSM.setVisibility(8);
            }
            this.dSA.setTag(drVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.Dp.getLayoutMode().ad(i == 1);
            this.Dp.getLayoutMode().w(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.dSC.setOnClickListener(onClickListener);
        this.dSH.setOnClickListener(onClickListener);
        this.dSK.setOnClickListener(onClickListener);
    }
}

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
public class ed extends y.a {
    private TbPageContext aaX;
    View.OnClickListener bgO;
    public LinearLayout enH;
    public View enI;
    public RelativeLayout enJ;
    public TbImageView enK;
    public TextView enL;
    public TextView enM;
    public TextView enN;
    public LinearLayout enO;
    public ImageView enP;
    public TextView enQ;
    public LinearLayout enR;
    public ImageView enS;
    public TextView enT;
    public View enU;
    private com.baidu.tbadk.core.data.ar enV;
    private com.baidu.tbadk.core.data.ar enW;
    private com.baidu.tbadk.core.data.ar enX;
    private int mSkinType;

    public ed(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bgO = new ee(this);
        this.aaX = tbPageContext;
        this.enH = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.enI = view.findViewById(w.h.pb_list_item_top_line);
        this.enJ = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.enK = (TbImageView) view.findViewById(w.h.top_code_img);
        this.enL = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.enM = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.enN = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.enO = (LinearLayout) view.findViewById(w.h.news_info);
        this.enP = (ImageView) view.findViewById(w.h.news_info_img);
        this.enQ = (TextView) view.findViewById(w.h.news_info_text);
        this.enR = (LinearLayout) view.findViewById(w.h.game_info);
        this.enS = (ImageView) view.findViewById(w.h.game_info_img);
        this.enT = (TextView) view.findViewById(w.h.game_info_text);
        this.enU = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.bgO);
    }

    public void a(du duVar) {
        if (duVar != null) {
            this.enV = duVar.emY;
            this.enW = duVar.emZ;
            this.enX = duVar.ena;
            if (this.enV != null) {
                this.enK.c(this.enV.Xf, 10, false);
                this.enM.setText(this.enV.summary);
                this.enN.setText(this.enV.subtitle);
                this.enL.setText(this.enV.buttonText);
                com.baidu.tbadk.core.util.aq.j(this.enL, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aq.i(this.enL, w.g.news_text_color_selector);
            } else {
                this.enJ.setVisibility(8);
            }
            if (this.enW != null) {
                this.enQ.setText(this.enW.summary);
                com.baidu.tbadk.core.util.aq.j(this.enP, w.g.icon_frs_news);
            } else {
                this.enO.setVisibility(8);
                this.enQ.setVisibility(8);
                this.enP.setVisibility(8);
            }
            if (this.enX != null) {
                this.enT.setText(this.enX.summary);
                com.baidu.tbadk.core.util.aq.j(this.enS, w.g.icon_frs_game);
            } else {
                this.enR.setVisibility(8);
                this.enT.setVisibility(8);
                this.enT.setVisibility(8);
            }
            this.enH.setTag(duVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aaX.getLayoutMode().aj(i == 1);
            this.aaX.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.enJ.setOnClickListener(onClickListener);
        this.enO.setOnClickListener(onClickListener);
        this.enR.setOnClickListener(onClickListener);
    }
}

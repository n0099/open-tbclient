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
public class ed extends y.a {
    private TbPageContext DQ;
    View.OnClickListener aXC;
    public LinearLayout eeR;
    public View eeS;
    public RelativeLayout eeT;
    public TbImageView eeU;
    public TextView eeV;
    public TextView eeW;
    public TextView eeX;
    public LinearLayout eeY;
    public ImageView eeZ;
    public TextView efa;
    public LinearLayout efb;
    public ImageView efc;
    public TextView efd;
    public View efe;
    private com.baidu.tbadk.core.data.al eff;
    private com.baidu.tbadk.core.data.al efg;
    private com.baidu.tbadk.core.data.al efh;
    private int mSkinType;

    public ed(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.aXC = new ee(this);
        this.DQ = tbPageContext;
        this.eeR = (LinearLayout) view.findViewById(u.g.pb_news_info_layout);
        this.eeS = view.findViewById(u.g.pb_list_item_top_line);
        this.eeT = (RelativeLayout) view.findViewById(u.g.pb_top_code);
        this.eeU = (TbImageView) view.findViewById(u.g.top_code_img);
        this.eeV = (TextView) view.findViewById(u.g.top_code_get_btn);
        this.eeW = (TextView) view.findViewById(u.g.top_code_detail_summary_text);
        this.eeX = (TextView) view.findViewById(u.g.top_code_detail_subtitle_text);
        this.eeY = (LinearLayout) view.findViewById(u.g.news_info);
        this.eeZ = (ImageView) view.findViewById(u.g.news_info_img);
        this.efa = (TextView) view.findViewById(u.g.news_info_text);
        this.efb = (LinearLayout) view.findViewById(u.g.game_info);
        this.efc = (ImageView) view.findViewById(u.g.game_info_img);
        this.efd = (TextView) view.findViewById(u.g.game_info_text);
        this.efe = view.findViewById(u.g.pb_news_info_divider);
        setOnClickListener(this.aXC);
    }

    public void a(ds dsVar) {
        if (dsVar != null) {
            this.eff = dsVar.eeu;
            this.efg = dsVar.eev;
            this.efh = dsVar.eew;
            if (this.eff != null) {
                this.eeU.c(this.eff.Pl, 10, false);
                this.eeW.setText(this.eff.summary);
                this.eeX.setText(this.eff.subtitle);
                this.eeV.setText(this.eff.FG);
                com.baidu.tbadk.core.util.av.k(this.eeV, u.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.av.j((View) this.eeV, u.f.news_text_color_selector);
            } else {
                this.eeT.setVisibility(8);
            }
            if (this.efg != null) {
                this.efa.setText(this.efg.summary);
                com.baidu.tbadk.core.util.av.k(this.eeZ, u.f.icon_frs_news);
            } else {
                this.eeY.setVisibility(8);
                this.efa.setVisibility(8);
                this.eeZ.setVisibility(8);
            }
            if (this.efh != null) {
                this.efd.setText(this.efh.summary);
                com.baidu.tbadk.core.util.av.k(this.efc, u.f.icon_frs_game);
            } else {
                this.efb.setVisibility(8);
                this.efd.setVisibility(8);
                this.efd.setVisibility(8);
            }
            this.eeR.setTag(dsVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.DQ.getLayoutMode().af(i == 1);
            this.DQ.getLayoutMode().w(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eeT.setOnClickListener(onClickListener);
        this.eeY.setOnClickListener(onClickListener);
        this.efb.setOnClickListener(onClickListener);
    }
}

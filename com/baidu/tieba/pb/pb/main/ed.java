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
public class ed extends y.a {
    private TbPageContext Gd;
    View.OnClickListener bdP;
    public LinearLayout etf;
    public View etg;
    public RelativeLayout eth;
    public TbImageView eti;
    public TextView etj;
    public TextView etk;
    public TextView etl;
    public LinearLayout etm;
    public ImageView etn;
    public TextView eto;
    public LinearLayout etp;
    public ImageView etq;
    public TextView etr;
    public View ets;
    private com.baidu.tbadk.core.data.ao ett;
    private com.baidu.tbadk.core.data.ao etu;
    private com.baidu.tbadk.core.data.ao etv;
    private int mSkinType;

    public ed(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bdP = new ee(this);
        this.Gd = tbPageContext;
        this.etf = (LinearLayout) view.findViewById(r.g.pb_news_info_layout);
        this.etg = view.findViewById(r.g.pb_list_item_top_line);
        this.eth = (RelativeLayout) view.findViewById(r.g.pb_top_code);
        this.eti = (TbImageView) view.findViewById(r.g.top_code_img);
        this.etj = (TextView) view.findViewById(r.g.top_code_get_btn);
        this.etk = (TextView) view.findViewById(r.g.top_code_detail_summary_text);
        this.etl = (TextView) view.findViewById(r.g.top_code_detail_subtitle_text);
        this.etm = (LinearLayout) view.findViewById(r.g.news_info);
        this.etn = (ImageView) view.findViewById(r.g.news_info_img);
        this.eto = (TextView) view.findViewById(r.g.news_info_text);
        this.etp = (LinearLayout) view.findViewById(r.g.game_info);
        this.etq = (ImageView) view.findViewById(r.g.game_info_img);
        this.etr = (TextView) view.findViewById(r.g.game_info_text);
        this.ets = view.findViewById(r.g.pb_news_info_divider);
        setOnClickListener(this.bdP);
    }

    public void a(ds dsVar) {
        if (dsVar != null) {
            this.ett = dsVar.esx;
            this.etu = dsVar.esy;
            this.etv = dsVar.esz;
            if (this.ett != null) {
                this.eti.c(this.ett.Sd, 10, false);
                this.etk.setText(this.ett.summary);
                this.etl.setText(this.ett.subtitle);
                this.etj.setText(this.ett.buttonText);
                com.baidu.tbadk.core.util.av.k(this.etj, r.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.av.j((View) this.etj, r.f.news_text_color_selector);
            } else {
                this.eth.setVisibility(8);
            }
            if (this.etu != null) {
                this.eto.setText(this.etu.summary);
                com.baidu.tbadk.core.util.av.k(this.etn, r.f.icon_frs_news);
            } else {
                this.etm.setVisibility(8);
                this.eto.setVisibility(8);
                this.etn.setVisibility(8);
            }
            if (this.etv != null) {
                this.etr.setText(this.etv.summary);
                com.baidu.tbadk.core.util.av.k(this.etq, r.f.icon_frs_game);
            } else {
                this.etp.setVisibility(8);
                this.etr.setVisibility(8);
                this.etr.setVisibility(8);
            }
            this.etf.setTag(dsVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.Gd.getLayoutMode().ah(i == 1);
            this.Gd.getLayoutMode().x(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eth.setOnClickListener(onClickListener);
        this.etm.setOnClickListener(onClickListener);
        this.etp.setOnClickListener(onClickListener);
    }
}

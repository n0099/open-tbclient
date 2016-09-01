package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class ed extends y.a {
    private TbPageContext Gd;
    View.OnClickListener bdv;
    public LinearLayout eqW;
    public View eqX;
    public RelativeLayout eqY;
    public TbImageView eqZ;
    public TextView era;
    public TextView erb;
    public TextView erc;
    public LinearLayout erd;
    public ImageView ere;
    public TextView erf;
    public LinearLayout erg;
    public ImageView erh;
    public TextView eri;
    public View erj;
    private com.baidu.tbadk.core.data.am erk;
    private com.baidu.tbadk.core.data.am erl;
    private com.baidu.tbadk.core.data.am erm;
    private int mSkinType;

    public ed(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bdv = new ee(this);
        this.Gd = tbPageContext;
        this.eqW = (LinearLayout) view.findViewById(t.g.pb_news_info_layout);
        this.eqX = view.findViewById(t.g.pb_list_item_top_line);
        this.eqY = (RelativeLayout) view.findViewById(t.g.pb_top_code);
        this.eqZ = (TbImageView) view.findViewById(t.g.top_code_img);
        this.era = (TextView) view.findViewById(t.g.top_code_get_btn);
        this.erb = (TextView) view.findViewById(t.g.top_code_detail_summary_text);
        this.erc = (TextView) view.findViewById(t.g.top_code_detail_subtitle_text);
        this.erd = (LinearLayout) view.findViewById(t.g.news_info);
        this.ere = (ImageView) view.findViewById(t.g.news_info_img);
        this.erf = (TextView) view.findViewById(t.g.news_info_text);
        this.erg = (LinearLayout) view.findViewById(t.g.game_info);
        this.erh = (ImageView) view.findViewById(t.g.game_info_img);
        this.eri = (TextView) view.findViewById(t.g.game_info_text);
        this.erj = view.findViewById(t.g.pb_news_info_divider);
        setOnClickListener(this.bdv);
    }

    public void a(ds dsVar) {
        if (dsVar != null) {
            this.erk = dsVar.eqz;
            this.erl = dsVar.eqA;
            this.erm = dsVar.eqB;
            if (this.erk != null) {
                this.eqZ.c(this.erk.RX, 10, false);
                this.erb.setText(this.erk.summary);
                this.erc.setText(this.erk.subtitle);
                this.era.setText(this.erk.HT);
                com.baidu.tbadk.core.util.av.k(this.era, t.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.av.j((View) this.era, t.f.news_text_color_selector);
            } else {
                this.eqY.setVisibility(8);
            }
            if (this.erl != null) {
                this.erf.setText(this.erl.summary);
                com.baidu.tbadk.core.util.av.k(this.ere, t.f.icon_frs_news);
            } else {
                this.erd.setVisibility(8);
                this.erf.setVisibility(8);
                this.ere.setVisibility(8);
            }
            if (this.erm != null) {
                this.eri.setText(this.erm.summary);
                com.baidu.tbadk.core.util.av.k(this.erh, t.f.icon_frs_game);
            } else {
                this.erg.setVisibility(8);
                this.eri.setVisibility(8);
                this.eri.setVisibility(8);
            }
            this.eqW.setTag(dsVar);
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
        this.eqY.setOnClickListener(onClickListener);
        this.erd.setOnClickListener(onClickListener);
        this.erg.setOnClickListener(onClickListener);
    }
}

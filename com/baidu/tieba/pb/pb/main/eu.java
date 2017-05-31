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
public class eu extends z.a {
    private TbPageContext aas;
    View.OnClickListener bkC;
    public LinearLayout erh;
    public View eri;
    public RelativeLayout erj;
    public TbImageView erk;
    public TextView erl;
    public TextView erm;
    public TextView ern;
    public LinearLayout ero;
    public ImageView erp;
    public TextView erq;
    public LinearLayout err;
    public ImageView ers;
    public TextView ert;
    public View eru;
    private com.baidu.tbadk.core.data.at erv;
    private com.baidu.tbadk.core.data.at erw;
    private com.baidu.tbadk.core.data.at erx;
    private int mSkinType;

    public eu(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bkC = new ev(this);
        this.aas = tbPageContext;
        this.erh = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.eri = view.findViewById(w.h.pb_list_item_top_line);
        this.erj = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.erk = (TbImageView) view.findViewById(w.h.top_code_img);
        this.erl = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.erm = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.ern = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.ero = (LinearLayout) view.findViewById(w.h.news_info);
        this.erp = (ImageView) view.findViewById(w.h.news_info_img);
        this.erq = (TextView) view.findViewById(w.h.news_info_text);
        this.err = (LinearLayout) view.findViewById(w.h.game_info);
        this.ers = (ImageView) view.findViewById(w.h.game_info_img);
        this.ert = (TextView) view.findViewById(w.h.game_info_text);
        this.eru = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.bkC);
    }

    public void a(es esVar) {
        if (esVar != null) {
            this.erv = esVar.erc;
            this.erw = esVar.erd;
            this.erx = esVar.ere;
            if (this.erv != null) {
                this.erk.c(this.erv.Wt, 10, false);
                this.erm.setText(this.erv.summary);
                this.ern.setText(this.erv.subtitle);
                this.erl.setText(this.erv.buttonText);
                com.baidu.tbadk.core.util.aq.j(this.erl, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aq.i(this.erl, w.g.news_text_color_selector);
            } else {
                this.erj.setVisibility(8);
            }
            if (this.erw != null) {
                this.erq.setText(this.erw.summary);
                com.baidu.tbadk.core.util.aq.j(this.erp, w.g.icon_frs_news);
            } else {
                this.ero.setVisibility(8);
                this.erq.setVisibility(8);
                this.erp.setVisibility(8);
            }
            if (this.erx != null) {
                this.ert.setText(this.erx.summary);
                com.baidu.tbadk.core.util.aq.j(this.ers, w.g.icon_frs_game);
            } else {
                this.err.setVisibility(8);
                this.ert.setVisibility(8);
                this.ert.setVisibility(8);
            }
            this.erh.setTag(esVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aas.getLayoutMode().ah(i == 1);
            this.aas.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.erj.setOnClickListener(onClickListener);
        this.ero.setOnClickListener(onClickListener);
        this.err.setOnClickListener(onClickListener);
    }
}

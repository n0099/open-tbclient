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
    private TbPageContext aaY;
    View.OnClickListener biY;
    public LinearLayout epZ;
    public View eqa;
    public RelativeLayout eqb;
    public TbImageView eqc;
    public TextView eqd;
    public TextView eqe;
    public TextView eqf;
    public LinearLayout eqg;
    public ImageView eqh;
    public TextView eqi;
    public LinearLayout eqj;
    public ImageView eqk;
    public TextView eql;
    public View eqm;
    private com.baidu.tbadk.core.data.ar eqn;
    private com.baidu.tbadk.core.data.ar eqo;
    private com.baidu.tbadk.core.data.ar eqp;
    private int mSkinType;

    public ed(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.biY = new ee(this);
        this.aaY = tbPageContext;
        this.epZ = (LinearLayout) view.findViewById(w.h.pb_news_info_layout);
        this.eqa = view.findViewById(w.h.pb_list_item_top_line);
        this.eqb = (RelativeLayout) view.findViewById(w.h.pb_top_code);
        this.eqc = (TbImageView) view.findViewById(w.h.top_code_img);
        this.eqd = (TextView) view.findViewById(w.h.top_code_get_btn);
        this.eqe = (TextView) view.findViewById(w.h.top_code_detail_summary_text);
        this.eqf = (TextView) view.findViewById(w.h.top_code_detail_subtitle_text);
        this.eqg = (LinearLayout) view.findViewById(w.h.news_info);
        this.eqh = (ImageView) view.findViewById(w.h.news_info_img);
        this.eqi = (TextView) view.findViewById(w.h.news_info_text);
        this.eqj = (LinearLayout) view.findViewById(w.h.game_info);
        this.eqk = (ImageView) view.findViewById(w.h.game_info_img);
        this.eql = (TextView) view.findViewById(w.h.game_info_text);
        this.eqm = view.findViewById(w.h.pb_news_info_divider);
        setOnClickListener(this.biY);
    }

    public void a(du duVar) {
        if (duVar != null) {
            this.eqn = duVar.epr;
            this.eqo = duVar.eps;
            this.eqp = duVar.ept;
            if (this.eqn != null) {
                this.eqc.c(this.eqn.Xg, 10, false);
                this.eqe.setText(this.eqn.summary);
                this.eqf.setText(this.eqn.subtitle);
                this.eqd.setText(this.eqn.buttonText);
                com.baidu.tbadk.core.util.aq.j(this.eqd, w.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aq.i(this.eqd, w.g.news_text_color_selector);
            } else {
                this.eqb.setVisibility(8);
            }
            if (this.eqo != null) {
                this.eqi.setText(this.eqo.summary);
                com.baidu.tbadk.core.util.aq.j(this.eqh, w.g.icon_frs_news);
            } else {
                this.eqg.setVisibility(8);
                this.eqi.setVisibility(8);
                this.eqh.setVisibility(8);
            }
            if (this.eqp != null) {
                this.eql.setText(this.eqp.summary);
                com.baidu.tbadk.core.util.aq.j(this.eqk, w.g.icon_frs_game);
            } else {
                this.eqj.setVisibility(8);
                this.eql.setVisibility(8);
                this.eql.setVisibility(8);
            }
            this.epZ.setTag(duVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aaY.getLayoutMode().aj(i == 1);
            this.aaY.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eqb.setOnClickListener(onClickListener);
        this.eqg.setOnClickListener(onClickListener);
        this.eqj.setOnClickListener(onClickListener);
    }
}

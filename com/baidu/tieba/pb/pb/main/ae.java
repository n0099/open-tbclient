package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ae extends j.a {
    private TbPageContext acd;
    View.OnClickListener bER;
    public LinearLayout eZh;
    public View eZi;
    public RelativeLayout eZj;
    public TbImageView eZk;
    public TextView eZl;
    public TextView eZm;
    public TextView eZn;
    public LinearLayout eZo;
    public ImageView eZp;
    public TextView eZq;
    public LinearLayout eZr;
    public ImageView eZs;
    public TextView eZt;
    public View eZu;
    private com.baidu.tbadk.core.data.an eZv;
    private com.baidu.tbadk.core.data.an eZw;
    private com.baidu.tbadk.core.data.an eZx;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aV(ae.this.acd.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == ae.this.eZj) {
                        if (ae.this.eZv != null && !TextUtils.isEmpty(ae.this.eZv.XN)) {
                            com.baidu.tbadk.core.util.av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.acd.getPageActivity()), new String[]{ae.this.eZv.XN});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.eZv.XN));
                        }
                    } else if (view2 == ae.this.eZo) {
                        BdLog.e("link: " + ae.this.eZw.XN);
                        if (ae.this.eZw != null && !TextUtils.isEmpty(ae.this.eZw.XN)) {
                            com.baidu.tbadk.core.util.av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.acd.getPageActivity()), new String[]{ae.this.eZw.XN});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.eZw.XN));
                        }
                    } else if (view2 == ae.this.eZr && ae.this.eZx != null && !TextUtils.isEmpty(ae.this.eZx.XN)) {
                        com.baidu.tbadk.core.util.av.vL().c((TbPageContext) com.baidu.adp.base.i.Y(ae.this.acd.getPageActivity()), new String[]{ae.this.eZx.XN});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.eZx.XN));
                    }
                }
            }
        };
        this.acd = tbPageContext;
        this.eZh = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.eZi = view.findViewById(d.g.pb_list_item_top_line);
        this.eZj = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.eZk = (TbImageView) view.findViewById(d.g.top_code_img);
        this.eZl = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.eZm = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.eZn = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.eZo = (LinearLayout) view.findViewById(d.g.news_info);
        this.eZp = (ImageView) view.findViewById(d.g.news_info_img);
        this.eZq = (TextView) view.findViewById(d.g.news_info_text);
        this.eZr = (LinearLayout) view.findViewById(d.g.game_info);
        this.eZs = (ImageView) view.findViewById(d.g.game_info_img);
        this.eZt = (TextView) view.findViewById(d.g.game_info_text);
        this.eZu = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bER);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.eZv = acVar.eZc;
            this.eZw = acVar.eZd;
            this.eZx = acVar.eZe;
            if (this.eZv != null) {
                this.eZk.startLoad(this.eZv.XP, 10, false);
                this.eZm.setText(this.eZv.summary);
                this.eZn.setText(this.eZv.subtitle);
                this.eZl.setText(this.eZv.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eZl, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eZl, d.f.news_text_color_selector);
            } else {
                this.eZj.setVisibility(8);
            }
            if (this.eZw != null) {
                this.eZq.setText(this.eZw.summary);
                com.baidu.tbadk.core.util.aj.j(this.eZp, d.f.icon_frs_news);
            } else {
                this.eZo.setVisibility(8);
                this.eZq.setVisibility(8);
                this.eZp.setVisibility(8);
            }
            if (this.eZx != null) {
                this.eZt.setText(this.eZx.summary);
                com.baidu.tbadk.core.util.aj.j(this.eZs, d.f.icon_frs_game);
            } else {
                this.eZr.setVisibility(8);
                this.eZt.setVisibility(8);
                this.eZt.setVisibility(8);
            }
            this.eZh.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.acd.getLayoutMode().ag(i == 1);
            this.acd.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eZj.setOnClickListener(onClickListener);
        this.eZo.setOnClickListener(onClickListener);
        this.eZr.setOnClickListener(onClickListener);
    }
}

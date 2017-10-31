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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ac extends j.a {
    private TbPageContext abI;
    View.OnClickListener byf;
    public LinearLayout eQh;
    public View eQi;
    public RelativeLayout eQj;
    public TbImageView eQk;
    public TextView eQl;
    public TextView eQm;
    public TextView eQn;
    public LinearLayout eQo;
    public ImageView eQp;
    public TextView eQq;
    public LinearLayout eQr;
    public ImageView eQs;
    public TextView eQt;
    public View eQu;
    private com.baidu.tbadk.core.data.ar eQv;
    private com.baidu.tbadk.core.data.ar eQw;
    private com.baidu.tbadk.core.data.ar eQx;
    private int mSkinType;

    public ac(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(ac.this.abI.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == ac.this.eQj) {
                        if (ac.this.eQv != null && !TextUtils.isEmpty(ac.this.eQv.Xv)) {
                            av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQv.Xv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQv.Xv));
                        }
                    } else if (view2 == ac.this.eQo) {
                        BdLog.e("link: " + ac.this.eQw.Xv);
                        if (ac.this.eQw != null && !TextUtils.isEmpty(ac.this.eQw.Xv)) {
                            av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQw.Xv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQw.Xv));
                        }
                    } else if (view2 == ac.this.eQr && ac.this.eQx != null && !TextUtils.isEmpty(ac.this.eQx.Xv)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQx.Xv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQx.Xv));
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.eQh = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.eQi = view.findViewById(d.g.pb_list_item_top_line);
        this.eQj = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.eQk = (TbImageView) view.findViewById(d.g.top_code_img);
        this.eQl = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.eQm = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.eQn = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.eQo = (LinearLayout) view.findViewById(d.g.news_info);
        this.eQp = (ImageView) view.findViewById(d.g.news_info_img);
        this.eQq = (TextView) view.findViewById(d.g.news_info_text);
        this.eQr = (LinearLayout) view.findViewById(d.g.game_info);
        this.eQs = (ImageView) view.findViewById(d.g.game_info_img);
        this.eQt = (TextView) view.findViewById(d.g.game_info_text);
        this.eQu = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.byf);
    }

    public void a(aa aaVar) {
        if (aaVar != null) {
            this.eQv = aaVar.eQc;
            this.eQw = aaVar.eQd;
            this.eQx = aaVar.eQe;
            if (this.eQv != null) {
                this.eQk.startLoad(this.eQv.Xx, 10, false);
                this.eQm.setText(this.eQv.summary);
                this.eQn.setText(this.eQv.subtitle);
                this.eQl.setText(this.eQv.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eQl, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eQl, d.f.news_text_color_selector);
            } else {
                this.eQj.setVisibility(8);
            }
            if (this.eQw != null) {
                this.eQq.setText(this.eQw.summary);
                com.baidu.tbadk.core.util.aj.j(this.eQp, d.f.icon_frs_news);
            } else {
                this.eQo.setVisibility(8);
                this.eQq.setVisibility(8);
                this.eQp.setVisibility(8);
            }
            if (this.eQx != null) {
                this.eQt.setText(this.eQx.summary);
                com.baidu.tbadk.core.util.aj.j(this.eQs, d.f.icon_frs_game);
            } else {
                this.eQr.setVisibility(8);
                this.eQt.setVisibility(8);
                this.eQt.setVisibility(8);
            }
            this.eQh.setTag(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.abI.getLayoutMode().ag(i == 1);
            this.abI.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eQj.setOnClickListener(onClickListener);
        this.eQo.setOnClickListener(onClickListener);
        this.eQr.setOnClickListener(onClickListener);
    }
}

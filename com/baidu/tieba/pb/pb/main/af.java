package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class af extends r.a {
    private TbPageContext aQq;
    View.OnClickListener ctG;
    public LinearLayout fNh;
    public View fNi;
    public RelativeLayout fNj;
    public TbImageView fNk;
    public TextView fNl;
    public TextView fNm;
    public TextView fNn;
    public LinearLayout fNo;
    public ImageView fNp;
    public TextView fNq;
    public LinearLayout fNr;
    public ImageView fNs;
    public TextView fNt;
    public View fNu;
    private com.baidu.tbadk.core.data.ao fNv;
    private com.baidu.tbadk.core.data.ao fNw;
    private com.baidu.tbadk.core.data.ao fNx;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.be(af.this.aQq.getPageActivity()) && com.baidu.adp.lib.util.l.oZ()) {
                    if (view2 == af.this.fNj) {
                        if (af.this.fNv != null && !TextUtils.isEmpty(af.this.fNv.aMi)) {
                            com.baidu.tbadk.core.util.av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQq.getPageActivity()), new String[]{af.this.fNv.aMi});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fNv.aMi));
                        }
                    } else if (view2 == af.this.fNo) {
                        BdLog.e("link: " + af.this.fNw.aMi);
                        if (af.this.fNw != null && !TextUtils.isEmpty(af.this.fNw.aMi)) {
                            com.baidu.tbadk.core.util.av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQq.getPageActivity()), new String[]{af.this.fNw.aMi});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fNw.aMi));
                        }
                    } else if (view2 == af.this.fNr && af.this.fNx != null && !TextUtils.isEmpty(af.this.fNx.aMi)) {
                        com.baidu.tbadk.core.util.av.Di().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQq.getPageActivity()), new String[]{af.this.fNx.aMi});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fNx.aMi));
                    }
                }
            }
        };
        this.aQq = tbPageContext;
        this.fNh = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fNi = view.findViewById(d.g.pb_list_item_top_line);
        this.fNj = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fNk = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fNl = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fNm = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fNn = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fNo = (LinearLayout) view.findViewById(d.g.news_info);
        this.fNp = (ImageView) view.findViewById(d.g.news_info_img);
        this.fNq = (TextView) view.findViewById(d.g.news_info_text);
        this.fNr = (LinearLayout) view.findViewById(d.g.game_info);
        this.fNs = (ImageView) view.findViewById(d.g.game_info_img);
        this.fNt = (TextView) view.findViewById(d.g.game_info_text);
        this.fNu = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.ctG);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fNv = adVar.fNc;
            this.fNw = adVar.fNd;
            this.fNx = adVar.fNe;
            if (this.fNv != null) {
                this.fNk.startLoad(this.fNv.aMk, 10, false);
                this.fNm.setText(this.fNv.summary);
                this.fNn.setText(this.fNv.subtitle);
                this.fNl.setText(this.fNv.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fNl, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fNl, d.f.news_text_color_selector);
            } else {
                this.fNj.setVisibility(8);
            }
            if (this.fNw != null) {
                this.fNq.setText(this.fNw.summary);
                com.baidu.tbadk.core.util.aj.s(this.fNp, d.f.icon_frs_news);
            } else {
                this.fNo.setVisibility(8);
                this.fNq.setVisibility(8);
                this.fNp.setVisibility(8);
            }
            if (this.fNx != null) {
                this.fNt.setText(this.fNx.summary);
                com.baidu.tbadk.core.util.aj.s(this.fNs, d.f.icon_frs_game);
            } else {
                this.fNr.setVisibility(8);
                this.fNt.setVisibility(8);
                this.fNt.setVisibility(8);
            }
            this.fNh.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aQq.getLayoutMode().aM(i == 1);
            this.aQq.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fNj.setOnClickListener(onClickListener);
        this.fNo.setOnClickListener(onClickListener);
        this.fNr.setOnClickListener(onClickListener);
    }
}

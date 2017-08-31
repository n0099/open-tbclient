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
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ab extends j.a {
    private TbPageContext aby;
    View.OnClickListener buo;
    public LinearLayout eNe;
    public View eNf;
    public RelativeLayout eNg;
    public TbImageView eNh;
    public TextView eNi;
    public TextView eNj;
    public TextView eNk;
    public LinearLayout eNl;
    public ImageView eNm;
    public TextView eNn;
    public LinearLayout eNo;
    public ImageView eNp;
    public TextView eNq;
    public View eNr;
    private at eNs;
    private at eNt;
    private at eNu;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(ab.this.aby.getPageActivity()) && com.baidu.adp.lib.util.k.hz()) {
                    if (view2 == ab.this.eNg) {
                        if (ab.this.eNs != null && !TextUtils.isEmpty(ab.this.eNs.Xo)) {
                            au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ab.this.aby.getPageActivity()), new String[]{ab.this.eNs.Xo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNs.Xo));
                        }
                    } else if (view2 == ab.this.eNl) {
                        BdLog.e("link: " + ab.this.eNt.Xo);
                        if (ab.this.eNt != null && !TextUtils.isEmpty(ab.this.eNt.Xo)) {
                            au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ab.this.aby.getPageActivity()), new String[]{ab.this.eNt.Xo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNt.Xo));
                        }
                    } else if (view2 == ab.this.eNo && ab.this.eNu != null && !TextUtils.isEmpty(ab.this.eNu.Xo)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.X(ab.this.aby.getPageActivity()), new String[]{ab.this.eNu.Xo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNu.Xo));
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eNe = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eNf = view.findViewById(d.h.pb_list_item_top_line);
        this.eNg = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eNh = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eNi = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eNj = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eNk = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eNl = (LinearLayout) view.findViewById(d.h.news_info);
        this.eNm = (ImageView) view.findViewById(d.h.news_info_img);
        this.eNn = (TextView) view.findViewById(d.h.news_info_text);
        this.eNo = (LinearLayout) view.findViewById(d.h.game_info);
        this.eNp = (ImageView) view.findViewById(d.h.game_info_img);
        this.eNq = (TextView) view.findViewById(d.h.game_info_text);
        this.eNr = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.buo);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eNs = zVar.eMZ;
            this.eNt = zVar.eNa;
            this.eNu = zVar.eNb;
            if (this.eNs != null) {
                this.eNh.c(this.eNs.Xq, 10, false);
                this.eNj.setText(this.eNs.summary);
                this.eNk.setText(this.eNs.subtitle);
                this.eNi.setText(this.eNs.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eNi, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eNi, d.g.news_text_color_selector);
            } else {
                this.eNg.setVisibility(8);
            }
            if (this.eNt != null) {
                this.eNn.setText(this.eNt.summary);
                com.baidu.tbadk.core.util.aj.j(this.eNm, d.g.icon_frs_news);
            } else {
                this.eNl.setVisibility(8);
                this.eNn.setVisibility(8);
                this.eNm.setVisibility(8);
            }
            if (this.eNu != null) {
                this.eNq.setText(this.eNu.summary);
                com.baidu.tbadk.core.util.aj.j(this.eNp, d.g.icon_frs_game);
            } else {
                this.eNo.setVisibility(8);
                this.eNq.setVisibility(8);
                this.eNq.setVisibility(8);
            }
            this.eNe.setTag(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aby.getLayoutMode().ah(i == 1);
            this.aby.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eNg.setOnClickListener(onClickListener);
        this.eNl.setOnClickListener(onClickListener);
        this.eNo.setOnClickListener(onClickListener);
    }
}

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
    View.OnClickListener bvd;
    public LinearLayout eNY;
    public View eNZ;
    public RelativeLayout eOa;
    public TbImageView eOb;
    public TextView eOc;
    public TextView eOd;
    public TextView eOe;
    public LinearLayout eOf;
    public ImageView eOg;
    public TextView eOh;
    public LinearLayout eOi;
    public ImageView eOj;
    public TextView eOk;
    public View eOl;
    private at eOm;
    private at eOn;
    private at eOo;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(ab.this.aby.getPageActivity()) && com.baidu.adp.lib.util.k.hz()) {
                    if (view2 == ab.this.eOa) {
                        if (ab.this.eOm != null && !TextUtils.isEmpty(ab.this.eOm.Xo)) {
                            au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ab.this.aby.getPageActivity()), new String[]{ab.this.eOm.Xo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOm.Xo));
                        }
                    } else if (view2 == ab.this.eOf) {
                        BdLog.e("link: " + ab.this.eOn.Xo);
                        if (ab.this.eOn != null && !TextUtils.isEmpty(ab.this.eOn.Xo)) {
                            au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ab.this.aby.getPageActivity()), new String[]{ab.this.eOn.Xo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOn.Xo));
                        }
                    } else if (view2 == ab.this.eOi && ab.this.eOo != null && !TextUtils.isEmpty(ab.this.eOo.Xo)) {
                        au.wd().c((TbPageContext) com.baidu.adp.base.i.Y(ab.this.aby.getPageActivity()), new String[]{ab.this.eOo.Xo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOo.Xo));
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.eNY = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eNZ = view.findViewById(d.h.pb_list_item_top_line);
        this.eOa = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eOb = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eOc = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eOd = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eOe = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eOf = (LinearLayout) view.findViewById(d.h.news_info);
        this.eOg = (ImageView) view.findViewById(d.h.news_info_img);
        this.eOh = (TextView) view.findViewById(d.h.news_info_text);
        this.eOi = (LinearLayout) view.findViewById(d.h.game_info);
        this.eOj = (ImageView) view.findViewById(d.h.game_info_img);
        this.eOk = (TextView) view.findViewById(d.h.game_info_text);
        this.eOl = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.bvd);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eOm = zVar.eNT;
            this.eOn = zVar.eNU;
            this.eOo = zVar.eNV;
            if (this.eOm != null) {
                this.eOb.c(this.eOm.Xq, 10, false);
                this.eOd.setText(this.eOm.summary);
                this.eOe.setText(this.eOm.subtitle);
                this.eOc.setText(this.eOm.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eOc, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eOc, d.g.news_text_color_selector);
            } else {
                this.eOa.setVisibility(8);
            }
            if (this.eOn != null) {
                this.eOh.setText(this.eOn.summary);
                com.baidu.tbadk.core.util.aj.j(this.eOg, d.g.icon_frs_news);
            } else {
                this.eOf.setVisibility(8);
                this.eOh.setVisibility(8);
                this.eOg.setVisibility(8);
            }
            if (this.eOo != null) {
                this.eOk.setText(this.eOo.summary);
                com.baidu.tbadk.core.util.aj.j(this.eOj, d.g.icon_frs_game);
            } else {
                this.eOi.setVisibility(8);
                this.eOk.setVisibility(8);
                this.eOk.setVisibility(8);
            }
            this.eNY.setTag(zVar);
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
        this.eOa.setOnClickListener(onClickListener);
        this.eOf.setOnClickListener(onClickListener);
        this.eOi.setOnClickListener(onClickListener);
    }
}

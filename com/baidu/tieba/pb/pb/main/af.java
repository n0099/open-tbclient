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
    private TbPageContext aQs;
    View.OnClickListener ctZ;
    public LinearLayout fPc;
    public View fPd;
    public RelativeLayout fPe;
    public TbImageView fPf;
    public TextView fPg;
    public TextView fPh;
    public TextView fPi;
    public LinearLayout fPj;
    public ImageView fPk;
    public TextView fPl;
    public LinearLayout fPm;
    public ImageView fPn;
    public TextView fPo;
    public View fPp;
    private com.baidu.tbadk.core.data.an fPq;
    private com.baidu.tbadk.core.data.an fPr;
    private com.baidu.tbadk.core.data.an fPs;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ctZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.bb(af.this.aQs.getPageActivity()) && com.baidu.adp.lib.util.l.pa()) {
                    if (view2 == af.this.fPe) {
                        if (af.this.fPq != null && !TextUtils.isEmpty(af.this.fPq.aMh)) {
                            com.baidu.tbadk.core.util.av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQs.getPageActivity()), new String[]{af.this.fPq.aMh});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fPq.aMh));
                        }
                    } else if (view2 == af.this.fPj) {
                        BdLog.e("link: " + af.this.fPr.aMh);
                        if (af.this.fPr != null && !TextUtils.isEmpty(af.this.fPr.aMh)) {
                            com.baidu.tbadk.core.util.av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQs.getPageActivity()), new String[]{af.this.fPr.aMh});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fPr.aMh));
                        }
                    } else if (view2 == af.this.fPm && af.this.fPs != null && !TextUtils.isEmpty(af.this.fPs.aMh)) {
                        com.baidu.tbadk.core.util.av.Da().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQs.getPageActivity()), new String[]{af.this.fPs.aMh});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fPs.aMh));
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        this.fPc = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fPd = view.findViewById(d.g.pb_list_item_top_line);
        this.fPe = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fPf = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fPg = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fPh = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fPi = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fPj = (LinearLayout) view.findViewById(d.g.news_info);
        this.fPk = (ImageView) view.findViewById(d.g.news_info_img);
        this.fPl = (TextView) view.findViewById(d.g.news_info_text);
        this.fPm = (LinearLayout) view.findViewById(d.g.game_info);
        this.fPn = (ImageView) view.findViewById(d.g.game_info_img);
        this.fPo = (TextView) view.findViewById(d.g.game_info_text);
        this.fPp = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.ctZ);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fPq = adVar.fOX;
            this.fPr = adVar.fOY;
            this.fPs = adVar.fOZ;
            if (this.fPq != null) {
                this.fPf.startLoad(this.fPq.aMj, 10, false);
                this.fPh.setText(this.fPq.summary);
                this.fPi.setText(this.fPq.subtitle);
                this.fPg.setText(this.fPq.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fPg, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fPg, d.f.news_text_color_selector);
            } else {
                this.fPe.setVisibility(8);
            }
            if (this.fPr != null) {
                this.fPl.setText(this.fPr.summary);
                com.baidu.tbadk.core.util.aj.s(this.fPk, d.f.icon_frs_news);
            } else {
                this.fPj.setVisibility(8);
                this.fPl.setVisibility(8);
                this.fPk.setVisibility(8);
            }
            if (this.fPs != null) {
                this.fPo.setText(this.fPs.summary);
                com.baidu.tbadk.core.util.aj.s(this.fPn, d.f.icon_frs_game);
            } else {
                this.fPm.setVisibility(8);
                this.fPo.setVisibility(8);
                this.fPo.setVisibility(8);
            }
            this.fPc.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aQs.getLayoutMode().aN(i == 1);
            this.aQs.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fPe.setOnClickListener(onClickListener);
        this.fPj.setOnClickListener(onClickListener);
        this.fPm.setOnClickListener(onClickListener);
    }
}

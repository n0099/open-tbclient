package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class af extends q.a {
    View.OnClickListener csN;
    public TextView gaA;
    public LinearLayout gaB;
    public ImageView gaC;
    public TextView gaD;
    public LinearLayout gaE;
    public ImageView gaF;
    public TextView gaG;
    public View gaH;
    private com.baidu.tbadk.core.data.an gaI;
    private com.baidu.tbadk.core.data.an gaJ;
    private com.baidu.tbadk.core.data.an gaK;
    public LinearLayout gau;
    public View gav;
    public RelativeLayout gaw;
    public TbImageView gax;
    public TextView gay;
    public TextView gaz;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll()) {
                    if (view2 == af.this.gaw) {
                        if (af.this.gaI != null && !TextUtils.isEmpty(af.this.gaI.aso)) {
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gaI.aso});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gaI.aso));
                        }
                    } else if (view2 == af.this.gaB) {
                        BdLog.e("link: " + af.this.gaJ.aso);
                        if (af.this.gaJ != null && !TextUtils.isEmpty(af.this.gaJ.aso)) {
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gaJ.aso});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gaJ.aso));
                        }
                    } else if (view2 == af.this.gaE && af.this.gaK != null && !TextUtils.isEmpty(af.this.gaK.aso)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gaK.aso});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gaK.aso));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gau = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.gav = view.findViewById(e.g.pb_list_item_top_line);
        this.gaw = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.gax = (TbImageView) view.findViewById(e.g.top_code_img);
        this.gay = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.gaz = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.gaA = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.gaB = (LinearLayout) view.findViewById(e.g.news_info);
        this.gaC = (ImageView) view.findViewById(e.g.news_info_img);
        this.gaD = (TextView) view.findViewById(e.g.news_info_text);
        this.gaE = (LinearLayout) view.findViewById(e.g.game_info);
        this.gaF = (ImageView) view.findViewById(e.g.game_info_img);
        this.gaG = (TextView) view.findViewById(e.g.game_info_text);
        this.gaH = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.csN);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.gaI = adVar.gap;
            this.gaJ = adVar.gaq;
            this.gaK = adVar.gar;
            if (this.gaI != null) {
                this.gax.startLoad(this.gaI.asq, 10, false);
                this.gaz.setText(this.gaI.summary);
                this.gaA.setText(this.gaI.subtitle);
                this.gay.setText(this.gaI.buttonText);
                com.baidu.tbadk.core.util.al.i(this.gay, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.gay, e.f.news_text_color_selector);
            } else {
                this.gaw.setVisibility(8);
            }
            if (this.gaJ != null) {
                this.gaD.setText(this.gaJ.summary);
                com.baidu.tbadk.core.util.al.i(this.gaC, e.f.icon_frs_news);
            } else {
                this.gaB.setVisibility(8);
                this.gaD.setVisibility(8);
                this.gaC.setVisibility(8);
            }
            if (this.gaK != null) {
                this.gaG.setText(this.gaK.summary);
                com.baidu.tbadk.core.util.al.i(this.gaF, e.f.icon_frs_game);
            } else {
                this.gaE.setVisibility(8);
                this.gaG.setVisibility(8);
                this.gaG.setVisibility(8);
            }
            this.gau.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.gaw.setOnClickListener(onClickListener);
        this.gaB.setOnClickListener(onClickListener);
        this.gaE.setOnClickListener(onClickListener);
    }
}

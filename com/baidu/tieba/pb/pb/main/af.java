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
    private TbPageContext aQp;
    View.OnClickListener ctQ;
    public LinearLayout fOH;
    public View fOI;
    public RelativeLayout fOJ;
    public TbImageView fOK;
    public TextView fOL;
    public TextView fOM;
    public TextView fON;
    public LinearLayout fOO;
    public ImageView fOP;
    public TextView fOQ;
    public LinearLayout fOR;
    public ImageView fOS;
    public TextView fOT;
    public View fOU;
    private com.baidu.tbadk.core.data.an fOV;
    private com.baidu.tbadk.core.data.an fOW;
    private com.baidu.tbadk.core.data.an fOX;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (com.baidu.tbadk.core.util.ax.be(af.this.aQp.getPageActivity()) && com.baidu.adp.lib.util.l.oZ()) {
                    if (view2 == af.this.fOJ) {
                        if (af.this.fOV != null && !TextUtils.isEmpty(af.this.fOV.aMe)) {
                            com.baidu.tbadk.core.util.av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQp.getPageActivity()), new String[]{af.this.fOV.aMe});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fOV.aMe));
                        }
                    } else if (view2 == af.this.fOO) {
                        BdLog.e("link: " + af.this.fOW.aMe);
                        if (af.this.fOW != null && !TextUtils.isEmpty(af.this.fOW.aMe)) {
                            com.baidu.tbadk.core.util.av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQp.getPageActivity()), new String[]{af.this.fOW.aMe});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fOW.aMe));
                        }
                    } else if (view2 == af.this.fOR && af.this.fOX != null && !TextUtils.isEmpty(af.this.fOX.aMe)) {
                        com.baidu.tbadk.core.util.av.CZ().c((TbPageContext) com.baidu.adp.base.i.ak(af.this.aQp.getPageActivity()), new String[]{af.this.fOX.aMe});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fOX.aMe));
                    }
                }
            }
        };
        this.aQp = tbPageContext;
        this.fOH = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fOI = view.findViewById(d.g.pb_list_item_top_line);
        this.fOJ = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fOK = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fOL = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fOM = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fON = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fOO = (LinearLayout) view.findViewById(d.g.news_info);
        this.fOP = (ImageView) view.findViewById(d.g.news_info_img);
        this.fOQ = (TextView) view.findViewById(d.g.news_info_text);
        this.fOR = (LinearLayout) view.findViewById(d.g.game_info);
        this.fOS = (ImageView) view.findViewById(d.g.game_info_img);
        this.fOT = (TextView) view.findViewById(d.g.game_info_text);
        this.fOU = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.ctQ);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fOV = adVar.fOC;
            this.fOW = adVar.fOD;
            this.fOX = adVar.fOE;
            if (this.fOV != null) {
                this.fOK.startLoad(this.fOV.aMg, 10, false);
                this.fOM.setText(this.fOV.summary);
                this.fON.setText(this.fOV.subtitle);
                this.fOL.setText(this.fOV.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fOL, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fOL, d.f.news_text_color_selector);
            } else {
                this.fOJ.setVisibility(8);
            }
            if (this.fOW != null) {
                this.fOQ.setText(this.fOW.summary);
                com.baidu.tbadk.core.util.aj.s(this.fOP, d.f.icon_frs_news);
            } else {
                this.fOO.setVisibility(8);
                this.fOQ.setVisibility(8);
                this.fOP.setVisibility(8);
            }
            if (this.fOX != null) {
                this.fOT.setText(this.fOX.summary);
                com.baidu.tbadk.core.util.aj.s(this.fOS, d.f.icon_frs_game);
            } else {
                this.fOR.setVisibility(8);
                this.fOT.setVisibility(8);
                this.fOT.setVisibility(8);
            }
            this.fOH.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aQp.getLayoutMode().aM(i == 1);
            this.aQp.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fOJ.setOnClickListener(onClickListener);
        this.fOO.setOnClickListener(onClickListener);
        this.fOR.setOnClickListener(onClickListener);
    }
}

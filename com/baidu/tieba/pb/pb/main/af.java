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
    View.OnClickListener cue;
    private com.baidu.tbadk.core.data.an geA;
    private com.baidu.tbadk.core.data.an geB;
    private com.baidu.tbadk.core.data.an geC;
    private ad geD;
    private a geE;
    public LinearLayout gel;
    public View gem;
    public RelativeLayout gen;
    public TbImageView gep;
    public TextView geq;
    public TextView ger;
    public TextView ges;
    public LinearLayout get;
    public ImageView geu;
    public TextView gev;
    public LinearLayout gew;
    public ImageView gex;
    public TextView gey;
    public View gez;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes6.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.cue = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll()) {
                    if (af.this.geE != null) {
                        af.this.geE.b(af.this.geD);
                    }
                    if (view2 == af.this.gen) {
                        if (af.this.geA != null && !TextUtils.isEmpty(af.this.geA.asR)) {
                            ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.geA.asR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.geA.asR));
                        }
                    } else if (view2 == af.this.get) {
                        BdLog.e("link: " + af.this.geB.asR);
                        if (af.this.geB != null && !TextUtils.isEmpty(af.this.geB.asR)) {
                            ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.geB.asR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.geB.asR));
                        }
                    } else if (view2 == af.this.gew && af.this.geC != null && !TextUtils.isEmpty(af.this.geC.asR)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.geC.asR});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.geC.asR));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.geE = aVar;
        this.gel = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.gem = view.findViewById(e.g.pb_list_item_top_line);
        this.gen = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.gep = (TbImageView) view.findViewById(e.g.top_code_img);
        this.geq = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.ger = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.ges = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.get = (LinearLayout) view.findViewById(e.g.news_info);
        this.geu = (ImageView) view.findViewById(e.g.news_info_img);
        this.gev = (TextView) view.findViewById(e.g.news_info_text);
        this.gew = (LinearLayout) view.findViewById(e.g.game_info);
        this.gex = (ImageView) view.findViewById(e.g.game_info_img);
        this.gey = (TextView) view.findViewById(e.g.game_info_text);
        this.gez = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.cue);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.geD = adVar;
            this.geA = adVar.geg;
            this.geB = adVar.geh;
            this.geC = adVar.gei;
            if (this.geA != null) {
                this.gep.startLoad(this.geA.asT, 10, false);
                this.ger.setText(this.geA.summary);
                this.ges.setText(this.geA.subtitle);
                this.geq.setText(this.geA.buttonText);
                com.baidu.tbadk.core.util.al.i(this.geq, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.geq, e.f.news_text_color_selector);
            } else {
                this.gen.setVisibility(8);
            }
            if (this.geB != null) {
                this.gev.setText(this.geB.summary);
                com.baidu.tbadk.core.util.al.i(this.geu, e.f.icon_frs_news);
            } else {
                this.get.setVisibility(8);
                this.gev.setVisibility(8);
                this.geu.setVisibility(8);
            }
            if (this.geC != null) {
                this.gey.setText(this.geC.summary);
                com.baidu.tbadk.core.util.al.i(this.gex, e.f.icon_frs_game);
            } else {
                this.gew.setVisibility(8);
                this.gey.setVisibility(8);
                this.gey.setVisibility(8);
            }
            this.gel.setTag(adVar);
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
        this.gen.setOnClickListener(onClickListener);
        this.get.setOnClickListener(onClickListener);
        this.gew.setOnClickListener(onClickListener);
    }
}

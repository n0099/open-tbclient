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
    View.OnClickListener cud;
    private com.baidu.tbadk.core.data.an geA;
    private com.baidu.tbadk.core.data.an geB;
    private ad geC;
    private a geD;
    public LinearLayout gek;
    public View gel;
    public RelativeLayout gem;
    public TbImageView gen;
    public TextView gep;
    public TextView geq;
    public TextView ger;
    public LinearLayout ges;
    public ImageView get;
    public TextView geu;
    public LinearLayout gev;
    public ImageView gew;
    public TextView gex;
    public View gey;
    private com.baidu.tbadk.core.data.an gez;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes6.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll()) {
                    if (af.this.geD != null) {
                        af.this.geD.b(af.this.geC);
                    }
                    if (view2 == af.this.gem) {
                        if (af.this.gez != null && !TextUtils.isEmpty(af.this.gez.asQ)) {
                            ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gez.asQ});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gez.asQ));
                        }
                    } else if (view2 == af.this.ges) {
                        BdLog.e("link: " + af.this.geA.asQ);
                        if (af.this.geA != null && !TextUtils.isEmpty(af.this.geA.asQ)) {
                            ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.geA.asQ});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.geA.asQ));
                        }
                    } else if (view2 == af.this.gev && af.this.geB != null && !TextUtils.isEmpty(af.this.geB.asQ)) {
                        ay.Es().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.geB.asQ});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.geB.asQ));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.geD = aVar;
        this.gek = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.gel = view.findViewById(e.g.pb_list_item_top_line);
        this.gem = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.gen = (TbImageView) view.findViewById(e.g.top_code_img);
        this.gep = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.geq = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.ger = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.ges = (LinearLayout) view.findViewById(e.g.news_info);
        this.get = (ImageView) view.findViewById(e.g.news_info_img);
        this.geu = (TextView) view.findViewById(e.g.news_info_text);
        this.gev = (LinearLayout) view.findViewById(e.g.game_info);
        this.gew = (ImageView) view.findViewById(e.g.game_info_img);
        this.gex = (TextView) view.findViewById(e.g.game_info_text);
        this.gey = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.cud);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.geC = adVar;
            this.gez = adVar.gef;
            this.geA = adVar.geg;
            this.geB = adVar.geh;
            if (this.gez != null) {
                this.gen.startLoad(this.gez.asS, 10, false);
                this.geq.setText(this.gez.summary);
                this.ger.setText(this.gez.subtitle);
                this.gep.setText(this.gez.buttonText);
                com.baidu.tbadk.core.util.al.i(this.gep, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.gep, e.f.news_text_color_selector);
            } else {
                this.gem.setVisibility(8);
            }
            if (this.geA != null) {
                this.geu.setText(this.geA.summary);
                com.baidu.tbadk.core.util.al.i(this.get, e.f.icon_frs_news);
            } else {
                this.ges.setVisibility(8);
                this.geu.setVisibility(8);
                this.get.setVisibility(8);
            }
            if (this.geB != null) {
                this.gex.setText(this.geB.summary);
                com.baidu.tbadk.core.util.al.i(this.gew, e.f.icon_frs_game);
            } else {
                this.gev.setVisibility(8);
                this.gex.setVisibility(8);
                this.gex.setVisibility(8);
            }
            this.gek.setTag(adVar);
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
        this.gem.setOnClickListener(onClickListener);
        this.ges.setOnClickListener(onClickListener);
        this.gev.setOnClickListener(onClickListener);
    }
}

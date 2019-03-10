package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener dJa;
    public TextView huA;
    public TextView huB;
    public LinearLayout huC;
    public ImageView huD;
    public TextView huE;
    public LinearLayout huF;
    public ImageView huG;
    public TextView huH;
    public View huI;
    private com.baidu.tbadk.core.data.ap huJ;
    private com.baidu.tbadk.core.data.ap huK;
    private com.baidu.tbadk.core.data.ap huL;
    private ad huM;
    private a huN;
    public LinearLayout huv;
    public View huw;
    public RelativeLayout hux;
    public TbImageView huy;
    public TextView huz;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dJa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (af.this.huN != null) {
                        af.this.huN.b(af.this.huM);
                    }
                    if (view2 == af.this.hux) {
                        if (af.this.huJ != null && !TextUtils.isEmpty(af.this.huJ.bzD)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huJ.bzD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huJ.bzD));
                        }
                    } else if (view2 == af.this.huC) {
                        BdLog.e("link: " + af.this.huK.bzD);
                        if (af.this.huK != null && !TextUtils.isEmpty(af.this.huK.bzD)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huK.bzD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huK.bzD));
                        }
                    } else if (view2 == af.this.huF && af.this.huL != null && !TextUtils.isEmpty(af.this.huL.bzD)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huL.bzD});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huL.bzD));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huN = aVar;
        this.huv = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.huw = view.findViewById(d.g.pb_list_item_top_line);
        this.hux = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.huy = (TbImageView) view.findViewById(d.g.top_code_img);
        this.huz = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.huA = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.huB = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.huC = (LinearLayout) view.findViewById(d.g.news_info);
        this.huD = (ImageView) view.findViewById(d.g.news_info_img);
        this.huE = (TextView) view.findViewById(d.g.news_info_text);
        this.huF = (LinearLayout) view.findViewById(d.g.game_info);
        this.huG = (ImageView) view.findViewById(d.g.game_info_img);
        this.huH = (TextView) view.findViewById(d.g.game_info_text);
        this.huI = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.dJa);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.huM = adVar;
            this.huJ = adVar.huq;
            this.huK = adVar.hur;
            this.huL = adVar.hus;
            if (this.huJ != null) {
                this.huy.startLoad(this.huJ.bzF, 10, false);
                this.huA.setText(this.huJ.summary);
                this.huB.setText(this.huJ.subtitle);
                this.huz.setText(this.huJ.buttonText);
                com.baidu.tbadk.core.util.al.k(this.huz, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.huz, d.f.news_text_color_selector);
            } else {
                this.hux.setVisibility(8);
            }
            if (this.huK != null) {
                this.huE.setText(this.huK.summary);
                com.baidu.tbadk.core.util.al.k(this.huD, d.f.icon_frs_news);
            } else {
                this.huC.setVisibility(8);
                this.huE.setVisibility(8);
                this.huD.setVisibility(8);
            }
            if (this.huL != null) {
                this.huH.setText(this.huL.summary);
                com.baidu.tbadk.core.util.al.k(this.huG, d.f.icon_frs_game);
            } else {
                this.huF.setVisibility(8);
                this.huH.setVisibility(8);
                this.huH.setVisibility(8);
            }
            this.huv.setTag(adVar);
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
        this.hux.setOnClickListener(onClickListener);
        this.huC.setOnClickListener(onClickListener);
        this.huF.setOnClickListener(onClickListener);
    }
}

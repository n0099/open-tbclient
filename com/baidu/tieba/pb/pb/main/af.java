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
    public LinearLayout huB;
    public ImageView huC;
    public TextView huD;
    public LinearLayout huE;
    public ImageView huF;
    public TextView huG;
    public View huH;
    private com.baidu.tbadk.core.data.ap huI;
    private com.baidu.tbadk.core.data.ap huJ;
    private com.baidu.tbadk.core.data.ap huK;
    private ad huL;
    private a huM;
    public LinearLayout huu;
    public View huv;
    public RelativeLayout huw;
    public TbImageView hux;
    public TextView huy;
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
                    if (af.this.huM != null) {
                        af.this.huM.b(af.this.huL);
                    }
                    if (view2 == af.this.huw) {
                        if (af.this.huI != null && !TextUtils.isEmpty(af.this.huI.bzD)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huI.bzD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huI.bzD));
                        }
                    } else if (view2 == af.this.huB) {
                        BdLog.e("link: " + af.this.huJ.bzD);
                        if (af.this.huJ != null && !TextUtils.isEmpty(af.this.huJ.bzD)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huJ.bzD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huJ.bzD));
                        }
                    } else if (view2 == af.this.huE && af.this.huK != null && !TextUtils.isEmpty(af.this.huK.bzD)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huK.bzD});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huK.bzD));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huM = aVar;
        this.huu = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.huv = view.findViewById(d.g.pb_list_item_top_line);
        this.huw = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.hux = (TbImageView) view.findViewById(d.g.top_code_img);
        this.huy = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.huz = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.huA = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.huB = (LinearLayout) view.findViewById(d.g.news_info);
        this.huC = (ImageView) view.findViewById(d.g.news_info_img);
        this.huD = (TextView) view.findViewById(d.g.news_info_text);
        this.huE = (LinearLayout) view.findViewById(d.g.game_info);
        this.huF = (ImageView) view.findViewById(d.g.game_info_img);
        this.huG = (TextView) view.findViewById(d.g.game_info_text);
        this.huH = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.dJa);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.huL = adVar;
            this.huI = adVar.hup;
            this.huJ = adVar.huq;
            this.huK = adVar.hur;
            if (this.huI != null) {
                this.hux.startLoad(this.huI.bzF, 10, false);
                this.huz.setText(this.huI.summary);
                this.huA.setText(this.huI.subtitle);
                this.huy.setText(this.huI.buttonText);
                com.baidu.tbadk.core.util.al.k(this.huy, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.huy, d.f.news_text_color_selector);
            } else {
                this.huw.setVisibility(8);
            }
            if (this.huJ != null) {
                this.huD.setText(this.huJ.summary);
                com.baidu.tbadk.core.util.al.k(this.huC, d.f.icon_frs_news);
            } else {
                this.huB.setVisibility(8);
                this.huD.setVisibility(8);
                this.huC.setVisibility(8);
            }
            if (this.huK != null) {
                this.huG.setText(this.huK.summary);
                com.baidu.tbadk.core.util.al.k(this.huF, d.f.icon_frs_game);
            } else {
                this.huE.setVisibility(8);
                this.huG.setVisibility(8);
                this.huG.setVisibility(8);
            }
            this.huu.setTag(adVar);
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
        this.huw.setOnClickListener(onClickListener);
        this.huB.setOnClickListener(onClickListener);
        this.huE.setOnClickListener(onClickListener);
    }
}

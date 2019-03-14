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
    View.OnClickListener dIW;
    public TextView huA;
    public View huB;
    private com.baidu.tbadk.core.data.ap huC;
    private com.baidu.tbadk.core.data.ap huD;
    private com.baidu.tbadk.core.data.ap huE;
    private ad huF;
    private a huG;
    public LinearLayout huo;
    public View hup;
    public RelativeLayout huq;
    public TbImageView hur;
    public TextView hus;
    public TextView hut;
    public TextView huu;
    public LinearLayout huv;
    public ImageView huw;
    public TextView hux;
    public LinearLayout huy;
    public ImageView huz;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dIW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cZ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (af.this.huG != null) {
                        af.this.huG.b(af.this.huF);
                    }
                    if (view2 == af.this.huq) {
                        if (af.this.huC != null && !TextUtils.isEmpty(af.this.huC.bzF)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huC.bzF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huC.bzF));
                        }
                    } else if (view2 == af.this.huv) {
                        BdLog.e("link: " + af.this.huD.bzF);
                        if (af.this.huD != null && !TextUtils.isEmpty(af.this.huD.bzF)) {
                            ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huD.bzF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huD.bzF));
                        }
                    } else if (view2 == af.this.huy && af.this.huE != null && !TextUtils.isEmpty(af.this.huE.bzF)) {
                        ba.adD().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.huE.bzF});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.huE.bzF));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.huG = aVar;
        this.huo = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.hup = view.findViewById(d.g.pb_list_item_top_line);
        this.huq = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.hur = (TbImageView) view.findViewById(d.g.top_code_img);
        this.hus = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.hut = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.huu = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.huv = (LinearLayout) view.findViewById(d.g.news_info);
        this.huw = (ImageView) view.findViewById(d.g.news_info_img);
        this.hux = (TextView) view.findViewById(d.g.news_info_text);
        this.huy = (LinearLayout) view.findViewById(d.g.game_info);
        this.huz = (ImageView) view.findViewById(d.g.game_info_img);
        this.huA = (TextView) view.findViewById(d.g.game_info_text);
        this.huB = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.dIW);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.huF = adVar;
            this.huC = adVar.huj;
            this.huD = adVar.huk;
            this.huE = adVar.hul;
            if (this.huC != null) {
                this.hur.startLoad(this.huC.bzH, 10, false);
                this.hut.setText(this.huC.summary);
                this.huu.setText(this.huC.subtitle);
                this.hus.setText(this.huC.buttonText);
                com.baidu.tbadk.core.util.al.k(this.hus, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.hus, d.f.news_text_color_selector);
            } else {
                this.huq.setVisibility(8);
            }
            if (this.huD != null) {
                this.hux.setText(this.huD.summary);
                com.baidu.tbadk.core.util.al.k(this.huw, d.f.icon_frs_news);
            } else {
                this.huv.setVisibility(8);
                this.hux.setVisibility(8);
                this.huw.setVisibility(8);
            }
            if (this.huE != null) {
                this.huA.setText(this.huE.summary);
                com.baidu.tbadk.core.util.al.k(this.huz, d.f.icon_frs_game);
            } else {
                this.huy.setVisibility(8);
                this.huA.setVisibility(8);
                this.huA.setVisibility(8);
            }
            this.huo.setTag(adVar);
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
        this.huq.setOnClickListener(onClickListener);
        this.huv.setOnClickListener(onClickListener);
        this.huy.setOnClickListener(onClickListener);
    }
}

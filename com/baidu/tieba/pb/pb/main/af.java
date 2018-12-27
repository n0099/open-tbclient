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
    View.OnClickListener cts;
    private com.baidu.tbadk.core.data.an gdA;
    private com.baidu.tbadk.core.data.an gdB;
    private com.baidu.tbadk.core.data.an gdC;
    public LinearLayout gdm;
    public View gdn;
    public RelativeLayout gdo;
    public TbImageView gdp;
    public TextView gdq;
    public TextView gdr;
    public TextView gds;
    public LinearLayout gdt;
    public ImageView gdu;
    public TextView gdv;
    public LinearLayout gdw;
    public ImageView gdx;
    public TextView gdy;
    public View gdz;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cts = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bJ(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ll()) {
                    if (view2 == af.this.gdo) {
                        if (af.this.gdA != null && !TextUtils.isEmpty(af.this.gdA.aso)) {
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gdA.aso});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gdA.aso));
                        }
                    } else if (view2 == af.this.gdt) {
                        BdLog.e("link: " + af.this.gdB.aso);
                        if (af.this.gdB != null && !TextUtils.isEmpty(af.this.gdB.aso)) {
                            ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gdB.aso});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gdB.aso));
                        }
                    } else if (view2 == af.this.gdw && af.this.gdC != null && !TextUtils.isEmpty(af.this.gdC.aso)) {
                        ay.Ef().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.gdC.aso});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.gdC.aso));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gdm = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.gdn = view.findViewById(e.g.pb_list_item_top_line);
        this.gdo = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.gdp = (TbImageView) view.findViewById(e.g.top_code_img);
        this.gdq = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.gdr = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.gds = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.gdt = (LinearLayout) view.findViewById(e.g.news_info);
        this.gdu = (ImageView) view.findViewById(e.g.news_info_img);
        this.gdv = (TextView) view.findViewById(e.g.news_info_text);
        this.gdw = (LinearLayout) view.findViewById(e.g.game_info);
        this.gdx = (ImageView) view.findViewById(e.g.game_info_img);
        this.gdy = (TextView) view.findViewById(e.g.game_info_text);
        this.gdz = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.cts);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.gdA = adVar.gdh;
            this.gdB = adVar.gdi;
            this.gdC = adVar.gdj;
            if (this.gdA != null) {
                this.gdp.startLoad(this.gdA.asq, 10, false);
                this.gdr.setText(this.gdA.summary);
                this.gds.setText(this.gdA.subtitle);
                this.gdq.setText(this.gdA.buttonText);
                com.baidu.tbadk.core.util.al.i(this.gdq, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.gdq, e.f.news_text_color_selector);
            } else {
                this.gdo.setVisibility(8);
            }
            if (this.gdB != null) {
                this.gdv.setText(this.gdB.summary);
                com.baidu.tbadk.core.util.al.i(this.gdu, e.f.icon_frs_news);
            } else {
                this.gdt.setVisibility(8);
                this.gdv.setVisibility(8);
                this.gdu.setVisibility(8);
            }
            if (this.gdC != null) {
                this.gdy.setText(this.gdC.summary);
                com.baidu.tbadk.core.util.al.i(this.gdx, e.f.icon_frs_game);
            } else {
                this.gdw.setVisibility(8);
                this.gdy.setVisibility(8);
                this.gdy.setVisibility(8);
            }
            this.gdm.setTag(adVar);
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
        this.gdo.setOnClickListener(onClickListener);
        this.gdt.setOnClickListener(onClickListener);
        this.gdw.setOnClickListener(onClickListener);
    }
}

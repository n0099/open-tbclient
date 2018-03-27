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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ae extends r.a {
    private TbPageContext aRI;
    View.OnClickListener cxY;
    public ImageView fSA;
    public TextView fSB;
    public View fSC;
    private com.baidu.tbadk.core.data.an fSD;
    private com.baidu.tbadk.core.data.an fSE;
    private com.baidu.tbadk.core.data.an fSF;
    public LinearLayout fSp;
    public View fSq;
    public RelativeLayout fSr;
    public TbImageView fSs;
    public TextView fSt;
    public TextView fSu;
    public TextView fSv;
    public LinearLayout fSw;
    public ImageView fSx;
    public TextView fSy;
    public LinearLayout fSz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cxY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ae.this.aRI.getPageActivity()) && com.baidu.adp.lib.util.l.pa()) {
                    if (view2 == ae.this.fSr) {
                        if (ae.this.fSD != null && !TextUtils.isEmpty(ae.this.fSD.aNq)) {
                            com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRI.getPageActivity()), new String[]{ae.this.fSD.aNq});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSD.aNq));
                        }
                    } else if (view2 == ae.this.fSw) {
                        BdLog.e("link: " + ae.this.fSE.aNq);
                        if (ae.this.fSE != null && !TextUtils.isEmpty(ae.this.fSE.aNq)) {
                            com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRI.getPageActivity()), new String[]{ae.this.fSE.aNq});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSE.aNq));
                        }
                    } else if (view2 == ae.this.fSz && ae.this.fSF != null && !TextUtils.isEmpty(ae.this.fSF.aNq)) {
                        com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRI.getPageActivity()), new String[]{ae.this.fSF.aNq});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSF.aNq));
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        this.fSp = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fSq = view.findViewById(d.g.pb_list_item_top_line);
        this.fSr = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fSs = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fSt = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fSu = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fSv = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fSw = (LinearLayout) view.findViewById(d.g.news_info);
        this.fSx = (ImageView) view.findViewById(d.g.news_info_img);
        this.fSy = (TextView) view.findViewById(d.g.news_info_text);
        this.fSz = (LinearLayout) view.findViewById(d.g.game_info);
        this.fSA = (ImageView) view.findViewById(d.g.game_info_img);
        this.fSB = (TextView) view.findViewById(d.g.game_info_text);
        this.fSC = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.cxY);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fSD = acVar.fSk;
            this.fSE = acVar.fSl;
            this.fSF = acVar.fSm;
            if (this.fSD != null) {
                this.fSs.startLoad(this.fSD.aNs, 10, false);
                this.fSu.setText(this.fSD.summary);
                this.fSv.setText(this.fSD.subtitle);
                this.fSt.setText(this.fSD.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fSt, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fSt, d.f.news_text_color_selector);
            } else {
                this.fSr.setVisibility(8);
            }
            if (this.fSE != null) {
                this.fSy.setText(this.fSE.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSx, d.f.icon_frs_news);
            } else {
                this.fSw.setVisibility(8);
                this.fSy.setVisibility(8);
                this.fSx.setVisibility(8);
            }
            if (this.fSF != null) {
                this.fSB.setText(this.fSF.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSA, d.f.icon_frs_game);
            } else {
                this.fSz.setVisibility(8);
                this.fSB.setVisibility(8);
                this.fSB.setVisibility(8);
            }
            this.fSp.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aRI.getLayoutMode().aQ(i == 1);
            this.aRI.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fSr.setOnClickListener(onClickListener);
        this.fSw.setOnClickListener(onClickListener);
        this.fSz.setOnClickListener(onClickListener);
    }
}

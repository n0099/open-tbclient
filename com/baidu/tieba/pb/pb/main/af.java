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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class af extends q.a {
    View.OnClickListener bZi;
    public LinearLayout fCN;
    public View fCO;
    public RelativeLayout fCP;
    public TbImageView fCQ;
    public TextView fCR;
    public TextView fCS;
    public TextView fCT;
    public LinearLayout fCU;
    public ImageView fCV;
    public TextView fCW;
    public LinearLayout fCX;
    public ImageView fCY;
    public TextView fCZ;
    public View fDa;
    private com.baidu.tbadk.core.data.ao fDb;
    private com.baidu.tbadk.core.data.ao fDc;
    private com.baidu.tbadk.core.data.ao fDd;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bZi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jU()) {
                    if (view2 == af.this.fCP) {
                        if (af.this.fDb != null && !TextUtils.isEmpty(af.this.fDb.ahl)) {
                            az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDb.ahl});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDb.ahl));
                        }
                    } else if (view2 == af.this.fCU) {
                        BdLog.e("link: " + af.this.fDc.ahl);
                        if (af.this.fDc != null && !TextUtils.isEmpty(af.this.fDc.ahl)) {
                            az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDc.ahl});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDc.ahl));
                        }
                    } else if (view2 == af.this.fCX && af.this.fDd != null && !TextUtils.isEmpty(af.this.fDd.ahl)) {
                        az.zV().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDd.ahl});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDd.ahl));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fCN = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fCO = view.findViewById(d.g.pb_list_item_top_line);
        this.fCP = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fCQ = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fCR = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fCS = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fCT = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fCU = (LinearLayout) view.findViewById(d.g.news_info);
        this.fCV = (ImageView) view.findViewById(d.g.news_info_img);
        this.fCW = (TextView) view.findViewById(d.g.news_info_text);
        this.fCX = (LinearLayout) view.findViewById(d.g.game_info);
        this.fCY = (ImageView) view.findViewById(d.g.game_info_img);
        this.fCZ = (TextView) view.findViewById(d.g.game_info_text);
        this.fDa = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bZi);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fDb = adVar.fCI;
            this.fDc = adVar.fCJ;
            this.fDd = adVar.fCK;
            if (this.fDb != null) {
                this.fCQ.startLoad(this.fDb.ahn, 10, false);
                this.fCS.setText(this.fDb.summary);
                this.fCT.setText(this.fDb.subtitle);
                this.fCR.setText(this.fDb.buttonText);
                com.baidu.tbadk.core.util.am.i(this.fCR, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.h(this.fCR, d.f.news_text_color_selector);
            } else {
                this.fCP.setVisibility(8);
            }
            if (this.fDc != null) {
                this.fCW.setText(this.fDc.summary);
                com.baidu.tbadk.core.util.am.i(this.fCV, d.f.icon_frs_news);
            } else {
                this.fCU.setVisibility(8);
                this.fCW.setVisibility(8);
                this.fCV.setVisibility(8);
            }
            if (this.fDd != null) {
                this.fCZ.setText(this.fDd.summary);
                com.baidu.tbadk.core.util.am.i(this.fCY, d.f.icon_frs_game);
            } else {
                this.fCX.setVisibility(8);
                this.fCZ.setVisibility(8);
                this.fCZ.setVisibility(8);
            }
            this.fCN.setTag(adVar);
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
        this.fCP.setOnClickListener(onClickListener);
        this.fCU.setOnClickListener(onClickListener);
        this.fCX.setOnClickListener(onClickListener);
    }
}

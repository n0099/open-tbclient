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
/* loaded from: classes2.dex */
public class af extends q.a {
    View.OnClickListener cgg;
    public LinearLayout fKD;
    public View fKE;
    public RelativeLayout fKF;
    public TbImageView fKG;
    public TextView fKH;
    public TextView fKI;
    public TextView fKJ;
    public LinearLayout fKK;
    public ImageView fKL;
    public TextView fKM;
    public LinearLayout fKN;
    public ImageView fKO;
    public TextView fKP;
    public View fKQ;
    private com.baidu.tbadk.core.data.an fKR;
    private com.baidu.tbadk.core.data.an fKS;
    private com.baidu.tbadk.core.data.an fKT;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bA(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lb()) {
                    if (view2 == af.this.fKF) {
                        if (af.this.fKR != null && !TextUtils.isEmpty(af.this.fKR.ajf)) {
                            ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fKR.ajf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fKR.ajf));
                        }
                    } else if (view2 == af.this.fKK) {
                        BdLog.e("link: " + af.this.fKS.ajf);
                        if (af.this.fKS != null && !TextUtils.isEmpty(af.this.fKS.ajf)) {
                            ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fKS.ajf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fKS.ajf));
                        }
                    } else if (view2 == af.this.fKN && af.this.fKT != null && !TextUtils.isEmpty(af.this.fKT.ajf)) {
                        ay.AN().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fKT.ajf});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fKT.ajf));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fKD = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.fKE = view.findViewById(e.g.pb_list_item_top_line);
        this.fKF = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.fKG = (TbImageView) view.findViewById(e.g.top_code_img);
        this.fKH = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.fKI = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.fKJ = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.fKK = (LinearLayout) view.findViewById(e.g.news_info);
        this.fKL = (ImageView) view.findViewById(e.g.news_info_img);
        this.fKM = (TextView) view.findViewById(e.g.news_info_text);
        this.fKN = (LinearLayout) view.findViewById(e.g.game_info);
        this.fKO = (ImageView) view.findViewById(e.g.game_info_img);
        this.fKP = (TextView) view.findViewById(e.g.game_info_text);
        this.fKQ = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.cgg);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fKR = adVar.fKy;
            this.fKS = adVar.fKz;
            this.fKT = adVar.fKA;
            if (this.fKR != null) {
                this.fKG.startLoad(this.fKR.ajh, 10, false);
                this.fKI.setText(this.fKR.summary);
                this.fKJ.setText(this.fKR.subtitle);
                this.fKH.setText(this.fKR.buttonText);
                com.baidu.tbadk.core.util.al.i(this.fKH, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.fKH, e.f.news_text_color_selector);
            } else {
                this.fKF.setVisibility(8);
            }
            if (this.fKS != null) {
                this.fKM.setText(this.fKS.summary);
                com.baidu.tbadk.core.util.al.i(this.fKL, e.f.icon_frs_news);
            } else {
                this.fKK.setVisibility(8);
                this.fKM.setVisibility(8);
                this.fKL.setVisibility(8);
            }
            if (this.fKT != null) {
                this.fKP.setText(this.fKT.summary);
                com.baidu.tbadk.core.util.al.i(this.fKO, e.f.icon_frs_game);
            } else {
                this.fKN.setVisibility(8);
                this.fKP.setVisibility(8);
                this.fKP.setVisibility(8);
            }
            this.fKD.setTag(adVar);
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
        this.fKF.setOnClickListener(onClickListener);
        this.fKK.setOnClickListener(onClickListener);
        this.fKN.setOnClickListener(onClickListener);
    }
}

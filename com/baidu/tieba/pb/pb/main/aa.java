package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class aa extends j.a {
    private TbPageContext abm;
    View.OnClickListener bwB;
    public TbImageView eHA;
    public TextView eHB;
    public TextView eHC;
    public TextView eHD;
    public LinearLayout eHE;
    public ImageView eHF;
    public TextView eHG;
    public LinearLayout eHH;
    public ImageView eHI;
    public TextView eHJ;
    public View eHK;
    private com.baidu.tbadk.core.data.ar eHL;
    private com.baidu.tbadk.core.data.ar eHM;
    private com.baidu.tbadk.core.data.ar eHN;
    public LinearLayout eHx;
    public View eHy;
    public RelativeLayout eHz;
    private int mSkinType;

    public aa(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(aa.this.abm.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == aa.this.eHz) {
                        if (aa.this.eHL != null && !TextUtils.isEmpty(aa.this.eHL.Xd)) {
                            av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abm.getPageActivity()), new String[]{aa.this.eHL.Xd});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eHL.Xd));
                        }
                    } else if (view2 == aa.this.eHE) {
                        BdLog.e("link: " + aa.this.eHM.Xd);
                        if (aa.this.eHM != null && !TextUtils.isEmpty(aa.this.eHM.Xd)) {
                            av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abm.getPageActivity()), new String[]{aa.this.eHM.Xd});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eHM.Xd));
                        }
                    } else if (view2 == aa.this.eHH && aa.this.eHN != null && !TextUtils.isEmpty(aa.this.eHN.Xd)) {
                        av.vA().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abm.getPageActivity()), new String[]{aa.this.eHN.Xd});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eHN.Xd));
                    }
                }
            }
        };
        this.abm = tbPageContext;
        this.eHx = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eHy = view.findViewById(d.h.pb_list_item_top_line);
        this.eHz = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eHA = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eHB = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eHC = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eHD = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eHE = (LinearLayout) view.findViewById(d.h.news_info);
        this.eHF = (ImageView) view.findViewById(d.h.news_info_img);
        this.eHG = (TextView) view.findViewById(d.h.news_info_text);
        this.eHH = (LinearLayout) view.findViewById(d.h.game_info);
        this.eHI = (ImageView) view.findViewById(d.h.game_info_img);
        this.eHJ = (TextView) view.findViewById(d.h.game_info_text);
        this.eHK = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.bwB);
    }

    public void a(y yVar) {
        if (yVar != null) {
            this.eHL = yVar.eHs;
            this.eHM = yVar.eHt;
            this.eHN = yVar.eHu;
            if (this.eHL != null) {
                this.eHA.c(this.eHL.Xf, 10, false);
                this.eHC.setText(this.eHL.summary);
                this.eHD.setText(this.eHL.subtitle);
                this.eHB.setText(this.eHL.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eHB, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eHB, d.g.news_text_color_selector);
            } else {
                this.eHz.setVisibility(8);
            }
            if (this.eHM != null) {
                this.eHG.setText(this.eHM.summary);
                com.baidu.tbadk.core.util.aj.j(this.eHF, d.g.icon_frs_news);
            } else {
                this.eHE.setVisibility(8);
                this.eHG.setVisibility(8);
                this.eHF.setVisibility(8);
            }
            if (this.eHN != null) {
                this.eHJ.setText(this.eHN.summary);
                com.baidu.tbadk.core.util.aj.j(this.eHI, d.g.icon_frs_game);
            } else {
                this.eHH.setVisibility(8);
                this.eHJ.setVisibility(8);
                this.eHJ.setVisibility(8);
            }
            this.eHx.setTag(yVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.abm.getLayoutMode().ah(i == 1);
            this.abm.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eHz.setOnClickListener(onClickListener);
        this.eHE.setOnClickListener(onClickListener);
        this.eHH.setOnClickListener(onClickListener);
    }
}

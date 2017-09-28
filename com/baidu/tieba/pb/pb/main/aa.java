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
    private TbPageContext abz;
    View.OnClickListener bwN;
    public LinearLayout eHL;
    public View eHM;
    public RelativeLayout eHN;
    public TbImageView eHO;
    public TextView eHP;
    public TextView eHQ;
    public TextView eHR;
    public LinearLayout eHS;
    public ImageView eHT;
    public TextView eHU;
    public LinearLayout eHV;
    public ImageView eHW;
    public TextView eHX;
    public View eHY;
    private com.baidu.tbadk.core.data.ar eHZ;
    private com.baidu.tbadk.core.data.ar eIa;
    private com.baidu.tbadk.core.data.ar eIb;
    private int mSkinType;

    public aa(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aa.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aU(aa.this.abz.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == aa.this.eHN) {
                        if (aa.this.eHZ != null && !TextUtils.isEmpty(aa.this.eHZ.Xp)) {
                            av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abz.getPageActivity()), new String[]{aa.this.eHZ.Xp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eHZ.Xp));
                        }
                    } else if (view2 == aa.this.eHS) {
                        BdLog.e("link: " + aa.this.eIa.Xp);
                        if (aa.this.eIa != null && !TextUtils.isEmpty(aa.this.eIa.Xp)) {
                            av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abz.getPageActivity()), new String[]{aa.this.eIa.Xp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eIa.Xp));
                        }
                    } else if (view2 == aa.this.eHV && aa.this.eIb != null && !TextUtils.isEmpty(aa.this.eIb.Xp)) {
                        av.vH().c((TbPageContext) com.baidu.adp.base.i.Y(aa.this.abz.getPageActivity()), new String[]{aa.this.eIb.Xp});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ad(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, aa.this.eIb.Xp));
                    }
                }
            }
        };
        this.abz = tbPageContext;
        this.eHL = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eHM = view.findViewById(d.h.pb_list_item_top_line);
        this.eHN = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eHO = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eHP = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eHQ = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eHR = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eHS = (LinearLayout) view.findViewById(d.h.news_info);
        this.eHT = (ImageView) view.findViewById(d.h.news_info_img);
        this.eHU = (TextView) view.findViewById(d.h.news_info_text);
        this.eHV = (LinearLayout) view.findViewById(d.h.game_info);
        this.eHW = (ImageView) view.findViewById(d.h.game_info_img);
        this.eHX = (TextView) view.findViewById(d.h.game_info_text);
        this.eHY = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.bwN);
    }

    public void a(y yVar) {
        if (yVar != null) {
            this.eHZ = yVar.eHG;
            this.eIa = yVar.eHH;
            this.eIb = yVar.eHI;
            if (this.eHZ != null) {
                this.eHO.c(this.eHZ.Xr, 10, false);
                this.eHQ.setText(this.eHZ.summary);
                this.eHR.setText(this.eHZ.subtitle);
                this.eHP.setText(this.eHZ.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eHP, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eHP, d.g.news_text_color_selector);
            } else {
                this.eHN.setVisibility(8);
            }
            if (this.eIa != null) {
                this.eHU.setText(this.eIa.summary);
                com.baidu.tbadk.core.util.aj.j(this.eHT, d.g.icon_frs_news);
            } else {
                this.eHS.setVisibility(8);
                this.eHU.setVisibility(8);
                this.eHT.setVisibility(8);
            }
            if (this.eIb != null) {
                this.eHX.setText(this.eIb.summary);
                com.baidu.tbadk.core.util.aj.j(this.eHW, d.g.icon_frs_game);
            } else {
                this.eHV.setVisibility(8);
                this.eHX.setVisibility(8);
                this.eHX.setVisibility(8);
            }
            this.eHL.setTag(yVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.abz.getLayoutMode().ai(i == 1);
            this.abz.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eHN.setOnClickListener(onClickListener);
        this.eHS.setOnClickListener(onClickListener);
        this.eHV.setOnClickListener(onClickListener);
    }
}

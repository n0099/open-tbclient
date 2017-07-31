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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ab extends j.a {
    private TbPageContext acp;
    View.OnClickListener btm;
    public LinearLayout eMO;
    public View eMP;
    public RelativeLayout eMQ;
    public TbImageView eMR;
    public TextView eMS;
    public TextView eMT;
    public TextView eMU;
    public LinearLayout eMV;
    public ImageView eMW;
    public TextView eMX;
    public LinearLayout eMY;
    public ImageView eMZ;
    public TextView eNa;
    public View eNb;
    private com.baidu.tbadk.core.data.at eNc;
    private com.baidu.tbadk.core.data.at eNd;
    private com.baidu.tbadk.core.data.at eNe;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.btm = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(ab.this.acp.getPageActivity()) && com.baidu.adp.lib.util.k.hI()) {
                    if (view2 == ab.this.eMQ) {
                        if (ab.this.eNc != null && !TextUtils.isEmpty(ab.this.eNc.Yd)) {
                            com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acp.getPageActivity()), new String[]{ab.this.eNc.Yd});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11410").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNc.Yd));
                        }
                    } else if (view2 == ab.this.eMV) {
                        BdLog.e("link: " + ab.this.eNd.Yd);
                        if (ab.this.eNd != null && !TextUtils.isEmpty(ab.this.eNd.Yd)) {
                            com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acp.getPageActivity()), new String[]{ab.this.eNd.Yd});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11409").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNd.Yd));
                        }
                    } else if (view2 == ab.this.eMY && ab.this.eNe != null && !TextUtils.isEmpty(ab.this.eNe.Yd)) {
                        com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acp.getPageActivity()), new String[]{ab.this.eNe.Yd});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11408").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eNe.Yd));
                    }
                }
            }
        };
        this.acp = tbPageContext;
        this.eMO = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eMP = view.findViewById(d.h.pb_list_item_top_line);
        this.eMQ = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eMR = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eMS = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eMT = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eMU = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eMV = (LinearLayout) view.findViewById(d.h.news_info);
        this.eMW = (ImageView) view.findViewById(d.h.news_info_img);
        this.eMX = (TextView) view.findViewById(d.h.news_info_text);
        this.eMY = (LinearLayout) view.findViewById(d.h.game_info);
        this.eMZ = (ImageView) view.findViewById(d.h.game_info_img);
        this.eNa = (TextView) view.findViewById(d.h.game_info_text);
        this.eNb = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.btm);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eNc = zVar.eMJ;
            this.eNd = zVar.eMK;
            this.eNe = zVar.eML;
            if (this.eNc != null) {
                this.eMR.c(this.eNc.Yf, 10, false);
                this.eMT.setText(this.eNc.summary);
                this.eMU.setText(this.eNc.subtitle);
                this.eMS.setText(this.eNc.buttonText);
                com.baidu.tbadk.core.util.ai.j(this.eMS, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.ai.i(this.eMS, d.g.news_text_color_selector);
            } else {
                this.eMQ.setVisibility(8);
            }
            if (this.eNd != null) {
                this.eMX.setText(this.eNd.summary);
                com.baidu.tbadk.core.util.ai.j(this.eMW, d.g.icon_frs_news);
            } else {
                this.eMV.setVisibility(8);
                this.eMX.setVisibility(8);
                this.eMW.setVisibility(8);
            }
            if (this.eNe != null) {
                this.eNa.setText(this.eNe.summary);
                com.baidu.tbadk.core.util.ai.j(this.eMZ, d.g.icon_frs_game);
            } else {
                this.eMY.setVisibility(8);
                this.eNa.setVisibility(8);
                this.eNa.setVisibility(8);
            }
            this.eMO.setTag(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.acp.getLayoutMode().ah(i == 1);
            this.acp.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eMQ.setOnClickListener(onClickListener);
        this.eMV.setOnClickListener(onClickListener);
        this.eMY.setOnClickListener(onClickListener);
    }
}

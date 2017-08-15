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
    private TbPageContext acr;
    View.OnClickListener btC;
    public LinearLayout eOI;
    public View eOJ;
    public RelativeLayout eOK;
    public TbImageView eOL;
    public TextView eOM;
    public TextView eON;
    public TextView eOO;
    public LinearLayout eOP;
    public ImageView eOQ;
    public TextView eOR;
    public LinearLayout eOS;
    public ImageView eOT;
    public TextView eOU;
    public View eOV;
    private com.baidu.tbadk.core.data.at eOW;
    private com.baidu.tbadk.core.data.at eOX;
    private com.baidu.tbadk.core.data.at eOY;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.btC = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(ab.this.acr.getPageActivity()) && com.baidu.adp.lib.util.k.hI()) {
                    if (view2 == ab.this.eOK) {
                        if (ab.this.eOW != null && !TextUtils.isEmpty(ab.this.eOW.Yf)) {
                            com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.eOW.Yf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11410").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOW.Yf));
                        }
                    } else if (view2 == ab.this.eOP) {
                        BdLog.e("link: " + ab.this.eOX.Yf);
                        if (ab.this.eOX != null && !TextUtils.isEmpty(ab.this.eOX.Yf)) {
                            com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.eOX.Yf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11409").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOX.Yf));
                        }
                    } else if (view2 == ab.this.eOS && ab.this.eOY != null && !TextUtils.isEmpty(ab.this.eOY.Yf)) {
                        com.baidu.tbadk.core.util.at.wf().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.eOY.Yf});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11408").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOY.Yf));
                    }
                }
            }
        };
        this.acr = tbPageContext;
        this.eOI = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eOJ = view.findViewById(d.h.pb_list_item_top_line);
        this.eOK = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eOL = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eOM = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eON = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eOO = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eOP = (LinearLayout) view.findViewById(d.h.news_info);
        this.eOQ = (ImageView) view.findViewById(d.h.news_info_img);
        this.eOR = (TextView) view.findViewById(d.h.news_info_text);
        this.eOS = (LinearLayout) view.findViewById(d.h.game_info);
        this.eOT = (ImageView) view.findViewById(d.h.game_info_img);
        this.eOU = (TextView) view.findViewById(d.h.game_info_text);
        this.eOV = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.btC);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eOW = zVar.eOD;
            this.eOX = zVar.eOE;
            this.eOY = zVar.eOF;
            if (this.eOW != null) {
                this.eOL.c(this.eOW.Yh, 10, false);
                this.eON.setText(this.eOW.summary);
                this.eOO.setText(this.eOW.subtitle);
                this.eOM.setText(this.eOW.buttonText);
                com.baidu.tbadk.core.util.ai.j(this.eOM, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.ai.i(this.eOM, d.g.news_text_color_selector);
            } else {
                this.eOK.setVisibility(8);
            }
            if (this.eOX != null) {
                this.eOR.setText(this.eOX.summary);
                com.baidu.tbadk.core.util.ai.j(this.eOQ, d.g.icon_frs_news);
            } else {
                this.eOP.setVisibility(8);
                this.eOR.setVisibility(8);
                this.eOQ.setVisibility(8);
            }
            if (this.eOY != null) {
                this.eOU.setText(this.eOY.summary);
                com.baidu.tbadk.core.util.ai.j(this.eOT, d.g.icon_frs_game);
            } else {
                this.eOS.setVisibility(8);
                this.eOU.setVisibility(8);
                this.eOU.setVisibility(8);
            }
            this.eOI.setTag(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.acr.getLayoutMode().ah(i == 1);
            this.acr.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eOK.setOnClickListener(onClickListener);
        this.eOP.setOnClickListener(onClickListener);
        this.eOS.setOnClickListener(onClickListener);
    }
}

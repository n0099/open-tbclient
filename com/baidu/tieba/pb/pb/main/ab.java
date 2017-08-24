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
    View.OnClickListener btD;
    public LinearLayout eOK;
    public View eOL;
    public RelativeLayout eOM;
    public TbImageView eON;
    public TextView eOO;
    public TextView eOP;
    public TextView eOQ;
    public LinearLayout eOR;
    public ImageView eOS;
    public TextView eOT;
    public LinearLayout eOU;
    public ImageView eOV;
    public TextView eOW;
    public View eOX;
    private com.baidu.tbadk.core.data.at eOY;
    private com.baidu.tbadk.core.data.at eOZ;
    private com.baidu.tbadk.core.data.at ePa;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.btD = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aO(ab.this.acr.getPageActivity()) && com.baidu.adp.lib.util.k.hI()) {
                    if (view2 == ab.this.eOM) {
                        if (ab.this.eOY != null && !TextUtils.isEmpty(ab.this.eOY.Yg)) {
                            com.baidu.tbadk.core.util.at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.eOY.Yg});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11410").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOY.Yg));
                        }
                    } else if (view2 == ab.this.eOR) {
                        BdLog.e("link: " + ab.this.eOZ.Yg);
                        if (ab.this.eOZ != null && !TextUtils.isEmpty(ab.this.eOZ.Yg)) {
                            com.baidu.tbadk.core.util.at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.eOZ.Yg});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11409").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eOZ.Yg));
                        }
                    } else if (view2 == ab.this.eOU && ab.this.ePa != null && !TextUtils.isEmpty(ab.this.ePa.Yg)) {
                        com.baidu.tbadk.core.util.at.wg().c((TbPageContext) com.baidu.adp.base.i.aa(ab.this.acr.getPageActivity()), new String[]{ab.this.ePa.Yg});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11408").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.ePa.Yg));
                    }
                }
            }
        };
        this.acr = tbPageContext;
        this.eOK = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eOL = view.findViewById(d.h.pb_list_item_top_line);
        this.eOM = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eON = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eOO = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eOP = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eOQ = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eOR = (LinearLayout) view.findViewById(d.h.news_info);
        this.eOS = (ImageView) view.findViewById(d.h.news_info_img);
        this.eOT = (TextView) view.findViewById(d.h.news_info_text);
        this.eOU = (LinearLayout) view.findViewById(d.h.game_info);
        this.eOV = (ImageView) view.findViewById(d.h.game_info_img);
        this.eOW = (TextView) view.findViewById(d.h.game_info_text);
        this.eOX = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.btD);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eOY = zVar.eOF;
            this.eOZ = zVar.eOG;
            this.ePa = zVar.eOH;
            if (this.eOY != null) {
                this.eON.c(this.eOY.Yi, 10, false);
                this.eOP.setText(this.eOY.summary);
                this.eOQ.setText(this.eOY.subtitle);
                this.eOO.setText(this.eOY.buttonText);
                com.baidu.tbadk.core.util.ai.j(this.eOO, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.ai.i(this.eOO, d.g.news_text_color_selector);
            } else {
                this.eOM.setVisibility(8);
            }
            if (this.eOZ != null) {
                this.eOT.setText(this.eOZ.summary);
                com.baidu.tbadk.core.util.ai.j(this.eOS, d.g.icon_frs_news);
            } else {
                this.eOR.setVisibility(8);
                this.eOT.setVisibility(8);
                this.eOS.setVisibility(8);
            }
            if (this.ePa != null) {
                this.eOW.setText(this.ePa.summary);
                com.baidu.tbadk.core.util.ai.j(this.eOV, d.g.icon_frs_game);
            } else {
                this.eOU.setVisibility(8);
                this.eOW.setVisibility(8);
                this.eOW.setVisibility(8);
            }
            this.eOK.setTag(zVar);
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
        this.eOM.setOnClickListener(onClickListener);
        this.eOR.setOnClickListener(onClickListener);
        this.eOU.setOnClickListener(onClickListener);
    }
}

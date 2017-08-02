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
    private TbPageContext aaS;
    View.OnClickListener bsc;
    public LinearLayout eLB;
    public View eLC;
    public RelativeLayout eLD;
    public TbImageView eLE;
    public TextView eLF;
    public TextView eLG;
    public TextView eLH;
    public LinearLayout eLI;
    public ImageView eLJ;
    public TextView eLK;
    public LinearLayout eLL;
    public ImageView eLM;
    public TextView eLN;
    public View eLO;
    private com.baidu.tbadk.core.data.at eLP;
    private com.baidu.tbadk.core.data.at eLQ;
    private com.baidu.tbadk.core.data.at eLR;
    private int mSkinType;

    public ab(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bsc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ab.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aw.aN(ab.this.aaS.getPageActivity()) && com.baidu.adp.lib.util.k.hy()) {
                    if (view2 == ab.this.eLD) {
                        if (ab.this.eLP != null && !TextUtils.isEmpty(ab.this.eLP.WH)) {
                            com.baidu.tbadk.core.util.at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ab.this.aaS.getPageActivity()), new String[]{ab.this.eLP.WH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11410").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eLP.WH));
                        }
                    } else if (view2 == ab.this.eLI) {
                        BdLog.e("link: " + ab.this.eLQ.WH);
                        if (ab.this.eLQ != null && !TextUtils.isEmpty(ab.this.eLQ.WH)) {
                            com.baidu.tbadk.core.util.at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ab.this.aaS.getPageActivity()), new String[]{ab.this.eLQ.WH});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11409").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eLQ.WH));
                        }
                    } else if (view2 == ab.this.eLL && ab.this.eLR != null && !TextUtils.isEmpty(ab.this.eLR.WH)) {
                        com.baidu.tbadk.core.util.at.vV().c((TbPageContext) com.baidu.adp.base.i.Z(ab.this.aaS.getPageActivity()), new String[]{ab.this.eLR.WH});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11408").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ab.this.eLR.WH));
                    }
                }
            }
        };
        this.aaS = tbPageContext;
        this.eLB = (LinearLayout) view.findViewById(d.h.pb_news_info_layout);
        this.eLC = view.findViewById(d.h.pb_list_item_top_line);
        this.eLD = (RelativeLayout) view.findViewById(d.h.pb_top_code);
        this.eLE = (TbImageView) view.findViewById(d.h.top_code_img);
        this.eLF = (TextView) view.findViewById(d.h.top_code_get_btn);
        this.eLG = (TextView) view.findViewById(d.h.top_code_detail_summary_text);
        this.eLH = (TextView) view.findViewById(d.h.top_code_detail_subtitle_text);
        this.eLI = (LinearLayout) view.findViewById(d.h.news_info);
        this.eLJ = (ImageView) view.findViewById(d.h.news_info_img);
        this.eLK = (TextView) view.findViewById(d.h.news_info_text);
        this.eLL = (LinearLayout) view.findViewById(d.h.game_info);
        this.eLM = (ImageView) view.findViewById(d.h.game_info_img);
        this.eLN = (TextView) view.findViewById(d.h.game_info_text);
        this.eLO = view.findViewById(d.h.pb_news_info_divider);
        setOnClickListener(this.bsc);
    }

    public void a(z zVar) {
        if (zVar != null) {
            this.eLP = zVar.eLw;
            this.eLQ = zVar.eLx;
            this.eLR = zVar.eLy;
            if (this.eLP != null) {
                this.eLE.c(this.eLP.WJ, 10, false);
                this.eLG.setText(this.eLP.summary);
                this.eLH.setText(this.eLP.subtitle);
                this.eLF.setText(this.eLP.buttonText);
                com.baidu.tbadk.core.util.ai.j(this.eLF, d.g.selector_star_btn_like);
                com.baidu.tbadk.core.util.ai.i(this.eLF, d.g.news_text_color_selector);
            } else {
                this.eLD.setVisibility(8);
            }
            if (this.eLQ != null) {
                this.eLK.setText(this.eLQ.summary);
                com.baidu.tbadk.core.util.ai.j(this.eLJ, d.g.icon_frs_news);
            } else {
                this.eLI.setVisibility(8);
                this.eLK.setVisibility(8);
                this.eLJ.setVisibility(8);
            }
            if (this.eLR != null) {
                this.eLN.setText(this.eLR.summary);
                com.baidu.tbadk.core.util.ai.j(this.eLM, d.g.icon_frs_game);
            } else {
                this.eLL.setVisibility(8);
                this.eLN.setVisibility(8);
                this.eLN.setVisibility(8);
            }
            this.eLB.setTag(zVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aaS.getLayoutMode().ah(i == 1);
            this.aaS.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eLD.setOnClickListener(onClickListener);
        this.eLI.setOnClickListener(onClickListener);
        this.eLL.setOnClickListener(onClickListener);
    }
}

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
    View.OnClickListener coU;
    public LinearLayout fTE;
    public View fTF;
    public RelativeLayout fTG;
    public TbImageView fTH;
    public TextView fTI;
    public TextView fTJ;
    public TextView fTK;
    public LinearLayout fTL;
    public ImageView fTM;
    public TextView fTN;
    public LinearLayout fTO;
    public ImageView fTP;
    public TextView fTQ;
    public View fTR;
    private com.baidu.tbadk.core.data.an fTS;
    private com.baidu.tbadk.core.data.an fTT;
    private com.baidu.tbadk.core.data.an fTU;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bG(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lm()) {
                    if (view2 == af.this.fTG) {
                        if (af.this.fTS != null && !TextUtils.isEmpty(af.this.fTS.aoN)) {
                            ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fTS.aoN});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fTS.aoN));
                        }
                    } else if (view2 == af.this.fTL) {
                        BdLog.e("link: " + af.this.fTT.aoN);
                        if (af.this.fTT != null && !TextUtils.isEmpty(af.this.fTT.aoN)) {
                            ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fTT.aoN});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fTT.aoN));
                        }
                    } else if (view2 == af.this.fTO && af.this.fTU != null && !TextUtils.isEmpty(af.this.fTU.aoN)) {
                        ay.Db().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fTU.aoN});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fTU.aoN));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fTE = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.fTF = view.findViewById(e.g.pb_list_item_top_line);
        this.fTG = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.fTH = (TbImageView) view.findViewById(e.g.top_code_img);
        this.fTI = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.fTJ = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.fTK = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.fTL = (LinearLayout) view.findViewById(e.g.news_info);
        this.fTM = (ImageView) view.findViewById(e.g.news_info_img);
        this.fTN = (TextView) view.findViewById(e.g.news_info_text);
        this.fTO = (LinearLayout) view.findViewById(e.g.game_info);
        this.fTP = (ImageView) view.findViewById(e.g.game_info_img);
        this.fTQ = (TextView) view.findViewById(e.g.game_info_text);
        this.fTR = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.coU);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fTS = adVar.fTz;
            this.fTT = adVar.fTA;
            this.fTU = adVar.fTB;
            if (this.fTS != null) {
                this.fTH.startLoad(this.fTS.aoP, 10, false);
                this.fTJ.setText(this.fTS.summary);
                this.fTK.setText(this.fTS.subtitle);
                this.fTI.setText(this.fTS.buttonText);
                com.baidu.tbadk.core.util.al.i(this.fTI, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.fTI, e.f.news_text_color_selector);
            } else {
                this.fTG.setVisibility(8);
            }
            if (this.fTT != null) {
                this.fTN.setText(this.fTT.summary);
                com.baidu.tbadk.core.util.al.i(this.fTM, e.f.icon_frs_news);
            } else {
                this.fTL.setVisibility(8);
                this.fTN.setVisibility(8);
                this.fTM.setVisibility(8);
            }
            if (this.fTU != null) {
                this.fTQ.setText(this.fTU.summary);
                com.baidu.tbadk.core.util.al.i(this.fTP, e.f.icon_frs_game);
            } else {
                this.fTO.setVisibility(8);
                this.fTQ.setVisibility(8);
                this.fTQ.setVisibility(8);
            }
            this.fTE.setTag(adVar);
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
        this.fTG.setOnClickListener(onClickListener);
        this.fTL.setOnClickListener(onClickListener);
        this.fTO.setOnClickListener(onClickListener);
    }
}

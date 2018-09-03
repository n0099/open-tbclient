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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class af extends q.a {
    View.OnClickListener caq;
    public LinearLayout fCT;
    public View fCU;
    public RelativeLayout fCV;
    public TbImageView fCW;
    public TextView fCX;
    public TextView fCY;
    public TextView fCZ;
    public LinearLayout fDa;
    public ImageView fDb;
    public TextView fDc;
    public LinearLayout fDd;
    public ImageView fDe;
    public TextView fDf;
    public View fDg;
    private com.baidu.tbadk.core.data.an fDh;
    private com.baidu.tbadk.core.data.an fDi;
    private com.baidu.tbadk.core.data.an fDj;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bb.aU(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jV()) {
                    if (view2 == af.this.fCV) {
                        if (af.this.fDh != null && !TextUtils.isEmpty(af.this.fDh.agF)) {
                            az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDh.agF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDh.agF));
                        }
                    } else if (view2 == af.this.fDa) {
                        BdLog.e("link: " + af.this.fDi.agF);
                        if (af.this.fDi != null && !TextUtils.isEmpty(af.this.fDi.agF)) {
                            az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDi.agF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDi.agF));
                        }
                    } else if (view2 == af.this.fDd && af.this.fDj != null && !TextUtils.isEmpty(af.this.fDj.agF)) {
                        az.zI().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDj.agF});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDj.agF));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fCT = (LinearLayout) view.findViewById(f.g.pb_news_info_layout);
        this.fCU = view.findViewById(f.g.pb_list_item_top_line);
        this.fCV = (RelativeLayout) view.findViewById(f.g.pb_top_code);
        this.fCW = (TbImageView) view.findViewById(f.g.top_code_img);
        this.fCX = (TextView) view.findViewById(f.g.top_code_get_btn);
        this.fCY = (TextView) view.findViewById(f.g.top_code_detail_summary_text);
        this.fCZ = (TextView) view.findViewById(f.g.top_code_detail_subtitle_text);
        this.fDa = (LinearLayout) view.findViewById(f.g.news_info);
        this.fDb = (ImageView) view.findViewById(f.g.news_info_img);
        this.fDc = (TextView) view.findViewById(f.g.news_info_text);
        this.fDd = (LinearLayout) view.findViewById(f.g.game_info);
        this.fDe = (ImageView) view.findViewById(f.g.game_info_img);
        this.fDf = (TextView) view.findViewById(f.g.game_info_text);
        this.fDg = view.findViewById(f.g.pb_news_info_divider);
        setOnClickListener(this.caq);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fDh = adVar.fCO;
            this.fDi = adVar.fCP;
            this.fDj = adVar.fCQ;
            if (this.fDh != null) {
                this.fCW.startLoad(this.fDh.agH, 10, false);
                this.fCY.setText(this.fDh.summary);
                this.fCZ.setText(this.fDh.subtitle);
                this.fCX.setText(this.fDh.buttonText);
                com.baidu.tbadk.core.util.am.i(this.fCX, f.C0146f.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.h(this.fCX, f.C0146f.news_text_color_selector);
            } else {
                this.fCV.setVisibility(8);
            }
            if (this.fDi != null) {
                this.fDc.setText(this.fDi.summary);
                com.baidu.tbadk.core.util.am.i(this.fDb, f.C0146f.icon_frs_news);
            } else {
                this.fDa.setVisibility(8);
                this.fDc.setVisibility(8);
                this.fDb.setVisibility(8);
            }
            if (this.fDj != null) {
                this.fDf.setText(this.fDj.summary);
                com.baidu.tbadk.core.util.am.i(this.fDe, f.C0146f.icon_frs_game);
            } else {
                this.fDd.setVisibility(8);
                this.fDf.setVisibility(8);
                this.fDf.setVisibility(8);
            }
            this.fCT.setTag(adVar);
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
        this.fCV.setOnClickListener(onClickListener);
        this.fDa.setOnClickListener(onClickListener);
        this.fDd.setOnClickListener(onClickListener);
    }
}

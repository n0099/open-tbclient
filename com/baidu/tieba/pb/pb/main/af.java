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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class af extends q.a {
    View.OnClickListener cas;
    public LinearLayout fDa;
    public View fDb;
    public RelativeLayout fDc;
    public TbImageView fDd;
    public TextView fDe;
    public TextView fDf;
    public TextView fDg;
    public LinearLayout fDh;
    public ImageView fDi;
    public TextView fDj;
    public LinearLayout fDk;
    public ImageView fDl;
    public TextView fDm;
    public View fDn;
    private com.baidu.tbadk.core.data.an fDo;
    private com.baidu.tbadk.core.data.an fDp;
    private com.baidu.tbadk.core.data.an fDq;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.aV(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.jV()) {
                    if (view2 == af.this.fDc) {
                        if (af.this.fDo != null && !TextUtils.isEmpty(af.this.fDo.agF)) {
                            com.baidu.tbadk.core.util.ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDo.agF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDo.agF));
                        }
                    } else if (view2 == af.this.fDh) {
                        BdLog.e("link: " + af.this.fDp.agF);
                        if (af.this.fDp != null && !TextUtils.isEmpty(af.this.fDp.agF)) {
                            com.baidu.tbadk.core.util.ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDp.agF});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDp.agF));
                        }
                    } else if (view2 == af.this.fDk && af.this.fDq != null && !TextUtils.isEmpty(af.this.fDq.agF)) {
                        com.baidu.tbadk.core.util.ay.zK().c((TbPageContext) com.baidu.adp.base.i.ad(af.this.mContext.getPageActivity()), new String[]{af.this.fDq.agF});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fDq.agF));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fDa = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fDb = view.findViewById(d.g.pb_list_item_top_line);
        this.fDc = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fDd = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fDe = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fDf = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fDg = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fDh = (LinearLayout) view.findViewById(d.g.news_info);
        this.fDi = (ImageView) view.findViewById(d.g.news_info_img);
        this.fDj = (TextView) view.findViewById(d.g.news_info_text);
        this.fDk = (LinearLayout) view.findViewById(d.g.game_info);
        this.fDl = (ImageView) view.findViewById(d.g.game_info_img);
        this.fDm = (TextView) view.findViewById(d.g.game_info_text);
        this.fDn = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.cas);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fDo = adVar.fCV;
            this.fDp = adVar.fCW;
            this.fDq = adVar.fCX;
            if (this.fDo != null) {
                this.fDd.startLoad(this.fDo.agH, 10, false);
                this.fDf.setText(this.fDo.summary);
                this.fDg.setText(this.fDo.subtitle);
                this.fDe.setText(this.fDo.buttonText);
                com.baidu.tbadk.core.util.am.i(this.fDe, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.h(this.fDe, d.f.news_text_color_selector);
            } else {
                this.fDc.setVisibility(8);
            }
            if (this.fDp != null) {
                this.fDj.setText(this.fDp.summary);
                com.baidu.tbadk.core.util.am.i(this.fDi, d.f.icon_frs_news);
            } else {
                this.fDh.setVisibility(8);
                this.fDj.setVisibility(8);
                this.fDi.setVisibility(8);
            }
            if (this.fDq != null) {
                this.fDm.setText(this.fDq.summary);
                com.baidu.tbadk.core.util.am.i(this.fDl, d.f.icon_frs_game);
            } else {
                this.fDk.setVisibility(8);
                this.fDm.setVisibility(8);
                this.fDm.setVisibility(8);
            }
            this.fDa.setTag(adVar);
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
        this.fDc.setOnClickListener(onClickListener);
        this.fDh.setOnClickListener(onClickListener);
        this.fDk.setOnClickListener(onClickListener);
    }
}

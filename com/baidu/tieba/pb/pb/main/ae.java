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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ae extends q.a {
    View.OnClickListener bOY;
    public ImageView fnA;
    public TextView fnB;
    public LinearLayout fnC;
    public ImageView fnD;
    public TextView fnE;
    public View fnF;
    private com.baidu.tbadk.core.data.ao fnG;
    private com.baidu.tbadk.core.data.ao fnH;
    private com.baidu.tbadk.core.data.ao fnI;
    public LinearLayout fns;
    public View fnt;
    public RelativeLayout fnu;
    public TbImageView fnv;
    public TextView fnw;
    public TextView fnx;
    public TextView fny;
    public LinearLayout fnz;
    private TbPageContext mContext;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.bOY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ae.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.hg()) {
                    if (view3 == ae.this.fnu) {
                        if (ae.this.fnG != null && !TextUtils.isEmpty(ae.this.fnG.YR)) {
                            com.baidu.tbadk.core.util.ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.mContext.getPageActivity()), new String[]{ae.this.fnG.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fnG.YR));
                        }
                    } else if (view3 == ae.this.fnz) {
                        BdLog.e("link: " + ae.this.fnH.YR);
                        if (ae.this.fnH != null && !TextUtils.isEmpty(ae.this.fnH.YR)) {
                            com.baidu.tbadk.core.util.ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.mContext.getPageActivity()), new String[]{ae.this.fnH.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fnH.YR));
                        }
                    } else if (view3 == ae.this.fnC && ae.this.fnI != null && !TextUtils.isEmpty(ae.this.fnI.YR)) {
                        com.baidu.tbadk.core.util.ax.wf().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.mContext.getPageActivity()), new String[]{ae.this.fnI.YR});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fnI.YR));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fns = (LinearLayout) view2.findViewById(d.g.pb_news_info_layout);
        this.fnt = view2.findViewById(d.g.pb_list_item_top_line);
        this.fnu = (RelativeLayout) view2.findViewById(d.g.pb_top_code);
        this.fnv = (TbImageView) view2.findViewById(d.g.top_code_img);
        this.fnw = (TextView) view2.findViewById(d.g.top_code_get_btn);
        this.fnx = (TextView) view2.findViewById(d.g.top_code_detail_summary_text);
        this.fny = (TextView) view2.findViewById(d.g.top_code_detail_subtitle_text);
        this.fnz = (LinearLayout) view2.findViewById(d.g.news_info);
        this.fnA = (ImageView) view2.findViewById(d.g.news_info_img);
        this.fnB = (TextView) view2.findViewById(d.g.news_info_text);
        this.fnC = (LinearLayout) view2.findViewById(d.g.game_info);
        this.fnD = (ImageView) view2.findViewById(d.g.game_info_img);
        this.fnE = (TextView) view2.findViewById(d.g.game_info_text);
        this.fnF = view2.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bOY);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fnG = acVar.fnn;
            this.fnH = acVar.fno;
            this.fnI = acVar.fnp;
            if (this.fnG != null) {
                this.fnv.startLoad(this.fnG.YT, 10, false);
                this.fnx.setText(this.fnG.summary);
                this.fny.setText(this.fnG.subtitle);
                this.fnw.setText(this.fnG.buttonText);
                com.baidu.tbadk.core.util.ak.i(this.fnw, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.ak.h(this.fnw, d.f.news_text_color_selector);
            } else {
                this.fnu.setVisibility(8);
            }
            if (this.fnH != null) {
                this.fnB.setText(this.fnH.summary);
                com.baidu.tbadk.core.util.ak.i(this.fnA, d.f.icon_frs_news);
            } else {
                this.fnz.setVisibility(8);
                this.fnB.setVisibility(8);
                this.fnA.setVisibility(8);
            }
            if (this.fnI != null) {
                this.fnE.setText(this.fnI.summary);
                com.baidu.tbadk.core.util.ak.i(this.fnD, d.f.icon_frs_game);
            } else {
                this.fnC.setVisibility(8);
                this.fnE.setVisibility(8);
                this.fnE.setVisibility(8);
            }
            this.fns.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().u(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fnu.setOnClickListener(onClickListener);
        this.fnz.setOnClickListener(onClickListener);
        this.fnC.setOnClickListener(onClickListener);
    }
}

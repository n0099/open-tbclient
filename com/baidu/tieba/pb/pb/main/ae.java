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
    private TbPageContext adf;
    View.OnClickListener bOj;
    public TextView fmA;
    public View fmB;
    private com.baidu.tbadk.core.data.ao fmC;
    private com.baidu.tbadk.core.data.ao fmD;
    private com.baidu.tbadk.core.data.ao fmE;
    public LinearLayout fmo;
    public View fmp;
    public RelativeLayout fmq;
    public TbImageView fmr;
    public TextView fms;
    public TextView fmt;
    public TextView fmu;
    public LinearLayout fmv;
    public ImageView fmw;
    public TextView fmx;
    public LinearLayout fmy;
    public ImageView fmz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ae.this.adf.getPageActivity()) && com.baidu.adp.lib.util.l.hg()) {
                    if (view3 == ae.this.fmq) {
                        if (ae.this.fmC != null && !TextUtils.isEmpty(ae.this.fmC.YR)) {
                            com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmC.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmC.YR));
                        }
                    } else if (view3 == ae.this.fmv) {
                        BdLog.e("link: " + ae.this.fmD.YR);
                        if (ae.this.fmD != null && !TextUtils.isEmpty(ae.this.fmD.YR)) {
                            com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmD.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmD.YR));
                        }
                    } else if (view3 == ae.this.fmy && ae.this.fmE != null && !TextUtils.isEmpty(ae.this.fmE.YR)) {
                        com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmE.YR});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmE.YR));
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fmo = (LinearLayout) view2.findViewById(d.g.pb_news_info_layout);
        this.fmp = view2.findViewById(d.g.pb_list_item_top_line);
        this.fmq = (RelativeLayout) view2.findViewById(d.g.pb_top_code);
        this.fmr = (TbImageView) view2.findViewById(d.g.top_code_img);
        this.fms = (TextView) view2.findViewById(d.g.top_code_get_btn);
        this.fmt = (TextView) view2.findViewById(d.g.top_code_detail_summary_text);
        this.fmu = (TextView) view2.findViewById(d.g.top_code_detail_subtitle_text);
        this.fmv = (LinearLayout) view2.findViewById(d.g.news_info);
        this.fmw = (ImageView) view2.findViewById(d.g.news_info_img);
        this.fmx = (TextView) view2.findViewById(d.g.news_info_text);
        this.fmy = (LinearLayout) view2.findViewById(d.g.game_info);
        this.fmz = (ImageView) view2.findViewById(d.g.game_info_img);
        this.fmA = (TextView) view2.findViewById(d.g.game_info_text);
        this.fmB = view2.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bOj);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fmC = acVar.fmj;
            this.fmD = acVar.fmk;
            this.fmE = acVar.fml;
            if (this.fmC != null) {
                this.fmr.startLoad(this.fmC.YT, 10, false);
                this.fmt.setText(this.fmC.summary);
                this.fmu.setText(this.fmC.subtitle);
                this.fms.setText(this.fmC.buttonText);
                com.baidu.tbadk.core.util.ak.i(this.fms, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.ak.h(this.fms, d.f.news_text_color_selector);
            } else {
                this.fmq.setVisibility(8);
            }
            if (this.fmD != null) {
                this.fmx.setText(this.fmD.summary);
                com.baidu.tbadk.core.util.ak.i(this.fmw, d.f.icon_frs_news);
            } else {
                this.fmv.setVisibility(8);
                this.fmx.setVisibility(8);
                this.fmw.setVisibility(8);
            }
            if (this.fmE != null) {
                this.fmA.setText(this.fmE.summary);
                com.baidu.tbadk.core.util.ak.i(this.fmz, d.f.icon_frs_game);
            } else {
                this.fmy.setVisibility(8);
                this.fmA.setVisibility(8);
                this.fmA.setVisibility(8);
            }
            this.fmo.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.adf.getLayoutMode().setNightMode(i == 1);
            this.adf.getLayoutMode().u(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fmq.setOnClickListener(onClickListener);
        this.fmv.setOnClickListener(onClickListener);
        this.fmy.setOnClickListener(onClickListener);
    }
}

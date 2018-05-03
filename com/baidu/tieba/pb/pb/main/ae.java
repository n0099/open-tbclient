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
    View.OnClickListener bOi;
    private com.baidu.tbadk.core.data.ao fmA;
    private com.baidu.tbadk.core.data.ao fmB;
    public LinearLayout fml;
    public View fmm;
    public RelativeLayout fmn;
    public TbImageView fmo;
    public TextView fmp;
    public TextView fmq;
    public TextView fmr;
    public LinearLayout fms;
    public ImageView fmt;
    public TextView fmu;
    public LinearLayout fmv;
    public ImageView fmw;
    public TextView fmx;
    public View fmy;
    private com.baidu.tbadk.core.data.ao fmz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view2) {
        super(view2);
        this.mSkinType = 3;
        this.bOi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (az.aK(ae.this.adf.getPageActivity()) && com.baidu.adp.lib.util.l.hg()) {
                    if (view3 == ae.this.fmn) {
                        if (ae.this.fmz != null && !TextUtils.isEmpty(ae.this.fmz.YR)) {
                            com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmz.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmz.YR));
                        }
                    } else if (view3 == ae.this.fms) {
                        BdLog.e("link: " + ae.this.fmA.YR);
                        if (ae.this.fmA != null && !TextUtils.isEmpty(ae.this.fmA.YR)) {
                            com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmA.YR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmA.YR));
                        }
                    } else if (view3 == ae.this.fmv && ae.this.fmB != null && !TextUtils.isEmpty(ae.this.fmB.YR)) {
                        com.baidu.tbadk.core.util.ax.wg().c((TbPageContext) com.baidu.adp.base.i.ab(ae.this.adf.getPageActivity()), new String[]{ae.this.fmB.YR});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.al("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fmB.YR));
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fml = (LinearLayout) view2.findViewById(d.g.pb_news_info_layout);
        this.fmm = view2.findViewById(d.g.pb_list_item_top_line);
        this.fmn = (RelativeLayout) view2.findViewById(d.g.pb_top_code);
        this.fmo = (TbImageView) view2.findViewById(d.g.top_code_img);
        this.fmp = (TextView) view2.findViewById(d.g.top_code_get_btn);
        this.fmq = (TextView) view2.findViewById(d.g.top_code_detail_summary_text);
        this.fmr = (TextView) view2.findViewById(d.g.top_code_detail_subtitle_text);
        this.fms = (LinearLayout) view2.findViewById(d.g.news_info);
        this.fmt = (ImageView) view2.findViewById(d.g.news_info_img);
        this.fmu = (TextView) view2.findViewById(d.g.news_info_text);
        this.fmv = (LinearLayout) view2.findViewById(d.g.game_info);
        this.fmw = (ImageView) view2.findViewById(d.g.game_info_img);
        this.fmx = (TextView) view2.findViewById(d.g.game_info_text);
        this.fmy = view2.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.bOi);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fmz = acVar.fmg;
            this.fmA = acVar.fmh;
            this.fmB = acVar.fmi;
            if (this.fmz != null) {
                this.fmo.startLoad(this.fmz.YT, 10, false);
                this.fmq.setText(this.fmz.summary);
                this.fmr.setText(this.fmz.subtitle);
                this.fmp.setText(this.fmz.buttonText);
                com.baidu.tbadk.core.util.ak.i(this.fmp, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.ak.h(this.fmp, d.f.news_text_color_selector);
            } else {
                this.fmn.setVisibility(8);
            }
            if (this.fmA != null) {
                this.fmu.setText(this.fmA.summary);
                com.baidu.tbadk.core.util.ak.i(this.fmt, d.f.icon_frs_news);
            } else {
                this.fms.setVisibility(8);
                this.fmu.setVisibility(8);
                this.fmt.setVisibility(8);
            }
            if (this.fmB != null) {
                this.fmx.setText(this.fmB.summary);
                com.baidu.tbadk.core.util.ak.i(this.fmw, d.f.icon_frs_game);
            } else {
                this.fmv.setVisibility(8);
                this.fmx.setVisibility(8);
                this.fmx.setVisibility(8);
            }
            this.fml.setTag(acVar);
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
        this.fmn.setOnClickListener(onClickListener);
        this.fms.setOnClickListener(onClickListener);
        this.fmv.setOnClickListener(onClickListener);
    }
}

package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class ae extends r.a {
    private TbPageContext aRR;
    View.OnClickListener cyh;
    private com.baidu.tbadk.core.data.an fSA;
    public LinearLayout fSk;
    public View fSl;
    public RelativeLayout fSm;
    public TbImageView fSn;
    public TextView fSo;
    public TextView fSp;
    public TextView fSq;
    public LinearLayout fSr;
    public ImageView fSs;
    public TextView fSt;
    public LinearLayout fSu;
    public ImageView fSv;
    public TextView fSw;
    public View fSx;
    private com.baidu.tbadk.core.data.an fSy;
    private com.baidu.tbadk.core.data.an fSz;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ae.this.aRR.getPageActivity()) && com.baidu.adp.lib.util.l.pa()) {
                    if (view2 == ae.this.fSm) {
                        if (ae.this.fSy != null && !TextUtils.isEmpty(ae.this.fSy.aNA)) {
                            com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRR.getPageActivity()), new String[]{ae.this.fSy.aNA});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSy.aNA));
                        }
                    } else if (view2 == ae.this.fSr) {
                        BdLog.e("link: " + ae.this.fSz.aNA);
                        if (ae.this.fSz != null && !TextUtils.isEmpty(ae.this.fSz.aNA)) {
                            com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRR.getPageActivity()), new String[]{ae.this.fSz.aNA});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSz.aNA));
                        }
                    } else if (view2 == ae.this.fSu && ae.this.fSA != null && !TextUtils.isEmpty(ae.this.fSA.aNA)) {
                        com.baidu.tbadk.core.util.aw.Du().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRR.getPageActivity()), new String[]{ae.this.fSA.aNA});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSA.aNA));
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.fSk = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fSl = view.findViewById(d.g.pb_list_item_top_line);
        this.fSm = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fSn = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fSo = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fSp = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fSq = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fSr = (LinearLayout) view.findViewById(d.g.news_info);
        this.fSs = (ImageView) view.findViewById(d.g.news_info_img);
        this.fSt = (TextView) view.findViewById(d.g.news_info_text);
        this.fSu = (LinearLayout) view.findViewById(d.g.game_info);
        this.fSv = (ImageView) view.findViewById(d.g.game_info_img);
        this.fSw = (TextView) view.findViewById(d.g.game_info_text);
        this.fSx = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.cyh);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fSy = acVar.fSf;
            this.fSz = acVar.fSg;
            this.fSA = acVar.fSh;
            if (this.fSy != null) {
                this.fSn.startLoad(this.fSy.aNC, 10, false);
                this.fSp.setText(this.fSy.summary);
                this.fSq.setText(this.fSy.subtitle);
                this.fSo.setText(this.fSy.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fSo, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fSo, d.f.news_text_color_selector);
            } else {
                this.fSm.setVisibility(8);
            }
            if (this.fSz != null) {
                this.fSt.setText(this.fSz.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSs, d.f.icon_frs_news);
            } else {
                this.fSr.setVisibility(8);
                this.fSt.setVisibility(8);
                this.fSs.setVisibility(8);
            }
            if (this.fSA != null) {
                this.fSw.setText(this.fSA.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSv, d.f.icon_frs_game);
            } else {
                this.fSu.setVisibility(8);
                this.fSw.setVisibility(8);
                this.fSw.setVisibility(8);
            }
            this.fSk.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aRR.getLayoutMode().aQ(i == 1);
            this.aRR.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fSm.setOnClickListener(onClickListener);
        this.fSr.setOnClickListener(onClickListener);
        this.fSu.setOnClickListener(onClickListener);
    }
}

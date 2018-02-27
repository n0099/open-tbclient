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
    private TbPageContext aRG;
    View.OnClickListener cxV;
    public LinearLayout fRZ;
    public View fSa;
    public RelativeLayout fSb;
    public TbImageView fSc;
    public TextView fSd;
    public TextView fSe;
    public TextView fSf;
    public LinearLayout fSg;
    public ImageView fSh;
    public TextView fSi;
    public LinearLayout fSj;
    public ImageView fSk;
    public TextView fSl;
    public View fSm;
    private com.baidu.tbadk.core.data.an fSn;
    private com.baidu.tbadk.core.data.an fSo;
    private com.baidu.tbadk.core.data.an fSp;
    private int mSkinType;

    public ae(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ae.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ay.ba(ae.this.aRG.getPageActivity()) && com.baidu.adp.lib.util.l.pa()) {
                    if (view2 == ae.this.fSb) {
                        if (ae.this.fSn != null && !TextUtils.isEmpty(ae.this.fSn.aNp)) {
                            com.baidu.tbadk.core.util.aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRG.getPageActivity()), new String[]{ae.this.fSn.aNp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSn.aNp));
                        }
                    } else if (view2 == ae.this.fSg) {
                        BdLog.e("link: " + ae.this.fSo.aNp);
                        if (ae.this.fSo != null && !TextUtils.isEmpty(ae.this.fSo.aNp)) {
                            com.baidu.tbadk.core.util.aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRG.getPageActivity()), new String[]{ae.this.fSo.aNp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSo.aNp));
                        }
                    } else if (view2 == ae.this.fSj && ae.this.fSp != null && !TextUtils.isEmpty(ae.this.fSp.aNp)) {
                        com.baidu.tbadk.core.util.aw.Dt().c((TbPageContext) com.baidu.adp.base.i.ak(ae.this.aRG.getPageActivity()), new String[]{ae.this.fSp.aNp});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ae.this.fSp.aNp));
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        this.fRZ = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.fSa = view.findViewById(d.g.pb_list_item_top_line);
        this.fSb = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.fSc = (TbImageView) view.findViewById(d.g.top_code_img);
        this.fSd = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.fSe = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.fSf = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.fSg = (LinearLayout) view.findViewById(d.g.news_info);
        this.fSh = (ImageView) view.findViewById(d.g.news_info_img);
        this.fSi = (TextView) view.findViewById(d.g.news_info_text);
        this.fSj = (LinearLayout) view.findViewById(d.g.game_info);
        this.fSk = (ImageView) view.findViewById(d.g.game_info_img);
        this.fSl = (TextView) view.findViewById(d.g.game_info_text);
        this.fSm = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.cxV);
    }

    public void a(ac acVar) {
        if (acVar != null) {
            this.fSn = acVar.fRU;
            this.fSo = acVar.fRV;
            this.fSp = acVar.fRW;
            if (this.fSn != null) {
                this.fSc.startLoad(this.fSn.aNr, 10, false);
                this.fSe.setText(this.fSn.summary);
                this.fSf.setText(this.fSn.subtitle);
                this.fSd.setText(this.fSn.buttonText);
                com.baidu.tbadk.core.util.aj.s(this.fSd, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.r(this.fSd, d.f.news_text_color_selector);
            } else {
                this.fSb.setVisibility(8);
            }
            if (this.fSo != null) {
                this.fSi.setText(this.fSo.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSh, d.f.icon_frs_news);
            } else {
                this.fSg.setVisibility(8);
                this.fSi.setVisibility(8);
                this.fSh.setVisibility(8);
            }
            if (this.fSp != null) {
                this.fSl.setText(this.fSp.summary);
                com.baidu.tbadk.core.util.aj.s(this.fSk, d.f.icon_frs_game);
            } else {
                this.fSj.setVisibility(8);
                this.fSl.setVisibility(8);
                this.fSl.setVisibility(8);
            }
            this.fRZ.setTag(acVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.aRG.getLayoutMode().aQ(i == 1);
            this.aRG.getLayoutMode().aM(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.fSb.setOnClickListener(onClickListener);
        this.fSg.setOnClickListener(onClickListener);
        this.fSj.setOnClickListener(onClickListener);
    }
}

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
    View.OnClickListener coI;
    public LinearLayout fSe;
    public View fSf;
    public RelativeLayout fSg;
    public TbImageView fSh;
    public TextView fSi;
    public TextView fSj;
    public TextView fSk;
    public LinearLayout fSl;
    public ImageView fSm;
    public TextView fSn;
    public LinearLayout fSo;
    public ImageView fSp;
    public TextView fSq;
    public View fSr;
    private com.baidu.tbadk.core.data.an fSs;
    private com.baidu.tbadk.core.data.an fSt;
    private com.baidu.tbadk.core.data.an fSu;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bI(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (view2 == af.this.fSg) {
                        if (af.this.fSs != null && !TextUtils.isEmpty(af.this.fSs.aoa)) {
                            ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSs.aoa});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSs.aoa));
                        }
                    } else if (view2 == af.this.fSl) {
                        BdLog.e("link: " + af.this.fSt.aoa);
                        if (af.this.fSt != null && !TextUtils.isEmpty(af.this.fSt.aoa)) {
                            ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSt.aoa});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSt.aoa));
                        }
                    } else if (view2 == af.this.fSo && af.this.fSu != null && !TextUtils.isEmpty(af.this.fSu.aoa)) {
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSu.aoa});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSu.aoa));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fSe = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.fSf = view.findViewById(e.g.pb_list_item_top_line);
        this.fSg = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.fSh = (TbImageView) view.findViewById(e.g.top_code_img);
        this.fSi = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.fSj = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.fSk = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.fSl = (LinearLayout) view.findViewById(e.g.news_info);
        this.fSm = (ImageView) view.findViewById(e.g.news_info_img);
        this.fSn = (TextView) view.findViewById(e.g.news_info_text);
        this.fSo = (LinearLayout) view.findViewById(e.g.game_info);
        this.fSp = (ImageView) view.findViewById(e.g.game_info_img);
        this.fSq = (TextView) view.findViewById(e.g.game_info_text);
        this.fSr = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.coI);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fSs = adVar.fRZ;
            this.fSt = adVar.fSa;
            this.fSu = adVar.fSb;
            if (this.fSs != null) {
                this.fSh.startLoad(this.fSs.aoc, 10, false);
                this.fSj.setText(this.fSs.summary);
                this.fSk.setText(this.fSs.subtitle);
                this.fSi.setText(this.fSs.buttonText);
                com.baidu.tbadk.core.util.al.i(this.fSi, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.fSi, e.f.news_text_color_selector);
            } else {
                this.fSg.setVisibility(8);
            }
            if (this.fSt != null) {
                this.fSn.setText(this.fSt.summary);
                com.baidu.tbadk.core.util.al.i(this.fSm, e.f.icon_frs_news);
            } else {
                this.fSl.setVisibility(8);
                this.fSn.setVisibility(8);
                this.fSm.setVisibility(8);
            }
            if (this.fSu != null) {
                this.fSq.setText(this.fSu.summary);
                com.baidu.tbadk.core.util.al.i(this.fSp, e.f.icon_frs_game);
            } else {
                this.fSo.setVisibility(8);
                this.fSq.setVisibility(8);
                this.fSq.setVisibility(8);
            }
            this.fSe.setTag(adVar);
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
        this.fSg.setOnClickListener(onClickListener);
        this.fSl.setOnClickListener(onClickListener);
        this.fSo.setOnClickListener(onClickListener);
    }
}

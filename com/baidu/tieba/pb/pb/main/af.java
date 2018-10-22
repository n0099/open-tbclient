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
    public LinearLayout fSf;
    public View fSg;
    public RelativeLayout fSh;
    public TbImageView fSi;
    public TextView fSj;
    public TextView fSk;
    public TextView fSl;
    public LinearLayout fSm;
    public ImageView fSn;
    public TextView fSo;
    public LinearLayout fSp;
    public ImageView fSq;
    public TextView fSr;
    public View fSs;
    private com.baidu.tbadk.core.data.an fSt;
    private com.baidu.tbadk.core.data.an fSu;
    private com.baidu.tbadk.core.data.an fSv;
    private TbPageContext mContext;
    private int mSkinType;

    public af(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ba.bI(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.lo()) {
                    if (view2 == af.this.fSh) {
                        if (af.this.fSt != null && !TextUtils.isEmpty(af.this.fSt.aoa)) {
                            ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSt.aoa});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSt.aoa));
                        }
                    } else if (view2 == af.this.fSm) {
                        BdLog.e("link: " + af.this.fSu.aoa);
                        if (af.this.fSu != null && !TextUtils.isEmpty(af.this.fSu.aoa)) {
                            ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSu.aoa});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSu.aoa));
                        }
                    } else if (view2 == af.this.fSp && af.this.fSv != null && !TextUtils.isEmpty(af.this.fSv.aoa)) {
                        ay.CU().c((TbPageContext) com.baidu.adp.base.i.aK(af.this.mContext.getPageActivity()), new String[]{af.this.fSv.aoa});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.fSv.aoa));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fSf = (LinearLayout) view.findViewById(e.g.pb_news_info_layout);
        this.fSg = view.findViewById(e.g.pb_list_item_top_line);
        this.fSh = (RelativeLayout) view.findViewById(e.g.pb_top_code);
        this.fSi = (TbImageView) view.findViewById(e.g.top_code_img);
        this.fSj = (TextView) view.findViewById(e.g.top_code_get_btn);
        this.fSk = (TextView) view.findViewById(e.g.top_code_detail_summary_text);
        this.fSl = (TextView) view.findViewById(e.g.top_code_detail_subtitle_text);
        this.fSm = (LinearLayout) view.findViewById(e.g.news_info);
        this.fSn = (ImageView) view.findViewById(e.g.news_info_img);
        this.fSo = (TextView) view.findViewById(e.g.news_info_text);
        this.fSp = (LinearLayout) view.findViewById(e.g.game_info);
        this.fSq = (ImageView) view.findViewById(e.g.game_info_img);
        this.fSr = (TextView) view.findViewById(e.g.game_info_text);
        this.fSs = view.findViewById(e.g.pb_news_info_divider);
        setOnClickListener(this.coI);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.fSt = adVar.fSa;
            this.fSu = adVar.fSb;
            this.fSv = adVar.fSc;
            if (this.fSt != null) {
                this.fSi.startLoad(this.fSt.aoc, 10, false);
                this.fSk.setText(this.fSt.summary);
                this.fSl.setText(this.fSt.subtitle);
                this.fSj.setText(this.fSt.buttonText);
                com.baidu.tbadk.core.util.al.i(this.fSj, e.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.h(this.fSj, e.f.news_text_color_selector);
            } else {
                this.fSh.setVisibility(8);
            }
            if (this.fSu != null) {
                this.fSo.setText(this.fSu.summary);
                com.baidu.tbadk.core.util.al.i(this.fSn, e.f.icon_frs_news);
            } else {
                this.fSm.setVisibility(8);
                this.fSo.setVisibility(8);
                this.fSn.setVisibility(8);
            }
            if (this.fSv != null) {
                this.fSr.setText(this.fSv.summary);
                com.baidu.tbadk.core.util.al.i(this.fSq, e.f.icon_frs_game);
            } else {
                this.fSp.setVisibility(8);
                this.fSr.setVisibility(8);
                this.fSr.setVisibility(8);
            }
            this.fSf.setTag(adVar);
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
        this.fSh.setOnClickListener(onClickListener);
        this.fSm.setOnClickListener(onClickListener);
        this.fSp.setOnClickListener(onClickListener);
    }
}

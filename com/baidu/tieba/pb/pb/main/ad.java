package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ad extends v.a {
    View.OnClickListener auX;
    private TbPageContext cVh;
    private com.baidu.tbadk.core.data.as iMA;
    private com.baidu.tbadk.core.data.as iMB;
    private com.baidu.tbadk.core.data.as iMC;
    private ab iMD;
    private a iME;
    public LinearLayout iMm;
    public View iMn;
    public RelativeLayout iMo;
    public TbImageView iMp;
    public TextView iMq;
    public TextView iMr;
    public TextView iMs;
    public LinearLayout iMt;
    public ImageView iMu;
    public TextView iMv;
    public LinearLayout iMw;
    public ImageView iMx;
    public TextView iMy;
    public View iMz;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ab abVar);
    }

    public ad(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.auX = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ad.this.cVh.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.iME != null) {
                        ad.this.iME.b(ad.this.iMD);
                    }
                    if (view2 == ad.this.iMo) {
                        if (ad.this.iMA != null && !TextUtils.isEmpty(ad.this.iMA.cPS)) {
                            ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVh.getPageActivity()), new String[]{ad.this.iMA.cPS});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cy("obj_source", ad.this.iMA.cPS));
                        }
                    } else if (view2 == ad.this.iMt) {
                        BdLog.e("link: " + ad.this.iMB.cPS);
                        if (ad.this.iMB != null && !TextUtils.isEmpty(ad.this.iMB.cPS)) {
                            ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVh.getPageActivity()), new String[]{ad.this.iMB.cPS});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cy("obj_source", ad.this.iMB.cPS));
                        }
                    } else if (view2 == ad.this.iMw && ad.this.iMC != null && !TextUtils.isEmpty(ad.this.iMC.cPS)) {
                        ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVh.getPageActivity()), new String[]{ad.this.iMC.cPS});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cy("obj_source", ad.this.iMC.cPS));
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.iME = aVar;
        this.iMm = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iMn = view.findViewById(R.id.pb_list_item_top_line);
        this.iMo = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iMp = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iMq = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iMr = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iMs = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iMt = (LinearLayout) view.findViewById(R.id.news_info);
        this.iMu = (ImageView) view.findViewById(R.id.news_info_img);
        this.iMv = (TextView) view.findViewById(R.id.news_info_text);
        this.iMw = (LinearLayout) view.findViewById(R.id.game_info);
        this.iMx = (ImageView) view.findViewById(R.id.game_info_img);
        this.iMy = (TextView) view.findViewById(R.id.game_info_text);
        this.iMz = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.auX);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.iMD = abVar;
            this.iMA = abVar.iMj;
            this.iMB = abVar.iMk;
            this.iMC = abVar.iMl;
            if (this.iMA != null) {
                this.iMp.startLoad(this.iMA.cPT, 10, false);
                this.iMr.setText(this.iMA.summary);
                this.iMs.setText(this.iMA.subtitle);
                this.iMq.setText(this.iMA.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMq, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iMq, (int) R.drawable.news_text_color_selector);
            } else {
                this.iMo.setVisibility(8);
            }
            if (this.iMB != null) {
                this.iMv.setText(this.iMB.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMu, R.drawable.icon_frs_news);
            } else {
                this.iMt.setVisibility(8);
                this.iMv.setVisibility(8);
                this.iMu.setVisibility(8);
            }
            if (this.iMC != null) {
                this.iMy.setText(this.iMC.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMx, R.drawable.icon_frs_game);
            } else {
                this.iMw.setVisibility(8);
                this.iMy.setVisibility(8);
                this.iMy.setVisibility(8);
            }
            this.iMm.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cVh.getLayoutMode().setNightMode(i == 1);
            this.cVh.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMo.setOnClickListener(onClickListener);
        this.iMt.setOnClickListener(onClickListener);
        this.iMw.setOnClickListener(onClickListener);
    }
}

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
    private TbPageContext cVg;
    private com.baidu.tbadk.core.data.as iMA;
    private ab iMB;
    private a iMC;
    public LinearLayout iMk;
    public View iMl;
    public RelativeLayout iMm;
    public TbImageView iMn;
    public TextView iMo;
    public TextView iMp;
    public TextView iMq;
    public LinearLayout iMr;
    public ImageView iMs;
    public TextView iMt;
    public LinearLayout iMu;
    public ImageView iMv;
    public TextView iMw;
    public View iMx;
    private com.baidu.tbadk.core.data.as iMy;
    private com.baidu.tbadk.core.data.as iMz;
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
                if (bc.checkUpIsLogin(ad.this.cVg.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.iMC != null) {
                        ad.this.iMC.b(ad.this.iMB);
                    }
                    if (view2 == ad.this.iMm) {
                        if (ad.this.iMy != null && !TextUtils.isEmpty(ad.this.iMy.cPR)) {
                            ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVg.getPageActivity()), new String[]{ad.this.iMy.cPR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cy("obj_source", ad.this.iMy.cPR));
                        }
                    } else if (view2 == ad.this.iMr) {
                        BdLog.e("link: " + ad.this.iMz.cPR);
                        if (ad.this.iMz != null && !TextUtils.isEmpty(ad.this.iMz.cPR)) {
                            ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVg.getPageActivity()), new String[]{ad.this.iMz.cPR});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cy("obj_source", ad.this.iMz.cPR));
                        }
                    } else if (view2 == ad.this.iMu && ad.this.iMA != null && !TextUtils.isEmpty(ad.this.iMA.cPR)) {
                        ba.aGE().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVg.getPageActivity()), new String[]{ad.this.iMA.cPR});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cy("obj_source", ad.this.iMA.cPR));
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.iMC = aVar;
        this.iMk = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iMl = view.findViewById(R.id.pb_list_item_top_line);
        this.iMm = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iMn = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iMo = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iMp = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iMq = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iMr = (LinearLayout) view.findViewById(R.id.news_info);
        this.iMs = (ImageView) view.findViewById(R.id.news_info_img);
        this.iMt = (TextView) view.findViewById(R.id.news_info_text);
        this.iMu = (LinearLayout) view.findViewById(R.id.game_info);
        this.iMv = (ImageView) view.findViewById(R.id.game_info_img);
        this.iMw = (TextView) view.findViewById(R.id.game_info_text);
        this.iMx = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.auX);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.iMB = abVar;
            this.iMy = abVar.iMh;
            this.iMz = abVar.iMi;
            this.iMA = abVar.iMj;
            if (this.iMy != null) {
                this.iMn.startLoad(this.iMy.cPS, 10, false);
                this.iMp.setText(this.iMy.summary);
                this.iMq.setText(this.iMy.subtitle);
                this.iMo.setText(this.iMy.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMo, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iMo, (int) R.drawable.news_text_color_selector);
            } else {
                this.iMm.setVisibility(8);
            }
            if (this.iMz != null) {
                this.iMt.setText(this.iMz.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMs, R.drawable.icon_frs_news);
            } else {
                this.iMr.setVisibility(8);
                this.iMt.setVisibility(8);
                this.iMs.setVisibility(8);
            }
            if (this.iMA != null) {
                this.iMw.setText(this.iMA.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMv, R.drawable.icon_frs_game);
            } else {
                this.iMu.setVisibility(8);
                this.iMw.setVisibility(8);
                this.iMw.setVisibility(8);
            }
            this.iMk.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cVg.getLayoutMode().setNightMode(i == 1);
            this.cVg.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMm.setOnClickListener(onClickListener);
        this.iMr.setOnClickListener(onClickListener);
        this.iMu.setOnClickListener(onClickListener);
    }
}

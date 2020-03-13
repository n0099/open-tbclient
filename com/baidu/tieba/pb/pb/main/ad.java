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
    View.OnClickListener auY;
    private TbPageContext cVi;
    public RelativeLayout iMA;
    public TbImageView iMB;
    public TextView iMC;
    public TextView iMD;
    public TextView iME;
    public LinearLayout iMF;
    public ImageView iMG;
    public TextView iMH;
    public LinearLayout iMI;
    public ImageView iMJ;
    public TextView iMK;
    public View iML;
    private com.baidu.tbadk.core.data.as iMM;
    private com.baidu.tbadk.core.data.as iMN;
    private com.baidu.tbadk.core.data.as iMO;
    private ab iMP;
    private a iMQ;
    public LinearLayout iMy;
    public View iMz;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ab abVar);
    }

    public ad(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.auY = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ad.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ad.this.cVi.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ad.this.iMQ != null) {
                        ad.this.iMQ.b(ad.this.iMP);
                    }
                    if (view2 == ad.this.iMA) {
                        if (ad.this.iMM != null && !TextUtils.isEmpty(ad.this.iMM.cPT)) {
                            ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVi.getPageActivity()), new String[]{ad.this.iMM.cPT});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cy("obj_source", ad.this.iMM.cPT));
                        }
                    } else if (view2 == ad.this.iMF) {
                        BdLog.e("link: " + ad.this.iMN.cPT);
                        if (ad.this.iMN != null && !TextUtils.isEmpty(ad.this.iMN.cPT)) {
                            ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVi.getPageActivity()), new String[]{ad.this.iMN.cPT});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cy("obj_source", ad.this.iMN.cPT));
                        }
                    } else if (view2 == ad.this.iMI && ad.this.iMO != null && !TextUtils.isEmpty(ad.this.iMO.cPT)) {
                        ba.aGG().b((TbPageContext) com.baidu.adp.base.i.ab(ad.this.cVi.getPageActivity()), new String[]{ad.this.iMO.cPT});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cy("obj_source", ad.this.iMO.cPT));
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.iMQ = aVar;
        this.iMy = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iMz = view.findViewById(R.id.pb_list_item_top_line);
        this.iMA = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iMB = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iMC = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iMD = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iME = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iMF = (LinearLayout) view.findViewById(R.id.news_info);
        this.iMG = (ImageView) view.findViewById(R.id.news_info_img);
        this.iMH = (TextView) view.findViewById(R.id.news_info_text);
        this.iMI = (LinearLayout) view.findViewById(R.id.game_info);
        this.iMJ = (ImageView) view.findViewById(R.id.game_info_img);
        this.iMK = (TextView) view.findViewById(R.id.game_info_text);
        this.iML = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.auY);
    }

    public void a(ab abVar) {
        if (abVar != null) {
            this.iMP = abVar;
            this.iMM = abVar.iMv;
            this.iMN = abVar.iMw;
            this.iMO = abVar.iMx;
            if (this.iMM != null) {
                this.iMB.startLoad(this.iMM.cPU, 10, false);
                this.iMD.setText(this.iMM.summary);
                this.iME.setText(this.iMM.subtitle);
                this.iMC.setText(this.iMM.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMC, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iMC, (int) R.drawable.news_text_color_selector);
            } else {
                this.iMA.setVisibility(8);
            }
            if (this.iMN != null) {
                this.iMH.setText(this.iMN.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMG, R.drawable.icon_frs_news);
            } else {
                this.iMF.setVisibility(8);
                this.iMH.setVisibility(8);
                this.iMG.setVisibility(8);
            }
            if (this.iMO != null) {
                this.iMK.setText(this.iMO.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iMJ, R.drawable.icon_frs_game);
            } else {
                this.iMI.setVisibility(8);
                this.iMK.setVisibility(8);
                this.iMK.setVisibility(8);
            }
            this.iMy.setTag(abVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cVi.getLayoutMode().setNightMode(i == 1);
            this.cVi.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iMA.setOnClickListener(onClickListener);
        this.iMF.setOnClickListener(onClickListener);
        this.iMI.setOnClickListener(onClickListener);
    }
}

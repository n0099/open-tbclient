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
/* loaded from: classes7.dex */
public class ag extends v.a {
    View.OnClickListener arL;
    private TbPageContext cRe;
    public LinearLayout iKP;
    public View iKQ;
    public RelativeLayout iKR;
    public TbImageView iKS;
    public TextView iKT;
    public TextView iKU;
    public TextView iKV;
    public LinearLayout iKW;
    public ImageView iKX;
    public TextView iKY;
    public LinearLayout iKZ;
    public ImageView iLa;
    public TextView iLb;
    public View iLc;
    private com.baidu.tbadk.core.data.as iLd;
    private com.baidu.tbadk.core.data.as iLe;
    private com.baidu.tbadk.core.data.as iLf;
    private ae iLg;
    private a iLh;
    private int mSkinType;

    /* loaded from: classes7.dex */
    public interface a {
        void b(ae aeVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.arL = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cRe.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ag.this.iLh != null) {
                        ag.this.iLh.b(ag.this.iLg);
                    }
                    if (view2 == ag.this.iKR) {
                        if (ag.this.iLd != null && !TextUtils.isEmpty(ag.this.iLd.cLO)) {
                            ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cRe.getPageActivity()), new String[]{ag.this.iLd.cLO});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cp("obj_source", ag.this.iLd.cLO));
                        }
                    } else if (view2 == ag.this.iKW) {
                        BdLog.e("link: " + ag.this.iLe.cLO);
                        if (ag.this.iLe != null && !TextUtils.isEmpty(ag.this.iLe.cLO)) {
                            ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cRe.getPageActivity()), new String[]{ag.this.iLe.cLO});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cp("obj_source", ag.this.iLe.cLO));
                        }
                    } else if (view2 == ag.this.iKZ && ag.this.iLf != null && !TextUtils.isEmpty(ag.this.iLf.cLO)) {
                        ba.aEt().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cRe.getPageActivity()), new String[]{ag.this.iLf.cLO});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cp("obj_source", ag.this.iLf.cLO));
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.iLh = aVar;
        this.iKP = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iKQ = view.findViewById(R.id.pb_list_item_top_line);
        this.iKR = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iKS = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iKT = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iKU = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iKV = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iKW = (LinearLayout) view.findViewById(R.id.news_info);
        this.iKX = (ImageView) view.findViewById(R.id.news_info_img);
        this.iKY = (TextView) view.findViewById(R.id.news_info_text);
        this.iKZ = (LinearLayout) view.findViewById(R.id.game_info);
        this.iLa = (ImageView) view.findViewById(R.id.game_info_img);
        this.iLb = (TextView) view.findViewById(R.id.game_info_text);
        this.iLc = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.arL);
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.iLg = aeVar;
            this.iLd = aeVar.iKM;
            this.iLe = aeVar.iKN;
            this.iLf = aeVar.iKO;
            if (this.iLd != null) {
                this.iKS.startLoad(this.iLd.cLP, 10, false);
                this.iKU.setText(this.iLd.summary);
                this.iKV.setText(this.iLd.subtitle);
                this.iKT.setText(this.iLd.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iKT, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iKT, (int) R.drawable.news_text_color_selector);
            } else {
                this.iKR.setVisibility(8);
            }
            if (this.iLe != null) {
                this.iKY.setText(this.iLe.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iKX, R.drawable.icon_frs_news);
            } else {
                this.iKW.setVisibility(8);
                this.iKY.setVisibility(8);
                this.iKX.setVisibility(8);
            }
            if (this.iLf != null) {
                this.iLb.setText(this.iLf.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iLa, R.drawable.icon_frs_game);
            } else {
                this.iKZ.setVisibility(8);
                this.iLb.setVisibility(8);
                this.iLb.setVisibility(8);
            }
            this.iKP.setTag(aeVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cRe.getLayoutMode().setNightMode(i == 1);
            this.cRe.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iKR.setOnClickListener(onClickListener);
        this.iKW.setOnClickListener(onClickListener);
        this.iKZ.setOnClickListener(onClickListener);
    }
}

package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ak extends aa.a {
    View.OnClickListener aUZ;
    private TbPageContext dIF;
    public LinearLayout jPB;
    public View jPC;
    public RelativeLayout jPD;
    public TbImageView jPE;
    public TextView jPF;
    public TextView jPG;
    public TextView jPH;
    public LinearLayout jPI;
    public ImageView jPJ;
    public TextView jPK;
    public LinearLayout jPL;
    public ImageView jPM;
    public TextView jPN;
    public View jPO;
    private com.baidu.tbadk.core.data.ar jPP;
    private com.baidu.tbadk.core.data.ar jPQ;
    private com.baidu.tbadk.core.data.ar jPR;
    private ai jPS;
    private a jPT;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ai aiVar);
    }

    public ak(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ak.this.dIF.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ak.this.jPT != null) {
                        ak.this.jPT.b(ak.this.jPS);
                    }
                    if (view2 == ak.this.jPD) {
                        if (ak.this.jPP != null && !TextUtils.isEmpty(ak.this.jPP.dDo)) {
                            com.baidu.tbadk.core.util.ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jPP.dDo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").dh("obj_source", ak.this.jPP.dDo));
                        }
                    } else if (view2 == ak.this.jPI) {
                        BdLog.e("link: " + ak.this.jPQ.dDo);
                        if (ak.this.jPQ != null && !TextUtils.isEmpty(ak.this.jPQ.dDo)) {
                            com.baidu.tbadk.core.util.ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jPQ.dDo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").dh("obj_source", ak.this.jPQ.dDo));
                        }
                    } else if (view2 == ak.this.jPL && ak.this.jPR != null && !TextUtils.isEmpty(ak.this.jPR.dDo)) {
                        com.baidu.tbadk.core.util.ba.aUZ().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jPR.dDo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").dh("obj_source", ak.this.jPR.dDo));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.jPT = aVar;
        this.jPB = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.jPC = view.findViewById(R.id.pb_list_item_top_line);
        this.jPD = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.jPE = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jPF = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.jPG = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jPH = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.jPI = (LinearLayout) view.findViewById(R.id.news_info);
        this.jPJ = (ImageView) view.findViewById(R.id.news_info_img);
        this.jPK = (TextView) view.findViewById(R.id.news_info_text);
        this.jPL = (LinearLayout) view.findViewById(R.id.game_info);
        this.jPM = (ImageView) view.findViewById(R.id.game_info_img);
        this.jPN = (TextView) view.findViewById(R.id.game_info_text);
        this.jPO = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aUZ);
    }

    public void a(ai aiVar) {
        if (aiVar != null) {
            this.jPS = aiVar;
            this.jPP = aiVar.jPy;
            this.jPQ = aiVar.jPz;
            this.jPR = aiVar.jPA;
            if (this.jPP != null) {
                this.jPE.startLoad(this.jPP.dDp, 10, false);
                this.jPG.setText(this.jPP.summary);
                this.jPH.setText(this.jPP.subtitle);
                this.jPF.setText(this.jPP.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jPF, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jPF, (int) R.drawable.news_text_color_selector);
            } else {
                this.jPD.setVisibility(8);
            }
            if (this.jPQ != null) {
                this.jPK.setText(this.jPQ.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jPJ, R.drawable.icon_frs_news);
            } else {
                this.jPI.setVisibility(8);
                this.jPK.setVisibility(8);
                this.jPJ.setVisibility(8);
            }
            if (this.jPR != null) {
                this.jPN.setText(this.jPR.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jPM, R.drawable.icon_frs_game);
            } else {
                this.jPL.setVisibility(8);
                this.jPN.setVisibility(8);
                this.jPN.setVisibility(8);
            }
            this.jPB.setTag(aiVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.dIF.getLayoutMode().setNightMode(i == 1);
            this.dIF.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.jPD.setOnClickListener(onClickListener);
        this.jPI.setOnClickListener(onClickListener);
        this.jPL.setOnClickListener(onClickListener);
    }
}

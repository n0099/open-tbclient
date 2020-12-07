package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ao extends af.a {
    View.OnClickListener aGQ;
    private TbPageContext eNx;
    public LinearLayout lNC;
    public View lND;
    public RelativeLayout lNE;
    public TbImageView lNF;
    public TextView lNG;
    public TextView lNH;
    public TextView lNI;
    public LinearLayout lNJ;
    public ImageView lNK;
    public TextView lNL;
    public LinearLayout lNM;
    public ImageView lNN;
    public TextView lNO;
    public View lNP;
    private com.baidu.tbadk.core.data.ba lNQ;
    private com.baidu.tbadk.core.data.ba lNR;
    private com.baidu.tbadk.core.data.ba lNS;
    private am lNT;
    private a lNU;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(ao.this.eNx.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.lNU != null) {
                        ao.this.lNU.b(ao.this.lNT);
                    }
                    if (view2 == ao.this.lNE) {
                        if (ao.this.lNQ != null && !TextUtils.isEmpty(ao.this.lNQ.eHo)) {
                            bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNQ.eHo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dY("obj_source", ao.this.lNQ.eHo));
                        }
                    } else if (view2 == ao.this.lNJ) {
                        BdLog.e("link: " + ao.this.lNR.eHo);
                        if (ao.this.lNR != null && !TextUtils.isEmpty(ao.this.lNR.eHo)) {
                            bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNR.eHo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dY("obj_source", ao.this.lNR.eHo));
                        }
                    } else if (view2 == ao.this.lNM && ao.this.lNS != null && !TextUtils.isEmpty(ao.this.lNS.eHo)) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNS.eHo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dY("obj_source", ao.this.lNS.eHo));
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.lNU = aVar;
        this.lNC = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lND = view.findViewById(R.id.pb_list_item_top_line);
        this.lNE = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lNF = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lNG = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lNH = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lNI = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lNJ = (LinearLayout) view.findViewById(R.id.news_info);
        this.lNK = (ImageView) view.findViewById(R.id.news_info_img);
        this.lNL = (TextView) view.findViewById(R.id.news_info_text);
        this.lNM = (LinearLayout) view.findViewById(R.id.game_info);
        this.lNN = (ImageView) view.findViewById(R.id.game_info_img);
        this.lNO = (TextView) view.findViewById(R.id.game_info_text);
        this.lNP = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aGQ);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.lNT = amVar;
            this.lNQ = amVar.lNz;
            this.lNR = amVar.lNA;
            this.lNS = amVar.lNB;
            if (this.lNQ != null) {
                this.lNF.startLoad(this.lNQ.eHp, 10, false);
                this.lNH.setText(this.lNQ.summary);
                this.lNI.setText(this.lNQ.subtitle);
                this.lNG.setText(this.lNQ.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNG, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNG, R.drawable.news_text_color_selector);
            } else {
                this.lNE.setVisibility(8);
            }
            if (this.lNR != null) {
                this.lNL.setText(this.lNR.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNK, R.drawable.icon_frs_news);
            } else {
                this.lNJ.setVisibility(8);
                this.lNL.setVisibility(8);
                this.lNK.setVisibility(8);
            }
            if (this.lNS != null) {
                this.lNO.setText(this.lNS.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNN, R.drawable.icon_frs_game);
            } else {
                this.lNM.setVisibility(8);
                this.lNO.setVisibility(8);
                this.lNO.setVisibility(8);
            }
            this.lNC.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eNx.getLayoutMode().setNightMode(i == 1);
            this.eNx.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lNE.setOnClickListener(onClickListener);
        this.lNJ.setOnClickListener(onClickListener);
        this.lNM.setOnClickListener(onClickListener);
    }
}

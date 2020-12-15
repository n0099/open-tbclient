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
    public LinearLayout lNE;
    public View lNF;
    public RelativeLayout lNG;
    public TbImageView lNH;
    public TextView lNI;
    public TextView lNJ;
    public TextView lNK;
    public LinearLayout lNL;
    public ImageView lNM;
    public TextView lNN;
    public LinearLayout lNO;
    public ImageView lNP;
    public TextView lNQ;
    public View lNR;
    private com.baidu.tbadk.core.data.ba lNS;
    private com.baidu.tbadk.core.data.ba lNT;
    private com.baidu.tbadk.core.data.ba lNU;
    private am lNV;
    private a lNW;
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
                    if (ao.this.lNW != null) {
                        ao.this.lNW.b(ao.this.lNV);
                    }
                    if (view2 == ao.this.lNG) {
                        if (ao.this.lNS != null && !TextUtils.isEmpty(ao.this.lNS.eHo)) {
                            bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNS.eHo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dY("obj_source", ao.this.lNS.eHo));
                        }
                    } else if (view2 == ao.this.lNL) {
                        BdLog.e("link: " + ao.this.lNT.eHo);
                        if (ao.this.lNT != null && !TextUtils.isEmpty(ao.this.lNT.eHo)) {
                            bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNT.eHo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dY("obj_source", ao.this.lNT.eHo));
                        }
                    } else if (view2 == ao.this.lNO && ao.this.lNU != null && !TextUtils.isEmpty(ao.this.lNU.eHo)) {
                        bf.bua().b((TbPageContext) com.baidu.adp.base.i.J(ao.this.eNx.getPageActivity()), new String[]{ao.this.lNU.eHo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dY("obj_source", ao.this.lNU.eHo));
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.lNW = aVar;
        this.lNE = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lNF = view.findViewById(R.id.pb_list_item_top_line);
        this.lNG = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lNH = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lNI = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lNJ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lNK = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lNL = (LinearLayout) view.findViewById(R.id.news_info);
        this.lNM = (ImageView) view.findViewById(R.id.news_info_img);
        this.lNN = (TextView) view.findViewById(R.id.news_info_text);
        this.lNO = (LinearLayout) view.findViewById(R.id.game_info);
        this.lNP = (ImageView) view.findViewById(R.id.game_info_img);
        this.lNQ = (TextView) view.findViewById(R.id.game_info_text);
        this.lNR = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aGQ);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.lNV = amVar;
            this.lNS = amVar.lNB;
            this.lNT = amVar.lNC;
            this.lNU = amVar.lND;
            if (this.lNS != null) {
                this.lNH.startLoad(this.lNS.eHp, 10, false);
                this.lNJ.setText(this.lNS.summary);
                this.lNK.setText(this.lNS.subtitle);
                this.lNI.setText(this.lNS.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNI, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lNI, R.drawable.news_text_color_selector);
            } else {
                this.lNG.setVisibility(8);
            }
            if (this.lNT != null) {
                this.lNN.setText(this.lNT.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNM, R.drawable.icon_frs_news);
            } else {
                this.lNL.setVisibility(8);
                this.lNN.setVisibility(8);
                this.lNM.setVisibility(8);
            }
            if (this.lNU != null) {
                this.lNQ.setText(this.lNU.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lNP, R.drawable.icon_frs_game);
            } else {
                this.lNO.setVisibility(8);
                this.lNQ.setVisibility(8);
                this.lNQ.setVisibility(8);
            }
            this.lNE.setTag(amVar);
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
        this.lNG.setOnClickListener(onClickListener);
        this.lNL.setOnClickListener(onClickListener);
        this.lNO.setOnClickListener(onClickListener);
    }
}

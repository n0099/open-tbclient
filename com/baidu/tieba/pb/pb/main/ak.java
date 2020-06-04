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
    public LinearLayout jQH;
    public View jQI;
    public RelativeLayout jQJ;
    public TbImageView jQK;
    public TextView jQL;
    public TextView jQM;
    public TextView jQN;
    public LinearLayout jQO;
    public ImageView jQP;
    public TextView jQQ;
    public LinearLayout jQR;
    public ImageView jQS;
    public TextView jQT;
    public View jQU;
    private com.baidu.tbadk.core.data.ar jQV;
    private com.baidu.tbadk.core.data.ar jQW;
    private com.baidu.tbadk.core.data.ar jQX;
    private ai jQY;
    private a jQZ;
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
                    if (ak.this.jQZ != null) {
                        ak.this.jQZ.b(ak.this.jQY);
                    }
                    if (view2 == ak.this.jQJ) {
                        if (ak.this.jQV != null && !TextUtils.isEmpty(ak.this.jQV.dDo)) {
                            com.baidu.tbadk.core.util.ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jQV.dDo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").dh("obj_source", ak.this.jQV.dDo));
                        }
                    } else if (view2 == ak.this.jQO) {
                        BdLog.e("link: " + ak.this.jQW.dDo);
                        if (ak.this.jQW != null && !TextUtils.isEmpty(ak.this.jQW.dDo)) {
                            com.baidu.tbadk.core.util.ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jQW.dDo});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").dh("obj_source", ak.this.jQW.dDo));
                        }
                    } else if (view2 == ak.this.jQR && ak.this.jQX != null && !TextUtils.isEmpty(ak.this.jQX.dDo)) {
                        com.baidu.tbadk.core.util.ba.aVa().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dIF.getPageActivity()), new String[]{ak.this.jQX.dDo});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").dh("obj_source", ak.this.jQX.dDo));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.jQZ = aVar;
        this.jQH = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.jQI = view.findViewById(R.id.pb_list_item_top_line);
        this.jQJ = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.jQK = (TbImageView) view.findViewById(R.id.top_code_img);
        this.jQL = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.jQM = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.jQN = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.jQO = (LinearLayout) view.findViewById(R.id.news_info);
        this.jQP = (ImageView) view.findViewById(R.id.news_info_img);
        this.jQQ = (TextView) view.findViewById(R.id.news_info_text);
        this.jQR = (LinearLayout) view.findViewById(R.id.game_info);
        this.jQS = (ImageView) view.findViewById(R.id.game_info_img);
        this.jQT = (TextView) view.findViewById(R.id.game_info_text);
        this.jQU = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aUZ);
    }

    public void a(ai aiVar) {
        if (aiVar != null) {
            this.jQY = aiVar;
            this.jQV = aiVar.jQE;
            this.jQW = aiVar.jQF;
            this.jQX = aiVar.jQG;
            if (this.jQV != null) {
                this.jQK.startLoad(this.jQV.dDp, 10, false);
                this.jQM.setText(this.jQV.summary);
                this.jQN.setText(this.jQV.subtitle);
                this.jQL.setText(this.jQV.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQL, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.jQL, (int) R.drawable.news_text_color_selector);
            } else {
                this.jQJ.setVisibility(8);
            }
            if (this.jQW != null) {
                this.jQQ.setText(this.jQW.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQP, R.drawable.icon_frs_news);
            } else {
                this.jQO.setVisibility(8);
                this.jQQ.setVisibility(8);
                this.jQP.setVisibility(8);
            }
            if (this.jQX != null) {
                this.jQT.setText(this.jQX.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.jQS, R.drawable.icon_frs_game);
            } else {
                this.jQR.setVisibility(8);
                this.jQT.setVisibility(8);
                this.jQT.setVisibility(8);
            }
            this.jQH.setTag(aiVar);
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
        this.jQJ.setOnClickListener(onClickListener);
        this.jQO.setOnClickListener(onClickListener);
        this.jQR.setOnClickListener(onClickListener);
    }
}

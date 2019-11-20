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
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener ajc;
    private TbPageContext ceu;
    public LinearLayout hSE;
    public View hSF;
    public RelativeLayout hSG;
    public TbImageView hSH;
    public TextView hSI;
    public TextView hSJ;
    public TextView hSK;
    public LinearLayout hSL;
    public ImageView hSM;
    public TextView hSN;
    public LinearLayout hSO;
    public ImageView hSP;
    public TextView hSQ;
    public View hSR;
    private com.baidu.tbadk.core.data.ap hSS;
    private com.baidu.tbadk.core.data.ap hST;
    private com.baidu.tbadk.core.data.ap hSU;
    private ad hSV;
    private a hSW;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.ajc = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(af.this.ceu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (af.this.hSW != null) {
                        af.this.hSW.b(af.this.hSV);
                    }
                    if (view2 == af.this.hSG) {
                        if (af.this.hSS != null && !TextUtils.isEmpty(af.this.hSS.bZl)) {
                            ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.ceu.getPageActivity()), new String[]{af.this.hSS.bZl});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").bS("obj_source", af.this.hSS.bZl));
                        }
                    } else if (view2 == af.this.hSL) {
                        BdLog.e("link: " + af.this.hST.bZl);
                        if (af.this.hST != null && !TextUtils.isEmpty(af.this.hST.bZl)) {
                            ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.ceu.getPageActivity()), new String[]{af.this.hST.bZl});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").bS("obj_source", af.this.hST.bZl));
                        }
                    } else if (view2 == af.this.hSO && af.this.hSU != null && !TextUtils.isEmpty(af.this.hSU.bZl)) {
                        ba.amO().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.ceu.getPageActivity()), new String[]{af.this.hSU.bZl});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").bS("obj_source", af.this.hSU.bZl));
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.hSW = aVar;
        this.hSE = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hSF = view.findViewById(R.id.pb_list_item_top_line);
        this.hSG = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hSH = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hSI = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hSJ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hSK = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hSL = (LinearLayout) view.findViewById(R.id.news_info);
        this.hSM = (ImageView) view.findViewById(R.id.news_info_img);
        this.hSN = (TextView) view.findViewById(R.id.news_info_text);
        this.hSO = (LinearLayout) view.findViewById(R.id.game_info);
        this.hSP = (ImageView) view.findViewById(R.id.game_info_img);
        this.hSQ = (TextView) view.findViewById(R.id.game_info_text);
        this.hSR = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.ajc);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hSV = adVar;
            this.hSS = adVar.hSB;
            this.hST = adVar.hSC;
            this.hSU = adVar.hSD;
            if (this.hSS != null) {
                this.hSH.startLoad(this.hSS.bZn, 10, false);
                this.hSJ.setText(this.hSS.summary);
                this.hSK.setText(this.hSS.subtitle);
                this.hSI.setText(this.hSS.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hSI, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hSI, (int) R.drawable.news_text_color_selector);
            } else {
                this.hSG.setVisibility(8);
            }
            if (this.hST != null) {
                this.hSN.setText(this.hST.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hSM, R.drawable.icon_frs_news);
            } else {
                this.hSL.setVisibility(8);
                this.hSN.setVisibility(8);
                this.hSM.setVisibility(8);
            }
            if (this.hSU != null) {
                this.hSQ.setText(this.hSU.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hSP, R.drawable.icon_frs_game);
            } else {
                this.hSO.setVisibility(8);
                this.hSQ.setVisibility(8);
                this.hSQ.setVisibility(8);
            }
            this.hSE.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ceu.getLayoutMode().setNightMode(i == 1);
            this.ceu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hSG.setOnClickListener(onClickListener);
        this.hSL.setOnClickListener(onClickListener);
        this.hSO.setOnClickListener(onClickListener);
    }
}

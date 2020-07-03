package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class ak extends ad.a {
    View.OnClickListener aXG;
    private TbPageContext dPv;
    public TbImageView kkA;
    public TextView kkB;
    public TextView kkC;
    public TextView kkD;
    public LinearLayout kkE;
    public ImageView kkF;
    public TextView kkG;
    public LinearLayout kkH;
    public ImageView kkI;
    public TextView kkJ;
    public View kkK;
    private com.baidu.tbadk.core.data.aw kkL;
    private com.baidu.tbadk.core.data.aw kkM;
    private com.baidu.tbadk.core.data.aw kkN;
    private ai kkO;
    private a kkP;
    public LinearLayout kkx;
    public View kky;
    public RelativeLayout kkz;
    private int mSkinType;

    /* loaded from: classes9.dex */
    public interface a {
        void b(ai aiVar);
    }

    public ak(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ak.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (be.checkUpIsLogin(ak.this.dPv.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ak.this.kkP != null) {
                        ak.this.kkP.b(ak.this.kkO);
                    }
                    if (view2 == ak.this.kkz) {
                        if (ak.this.kkL != null && !TextUtils.isEmpty(ak.this.kkL.dJK)) {
                            bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dPv.getPageActivity()), new String[]{ak.this.kkL.dJK});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11410").dk("obj_source", ak.this.kkL.dJK));
                        }
                    } else if (view2 == ak.this.kkE) {
                        BdLog.e("link: " + ak.this.kkM.dJK);
                        if (ak.this.kkM != null && !TextUtils.isEmpty(ak.this.kkM.dJK)) {
                            bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dPv.getPageActivity()), new String[]{ak.this.kkM.dJK});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11409").dk("obj_source", ak.this.kkM.dJK));
                        }
                    } else if (view2 == ak.this.kkH && ak.this.kkN != null && !TextUtils.isEmpty(ak.this.kkN.dJK)) {
                        bc.aWU().b((TbPageContext) com.baidu.adp.base.i.G(ak.this.dPv.getPageActivity()), new String[]{ak.this.kkN.dJK});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ao("c11408").dk("obj_source", ak.this.kkN.dJK));
                    }
                }
            }
        };
        this.dPv = tbPageContext;
        this.kkP = aVar;
        this.kkx = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.kky = view.findViewById(R.id.pb_list_item_top_line);
        this.kkz = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.kkA = (TbImageView) view.findViewById(R.id.top_code_img);
        this.kkB = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.kkC = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.kkD = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.kkE = (LinearLayout) view.findViewById(R.id.news_info);
        this.kkF = (ImageView) view.findViewById(R.id.news_info_img);
        this.kkG = (TextView) view.findViewById(R.id.news_info_text);
        this.kkH = (LinearLayout) view.findViewById(R.id.game_info);
        this.kkI = (ImageView) view.findViewById(R.id.game_info_img);
        this.kkJ = (TextView) view.findViewById(R.id.game_info_text);
        this.kkK = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aXG);
    }

    public void a(ai aiVar) {
        if (aiVar != null) {
            this.kkO = aiVar;
            this.kkL = aiVar.kku;
            this.kkM = aiVar.kkv;
            this.kkN = aiVar.kkw;
            if (this.kkL != null) {
                this.kkA.startLoad(this.kkL.dJL, 10, false);
                this.kkC.setText(this.kkL.summary);
                this.kkD.setText(this.kkL.subtitle);
                this.kkB.setText(this.kkL.buttonText);
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kkB, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.an.setViewTextColor(this.kkB, (int) R.drawable.news_text_color_selector);
            } else {
                this.kkz.setVisibility(8);
            }
            if (this.kkM != null) {
                this.kkG.setText(this.kkM.summary);
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kkF, R.drawable.icon_frs_news);
            } else {
                this.kkE.setVisibility(8);
                this.kkG.setVisibility(8);
                this.kkF.setVisibility(8);
            }
            if (this.kkN != null) {
                this.kkJ.setText(this.kkN.summary);
                com.baidu.tbadk.core.util.an.setBackgroundResource(this.kkI, R.drawable.icon_frs_game);
            } else {
                this.kkH.setVisibility(8);
                this.kkJ.setVisibility(8);
                this.kkJ.setVisibility(8);
            }
            this.kkx.setTag(aiVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.dPv.getLayoutMode().setNightMode(i == 1);
            this.dPv.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kkz.setOnClickListener(onClickListener);
        this.kkE.setOnClickListener(onClickListener);
        this.kkH.setOnClickListener(onClickListener);
    }
}

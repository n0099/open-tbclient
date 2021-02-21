package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aEh;
    private TbPageContext eUY;
    public TbImageView lXA;
    public TextView lXB;
    public TextView lXC;
    public TextView lXD;
    public LinearLayout lXE;
    public ImageView lXF;
    public TextView lXG;
    public LinearLayout lXH;
    public ImageView lXI;
    public TextView lXJ;
    public View lXK;
    private bc lXL;
    private bc lXM;
    private bc lXN;
    private af lXO;
    private a lXP;
    public LinearLayout lXx;
    public View lXy;
    public RelativeLayout lXz;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void b(af afVar);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(PbPageNewsInfoHolder.this.eUY.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (PbPageNewsInfoHolder.this.lXP != null) {
                        PbPageNewsInfoHolder.this.lXP.b(PbPageNewsInfoHolder.this.lXO);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lXz) {
                        if (PbPageNewsInfoHolder.this.lXL != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXL.eOG)) {
                            bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXL.eOG});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dR("obj_source", PbPageNewsInfoHolder.this.lXL.eOG));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lXE) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lXM.eOG);
                        if (PbPageNewsInfoHolder.this.lXM != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXM.eOG)) {
                            bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXM.eOG});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dR("obj_source", PbPageNewsInfoHolder.this.lXM.eOG));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lXH && PbPageNewsInfoHolder.this.lXN != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXN.eOG)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXN.eOG});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dR("obj_source", PbPageNewsInfoHolder.this.lXN.eOG));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.lXP = aVar;
        this.lXx = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lXy = view.findViewById(R.id.pb_list_item_top_line);
        this.lXz = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lXA = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lXB = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lXC = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lXD = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lXE = (LinearLayout) view.findViewById(R.id.news_info);
        this.lXF = (ImageView) view.findViewById(R.id.news_info_img);
        this.lXG = (TextView) view.findViewById(R.id.news_info_text);
        this.lXH = (LinearLayout) view.findViewById(R.id.game_info);
        this.lXI = (ImageView) view.findViewById(R.id.game_info_img);
        this.lXJ = (TextView) view.findViewById(R.id.game_info_text);
        this.lXK = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aEh);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lXO = afVar;
            this.lXL = afVar.lXu;
            this.lXM = afVar.lXv;
            this.lXN = afVar.lXw;
            if (this.lXL != null) {
                this.lXA.startLoad(this.lXL.eOH, 10, false);
                this.lXC.setText(this.lXL.summary);
                this.lXD.setText(this.lXL.subtitle);
                this.lXB.setText(this.lXL.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXB, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXB, R.drawable.news_text_color_selector);
            } else {
                this.lXz.setVisibility(8);
            }
            if (this.lXM != null) {
                this.lXG.setText(this.lXM.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXF, R.drawable.icon_frs_news);
            } else {
                this.lXE.setVisibility(8);
                this.lXG.setVisibility(8);
                this.lXF.setVisibility(8);
            }
            if (this.lXN != null) {
                this.lXJ.setText(this.lXN.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXI, R.drawable.icon_frs_game);
            } else {
                this.lXH.setVisibility(8);
                this.lXJ.setVisibility(8);
                this.lXJ.setVisibility(8);
            }
            this.lXx.setTag(afVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eUY.getLayoutMode().setNightMode(i == 1);
            this.eUY.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lXz.setOnClickListener(onClickListener);
        this.lXE.setOnClickListener(onClickListener);
        this.lXH.setOnClickListener(onClickListener);
    }
}

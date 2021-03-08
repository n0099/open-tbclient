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
    View.OnClickListener aFH;
    private TbPageContext eWx;
    public View lZA;
    public RelativeLayout lZB;
    public TbImageView lZC;
    public TextView lZD;
    public TextView lZE;
    public TextView lZF;
    public LinearLayout lZG;
    public ImageView lZH;
    public TextView lZI;
    public LinearLayout lZJ;
    public ImageView lZK;
    public TextView lZL;
    public View lZM;
    private bc lZN;
    private bc lZO;
    private bc lZP;
    private af lZQ;
    private a lZR;
    public LinearLayout lZz;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void b(af afVar);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(PbPageNewsInfoHolder.this.eWx.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (PbPageNewsInfoHolder.this.lZR != null) {
                        PbPageNewsInfoHolder.this.lZR.b(PbPageNewsInfoHolder.this.lZQ);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lZB) {
                        if (PbPageNewsInfoHolder.this.lZN != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lZN.eQh)) {
                            bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(PbPageNewsInfoHolder.this.eWx.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lZN.eQh});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dR("obj_source", PbPageNewsInfoHolder.this.lZN.eQh));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lZG) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lZO.eQh);
                        if (PbPageNewsInfoHolder.this.lZO != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lZO.eQh)) {
                            bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(PbPageNewsInfoHolder.this.eWx.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lZO.eQh});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dR("obj_source", PbPageNewsInfoHolder.this.lZO.eQh));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lZJ && PbPageNewsInfoHolder.this.lZP != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lZP.eQh)) {
                        bf.bsY().b((TbPageContext) com.baidu.adp.base.j.J(PbPageNewsInfoHolder.this.eWx.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lZP.eQh});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dR("obj_source", PbPageNewsInfoHolder.this.lZP.eQh));
                    }
                }
            }
        };
        this.eWx = tbPageContext;
        this.lZR = aVar;
        this.lZz = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lZA = view.findViewById(R.id.pb_list_item_top_line);
        this.lZB = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lZC = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lZD = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lZE = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lZF = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lZG = (LinearLayout) view.findViewById(R.id.news_info);
        this.lZH = (ImageView) view.findViewById(R.id.news_info_img);
        this.lZI = (TextView) view.findViewById(R.id.news_info_text);
        this.lZJ = (LinearLayout) view.findViewById(R.id.game_info);
        this.lZK = (ImageView) view.findViewById(R.id.game_info_img);
        this.lZL = (TextView) view.findViewById(R.id.game_info_text);
        this.lZM = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aFH);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lZQ = afVar;
            this.lZN = afVar.lZw;
            this.lZO = afVar.lZx;
            this.lZP = afVar.lZy;
            if (this.lZN != null) {
                this.lZC.startLoad(this.lZN.eQi, 10, false);
                this.lZE.setText(this.lZN.summary);
                this.lZF.setText(this.lZN.subtitle);
                this.lZD.setText(this.lZN.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lZD, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lZD, R.drawable.news_text_color_selector);
            } else {
                this.lZB.setVisibility(8);
            }
            if (this.lZO != null) {
                this.lZI.setText(this.lZO.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lZH, R.drawable.icon_frs_news);
            } else {
                this.lZG.setVisibility(8);
                this.lZI.setVisibility(8);
                this.lZH.setVisibility(8);
            }
            if (this.lZP != null) {
                this.lZL.setText(this.lZP.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lZK, R.drawable.icon_frs_game);
            } else {
                this.lZJ.setVisibility(8);
                this.lZL.setVisibility(8);
                this.lZL.setVisibility(8);
            }
            this.lZz.setTag(afVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eWx.getLayoutMode().setNightMode(i == 1);
            this.eWx.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lZB.setOnClickListener(onClickListener);
        this.lZG.setOnClickListener(onClickListener);
        this.lZJ.setOnClickListener(onClickListener);
    }
}

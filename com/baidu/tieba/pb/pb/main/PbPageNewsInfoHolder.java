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
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    View.OnClickListener aHh;
    private TbPageContext eXu;
    public LinearLayout lSQ;
    public View lSR;
    public RelativeLayout lSS;
    public TbImageView lST;
    public TextView lSU;
    public TextView lSV;
    public TextView lSW;
    public LinearLayout lSX;
    public ImageView lSY;
    public TextView lSZ;
    public LinearLayout lTa;
    public ImageView lTb;
    public TextView lTc;
    public View lTd;
    private ba lTe;
    private ba lTf;
    private ba lTg;
    private af lTh;
    private a lTi;
    private int mSkinType;

    /* loaded from: classes2.dex */
    public interface a {
        void b(af afVar);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.PbPageNewsInfoHolder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(PbPageNewsInfoHolder.this.eXu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (PbPageNewsInfoHolder.this.lTi != null) {
                        PbPageNewsInfoHolder.this.lTi.b(PbPageNewsInfoHolder.this.lTh);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lSS) {
                        if (PbPageNewsInfoHolder.this.lTe != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTe.eRf)) {
                            be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTe.eRf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dX("obj_source", PbPageNewsInfoHolder.this.lTe.eRf));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lSX) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lTf.eRf);
                        if (PbPageNewsInfoHolder.this.lTf != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTf.eRf)) {
                            be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTf.eRf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dX("obj_source", PbPageNewsInfoHolder.this.lTf.eRf));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lTa && PbPageNewsInfoHolder.this.lTg != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTg.eRf)) {
                        be.bwv().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTg.eRf});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dX("obj_source", PbPageNewsInfoHolder.this.lTg.eRf));
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.lTi = aVar;
        this.lSQ = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lSR = view.findViewById(R.id.pb_list_item_top_line);
        this.lSS = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lST = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lSU = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lSV = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lSW = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lSX = (LinearLayout) view.findViewById(R.id.news_info);
        this.lSY = (ImageView) view.findViewById(R.id.news_info_img);
        this.lSZ = (TextView) view.findViewById(R.id.news_info_text);
        this.lTa = (LinearLayout) view.findViewById(R.id.game_info);
        this.lTb = (ImageView) view.findViewById(R.id.game_info_img);
        this.lTc = (TextView) view.findViewById(R.id.game_info_text);
        this.lTd = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aHh);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lTh = afVar;
            this.lTe = afVar.lSN;
            this.lTf = afVar.lSO;
            this.lTg = afVar.lSP;
            if (this.lTe != null) {
                this.lST.startLoad(this.lTe.eRg, 10, false);
                this.lSV.setText(this.lTe.summary);
                this.lSW.setText(this.lTe.subtitle);
                this.lSU.setText(this.lTe.buttonText);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lSU, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSU, R.drawable.news_text_color_selector);
            } else {
                this.lSS.setVisibility(8);
            }
            if (this.lTf != null) {
                this.lSZ.setText(this.lTf.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lSY, R.drawable.icon_frs_news);
            } else {
                this.lSX.setVisibility(8);
                this.lSZ.setVisibility(8);
                this.lSY.setVisibility(8);
            }
            if (this.lTg != null) {
                this.lTc.setText(this.lTg.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lTb, R.drawable.icon_frs_game);
            } else {
                this.lTa.setVisibility(8);
                this.lTc.setVisibility(8);
                this.lTc.setVisibility(8);
            }
            this.lSQ.setTag(afVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eXu.getLayoutMode().setNightMode(i == 1);
            this.eXu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lSS.setOnClickListener(onClickListener);
        this.lSX.setOnClickListener(onClickListener);
        this.lTa.setOnClickListener(onClickListener);
    }
}

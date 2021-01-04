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
    public LinearLayout lSR;
    public View lSS;
    public RelativeLayout lST;
    public TbImageView lSU;
    public TextView lSV;
    public TextView lSW;
    public TextView lSX;
    public LinearLayout lSY;
    public ImageView lSZ;
    public TextView lTa;
    public LinearLayout lTb;
    public ImageView lTc;
    public TextView lTd;
    public View lTe;
    private ba lTf;
    private ba lTg;
    private ba lTh;
    private af lTi;
    private a lTj;
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
                    if (PbPageNewsInfoHolder.this.lTj != null) {
                        PbPageNewsInfoHolder.this.lTj.b(PbPageNewsInfoHolder.this.lTi);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lST) {
                        if (PbPageNewsInfoHolder.this.lTf != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTf.eRf)) {
                            be.bwu().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTf.eRf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dX("obj_source", PbPageNewsInfoHolder.this.lTf.eRf));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lSY) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lTg.eRf);
                        if (PbPageNewsInfoHolder.this.lTg != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTg.eRf)) {
                            be.bwu().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTg.eRf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dX("obj_source", PbPageNewsInfoHolder.this.lTg.eRf));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lTb && PbPageNewsInfoHolder.this.lTh != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lTh.eRf)) {
                        be.bwu().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eXu.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lTh.eRf});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dX("obj_source", PbPageNewsInfoHolder.this.lTh.eRf));
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.lTj = aVar;
        this.lSR = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lSS = view.findViewById(R.id.pb_list_item_top_line);
        this.lST = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lSU = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lSV = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lSW = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lSX = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lSY = (LinearLayout) view.findViewById(R.id.news_info);
        this.lSZ = (ImageView) view.findViewById(R.id.news_info_img);
        this.lTa = (TextView) view.findViewById(R.id.news_info_text);
        this.lTb = (LinearLayout) view.findViewById(R.id.game_info);
        this.lTc = (ImageView) view.findViewById(R.id.game_info_img);
        this.lTd = (TextView) view.findViewById(R.id.game_info_text);
        this.lTe = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aHh);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lTi = afVar;
            this.lTf = afVar.lSO;
            this.lTg = afVar.lSP;
            this.lTh = afVar.lSQ;
            if (this.lTf != null) {
                this.lSU.startLoad(this.lTf.eRg, 10, false);
                this.lSW.setText(this.lTf.summary);
                this.lSX.setText(this.lTf.subtitle);
                this.lSV.setText(this.lTf.buttonText);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lSV, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.lSV, R.drawable.news_text_color_selector);
            } else {
                this.lST.setVisibility(8);
            }
            if (this.lTg != null) {
                this.lTa.setText(this.lTg.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lSZ, R.drawable.icon_frs_news);
            } else {
                this.lSY.setVisibility(8);
                this.lTa.setVisibility(8);
                this.lSZ.setVisibility(8);
            }
            if (this.lTh != null) {
                this.lTd.setText(this.lTh.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.lTc, R.drawable.icon_frs_game);
            } else {
                this.lTb.setVisibility(8);
                this.lTd.setVisibility(8);
                this.lTd.setVisibility(8);
            }
            this.lSR.setTag(afVar);
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
        this.lST.setOnClickListener(onClickListener);
        this.lSY.setOnClickListener(onClickListener);
        this.lTb.setOnClickListener(onClickListener);
    }
}

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
    private a lXA;
    public LinearLayout lXi;
    public View lXj;
    public RelativeLayout lXk;
    public TbImageView lXl;
    public TextView lXm;
    public TextView lXn;
    public TextView lXo;
    public LinearLayout lXp;
    public ImageView lXq;
    public TextView lXr;
    public LinearLayout lXs;
    public ImageView lXt;
    public TextView lXu;
    public View lXv;
    private bc lXw;
    private bc lXx;
    private bc lXy;
    private af lXz;
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
                    if (PbPageNewsInfoHolder.this.lXA != null) {
                        PbPageNewsInfoHolder.this.lXA.b(PbPageNewsInfoHolder.this.lXz);
                    }
                    if (view2 == PbPageNewsInfoHolder.this.lXk) {
                        if (PbPageNewsInfoHolder.this.lXw != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXw.eOG)) {
                            bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXw.eOG});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dR("obj_source", PbPageNewsInfoHolder.this.lXw.eOG));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lXp) {
                        BdLog.e("link: " + PbPageNewsInfoHolder.this.lXx.eOG);
                        if (PbPageNewsInfoHolder.this.lXx != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXx.eOG)) {
                            bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXx.eOG});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dR("obj_source", PbPageNewsInfoHolder.this.lXx.eOG));
                        }
                    } else if (view2 == PbPageNewsInfoHolder.this.lXs && PbPageNewsInfoHolder.this.lXy != null && !TextUtils.isEmpty(PbPageNewsInfoHolder.this.lXy.eOG)) {
                        bf.bsV().b((TbPageContext) com.baidu.adp.base.j.K(PbPageNewsInfoHolder.this.eUY.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.lXy.eOG});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dR("obj_source", PbPageNewsInfoHolder.this.lXy.eOG));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.lXA = aVar;
        this.lXi = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lXj = view.findViewById(R.id.pb_list_item_top_line);
        this.lXk = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lXl = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lXm = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lXn = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lXo = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lXp = (LinearLayout) view.findViewById(R.id.news_info);
        this.lXq = (ImageView) view.findViewById(R.id.news_info_img);
        this.lXr = (TextView) view.findViewById(R.id.news_info_text);
        this.lXs = (LinearLayout) view.findViewById(R.id.game_info);
        this.lXt = (ImageView) view.findViewById(R.id.game_info_img);
        this.lXu = (TextView) view.findViewById(R.id.game_info_text);
        this.lXv = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aEh);
    }

    public void a(af afVar) {
        if (afVar != null) {
            this.lXz = afVar;
            this.lXw = afVar.lXf;
            this.lXx = afVar.lXg;
            this.lXy = afVar.lXh;
            if (this.lXw != null) {
                this.lXl.startLoad(this.lXw.eOH, 10, false);
                this.lXn.setText(this.lXw.summary);
                this.lXo.setText(this.lXw.subtitle);
                this.lXm.setText(this.lXw.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXm, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lXm, R.drawable.news_text_color_selector);
            } else {
                this.lXk.setVisibility(8);
            }
            if (this.lXx != null) {
                this.lXr.setText(this.lXx.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXq, R.drawable.icon_frs_news);
            } else {
                this.lXp.setVisibility(8);
                this.lXr.setVisibility(8);
                this.lXq.setVisibility(8);
            }
            if (this.lXy != null) {
                this.lXu.setText(this.lXy.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lXt, R.drawable.icon_frs_game);
            } else {
                this.lXs.setVisibility(8);
                this.lXu.setVisibility(8);
                this.lXu.setVisibility(8);
            }
            this.lXi.setTag(afVar);
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
        this.lXk.setOnClickListener(onClickListener);
        this.lXp.setOnClickListener(onClickListener);
        this.lXs.setOnClickListener(onClickListener);
    }
}

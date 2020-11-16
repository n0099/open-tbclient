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
/* loaded from: classes21.dex */
public class ao extends af.a {
    View.OnClickListener aEk;
    private TbPageContext eGu;
    public ImageView lAa;
    public TextView lAb;
    public View lAc;
    private com.baidu.tbadk.core.data.az lAd;
    private com.baidu.tbadk.core.data.az lAe;
    private com.baidu.tbadk.core.data.az lAf;
    private am lAg;
    private a lAh;
    public LinearLayout lzP;
    public View lzQ;
    public RelativeLayout lzR;
    public TbImageView lzS;
    public TextView lzT;
    public TextView lzU;
    public TextView lzV;
    public LinearLayout lzW;
    public ImageView lzX;
    public TextView lzY;
    public LinearLayout lzZ;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bh.checkUpIsLogin(ao.this.eGu.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.lAh != null) {
                        ao.this.lAh.b(ao.this.lAg);
                    }
                    if (view2 == ao.this.lzR) {
                        if (ao.this.lAd != null && !TextUtils.isEmpty(ao.this.lAd.eAp)) {
                            bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eGu.getPageActivity()), new String[]{ao.this.lAd.eAp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11410").dR("obj_source", ao.this.lAd.eAp));
                        }
                    } else if (view2 == ao.this.lzW) {
                        BdLog.e("link: " + ao.this.lAe.eAp);
                        if (ao.this.lAe != null && !TextUtils.isEmpty(ao.this.lAe.eAp)) {
                            bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eGu.getPageActivity()), new String[]{ao.this.lAe.eAp});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11409").dR("obj_source", ao.this.lAe.eAp));
                        }
                    } else if (view2 == ao.this.lzZ && ao.this.lAf != null && !TextUtils.isEmpty(ao.this.lAf.eAp)) {
                        bf.bqF().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eGu.getPageActivity()), new String[]{ao.this.lAf.eAp});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11408").dR("obj_source", ao.this.lAf.eAp));
                    }
                }
            }
        };
        this.eGu = tbPageContext;
        this.lAh = aVar;
        this.lzP = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.lzQ = view.findViewById(R.id.pb_list_item_top_line);
        this.lzR = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.lzS = (TbImageView) view.findViewById(R.id.top_code_img);
        this.lzT = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.lzU = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.lzV = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.lzW = (LinearLayout) view.findViewById(R.id.news_info);
        this.lzX = (ImageView) view.findViewById(R.id.news_info_img);
        this.lzY = (TextView) view.findViewById(R.id.news_info_text);
        this.lzZ = (LinearLayout) view.findViewById(R.id.game_info);
        this.lAa = (ImageView) view.findViewById(R.id.game_info_img);
        this.lAb = (TextView) view.findViewById(R.id.game_info_text);
        this.lAc = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aEk);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.lAg = amVar;
            this.lAd = amVar.lzM;
            this.lAe = amVar.lzN;
            this.lAf = amVar.lzO;
            if (this.lAd != null) {
                this.lzS.startLoad(this.lAd.eAq, 10, false);
                this.lzU.setText(this.lAd.summary);
                this.lzV.setText(this.lAd.subtitle);
                this.lzT.setText(this.lAd.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzT, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.lzT, R.drawable.news_text_color_selector);
            } else {
                this.lzR.setVisibility(8);
            }
            if (this.lAe != null) {
                this.lzY.setText(this.lAe.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lzX, R.drawable.icon_frs_news);
            } else {
                this.lzW.setVisibility(8);
                this.lzY.setVisibility(8);
                this.lzX.setVisibility(8);
            }
            if (this.lAf != null) {
                this.lAb.setText(this.lAf.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.lAa, R.drawable.icon_frs_game);
            } else {
                this.lzZ.setVisibility(8);
                this.lAb.setVisibility(8);
                this.lAb.setVisibility(8);
            }
            this.lzP.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eGu.getLayoutMode().setNightMode(i == 1);
            this.eGu.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.lzR.setOnClickListener(onClickListener);
        this.lzW.setOnClickListener(onClickListener);
        this.lzZ.setOnClickListener(onClickListener);
    }
}

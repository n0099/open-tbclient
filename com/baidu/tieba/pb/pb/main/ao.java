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
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ao extends af.a {
    View.OnClickListener aBS;
    private TbPageContext ehG;
    public LinearLayout kRK;
    public View kRL;
    public RelativeLayout kRM;
    public TbImageView kRN;
    public TextView kRO;
    public TextView kRP;
    public TextView kRQ;
    public LinearLayout kRR;
    public ImageView kRS;
    public TextView kRT;
    public LinearLayout kRU;
    public ImageView kRV;
    public TextView kRW;
    public View kRX;
    private com.baidu.tbadk.core.data.ay kRY;
    private com.baidu.tbadk.core.data.ay kRZ;
    private com.baidu.tbadk.core.data.ay kSa;
    private am kSb;
    private a kSc;
    private int mSkinType;

    /* loaded from: classes21.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.ehG.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.kSc != null) {
                        ao.this.kSc.b(ao.this.kSb);
                    }
                    if (view2 == ao.this.kRM) {
                        if (ao.this.kRY != null && !TextUtils.isEmpty(ao.this.kRY.ebD)) {
                            com.baidu.tbadk.core.util.be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.ehG.getPageActivity()), new String[]{ao.this.kRY.ebD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dF("obj_source", ao.this.kRY.ebD));
                        }
                    } else if (view2 == ao.this.kRR) {
                        BdLog.e("link: " + ao.this.kRZ.ebD);
                        if (ao.this.kRZ != null && !TextUtils.isEmpty(ao.this.kRZ.ebD)) {
                            com.baidu.tbadk.core.util.be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.ehG.getPageActivity()), new String[]{ao.this.kRZ.ebD});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dF("obj_source", ao.this.kRZ.ebD));
                        }
                    } else if (view2 == ao.this.kRU && ao.this.kSa != null && !TextUtils.isEmpty(ao.this.kSa.ebD)) {
                        com.baidu.tbadk.core.util.be.bkp().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.ehG.getPageActivity()), new String[]{ao.this.kSa.ebD});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dF("obj_source", ao.this.kSa.ebD));
                    }
                }
            }
        };
        this.ehG = tbPageContext;
        this.kSc = aVar;
        this.kRK = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.kRL = view.findViewById(R.id.pb_list_item_top_line);
        this.kRM = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.kRN = (TbImageView) view.findViewById(R.id.top_code_img);
        this.kRO = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.kRP = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.kRQ = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.kRR = (LinearLayout) view.findViewById(R.id.news_info);
        this.kRS = (ImageView) view.findViewById(R.id.news_info_img);
        this.kRT = (TextView) view.findViewById(R.id.news_info_text);
        this.kRU = (LinearLayout) view.findViewById(R.id.game_info);
        this.kRV = (ImageView) view.findViewById(R.id.game_info_img);
        this.kRW = (TextView) view.findViewById(R.id.game_info_text);
        this.kRX = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aBS);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.kSb = amVar;
            this.kRY = amVar.kRH;
            this.kRZ = amVar.kRI;
            this.kSa = amVar.kRJ;
            if (this.kRY != null) {
                this.kRN.startLoad(this.kRY.ebE, 10, false);
                this.kRP.setText(this.kRY.summary);
                this.kRQ.setText(this.kRY.subtitle);
                this.kRO.setText(this.kRY.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kRO, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.kRO, R.drawable.news_text_color_selector);
            } else {
                this.kRM.setVisibility(8);
            }
            if (this.kRZ != null) {
                this.kRT.setText(this.kRZ.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kRS, R.drawable.icon_frs_news);
            } else {
                this.kRR.setVisibility(8);
                this.kRT.setVisibility(8);
                this.kRS.setVisibility(8);
            }
            if (this.kSa != null) {
                this.kRW.setText(this.kSa.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.kRV, R.drawable.icon_frs_game);
            } else {
                this.kRU.setVisibility(8);
                this.kRW.setVisibility(8);
                this.kRW.setVisibility(8);
            }
            this.kRK.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ehG.getLayoutMode().setNightMode(i == 1);
            this.ehG.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.kRM.setOnClickListener(onClickListener);
        this.kRR.setOnClickListener(onClickListener);
        this.kRU.setOnClickListener(onClickListener);
    }
}

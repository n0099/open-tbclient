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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener dSO;
    public LinearLayout hLE;
    public View hLF;
    public RelativeLayout hLG;
    public TbImageView hLH;
    public TextView hLI;
    public TextView hLJ;
    public TextView hLK;
    public LinearLayout hLL;
    public ImageView hLM;
    public TextView hLN;
    public LinearLayout hLO;
    public ImageView hLP;
    public TextView hLQ;
    public View hLR;
    private com.baidu.tbadk.core.data.ap hLS;
    private com.baidu.tbadk.core.data.ap hLT;
    private com.baidu.tbadk.core.data.ap hLU;
    private ad hLV;
    private a hLW;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dSO = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ki()) {
                    if (af.this.hLW != null) {
                        af.this.hLW.b(af.this.hLV);
                    }
                    if (view2 == af.this.hLG) {
                        if (af.this.hLS != null && !TextUtils.isEmpty(af.this.hLS.bGV)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLS.bGV});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLS.bGV));
                        }
                    } else if (view2 == af.this.hLL) {
                        BdLog.e("link: " + af.this.hLT.bGV);
                        if (af.this.hLT != null && !TextUtils.isEmpty(af.this.hLT.bGV)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLT.bGV});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLT.bGV));
                        }
                    } else if (view2 == af.this.hLO && af.this.hLU != null && !TextUtils.isEmpty(af.this.hLU.bGV)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLU.bGV});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLU.bGV));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hLW = aVar;
        this.hLE = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hLF = view.findViewById(R.id.pb_list_item_top_line);
        this.hLG = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hLH = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hLI = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hLJ = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hLK = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hLL = (LinearLayout) view.findViewById(R.id.news_info);
        this.hLM = (ImageView) view.findViewById(R.id.news_info_img);
        this.hLN = (TextView) view.findViewById(R.id.news_info_text);
        this.hLO = (LinearLayout) view.findViewById(R.id.game_info);
        this.hLP = (ImageView) view.findViewById(R.id.game_info_img);
        this.hLQ = (TextView) view.findViewById(R.id.game_info_text);
        this.hLR = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dSO);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hLV = adVar;
            this.hLS = adVar.hLB;
            this.hLT = adVar.hLC;
            this.hLU = adVar.hLD;
            if (this.hLS != null) {
                this.hLH.startLoad(this.hLS.bGX, 10, false);
                this.hLJ.setText(this.hLS.summary);
                this.hLK.setText(this.hLS.subtitle);
                this.hLI.setText(this.hLS.buttonText);
                com.baidu.tbadk.core.util.al.k(this.hLI, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.hLI, R.drawable.news_text_color_selector);
            } else {
                this.hLG.setVisibility(8);
            }
            if (this.hLT != null) {
                this.hLN.setText(this.hLT.summary);
                com.baidu.tbadk.core.util.al.k(this.hLM, R.drawable.icon_frs_news);
            } else {
                this.hLL.setVisibility(8);
                this.hLN.setVisibility(8);
                this.hLM.setVisibility(8);
            }
            if (this.hLU != null) {
                this.hLQ.setText(this.hLU.summary);
                com.baidu.tbadk.core.util.al.k(this.hLP, R.drawable.icon_frs_game);
            } else {
                this.hLO.setVisibility(8);
                this.hLQ.setVisibility(8);
                this.hLQ.setVisibility(8);
            }
            this.hLE.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mContext.getLayoutMode().setNightMode(i == 1);
            this.mContext.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hLG.setOnClickListener(onClickListener);
        this.hLL.setOnClickListener(onClickListener);
        this.hLO.setOnClickListener(onClickListener);
    }
}

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
    View.OnClickListener dSP;
    public LinearLayout hLH;
    public View hLI;
    public RelativeLayout hLJ;
    public TbImageView hLK;
    public TextView hLL;
    public TextView hLM;
    public TextView hLN;
    public LinearLayout hLO;
    public ImageView hLP;
    public TextView hLQ;
    public LinearLayout hLR;
    public ImageView hLS;
    public TextView hLT;
    public View hLU;
    private com.baidu.tbadk.core.data.ap hLV;
    private com.baidu.tbadk.core.data.ap hLW;
    private com.baidu.tbadk.core.data.ap hLX;
    private ad hLY;
    private a hLZ;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dSP = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cE(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.ki()) {
                    if (af.this.hLZ != null) {
                        af.this.hLZ.b(af.this.hLY);
                    }
                    if (view2 == af.this.hLJ) {
                        if (af.this.hLV != null && !TextUtils.isEmpty(af.this.hLV.bGV)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLV.bGV});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLV.bGV));
                        }
                    } else if (view2 == af.this.hLO) {
                        BdLog.e("link: " + af.this.hLW.bGV);
                        if (af.this.hLW != null && !TextUtils.isEmpty(af.this.hLW.bGV)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLW.bGV});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLW.bGV));
                        }
                    } else if (view2 == af.this.hLR && af.this.hLX != null && !TextUtils.isEmpty(af.this.hLX.bGV)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLX.bGV});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLX.bGV));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hLZ = aVar;
        this.hLH = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hLI = view.findViewById(R.id.pb_list_item_top_line);
        this.hLJ = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hLK = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hLL = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hLM = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hLN = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hLO = (LinearLayout) view.findViewById(R.id.news_info);
        this.hLP = (ImageView) view.findViewById(R.id.news_info_img);
        this.hLQ = (TextView) view.findViewById(R.id.news_info_text);
        this.hLR = (LinearLayout) view.findViewById(R.id.game_info);
        this.hLS = (ImageView) view.findViewById(R.id.game_info_img);
        this.hLT = (TextView) view.findViewById(R.id.game_info_text);
        this.hLU = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dSP);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hLY = adVar;
            this.hLV = adVar.hLE;
            this.hLW = adVar.hLF;
            this.hLX = adVar.hLG;
            if (this.hLV != null) {
                this.hLK.startLoad(this.hLV.bGX, 10, false);
                this.hLM.setText(this.hLV.summary);
                this.hLN.setText(this.hLV.subtitle);
                this.hLL.setText(this.hLV.buttonText);
                com.baidu.tbadk.core.util.al.k(this.hLL, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.hLL, R.drawable.news_text_color_selector);
            } else {
                this.hLJ.setVisibility(8);
            }
            if (this.hLW != null) {
                this.hLQ.setText(this.hLW.summary);
                com.baidu.tbadk.core.util.al.k(this.hLP, R.drawable.icon_frs_news);
            } else {
                this.hLO.setVisibility(8);
                this.hLQ.setVisibility(8);
                this.hLP.setVisibility(8);
            }
            if (this.hLX != null) {
                this.hLT.setText(this.hLX.summary);
                com.baidu.tbadk.core.util.al.k(this.hLS, R.drawable.icon_frs_game);
            } else {
                this.hLR.setVisibility(8);
                this.hLT.setVisibility(8);
                this.hLT.setVisibility(8);
            }
            this.hLH.setTag(adVar);
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
        this.hLJ.setOnClickListener(onClickListener);
        this.hLO.setOnClickListener(onClickListener);
        this.hLR.setOnClickListener(onClickListener);
    }
}

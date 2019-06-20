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
    public LinearLayout hLI;
    public View hLJ;
    public RelativeLayout hLK;
    public TbImageView hLL;
    public TextView hLM;
    public TextView hLN;
    public TextView hLO;
    public LinearLayout hLP;
    public ImageView hLQ;
    public TextView hLR;
    public LinearLayout hLS;
    public ImageView hLT;
    public TextView hLU;
    public View hLV;
    private com.baidu.tbadk.core.data.ap hLW;
    private com.baidu.tbadk.core.data.ap hLX;
    private com.baidu.tbadk.core.data.ap hLY;
    private ad hLZ;
    private a hMa;
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
                    if (af.this.hMa != null) {
                        af.this.hMa.b(af.this.hLZ);
                    }
                    if (view2 == af.this.hLK) {
                        if (af.this.hLW != null && !TextUtils.isEmpty(af.this.hLW.bGW)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLW.bGW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLW.bGW));
                        }
                    } else if (view2 == af.this.hLP) {
                        BdLog.e("link: " + af.this.hLX.bGW);
                        if (af.this.hLX != null && !TextUtils.isEmpty(af.this.hLX.bGW)) {
                            ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLX.bGW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLX.bGW));
                        }
                    } else if (view2 == af.this.hLS && af.this.hLY != null && !TextUtils.isEmpty(af.this.hLY.bGW)) {
                        ba.aiz().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hLY.bGW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.am("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hLY.bGW));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hMa = aVar;
        this.hLI = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hLJ = view.findViewById(R.id.pb_list_item_top_line);
        this.hLK = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hLL = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hLM = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hLN = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hLO = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hLP = (LinearLayout) view.findViewById(R.id.news_info);
        this.hLQ = (ImageView) view.findViewById(R.id.news_info_img);
        this.hLR = (TextView) view.findViewById(R.id.news_info_text);
        this.hLS = (LinearLayout) view.findViewById(R.id.game_info);
        this.hLT = (ImageView) view.findViewById(R.id.game_info_img);
        this.hLU = (TextView) view.findViewById(R.id.game_info_text);
        this.hLV = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dSP);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hLZ = adVar;
            this.hLW = adVar.hLF;
            this.hLX = adVar.hLG;
            this.hLY = adVar.hLH;
            if (this.hLW != null) {
                this.hLL.startLoad(this.hLW.bGY, 10, false);
                this.hLN.setText(this.hLW.summary);
                this.hLO.setText(this.hLW.subtitle);
                this.hLM.setText(this.hLW.buttonText);
                com.baidu.tbadk.core.util.al.k(this.hLM, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.al.j(this.hLM, R.drawable.news_text_color_selector);
            } else {
                this.hLK.setVisibility(8);
            }
            if (this.hLX != null) {
                this.hLR.setText(this.hLX.summary);
                com.baidu.tbadk.core.util.al.k(this.hLQ, R.drawable.icon_frs_news);
            } else {
                this.hLP.setVisibility(8);
                this.hLR.setVisibility(8);
                this.hLQ.setVisibility(8);
            }
            if (this.hLY != null) {
                this.hLU.setText(this.hLY.summary);
                com.baidu.tbadk.core.util.al.k(this.hLT, R.drawable.icon_frs_game);
            } else {
                this.hLS.setVisibility(8);
                this.hLU.setVisibility(8);
                this.hLU.setVisibility(8);
            }
            this.hLI.setTag(adVar);
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
        this.hLK.setOnClickListener(onClickListener);
        this.hLP.setOnClickListener(onClickListener);
        this.hLS.setOnClickListener(onClickListener);
    }
}

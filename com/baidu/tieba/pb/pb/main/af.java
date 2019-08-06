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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener dWR;
    public LinearLayout hSQ;
    public View hSR;
    public RelativeLayout hSS;
    public TbImageView hST;
    public TextView hSU;
    public TextView hSV;
    public TextView hSW;
    public LinearLayout hSX;
    public ImageView hSY;
    public TextView hSZ;
    public LinearLayout hTa;
    public ImageView hTb;
    public TextView hTc;
    public View hTd;
    private com.baidu.tbadk.core.data.ap hTe;
    private com.baidu.tbadk.core.data.ap hTf;
    private com.baidu.tbadk.core.data.ap hTg;
    private ad hTh;
    private a hTi;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dWR = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt()) {
                    if (af.this.hTi != null) {
                        af.this.hTi.b(af.this.hTh);
                    }
                    if (view2 == af.this.hSS) {
                        if (af.this.hTe != null && !TextUtils.isEmpty(af.this.hTe.bHX)) {
                            bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hTe.bHX});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hTe.bHX));
                        }
                    } else if (view2 == af.this.hSX) {
                        BdLog.e("link: " + af.this.hTf.bHX);
                        if (af.this.hTf != null && !TextUtils.isEmpty(af.this.hTf.bHX)) {
                            bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hTf.bHX});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hTf.bHX));
                        }
                    } else if (view2 == af.this.hTa && af.this.hTg != null && !TextUtils.isEmpty(af.this.hTg.bHX)) {
                        bb.ajE().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hTg.bHX});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hTg.bHX));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hTi = aVar;
        this.hSQ = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hSR = view.findViewById(R.id.pb_list_item_top_line);
        this.hSS = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hST = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hSU = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hSV = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hSW = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hSX = (LinearLayout) view.findViewById(R.id.news_info);
        this.hSY = (ImageView) view.findViewById(R.id.news_info_img);
        this.hSZ = (TextView) view.findViewById(R.id.news_info_text);
        this.hTa = (LinearLayout) view.findViewById(R.id.game_info);
        this.hTb = (ImageView) view.findViewById(R.id.game_info_img);
        this.hTc = (TextView) view.findViewById(R.id.game_info_text);
        this.hTd = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dWR);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hTh = adVar;
            this.hTe = adVar.hSN;
            this.hTf = adVar.hSO;
            this.hTg = adVar.hSP;
            if (this.hTe != null) {
                this.hST.startLoad(this.hTe.bHZ, 10, false);
                this.hSV.setText(this.hTe.summary);
                this.hSW.setText(this.hTe.subtitle);
                this.hSU.setText(this.hTe.buttonText);
                com.baidu.tbadk.core.util.am.k(this.hSU, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.j(this.hSU, R.drawable.news_text_color_selector);
            } else {
                this.hSS.setVisibility(8);
            }
            if (this.hTf != null) {
                this.hSZ.setText(this.hTf.summary);
                com.baidu.tbadk.core.util.am.k(this.hSY, R.drawable.icon_frs_news);
            } else {
                this.hSX.setVisibility(8);
                this.hSZ.setVisibility(8);
                this.hSY.setVisibility(8);
            }
            if (this.hTg != null) {
                this.hTc.setText(this.hTg.summary);
                com.baidu.tbadk.core.util.am.k(this.hTb, R.drawable.icon_frs_game);
            } else {
                this.hTa.setVisibility(8);
                this.hTc.setVisibility(8);
                this.hTc.setVisibility(8);
            }
            this.hSQ.setTag(adVar);
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
        this.hSS.setOnClickListener(onClickListener);
        this.hSX.setOnClickListener(onClickListener);
        this.hTa.setOnClickListener(onClickListener);
    }
}

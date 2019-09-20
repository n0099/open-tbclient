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
    View.OnClickListener dYB;
    public LinearLayout hUN;
    public View hUO;
    public RelativeLayout hUP;
    public TbImageView hUQ;
    public TextView hUR;
    public TextView hUS;
    public TextView hUT;
    public LinearLayout hUU;
    public ImageView hUV;
    public TextView hUW;
    public LinearLayout hUX;
    public ImageView hUY;
    public TextView hUZ;
    public View hVa;
    private com.baidu.tbadk.core.data.ap hVb;
    private com.baidu.tbadk.core.data.ap hVc;
    private com.baidu.tbadk.core.data.ap hVd;
    private ad hVe;
    private a hVf;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.cF(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt()) {
                    if (af.this.hVf != null) {
                        af.this.hVf.b(af.this.hVe);
                    }
                    if (view2 == af.this.hUP) {
                        if (af.this.hVb != null && !TextUtils.isEmpty(af.this.hVb.bIv)) {
                            ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hVb.bIv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hVb.bIv));
                        }
                    } else if (view2 == af.this.hUU) {
                        BdLog.e("link: " + af.this.hVc.bIv);
                        if (af.this.hVc != null && !TextUtils.isEmpty(af.this.hVc.bIv)) {
                            ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hVc.bIv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hVc.bIv));
                        }
                    } else if (view2 == af.this.hUX && af.this.hVd != null && !TextUtils.isEmpty(af.this.hVd.bIv)) {
                        ba.ajK().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hVd.bIv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hVd.bIv));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hVf = aVar;
        this.hUN = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hUO = view.findViewById(R.id.pb_list_item_top_line);
        this.hUP = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hUQ = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hUR = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hUS = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hUT = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hUU = (LinearLayout) view.findViewById(R.id.news_info);
        this.hUV = (ImageView) view.findViewById(R.id.news_info_img);
        this.hUW = (TextView) view.findViewById(R.id.news_info_text);
        this.hUX = (LinearLayout) view.findViewById(R.id.game_info);
        this.hUY = (ImageView) view.findViewById(R.id.game_info_img);
        this.hUZ = (TextView) view.findViewById(R.id.game_info_text);
        this.hVa = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dYB);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hVe = adVar;
            this.hVb = adVar.hUK;
            this.hVc = adVar.hUL;
            this.hVd = adVar.hUM;
            if (this.hVb != null) {
                this.hUQ.startLoad(this.hVb.bIx, 10, false);
                this.hUS.setText(this.hVb.summary);
                this.hUT.setText(this.hVb.subtitle);
                this.hUR.setText(this.hVb.buttonText);
                com.baidu.tbadk.core.util.am.k(this.hUR, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.j(this.hUR, R.drawable.news_text_color_selector);
            } else {
                this.hUP.setVisibility(8);
            }
            if (this.hVc != null) {
                this.hUW.setText(this.hVc.summary);
                com.baidu.tbadk.core.util.am.k(this.hUV, R.drawable.icon_frs_news);
            } else {
                this.hUU.setVisibility(8);
                this.hUW.setVisibility(8);
                this.hUV.setVisibility(8);
            }
            if (this.hVd != null) {
                this.hUZ.setText(this.hVd.summary);
                com.baidu.tbadk.core.util.am.k(this.hUY, R.drawable.icon_frs_game);
            } else {
                this.hUX.setVisibility(8);
                this.hUZ.setVisibility(8);
                this.hUZ.setVisibility(8);
            }
            this.hUN.setTag(adVar);
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
        this.hUP.setOnClickListener(onClickListener);
        this.hUU.setOnClickListener(onClickListener);
        this.hUX.setOnClickListener(onClickListener);
    }
}

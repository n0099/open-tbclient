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
    View.OnClickListener dWK;
    public LinearLayout hRV;
    public View hRW;
    public RelativeLayout hRX;
    public TbImageView hRY;
    public TextView hRZ;
    public TextView hSa;
    public TextView hSb;
    public LinearLayout hSc;
    public ImageView hSd;
    public TextView hSe;
    public LinearLayout hSf;
    public ImageView hSg;
    public TextView hSh;
    public View hSi;
    private com.baidu.tbadk.core.data.ap hSj;
    private com.baidu.tbadk.core.data.ap hSk;
    private com.baidu.tbadk.core.data.ap hSl;
    private ad hSm;
    private a hSn;
    private TbPageContext mContext;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.dWK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bd.cF(af.this.mContext.getPageActivity()) && com.baidu.adp.lib.util.l.kt()) {
                    if (af.this.hSn != null) {
                        af.this.hSn.b(af.this.hSm);
                    }
                    if (view2 == af.this.hRX) {
                        if (af.this.hSj != null && !TextUtils.isEmpty(af.this.hSj.bHW)) {
                            bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hSj.bHW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hSj.bHW));
                        }
                    } else if (view2 == af.this.hSc) {
                        BdLog.e("link: " + af.this.hSk.bHW);
                        if (af.this.hSk != null && !TextUtils.isEmpty(af.this.hSk.bHW)) {
                            bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hSk.bHW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hSk.bHW));
                        }
                    } else if (view2 == af.this.hSf && af.this.hSl != null && !TextUtils.isEmpty(af.this.hSl.bHW)) {
                        bb.ajC().c((TbPageContext) com.baidu.adp.base.i.ab(af.this.mContext.getPageActivity()), new String[]{af.this.hSl.bHW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, af.this.hSl.bHW));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hSn = aVar;
        this.hRV = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hRW = view.findViewById(R.id.pb_list_item_top_line);
        this.hRX = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hRY = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hRZ = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hSa = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hSb = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hSc = (LinearLayout) view.findViewById(R.id.news_info);
        this.hSd = (ImageView) view.findViewById(R.id.news_info_img);
        this.hSe = (TextView) view.findViewById(R.id.news_info_text);
        this.hSf = (LinearLayout) view.findViewById(R.id.game_info);
        this.hSg = (ImageView) view.findViewById(R.id.game_info_img);
        this.hSh = (TextView) view.findViewById(R.id.game_info_text);
        this.hSi = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.dWK);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hSm = adVar;
            this.hSj = adVar.hRS;
            this.hSk = adVar.hRT;
            this.hSl = adVar.hRU;
            if (this.hSj != null) {
                this.hRY.startLoad(this.hSj.bHY, 10, false);
                this.hSa.setText(this.hSj.summary);
                this.hSb.setText(this.hSj.subtitle);
                this.hRZ.setText(this.hSj.buttonText);
                com.baidu.tbadk.core.util.am.k(this.hRZ, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.j(this.hRZ, R.drawable.news_text_color_selector);
            } else {
                this.hRX.setVisibility(8);
            }
            if (this.hSk != null) {
                this.hSe.setText(this.hSk.summary);
                com.baidu.tbadk.core.util.am.k(this.hSd, R.drawable.icon_frs_news);
            } else {
                this.hSc.setVisibility(8);
                this.hSe.setVisibility(8);
                this.hSd.setVisibility(8);
            }
            if (this.hSl != null) {
                this.hSh.setText(this.hSl.summary);
                com.baidu.tbadk.core.util.am.k(this.hSg, R.drawable.icon_frs_game);
            } else {
                this.hSf.setVisibility(8);
                this.hSh.setVisibility(8);
                this.hSh.setVisibility(8);
            }
            this.hRV.setTag(adVar);
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
        this.hRX.setOnClickListener(onClickListener);
        this.hSc.setOnClickListener(onClickListener);
        this.hSf.setOnClickListener(onClickListener);
    }
}

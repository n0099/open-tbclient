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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class af extends v.a {
    View.OnClickListener aju;
    private TbPageContext cfl;
    public TextView hTA;
    public TextView hTB;
    public LinearLayout hTC;
    public ImageView hTD;
    public TextView hTE;
    public LinearLayout hTF;
    public ImageView hTG;
    public TextView hTH;
    public View hTI;
    private com.baidu.tbadk.core.data.ap hTJ;
    private com.baidu.tbadk.core.data.ap hTK;
    private com.baidu.tbadk.core.data.ap hTL;
    private ad hTM;
    private a hTN;
    public LinearLayout hTv;
    public View hTw;
    public RelativeLayout hTx;
    public TbImageView hTy;
    public TextView hTz;
    private int mSkinType;

    /* loaded from: classes4.dex */
    public interface a {
        void b(ad adVar);
    }

    public af(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.af.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(af.this.cfl.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (af.this.hTN != null) {
                        af.this.hTN.b(af.this.hTM);
                    }
                    if (view2 == af.this.hTx) {
                        if (af.this.hTJ != null && !TextUtils.isEmpty(af.this.hTJ.cac)) {
                            ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.cfl.getPageActivity()), new String[]{af.this.hTJ.cac});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").bS("obj_source", af.this.hTJ.cac));
                        }
                    } else if (view2 == af.this.hTC) {
                        BdLog.e("link: " + af.this.hTK.cac);
                        if (af.this.hTK != null && !TextUtils.isEmpty(af.this.hTK.cac)) {
                            ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.cfl.getPageActivity()), new String[]{af.this.hTK.cac});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").bS("obj_source", af.this.hTK.cac));
                        }
                    } else if (view2 == af.this.hTF && af.this.hTL != null && !TextUtils.isEmpty(af.this.hTL.cac)) {
                        ba.amQ().b((TbPageContext) com.baidu.adp.base.i.ab(af.this.cfl.getPageActivity()), new String[]{af.this.hTL.cac});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").bS("obj_source", af.this.hTL.cac));
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.hTN = aVar;
        this.hTv = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.hTw = view.findViewById(R.id.pb_list_item_top_line);
        this.hTx = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.hTy = (TbImageView) view.findViewById(R.id.top_code_img);
        this.hTz = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.hTA = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.hTB = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.hTC = (LinearLayout) view.findViewById(R.id.news_info);
        this.hTD = (ImageView) view.findViewById(R.id.news_info_img);
        this.hTE = (TextView) view.findViewById(R.id.news_info_text);
        this.hTF = (LinearLayout) view.findViewById(R.id.game_info);
        this.hTG = (ImageView) view.findViewById(R.id.game_info_img);
        this.hTH = (TextView) view.findViewById(R.id.game_info_text);
        this.hTI = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aju);
    }

    public void a(ad adVar) {
        if (adVar != null) {
            this.hTM = adVar;
            this.hTJ = adVar.hTs;
            this.hTK = adVar.hTt;
            this.hTL = adVar.hTu;
            if (this.hTJ != null) {
                this.hTy.startLoad(this.hTJ.cae, 10, false);
                this.hTA.setText(this.hTJ.summary);
                this.hTB.setText(this.hTJ.subtitle);
                this.hTz.setText(this.hTJ.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTz, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.hTz, (int) R.drawable.news_text_color_selector);
            } else {
                this.hTx.setVisibility(8);
            }
            if (this.hTK != null) {
                this.hTE.setText(this.hTK.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTD, R.drawable.icon_frs_news);
            } else {
                this.hTC.setVisibility(8);
                this.hTE.setVisibility(8);
                this.hTD.setVisibility(8);
            }
            if (this.hTL != null) {
                this.hTH.setText(this.hTL.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.hTG, R.drawable.icon_frs_game);
            } else {
                this.hTF.setVisibility(8);
                this.hTH.setVisibility(8);
                this.hTH.setVisibility(8);
            }
            this.hTv.setTag(adVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cfl.getLayoutMode().setNightMode(i == 1);
            this.cfl.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hTx.setOnClickListener(onClickListener);
        this.hTC.setOnClickListener(onClickListener);
        this.hTF.setOnClickListener(onClickListener);
    }
}

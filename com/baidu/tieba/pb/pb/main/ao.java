package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class ao extends ad.a {
    View.OnClickListener awi;
    private TbPageContext dVN;
    public RelativeLayout ktA;
    public TbImageView ktB;
    public TextView ktC;
    public TextView ktD;
    public TextView ktE;
    public LinearLayout ktF;
    public ImageView ktG;
    public TextView ktH;
    public LinearLayout ktI;
    public ImageView ktJ;
    public TextView ktK;
    public View ktL;
    private com.baidu.tbadk.core.data.ax ktM;
    private com.baidu.tbadk.core.data.ax ktN;
    private com.baidu.tbadk.core.data.ax ktO;
    private am ktP;
    private a ktQ;
    public LinearLayout kty;
    public View ktz;
    private int mSkinType;

    /* loaded from: classes16.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.awi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bf.checkUpIsLogin(ao.this.dVN.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.ktQ != null) {
                        ao.this.ktQ.b(ao.this.ktP);
                    }
                    if (view2 == ao.this.ktA) {
                        if (ao.this.ktM != null && !TextUtils.isEmpty(ao.this.ktM.dPW)) {
                            com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktM.dPW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11410").dn("obj_source", ao.this.ktM.dPW));
                        }
                    } else if (view2 == ao.this.ktF) {
                        BdLog.e("link: " + ao.this.ktN.dPW);
                        if (ao.this.ktN != null && !TextUtils.isEmpty(ao.this.ktN.dPW)) {
                            com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktN.dPW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11409").dn("obj_source", ao.this.ktN.dPW));
                        }
                    } else if (view2 == ao.this.ktI && ao.this.ktO != null && !TextUtils.isEmpty(ao.this.ktO.dPW)) {
                        com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktO.dPW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11408").dn("obj_source", ao.this.ktO.dPW));
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.ktQ = aVar;
        this.kty = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.ktz = view.findViewById(R.id.pb_list_item_top_line);
        this.ktA = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.ktB = (TbImageView) view.findViewById(R.id.top_code_img);
        this.ktC = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.ktD = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.ktE = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.ktF = (LinearLayout) view.findViewById(R.id.news_info);
        this.ktG = (ImageView) view.findViewById(R.id.news_info_img);
        this.ktH = (TextView) view.findViewById(R.id.news_info_text);
        this.ktI = (LinearLayout) view.findViewById(R.id.game_info);
        this.ktJ = (ImageView) view.findViewById(R.id.game_info_img);
        this.ktK = (TextView) view.findViewById(R.id.game_info_text);
        this.ktL = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.awi);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.ktP = amVar;
            this.ktM = amVar.ktv;
            this.ktN = amVar.ktw;
            this.ktO = amVar.ktx;
            if (this.ktM != null) {
                this.ktB.startLoad(this.ktM.dPX, 10, false);
                this.ktD.setText(this.ktM.summary);
                this.ktE.setText(this.ktM.subtitle);
                this.ktC.setText(this.ktM.buttonText);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktC, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktC, R.drawable.news_text_color_selector);
            } else {
                this.ktA.setVisibility(8);
            }
            if (this.ktN != null) {
                this.ktH.setText(this.ktN.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktG, R.drawable.icon_frs_news);
            } else {
                this.ktF.setVisibility(8);
                this.ktH.setVisibility(8);
                this.ktG.setVisibility(8);
            }
            if (this.ktO != null) {
                this.ktK.setText(this.ktO.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktJ, R.drawable.icon_frs_game);
            } else {
                this.ktI.setVisibility(8);
                this.ktK.setVisibility(8);
                this.ktK.setVisibility(8);
            }
            this.kty.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.dVN.getLayoutMode().setNightMode(i == 1);
            this.dVN.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ktA.setOnClickListener(onClickListener);
        this.ktF.setOnClickListener(onClickListener);
        this.ktI.setOnClickListener(onClickListener);
    }
}

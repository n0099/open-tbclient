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
    public TextView ktA;
    public TextView ktB;
    public TextView ktC;
    public LinearLayout ktD;
    public ImageView ktE;
    public TextView ktF;
    public LinearLayout ktG;
    public ImageView ktH;
    public TextView ktI;
    public View ktJ;
    private com.baidu.tbadk.core.data.ax ktK;
    private com.baidu.tbadk.core.data.ax ktL;
    private com.baidu.tbadk.core.data.ax ktM;
    private am ktN;
    private a ktO;
    public LinearLayout ktw;
    public View ktx;
    public RelativeLayout kty;
    public TbImageView ktz;
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
                    if (ao.this.ktO != null) {
                        ao.this.ktO.b(ao.this.ktN);
                    }
                    if (view2 == ao.this.kty) {
                        if (ao.this.ktK != null && !TextUtils.isEmpty(ao.this.ktK.dPW)) {
                            com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktK.dPW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11410").dn("obj_source", ao.this.ktK.dPW));
                        }
                    } else if (view2 == ao.this.ktD) {
                        BdLog.e("link: " + ao.this.ktL.dPW);
                        if (ao.this.ktL != null && !TextUtils.isEmpty(ao.this.ktL.dPW)) {
                            com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktL.dPW});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11409").dn("obj_source", ao.this.ktL.dPW));
                        }
                    } else if (view2 == ao.this.ktG && ao.this.ktM != null && !TextUtils.isEmpty(ao.this.ktM.dPW)) {
                        com.baidu.tbadk.core.util.bd.baV().b((TbPageContext) com.baidu.adp.base.i.G(ao.this.dVN.getPageActivity()), new String[]{ao.this.ktM.dPW});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ap("c11408").dn("obj_source", ao.this.ktM.dPW));
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.ktO = aVar;
        this.ktw = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.ktx = view.findViewById(R.id.pb_list_item_top_line);
        this.kty = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.ktz = (TbImageView) view.findViewById(R.id.top_code_img);
        this.ktA = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.ktB = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.ktC = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.ktD = (LinearLayout) view.findViewById(R.id.news_info);
        this.ktE = (ImageView) view.findViewById(R.id.news_info_img);
        this.ktF = (TextView) view.findViewById(R.id.news_info_text);
        this.ktG = (LinearLayout) view.findViewById(R.id.game_info);
        this.ktH = (ImageView) view.findViewById(R.id.game_info_img);
        this.ktI = (TextView) view.findViewById(R.id.game_info_text);
        this.ktJ = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.awi);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.ktN = amVar;
            this.ktK = amVar.ktt;
            this.ktL = amVar.ktu;
            this.ktM = amVar.ktv;
            if (this.ktK != null) {
                this.ktz.startLoad(this.ktK.dPX, 10, false);
                this.ktB.setText(this.ktK.summary);
                this.ktC.setText(this.ktK.subtitle);
                this.ktA.setText(this.ktK.buttonText);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktA, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ao.setViewTextColor(this.ktA, R.drawable.news_text_color_selector);
            } else {
                this.kty.setVisibility(8);
            }
            if (this.ktL != null) {
                this.ktF.setText(this.ktL.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktE, R.drawable.icon_frs_news);
            } else {
                this.ktD.setVisibility(8);
                this.ktF.setVisibility(8);
                this.ktE.setVisibility(8);
            }
            if (this.ktM != null) {
                this.ktI.setText(this.ktM.summary);
                com.baidu.tbadk.core.util.ao.setBackgroundResource(this.ktH, R.drawable.icon_frs_game);
            } else {
                this.ktG.setVisibility(8);
                this.ktI.setVisibility(8);
                this.ktI.setVisibility(8);
            }
            this.ktw.setTag(amVar);
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
        this.kty.setOnClickListener(onClickListener);
        this.ktD.setOnClickListener(onClickListener);
        this.ktG.setOnClickListener(onClickListener);
    }
}

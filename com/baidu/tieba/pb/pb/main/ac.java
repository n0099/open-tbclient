package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ac extends j.a {
    private TbPageContext abI;
    View.OnClickListener byr;
    public LinearLayout eQB;
    public View eQC;
    public RelativeLayout eQD;
    public TbImageView eQE;
    public TextView eQF;
    public TextView eQG;
    public TextView eQH;
    public LinearLayout eQI;
    public ImageView eQJ;
    public TextView eQK;
    public LinearLayout eQL;
    public ImageView eQM;
    public TextView eQN;
    public View eQO;
    private com.baidu.tbadk.core.data.ar eQP;
    private com.baidu.tbadk.core.data.ar eQQ;
    private com.baidu.tbadk.core.data.ar eQR;
    private int mSkinType;

    public ac(TbPageContext tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ac.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ax.aT(ac.this.abI.getPageActivity()) && com.baidu.adp.lib.util.l.hy()) {
                    if (view2 == ac.this.eQD) {
                        if (ac.this.eQP != null && !TextUtils.isEmpty(ac.this.eQP.Xv)) {
                            av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQP.Xv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11410").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQP.Xv));
                        }
                    } else if (view2 == ac.this.eQI) {
                        BdLog.e("link: " + ac.this.eQQ.Xv);
                        if (ac.this.eQQ != null && !TextUtils.isEmpty(ac.this.eQQ.Xv)) {
                            av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQQ.Xv});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11409").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQQ.Xv));
                        }
                    } else if (view2 == ac.this.eQL && ac.this.eQR != null && !TextUtils.isEmpty(ac.this.eQR.Xv)) {
                        av.vI().c((TbPageContext) com.baidu.adp.base.i.Y(ac.this.abI.getPageActivity()), new String[]{ac.this.eQR.Xv});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c11408").ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, ac.this.eQR.Xv));
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.eQB = (LinearLayout) view.findViewById(d.g.pb_news_info_layout);
        this.eQC = view.findViewById(d.g.pb_list_item_top_line);
        this.eQD = (RelativeLayout) view.findViewById(d.g.pb_top_code);
        this.eQE = (TbImageView) view.findViewById(d.g.top_code_img);
        this.eQF = (TextView) view.findViewById(d.g.top_code_get_btn);
        this.eQG = (TextView) view.findViewById(d.g.top_code_detail_summary_text);
        this.eQH = (TextView) view.findViewById(d.g.top_code_detail_subtitle_text);
        this.eQI = (LinearLayout) view.findViewById(d.g.news_info);
        this.eQJ = (ImageView) view.findViewById(d.g.news_info_img);
        this.eQK = (TextView) view.findViewById(d.g.news_info_text);
        this.eQL = (LinearLayout) view.findViewById(d.g.game_info);
        this.eQM = (ImageView) view.findViewById(d.g.game_info_img);
        this.eQN = (TextView) view.findViewById(d.g.game_info_text);
        this.eQO = view.findViewById(d.g.pb_news_info_divider);
        setOnClickListener(this.byr);
    }

    public void a(aa aaVar) {
        if (aaVar != null) {
            this.eQP = aaVar.eQw;
            this.eQQ = aaVar.eQx;
            this.eQR = aaVar.eQy;
            if (this.eQP != null) {
                this.eQE.startLoad(this.eQP.Xx, 10, false);
                this.eQG.setText(this.eQP.summary);
                this.eQH.setText(this.eQP.subtitle);
                this.eQF.setText(this.eQP.buttonText);
                com.baidu.tbadk.core.util.aj.j(this.eQF, d.f.selector_star_btn_like);
                com.baidu.tbadk.core.util.aj.i(this.eQF, d.f.news_text_color_selector);
            } else {
                this.eQD.setVisibility(8);
            }
            if (this.eQQ != null) {
                this.eQK.setText(this.eQQ.summary);
                com.baidu.tbadk.core.util.aj.j(this.eQJ, d.f.icon_frs_news);
            } else {
                this.eQI.setVisibility(8);
                this.eQK.setVisibility(8);
                this.eQJ.setVisibility(8);
            }
            if (this.eQR != null) {
                this.eQN.setText(this.eQR.summary);
                com.baidu.tbadk.core.util.aj.j(this.eQM, d.f.icon_frs_game);
            } else {
                this.eQL.setVisibility(8);
                this.eQN.setVisibility(8);
                this.eQN.setVisibility(8);
            }
            this.eQB.setTag(aaVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.abI.getLayoutMode().ag(i == 1);
            this.abI.getLayoutMode().t(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.eQD.setOnClickListener(onClickListener);
        this.eQI.setOnClickListener(onClickListener);
        this.eQL.setOnClickListener(onClickListener);
    }
}

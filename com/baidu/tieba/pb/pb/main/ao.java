package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class ao extends af.a {
    View.OnClickListener aFf;
    private TbPageContext eCn;
    public LinearLayout ltA;
    public View ltB;
    public RelativeLayout ltC;
    public TbImageView ltD;
    public TextView ltE;
    public TextView ltF;
    public TextView ltG;
    public LinearLayout ltH;
    public ImageView ltI;
    public TextView ltJ;
    public LinearLayout ltK;
    public ImageView ltL;
    public TextView ltM;
    public View ltN;
    private com.baidu.tbadk.core.data.ay ltO;
    private com.baidu.tbadk.core.data.ay ltP;
    private com.baidu.tbadk.core.data.ay ltQ;
    private am ltR;
    private a ltS;
    private int mSkinType;

    /* loaded from: classes22.dex */
    public interface a {
        void b(am amVar);
    }

    public ao(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aFf = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bg.checkUpIsLogin(ao.this.eCn.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ao.this.ltS != null) {
                        ao.this.ltS.b(ao.this.ltR);
                    }
                    if (view2 == ao.this.ltC) {
                        if (ao.this.ltO != null && !TextUtils.isEmpty(ao.this.ltO.ewf)) {
                            com.baidu.tbadk.core.util.be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eCn.getPageActivity()), new String[]{ao.this.ltO.ewf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11410").dR("obj_source", ao.this.ltO.ewf));
                        }
                    } else if (view2 == ao.this.ltH) {
                        BdLog.e("link: " + ao.this.ltP.ewf);
                        if (ao.this.ltP != null && !TextUtils.isEmpty(ao.this.ltP.ewf)) {
                            com.baidu.tbadk.core.util.be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eCn.getPageActivity()), new String[]{ao.this.ltP.ewf});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11409").dR("obj_source", ao.this.ltP.ewf));
                        }
                    } else if (view2 == ao.this.ltK && ao.this.ltQ != null && !TextUtils.isEmpty(ao.this.ltQ.ewf)) {
                        com.baidu.tbadk.core.util.be.boR().b((TbPageContext) com.baidu.adp.base.i.I(ao.this.eCn.getPageActivity()), new String[]{ao.this.ltQ.ewf});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c11408").dR("obj_source", ao.this.ltQ.ewf));
                    }
                }
            }
        };
        this.eCn = tbPageContext;
        this.ltS = aVar;
        this.ltA = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.ltB = view.findViewById(R.id.pb_list_item_top_line);
        this.ltC = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.ltD = (TbImageView) view.findViewById(R.id.top_code_img);
        this.ltE = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.ltF = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.ltG = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.ltH = (LinearLayout) view.findViewById(R.id.news_info);
        this.ltI = (ImageView) view.findViewById(R.id.news_info_img);
        this.ltJ = (TextView) view.findViewById(R.id.news_info_text);
        this.ltK = (LinearLayout) view.findViewById(R.id.game_info);
        this.ltL = (ImageView) view.findViewById(R.id.game_info_img);
        this.ltM = (TextView) view.findViewById(R.id.game_info_text);
        this.ltN = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aFf);
    }

    public void a(am amVar) {
        if (amVar != null) {
            this.ltR = amVar;
            this.ltO = amVar.ltx;
            this.ltP = amVar.lty;
            this.ltQ = amVar.ltz;
            if (this.ltO != null) {
                this.ltD.startLoad(this.ltO.ewg, 10, false);
                this.ltF.setText(this.ltO.summary);
                this.ltG.setText(this.ltO.subtitle);
                this.ltE.setText(this.ltO.buttonText);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ltE, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.ap.setViewTextColor(this.ltE, R.drawable.news_text_color_selector);
            } else {
                this.ltC.setVisibility(8);
            }
            if (this.ltP != null) {
                this.ltJ.setText(this.ltP.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ltI, R.drawable.icon_frs_news);
            } else {
                this.ltH.setVisibility(8);
                this.ltJ.setVisibility(8);
                this.ltI.setVisibility(8);
            }
            if (this.ltQ != null) {
                this.ltM.setText(this.ltQ.summary);
                com.baidu.tbadk.core.util.ap.setBackgroundResource(this.ltL, R.drawable.icon_frs_game);
            } else {
                this.ltK.setVisibility(8);
                this.ltM.setVisibility(8);
                this.ltM.setVisibility(8);
            }
            this.ltA.setTag(amVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eCn.getLayoutMode().setNightMode(i == 1);
            this.eCn.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ltC.setOnClickListener(onClickListener);
        this.ltH.setOnClickListener(onClickListener);
        this.ltK.setOnClickListener(onClickListener);
    }
}

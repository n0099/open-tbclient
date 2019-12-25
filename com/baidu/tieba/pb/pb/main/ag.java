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
/* loaded from: classes6.dex */
public class ag extends v.a {
    View.OnClickListener aqZ;
    private TbPageContext cQU;
    private com.baidu.tbadk.core.data.as iHA;
    private com.baidu.tbadk.core.data.as iHB;
    private ae iHC;
    private a iHD;
    public LinearLayout iHl;
    public View iHm;
    public RelativeLayout iHn;
    public TbImageView iHo;
    public TextView iHp;
    public TextView iHq;
    public TextView iHr;
    public LinearLayout iHs;
    public ImageView iHt;
    public TextView iHu;
    public LinearLayout iHv;
    public ImageView iHw;
    public TextView iHx;
    public View iHy;
    private com.baidu.tbadk.core.data.as iHz;
    private int mSkinType;

    /* loaded from: classes6.dex */
    public interface a {
        void b(ae aeVar);
    }

    public ag(TbPageContext tbPageContext, View view, a aVar) {
        super(view);
        this.mSkinType = 3;
        this.aqZ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ag.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (bc.checkUpIsLogin(ag.this.cQU.getPageActivity()) && com.baidu.adp.lib.util.l.isNetOk()) {
                    if (ag.this.iHD != null) {
                        ag.this.iHD.b(ag.this.iHC);
                    }
                    if (view2 == ag.this.iHn) {
                        if (ag.this.iHz != null && !TextUtils.isEmpty(ag.this.iHz.cLE)) {
                            ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cQU.getPageActivity()), new String[]{ag.this.iHz.cLE});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11410").cp("obj_source", ag.this.iHz.cLE));
                        }
                    } else if (view2 == ag.this.iHs) {
                        BdLog.e("link: " + ag.this.iHA.cLE);
                        if (ag.this.iHA != null && !TextUtils.isEmpty(ag.this.iHA.cLE)) {
                            ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cQU.getPageActivity()), new String[]{ag.this.iHA.cLE});
                            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11409").cp("obj_source", ag.this.iHA.cLE));
                        }
                    } else if (view2 == ag.this.iHv && ag.this.iHB != null && !TextUtils.isEmpty(ag.this.iHB.cLE)) {
                        ba.aEa().b((TbPageContext) com.baidu.adp.base.i.ab(ag.this.cQU.getPageActivity()), new String[]{ag.this.iHB.cLE});
                        TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11408").cp("obj_source", ag.this.iHB.cLE));
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.iHD = aVar;
        this.iHl = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.iHm = view.findViewById(R.id.pb_list_item_top_line);
        this.iHn = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.iHo = (TbImageView) view.findViewById(R.id.top_code_img);
        this.iHp = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.iHq = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.iHr = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.iHs = (LinearLayout) view.findViewById(R.id.news_info);
        this.iHt = (ImageView) view.findViewById(R.id.news_info_img);
        this.iHu = (TextView) view.findViewById(R.id.news_info_text);
        this.iHv = (LinearLayout) view.findViewById(R.id.game_info);
        this.iHw = (ImageView) view.findViewById(R.id.game_info_img);
        this.iHx = (TextView) view.findViewById(R.id.game_info_text);
        this.iHy = view.findViewById(R.id.pb_news_info_divider);
        setOnClickListener(this.aqZ);
    }

    public void a(ae aeVar) {
        if (aeVar != null) {
            this.iHC = aeVar;
            this.iHz = aeVar.iHi;
            this.iHA = aeVar.iHj;
            this.iHB = aeVar.iHk;
            if (this.iHz != null) {
                this.iHo.startLoad(this.iHz.cLF, 10, false);
                this.iHq.setText(this.iHz.summary);
                this.iHr.setText(this.iHz.subtitle);
                this.iHp.setText(this.iHz.buttonText);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iHp, R.drawable.selector_star_btn_like);
                com.baidu.tbadk.core.util.am.setViewTextColor(this.iHp, (int) R.drawable.news_text_color_selector);
            } else {
                this.iHn.setVisibility(8);
            }
            if (this.iHA != null) {
                this.iHu.setText(this.iHA.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iHt, R.drawable.icon_frs_news);
            } else {
                this.iHs.setVisibility(8);
                this.iHu.setVisibility(8);
                this.iHt.setVisibility(8);
            }
            if (this.iHB != null) {
                this.iHx.setText(this.iHB.summary);
                com.baidu.tbadk.core.util.am.setBackgroundResource(this.iHw, R.drawable.icon_frs_game);
            } else {
                this.iHv.setVisibility(8);
                this.iHx.setVisibility(8);
                this.iHx.setVisibility(8);
            }
            this.iHl.setTag(aeVar);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.cQU.getLayoutMode().setNightMode(i == 1);
            this.cQU.getLayoutMode().onModeChanged(getView());
            this.mSkinType = i;
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.iHn.setOnClickListener(onClickListener);
        this.iHs.setOnClickListener(onClickListener);
        this.iHv.setOnClickListener(onClickListener);
    }
}
